package org.jupnp.model.message;

import defpackage.j02;
import defpackage.n02;
import java.io.ByteArrayInputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.jupnp.http.Headers;
import org.jupnp.model.message.UpnpHeaders;
import org.jupnp.model.message.header.UpnpHeader;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class UpnpHeaders extends Headers {
    private final j02 logger;
    protected Map<UpnpHeader.Type, List<UpnpHeader>> parsedHeaders;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public UpnpHeaders() {
        this.logger = n02.k(UpnpHeaders.class);
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0002: CONSTRUCTOR  A[MD:():void (c)] (LINE:3) call: java.util.LinkedList.<init>():void type: CONSTRUCTOR */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ List b(UpnpHeader.Type type) {
        return new LinkedList();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void add(UpnpHeader.Type type, UpnpHeader upnpHeader) {
        super.add(type.getHttpName(), upnpHeader.getString());
        if (this.parsedHeaders != null) {
            addParsedValue(type, upnpHeader);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void addParsedValue(UpnpHeader.Type type, UpnpHeader upnpHeader) {
        this.logger.h("Adding parsed header: {}", upnpHeader);
        this.parsedHeaders.computeIfAbsent(type, new Function() { // from class: bx4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return UpnpHeaders.b((UpnpHeader.Type) obj);
            }
        }).add(upnpHeader);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.http.Headers, java.util.Map
    public void clear() {
        this.parsedHeaders = null;
        super.clear();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean containsKey(UpnpHeader.Type type) {
        if (this.parsedHeaders == null) {
            parseHeaders();
        }
        return this.parsedHeaders.containsKey(type);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List<UpnpHeader> get(UpnpHeader.Type type) {
        if (this.parsedHeaders == null) {
            parseHeaders();
        }
        return this.parsedHeaders.get(type);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public UpnpHeader[] getAsArray(UpnpHeader.Type type) {
        if (this.parsedHeaders == null) {
            parseHeaders();
        }
        return this.parsedHeaders.get(type) != null ? (UpnpHeader[]) this.parsedHeaders.get(type).toArray(new UpnpHeader[this.parsedHeaders.get(type).size()]) : new UpnpHeader[0];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public <H extends UpnpHeader> H getFirstHeader(UpnpHeader.Type type, Class<H> cls) {
        for (UpnpHeader upnpHeader : getAsArray(type)) {
            H h = (H) upnpHeader;
            if (cls.isAssignableFrom(h.getClass())) {
                return h;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getFirstHeaderString(UpnpHeader.Type type) {
        UpnpHeader firstHeader = getFirstHeader(type);
        if (firstHeader != null) {
            return firstHeader.getString();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void log() {
        if (this.logger.n()) {
            this.logger.y("############################ RAW HEADERS ###########################");
            for (Map.Entry<String, List<String>> entry : entrySet()) {
                this.logger.h("=== NAME : {}", entry.getKey());
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    this.logger.h("VALUE: {}", it.next());
                }
            }
            Map<UpnpHeader.Type, List<UpnpHeader>> map = this.parsedHeaders;
            if (map != null && !map.isEmpty()) {
                this.logger.y("########################## PARSED HEADERS ##########################");
                for (Map.Entry<UpnpHeader.Type, List<UpnpHeader>> entry2 : this.parsedHeaders.entrySet()) {
                    this.logger.h("=== TYPE: {}", entry2.getKey());
                    Iterator<UpnpHeader> it2 = entry2.getValue().iterator();
                    while (it2.hasNext()) {
                        this.logger.h("HEADER: {}", it2.next());
                    }
                }
            }
            this.logger.y("####################################################################");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void parseHeaders() {
        this.parsedHeaders = new LinkedHashMap();
        this.logger.h("Parsing all HTTP headers for known UPnP headers: {}", Integer.valueOf(size()));
        for (Map.Entry<String, List<String>> entry : entrySet()) {
            if (entry.getKey() != null) {
                UpnpHeader.Type byHttpName = UpnpHeader.Type.getByHttpName(entry.getKey());
                if (byHttpName == null) {
                    this.logger.h("Ignoring non-UPNP HTTP header: {}", entry.getKey());
                } else {
                    for (String str : entry.getValue()) {
                        UpnpHeader upnpHeaderNewInstance = UpnpHeader.newInstance(byHttpName, str);
                        if (upnpHeaderNewInstance == null || upnpHeaderNewInstance.getValue() == null) {
                            this.logger.i("Ignoring known but irrelevant header (value violates the UDA specification?) '{}': {}", byHttpName.getHttpName(), str);
                        } else {
                            addParsedValue(byHttpName, upnpHeaderNewInstance);
                        }
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void remove(UpnpHeader.Type type) {
        super.remove((Object) type.getHttpName());
        Map<UpnpHeader.Type, List<UpnpHeader>> map = this.parsedHeaders;
        if (map != null) {
            map.remove(type);
        }
    }

    /* JADX DEBUG: Method merged with bridge method: put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
    @Override // org.jupnp.http.Headers, java.util.Map
    public List<String> put(String str, List<String> list) {
        this.parsedHeaders = null;
        return super.put(str, list);
    }

    public UpnpHeaders(Map<String, List<String>> map) {
        super(map);
        this.logger = n02.k(UpnpHeaders.class);
    }

    public UpnpHeaders(ByteArrayInputStream byteArrayInputStream) {
        super(byteArrayInputStream);
        this.logger = n02.k(UpnpHeaders.class);
    }

    /* JADX DEBUG: Method merged with bridge method: remove(Ljava/lang/Object;)Ljava/lang/Object; */
    @Override // org.jupnp.http.Headers, java.util.Map
    public List<String> remove(Object obj) {
        this.parsedHeaders = null;
        return super.remove(obj);
    }

    public UpnpHeaders(boolean z) {
        super(z);
        this.logger = n02.k(UpnpHeaders.class);
    }

    @Override // org.jupnp.http.Headers
    public void add(String str, String str2) {
        this.parsedHeaders = null;
        super.add(str, str2);
    }

    public UpnpHeader getFirstHeader(UpnpHeader.Type type) {
        if (getAsArray(type).length > 0) {
            return getAsArray(type)[0];
        }
        return null;
    }
}
