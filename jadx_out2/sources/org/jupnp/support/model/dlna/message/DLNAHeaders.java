package org.jupnp.support.model.dlna.message;

import defpackage.j02;
import defpackage.n02;
import java.io.ByteArrayInputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.jupnp.model.message.UpnpHeaders;
import org.jupnp.model.message.header.UpnpHeader;
import org.jupnp.support.model.dlna.message.DLNAHeaders;
import org.jupnp.support.model.dlna.message.header.DLNAHeader;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DLNAHeaders extends UpnpHeaders {
    private final j02 logger;
    protected Map<DLNAHeader.Type, List<UpnpHeader<?>>> parsedDLNAHeaders;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DLNAHeaders() {
        this.logger = n02.l(DLNAHeaders.class.getName());
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0002: CONSTRUCTOR  A[MD:():void (c)] (LINE:3) call: java.util.LinkedList.<init>():void type: CONSTRUCTOR */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ List c(DLNAHeader.Type type) {
        return new LinkedList();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void add(DLNAHeader.Type type, UpnpHeader<?> upnpHeader) {
        super.add(type.getHttpName(), upnpHeader.getString());
        if (this.parsedDLNAHeaders != null) {
            addParsedValue(type, upnpHeader);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void addParsedValue(DLNAHeader.Type type, UpnpHeader<?> upnpHeader) {
        this.logger.q("Adding parsed header: {}", upnpHeader);
        this.parsedDLNAHeaders.computeIfAbsent(type, new Function() { // from class: h80
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DLNAHeaders.c((DLNAHeader.Type) obj);
            }
        }).add(upnpHeader);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.model.message.UpnpHeaders, org.jupnp.http.Headers, java.util.Map
    public void clear() {
        this.parsedDLNAHeaders = null;
        super.clear();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean containsKey(DLNAHeader.Type type) {
        if (this.parsedDLNAHeaders == null) {
            parseHeaders();
        }
        return this.parsedDLNAHeaders.containsKey(type);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List<UpnpHeader<?>> get(DLNAHeader.Type type) {
        if (this.parsedDLNAHeaders == null) {
            parseHeaders();
        }
        return this.parsedDLNAHeaders.get(type);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public UpnpHeader<?>[] getAsArray(DLNAHeader.Type type) {
        if (this.parsedDLNAHeaders == null) {
            parseHeaders();
        }
        return this.parsedDLNAHeaders.get(type) != null ? (UpnpHeader[]) this.parsedDLNAHeaders.get(type).toArray(new UpnpHeader[this.parsedDLNAHeaders.get(type).size()]) : new UpnpHeader[0];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public <H extends UpnpHeader<?>> H getFirstHeader(DLNAHeader.Type type, Class<H> cls) {
        for (UpnpHeader<?> upnpHeader : getAsArray(type)) {
            H h = (H) upnpHeader;
            if (cls.isAssignableFrom(h.getClass())) {
                return h;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.model.message.UpnpHeaders
    public void log() {
        if (this.logger.n()) {
            super.log();
            Map<DLNAHeader.Type, List<UpnpHeader<?>>> map = this.parsedDLNAHeaders;
            if (map != null && !map.isEmpty()) {
                this.logger.y("########################## PARSED DLNA HEADERS ##########################");
                for (Map.Entry<DLNAHeader.Type, List<UpnpHeader<?>>> entry : this.parsedDLNAHeaders.entrySet()) {
                    this.logger.h("=== TYPE: {}", entry.getKey());
                    Iterator<UpnpHeader<?>> it = entry.getValue().iterator();
                    while (it.hasNext()) {
                        this.logger.h("HEADER: {}", it.next());
                    }
                }
            }
            this.logger.y("####################################################################");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.model.message.UpnpHeaders
    public void parseHeaders() {
        if (this.parsedHeaders == null) {
            super.parseHeaders();
        }
        this.parsedDLNAHeaders = new LinkedHashMap();
        this.logger.q("Parsing all HTTP headers for known UPnP headers: {}", Integer.valueOf(size()));
        for (Map.Entry<String, List<String>> entry : entrySet()) {
            if (entry.getKey() != null) {
                DLNAHeader.Type byHttpName = DLNAHeader.Type.getByHttpName(entry.getKey());
                if (byHttpName == null) {
                    this.logger.q("Ignoring non-UPNP HTTP header: {}", entry.getKey());
                } else {
                    for (String str : entry.getValue()) {
                        DLNAHeader<?> dLNAHeaderNewInstance = DLNAHeader.newInstance(byHttpName, str);
                        if (dLNAHeaderNewInstance == null || dLNAHeaderNewInstance.getValue() == null) {
                            this.logger.f("Ignoring known but non-parsable header (value violates the UDA specification?) '{}': {}", byHttpName.getHttpName(), str);
                        } else {
                            addParsedValue(byHttpName, dLNAHeaderNewInstance);
                        }
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void remove(DLNAHeader.Type type) {
        super.remove((Object) type.getHttpName());
        Map<DLNAHeader.Type, List<UpnpHeader<?>>> map = this.parsedDLNAHeaders;
        if (map != null) {
            map.remove(type);
        }
    }

    /* JADX DEBUG: Method merged with bridge method: put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
    @Override // org.jupnp.model.message.UpnpHeaders, org.jupnp.http.Headers, java.util.Map
    public List<String> put(String str, List<String> list) {
        this.parsedDLNAHeaders = null;
        return super.put(str, list);
    }

    /* JADX DEBUG: Method merged with bridge method: remove(Ljava/lang/Object;)Ljava/lang/Object; */
    @Override // org.jupnp.model.message.UpnpHeaders, org.jupnp.http.Headers, java.util.Map
    public List<String> remove(Object obj) {
        this.parsedDLNAHeaders = null;
        return super.remove(obj);
    }

    public DLNAHeaders(Map<String, List<String>> map) {
        super(map);
        this.logger = n02.l(DLNAHeaders.class.getName());
    }

    public DLNAHeaders(ByteArrayInputStream byteArrayInputStream) {
        super(byteArrayInputStream);
        this.logger = n02.l(DLNAHeaders.class.getName());
    }

    @Override // org.jupnp.model.message.UpnpHeaders, org.jupnp.http.Headers
    public void add(String str, String str2) {
        this.parsedDLNAHeaders = null;
        super.add(str, str2);
    }

    public UpnpHeader<?> getFirstHeader(DLNAHeader.Type type) {
        if (getAsArray(type).length > 0) {
            return getAsArray(type)[0];
        }
        return null;
    }
}
