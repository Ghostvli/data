package net.engio.mbassy.bus.config;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import net.engio.mbassy.bus.IMessagePublication;
import net.engio.mbassy.bus.MessagePublication;
import net.engio.mbassy.listener.MetadataReader;
import net.engio.mbassy.subscription.ISubscriptionManagerProvider;
import net.engio.mbassy.subscription.SubscriptionFactory;
import net.engio.mbassy.subscription.SubscriptionManagerProvider;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface Feature {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class AsynchronousMessageDispatch implements Feature {
        protected static final ThreadFactory MessageDispatchThreadFactory = new ThreadFactory() { // from class: net.engio.mbassy.bus.config.Feature.AsynchronousMessageDispatch.1
            private final AtomicInteger threadID = new AtomicInteger(0);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread threadNewThread = Executors.defaultThreadFactory().newThread(runnable);
                threadNewThread.setDaemon(true);
                threadNewThread.setName("Dispatcher-" + this.threadID.getAndIncrement());
                return threadNewThread;
            }
        };
        private ThreadFactory dispatcherThreadFactory;
        private BlockingQueue<IMessagePublication> messageQueue;
        private int numberOfMessageDispatchers;

        public static final AsynchronousMessageDispatch Default() {
            return new AsynchronousMessageDispatch().setNumberOfMessageDispatchers(2).setDispatcherThreadFactory(MessageDispatchThreadFactory).setMessageQueue(new LinkedBlockingQueue(Integer.MAX_VALUE));
        }

        public ThreadFactory getDispatcherThreadFactory() {
            return this.dispatcherThreadFactory;
        }

        public BlockingQueue<IMessagePublication> getMessageQueue() {
            return this.messageQueue;
        }

        public int getNumberOfMessageDispatchers() {
            return this.numberOfMessageDispatchers;
        }

        public AsynchronousMessageDispatch setDispatcherThreadFactory(ThreadFactory threadFactory) {
            this.dispatcherThreadFactory = threadFactory;
            return this;
        }

        public AsynchronousMessageDispatch setMessageQueue(BlockingQueue<IMessagePublication> blockingQueue) {
            this.messageQueue = blockingQueue;
            return this;
        }

        public AsynchronousMessageDispatch setNumberOfMessageDispatchers(int i) {
            this.numberOfMessageDispatchers = i;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class SyncPubSub implements Feature {
        private MetadataReader metadataReader;
        private MessagePublication.Factory publicationFactory;
        private SubscriptionFactory subscriptionFactory;
        private ISubscriptionManagerProvider subscriptionManagerProvider;

        public static final SyncPubSub Default() {
            return new SyncPubSub().setMetadataReader(new MetadataReader()).setPublicationFactory(new MessagePublication.Factory()).setSubscriptionFactory(new SubscriptionFactory()).setSubscriptionManagerProvider(new SubscriptionManagerProvider());
        }

        public MetadataReader getMetadataReader() {
            return this.metadataReader;
        }

        public MessagePublication.Factory getPublicationFactory() {
            return this.publicationFactory;
        }

        public SubscriptionFactory getSubscriptionFactory() {
            return this.subscriptionFactory;
        }

        public ISubscriptionManagerProvider getSubscriptionManagerProvider() {
            return this.subscriptionManagerProvider;
        }

        public SyncPubSub setMetadataReader(MetadataReader metadataReader) {
            this.metadataReader = metadataReader;
            return this;
        }

        public SyncPubSub setPublicationFactory(MessagePublication.Factory factory) {
            this.publicationFactory = factory;
            return this;
        }

        public SyncPubSub setSubscriptionFactory(SubscriptionFactory subscriptionFactory) {
            this.subscriptionFactory = subscriptionFactory;
            return this;
        }

        public SyncPubSub setSubscriptionManagerProvider(ISubscriptionManagerProvider iSubscriptionManagerProvider) {
            this.subscriptionManagerProvider = iSubscriptionManagerProvider;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class AsynchronousHandlerInvocation implements Feature {
        protected static final ThreadFactory MessageHandlerThreadFactory = new ThreadFactory() { // from class: net.engio.mbassy.bus.config.Feature.AsynchronousHandlerInvocation.1
            private final AtomicInteger threadID = new AtomicInteger(0);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread threadNewThread = Executors.defaultThreadFactory().newThread(runnable);
                threadNewThread.setName("AsyncHandler-" + this.threadID.getAndIncrement());
                threadNewThread.setDaemon(true);
                return threadNewThread;
            }
        };
        private ExecutorService executor;

        public static final AsynchronousHandlerInvocation Default(int i, int i2) {
            return new AsynchronousHandlerInvocation().setExecutor(new ThreadPoolExecutor(i, i2, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue(), MessageHandlerThreadFactory));
        }

        public ExecutorService getExecutor() {
            return this.executor;
        }

        public AsynchronousHandlerInvocation setExecutor(ExecutorService executorService) {
            this.executor = executorService;
            return this;
        }

        public static final AsynchronousHandlerInvocation Default() {
            int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
            return Default(iAvailableProcessors, iAvailableProcessors * 2);
        }
    }
}
