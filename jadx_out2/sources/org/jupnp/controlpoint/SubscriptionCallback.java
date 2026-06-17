package org.jupnp.controlpoint;

import defpackage.j02;
import defpackage.n02;
import java.util.Collections;
import org.jupnp.model.UnsupportedDataException;
import org.jupnp.model.gena.CancelReason;
import org.jupnp.model.gena.GENASubscription;
import org.jupnp.model.gena.LocalGENASubscription;
import org.jupnp.model.gena.RemoteGENASubscription;
import org.jupnp.model.message.UpnpResponse;
import org.jupnp.model.meta.LocalService;
import org.jupnp.model.meta.RemoteService;
import org.jupnp.model.meta.Service;
import org.jupnp.protocol.ProtocolCreationException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SubscriptionCallback implements Runnable {
    private ControlPoint controlPoint;
    protected j02 logger;
    protected final Integer requestedDurationSeconds;
    protected final Service service;
    private GENASubscription subscription;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SubscriptionCallback(Service service) {
        this.logger = n02.k(SubscriptionCallback.class);
        this.service = service;
        this.requestedDurationSeconds = 1800;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String createDefaultFailureMessage(UpnpResponse upnpResponse, Exception exc) {
        if (upnpResponse == null) {
            return exc != null ? "Subscription failed:  Exception occurred: ".concat(String.valueOf(exc)) : "Subscription failed:  No response received.";
        }
        return "Subscription failed:  HTTP response was: " + upnpResponse.getResponseDetails();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void endLocalSubscription(LocalGENASubscription localGENASubscription) {
        this.logger.h("Removing local subscription and ending it in callback: {}", localGENASubscription);
        getControlPoint().getRegistry().removeLocalSubscription(localGENASubscription);
        localGENASubscription.end(null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void endRemoteSubscription(RemoteGENASubscription remoteGENASubscription) {
        this.logger.h("Ending remote subscription: {}", remoteGENASubscription);
        getControlPoint().getConfiguration().getSyncProtocolExecutorService().execute(getControlPoint().getProtocolFactory().createSendingUnsubscribe(remoteGENASubscription));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void establishLocalSubscription(LocalService localService) {
        LocalGENASubscription localGENASubscription;
        if (getControlPoint().getRegistry().getLocalDevice(localService.getDevice().getIdentity().getUdn(), false) == null) {
            this.logger.y("Local device service is currently not registered, failing subscription immediately");
            failed(null, null, new IllegalStateException("Local device is not registered"));
            return;
        }
        try {
            localGENASubscription = new LocalGENASubscription(localService, Integer.MAX_VALUE, Collections.EMPTY_LIST) { // from class: org.jupnp.controlpoint.SubscriptionCallback.1
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // org.jupnp.model.gena.LocalGENASubscription
                public void ended(CancelReason cancelReason) {
                    synchronized (SubscriptionCallback.this) {
                        SubscriptionCallback.this.setSubscription(null);
                        SubscriptionCallback.this.ended(this, cancelReason, null);
                    }
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // org.jupnp.model.gena.GENASubscription
                public void established() {
                    synchronized (SubscriptionCallback.this) {
                        SubscriptionCallback.this.setSubscription(this);
                        SubscriptionCallback.this.established(this);
                    }
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // org.jupnp.model.gena.GENASubscription
                public void eventReceived() {
                    synchronized (SubscriptionCallback.this) {
                        SubscriptionCallback.this.logger.h("Local service state updated, notifying callback, sequence is: {}", getCurrentSequence());
                        SubscriptionCallback.this.eventReceived(this);
                        incrementSequence();
                    }
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public void failed(Exception exc) {
                    synchronized (SubscriptionCallback.this) {
                        SubscriptionCallback.this.setSubscription(null);
                        SubscriptionCallback.this.failed(null, null, exc);
                    }
                }
            };
        } catch (Exception e) {
            e = e;
            localGENASubscription = null;
        }
        try {
            this.logger.y("Local device service is currently registered, also registering subscription");
            getControlPoint().getRegistry().addLocalSubscription(localGENASubscription);
            this.logger.y("Notifying subscription callback of local subscription availability");
            localGENASubscription.establish();
            this.logger.h("Simulating first initial event for local subscription callback, sequence: {}", localGENASubscription.getCurrentSequence());
            eventReceived(localGENASubscription);
            localGENASubscription.incrementSequence();
            this.logger.y("Starting to monitor state changes of local service");
            localGENASubscription.registerOnService();
        } catch (Exception e2) {
            e = e2;
            this.logger.v("Local callback creation failed", e);
            if (localGENASubscription != null) {
                getControlPoint().getRegistry().removeLocalSubscription(localGENASubscription);
            }
            failed(localGENASubscription, null, e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void establishRemoteSubscription(RemoteService remoteService) {
        try {
            getControlPoint().getProtocolFactory().createSendingSubscribe(new RemoteGENASubscription(remoteService, this.requestedDurationSeconds.intValue()) { // from class: org.jupnp.controlpoint.SubscriptionCallback.2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // org.jupnp.model.gena.RemoteGENASubscription
                public void ended(CancelReason cancelReason, UpnpResponse upnpResponse) {
                    synchronized (SubscriptionCallback.this) {
                        SubscriptionCallback.this.setSubscription(null);
                        SubscriptionCallback.this.ended(this, cancelReason, upnpResponse);
                    }
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // org.jupnp.model.gena.GENASubscription
                public void established() {
                    synchronized (SubscriptionCallback.this) {
                        SubscriptionCallback.this.setSubscription(this);
                        SubscriptionCallback.this.established(this);
                    }
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // org.jupnp.model.gena.GENASubscription
                public void eventReceived() {
                    synchronized (SubscriptionCallback.this) {
                        SubscriptionCallback.this.eventReceived(this);
                    }
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // org.jupnp.model.gena.RemoteGENASubscription
                public void eventsMissed(int i) {
                    synchronized (SubscriptionCallback.this) {
                        SubscriptionCallback.this.eventsMissed(this, i);
                    }
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // org.jupnp.model.gena.RemoteGENASubscription
                public void failed(UpnpResponse upnpResponse) {
                    synchronized (SubscriptionCallback.this) {
                        SubscriptionCallback.this.setSubscription(null);
                        SubscriptionCallback.this.failed(this, upnpResponse, null);
                    }
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // org.jupnp.model.gena.RemoteGENASubscription
                public void invalidMessage(UnsupportedDataException unsupportedDataException) {
                    synchronized (SubscriptionCallback.this) {
                        SubscriptionCallback.this.invalidMessage(this, unsupportedDataException);
                    }
                }
            }).run();
        } catch (ProtocolCreationException e) {
            this.failed(this.subscription, null, e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized void end() {
        try {
            GENASubscription gENASubscription = this.subscription;
            if (gENASubscription == null) {
                return;
            }
            if (gENASubscription instanceof LocalGENASubscription) {
                endLocalSubscription((LocalGENASubscription) gENASubscription);
            } else if (gENASubscription instanceof RemoteGENASubscription) {
                endRemoteSubscription((RemoteGENASubscription) gENASubscription);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public abstract void ended(GENASubscription gENASubscription, CancelReason cancelReason, UpnpResponse upnpResponse);

    public abstract void established(GENASubscription gENASubscription);

    public abstract void eventReceived(GENASubscription gENASubscription);

    public abstract void eventsMissed(GENASubscription gENASubscription, int i);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void failed(GENASubscription gENASubscription, UpnpResponse upnpResponse, Exception exc) {
        failed(gENASubscription, upnpResponse, exc, createDefaultFailureMessage(upnpResponse, exc));
    }

    public abstract void failed(GENASubscription gENASubscription, UpnpResponse upnpResponse, Exception exc, String str);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized ControlPoint getControlPoint() {
        return this.controlPoint;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Service getService() {
        return this.service;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized GENASubscription getSubscription() {
        return this.subscription;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void invalidMessage(RemoteGENASubscription remoteGENASubscription, UnsupportedDataException unsupportedDataException) {
        this.logger.t("Invalid event message received", unsupportedDataException);
        if (this.logger.n()) {
            this.logger.y("------------------------------------------------------------------------------");
            this.logger.y(unsupportedDataException.getData() != null ? unsupportedDataException.getData().toString() : "null");
            this.logger.y("------------------------------------------------------------------------------");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.Runnable
    public synchronized void run() {
        try {
            if (getControlPoint() == null) {
                throw new IllegalStateException("Callback must be executed through ControlPoint");
            }
            if (getService() instanceof LocalService) {
                establishLocalSubscription((LocalService) this.service);
            } else if (getService() instanceof RemoteService) {
                establishRemoteSubscription((RemoteService) this.service);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized void setControlPoint(ControlPoint controlPoint) {
        this.controlPoint = controlPoint;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized void setSubscription(GENASubscription gENASubscription) {
        this.subscription = gENASubscription;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "(SubscriptionCallback) ".concat(String.valueOf(getService()));
    }

    public SubscriptionCallback(Service service, int i) {
        this.logger = n02.k(SubscriptionCallback.class);
        this.service = service;
        this.requestedDurationSeconds = Integer.valueOf(i);
    }
}
