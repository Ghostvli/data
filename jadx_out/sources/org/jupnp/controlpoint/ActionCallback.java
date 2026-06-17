package org.jupnp.controlpoint;

import defpackage.e04;
import org.jupnp.model.action.ActionException;
import org.jupnp.model.action.ActionInvocation;
import org.jupnp.model.message.UpnpResponse;
import org.jupnp.model.message.control.IncomingActionResponseMessage;
import org.jupnp.model.meta.LocalService;
import org.jupnp.model.meta.RemoteService;
import org.jupnp.model.meta.Service;
import org.jupnp.protocol.sync.SendingAction;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ActionCallback implements Runnable {
    protected final ActionInvocation actionInvocation;
    protected ControlPoint controlPoint;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Default extends ActionCallback {
        public Default(ActionInvocation actionInvocation, ControlPoint controlPoint) {
            super(actionInvocation, controlPoint);
        }

        @Override // org.jupnp.controlpoint.ActionCallback
        public void failure(ActionInvocation actionInvocation, UpnpResponse upnpResponse, String str) {
        }

        @Override // org.jupnp.controlpoint.ActionCallback
        public void success(ActionInvocation actionInvocation) {
        }
    }

    public ActionCallback(ActionInvocation actionInvocation, ControlPoint controlPoint) {
        this.actionInvocation = actionInvocation;
        this.controlPoint = controlPoint;
    }

    public String createDefaultFailureMessage(ActionInvocation actionInvocation, UpnpResponse upnpResponse) {
        ActionException failure = actionInvocation.getFailure();
        String str = "Error: ";
        if (failure != null) {
            str = "Error: " + failure.getMessage();
        }
        if (upnpResponse == null) {
            return str;
        }
        return str + " (HTTP response was: " + upnpResponse.getResponseDetails() + ")";
    }

    public void failure(ActionInvocation actionInvocation, UpnpResponse upnpResponse) {
        failure(actionInvocation, upnpResponse, createDefaultFailureMessage(actionInvocation, upnpResponse));
    }

    public abstract void failure(ActionInvocation actionInvocation, UpnpResponse upnpResponse, String str);

    public ActionInvocation getActionInvocation() {
        return this.actionInvocation;
    }

    public synchronized ControlPoint getControlPoint() {
        return this.controlPoint;
    }

    @Override // java.lang.Runnable
    public void run() {
        Service service = this.actionInvocation.getAction().getService();
        if (service instanceof LocalService) {
            ((LocalService) service).getExecutor(this.actionInvocation.getAction()).execute(this.actionInvocation);
            ActionException failure = this.actionInvocation.getFailure();
            ActionInvocation actionInvocation = this.actionInvocation;
            if (failure != null) {
                failure(actionInvocation, null);
                return;
            } else {
                success(actionInvocation);
                return;
            }
        }
        if (service instanceof RemoteService) {
            if (getControlPoint() == null) {
                e04.a("Callback must be executed through ControlPoint");
                return;
            }
            RemoteService remoteService = (RemoteService) service;
            try {
                SendingAction sendingActionCreateSendingAction = getControlPoint().getProtocolFactory().createSendingAction(this.actionInvocation, remoteService.getDevice().normalizeURI(remoteService.getControlURI()));
                sendingActionCreateSendingAction.run();
                IncomingActionResponseMessage outputMessage = sendingActionCreateSendingAction.getOutputMessage();
                if (outputMessage == null) {
                    failure(this.actionInvocation, null);
                    return;
                }
                boolean zIsFailed = outputMessage.getOperation().isFailed();
                ActionInvocation actionInvocation2 = this.actionInvocation;
                if (zIsFailed) {
                    failure(actionInvocation2, outputMessage.getOperation());
                } else {
                    success(actionInvocation2);
                }
            } catch (IllegalArgumentException unused) {
                failure(this.actionInvocation, null, "bad control URL: ".concat(String.valueOf(remoteService.getControlURI())));
            }
        }
    }

    public synchronized ActionCallback setControlPoint(ControlPoint controlPoint) {
        this.controlPoint = controlPoint;
        return this;
    }

    public abstract void success(ActionInvocation actionInvocation);

    public String toString() {
        return "(ActionCallback) ".concat(String.valueOf(this.actionInvocation));
    }

    public ActionCallback(ActionInvocation actionInvocation) {
        this.actionInvocation = actionInvocation;
    }
}
