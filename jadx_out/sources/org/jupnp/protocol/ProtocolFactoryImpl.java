package org.jupnp.protocol;

import defpackage.j02;
import defpackage.n02;
import java.net.URI;
import java.net.URL;
import org.jupnp.UpnpService;
import org.jupnp.UpnpServiceConfiguration;
import org.jupnp.model.Namespace;
import org.jupnp.model.action.ActionInvocation;
import org.jupnp.model.gena.LocalGENASubscription;
import org.jupnp.model.gena.RemoteGENASubscription;
import org.jupnp.model.message.IncomingDatagramMessage;
import org.jupnp.model.message.StreamRequestMessage;
import org.jupnp.model.message.UpnpRequest;
import org.jupnp.model.message.UpnpResponse;
import org.jupnp.model.message.header.UpnpHeader;
import org.jupnp.model.meta.LocalDevice;
import org.jupnp.model.types.InvalidValueException;
import org.jupnp.model.types.NamedServiceType;
import org.jupnp.model.types.NotificationSubtype;
import org.jupnp.model.types.ServiceType;
import org.jupnp.protocol.async.ReceivingNotification;
import org.jupnp.protocol.async.ReceivingSearch;
import org.jupnp.protocol.async.ReceivingSearchResponse;
import org.jupnp.protocol.async.SendingNotificationAlive;
import org.jupnp.protocol.async.SendingNotificationByebye;
import org.jupnp.protocol.async.SendingSearch;
import org.jupnp.protocol.sync.ReceivingAction;
import org.jupnp.protocol.sync.ReceivingEvent;
import org.jupnp.protocol.sync.ReceivingRetrieval;
import org.jupnp.protocol.sync.ReceivingSubscribe;
import org.jupnp.protocol.sync.ReceivingUnsubscribe;
import org.jupnp.protocol.sync.SendingAction;
import org.jupnp.protocol.sync.SendingEvent;
import org.jupnp.protocol.sync.SendingRenewal;
import org.jupnp.protocol.sync.SendingSubscribe;
import org.jupnp.protocol.sync.SendingUnsubscribe;
import org.jupnp.transport.RouterException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ProtocolFactoryImpl implements ProtocolFactory {
    private final j02 logger;
    protected final UpnpService upnpService;

    /* JADX INFO: renamed from: org.jupnp.protocol.ProtocolFactoryImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jupnp$model$message$UpnpRequest$Method;

        static {
            int[] iArr = new int[UpnpRequest.Method.values().length];
            $SwitchMap$org$jupnp$model$message$UpnpRequest$Method = iArr;
            try {
                iArr[UpnpRequest.Method.NOTIFY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jupnp$model$message$UpnpRequest$Method[UpnpRequest.Method.MSEARCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public ProtocolFactoryImpl(UpnpService upnpService) {
        j02 j02VarK = n02.k(ProtocolFactory.class);
        this.logger = j02VarK;
        j02VarK.h("Creating ProtocolFactory: {}", getClass().getName());
        this.upnpService = upnpService;
    }

    public ReceivingAction createReceivingAction(StreamRequestMessage streamRequestMessage) {
        return new ReceivingAction(getUpnpService(), streamRequestMessage);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jupnp.protocol.ProtocolFactory
    public ReceivingAsync createReceivingAsync(IncomingDatagramMessage incomingDatagramMessage) throws ProtocolCreationException {
        this.logger.h("Creating protocol for incoming asynchronous: {}", incomingDatagramMessage);
        if (incomingDatagramMessage.getOperation() instanceof UpnpRequest) {
            int i = AnonymousClass1.$SwitchMap$org$jupnp$model$message$UpnpRequest$Method[((UpnpRequest) incomingDatagramMessage.getOperation()).getMethod().ordinal()];
            if (i == 1) {
                if (isByeBye(incomingDatagramMessage) || isSupportedServiceAdvertisement(incomingDatagramMessage)) {
                    return createReceivingNotification(incomingDatagramMessage);
                }
                return null;
            }
            if (i == 2) {
                return createReceivingSearch(incomingDatagramMessage);
            }
        } else if (incomingDatagramMessage.getOperation() instanceof UpnpResponse) {
            if (isSupportedServiceAdvertisement(incomingDatagramMessage)) {
                return createReceivingSearchResponse(incomingDatagramMessage);
            }
            return null;
        }
        throw new ProtocolCreationException("Protocol for incoming datagram message not found: ".concat(String.valueOf(incomingDatagramMessage)));
    }

    public ReceivingEvent createReceivingEvent(StreamRequestMessage streamRequestMessage) {
        return new ReceivingEvent(getUpnpService(), streamRequestMessage);
    }

    public ReceivingAsync createReceivingNotification(IncomingDatagramMessage<UpnpRequest> incomingDatagramMessage) {
        return new ReceivingNotification(getUpnpService(), incomingDatagramMessage);
    }

    public ReceivingRetrieval createReceivingRetrieval(StreamRequestMessage streamRequestMessage) {
        return new ReceivingRetrieval(getUpnpService(), streamRequestMessage);
    }

    public ReceivingAsync createReceivingSearch(IncomingDatagramMessage<UpnpRequest> incomingDatagramMessage) {
        return new ReceivingSearch(getUpnpService(), incomingDatagramMessage);
    }

    public ReceivingAsync createReceivingSearchResponse(IncomingDatagramMessage<UpnpResponse> incomingDatagramMessage) {
        return new ReceivingSearchResponse(getUpnpService(), incomingDatagramMessage);
    }

    public ReceivingSubscribe createReceivingSubscribe(StreamRequestMessage streamRequestMessage) {
        return new ReceivingSubscribe(getUpnpService(), streamRequestMessage);
    }

    @Override // org.jupnp.protocol.ProtocolFactory
    public ReceivingSync createReceivingSync(StreamRequestMessage streamRequestMessage) throws ProtocolCreationException {
        this.logger.h("Creating protocol for incoming synchronous: {}", streamRequestMessage);
        if (streamRequestMessage.getOperation().getMethod().equals(UpnpRequest.Method.GET)) {
            return createReceivingRetrieval(streamRequestMessage);
        }
        if (getUpnpService().getConfiguration().getNamespace().isControlPath(streamRequestMessage.getUri())) {
            if (streamRequestMessage.getOperation().getMethod().equals(UpnpRequest.Method.POST)) {
                return createReceivingAction(streamRequestMessage);
            }
        } else if (getUpnpService().getConfiguration().getNamespace().isEventSubscriptionPath(streamRequestMessage.getUri())) {
            if (streamRequestMessage.getOperation().getMethod().equals(UpnpRequest.Method.SUBSCRIBE)) {
                return createReceivingSubscribe(streamRequestMessage);
            }
            if (streamRequestMessage.getOperation().getMethod().equals(UpnpRequest.Method.UNSUBSCRIBE)) {
                return createReceivingUnsubscribe(streamRequestMessage);
            }
        } else if (getUpnpService().getConfiguration().getNamespace().isEventCallbackPath(streamRequestMessage.getUri())) {
            if (streamRequestMessage.getOperation().getMethod().equals(UpnpRequest.Method.NOTIFY)) {
                return createReceivingEvent(streamRequestMessage);
            }
        } else if (streamRequestMessage.getUri().getPath().contains("/event/cb")) {
            this.logger.d("Fixing trailing garbage in event message path: {}", streamRequestMessage.getUri().getPath());
            String string = streamRequestMessage.getUri().toString();
            streamRequestMessage.setUri(URI.create(string.substring(0, string.indexOf(Namespace.CALLBACK_FILE) + 3)));
            if (getUpnpService().getConfiguration().getNamespace().isEventCallbackPath(streamRequestMessage.getUri()) && streamRequestMessage.getOperation().getMethod().equals(UpnpRequest.Method.NOTIFY)) {
                return createReceivingEvent(streamRequestMessage);
            }
        }
        throw new ProtocolCreationException("Protocol for message type not found: ".concat(String.valueOf(streamRequestMessage)));
    }

    public ReceivingUnsubscribe createReceivingUnsubscribe(StreamRequestMessage streamRequestMessage) {
        return new ReceivingUnsubscribe(getUpnpService(), streamRequestMessage);
    }

    @Override // org.jupnp.protocol.ProtocolFactory
    public SendingAction createSendingAction(ActionInvocation actionInvocation, URL url) {
        return new SendingAction(getUpnpService(), actionInvocation, url);
    }

    @Override // org.jupnp.protocol.ProtocolFactory
    public SendingEvent createSendingEvent(LocalGENASubscription localGENASubscription) {
        return new SendingEvent(getUpnpService(), localGENASubscription);
    }

    @Override // org.jupnp.protocol.ProtocolFactory
    public SendingNotificationAlive createSendingNotificationAlive(LocalDevice localDevice) {
        return new SendingNotificationAlive(getUpnpService(), localDevice);
    }

    @Override // org.jupnp.protocol.ProtocolFactory
    public SendingNotificationByebye createSendingNotificationByebye(LocalDevice localDevice) {
        return new SendingNotificationByebye(getUpnpService(), localDevice);
    }

    @Override // org.jupnp.protocol.ProtocolFactory
    public SendingRenewal createSendingRenewal(RemoteGENASubscription remoteGENASubscription) {
        return new SendingRenewal(getUpnpService(), remoteGENASubscription);
    }

    @Override // org.jupnp.protocol.ProtocolFactory
    public SendingSearch createSendingSearch(UpnpHeader upnpHeader, int i) {
        return new SendingSearch(getUpnpService(), upnpHeader, i);
    }

    @Override // org.jupnp.protocol.ProtocolFactory
    public SendingSubscribe createSendingSubscribe(RemoteGENASubscription remoteGENASubscription) throws ProtocolCreationException {
        try {
            return new SendingSubscribe(getUpnpService(), remoteGENASubscription, getUpnpService().getRouter().getActiveStreamServers(remoteGENASubscription.getService().getDevice().getIdentity().getDiscoveredOnLocalAddress()));
        } catch (RouterException e) {
            throw new ProtocolCreationException("Failed to obtain local stream servers (for event callback URL creation) from router", e);
        }
    }

    @Override // org.jupnp.protocol.ProtocolFactory
    public SendingUnsubscribe createSendingUnsubscribe(RemoteGENASubscription remoteGENASubscription) {
        return new SendingUnsubscribe(getUpnpService(), remoteGENASubscription);
    }

    @Override // org.jupnp.protocol.ProtocolFactory
    public UpnpService getUpnpService() {
        return this.upnpService;
    }

    public boolean isByeBye(IncomingDatagramMessage incomingDatagramMessage) {
        String firstHeader = incomingDatagramMessage.getHeaders().getFirstHeader(UpnpHeader.Type.NTS.getHttpName());
        return firstHeader != null && firstHeader.equals(NotificationSubtype.BYEBYE.getHeaderString());
    }

    public boolean isSupportedServiceAdvertisement(IncomingDatagramMessage incomingDatagramMessage) {
        ServiceType[] exclusiveServiceTypes;
        UpnpServiceConfiguration configuration = this.upnpService.getConfiguration();
        if (configuration == null || (exclusiveServiceTypes = configuration.getExclusiveServiceTypes()) == null) {
            return false;
        }
        if (exclusiveServiceTypes.length == 0) {
            return true;
        }
        String firstHeader = incomingDatagramMessage.getHeaders().getFirstHeader(UpnpHeader.Type.USN.getHttpName());
        if (firstHeader == null) {
            return false;
        }
        try {
            NamedServiceType namedServiceTypeValueOf = NamedServiceType.valueOf(firstHeader);
            for (ServiceType serviceType : exclusiveServiceTypes) {
                if (namedServiceTypeValueOf.getServiceType().implementsVersion(serviceType)) {
                    return true;
                }
            }
        } catch (InvalidValueException unused) {
            this.logger.h("Not a named service type header value: {}", firstHeader);
        }
        this.logger.h("Service advertisement not supported, dropping it: {}", firstHeader);
        return false;
    }

    public ProtocolFactoryImpl() {
        this.logger = n02.k(ProtocolFactory.class);
        this.upnpService = null;
    }
}
