package net.engio.mbassy.subscription;

import java.lang.reflect.Modifier;
import java.util.Collection;
import net.engio.mbassy.bus.BusRuntime;
import net.engio.mbassy.bus.config.IBusConfiguration;
import net.engio.mbassy.bus.error.MessageBusException;
import net.engio.mbassy.common.StrongConcurrentSet;
import net.engio.mbassy.common.WeakConcurrentSet;
import net.engio.mbassy.dispatch.AsynchronousHandlerInvocation;
import net.engio.mbassy.dispatch.EnvelopedMessageDispatcher;
import net.engio.mbassy.dispatch.FilteredMessageDispatcher;
import net.engio.mbassy.dispatch.HandlerInvocation;
import net.engio.mbassy.dispatch.IHandlerInvocation;
import net.engio.mbassy.dispatch.IMessageDispatcher;
import net.engio.mbassy.dispatch.MessageDispatcher;
import net.engio.mbassy.dispatch.SynchronizedHandlerInvocation;
import net.engio.mbassy.listener.MessageHandler;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SubscriptionFactory {
    public IMessageDispatcher buildDispatcher(SubscriptionContext subscriptionContext, IHandlerInvocation iHandlerInvocation) {
        IMessageDispatcher messageDispatcher = new MessageDispatcher(subscriptionContext, iHandlerInvocation);
        if (subscriptionContext.getHandler().isEnveloped()) {
            messageDispatcher = new EnvelopedMessageDispatcher(messageDispatcher);
        }
        return subscriptionContext.getHandler().isFiltered() ? new FilteredMessageDispatcher(messageDispatcher) : messageDispatcher;
    }

    public IHandlerInvocation buildInvocationForHandler(SubscriptionContext subscriptionContext) throws MessageBusException {
        IHandlerInvocation iHandlerInvocationCreateBaseHandlerInvocation = createBaseHandlerInvocation(subscriptionContext);
        if (subscriptionContext.getHandler().isSynchronized()) {
            iHandlerInvocationCreateBaseHandlerInvocation = new SynchronizedHandlerInvocation(iHandlerInvocationCreateBaseHandlerInvocation);
        }
        return subscriptionContext.getHandler().isAsynchronous() ? new AsynchronousHandlerInvocation(iHandlerInvocationCreateBaseHandlerInvocation) : iHandlerInvocationCreateBaseHandlerInvocation;
    }

    public IHandlerInvocation createBaseHandlerInvocation(SubscriptionContext subscriptionContext) throws MessageBusException {
        Class<? extends HandlerInvocation> handlerInvocation = subscriptionContext.getHandler().getHandlerInvocation();
        if (handlerInvocation.isMemberClass() && !Modifier.isStatic(handlerInvocation.getModifiers())) {
            throw new MessageBusException("The handler invocation must be top level class or nested STATIC inner class");
        }
        try {
            return handlerInvocation.getConstructor(SubscriptionContext.class).newInstance(subscriptionContext);
        } catch (NoSuchMethodException e) {
            throw new MessageBusException("The provided handler invocation did not specify the necessary constructor " + handlerInvocation.getSimpleName() + "(SubscriptionContext);", e);
        } catch (Exception e2) {
            throw new MessageBusException("Could not instantiate the provided handler invocation ".concat(handlerInvocation.getSimpleName()), e2);
        }
    }

    public Subscription createSubscription(BusRuntime busRuntime, MessageHandler messageHandler) throws MessageBusException {
        try {
            SubscriptionContext subscriptionContext = new SubscriptionContext(busRuntime, messageHandler, (Collection) busRuntime.get(IBusConfiguration.Properties.PublicationErrorHandlers));
            return new Subscription(subscriptionContext, buildDispatcher(subscriptionContext, buildInvocationForHandler(subscriptionContext)), messageHandler.useStrongReferences() ? new StrongConcurrentSet() : new WeakConcurrentSet());
        } catch (Exception e) {
            throw new MessageBusException(e);
        }
    }
}
