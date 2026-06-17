package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.stream.Format;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class ParameterFactory {
    private final Format format;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ParameterFactory(Support support) {
        this.format = support.getFormat();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private ParameterBuilder getBuilder(Annotation annotation) throws PersistenceException {
        if (annotation instanceof Element) {
            return new ParameterBuilder(ElementParameter.class, Element.class);
        }
        if (annotation instanceof ElementList) {
            return new ParameterBuilder(ElementListParameter.class, ElementList.class);
        }
        if (annotation instanceof ElementArray) {
            return new ParameterBuilder(ElementArrayParameter.class, ElementArray.class);
        }
        if (annotation instanceof ElementMapUnion) {
            return new ParameterBuilder(ElementMapUnionParameter.class, ElementMapUnion.class, ElementMap.class);
        }
        if (annotation instanceof ElementListUnion) {
            return new ParameterBuilder(ElementListUnionParameter.class, ElementListUnion.class, ElementList.class);
        }
        if (annotation instanceof ElementUnion) {
            return new ParameterBuilder(ElementUnionParameter.class, ElementUnion.class, Element.class);
        }
        if (annotation instanceof ElementMap) {
            return new ParameterBuilder(ElementMapParameter.class, ElementMap.class);
        }
        if (annotation instanceof Attribute) {
            return new ParameterBuilder(AttributeParameter.class, Attribute.class);
        }
        if (annotation instanceof Text) {
            return new ParameterBuilder(TextParameter.class, Text.class);
        }
        throw new PersistenceException("Annotation %s not supported", annotation);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private Constructor getConstructor(Annotation annotation) {
        Constructor constructor = getBuilder(annotation).getConstructor();
        if (!constructor.isAccessible()) {
            constructor.setAccessible(true);
        }
        return constructor;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Parameter getInstance(Constructor constructor, Annotation annotation, Annotation annotation2, int i) {
        Constructor constructor2 = getConstructor(annotation);
        Format format = this.format;
        return annotation2 != null ? (Parameter) constructor2.newInstance(constructor, annotation, annotation2, format, Integer.valueOf(i)) : (Parameter) constructor2.newInstance(constructor, annotation, format, Integer.valueOf(i));
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class ParameterBuilder {
        private final Class entry;
        private final Class label;
        private final Class type;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public ParameterBuilder(Class cls, Class cls2, Class cls3) {
            this.label = cls2;
            this.entry = cls3;
            this.type = cls;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Constructor getConstructor() {
            Class cls = this.entry;
            Class cls2 = this.label;
            return cls != null ? getConstructor(cls2, cls) : getConstructor(cls2);
        }

        public ParameterBuilder(Class cls, Class cls2) {
            this(cls, cls2, null);
        }

        public Constructor getConstructor(Class cls) {
            return getConstructor(Constructor.class, cls, Format.class, Integer.TYPE);
        }

        public Constructor getConstructor(Class cls, Class cls2) {
            return getConstructor(Constructor.class, cls, cls2, Format.class, Integer.TYPE);
        }

        private Constructor getConstructor(Class... clsArr) {
            return this.type.getConstructor(clsArr);
        }
    }

    public Parameter getInstance(Constructor constructor, Annotation annotation, int i) {
        return getInstance(constructor, annotation, null, i);
    }
}
