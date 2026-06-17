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
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return obj.toString();
        }
    };
    public static final UnaryOperator<Object> UNDEFINED = new UnaryOperator() { // from class: dn1
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return Undefined.instance;
        }
    };
    public static final UnaryOperator<Object> EMPTY_OBJECT = new UnaryOperator() { // from class: en1
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return Collections.EMPTY_MAP;
        }
    };
    public static final UnaryOperator<Object> THROW_TYPE_ERROR = new UnaryOperator() { // from class: fn1
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return JavaToJSONConverters.b(obj);
        }
    };
    public static final UnaryOperator<Object> BEAN = new UnaryOperator() { // from class: gn1
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return JavaToJSONConverters.lambda$static$4(obj);
        }
    };

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private JavaToJSONConverters() {
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0012: THROW 
      (wrap:org.mozilla.javascript.EcmaError:0x000e: INVOKE 
      ("msg.json.cant.serialize")
      (wrap:java.lang.Object[]:0x0008: FILLED_NEW_ARRAY 
      (wrap:java.lang.String:0x0004: INVOKE 
      (wrap:java.lang.Class<?>:0x0000: INVOKE (r1v0 java.lang.Object) VIRTUAL call: java.lang.Object.getClass():java.lang.Class A[MD:():java.lang.Class<?> (c), WRAPPED] (LINE:1))
     VIRTUAL call: java.lang.Class.getName():java.lang.String A[MD:():java.lang.String (c), WRAPPED] (LINE:5))
     A[WRAPPED] (LINE:9) elemType: java.lang.Object)
     STATIC call: org.mozilla.javascript.ScriptRuntime.typeErrorById(java.lang.String, java.lang.Object[]):org.mozilla.javascript.EcmaError A[MD:(java.lang.String, java.lang.Object[]):org.mozilla.javascript.EcmaError VARARG (m), VARARG_CALL, WRAPPED] (LINE:15))
     (LINE:19) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ Object b(Object obj) {
        throw ScriptRuntime.typeErrorById("msg.json.cant.serialize", obj.getClass().getName());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
