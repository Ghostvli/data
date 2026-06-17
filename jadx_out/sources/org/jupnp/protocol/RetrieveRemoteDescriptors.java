package org.jupnp.protocol;

import defpackage.j02;
import defpackage.jl;
import defpackage.n02;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.jupnp.UpnpService;
import org.jupnp.UpnpServiceConfiguration;
import org.jupnp.binding.xml.DescriptorBindingException;
import org.jupnp.model.ValidationError;
import org.jupnp.model.ValidationException;
import org.jupnp.model.message.StreamRequestMessage;
import org.jupnp.model.message.StreamResponseMessage;
import org.jupnp.model.message.UpnpHeaders;
import org.jupnp.model.message.UpnpRequest;
import org.jupnp.model.meta.Icon;
import org.jupnp.model.meta.RemoteDevice;
import org.jupnp.model.meta.RemoteDeviceIdentity;
import org.jupnp.model.meta.RemoteService;
import org.jupnp.model.types.ServiceType;
import org.jupnp.model.types.UDN;
import org.jupnp.registry.RegistrationException;
import org.jupnp.transport.RouterException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class RetrieveRemoteDescriptors implements Runnable {
    private static final ConcurrentHashMap<URL, Boolean> activeRetrievals = new ConcurrentHashMap<>();
    private RemoteDevice rd;
    private final UpnpService upnpService;
    private final j02 logger = n02.k(RetrieveRemoteDescriptors.class);
    protected List<UDN> errorsAlreadyLogged = new ArrayList();

    public RetrieveRemoteDescriptors(UpnpService upnpService, RemoteDevice remoteDevice) {
        this.upnpService = upnpService;
        this.rd = remoteDevice;
    }

    public static boolean isRetrievalInProgress(RemoteDevice remoteDevice) {
        if (remoteDevice != null) {
            return activeRetrievals.containsKey(remoteDevice.getIdentity().getDescriptorURL());
        }
        jl.a("RemoteDevice must not be null!");
        return false;
    }

    public void describe(String str) {
        RemoteDevice remoteDevice = null;
        try {
            UpnpServiceConfiguration configuration = getUpnpService().getConfiguration();
            if (configuration == null) {
                this.logger.d("Configuration not available, cannot parse device descriptor: {}", this.rd.getIdentity().getDescriptorURL());
                return;
            }
            RemoteDevice remoteDevice2 = (RemoteDevice) configuration.getDeviceDescriptorBinderUDA10().describe(this.rd, str);
            try {
                this.logger.q("Remote device described (without services) notifying listeners: {}", remoteDevice2);
                boolean zNotifyDiscoveryStart = getUpnpService().getRegistry().notifyDiscoveryStart(remoteDevice2);
                this.logger.q("Hydrating described device's services: {}", remoteDevice2);
                RemoteDevice remoteDeviceDescribeServices = describeServices(remoteDevice2);
                if (remoteDeviceDescribeServices != null) {
                    this.logger.q("Adding fully hydrated remote device to registry: {}", remoteDeviceDescribeServices);
                    getUpnpService().getRegistry().addDevice(remoteDeviceDescribeServices);
                    return;
                }
                if (!this.errorsAlreadyLogged.contains(this.rd.getIdentity().getUdn())) {
                    this.errorsAlreadyLogged.add(this.rd.getIdentity().getUdn());
                    this.logger.d("Device service description failed: {}", this.rd);
                }
                if (zNotifyDiscoveryStart) {
                    getUpnpService().getRegistry().notifyDiscoveryFailure(remoteDevice2, new DescriptorBindingException("Device service description failed: ".concat(String.valueOf(this.rd))));
                    this.logger.q("Adding described remote device to registry: {}", remoteDevice2);
                    getUpnpService().getRegistry().addDevice(remoteDevice2);
                }
            } catch (DescriptorBindingException e) {
                remoteDevice = remoteDevice2;
                e = e;
                this.logger.m("Could not hydrate device or its services from descriptor: {}", this.rd, e);
                if (remoteDevice == null || 0 == 0) {
                    return;
                }
                getUpnpService().getRegistry().notifyDiscoveryFailure(remoteDevice, e);
            } catch (ValidationException e2) {
                remoteDevice = remoteDevice2;
                e = e2;
                if (this.errorsAlreadyLogged.contains(this.rd.getIdentity().getUdn())) {
                    return;
                }
                this.errorsAlreadyLogged.add(this.rd.getIdentity().getUdn());
                this.logger.d("Could not validate device model: {}", this.rd);
                Iterator<ValidationError> it = e.getErrors().iterator();
                while (it.hasNext()) {
                    this.logger.warn(it.next().toString());
                }
                if (remoteDevice == null || 0 == 0) {
                    return;
                }
                getUpnpService().getRegistry().notifyDiscoveryFailure(remoteDevice, e);
            } catch (RegistrationException e3) {
                remoteDevice = remoteDevice2;
                e = e3;
                this.logger.m("Adding hydrated device to registry failed: {}", this.rd, e);
                if (remoteDevice == null || 0 == 0) {
                    return;
                }
                getUpnpService().getRegistry().notifyDiscoveryFailure(remoteDevice, e);
            }
        } catch (DescriptorBindingException e4) {
            e = e4;
        } catch (ValidationException e5) {
            e = e5;
        } catch (RegistrationException e6) {
            e = e6;
        }
    }

    public RemoteService describeService(RemoteService remoteService) {
        try {
            URL urlNormalizeURI = remoteService.getDevice().normalizeURI(remoteService.getDescriptorURI());
            UpnpServiceConfiguration configuration = getUpnpService().getConfiguration();
            if (configuration == null) {
                this.logger.d("Configuration not available, cannot retrieve service descriptor: {}", urlNormalizeURI);
                return null;
            }
            StreamRequestMessage streamRequestMessage = new StreamRequestMessage(UpnpRequest.Method.GET, urlNormalizeURI);
            UpnpHeaders descriptorRetrievalHeaders = configuration.getDescriptorRetrievalHeaders(remoteService.getDevice().getIdentity());
            if (descriptorRetrievalHeaders != null) {
                streamRequestMessage.getHeaders().putAll(descriptorRetrievalHeaders);
            }
            this.logger.q("Sending service descriptor retrieval message: {}", streamRequestMessage);
            StreamResponseMessage streamResponseMessageSend = getUpnpService().getRouter().send(streamRequestMessage);
            if (streamResponseMessageSend == null) {
                this.logger.d("Could not retrieve service descriptor, no response: {}", remoteService);
                return null;
            }
            if (streamResponseMessageSend.getOperation().isFailed()) {
                this.logger.m("Service descriptor retrieval failed: {}, {}", urlNormalizeURI, streamResponseMessageSend.getOperation().getResponseDetails());
                return null;
            }
            if (!streamResponseMessageSend.isContentTypeTextUDA()) {
                this.logger.q("Received service descriptor without or with invalid Content-Type: {}", urlNormalizeURI);
            }
            String bodyString = streamResponseMessageSend.getBodyString();
            if (bodyString == null || bodyString.isEmpty()) {
                this.logger.d("Received empty service descriptor: {}", urlNormalizeURI);
                return null;
            }
            this.logger.q("Received service descriptor, hydrating service model: {}", streamResponseMessageSend);
            return (RemoteService) configuration.getServiceDescriptorBinderUDA10().describe(remoteService, bodyString);
        } catch (IllegalArgumentException unused) {
            this.logger.d("Could not normalize service descriptor URL: {}", remoteService.getDescriptorURI());
            return null;
        }
    }

    public RemoteDevice describeServices(RemoteDevice remoteDevice) {
        RemoteDevice remoteDeviceDescribeServices;
        ArrayList arrayList = new ArrayList();
        if (remoteDevice.hasServices()) {
            Iterator<RemoteService> it = filterExclusiveServices(remoteDevice.getServices()).iterator();
            while (it.hasNext()) {
                RemoteService remoteServiceDescribeService = describeService(it.next());
                if (remoteServiceDescribeService != null) {
                    arrayList.add(remoteServiceDescribeService);
                }
            }
        }
        List<RemoteDevice> arrayList2 = new ArrayList<>();
        if (remoteDevice.hasEmbeddedDevices()) {
            for (RemoteDevice remoteDevice2 : remoteDevice.getEmbeddedDevices()) {
                if (remoteDevice2 != null && (remoteDeviceDescribeServices = describeServices(remoteDevice2)) != null) {
                    arrayList2.add(remoteDeviceDescribeServices);
                }
            }
        }
        if (remoteDevice.hasServices() && arrayList.isEmpty()) {
            return null;
        }
        if (remoteDevice.hasEmbeddedDevices() && arrayList2.isEmpty()) {
            return null;
        }
        Icon[] iconArr = new Icon[remoteDevice.getIcons().length];
        for (int i = 0; i < remoteDevice.getIcons().length; i++) {
            iconArr[i] = remoteDevice.getIcons()[i].deepCopy();
        }
        return remoteDevice.newInstance(((RemoteDeviceIdentity) remoteDevice.getIdentity()).getUdn(), remoteDevice.getVersion(), remoteDevice.getType(), remoteDevice.getDetails(), iconArr, remoteDevice.toServiceArray((Collection<RemoteService>) arrayList), arrayList2);
    }

    public List<RemoteService> filterExclusiveServices(RemoteService[] remoteServiceArr) {
        UpnpServiceConfiguration configuration = getUpnpService().getConfiguration();
        if (configuration == null) {
            this.logger.b("Configuration not available, including all services");
            return Arrays.asList(remoteServiceArr);
        }
        ServiceType[] exclusiveServiceTypes = configuration.getExclusiveServiceTypes();
        if (exclusiveServiceTypes == null || exclusiveServiceTypes.length == 0) {
            return Arrays.asList(remoteServiceArr);
        }
        ArrayList arrayList = new ArrayList();
        for (RemoteService remoteService : remoteServiceArr) {
            for (ServiceType serviceType : exclusiveServiceTypes) {
                boolean zImplementsVersion = remoteService.getServiceType().implementsVersion(serviceType);
                j02 j02Var = this.logger;
                if (zImplementsVersion) {
                    j02Var.q("Including exclusive service: {}", remoteService);
                    arrayList.add(remoteService);
                } else {
                    j02Var.q("Excluding unwanted service: {}", serviceType);
                }
            }
        }
        return arrayList;
    }

    public UpnpService getUpnpService() {
        return this.upnpService;
    }

    @Override // java.lang.Runnable
    public void run() {
        URL descriptorURL = this.rd.getIdentity().getDescriptorURL();
        if (getUpnpService().getRegistry().getRemoteDevice(this.rd.getIdentity().getUdn(), true) != null) {
            this.logger.h("Exiting early, already discovered: {}", descriptorURL);
            return;
        }
        ConcurrentHashMap<URL, Boolean> concurrentHashMap = activeRetrievals;
        if (concurrentHashMap.putIfAbsent(descriptorURL, Boolean.TRUE) != null) {
            this.logger.h("Exiting early, active retrieval for URL already in progress: {}", descriptorURL);
            return;
        }
        try {
            try {
                describe();
                concurrentHashMap.remove(descriptorURL);
            } catch (RouterException e) {
                this.logger.m("Descriptor retrieval failed: {}", descriptorURL, e);
                activeRetrievals.remove(descriptorURL);
            }
        } catch (Throwable th) {
            activeRetrievals.remove(descriptorURL);
            throw th;
        }
    }

    public void describe() {
        if (getUpnpService().getRouter() == null) {
            this.logger.warn("Router not yet initialized");
            return;
        }
        try {
            StreamRequestMessage streamRequestMessage = new StreamRequestMessage(UpnpRequest.Method.GET, this.rd.getIdentity().getDescriptorURL());
            UpnpServiceConfiguration configuration = getUpnpService().getConfiguration();
            if (configuration != null) {
                UpnpHeaders descriptorRetrievalHeaders = configuration.getDescriptorRetrievalHeaders(this.rd.getIdentity());
                if (descriptorRetrievalHeaders != null) {
                    streamRequestMessage.getHeaders().putAll(descriptorRetrievalHeaders);
                }
            } else {
                this.logger.b("Configuration not available, skipping descriptor retrieval headers");
            }
            this.logger.q("Sending device descriptor retrieval message: {}", streamRequestMessage);
            StreamResponseMessage streamResponseMessageSend = getUpnpService().getRouter().send(streamRequestMessage);
            if (streamResponseMessageSend == null) {
                this.logger.d("Device descriptor retrieval failed, no response: {}", this.rd.getIdentity().getDescriptorURL());
                return;
            }
            if (streamResponseMessageSend.getOperation().isFailed()) {
                this.logger.m("Device descriptor retrieval failed: {}, {}", this.rd.getIdentity().getDescriptorURL(), streamResponseMessageSend.getOperation().getResponseDetails());
                return;
            }
            if (!streamResponseMessageSend.isContentTypeTextUDA()) {
                this.logger.q("Received device descriptor without or with invalid Content-Type: {}", this.rd.getIdentity().getDescriptorURL());
            }
            String bodyString = streamResponseMessageSend.getBodyString();
            if (bodyString != null && !bodyString.isEmpty()) {
                this.logger.q("Received root device descriptor: {}", streamResponseMessageSend);
                describe(bodyString);
            } else {
                this.logger.d("Received empty device descriptor: {}", this.rd.getIdentity().getDescriptorURL());
            }
        } catch (IllegalArgumentException e) {
            this.logger.m("Device descriptor retrieval failed: {}, possibly invalid URL", this.rd.getIdentity().getDescriptorURL(), e);
        }
    }
}
