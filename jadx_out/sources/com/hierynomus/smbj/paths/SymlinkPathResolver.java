package com.hierynomus.smbj.paths;

import com.hierynomus.mserref.NtStatus;
import com.hierynomus.mssmb2.SMB2Error;
import com.hierynomus.mssmb2.SMB2Functions;
import com.hierynomus.mssmb2.SMB2Packet;
import com.hierynomus.protocol.commons.Charsets;
import com.hierynomus.smbj.common.SmbPath;
import com.hierynomus.smbj.paths.PathResolver;
import com.hierynomus.smbj.session.Session;
import com.hierynomus.smbj.share.StatusHandler;
import com.hierynomus.utils.Strings;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SymlinkPathResolver implements PathResolver {
    private StatusHandler statusHandler;
    private PathResolver wrapped;

    public SymlinkPathResolver(final PathResolver pathResolver) {
        this.wrapped = pathResolver;
        this.statusHandler = new StatusHandler() { // from class: com.hierynomus.smbj.paths.SymlinkPathResolver.1
            @Override // com.hierynomus.smbj.share.StatusHandler
            public boolean isSuccess(long j) {
                return j == NtStatus.STATUS_STOPPED_ON_SYMLINK.getValue() || pathResolver.statusHandler().isSuccess(j);
            }
        };
    }

    private static SMB2Error.SymbolicLinkError getSymlinkErrorData(SMB2Error sMB2Error) {
        if (sMB2Error == null) {
            return null;
        }
        for (SMB2Error.SMB2ErrorData sMB2ErrorData : sMB2Error.getErrorData()) {
            if (sMB2ErrorData instanceof SMB2Error.SymbolicLinkError) {
                return (SMB2Error.SymbolicLinkError) sMB2ErrorData;
            }
        }
        return null;
    }

    private String getSymlinkParsedPath(String str, int i) {
        byte[] bArrUnicode = SMB2Functions.unicode(str);
        return new String(bArrUnicode, 0, bArrUnicode.length - i, Charsets.UTF_16LE);
    }

    private String getSymlinkUnparsedPath(String str, int i) {
        byte[] bArrUnicode = SMB2Functions.unicode(str);
        return new String(bArrUnicode, bArrUnicode.length - i, i, Charsets.UTF_16LE);
    }

    private String normalizePath(String str) {
        List<String> listSplit = Strings.split(str, '\\');
        int i = 0;
        while (i < listSplit.size()) {
            String str2 = listSplit.get(i);
            if (".".equals(str2)) {
                listSplit.remove(i);
            } else if ("..".equals(str2)) {
                if (i > 0) {
                    listSplit.remove(i);
                    i--;
                }
                listSplit.remove(i);
            } else {
                i++;
            }
        }
        return Strings.join(listSplit, '\\');
    }

    private String resolveSymlinkTarget(String str, SMB2Error.SymbolicLinkError symbolicLinkError) {
        String string;
        int unparsedPathLength = symbolicLinkError.getUnparsedPathLength();
        String symlinkUnparsedPath = getSymlinkUnparsedPath(str, unparsedPathLength);
        String substituteName = symbolicLinkError.getSubstituteName();
        if (symbolicLinkError.isAbsolute()) {
            string = substituteName + symlinkUnparsedPath;
        } else {
            String symlinkParsedPath = getSymlinkParsedPath(str, unparsedPathLength);
            StringBuilder sb = new StringBuilder();
            int iLastIndexOf = symlinkParsedPath.lastIndexOf("\\");
            if (iLastIndexOf != -1) {
                sb.append((CharSequence) symlinkParsedPath, 0, iLastIndexOf);
                sb.append('\\');
            }
            sb.append(substituteName);
            sb.append(symlinkUnparsedPath);
            string = sb.toString();
        }
        return normalizePath(string);
    }

    @Override // com.hierynomus.smbj.paths.PathResolver
    public <T> T resolve(Session session, SMB2Packet sMB2Packet, SmbPath smbPath, PathResolver.ResolveAction<T> resolveAction) throws PathResolveException {
        if (sMB2Packet.getHeader().getStatusCode() != NtStatus.STATUS_STOPPED_ON_SYMLINK.getValue()) {
            return (T) this.wrapped.resolve(session, sMB2Packet, smbPath, resolveAction);
        }
        SMB2Error.SymbolicLinkError symlinkErrorData = getSymlinkErrorData(sMB2Packet.getError());
        if (symlinkErrorData != null) {
            return resolveAction.apply(new SmbPath(smbPath.getHostname(), smbPath.getShareName(), resolveSymlinkTarget(smbPath.getPath(), symlinkErrorData)));
        }
        throw new PathResolveException(sMB2Packet.getHeader().getStatusCode(), "Create failed for " + smbPath + ": missing symlink data");
    }

    @Override // com.hierynomus.smbj.paths.PathResolver
    public StatusHandler statusHandler() {
        return this.statusHandler;
    }

    @Override // com.hierynomus.smbj.paths.PathResolver
    public <T> T resolve(Session session, SmbPath smbPath, PathResolver.ResolveAction<T> resolveAction) {
        return (T) this.wrapped.resolve(session, smbPath, resolveAction);
    }
}
