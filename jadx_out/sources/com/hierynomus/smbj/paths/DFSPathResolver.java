package com.hierynomus.smbj.paths;

import com.hierynomus.msdfsc.DFSException;
import com.hierynomus.msdfsc.DFSPath;
import com.hierynomus.msdfsc.DomainCache;
import com.hierynomus.msdfsc.ReferralCache;
import com.hierynomus.msdfsc.messages.SMB2GetDFSReferralRequest;
import com.hierynomus.msdfsc.messages.SMB2GetDFSReferralResponse;
import com.hierynomus.mserref.NtStatus;
import com.hierynomus.mssmb2.SMB2Packet;
import com.hierynomus.mssmb2.SMBApiException;
import com.hierynomus.mssmb2.messages.SMB2IoctlResponse;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.protocol.commons.concurrent.Futures;
import com.hierynomus.protocol.transport.TransportException;
import com.hierynomus.smb.SMBBuffer;
import com.hierynomus.smbj.common.SmbPath;
import com.hierynomus.smbj.io.BufferByteChunkProvider;
import com.hierynomus.smbj.paths.PathResolver;
import com.hierynomus.smbj.session.Session;
import com.hierynomus.smbj.share.Share;
import com.hierynomus.smbj.share.StatusHandler;
import defpackage.e04;
import defpackage.ho1;
import defpackage.j02;
import defpackage.n02;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DFSPathResolver implements PathResolver {
    private static final long FSCTL_DFS_GET_REFERRALS = 393620;
    private static final long FSCTL_DFS_GET_REFERRALS_EX = 393648;
    private static final j02 logger = n02.k(DFSPathResolver.class);
    private final StatusHandler statusHandler;
    private long transactTimeout;
    private final PathResolver wrapped;
    private ReferralCache referralCache = new ReferralCache();
    private DomainCache domainCache = new DomainCache();

    /* JADX INFO: renamed from: com.hierynomus.smbj.paths.DFSPathResolver$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$hierynomus$smbj$paths$DFSPathResolver$DfsRequestType;

        static {
            int[] iArr = new int[DfsRequestType.values().length];
            $SwitchMap$com$hierynomus$smbj$paths$DFSPathResolver$DfsRequestType = iArr;
            try {
                iArr[DfsRequestType.DC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$hierynomus$smbj$paths$DFSPathResolver$DfsRequestType[DfsRequestType.DOMAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$hierynomus$smbj$paths$DFSPathResolver$DfsRequestType[DfsRequestType.SYSVOL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$hierynomus$smbj$paths$DFSPathResolver$DfsRequestType[DfsRequestType.ROOT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$hierynomus$smbj$paths$DFSPathResolver$DfsRequestType[DfsRequestType.LINK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum DfsRequestType {
        DOMAIN,
        DC,
        SYSVOL,
        ROOT,
        LINK
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class ResolveState<T> {
        final PathResolver.ResolveAction<T> action;
        DFSPath path;
        boolean resolvedDomainEntry = false;
        boolean isDFSPath = false;
        String hostName = null;

        public ResolveState(DFSPath dFSPath, PathResolver.ResolveAction<T> resolveAction) {
            this.path = dFSPath;
            this.action = resolveAction;
        }

        public String toString() {
            return "ResolveState{path=" + this.path + ", resolvedDomainEntry=" + this.resolvedDomainEntry + ", isDFSPath=" + this.isDFSPath + ", hostName='" + this.hostName + "'}";
        }
    }

    public DFSPathResolver(final PathResolver pathResolver, long j) {
        this.wrapped = pathResolver;
        this.transactTimeout = j;
        this.statusHandler = new StatusHandler() { // from class: com.hierynomus.smbj.paths.DFSPathResolver.1
            @Override // com.hierynomus.smbj.share.StatusHandler
            public boolean isSuccess(long j2) {
                return j2 == NtStatus.STATUS_PATH_NOT_COVERED.getValue() || pathResolver.statusHandler().isSuccess(j2);
            }
        };
    }

    private ReferralResult getReferral(DfsRequestType dfsRequestType, Share share, DFSPath dFSPath) {
        SMB2GetDFSReferralRequest sMB2GetDFSReferralRequest = new SMB2GetDFSReferralRequest(dFSPath.toPath());
        SMBBuffer sMBBuffer = new SMBBuffer();
        sMB2GetDFSReferralRequest.writeTo(sMBBuffer);
        return handleReferralResponse(dfsRequestType, (SMB2IoctlResponse) Futures.get(share.ioctlAsync(FSCTL_DFS_GET_REFERRALS, true, new BufferByteChunkProvider(sMBBuffer)), this.transactTimeout, TimeUnit.MILLISECONDS, TransportException.Wrapper), dFSPath);
    }

    private void handleDCReferralResponse(ReferralResult referralResult, SMB2GetDFSReferralResponse sMB2GetDFSReferralResponse) {
        if (sMB2GetDFSReferralResponse.getVersionNumber() < 3) {
            return;
        }
        DomainCache.DomainCacheEntry domainCacheEntry = new DomainCache.DomainCacheEntry(sMB2GetDFSReferralResponse);
        this.domainCache.put(domainCacheEntry);
        referralResult.domainCacheEntry = domainCacheEntry;
    }

    private ReferralResult handleReferralResponse(DfsRequestType dfsRequestType, SMB2IoctlResponse sMB2IoctlResponse, DFSPath dFSPath) {
        ReferralResult referralResult = new ReferralResult(sMB2IoctlResponse.getHeader().getStatusCode());
        if (referralResult.status == NtStatus.STATUS_SUCCESS.getValue()) {
            SMB2GetDFSReferralResponse sMB2GetDFSReferralResponse = new SMB2GetDFSReferralResponse(dFSPath.toPath());
            sMB2GetDFSReferralResponse.read(new SMBBuffer(sMB2IoctlResponse.getOutputBuffer()));
            int i = AnonymousClass3.$SwitchMap$com$hierynomus$smbj$paths$DFSPathResolver$DfsRequestType[dfsRequestType.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    throw new UnsupportedOperationException(DfsRequestType.DOMAIN + " not used yet.");
                }
                if (i == 3 || i == 4 || i == 5) {
                    handleRootOrLinkReferralResponse(referralResult, sMB2GetDFSReferralResponse);
                    return referralResult;
                }
                ho1.a("Encountered unhandled DFS RequestType: ", dfsRequestType);
                return null;
            }
            handleDCReferralResponse(referralResult, sMB2GetDFSReferralResponse);
        }
        return referralResult;
    }

    private void handleRootOrLinkReferralResponse(ReferralResult referralResult, SMB2GetDFSReferralResponse sMB2GetDFSReferralResponse) {
        if (sMB2GetDFSReferralResponse.getReferralEntries().isEmpty()) {
            referralResult.status = NtStatus.STATUS_OBJECT_PATH_NOT_FOUND.getValue();
            return;
        }
        ReferralCache.ReferralCacheEntry referralCacheEntry = new ReferralCache.ReferralCacheEntry(sMB2GetDFSReferralResponse, this.domainCache);
        logger.c("Got DFS Referral result: {}", referralCacheEntry);
        this.referralCache.put(referralCacheEntry);
        referralResult.referralCacheEntry = referralCacheEntry;
    }

    private ReferralResult sendDfsReferralRequest(DfsRequestType dfsRequestType, String str, Session session, DFSPath dFSPath) throws DFSException {
        if (!str.equals(session.getConnection().getRemoteHostname())) {
            try {
                session = session.getConnection().getClient().connect(str).authenticate(session.getAuthenticationContext());
            } catch (IOException e) {
                throw new DFSException(e);
            }
        }
        try {
            return getReferral(dfsRequestType, session.connectShare("IPC$"), dFSPath);
        } catch (Buffer.BufferException | IOException e2) {
            throw new DFSException(e2);
        }
    }

    private <T> T start(Session session, SmbPath smbPath, PathResolver.ResolveAction<T> resolveAction) {
        logger.c("Starting DFS resolution for {}", smbPath.toUncPath());
        return (T) step1(session, new ResolveState<>(new DFSPath(smbPath.toUncPath()), resolveAction));
    }

    private <T> T step1(Session session, ResolveState<T> resolveState) {
        logger.h("DFS[1]: {}", resolveState);
        return (resolveState.path.hasOnlyOnePathComponent() || resolveState.path.isIpc()) ? (T) step12(resolveState) : (T) step2(session, resolveState);
    }

    private <T> T step10(Session session, ResolveState<T> resolveState, DomainCache.DomainCacheEntry domainCacheEntry) throws DFSException {
        logger.h("DFS[10]: {}", resolveState);
        ReferralResult referralResultSendDfsReferralRequest = sendDfsReferralRequest(DfsRequestType.SYSVOL, domainCacheEntry.getDCHint(), session, resolveState.path);
        return NtStatus.isSuccess(referralResultSendDfsReferralRequest.status) ? (T) step3(session, resolveState, referralResultSendDfsReferralRequest.referralCacheEntry) : (T) step13(session, resolveState, referralResultSendDfsReferralRequest);
    }

    private <T> T step11(Session session, ResolveState<T> resolveState, ReferralCache.ReferralCacheEntry referralCacheEntry) {
        logger.h("DFS[11]: {}", resolveState);
        resolveState.path = resolveState.path.replacePrefix(referralCacheEntry.getDfsPathPrefix(), referralCacheEntry.getTargetHint().getTargetPath());
        resolveState.isDFSPath = true;
        return (T) step2(session, resolveState);
    }

    private <T> T step12(ResolveState<T> resolveState) {
        logger.h("DFS[12]: {}", resolveState);
        return resolveState.action.apply(SmbPath.parse(resolveState.path.toPath()));
    }

    private <T> T step13(Session session, ResolveState<T> resolveState, ReferralResult referralResult) throws DFSException {
        logger.h("DFS[13]: {}", resolveState);
        throw new DFSException(referralResult.status, "Cannot get DC for domain '" + resolveState.path.getPathComponents().get(0) + "'");
    }

    private <T> T step14(Session session, ResolveState<T> resolveState, ReferralResult referralResult) throws DFSException {
        logger.h("DFS[14]: {}", resolveState);
        throw new DFSException(referralResult.status, "DFS request failed for path " + resolveState.path);
    }

    private <T> T step2(Session session, ResolveState<T> resolveState) {
        logger.h("DFS[2]: {}", resolveState);
        ReferralCache.ReferralCacheEntry referralCacheEntryLookup = this.referralCache.lookup(resolveState.path);
        return (referralCacheEntryLookup == null || (referralCacheEntryLookup.isExpired() && referralCacheEntryLookup.isRoot())) ? (T) step5(session, resolveState) : referralCacheEntryLookup.isExpired() ? (T) step9(session, resolveState, referralCacheEntryLookup) : referralCacheEntryLookup.isLink() ? (T) step4(session, resolveState, referralCacheEntryLookup) : (T) step3(session, resolveState, referralCacheEntryLookup);
    }

    private <T> T step3(Session session, ResolveState<T> resolveState, ReferralCache.ReferralCacheEntry referralCacheEntry) {
        logger.h("DFS[3]: {}", resolveState);
        ReferralCache.TargetSetEntry targetHint = referralCacheEntry.getTargetHint();
        DFSPath dFSPath = resolveState.path;
        SMBApiException e = null;
        while (targetHint != null) {
            try {
                resolveState.path = resolveState.path.replacePrefix(referralCacheEntry.getDfsPathPrefix(), referralCacheEntry.getTargetHint().getTargetPath());
                resolveState.isDFSPath = true;
                return (T) this.step8(session, resolveState, referralCacheEntry);
            } catch (SMBApiException e2) {
                e = e2;
                if (e.getStatusCode() != NtStatus.STATUS_PATH_NOT_COVERED.getValue()) {
                    targetHint = referralCacheEntry.nextTargetHint();
                    resolveState.path = dFSPath;
                }
            }
        }
        if (e != null) {
            throw e;
        }
        e04.a("Unknown error resolving DFS");
        return null;
    }

    private <T> T step4(Session session, ResolveState<T> resolveState, ReferralCache.ReferralCacheEntry referralCacheEntry) {
        logger.h("DFS[4]: {}", resolveState);
        return resolveState.path.isSysVolOrNetLogon() ? (T) step3(session, resolveState, referralCacheEntry) : referralCacheEntry.isInterlink() ? (T) step11(session, resolveState, referralCacheEntry) : (T) step3(session, resolveState, referralCacheEntry);
    }

    private <T> T step5(Session session, ResolveState<T> resolveState) throws DFSException {
        logger.h("DFS[5]: {}", resolveState);
        String str = resolveState.path.getPathComponents().get(0);
        DomainCache.DomainCacheEntry domainCacheEntryLookup = this.domainCache.lookup(str);
        if (domainCacheEntryLookup == null) {
            resolveState.hostName = str;
            resolveState.resolvedDomainEntry = false;
            return (T) step6(session, resolveState);
        }
        if (domainCacheEntryLookup.getDCHint() == null || domainCacheEntryLookup.getDCHint().isEmpty()) {
            ReferralResult referralResultSendDfsReferralRequest = sendDfsReferralRequest(DfsRequestType.DC, session.getAuthenticationContext().getDomain(), session, resolveState.path);
            if (!NtStatus.isSuccess(referralResultSendDfsReferralRequest.status)) {
                return (T) step13(session, resolveState, referralResultSendDfsReferralRequest);
            }
            domainCacheEntryLookup = referralResultSendDfsReferralRequest.domainCacheEntry;
        }
        if (resolveState.path.isSysVolOrNetLogon()) {
            return (T) step10(session, resolveState, domainCacheEntryLookup);
        }
        resolveState.hostName = domainCacheEntryLookup.getDCHint();
        resolveState.resolvedDomainEntry = true;
        return (T) step6(session, resolveState);
    }

    private <T> T step6(Session session, ResolveState<T> resolveState) throws DFSException {
        logger.h("DFS[6]: {}", resolveState);
        ReferralResult referralResultSendDfsReferralRequest = sendDfsReferralRequest(DfsRequestType.ROOT, resolveState.path.getPathComponents().get(0), session, resolveState.path);
        return NtStatus.isSuccess(referralResultSendDfsReferralRequest.status) ? (T) step7(session, resolveState, referralResultSendDfsReferralRequest.referralCacheEntry) : resolveState.resolvedDomainEntry ? (T) step13(session, resolveState, referralResultSendDfsReferralRequest) : resolveState.isDFSPath ? (T) step14(session, resolveState, referralResultSendDfsReferralRequest) : (T) step12(resolveState);
    }

    private <T> T step7(Session session, ResolveState<T> resolveState, ReferralCache.ReferralCacheEntry referralCacheEntry) {
        logger.h("DFS[7]: {}", resolveState);
        return referralCacheEntry.isRoot() ? (T) step3(session, resolveState, referralCacheEntry) : (T) step4(session, resolveState, referralCacheEntry);
    }

    private <T> T step8(Session session, ResolveState<T> resolveState, ReferralCache.ReferralCacheEntry referralCacheEntry) {
        logger.h("DFS[8]: {}", resolveState);
        return resolveState.action.apply(SmbPath.parse(resolveState.path.toPath()));
    }

    private <T> T step9(Session session, ResolveState<T> resolveState, ReferralCache.ReferralCacheEntry referralCacheEntry) throws DFSException {
        j02 j02Var = logger;
        j02Var.h("DFS[9]: {}", resolveState);
        DFSPath dFSPath = new DFSPath(resolveState.path.getPathComponents().subList(0, 2));
        ReferralCache.ReferralCacheEntry referralCacheEntryLookup = this.referralCache.lookup(dFSPath);
        if (referralCacheEntryLookup == null) {
            j02Var.q("Could not find referral cache entry for {}", dFSPath);
            this.referralCache.clear(resolveState.path);
            return (T) step1(session, resolveState);
        }
        ReferralResult referralResultSendDfsReferralRequest = sendDfsReferralRequest(DfsRequestType.LINK, referralCacheEntryLookup.getTargetHint().getTargetPath().getPathComponents().get(0), session, resolveState.path);
        if (!NtStatus.isSuccess(referralResultSendDfsReferralRequest.status)) {
            return (T) step14(session, resolveState, referralResultSendDfsReferralRequest);
        }
        boolean zIsRoot = referralResultSendDfsReferralRequest.referralCacheEntry.isRoot();
        ReferralCache.ReferralCacheEntry referralCacheEntry2 = referralResultSendDfsReferralRequest.referralCacheEntry;
        return zIsRoot ? (T) step3(session, resolveState, referralCacheEntry2) : (T) step4(session, resolveState, referralCacheEntry2);
    }

    @Override // com.hierynomus.smbj.paths.PathResolver
    public <T> T resolve(Session session, SMB2Packet sMB2Packet, final SmbPath smbPath, final PathResolver.ResolveAction<T> resolveAction) {
        if (!session.getConnection().getConnectionContext().supportsDFS()) {
            return (T) this.wrapped.resolve(session, sMB2Packet, smbPath, resolveAction);
        }
        if (smbPath.getPath() != null && sMB2Packet.getHeader().getStatusCode() == NtStatus.STATUS_PATH_NOT_COVERED.getValue()) {
            logger.A("DFS Share {} does not cover {}, resolve through DFS", smbPath.getShareName(), smbPath);
            return (T) start(session, smbPath, new PathResolver.ResolveAction<T>() { // from class: com.hierynomus.smbj.paths.DFSPathResolver.2
                @Override // com.hierynomus.smbj.paths.PathResolver.ResolveAction
                public T apply(SmbPath smbPath2) {
                    DFSPathResolver.logger.A("DFS resolved {} -> {}", smbPath, smbPath2);
                    return (T) resolveAction.apply(smbPath2);
                }
            });
        }
        if (smbPath.getPath() != null || !NtStatus.isError(sMB2Packet.getHeader().getStatusCode())) {
            return (T) this.wrapped.resolve(session, sMB2Packet, smbPath, resolveAction);
        }
        logger.c("Attempting to resolve {} through DFS", smbPath);
        return (T) start(session, smbPath, resolveAction);
    }

    @Override // com.hierynomus.smbj.paths.PathResolver
    public StatusHandler statusHandler() {
        return this.statusHandler;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class ReferralResult {
        DomainCache.DomainCacheEntry domainCacheEntry;
        ReferralCache.ReferralCacheEntry referralCacheEntry;
        long status;

        private ReferralResult(long j) {
            this.status = j;
        }

        private ReferralResult(DomainCache.DomainCacheEntry domainCacheEntry) {
            this.domainCacheEntry = domainCacheEntry;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.hierynomus.smbj.paths.PathResolver
    public <T> T resolve(Session session, SmbPath smbPath, PathResolver.ResolveAction<T> resolveAction) {
        T t = (T) start(session, smbPath, resolveAction);
        if (!smbPath.equals(t)) {
            logger.A("DFS resolved {} -> {}", smbPath, t);
            return t;
        }
        return (T) this.wrapped.resolve(session, smbPath, resolveAction);
    }
}
