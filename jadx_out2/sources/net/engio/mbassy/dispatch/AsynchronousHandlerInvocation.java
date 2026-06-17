package net.engio.mbassy.dispatch;

import java.util.concurrent.ExecutorService;
import net.engio.mbassy.bus.MessagePublication;
import net.engio.mbassy.bus.config.IBusConfiguration;
import net.engio.mbassy.subscription.AbstractSubscriptionContextAware;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class AsynchronousHandlerInvocation extends AbstractSubscriptionContextAware implements IHandlerInvocation {
    private final IHandlerInvocation delegate;
    private final ExecutorService executor;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AsynchronousHandlerInvocation(IHandlerInvocation iHandlerInvocation) {
        super(iHandlerInvocation.getContext());
        this.delegate = iHandlerInvocation;
        this.executor = (ExecutorService) iHandlerInvocation.getContext().getRuntime().get(IBusConfiguration.Properties.AsynchronousHandlerExecutor);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // net.engio.mbassy.dispatch.IHandlerInvocation
    public void invoke(final Object obj, final Object obj2, final MessagePublication messagePublication) {
        this.executor.execute(new Runnable() { // from class: net.engio.mbassy.dispatch.AsynchronousHandlerInvocation.1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public void run() {
                AsynchronousHandlerInvocation.this.delegate.invoke(obj, obj2, messagePublication);
            }
        });
    }
}
