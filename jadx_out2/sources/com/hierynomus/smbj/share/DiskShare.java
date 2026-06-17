package com.hierynomus.smbj.share;

import com.hierynomus.msdtyp.AccessMask;
import com.hierynomus.msdtyp.SecurityDescriptor;
import com.hierynomus.msdtyp.SecurityInformation;
import com.hierynomus.mserref.NtStatus;
import com.hierynomus.msfscc.FileAttributes;
import com.hierynomus.msfscc.FileSystemInformationClass;
import com.hierynomus.msfscc.fileinformation.FileAllInformation;
import com.hierynomus.msfscc.fileinformation.FileDirectoryQueryableInformation;
import com.hierynomus.msfscc.fileinformation.FileDispositionInformation;
import com.hierynomus.msfscc.fileinformation.FileIdBothDirectoryInformation;
import com.hierynomus.msfscc.fileinformation.FileInformation;
import com.hierynomus.msfscc.fileinformation.FileInformationFactory;
import com.hierynomus.msfscc.fileinformation.FileQueryableInformation;
import com.hierynomus.msfscc.fileinformation.FileSettableInformation;
import com.hierynomus.msfscc.fileinformation.ShareInfo;
import com.hierynomus.msfscc.fileinformation.VolumeInfo;
import com.hierynomus.mssmb2.SMB2CreateDisposition;
import com.hierynomus.mssmb2.SMB2CreateOptions;
import com.hierynomus.mssmb2.SMB2FileId;
import com.hierynomus.mssmb2.SMB2ImpersonationLevel;
import com.hierynomus.mssmb2.SMB2MessageCommandCode;
import com.hierynomus.mssmb2.SMB2ShareAccess;
import com.hierynomus.mssmb2.SMBApiException;
import com.hierynomus.mssmb2.messages.SMB2CreateResponse;
import com.hierynomus.mssmb2.messages.SMB2QueryInfoRequest;
import com.hierynomus.mssmb2.messages.SMB2SetInfoRequest;
import com.hierynomus.protocol.commons.EnumWithValue;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.protocol.commons.buffer.Endian;
import com.hierynomus.smb.SMBBuffer;
import com.hierynomus.smbj.common.SMBRuntimeException;
import com.hierynomus.smbj.common.SmbPath;
import com.hierynomus.smbj.paths.PathResolveException;
import com.hierynomus.smbj.paths.PathResolver;
import com.hierynomus.smbj.session.Session;
import defpackage.jl;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DiskShare extends Share {
    private final PathResolver resolver;
    private static final StatusHandler FILE_EXISTS_STATUS_HANDLER = new StatusHandler() { // from class: com.hierynomus.smbj.share.DiskShare.3
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.smbj.share.StatusHandler
        public boolean isSuccess(long j) {
            return j == NtStatus.STATUS_OBJECT_NAME_NOT_FOUND.getValue() || j == NtStatus.STATUS_OBJECT_PATH_NOT_FOUND.getValue() || j == NtStatus.STATUS_FILE_IS_A_DIRECTORY.getValue() || j == NtStatus.STATUS_DELETE_PENDING.getValue();
        }
    };
    private static final StatusHandler FOLDER_EXISTS_STATUS_HANDLER = new StatusHandler() { // from class: com.hierynomus.smbj.share.DiskShare.4
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.smbj.share.StatusHandler
        public boolean isSuccess(long j) {
            return j == NtStatus.STATUS_OBJECT_NAME_NOT_FOUND.getValue() || j == NtStatus.STATUS_OBJECT_PATH_NOT_FOUND.getValue() || j == NtStatus.STATUS_NOT_A_DIRECTORY.getValue() || j == NtStatus.STATUS_DELETE_PENDING.getValue();
        }
    };
    private static StatusHandler ALREADY_DELETED_STATUS_HANDLER = new StatusHandler() { // from class: com.hierynomus.smbj.share.DiskShare.5
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.smbj.share.StatusHandler
        public boolean isSuccess(long j) {
            return j == NtStatus.STATUS_DELETE_PENDING.getValue();
        }
    };

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class SMB2CreateResponseContext {
        final SMB2CreateResponse resp;
        final DiskShare share;
        final SmbPath target;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public SMB2CreateResponseContext(SMB2CreateResponse sMB2CreateResponse, SmbPath smbPath, DiskShare diskShare) {
            this.resp = sMB2CreateResponse;
            this.target = smbPath;
            this.share = diskShare;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DiskShare(SmbPath smbPath, TreeConnect treeConnect, PathResolver pathResolver) {
        super(smbPath, treeConnect);
        this.resolver = pathResolver;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public SMB2CreateResponseContext createFileAndResolve(final SmbPath smbPath, final SMB2ImpersonationLevel sMB2ImpersonationLevel, final Set<AccessMask> set, final Set<FileAttributes> set2, final Set<SMB2ShareAccess> set3, final SMB2CreateDisposition sMB2CreateDisposition, final Set<SMB2CreateOptions> set4) {
        SMB2CreateResponse sMB2CreateResponseCreateFile = super.createFile(smbPath, sMB2ImpersonationLevel, set, set2, set3, sMB2CreateDisposition, set4);
        try {
            SMB2CreateResponseContext sMB2CreateResponseContext = (SMB2CreateResponseContext) this.resolver.resolve(this.session, sMB2CreateResponseCreateFile, smbPath, new PathResolver.ResolveAction<SMB2CreateResponseContext>() { // from class: com.hierynomus.smbj.share.DiskShare.1
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                /* JADX DEBUG: Method merged with bridge method: apply(Lcom/hierynomus/smbj/common/SmbPath;)Ljava/lang/Object; */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.hierynomus.smbj.paths.PathResolver.ResolveAction
                public SMB2CreateResponseContext apply(SmbPath smbPath2) {
                    DiskShare diskShareRerouteIfNeeded = DiskShare.this.rerouteIfNeeded(smbPath, smbPath2);
                    if (smbPath.equals(smbPath2)) {
                        return null;
                    }
                    return diskShareRerouteIfNeeded.createFileAndResolve(smbPath2, sMB2ImpersonationLevel, set, set2, set3, sMB2CreateDisposition, set4);
                }
            });
            return sMB2CreateResponseContext != null ? sMB2CreateResponseContext : new SMB2CreateResponseContext(sMB2CreateResponseCreateFile, smbPath, this);
        } catch (PathResolveException e) {
            throw new SMBApiException(e.getStatusCode(), SMB2MessageCommandCode.SMB2_CREATE, "Cannot resolve path " + smbPath, e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean exists(String str, EnumSet<SMB2CreateOptions> enumSet, StatusHandler statusHandler) {
        try {
            DiskEntry diskEntryOpen = open(str, EnumSet.of(AccessMask.FILE_READ_ATTRIBUTES), EnumSet.of(FileAttributes.FILE_ATTRIBUTE_NORMAL), SMB2ShareAccess.ALL, SMB2CreateDisposition.FILE_OPEN, enumSet);
            if (diskEntryOpen == null) {
                return true;
            }
            diskEntryOpen.close();
            return true;
        } catch (SMBApiException e) {
            if (statusHandler.isSuccess(e.getStatusCode())) {
                return false;
            }
            throw e;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public DiskShare rerouteIfNeeded(SmbPath smbPath, SmbPath smbPath2) {
        Session nestedSession = this.session;
        if (!smbPath.isOnSameHost(smbPath2)) {
            nestedSession = nestedSession.getNestedSession(smbPath2);
        }
        return !smbPath.isOnSameShare(smbPath2) ? (DiskShare) nestedSession.connectShare(smbPath2.getShareName()) : this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private SMB2CreateResponseContext resolveAndCreateFile(final SmbPath smbPath, final SMB2ImpersonationLevel sMB2ImpersonationLevel, final Set<AccessMask> set, final Set<FileAttributes> set2, final Set<SMB2ShareAccess> set3, final SMB2CreateDisposition sMB2CreateDisposition, final Set<SMB2CreateOptions> set4) {
        try {
            return (SMB2CreateResponseContext) this.resolver.resolve(this.session, smbPath, new PathResolver.ResolveAction<SMB2CreateResponseContext>() { // from class: com.hierynomus.smbj.share.DiskShare.2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                /* JADX DEBUG: Method merged with bridge method: apply(Lcom/hierynomus/smbj/common/SmbPath;)Ljava/lang/Object; */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.hierynomus.smbj.paths.PathResolver.ResolveAction
                public SMB2CreateResponseContext apply(SmbPath smbPath2) {
                    return DiskShare.this.rerouteIfNeeded(smbPath, smbPath2).createFileAndResolve(smbPath2, sMB2ImpersonationLevel, set, set2, set3, sMB2CreateDisposition, set4);
                }
            });
        } catch (PathResolveException e) {
            throw new SMBApiException(e.getStatus().getValue(), SMB2MessageCommandCode.SMB2_CREATE, "Cannot resolve path " + smbPath, e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void deleteOnClose(SMB2FileId sMB2FileId) {
        setFileInformation(sMB2FileId, new FileDispositionInformation(true));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean fileExists(String str) {
        return exists(str, EnumSet.of(SMB2CreateOptions.FILE_NON_DIRECTORY_FILE), FILE_EXISTS_STATUS_HANDLER);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean folderExists(String str) {
        return exists(str, EnumSet.of(SMB2CreateOptions.FILE_DIRECTORY_FILE), FOLDER_EXISTS_STATUS_HANDLER);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smbj.share.Share
    public StatusHandler getCreateStatusHandler() {
        return this.resolver.statusHandler();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DiskEntry getDiskEntry(SMB2CreateResponseContext sMB2CreateResponseContext) {
        SMB2CreateResponse sMB2CreateResponse = sMB2CreateResponseContext.resp;
        return sMB2CreateResponse.getFileAttributes().contains(FileAttributes.FILE_ATTRIBUTE_DIRECTORY) ? new Directory(sMB2CreateResponse.getFileId(), sMB2CreateResponseContext.share, sMB2CreateResponseContext.target) : new File(sMB2CreateResponse.getFileId(), sMB2CreateResponseContext.share, sMB2CreateResponseContext.target);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public <F extends FileQueryableInformation> F getFileInformation(SMB2FileId sMB2FileId, Class<F> cls) {
        FileInformation.Decoder decoder = FileInformationFactory.getDecoder(cls);
        try {
            return (F) decoder.read(new Buffer.PlainBuffer(queryInfo(sMB2FileId, SMB2QueryInfoRequest.SMB2QueryInfoType.SMB2_0_INFO_FILE, null, decoder.getInformationClass(), null).getOutputBuffer(), Endian.LE));
        } catch (Buffer.BufferException e) {
            throw new SMBRuntimeException(e);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, MOVE_EXCEPTION, THROW, INVOKE, MOVE_EXCEPTION, THROW, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
    public SecurityDescriptor getSecurityInfo(String str, Set<SecurityInformation> set) {
        EnumSet enumSetOf = EnumSet.of(AccessMask.READ_CONTROL);
        if (set.contains(SecurityInformation.SACL_SECURITY_INFORMATION)) {
            enumSetOf.add(AccessMask.ACCESS_SYSTEM_SECURITY);
        }
        DiskEntry diskEntryOpen = open(str, enumSetOf, null, SMB2ShareAccess.ALL, SMB2CreateDisposition.FILE_OPEN, null);
        try {
            SecurityDescriptor securityInformation = diskEntryOpen.getSecurityInformation(set);
            diskEntryOpen.close();
            return securityInformation;
        } finally {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
    public ShareInfo getShareInformation() {
        Directory directoryOpenDirectory = openDirectory("", EnumSet.of(AccessMask.FILE_READ_ATTRIBUTES), null, SMB2ShareAccess.ALL, SMB2CreateDisposition.FILE_OPEN, null);
        try {
            try {
                ShareInfo fsFullSizeInformation = ShareInfo.parseFsFullSizeInformation(new Buffer.PlainBuffer(queryInfo(directoryOpenDirectory.getFileId(), SMB2QueryInfoRequest.SMB2QueryInfoType.SMB2_0_INFO_FILESYSTEM, null, null, FileSystemInformationClass.FileFsFullSizeInformation).getOutputBuffer(), Endian.LE));
                directoryOpenDirectory.close();
                return fsFullSizeInformation;
            } catch (Buffer.BufferException e) {
                throw new SMBRuntimeException(e);
            }
        } finally {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
    public VolumeInfo getVolumeInfo() {
        Directory directoryOpenDirectory = openDirectory("", EnumSet.of(AccessMask.FILE_READ_ATTRIBUTES), null, SMB2ShareAccess.ALL, SMB2CreateDisposition.FILE_OPEN, null);
        try {
            try {
                VolumeInfo fileFsVolumeInformation = VolumeInfo.parseFileFsVolumeInformation(new Buffer.PlainBuffer(queryInfo(directoryOpenDirectory.getFileId(), SMB2QueryInfoRequest.SMB2QueryInfoType.SMB2_0_INFO_FILESYSTEM, null, null, FileSystemInformationClass.FileFsVolumeInformation).getOutputBuffer(), Endian.LE));
                directoryOpenDirectory.close();
                return fileFsVolumeInformation;
            } catch (Buffer.BufferException e) {
                throw new SMBRuntimeException(e);
            }
        } finally {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public <I extends FileDirectoryQueryableInformation> List<I> list(String str, Class<I> cls, String str2, EnumSet<AccessMask> enumSet) {
        if (enumSet == null) {
            enumSet = EnumSet.of(AccessMask.FILE_LIST_DIRECTORY, AccessMask.FILE_READ_ATTRIBUTES, AccessMask.FILE_READ_EA);
        }
        Directory directoryOpenDirectory = openDirectory(str, enumSet, null, SMB2ShareAccess.ALL, SMB2CreateDisposition.FILE_OPEN, null);
        try {
            List<I> list = directoryOpenDirectory.list(cls, str2);
            directoryOpenDirectory.closeSilently();
            return list;
        } finally {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void mkdir(String str) {
        openDirectory(str, EnumSet.of(AccessMask.FILE_LIST_DIRECTORY, AccessMask.FILE_ADD_SUBDIRECTORY), EnumSet.of(FileAttributes.FILE_ATTRIBUTE_DIRECTORY), SMB2ShareAccess.ALL, SMB2CreateDisposition.FILE_CREATE, EnumSet.of(SMB2CreateOptions.FILE_DIRECTORY_FILE)).close();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DiskEntry open(String str, Set<AccessMask> set, Set<FileAttributes> set2, Set<SMB2ShareAccess> set3, SMB2CreateDisposition sMB2CreateDisposition, Set<SMB2CreateOptions> set4) {
        return getDiskEntry(resolveAndCreateFile(new SmbPath(this.smbPath, str), null, set, set2, set3, sMB2CreateDisposition, set4));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Directory openDirectory(String str, Set<AccessMask> set, Set<FileAttributes> set2, Set<SMB2ShareAccess> set3, SMB2CreateDisposition sMB2CreateDisposition, Set<SMB2CreateOptions> set4) {
        EnumSet enumSetCopyOf = set4 != null ? EnumSet.copyOf((Collection) set4) : EnumSet.noneOf(SMB2CreateOptions.class);
        enumSetCopyOf.add(SMB2CreateOptions.FILE_DIRECTORY_FILE);
        enumSetCopyOf.remove(SMB2CreateOptions.FILE_NON_DIRECTORY_FILE);
        EnumSet enumSetCopyOf2 = set2 != null ? EnumSet.copyOf((Collection) set2) : EnumSet.noneOf(FileAttributes.class);
        enumSetCopyOf2.add(FileAttributes.FILE_ATTRIBUTE_DIRECTORY);
        return (Directory) open(str, set, enumSetCopyOf2, set3, sMB2CreateDisposition, enumSetCopyOf);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public File openFile(String str, Set<AccessMask> set, Set<FileAttributes> set2, Set<SMB2ShareAccess> set3, SMB2CreateDisposition sMB2CreateDisposition, Set<SMB2CreateOptions> set4) {
        EnumSet enumSetCopyOf = set4 != null ? EnumSet.copyOf((Collection) set4) : EnumSet.noneOf(SMB2CreateOptions.class);
        enumSetCopyOf.add(SMB2CreateOptions.FILE_NON_DIRECTORY_FILE);
        enumSetCopyOf.remove(SMB2CreateOptions.FILE_DIRECTORY_FILE);
        EnumSet enumSetCopyOf2 = set2 != null ? EnumSet.copyOf((Collection) set2) : EnumSet.noneOf(FileAttributes.class);
        enumSetCopyOf2.remove(FileAttributes.FILE_ATTRIBUTE_DIRECTORY);
        return (File) open(str, set, enumSetCopyOf2, set3, sMB2CreateDisposition, enumSetCopyOf);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, MOVE_EXCEPTION, THROW, INVOKE, MOVE_EXCEPTION, THROW, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
    public void rm(String str) {
        try {
            DiskEntry diskEntryOpen = open(str, EnumSet.of(AccessMask.DELETE), EnumSet.of(FileAttributes.FILE_ATTRIBUTE_NORMAL), EnumSet.of(SMB2ShareAccess.FILE_SHARE_DELETE, SMB2ShareAccess.FILE_SHARE_WRITE, SMB2ShareAccess.FILE_SHARE_READ), SMB2CreateDisposition.FILE_OPEN, EnumSet.of(SMB2CreateOptions.FILE_NON_DIRECTORY_FILE));
            try {
                diskEntryOpen.deleteOnClose();
                diskEntryOpen.close();
            } finally {
            }
        } catch (SMBApiException e) {
            if (!ALREADY_DELETED_STATUS_HANDLER.isSuccess(e.getStatusCode())) {
                throw e;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, MOVE_EXCEPTION, THROW, INVOKE, MOVE_EXCEPTION, THROW, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
    public void rmdir(String str, boolean z) {
        if (str == null || str.isEmpty()) {
            jl.a("rmdir: path should be non-null and non-empty");
            return;
        }
        if (z) {
            for (FileIdBothDirectoryInformation fileIdBothDirectoryInformation : list(str)) {
                if (!fileIdBothDirectoryInformation.getFileName().equals(".") && !fileIdBothDirectoryInformation.getFileName().equals("..")) {
                    String str2 = str + "\\" + fileIdBothDirectoryInformation.getFileName();
                    if (EnumWithValue.EnumUtils.isSet(fileIdBothDirectoryInformation.getFileAttributes(), FileAttributes.FILE_ATTRIBUTE_DIRECTORY)) {
                        rmdir(str2, true);
                    } else {
                        rm(str2);
                    }
                }
            }
            rmdir(str, false);
            return;
        }
        try {
            DiskEntry diskEntryOpen = open(str, EnumSet.of(AccessMask.DELETE), EnumSet.of(FileAttributes.FILE_ATTRIBUTE_DIRECTORY), EnumSet.of(SMB2ShareAccess.FILE_SHARE_DELETE, SMB2ShareAccess.FILE_SHARE_WRITE, SMB2ShareAccess.FILE_SHARE_READ), SMB2CreateDisposition.FILE_OPEN, EnumSet.of(SMB2CreateOptions.FILE_DIRECTORY_FILE));
            try {
                diskEntryOpen.deleteOnClose();
                diskEntryOpen.close();
            } finally {
            }
        } catch (SMBApiException e) {
            if (!ALREADY_DELETED_STATUS_HANDLER.isSuccess(e.getStatusCode())) {
                throw e;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
    public <F extends FileSettableInformation> void setFileInformation(String str, F f) {
        DiskEntry diskEntryOpen = open(str, EnumSet.of(AccessMask.FILE_WRITE_ATTRIBUTES, AccessMask.FILE_WRITE_EA), null, SMB2ShareAccess.ALL, SMB2CreateDisposition.FILE_OPEN, null);
        try {
            diskEntryOpen.setFileInformation(f);
            diskEntryOpen.close();
        } catch (Throwable th) {
            if (diskEntryOpen == null) {
                throw th;
            }
            try {
                diskEntryOpen.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, MOVE_EXCEPTION, THROW, INVOKE, MOVE_EXCEPTION, THROW, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
    public void setSecurityInfo(String str, Set<SecurityInformation> set, SecurityDescriptor securityDescriptor) {
        EnumSet enumSetNoneOf = EnumSet.noneOf(AccessMask.class);
        if (set.contains(SecurityInformation.SACL_SECURITY_INFORMATION)) {
            enumSetNoneOf.add(AccessMask.ACCESS_SYSTEM_SECURITY);
        }
        if (set.contains(SecurityInformation.OWNER_SECURITY_INFORMATION) || set.contains(SecurityInformation.GROUP_SECURITY_INFORMATION)) {
            enumSetNoneOf.add(AccessMask.WRITE_OWNER);
        }
        if (set.contains(SecurityInformation.DACL_SECURITY_INFORMATION)) {
            enumSetNoneOf.add(AccessMask.WRITE_DAC);
        }
        DiskEntry diskEntryOpen = open(str, enumSetNoneOf, null, SMB2ShareAccess.ALL, SMB2CreateDisposition.FILE_OPEN, null);
        try {
            diskEntryOpen.setSecurityInformation(securityDescriptor, set);
            diskEntryOpen.close();
        } finally {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return getClass().getSimpleName() + "[" + getSmbPath() + "]";
    }

    public List<FileIdBothDirectoryInformation> list(String str, String str2) {
        return list(str, FileIdBothDirectoryInformation.class, str2, null);
    }

    public <F extends FileSettableInformation> void setFileInformation(SMB2FileId sMB2FileId, F f) {
        SMBBuffer sMBBuffer = new SMBBuffer();
        FileInformation.Encoder encoder = FileInformationFactory.getEncoder(f);
        encoder.write(f, sMBBuffer);
        setInfo(sMB2FileId, SMB2SetInfoRequest.SMB2InfoType.SMB2_0_INFO_FILE, null, encoder.getInformationClass(), sMBBuffer.getCompactData());
    }

    public <I extends FileDirectoryQueryableInformation> List<I> list(String str, Class<I> cls) {
        return list(str, cls, null, null);
    }

    public List<FileIdBothDirectoryInformation> list(String str) {
        return list(str, FileIdBothDirectoryInformation.class, null, null);
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
    public <F extends FileQueryableInformation> F getFileInformation(String str, Class<F> cls) {
        DiskEntry diskEntryOpen = open(str, EnumSet.of(AccessMask.FILE_READ_ATTRIBUTES, AccessMask.FILE_READ_EA), null, SMB2ShareAccess.ALL, SMB2CreateDisposition.FILE_OPEN, null);
        try {
            F f = (F) diskEntryOpen.getFileInformation(cls);
            diskEntryOpen.close();
            return f;
        } catch (Throwable th) {
            if (diskEntryOpen == null) {
                throw th;
            }
            try {
                diskEntryOpen.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    public FileAllInformation getFileInformation(SMB2FileId sMB2FileId) {
        return (FileAllInformation) getFileInformation(sMB2FileId, FileAllInformation.class);
    }

    public FileAllInformation getFileInformation(String str) {
        return (FileAllInformation) getFileInformation(str, FileAllInformation.class);
    }

    public SecurityDescriptor getSecurityInfo(SMB2FileId sMB2FileId, Set<SecurityInformation> set) {
        try {
            return SecurityDescriptor.read(new SMBBuffer(queryInfo(sMB2FileId, SMB2QueryInfoRequest.SMB2QueryInfoType.SMB2_0_INFO_SECURITY, set, null, null).getOutputBuffer()));
        } catch (Buffer.BufferException e) {
            throw new SMBRuntimeException(e);
        }
    }

    public void setSecurityInfo(SMB2FileId sMB2FileId, Set<SecurityInformation> set, SecurityDescriptor securityDescriptor) {
        SMBBuffer sMBBuffer = new SMBBuffer();
        securityDescriptor.write(sMBBuffer);
        setInfo(sMB2FileId, SMB2SetInfoRequest.SMB2InfoType.SMB2_0_INFO_SECURITY, set, null, sMBBuffer.getCompactData());
    }
}
