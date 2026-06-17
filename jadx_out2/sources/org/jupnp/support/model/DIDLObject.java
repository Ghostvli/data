package org.jupnp.support.model;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.function.Predicate;
import org.jupnp.support.model.DIDLObject;
import org.w3c.dom.Element;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DIDLObject {
    protected Class clazz;
    protected String creator;
    protected List<DescMeta<?>> descMetadata;
    protected String id;
    protected String parentID;
    protected List<Property<?>> properties;
    protected List<Res> resources;
    protected boolean restricted;
    protected String title;
    protected WriteStatus writeStatus;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DIDLObject(String str, String str2, String str3, String str4, boolean z, WriteStatus writeStatus, Class r8, List<Res> list, List<Property<?>> list2, List<DescMeta<?>> list3) {
        this.restricted = true;
        this.resources = new ArrayList();
        this.properties = new ArrayList();
        new ArrayList();
        this.id = str;
        this.parentID = str2;
        this.title = str3;
        this.creator = str4;
        this.restricted = z;
        this.writeStatus = writeStatus;
        this.clazz = r8;
        this.resources = list;
        this.properties = list2;
        this.descMetadata = list3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DIDLObject addDescMetadata(DescMeta<?> descMeta) {
        getDescMetadata().add(descMeta);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DIDLObject addProperties(Property<?>[] propertyArr) {
        if (propertyArr != null) {
            for (Property<?> property : propertyArr) {
                addProperty(property);
            }
        }
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DIDLObject addProperty(Property property) {
        if (property == null) {
            return this;
        }
        getProperties().add(property);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DIDLObject addResource(Res res) {
        getResources().add(res);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.id.equals(((DIDLObject) obj).id);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Class getClazz() {
        return this.clazz;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getCreator() {
        return this.creator;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List<DescMeta<?>> getDescMetadata() {
        return this.descMetadata;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public <V> Property<V> getFirstProperty(java.lang.Class<? extends Property<V>> cls) {
        Iterator<Property<?>> it = getProperties().iterator();
        while (it.hasNext()) {
            Property<V> property = (Property) it.next();
            if (cls.isInstance(property)) {
                return property;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public <V> V getFirstPropertyValue(java.lang.Class<? extends Property<V>> cls) {
        Property<V> firstProperty = getFirstProperty(cls);
        if (firstProperty == null) {
            return null;
        }
        return firstProperty.getValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Res getFirstResource() {
        if (getResources().isEmpty()) {
            return null;
        }
        return getResources().get(0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getId() {
        return this.id;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public <V> Property<V> getLastProperty(java.lang.Class<? extends Property<V>> cls) {
        Property<V> property = null;
        for (Property<?> property2 : getProperties()) {
            if (cls.isInstance(property2)) {
                property = (Property<V>) property2;
            }
        }
        return property;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getParentID() {
        return this.parentID;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public <V> Property<V>[] getProperties(java.lang.Class<? extends Property<V>> cls) {
        ArrayList arrayList = new ArrayList();
        for (Property<?> property : getProperties()) {
            if (cls.isInstance(property)) {
                arrayList.add(property);
            }
        }
        return (Property[]) arrayList.toArray(new Property[arrayList.size()]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public <V> Property<V>[] getPropertiesByNamespace(java.lang.Class<? extends Property.NAMESPACE> cls) {
        ArrayList arrayList = new ArrayList();
        for (Property<?> property : getProperties()) {
            if (cls.isInstance(property)) {
                arrayList.add(property);
            }
        }
        return (Property[]) arrayList.toArray(new Property[arrayList.size()]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public <V> List<V> getPropertyValues(java.lang.Class<? extends Property<V>> cls) {
        ArrayList arrayList = new ArrayList();
        for (Property<V> property : getProperties(cls)) {
            arrayList.add(property.getValue());
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List<Res> getResources() {
        return this.resources;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getTitle() {
        return this.title;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public WriteStatus getWriteStatus() {
        return this.writeStatus;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean hasProperty(java.lang.Class<? extends Property<?>> cls) {
        Iterator<Property<?>> it = getProperties().iterator();
        while (it.hasNext()) {
            if (cls.isInstance(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return this.id.hashCode();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isRestricted() {
        return this.restricted;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DIDLObject removeProperties(final java.lang.Class<? extends Property<?>> cls) {
        List<Property<?>> properties = getProperties();
        Objects.requireNonNull(cls);
        properties.removeIf(new Predicate() { // from class: t70
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return cls.isInstance((DIDLObject.Property) obj);
            }
        });
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DIDLObject replaceFirstProperty(final Property<?> property) {
        if (property == null) {
            return this;
        }
        getProperties().removeIf(new Predicate() { // from class: s70
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((DIDLObject.Property) obj).getClass().isAssignableFrom(property.getClass());
            }
        });
        addProperty(property);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DIDLObject replaceProperties(java.lang.Class<? extends Property<?>> cls, Property<?>[] propertyArr) {
        if (propertyArr.length == 0) {
            return this;
        }
        removeProperties(cls);
        return addProperties(propertyArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DIDLObject setClazz(Class r1) {
        this.clazz = r1;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DIDLObject setCreator(String str) {
        this.creator = str;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setDescMetadata(List<DescMeta<?>> list) {
        this.descMetadata = list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DIDLObject setId(String str) {
        this.id = str;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DIDLObject setParentID(String str) {
        this.parentID = str;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DIDLObject setProperties(List<Property<?>> list) {
        this.properties = list;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DIDLObject setResources(List<Res> list) {
        this.resources = list;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DIDLObject setRestricted(boolean z) {
        this.restricted = z;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DIDLObject setTitle(String str) {
        this.title = str;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DIDLObject setWriteStatus(WriteStatus writeStatus) {
        this.writeStatus = writeStatus;
        return this;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class Property<V> {
        private final List<Property<DIDLAttribute>> attributes;
        private final String descriptorName;
        private V value;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public interface NAMESPACE {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Property(V v, String str, List<Property<DIDLAttribute>> list) {
            ArrayList arrayList = new ArrayList();
            this.attributes = arrayList;
            this.value = v;
            this.descriptorName = str == null ? getClass().getSimpleName().toLowerCase(Locale.ROOT).replace("didlobject$property$upnp$", "") : str;
            arrayList.addAll(list);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void addAttribute(Property<DIDLAttribute> property) {
            this.attributes.add(property);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Property<DIDLAttribute> getAttribute(String str) {
            for (Property<DIDLAttribute> property : this.attributes) {
                if (property.getDescriptorName().equals(str)) {
                    return property;
                }
            }
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String getDescriptorName() {
            return this.descriptorName;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public V getValue() {
            return this.value;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void removeAttribute(String str) {
            for (Property<DIDLAttribute> property : this.attributes) {
                if (property.getDescriptorName().equals(str)) {
                    removeAttribute(property);
                    return;
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void setOnElement(Element element) {
            element.setTextContent(toString());
            for (Property<DIDLAttribute> property : this.attributes) {
                element.setAttributeNS(property.getValue().getNamespaceURI(), property.getValue().getPrefix() + ":" + property.getDescriptorName(), property.getValue().getValue());
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void setValue(V v) {
            this.value = v;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String toString() {
            return getValue() != null ? getValue().toString() : "";
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static class DC {

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public interface NAMESPACE extends NAMESPACE {
                public static final String URI = "http://purl.org/dc/elements/1.1/";
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class CONTRIBUTOR extends Property<Person> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public CONTRIBUTOR(Person person) {
                    super(person, null);
                }

                public CONTRIBUTOR() {
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class DATE extends Property<String> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public DATE(String str) {
                    super(str, null);
                }

                public DATE() {
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class DESCRIPTION extends Property<String> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public DESCRIPTION(String str) {
                    super(str, null);
                }

                public DESCRIPTION() {
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class LANGUAGE extends Property<String> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public LANGUAGE(String str) {
                    super(str, null);
                }

                public LANGUAGE() {
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class PUBLISHER extends Property<Person> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public PUBLISHER(Person person) {
                    super(person, null);
                }

                public PUBLISHER() {
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class RELATION extends Property<URI> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public RELATION(URI uri) {
                    super(uri, null);
                }

                public RELATION() {
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class RIGHTS extends Property<String> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public RIGHTS(String str) {
                    super(str, null);
                }

                public RIGHTS() {
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static class PropertyPersonWithRole extends Property<PersonWithRole> {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public PropertyPersonWithRole() {
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.jupnp.support.model.DIDLObject.Property
            public void setOnElement(Element element) {
                if (getValue() != null) {
                    getValue().setOnElement(element);
                }
            }

            public PropertyPersonWithRole(String str) {
                super(str);
            }

            public PropertyPersonWithRole(PersonWithRole personWithRole, String str) {
                super(personWithRole, str);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static abstract class UPNP {

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public interface NAMESPACE extends NAMESPACE {
                public static final String URI = "urn:schemas-upnp-org:metadata-1-0/upnp/";
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class ACTOR extends PropertyPersonWithRole implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public ACTOR(PersonWithRole personWithRole) {
                    super(personWithRole, null);
                }

                public ACTOR() {
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class ALBUM extends Property<String> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public ALBUM(String str) {
                    super(str, null);
                }

                public ALBUM() {
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class ARTIST extends PropertyPersonWithRole implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public ARTIST(PersonWithRole personWithRole) {
                    super(personWithRole, null);
                }

                public ARTIST() {
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class AUTHOR extends PropertyPersonWithRole implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public AUTHOR(PersonWithRole personWithRole) {
                    super(personWithRole, null);
                }

                public AUTHOR() {
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class DIRECTOR extends Property<Person> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public DIRECTOR(Person person) {
                    super(person, null);
                }

                public DIRECTOR() {
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class GENRE extends Property<String> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public GENRE(String str) {
                    super(str, null);
                }

                public GENRE() {
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class PLAYLIST extends Property<String> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public PLAYLIST(String str) {
                    super(str, null);
                }

                public PLAYLIST() {
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class PRODUCER extends Property<Person> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public PRODUCER(Person person) {
                    super(person, null);
                }

                public PRODUCER() {
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class RATING extends Property<String> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public RATING(String str) {
                    super(str, null);
                }

                public RATING() {
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class REGION extends Property<String> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public REGION(String str) {
                    super(str, null);
                }

                public REGION() {
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class TOC extends Property<String> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public TOC(String str) {
                    super(str, null);
                }

                public TOC() {
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class ALBUM_ART_URI extends Property<URI> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public ALBUM_ART_URI(URI uri) {
                    super(uri, "albumArtURI");
                }

                public ALBUM_ART_URI() {
                    this(null);
                }

                public ALBUM_ART_URI(URI uri, List<Property<DIDLAttribute>> list) {
                    super(uri, "albumArtURI", list);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class ARTIST_DISCO_URI extends Property<URI> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public ARTIST_DISCO_URI(URI uri) {
                    super(uri, "artistDiscographyURI");
                }

                public ARTIST_DISCO_URI() {
                    this(null);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class CHANNEL_NAME extends Property<String> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public CHANNEL_NAME(String str) {
                    super(str, "channelName");
                }

                public CHANNEL_NAME() {
                    this(null);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class CHANNEL_NR extends Property<Integer> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public CHANNEL_NR(Integer num) {
                    super(num, "channelNr");
                }

                public CHANNEL_NR() {
                    this(null);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class DVD_REGION_CODE extends Property<Integer> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public DVD_REGION_CODE(Integer num) {
                    super(num, "DVDRegionCode");
                }

                public DVD_REGION_CODE() {
                    this(null);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class ICON extends Property<URI> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public ICON(URI uri) {
                    super(uri, "icon");
                }

                public ICON() {
                    this(null);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class LONG_DESCRIPTION extends Property<String> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public LONG_DESCRIPTION(String str) {
                    super(str, "longDescription");
                }

                public LONG_DESCRIPTION() {
                    this(null);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class LYRICS_URI extends Property<URI> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public LYRICS_URI(URI uri) {
                    super(uri, "lyricsURI");
                }

                public LYRICS_URI() {
                    this(null);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class ORIGINAL_TRACK_NUMBER extends Property<Integer> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public ORIGINAL_TRACK_NUMBER(Integer num) {
                    super(num, "originalTrackNumber");
                }

                public ORIGINAL_TRACK_NUMBER() {
                    this(null);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class RADIO_BAND extends Property<String> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public RADIO_BAND(String str) {
                    super(str, "radioBand");
                }

                public RADIO_BAND() {
                    this(null);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class RADIO_CALL_SIGN extends Property<String> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public RADIO_CALL_SIGN(String str) {
                    super(str, "radioCallSign");
                }

                public RADIO_CALL_SIGN() {
                    this(null);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class RADIO_STATION_ID extends Property<String> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public RADIO_STATION_ID(String str) {
                    super(str, "radioStationID");
                }

                public RADIO_STATION_ID() {
                    this(null);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class SCHEDULED_END_TIME extends Property<String> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public SCHEDULED_END_TIME(String str) {
                    super(str, "scheduledEndTime");
                }

                public SCHEDULED_END_TIME() {
                    this(null);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class SCHEDULED_START_TIME extends Property<String> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public SCHEDULED_START_TIME(String str) {
                    super(str, "scheduledStartTime");
                }

                public SCHEDULED_START_TIME() {
                    this(null);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class STORAGE_FREE extends Property<Long> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public STORAGE_FREE(Long l) {
                    super(l, "storageFree");
                }

                public STORAGE_FREE() {
                    this(null);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class STORAGE_MAX_PARTITION extends Property<Long> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public STORAGE_MAX_PARTITION(Long l) {
                    super(l, "storageMaxPartition");
                }

                public STORAGE_MAX_PARTITION() {
                    this(null);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class STORAGE_MEDIUM extends Property<StorageMedium> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public STORAGE_MEDIUM(StorageMedium storageMedium) {
                    super(storageMedium, "storageMedium");
                }

                public STORAGE_MEDIUM() {
                    this(null);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class STORAGE_TOTAL extends Property<Long> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public STORAGE_TOTAL(Long l) {
                    super(l, "storageTotal");
                }

                public STORAGE_TOTAL() {
                    this(null);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class STORAGE_USED extends Property<Long> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public STORAGE_USED(Long l) {
                    super(l, "storageUsed");
                }

                public STORAGE_USED() {
                    this(null);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class USER_ANNOTATION extends Property<String> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public USER_ANNOTATION(String str) {
                    super(str, "userAnnotation");
                }

                public USER_ANNOTATION() {
                    this(null);
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static abstract class DLNA {

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public interface NAMESPACE extends NAMESPACE {
                public static final String URI = "urn:schemas-dlna-org:metadata-1-0/";
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class PROFILE_ID extends Property<DIDLAttribute> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public PROFILE_ID(DIDLAttribute dIDLAttribute) {
                    super(dIDLAttribute, "profileID");
                }

                public PROFILE_ID() {
                    this(null);
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static abstract class SEC {

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public interface NAMESPACE extends NAMESPACE {
                public static final String URI = "http://www.sec.co.kr/";
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class CAPTIONINFO extends Property<URI> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public CAPTIONINFO(URI uri) {
                    super(uri, "CaptionInfo");
                }

                public CAPTIONINFO() {
                    this(null);
                }

                public CAPTIONINFO(URI uri, List<Property<DIDLAttribute>> list) {
                    super(uri, "CaptionInfo", list);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class CAPTIONINFOEX extends Property<URI> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public CAPTIONINFOEX(URI uri) {
                    super(uri, "CaptionInfoEx");
                }

                public CAPTIONINFOEX() {
                    this(null);
                }

                public CAPTIONINFOEX(URI uri, List<Property<DIDLAttribute>> list) {
                    super(uri, "CaptionInfoEx", list);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static class TYPE extends Property<DIDLAttribute> implements NAMESPACE {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public TYPE(DIDLAttribute dIDLAttribute) {
                    super(dIDLAttribute, "type");
                }

                public TYPE() {
                    this(null);
                }
            }
        }

        public void removeAttribute(Property<DIDLAttribute> property) {
            this.attributes.remove(property);
        }

        public Property(String str) {
            this(null, str);
        }

        public Property(V v, String str) {
            this.attributes = new ArrayList();
            this.value = v;
            this.descriptorName = str == null ? getClass().getSimpleName().toLowerCase(Locale.ROOT).replace("didlobject$property$upnp$", "") : str;
        }

        public Property() {
            this(null, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Class {
        protected String friendlyName;
        protected boolean includeDerived;
        protected String value;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Class(String str, String str2, boolean z) {
            this.value = str;
            this.friendlyName = str2;
            this.includeDerived = z;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean equals(DIDLObject dIDLObject) {
            return getValue().equals(dIDLObject.getClazz().getValue());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String getFriendlyName() {
            return this.friendlyName;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String getValue() {
            return this.value;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean isIncludeDerived() {
            return this.includeDerived;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void setFriendlyName(String str) {
            this.friendlyName = str;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void setIncludeDerived(boolean z) {
            this.includeDerived = z;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void setValue(String str) {
            this.value = str;
        }

        public Class(String str) {
            this.value = str;
        }

        public Class(String str, String str2) {
            this.value = str;
            this.friendlyName = str2;
        }

        public Class() {
        }
    }

    public DIDLObject(DIDLObject dIDLObject) {
        this(dIDLObject.getId(), dIDLObject.getParentID(), dIDLObject.getTitle(), dIDLObject.getCreator(), dIDLObject.isRestricted(), dIDLObject.getWriteStatus(), dIDLObject.getClazz(), dIDLObject.getResources(), dIDLObject.getProperties(), dIDLObject.getDescMetadata());
    }

    public List<Property<?>> getProperties() {
        return this.properties;
    }

    public DIDLObject() {
        this.restricted = true;
        this.resources = new ArrayList();
        this.properties = new ArrayList();
        this.descMetadata = new ArrayList();
    }
}
