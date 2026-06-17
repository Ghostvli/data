package org.jupnp.model;

import defpackage.e04;
import defpackage.j02;
import defpackage.n02;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import org.jupnp.model.meta.Device;
import org.jupnp.model.meta.Icon;
import org.jupnp.model.meta.Service;
import org.jupnp.model.resource.Resource;
import org.jupnp.util.URIUtil;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Namespace {
    public static final String CALLBACK_FILE = "/cb";
    public static final String CONTROL = "/action";
    public static final String DESCRIPTOR_FILE = "/desc";
    public static final String DEVICE = "/dev";
    public static final String EVENTS = "/event";
    public static final String SERVICE = "/svc";
    protected final URI basePath;
    protected final String decodedPath;
    private final j02 logger;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Namespace(URI uri) {
        this.logger = n02.k(Namespace.class);
        this.basePath = uri;
        this.decodedPath = uri.getPath();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public URI appendPathToBaseURI(String str) {
        try {
            return new URI(this.basePath.getScheme(), null, this.basePath.getHost(), this.basePath.getPort(), this.decodedPath + str, null, null);
        } catch (URISyntaxException unused) {
            return URI.create(String.valueOf(this.basePath) + str);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public URI getBasePath() {
        return this.basePath;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public URI getControlPath(Service service) {
        return appendPathToBaseURI(getServicePath(service) + CONTROL);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public URI getDescriptorPath(Device device) {
        return appendPathToBaseURI(getDevicePath(device.getRoot()) + DESCRIPTOR_FILE);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getDescriptorPathString(Device device) {
        return this.decodedPath + getDevicePath(device.getRoot()) + DESCRIPTOR_FILE;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getDevicePath(Device device) {
        if (device.getIdentity().getUdn() == null) {
            e04.a("Can't generate local URI prefix without UDN");
            return null;
        }
        return "/dev/" + URIUtil.encodePathSegment(device.getIdentity().getUdn().getIdentifierString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public URI getEventCallbackPath(Service service) {
        return appendPathToBaseURI(getServicePath(service) + "/event/cb");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getEventCallbackPathString(Service service) {
        return this.decodedPath + getServicePath(service) + "/event/cb";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public URI getEventSubscriptionPath(Service service) {
        return appendPathToBaseURI(getServicePath(service) + EVENTS);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public URI getIconPath(Icon icon) {
        return appendPathToBaseURI(getDevicePath(icon.getDevice()) + ServiceReference.DELIMITER + icon.getUri().toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public URI getPath(Device device) {
        return appendPathToBaseURI(getDevicePath(device));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Resource[] getResources(Device device) throws ValidationException {
        if (!device.isRoot()) {
            return null;
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        this.logger.y("Discovering local resources of device graph");
        for (Resource resource : device.discoverResources(this)) {
            this.logger.h("Discovered: {}", resource);
            if (!hashSet.add(resource)) {
                this.logger.y("Local resource already exists, queueing validation error");
                arrayList.add(new ValidationError(getClass(), "resources", "Local URI namespace conflict between resources of device: ".concat(String.valueOf(resource))));
            }
        }
        if (arrayList.isEmpty()) {
            return (Resource[]) hashSet.toArray(new Resource[hashSet.size()]);
        }
        throw new ValidationException("Validation of device graph failed, call getErrors() on exception", arrayList);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getServicePath(Service service) {
        if (service.getServiceId() == null) {
            e04.a("Can't generate local URI prefix without service ID");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/svc/");
        sb.append(service.getServiceId().getNamespace());
        sb.append(ServiceReference.DELIMITER);
        sb.append(service.getServiceId().getId());
        return getDevicePath(service.getDevice()) + String.valueOf(sb);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isControlPath(URI uri) {
        return uri.toString().endsWith(CONTROL);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isEventCallbackPath(URI uri) {
        return uri.toString().endsWith(CALLBACK_FILE);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isEventSubscriptionPath(URI uri) {
        return uri.toString().endsWith(EVENTS);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public URI prefixIfRelative(Device device, URI uri) {
        if (uri.isAbsolute() || uri.getPath().startsWith(ServiceReference.DELIMITER)) {
            return uri;
        }
        return appendPathToBaseURI(getDevicePath(device) + ServiceReference.DELIMITER + String.valueOf(uri));
    }

    public URI getPath(Service service) {
        return appendPathToBaseURI(getServicePath(service));
    }

    public Namespace(String str) {
        this(URI.create(str));
    }

    public Namespace() {
        this("");
    }

    public URI getDescriptorPath(Service service) {
        return appendPathToBaseURI(getServicePath(service) + DESCRIPTOR_FILE);
    }
}
