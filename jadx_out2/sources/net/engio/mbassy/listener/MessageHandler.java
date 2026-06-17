package net.engio.mbassy.listener;

import defpackage.e04;
import defpackage.jl;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import net.engio.mbassy.common.ReflectionUtils;
import net.engio.mbassy.dispatch.HandlerInvocation;
import net.engio.mbassy.dispatch.el.ElFilter;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class MessageHandler {
    private final boolean acceptsSubtypes;
    private final String condition;
    private final IMessageFilter[] filter;
    private final Class[] handledMessages;
    private final Method handler;
    private final Class<? extends HandlerInvocation> invocation;
    private final Invoke invocationMode;
    private final boolean isEnvelope;
    private final boolean isSynchronized;
    private final MessageListener listenerConfig;
    private final int priority;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Properties {
        public static final String AcceptSubtypes = "subtypes";
        public static final String Condition = "condition";
        public static final String Enveloped = "envelope";
        public static final String Filter = "filter";
        public static final String HandledMessages = "messages";
        public static final String HandlerMethod = "handler";
        public static final String Invocation = "invocation";
        public static final String InvocationMode = "invocationMode";
        public static final String IsSynchronized = "synchronized";
        public static final String Listener = "listener";
        public static final String Priority = "priority";

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static final Map<String, Object> Create(Method method, Handler handler, IMessageFilter[] iMessageFilterArr, MessageListener messageListener) {
            if (method == null) {
                jl.a("The message handler configuration may not be null");
                return null;
            }
            if (iMessageFilterArr == null) {
                iMessageFilterArr = new IMessageFilter[0];
            }
            Enveloped enveloped = (Enveloped) ReflectionUtils.getAnnotation(method, Enveloped.class);
            Class[] clsArrMessages = enveloped != null ? enveloped.messages() : method.getParameterTypes();
            method.setAccessible(true);
            HashMap map = new HashMap();
            map.put(HandlerMethod, method);
            if (handler.condition().length() > 0) {
                if (!ElFilter.isELAvailable()) {
                    e04.a("A handler uses an EL filter but no EL implementation is available.");
                    return null;
                }
                IMessageFilter[] iMessageFilterArr2 = new IMessageFilter[iMessageFilterArr.length + 1];
                for (int i = 0; i < iMessageFilterArr.length; i++) {
                    iMessageFilterArr2[i] = iMessageFilterArr[i];
                }
                iMessageFilterArr2[iMessageFilterArr.length] = new ElFilter();
                iMessageFilterArr = iMessageFilterArr2;
            }
            map.put(Filter, iMessageFilterArr);
            map.put(Condition, cleanEL(handler.condition()));
            map.put(Priority, Integer.valueOf(handler.priority()));
            map.put(Invocation, handler.invocation());
            map.put(InvocationMode, handler.delivery());
            map.put(Enveloped, Boolean.valueOf(enveloped != null));
            map.put(AcceptSubtypes, Boolean.valueOf(!handler.rejectSubtypes()));
            map.put(Listener, messageListener);
            map.put(IsSynchronized, Boolean.valueOf(ReflectionUtils.getAnnotation(method, Synchronized.class) != null));
            map.put(HandledMessages, clsArrMessages);
            return map;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private static String cleanEL(String str) {
            if (str.trim().startsWith("${") || str.trim().startsWith("#{")) {
                return str;
            }
            return "${" + str + "}";
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public MessageHandler(Map<String, Object> map) {
        validate(map);
        this.handler = (Method) map.get(Properties.HandlerMethod);
        this.filter = (IMessageFilter[]) map.get(Properties.Filter);
        this.condition = (String) map.get(Properties.Condition);
        this.priority = ((Integer) map.get(Properties.Priority)).intValue();
        this.invocation = (Class) map.get(Properties.Invocation);
        this.invocationMode = (Invoke) map.get(Properties.InvocationMode);
        this.isEnvelope = ((Boolean) map.get(Properties.Enveloped)).booleanValue();
        this.acceptsSubtypes = ((Boolean) map.get(Properties.AcceptSubtypes)).booleanValue();
        this.listenerConfig = (MessageListener) map.get(Properties.Listener);
        this.isSynchronized = ((Boolean) map.get(Properties.IsSynchronized)).booleanValue();
        this.handledMessages = (Class[]) map.get(Properties.HandledMessages);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void validate(Map<String, Object> map) {
        Object[][] objArr = {new Object[]{Properties.HandlerMethod, Method.class}, new Object[]{Properties.Priority, Integer.class}, new Object[]{Properties.Invocation, Class.class}, new Object[]{Properties.Filter, IMessageFilter[].class}, new Object[]{Properties.Condition, String.class}, new Object[]{Properties.Enveloped, Boolean.class}, new Object[]{Properties.HandledMessages, Class[].class}, new Object[]{Properties.IsSynchronized, Boolean.class}, new Object[]{Properties.Listener, MessageListener.class}, new Object[]{Properties.AcceptSubtypes, Boolean.class}};
        for (int i = 0; i < 10; i++) {
            Object[] objArr2 = objArr[i];
            if (map.get(objArr2[0]) == null || !((Class) objArr2[1]).isAssignableFrom(map.get(objArr2[0]).getClass())) {
                StringBuilder sb = new StringBuilder("Property ");
                sb.append(objArr2[0]);
                sb.append(" was expected to be not null and of type ");
                sb.append(objArr2[1]);
                Object obj = map.get(objArr2[0]);
                sb.append(" but was: ");
                sb.append(obj);
                throw new IllegalArgumentException(sb.toString());
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean acceptsSubtypes() {
        return this.acceptsSubtypes;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        return (A) ReflectionUtils.getAnnotation(this.handler, cls);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getCondition() {
        return this.condition;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public IMessageFilter[] getFilter() {
        return this.filter;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Class[] getHandledMessages() {
        return this.handledMessages;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Class<? extends HandlerInvocation> getHandlerInvocation() {
        return this.invocation;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Method getMethod() {
        return this.handler;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getPriority() {
        return this.priority;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean handlesMessage(Class<?> cls) {
        for (Class cls2 : this.handledMessages) {
            if (cls2.equals(cls)) {
                return true;
            }
            if (cls2.isAssignableFrom(cls) && acceptsSubtypes()) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isAsynchronous() {
        return this.invocationMode.equals(Invoke.Asynchronously);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isEnveloped() {
        return this.isEnvelope;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isFiltered() {
        if (this.filter.length > 0) {
            return true;
        }
        String str = this.condition;
        return str != null && str.trim().length() > 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isFromListener(Class cls) {
        return this.listenerConfig.isFromListener(cls);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isSynchronized() {
        return this.isSynchronized;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean useStrongReferences() {
        return this.listenerConfig.useStrongReferences();
    }
}
