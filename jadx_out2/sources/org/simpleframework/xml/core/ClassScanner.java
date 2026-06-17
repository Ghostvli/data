package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class ClassScanner {
    private Function commit;
    private Function complete;
    private NamespaceDecorator decorator = new NamespaceDecorator();
    private Order order;
    private Function persist;
    private Function replace;
    private Function resolve;
    private Root root;
    private ConstructorScanner scanner;
    private Support support;
    private Function validate;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ClassScanner(Detail detail, Support support) {
        this.scanner = new ConstructorScanner(detail, support);
        this.support = support;
        scan(detail);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void commit(Detail detail) {
        Namespace namespace = detail.getNamespace();
        if (namespace != null) {
            this.decorator.set(namespace);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void complete(Method method) {
        if (this.complete == null) {
            this.complete = getFunction(method);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void definition(Detail detail) {
        if (this.root == null) {
            this.root = detail.getRoot();
        }
        if (this.order == null) {
            this.order = detail.getOrder();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private Function getFunction(Method method) {
        boolean zIsContextual = isContextual(method);
        if (!method.isAccessible()) {
            method.setAccessible(true);
        }
        return new Function(method, zIsContextual);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean isContextual(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length == 1) {
            return Map.class.equals(parameterTypes[0]);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void method(MethodDetail methodDetail) {
        Annotation[] annotations = methodDetail.getAnnotations();
        Method method = methodDetail.getMethod();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Commit) {
                commit(method);
            }
            if (annotation instanceof Validate) {
                validate(method);
            }
            if (annotation instanceof Persist) {
                persist(method);
            }
            if (annotation instanceof Complete) {
                complete(method);
            }
            if (annotation instanceof Replace) {
                replace(method);
            }
            if (annotation instanceof Resolve) {
                resolve(method);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void namespace(Detail detail) {
        NamespaceList namespaceList = detail.getNamespaceList();
        Namespace namespace = detail.getNamespace();
        if (namespace != null) {
            this.decorator.add(namespace);
        }
        if (namespaceList != null) {
            for (Namespace namespace2 : namespaceList.value()) {
                this.decorator.add(namespace2);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void persist(Method method) {
        if (this.persist == null) {
            this.persist = getFunction(method);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void replace(Method method) {
        if (this.replace == null) {
            this.replace = getFunction(method);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void resolve(Method method) {
        if (this.resolve == null) {
            this.resolve = getFunction(method);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void scan(Detail detail) {
        DefaultType override = detail.getOverride();
        Class type = detail.getType();
        while (type != null) {
            Detail detail2 = this.support.getDetail(type, override);
            namespace(detail2);
            method(detail2);
            definition(detail2);
            type = detail2.getSuper();
        }
        commit(detail);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void validate(Method method) {
        if (this.validate == null) {
            this.validate = getFunction(method);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Function getCommit() {
        return this.commit;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Function getComplete() {
        return this.complete;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Decorator getDecorator() {
        return this.decorator;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Order getOrder() {
        return this.order;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ParameterMap getParameters() {
        return this.scanner.getParameters();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Function getPersist() {
        return this.persist;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Function getReplace() {
        return this.replace;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Function getResolve() {
        return this.resolve;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Root getRoot() {
        return this.root;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Signature getSignature() {
        return this.scanner.getSignature();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List<Signature> getSignatures() {
        return this.scanner.getSignatures();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Function getValidate() {
        return this.validate;
    }

    private void commit(Method method) {
        if (this.commit == null) {
            this.commit = getFunction(method);
        }
    }

    private void method(Detail detail) {
        Iterator<MethodDetail> it = detail.getMethods().iterator();
        while (it.hasNext()) {
            method(it.next());
        }
    }
}
