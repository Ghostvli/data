package org.jupnp.support.contentdirectory.callback;

import defpackage.j02;
import defpackage.n02;
import org.jupnp.controlpoint.ActionCallback;
import org.jupnp.model.action.ActionException;
import org.jupnp.model.action.ActionInvocation;
import org.jupnp.model.meta.Service;
import org.jupnp.model.types.ErrorCode;
import org.jupnp.model.types.UnsignedIntegerFourBytes;
import org.jupnp.support.contentdirectory.DIDLParser;
import org.jupnp.support.model.BrowseFlag;
import org.jupnp.support.model.BrowseResult;
import org.jupnp.support.model.DIDLContent;
import org.jupnp.support.model.SortCriterion;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Browse extends ActionCallback {
    public static final String CAPS_WILDCARD = "*";
    private static final int DEFAULT_MAX_RESULT = 999;
    private final j02 logger;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum Status {
        NO_CONTENT("No Content"),
        LOADING("Loading..."),
        OK("OK");

        private final String defaultMessage;

        Status(String str) {
            this.defaultMessage = str;
        }

        public String getDefaultMessage() {
            return this.defaultMessage;
        }
    }

    public Browse(Service<?, ?> service, String str, BrowseFlag browseFlag, String str2, long j, Long l, SortCriterion... sortCriterionArr) {
        super(new ActionInvocation(service.getAction("Browse")));
        j02 j02VarK = n02.k(Browse.class);
        this.logger = j02VarK;
        j02VarK.q("Creating browse action for object ID: {}", str);
        getActionInvocation().setInput("ObjectID", str);
        getActionInvocation().setInput("BrowseFlag", browseFlag.toString());
        getActionInvocation().setInput("Filter", str2);
        getActionInvocation().setInput("StartingIndex", new UnsignedIntegerFourBytes(j));
        getActionInvocation().setInput("RequestedCount", new UnsignedIntegerFourBytes(l == null ? getDefaultMaxResults() : l.longValue()));
        getActionInvocation().setInput("SortCriteria", SortCriterion.toString(sortCriterionArr));
    }

    public long getDefaultMaxResults() {
        return 999L;
    }

    public abstract void received(ActionInvocation<?> actionInvocation, DIDLContent dIDLContent);

    public boolean receivedRaw(ActionInvocation<?> actionInvocation, BrowseResult browseResult) {
        return true;
    }

    @Override // org.jupnp.controlpoint.ActionCallback, java.lang.Runnable
    public void run() {
        updateStatus(Status.LOADING);
        super.run();
    }

    @Override // org.jupnp.controlpoint.ActionCallback
    public void success(ActionInvocation actionInvocation) {
        this.logger.b("Successful browse action, reading output argument values");
        BrowseResult browseResult = new BrowseResult(actionInvocation.getOutput("Result").getValue().toString(), (UnsignedIntegerFourBytes) actionInvocation.getOutput("NumberReturned").getValue(), (UnsignedIntegerFourBytes) actionInvocation.getOutput("TotalMatches").getValue(), (UnsignedIntegerFourBytes) actionInvocation.getOutput("UpdateID").getValue());
        if (!receivedRaw(actionInvocation, browseResult) || browseResult.getCountLong() <= 0 || browseResult.getResult().isEmpty()) {
            received(actionInvocation, new DIDLContent());
            updateStatus(Status.NO_CONTENT);
            return;
        }
        try {
            received(actionInvocation, new DIDLParser().parse(browseResult.getResult()));
            updateStatus(Status.OK);
        } catch (Exception e) {
            actionInvocation.setFailure(new ActionException(ErrorCode.ACTION_FAILED, "Can't parse DIDL XML response: ".concat(String.valueOf(e)), e));
            failure(actionInvocation, null);
        }
    }

    public abstract void updateStatus(Status status);

    public Browse(Service<?, ?> service, String str, BrowseFlag browseFlag) {
        this(service, str, browseFlag, "*", 0L, null, new SortCriterion[0]);
    }
}
