package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.Text;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class SignatureScanner {
    private final SignatureBuilder builder;
    private final Constructor constructor;
    private final ParameterFactory factory;
    private final ParameterMap registry;
    private final Class type;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SignatureScanner(Constructor constructor, ParameterMap parameterMap, Support support) {
        this.builder = new SignatureBuilder(constructor);
        this.factory = new ParameterFactory(support);
        Class declaringClass = constructor.getDeclaringClass();
        this.type = declaringClass;
        this.constructor = constructor;
        this.registry = parameterMap;
        scan(declaringClass);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private List<Parameter> create(Annotation annotation, int i) throws ConstructorException {
        Parameter parameterFactory = this.factory.getInstance(this.constructor, annotation, i);
        if (parameterFactory != null) {
            register(parameterFactory);
        }
        return Collections.singletonList(parameterFactory);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private Annotation[] extract(Annotation annotation) throws UnionException {
        Method[] declaredMethods = annotation.annotationType().getDeclaredMethods();
        if (declaredMethods.length == 1) {
            return (Annotation[]) declaredMethods[0].invoke(annotation, null);
        }
        throw new UnionException("Annotation '%s' is not a valid union for %s", annotation, this.type);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private List<Parameter> process(Annotation annotation, int i) {
        return annotation instanceof Attribute ? create(annotation, i) : annotation instanceof Element ? create(annotation, i) : annotation instanceof ElementList ? create(annotation, i) : annotation instanceof ElementArray ? create(annotation, i) : annotation instanceof ElementMap ? create(annotation, i) : annotation instanceof ElementListUnion ? union(annotation, i) : annotation instanceof ElementMapUnion ? union(annotation, i) : annotation instanceof ElementUnion ? union(annotation, i) : annotation instanceof Text ? create(annotation, i) : Collections.EMPTY_LIST;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void register(Parameter parameter) throws ConstructorException {
        String path = parameter.getPath();
        Object key = parameter.getKey();
        if (this.registry.containsKey(key)) {
            validate(parameter, key);
        }
        if (this.registry.containsKey(path)) {
            validate(parameter, path);
        }
        this.registry.put(path, parameter);
        this.registry.put(key, parameter);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void scan(Class cls, int i) {
        Annotation[][] parameterAnnotations = this.constructor.getParameterAnnotations();
        int i2 = 0;
        while (true) {
            Annotation[] annotationArr = parameterAnnotations[i];
            if (i2 >= annotationArr.length) {
                return;
            }
            Iterator<Parameter> it = process(annotationArr[i2], i).iterator();
            while (it.hasNext()) {
                this.builder.insert(it.next(), i);
            }
            i2++;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private List<Parameter> union(Annotation annotation, int i) throws UnionException, ConstructorException {
        Signature signature = new Signature(this.constructor);
        for (Annotation annotation2 : extract(annotation)) {
            Parameter parameterFactory = this.factory.getInstance(this.constructor, annotation, annotation2, i);
            String path = parameterFactory.getPath();
            if (signature.contains(path)) {
                throw new UnionException("Annotation name '%s' used more than once in %s for %s", path, annotation, this.type);
            }
            signature.set(path, parameterFactory);
            register(parameterFactory);
        }
        return signature.getAll();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void validate(Parameter parameter, Object obj) throws ConstructorException {
        Parameter parameter2 = this.registry.get(obj);
        if (parameter.isText() != parameter2.isText()) {
            Annotation annotation = parameter.getAnnotation();
            Annotation annotation2 = parameter2.getAnnotation();
            String path = parameter.getPath();
            if (!annotation.equals(annotation2)) {
                throw new ConstructorException("Annotations do not match for '%s' in %s", path, this.type);
            }
            if (parameter2.getType() != parameter.getType()) {
                throw new ConstructorException("Parameter types do not match for '%s' in %s", path, this.type);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List<Signature> getSignatures() {
        return this.builder.build();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isValid() {
        return this.builder.isValid();
    }

    private void scan(Class cls) {
        Class<?>[] parameterTypes = this.constructor.getParameterTypes();
        for (int i = 0; i < parameterTypes.length; i++) {
            scan(parameterTypes[i], i);
        }
    }
}
