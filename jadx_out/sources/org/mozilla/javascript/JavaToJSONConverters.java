package org.mozilla.javascript;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.function.UnaryOperator;
import org.mozilla.javascript.JavaToJSONConverters;
import org.mozilla.javascript.Undefined;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class JavaToJSONConverters {
    public static final UnaryOperator<Object> STRING = new UnaryOperator() { // from class: cn1
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return obj.toString();
        }
    };
    public static final UnaryOperator<Object> UNDEFINED = new UnaryOperator() { // from class: dn1
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return Undefined.instance;
        }
    };
    public static final UnaryOperator<Object> EMPTY_OBJECT = new UnaryOperator() { // from class: en1
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return Collections.EMPTY_MAP;
        }
    };
    public static final UnaryOperator<Object> THROW_TYPE_ERROR = new UnaryOperator() { // from class: fn1
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return JavaToJSONConverters.b(obj);
        }
    };
    public static final UnaryOperator<Object> BEAN = new UnaryOperator() { // from class: gn1
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return JavaToJSONConverters.lambda$static$4(obj);
        }
    };

    private JavaToJSONConverters() {
    }

    public static /* synthetic */ Object b(Object obj) {
        throw ScriptRuntime.typeErrorById("msg.json.cant.serialize", obj.getClass().getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$static$4(Object obj) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass(), Object.class);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (PropertyDescriptor propertyDescriptor : beanInfo.getPropertyDescriptors()) {
                if (propertyDescriptor.getReadMethod() != null) {
                    try {
                        linkedHashMap.put(propertyDescriptor.getName(), propertyDescriptor.getReadMethod().invoke(obj, null));
                    } catch (Exception unused) {
                    }
                }
            }
            if (linkedHashMap.size() == 0) {
                return null;
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.put("beanClass", beanInfo.getBeanDescriptor().getBeanClass().getName());
            linkedHashMap2.put("properties", linkedHashMap);
            return linkedHashMap2;
        } catch (IntrospectionException unused2) {
            return null;
        }
    }
}
