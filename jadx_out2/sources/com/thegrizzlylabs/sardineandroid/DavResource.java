package com.thegrizzlylabs.sardineandroid;

import com.thegrizzlylabs.sardineandroid.model.Lockdiscovery;
import com.thegrizzlylabs.sardineandroid.model.Propstat;
import com.thegrizzlylabs.sardineandroid.model.Resourcetype;
import com.thegrizzlylabs.sardineandroid.model.Response;
import com.thegrizzlylabs.sardineandroid.model.Supportedlock;
import com.thegrizzlylabs.sardineandroid.util.SardineUtil;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import okhttp3.internal.http.StatusLine;
import org.w3c.dom.Element;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DavResource {
    public static final long DEFAULT_CONTENT_LENGTH = -1;
    public static final String DEFAULT_CONTENT_TYPE = "application/octet-stream";
    public static final int DEFAULT_STATUS_CODE = 200;
    public static final String HTTPD_UNIX_DIRECTORY_CONTENT_TYPE = "httpd/unix-directory";
    private static final String SEPARATOR = "/";
    private static final Logger log = Logger.getLogger(DavResource.class.getName());
    private final URI href;
    private final DavProperties props;
    private final int status;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DavResource(String str, Date date, Date date2, String str2, Long l, String str3, String str4, List<QName> list, String str5, List<QName> list2, Map<QName, String> map) {
        this.href = new URI(str);
        this.status = 200;
        this.props = new DavProperties(date, date2, str2, l, str3, str4, list, str5, list2, map);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public String getContentLanguage(Response response) {
        List<Propstat> propstat = response.getPropstat();
        if (propstat.isEmpty()) {
            return null;
        }
        for (Propstat propstat2 : propstat) {
            if (propstat2.getProp() != null) {
                Resourcetype resourcetype = propstat2.getProp().getResourcetype();
                return (resourcetype == null || resourcetype.getCollection() == null) ? propstat2.getProp().getGetcontentlanguage() : HTTPD_UNIX_DIRECTORY_CONTENT_TYPE;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public long getContentLength(Response response) {
        String getcontentlength;
        List<Propstat> propstat = response.getPropstat();
        if (propstat.isEmpty()) {
            return -1L;
        }
        Iterator<Propstat> it = propstat.iterator();
        while (it.hasNext()) {
            Propstat next = it.next();
            if (next.getProp() != null && (getcontentlength = next.getProp().getGetcontentlength()) != null) {
                try {
                    return Long.parseLong(getcontentlength);
                } catch (NumberFormatException unused) {
                    log.warning(String.format("Failed to parse content length %s", getcontentlength));
                }
            }
        }
        return -1L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public String getContentType(Response response) {
        List<Propstat> propstat = response.getPropstat();
        if (propstat.isEmpty()) {
            return null;
        }
        for (Propstat propstat2 : propstat) {
            if (propstat2.getProp() != null) {
                Resourcetype resourcetype = propstat2.getProp().getResourcetype();
                if (resourcetype != null && resourcetype.getCollection() != null) {
                    return HTTPD_UNIX_DIRECTORY_CONTENT_TYPE;
                }
                if (propstat2.getProp().getGetcontenttype() != null) {
                    return propstat2.getProp().getGetcontenttype();
                }
            }
        }
        return DEFAULT_CONTENT_TYPE;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public String getCreationDate(Response response) {
        List<Propstat> propstat = response.getPropstat();
        if (propstat.isEmpty()) {
            return null;
        }
        for (Propstat propstat2 : propstat) {
            if (propstat2.getProp() != null) {
                return propstat2.getProp().getCreationdate();
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public Map<QName, String> getCustomProps(Response response) {
        List<Propstat> propstat = response.getPropstat();
        if (propstat.isEmpty()) {
            return null;
        }
        HashMap map = new HashMap();
        for (Propstat propstat2 : propstat) {
            if (propstat2.getProp() != null) {
                for (Element element : propstat2.getProp().getAny()) {
                    map.put(SardineUtil.toQName(element), element.getTextContent());
                }
            }
        }
        return map;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public String getDisplayName(Response response) {
        List<Propstat> propstat = response.getPropstat();
        if (propstat.isEmpty()) {
            return null;
        }
        for (Propstat propstat2 : propstat) {
            if (propstat2.getProp() != null) {
                return propstat2.getProp().getDisplayname();
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public String getEtag(Response response) {
        List<Propstat> propstat = response.getPropstat();
        if (propstat.isEmpty()) {
            return null;
        }
        for (Propstat propstat2 : propstat) {
            if (propstat2.getProp() != null) {
                return propstat2.getProp().getGetetag();
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public Lockdiscovery getLockDiscovery(Response response) {
        List<Propstat> propstat = response.getPropstat();
        if (propstat.isEmpty()) {
            return null;
        }
        for (Propstat propstat2 : propstat) {
            if (propstat2.getProp() != null) {
                return propstat2.getProp().getLockdiscovery();
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public String getModifiedDate(Response response) {
        List<Propstat> propstat = response.getPropstat();
        if (propstat.isEmpty()) {
            return null;
        }
        for (Propstat propstat2 : propstat) {
            if (propstat2.getProp() != null) {
                return propstat2.getProp().getGetlastmodified();
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public List<QName> getResourceTypes(Response response) {
        Resourcetype resourcetype;
        List<Propstat> propstat = response.getPropstat();
        if (propstat.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        for (Propstat propstat2 : propstat) {
            if (propstat2.getProp() != null && (resourcetype = propstat2.getProp().getResourcetype()) != null) {
                if (resourcetype.getCollection() != null) {
                    arrayList.add(SardineUtil.createQNameWithDefaultNamespace("collection"));
                }
                if (resourcetype.getPrincipal() != null) {
                    arrayList.add(SardineUtil.createQNameWithDefaultNamespace("principal"));
                }
                Iterator<Element> it = resourcetype.getAny().iterator();
                while (it.hasNext()) {
                    arrayList.add(SardineUtil.toQName(it.next()));
                }
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private int getStatusCode(Response response) {
        String status = response.getStatus();
        if (status == null || status.isEmpty()) {
            return 200;
        }
        try {
            return StatusLine.Companion.parse(response.getStatus()).code;
        } catch (IOException unused) {
            log.warning(String.format("Failed to parse status line: %s", status));
            return -1;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public Supportedlock getSupportedLock(Response response) {
        List<Propstat> propstat = response.getPropstat();
        if (propstat.isEmpty()) {
            return null;
        }
        for (Propstat propstat2 : propstat) {
            if (propstat2.getProp() != null) {
                return propstat2.getProp().getSupportedlock();
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Date getCreation() {
        return this.props.creation;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Map<QName, String> getCustomPropsNS() {
        return this.props.customProps;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public URI getHref() {
        return this.href;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Date getModified() {
        return this.props.modified;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getName() {
        String path = this.href.getPath();
        try {
            if (path.endsWith("/")) {
                path = path.substring(0, path.length() - 1);
            }
            return path.substring(path.lastIndexOf(47) + 1);
        } catch (StringIndexOutOfBoundsException unused) {
            log.warning(String.format("Failed to parse name from path %s", path));
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getPath() {
        return this.href.getPath();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Supportedlock getSupportedlock() {
        return this.props.supportedLock;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isDirectory() {
        return HTTPD_UNIX_DIRECTORY_CONTENT_TYPE.equals(this.props.contentType);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return getPath();
    }

    public DavResource(Response response) {
        this.href = new URI(response.getHref());
        this.status = getStatusCode(response);
        this.props = new DavProperties(response);
    }

    public String getDisplayName() {
        return this.props.displayName;
    }

    public String getEtag() {
        return this.props.etag;
    }

    public Lockdiscovery getLockDiscovery() {
        return this.props.lockDiscovery;
    }

    public int getStatusCode() {
        return this.status;
    }

    public String getContentLanguage() {
        return this.props.contentLanguage;
    }

    public Long getContentLength() {
        return this.props.contentLength;
    }

    public String getContentType() {
        return this.props.contentType;
    }

    public Map<String, String> getCustomProps() {
        HashMap map = new HashMap();
        Map<QName, String> customPropsNS = getCustomPropsNS();
        for (QName qName : customPropsNS.keySet()) {
            map.put(qName.getLocalPart(), customPropsNS.get(qName));
        }
        return map;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class DavProperties {
        final String contentLanguage;
        final Long contentLength;
        final String contentType;
        final Date creation;
        final Map<QName, String> customProps;
        final String displayName;
        final String etag;
        final Lockdiscovery lockDiscovery;
        final Date modified;
        final List<QName> resourceTypes;
        final Supportedlock supportedLock;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public DavProperties(Response response) {
            this.creation = SardineUtil.parseDate(DavResource.this.getCreationDate(response));
            this.modified = SardineUtil.parseDate(DavResource.this.getModifiedDate(response));
            this.contentType = DavResource.this.getContentType(response);
            this.contentLength = Long.valueOf(DavResource.this.getContentLength(response));
            this.etag = DavResource.this.getEtag(response);
            this.displayName = DavResource.this.getDisplayName(response);
            this.resourceTypes = DavResource.this.getResourceTypes(response);
            this.contentLanguage = DavResource.this.getContentLanguage(response);
            this.customProps = DavResource.this.getCustomProps(response);
            this.lockDiscovery = DavResource.this.getLockDiscovery(response);
            this.supportedLock = DavResource.this.getSupportedLock(response);
        }

        public DavProperties(Date date, Date date2, String str, Long l, String str2, String str3, List<QName> list, String str4, List<QName> list2, Map<QName, String> map) {
            this.creation = date;
            this.modified = date2;
            this.contentType = str;
            this.contentLength = l;
            this.etag = str2;
            this.displayName = str3;
            this.resourceTypes = list;
            this.contentLanguage = str4;
            this.customProps = map;
            this.lockDiscovery = null;
            this.supportedLock = null;
        }
    }

    public List<QName> getResourceTypes() {
        return this.props.resourceTypes;
    }
}
