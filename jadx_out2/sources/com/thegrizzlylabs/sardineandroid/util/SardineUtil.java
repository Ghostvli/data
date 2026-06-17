package com.thegrizzlylabs.sardineandroid.util;

import com.thegrizzlylabs.sardineandroid.model.Prop;
import com.thegrizzlylabs.sardineandroid.model.Property;
import com.thegrizzlylabs.sardineandroid.model.Resourcetype;
import defpackage.cx4;
import j$.util.DesugarTimeZone;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.Registry;
import org.simpleframework.xml.convert.RegistryStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class SardineUtil {
    public static final String CUSTOM_NAMESPACE_PREFIX = "s";
    public static final String CUSTOM_NAMESPACE_URI = "SAR:";
    private static final List<ThreadLocal<SimpleDateFormat>> DATETIME_FORMATS;
    public static final String DEFAULT_NAMESPACE_PREFIX = "D";
    public static final String DEFAULT_NAMESPACE_URI = "DAV:";
    private static final String[] SUPPORTED_DATE_FORMATS;
    private static final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        String[] strArr = {"yyyy-MM-dd'T'HH:mm:ss'Z'", "EEE, dd MMM yyyy HH:mm:ss zzz", "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", "yyyy-MM-dd'T'HH:mm:ssZ", "EEE MMM dd HH:mm:ss zzz yyyy", "EEEEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMMM d HH:mm:ss yyyy"};
        SUPPORTED_DATE_FORMATS = strArr;
        ArrayList arrayList = new ArrayList(strArr.length);
        for (int i = 0; i < SUPPORTED_DATE_FORMATS.length; i++) {
            arrayList.add(new ThreadLocal());
        }
        DATETIME_FORMATS = Collections.unmodifiableList(arrayList);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private SardineUtil() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Document createDocument() {
        try {
            return factory.newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException e) {
            cx4.a(e.getMessage(), e);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Element createElement(QName qName) {
        return createDocument().createElementNS(qName.getNamespaceURI(), qName.getPrefix() + ":" + qName.getLocalPart());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static QName createQNameWithCustomNamespace(String str) {
        return new QName(CUSTOM_NAMESPACE_URI, str, CUSTOM_NAMESPACE_PREFIX);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static QName createQNameWithDefaultNamespace(String str) {
        return new QName(DEFAULT_NAMESPACE_URI, str, DEFAULT_NAMESPACE_PREFIX);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Serializer getSerializer() {
        Format format = new Format("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        Registry registry = new Registry();
        Persister persister = new Persister(new RegistryStrategy(registry), format);
        registry.bind(Prop.class, new EntityWithAnyElementConverter(persister, Prop.class));
        registry.bind(Resourcetype.class, new EntityWithAnyElementConverter(persister, Resourcetype.class));
        registry.bind(Property.class, Property.PropertyConverter.class);
        return persister;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Date parseDate(String str) {
        Date date = null;
        if (str == null) {
            return null;
        }
        int i = 0;
        while (true) {
            List<ThreadLocal<SimpleDateFormat>> list = DATETIME_FORMATS;
            if (i >= list.size()) {
                break;
            }
            ThreadLocal<SimpleDateFormat> threadLocal = list.get(i);
            SimpleDateFormat simpleDateFormat = threadLocal.get();
            if (simpleDateFormat == null) {
                simpleDateFormat = new SimpleDateFormat(SUPPORTED_DATE_FORMATS[i], Locale.US);
                simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
                threadLocal.set(simpleDateFormat);
            }
            try {
                continue;
                date = simpleDateFormat.parse(str);
                break;
            } catch (ParseException unused) {
                i++;
            }
        }
        return date;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Charset standardUTF8() {
        return StandardCharsets.UTF_8;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static QName toQName(Element element) {
        return element.getNamespaceURI() == null ? new QName(DEFAULT_NAMESPACE_URI, element.getLocalName(), DEFAULT_NAMESPACE_PREFIX) : element.getPrefix() == null ? new QName(element.getNamespaceURI(), element.getLocalName()) : new QName(element.getNamespaceURI(), element.getLocalName(), element.getPrefix());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String toXml(Object obj) {
        StringWriter stringWriter = new StringWriter();
        try {
            getSerializer().write(obj, stringWriter);
            return stringWriter.toString();
        } catch (Exception e) {
            cx4.a(e.getMessage(), e);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static <T> T unmarshal(Class<? extends T> cls, InputStream inputStream) throws IOException {
        try {
            return (T) getSerializer().read((Class) cls, inputStream);
        } catch (SAXException e) {
            cx4.a(e.getMessage(), e);
            return null;
        } catch (Exception e2) {
            throw new IOException("Not a valid DAV response", e2);
        }
    }

    public static Element createElement(Element element, QName qName) {
        return element.getOwnerDocument().createElementNS(qName.getNamespaceURI(), qName.getPrefix() + ":" + qName.getLocalPart());
    }

    public static List<QName> toQName(List<String> list) {
        if (list == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(createQNameWithCustomNamespace(it.next()));
        }
        return arrayList;
    }

    public static Map<QName, String> toQName(Map<String, String> map) {
        if (map == null) {
            return Collections.EMPTY_MAP;
        }
        HashMap map2 = new HashMap(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            map2.put(createQNameWithCustomNamespace(entry.getKey()), entry.getValue());
        }
        return map2;
    }
}
