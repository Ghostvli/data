package net.engio.mbassy.dispatch.el;

import javax.el.ExpressionFactory;
import net.engio.mbassy.bus.error.PublicationError;
import net.engio.mbassy.listener.IMessageFilter;
import net.engio.mbassy.subscription.SubscriptionContext;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ElFilter implements IMessageFilter {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class ExpressionFactoryHolder {
        public static final ExpressionFactory ELFactory = getELFactory();

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private static final ExpressionFactory getELFactory() {
            try {
                return ExpressionFactory.newInstance();
            } catch (RuntimeException unused) {
                return null;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final ExpressionFactory ELFactory() {
        return ExpressionFactoryHolder.ELFactory;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean evalExpression(String str, StandardELResolutionContext standardELResolutionContext, SubscriptionContext subscriptionContext, Object obj) {
        try {
            return ((Boolean) ELFactory().createValueExpression(standardELResolutionContext, str, Boolean.class).getValue(standardELResolutionContext)).booleanValue();
        } catch (Throwable th) {
            subscriptionContext.handleError(new PublicationError(th, "Error while evaluating EL expression on message", subscriptionContext).setPublishedMessage(obj));
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final boolean isELAvailable() {
        return ExpressionFactoryHolder.ELFactory != null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // net.engio.mbassy.listener.IMessageFilter
    public boolean accepts(Object obj, SubscriptionContext subscriptionContext) {
        return evalExpression(subscriptionContext.getHandler().getCondition(), new StandardELResolutionContext(obj), subscriptionContext, obj);
    }
}
