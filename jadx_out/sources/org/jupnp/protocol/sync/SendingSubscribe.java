package org.jupnp.protocol.sync;

import defpackage.j02;
import defpackage.n02;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import org.jupnp.UpnpService;
import org.jupnp.model.NetworkAddress;
import org.jupnp.model.gena.RemoteGENASubscription;
import org.jupnp.model.message.StreamResponseMessage;
import org.jupnp.model.message.gena.IncomingSubscribeResponseMessage;
import org.jupnp.model.message.gena.OutgoingSubscribeRequestMessage;
import org.jupnp.protocol.SendingSync;
import org.jupnp.transport.RouterException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SendingSubscribe extends SendingSync<OutgoingSubscribeRequestMessage, IncomingSubscribeResponseMessage> {
    private final j02 logger;
    protected final RemoteGENASubscription subscription;

    public SendingSubscribe(UpnpService upnpService, RemoteGENASubscription remoteGENASubscription, List<NetworkAddress> list) {
        super(upnpService, new OutgoingSubscribeRequestMessage(remoteGENASubscription, remoteGENASubscription.getEventCallbackURLs(list, upnpService.getConfiguration().getNamespace()), upnpService.getConfiguration().getEventSubscriptionHeaders(remoteGENASubscription.getService())));
        this.logger = n02.k(SendingSubscribe.class);
        this.subscription = remoteGENASubscription;
    }

    @Override // org.jupnp.protocol.SendingSync
    public IncomingSubscribeResponseMessage executeSync() {
        boolean zHasCallbackURLs = getInputMessage().hasCallbackURLs();
        j02 j02Var = this.logger;
        if (!zHasCallbackURLs) {
            j02Var.y("Subscription failed, no active local callback URLs available (network disabled?)");
            getUpnpService().getConfiguration().getRegistryListenerExecutor().execute(new Runnable() { // from class: a14
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.subscription.fail(null);
                }
            });
            return null;
        }
        j02Var.h("Sending subscription request: {}", getInputMessage());
        try {
            getUpnpService().getRegistry().registerPendingRemoteSubscription(this.subscription);
            StreamResponseMessage streamResponseMessageSend = getUpnpService().getRouter().send(getInputMessage());
            if (streamResponseMessageSend == null) {
                onSubscriptionFailure();
                return null;
            }
            final IncomingSubscribeResponseMessage incomingSubscribeResponseMessage = new IncomingSubscribeResponseMessage(streamResponseMessageSend);
            if (streamResponseMessageSend.getOperation().isFailed()) {
                this.logger.h("Subscription failed, response was: {}", incomingSubscribeResponseMessage);
                getUpnpService().getConfiguration().getRegistryListenerExecutor().execute(new Runnable() { // from class: b14
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f.subscription.fail(incomingSubscribeResponseMessage.getOperation());
                    }
                });
            } else {
                boolean zIsValidHeaders = incomingSubscribeResponseMessage.isValidHeaders();
                j02 j02Var2 = this.logger;
                if (zIsValidHeaders) {
                    j02Var2.h("Subscription established, adding to registry, response was: {}", streamResponseMessageSend);
                    this.subscription.setSubscriptionId(incomingSubscribeResponseMessage.getSubscriptionId());
                    this.subscription.setActualSubscriptionDurationSeconds(incomingSubscribeResponseMessage.getSubscriptionDurationSeconds());
                    getUpnpService().getRegistry().addRemoteSubscription(this.subscription);
                    Executor registryListenerExecutor = getUpnpService().getConfiguration().getRegistryListenerExecutor();
                    final RemoteGENASubscription remoteGENASubscription = this.subscription;
                    Objects.requireNonNull(remoteGENASubscription);
                    registryListenerExecutor.execute(new Runnable() { // from class: d14
                        @Override // java.lang.Runnable
                        public final void run() {
                            remoteGENASubscription.establish();
                        }
                    });
                } else {
                    j02Var2.error("Subscription failed, invalid or missing (SID, Timeout) response headers");
                    getUpnpService().getConfiguration().getRegistryListenerExecutor().execute(new Runnable() { // from class: c14
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f.subscription.fail(incomingSubscribeResponseMessage.getOperation());
                        }
                    });
                }
            }
            return incomingSubscribeResponseMessage;
        } catch (RouterException unused) {
            onSubscriptionFailure();
            return null;
        } finally {
            getUpnpService().getRegistry().unregisterPendingRemoteSubscription(this.subscription);
        }
    }

    public void onSubscriptionFailure() {
        this.logger.y("Subscription failed");
        getUpnpService().getConfiguration().getRegistryListenerExecutor().execute(new Runnable() { // from class: z04
            @Override // java.lang.Runnable
            public final void run() {
                this.f.subscription.fail(null);
            }
        });
    }
}
