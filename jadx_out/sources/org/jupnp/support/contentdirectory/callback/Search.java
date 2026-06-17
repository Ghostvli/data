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
import org.jupnp.support.model.DIDLContent;
import org.jupnp.support.model.SearchResult;
import org.jupnp.support.model.SortCriterion;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Search extends ActionCallback {
    public static final String CAPS_WILDCARD = "*";
    private static final long DEFAULT_MAX_RESULTS = 999;
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

    public Search(Service<?, ?> service, String str, String str2, String str3, long j, Long l, SortCriterion... sortCriterionArr) {
        super(new ActionInvocation(service.getAction("Search")));
        j02 j02VarK = n02.k(Search.class);
        this.logger = j02VarK;
        j02VarK.q("Creating browse action for container ID: {}", str);
        getActionInvocation().setInput("ContainerID", str);
        getActionInvocation().setInput("SearchCriteria", str2);
        getActionInvocation().setInput("Filter", str3);
        getActionInvocation().setInput("StartingIndex", new UnsignedIntegerFourBytes(j));
        getActionInvocation().setInput("RequestedCount", new UnsignedIntegerFourBytes((l == null ? getDefaultMaxResults() : l).longValue()));
        getActionInvocation().setInput("SortCriteria", SortCriterion.toString(sortCriterionArr));
    }

    public Long getDefaultMaxResults() {
        return Long.valueOf(DEFAULT_MAX_RESULTS);
    }

    public abstract void received(ActionInvocation<?> actionInvocation, DIDLContent dIDLContent);

    public boolean receivedRaw(ActionInvocation<?> actionInvocation, SearchResult searchResult) {
        return true;
    }

    @Override // org.jupnp.controlpoint.ActionCallback, java.lang.Runnable
    public void run() {
        updateStatus(Status.LOADING);
        super.run();
    }

    @Override // org.jupnp.controlpoint.ActionCallback
    public void success(ActionInvocation actionInvocation) {
        this.logger.b("Successful search action, reading output argument values");
        SearchResult searchResult = new SearchResult(actionInvocation.getOutput("Result").getValue().toString(), (UnsignedIntegerFourBytes) actionInvocation.getOutput("NumberReturned").getValue(), (UnsignedIntegerFourBytes) actionInvocation.getOutput("TotalMatches").getValue(), (UnsignedIntegerFourBytes) actionInvocation.getOutput("UpdateID").getValue());
        if (!receivedRaw(actionInvocation, searchResult) || searchResult.getCountLong() <= 0 || searchResult.getResult().isEmpty()) {
            received(actionInvocation, new DIDLContent());
            updateStatus(Status.NO_CONTENT);
            return;
        }
        try {
            received(actionInvocation, new DIDLParser().parse(searchResult.getResult()));
            updateStatus(Status.OK);
        } catch (Exception e) {
            actionInvocation.setFailure(new ActionException(ErrorCode.ACTION_FAILED, "Can't parse DIDL XML response: ".concat(String.valueOf(e)), e));
            failure(actionInvocation, null);
        }
    }

    public abstract void updateStatus(Status status);

    public Search(Service<?, ?> service, String str, String str2) {
        this(service, str, str2, "*", 0L, null, new SortCriterion[0]);
    }
}
