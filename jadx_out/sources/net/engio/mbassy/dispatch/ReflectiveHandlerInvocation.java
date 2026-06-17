package net.engio.mbassy.dispatch;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.engio.mbassy.bus.MessagePublication;
import net.engio.mbassy.bus.error.PublicationError;
import net.engio.mbassy.subscription.SubscriptionContext;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ReflectiveHandlerInvocation extends HandlerInvocation {
    public ReflectiveHandlerInvocation(SubscriptionContext subscriptionContext) {
        super(subscriptionContext);
    }

    @Override // net.engio.mbassy.dispatch.IHandlerInvocation
    public void invoke(Object obj, Object obj2, MessagePublication messagePublication) {
        Object obj3;
        MessagePublication messagePublication2;
        InvocationTargetException invocationTargetException;
        Object obj4;
        MessagePublication messagePublication3;
        IllegalAccessException illegalAccessException;
        Method method = getContext().getHandler().getMethod();
        try {
            try {
                try {
                    method.invoke(obj, obj2);
                } catch (IllegalAccessException e) {
                    obj4 = obj;
                    illegalAccessException = e;
                    messagePublication3 = messagePublication;
                    handlePublicationError(messagePublication3, new PublicationError(illegalAccessException, "Error during invocation of message handler. The class or method is not accessible", method, obj4, messagePublication3));
                } catch (InvocationTargetException e2) {
                    obj3 = obj;
                    invocationTargetException = e2;
                    messagePublication2 = messagePublication;
                    handlePublicationError(messagePublication2, new PublicationError(invocationTargetException, "Error during invocation of message handler. There might be an access rights problem. Do you use non public inner classes?", method, obj3, messagePublication2));
                }
            } catch (IllegalAccessException e3) {
                obj4 = obj;
                messagePublication3 = messagePublication;
                illegalAccessException = e3;
            } catch (InvocationTargetException e4) {
                obj3 = obj;
                messagePublication2 = messagePublication;
                invocationTargetException = e4;
            }
        } catch (IllegalArgumentException e5) {
            handlePublicationError(messagePublication, new PublicationError(e5, "Error during invocation of message handler. Wrong arguments passed to method. Was: " + obj2.getClass() + "Expected: " + method.getParameterTypes()[0], method, obj, messagePublication));
        } catch (Throwable th) {
            handlePublicationError(messagePublication, new PublicationError(th, "Error during invocation of message handler. The handler code threw an exception", method, obj, messagePublication));
        }
    }
}
