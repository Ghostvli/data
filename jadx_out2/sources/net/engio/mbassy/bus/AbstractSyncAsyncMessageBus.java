package net.engio.mbassy.bus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import net.engio.mbassy.bus.common.IMessageBus;
import net.engio.mbassy.bus.config.ConfigurationError;
import net.engio.mbassy.bus.config.Feature;
import net.engio.mbassy.bus.config.IBusConfiguration;
import net.engio.mbassy.bus.error.InternalPublicationError;
import net.engio.mbassy.bus.publication.ISyncAsyncPublicationCommand;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractSyncAsyncMessageBus<T, P extends ISyncAsyncPublicationCommand> extends AbstractPubSubSupport<T> implements IMessageBus<T, P> {
    private final List<Thread> dispatchers;
    private final ExecutorService executor;
    private final BlockingQueue<IMessagePublication> pendingMessages;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AbstractSyncAsyncMessageBus(IBusConfiguration iBusConfiguration) {
        super(iBusConfiguration);
        Feature.AsynchronousMessageDispatch asynchronousMessageDispatch = (Feature.AsynchronousMessageDispatch) iBusConfiguration.getFeature(Feature.AsynchronousMessageDispatch.class);
        if (asynchronousMessageDispatch == null) {
            throw ConfigurationError.MissingFeature(Feature.AsynchronousMessageDispatch.class);
        }
        this.pendingMessages = asynchronousMessageDispatch.getMessageQueue();
        this.dispatchers = new ArrayList(asynchronousMessageDispatch.getNumberOfMessageDispatchers());
        initDispatcherThreads(asynchronousMessageDispatch);
        Feature.AsynchronousHandlerInvocation asynchronousHandlerInvocation = (Feature.AsynchronousHandlerInvocation) iBusConfiguration.getFeature(Feature.AsynchronousHandlerInvocation.class);
        if (asynchronousHandlerInvocation == null) {
            throw ConfigurationError.MissingFeature(Feature.AsynchronousHandlerInvocation.class);
        }
        ExecutorService executor = asynchronousHandlerInvocation.getExecutor();
        this.executor = executor;
        getRuntime().add(IBusConfiguration.Properties.AsynchronousHandlerExecutor, executor);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void initDispatcherThreads(Feature.AsynchronousMessageDispatch asynchronousMessageDispatch) {
        for (int i = 0; i < asynchronousMessageDispatch.getNumberOfMessageDispatchers(); i++) {
            Thread threadNewThread = asynchronousMessageDispatch.getDispatcherThreadFactory().newThread(new Runnable() { // from class: net.engio.mbassy.bus.AbstractSyncAsyncMessageBus.1
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public void run() {
                    IMessagePublication iMessagePublication;
                    Throwable th;
                    while (true) {
                        try {
                            try {
                                iMessagePublication = (IMessagePublication) AbstractSyncAsyncMessageBus.this.pendingMessages.take();
                                try {
                                    iMessagePublication.execute();
                                } catch (Throwable th2) {
                                    th = th2;
                                    AbstractSyncAsyncMessageBus.this.handlePublicationError(new InternalPublicationError(th, "Error in asynchronous dispatch", iMessagePublication));
                                }
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                                return;
                            }
                        } catch (Throwable th3) {
                            iMessagePublication = null;
                            th = th3;
                        }
                    }
                }
            });
            threadNewThread.setName("MsgDispatcher-" + i);
            this.dispatchers.add(threadNewThread);
            threadNewThread.start();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public IMessagePublication addAsynchronousPublication(MessagePublication messagePublication, long j, TimeUnit timeUnit) {
        try {
            return this.pendingMessages.offer(messagePublication, j, timeUnit) ? messagePublication.markScheduled() : messagePublication;
        } catch (InterruptedException e) {
            this.handlePublicationError(new InternalPublicationError(e, "Error while adding an asynchronous message publication", messagePublication));
            return messagePublication;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void finalize() throws Throwable {
        super.finalize();
        shutdown();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // net.engio.mbassy.bus.common.IMessageBus
    public boolean hasPendingMessages() {
        return this.pendingMessages.size() > 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // net.engio.mbassy.bus.common.IMessageBus
    public void shutdown() {
        Iterator<Thread> it = this.dispatchers.iterator();
        while (it.hasNext()) {
            it.next().interrupt();
        }
        ExecutorService executorService = this.executor;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public IMessagePublication addAsynchronousPublication(MessagePublication messagePublication) {
        try {
            this.pendingMessages.put(messagePublication);
            return messagePublication.markScheduled();
        } catch (InterruptedException e) {
            this.handlePublicationError(new InternalPublicationError(e, "Error while adding an asynchronous message publication", messagePublication));
            return messagePublication;
        }
    }
}
