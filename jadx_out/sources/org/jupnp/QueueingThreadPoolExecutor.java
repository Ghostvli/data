package org.jupnp;

import defpackage.e45;
import defpackage.j02;
import defpackage.jl;
import defpackage.n02;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.jupnp.QueueingThreadPoolExecutor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class QueueingThreadPoolExecutor extends ThreadPoolExecutor implements AutoCloseable {
    static final int CORE_THREAD_POOL_SIZE = 1;
    private final ReadWriteLock lock;
    private final j02 logger;
    private Thread queueThread;
    private final Object semaphore;
    private final BlockingQueue<Runnable> taskQueue;
    private final String threadPoolName;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class CommonThreadFactory implements ThreadFactory {
        protected final String name;
        protected final AtomicInteger threadNumber = new AtomicInteger(1);
        protected final ThreadGroup group = Thread.currentThread().getThreadGroup();

        public CommonThreadFactory(String str) {
            this.name = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.group, runnable, this.name + "-" + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    private QueueingThreadPoolExecutor(String str, ThreadFactory threadFactory, int i, BlockingQueue<Runnable> blockingQueue, RejectedExecutionHandler rejectedExecutionHandler) {
        super(1, i, 10L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory, rejectedExecutionHandler);
        j02 j02VarK = n02.k(QueueingThreadPoolExecutor.class);
        this.logger = j02VarK;
        this.lock = new ReentrantReadWriteLock(true);
        this.semaphore = new Object();
        this.threadPoolName = str;
        this.taskQueue = blockingQueue;
        j02VarK.q("Using {} as taskQueue implementation", blockingQueue.getClass().getCanonicalName());
        allowCoreThreadTimeOut(true);
    }

    public static /* synthetic */ void a(QueueingThreadPoolExecutor queueingThreadPoolExecutor) {
        while (true) {
            if (queueingThreadPoolExecutor.getActiveCount() < queueingThreadPoolExecutor.getMaximumPoolSize()) {
                try {
                    Runnable runnablePoll = queueingThreadPoolExecutor.taskQueue.poll(2L, TimeUnit.SECONDS);
                    if (runnablePoll != null) {
                        queueingThreadPoolExecutor.logger.q("Executing queued task of thread pool '{}'.", queueingThreadPoolExecutor.threadPoolName);
                        super.execute(runnablePoll);
                    } else {
                        queueingThreadPoolExecutor.lock.writeLock().lock();
                        try {
                            if (queueingThreadPoolExecutor.taskQueue.isEmpty()) {
                                queueingThreadPoolExecutor.queueThread = null;
                                queueingThreadPoolExecutor.logger.q("Queue for thread pool '{}' fully processed - terminating queue thread.", queueingThreadPoolExecutor.threadPoolName);
                                return;
                            }
                            queueingThreadPoolExecutor.lock.writeLock().unlock();
                        } finally {
                            queueingThreadPoolExecutor.lock.writeLock().unlock();
                        }
                    }
                } catch (InterruptedException unused) {
                    continue;
                }
            } else {
                synchronized (queueingThreadPoolExecutor.semaphore) {
                    queueingThreadPoolExecutor.semaphore.wait(1000L);
                }
            }
        }
    }

    public static QueueingThreadPoolExecutor createInstance(String str, int i, BlockingQueue<Runnable> blockingQueue) {
        if (str != null && !str.trim().isEmpty()) {
            return new QueueingThreadPoolExecutor(str, new CommonThreadFactory(str), i, blockingQueue, new QueueingRejectionHandler());
        }
        jl.a("A thread pool name must be provided!");
        return null;
    }

    private Thread createNewQueueThread() {
        Thread threadNewThread = getThreadFactory().newThread(new Runnable() { // from class: mj3
            @Override // java.lang.Runnable
            public final void run() {
                QueueingThreadPoolExecutor.a(this.f);
            }
        });
        threadNewThread.setName(this.threadPoolName + "-queue");
        return threadNewThread;
    }

    public void addToQueue(Runnable runnable) {
        this.lock.readLock().lock();
        Thread thread = this.queueThread;
        if (thread == null || !thread.isAlive()) {
            this.lock.readLock().unlock();
            this.lock.writeLock().lock();
            try {
                Thread thread2 = this.queueThread;
                if (thread2 == null || !thread2.isAlive()) {
                    this.logger.c("Thread pool '{}' exhausted, queueing tasks now.", this.threadPoolName);
                    Thread threadCreateNewQueueThread = createNewQueueThread();
                    this.queueThread = threadCreateNewQueueThread;
                    threadCreateNewQueueThread.start();
                }
                this.lock.readLock().lock();
                this.lock.writeLock().unlock();
            } catch (Throwable th) {
                this.lock.writeLock().unlock();
                throw th;
            }
        }
        try {
            this.taskQueue.add(runnable);
        } finally {
            this.lock.readLock().unlock();
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        synchronized (this.semaphore) {
            this.semaphore.notify();
        }
    }

    @Override // java.lang.AutoCloseable
    public /* synthetic */ void close() {
        e45.a(this);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (this.taskQueue.isEmpty()) {
            super.execute(runnable);
            return;
        }
        runnable.getClass();
        if (isShutdown()) {
            return;
        }
        addToQueue(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public BlockingQueue<Runnable> getQueue() {
        return this.taskQueue;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setRejectedExecutionHandler(RejectedExecutionHandler rejectedExecutionHandler) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class QueueingRejectionHandler extends ThreadPoolExecutor.DiscardPolicy {
        @Override // java.util.concurrent.ThreadPoolExecutor.DiscardPolicy, java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            if (threadPoolExecutor.isShutdown()) {
                return;
            }
            ((QueueingThreadPoolExecutor) threadPoolExecutor).addToQueue(runnable);
        }

        private QueueingRejectionHandler() {
        }
    }

    public static QueueingThreadPoolExecutor createInstance(String str, int i) {
        return createInstance(str, i, new LinkedTransferQueue());
    }

    public QueueingThreadPoolExecutor(String str, int i) {
        this(str, new CommonThreadFactory(str), i, new LinkedTransferQueue(), new QueueingRejectionHandler());
    }
}
