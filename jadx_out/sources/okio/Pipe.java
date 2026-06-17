package okio;

import defpackage.dk1;
import defpackage.eb3;
import defpackage.fw4;
import defpackage.il1;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class Pipe {
    private final Buffer buffer = new Buffer();
    private boolean canceled;
    private final Condition condition;
    private Sink foldedSink;
    private final ReentrantLock lock;
    private final long maxBufferSize;
    private final Sink sink;
    private boolean sinkClosed;
    private final Source source;
    private boolean sourceClosed;

    public Pipe(long j) {
        this.maxBufferSize = j;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        conditionNewCondition.getClass();
        this.condition = conditionNewCondition;
        if (j < 1) {
            eb3.a("maxBufferSize < 1: ", j);
            throw null;
        }
        this.sink = new Sink() { // from class: okio.Pipe.sink.1
            private final Timeout timeout = new Timeout();

            @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                boolean zHasDeadline;
                ReentrantLock lock = Pipe.this.getLock();
                Pipe pipe = Pipe.this;
                lock.lock();
                try {
                    if (pipe.getSinkClosed$okio()) {
                        lock.unlock();
                        return;
                    }
                    Sink foldedSink$okio = pipe.getFoldedSink$okio();
                    if (foldedSink$okio == null) {
                        if (pipe.getSourceClosed$okio() && pipe.getBuffer$okio().size() > 0) {
                            throw new IOException("source is closed");
                        }
                        pipe.setSinkClosed$okio(true);
                        pipe.getCondition().signalAll();
                        foldedSink$okio = null;
                    }
                    fw4 fw4Var = fw4.a;
                    lock.unlock();
                    if (foldedSink$okio != null) {
                        Pipe pipe2 = Pipe.this;
                        Timeout timeout = foldedSink$okio.timeout();
                        Timeout timeout2 = pipe2.sink().timeout();
                        long jTimeoutNanos = timeout.timeoutNanos();
                        long jMinTimeout = Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos());
                        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                        timeout.timeout(jMinTimeout, timeUnit);
                        if (!timeout.hasDeadline()) {
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                            }
                            try {
                                foldedSink$okio.close();
                                if (zHasDeadline) {
                                    return;
                                } else {
                                    return;
                                }
                            } finally {
                                timeout.timeout(jTimeoutNanos, timeUnit);
                                if (timeout2.hasDeadline()) {
                                    timeout.clearDeadline();
                                }
                            }
                        }
                        long jDeadlineNanoTime = timeout.deadlineNanoTime();
                        if (timeout2.hasDeadline()) {
                            timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                        }
                        try {
                            foldedSink$okio.close();
                        } finally {
                            timeout.timeout(jTimeoutNanos, timeUnit);
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(jDeadlineNanoTime);
                            }
                        }
                    }
                } catch (Throwable th) {
                    lock.unlock();
                    throw th;
                }
            }

            @Override // okio.Sink, java.io.Flushable
            public void flush() {
                boolean zHasDeadline;
                ReentrantLock lock = Pipe.this.getLock();
                Pipe pipe = Pipe.this;
                lock.lock();
                try {
                    if (pipe.getSinkClosed$okio()) {
                        throw new IllegalStateException("closed");
                    }
                    if (pipe.getCanceled$okio()) {
                        throw new IOException("canceled");
                    }
                    Sink foldedSink$okio = pipe.getFoldedSink$okio();
                    if (foldedSink$okio == null) {
                        if (pipe.getSourceClosed$okio() && pipe.getBuffer$okio().size() > 0) {
                            throw new IOException("source is closed");
                        }
                        foldedSink$okio = null;
                    }
                    fw4 fw4Var = fw4.a;
                    lock.unlock();
                    if (foldedSink$okio != null) {
                        Pipe pipe2 = Pipe.this;
                        Timeout timeout = foldedSink$okio.timeout();
                        Timeout timeout2 = pipe2.sink().timeout();
                        long jTimeoutNanos = timeout.timeoutNanos();
                        long jMinTimeout = Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos());
                        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                        timeout.timeout(jMinTimeout, timeUnit);
                        if (!timeout.hasDeadline()) {
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                            }
                            try {
                                foldedSink$okio.flush();
                                if (zHasDeadline) {
                                    return;
                                } else {
                                    return;
                                }
                            } finally {
                                timeout.timeout(jTimeoutNanos, timeUnit);
                                if (timeout2.hasDeadline()) {
                                    timeout.clearDeadline();
                                }
                            }
                        }
                        long jDeadlineNanoTime = timeout.deadlineNanoTime();
                        if (timeout2.hasDeadline()) {
                            timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                        }
                        try {
                            foldedSink$okio.flush();
                        } finally {
                            timeout.timeout(jTimeoutNanos, timeUnit);
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(jDeadlineNanoTime);
                            }
                        }
                    }
                } catch (Throwable th) {
                    lock.unlock();
                    throw th;
                }
            }

            @Override // okio.Sink
            public Timeout timeout() {
                return this.timeout;
            }

            /* JADX WARN: Code restructure failed: missing block: B:28:0x0076, code lost:
            
                r1 = defpackage.fw4.a;
             */
            /* JADX WARN: Code restructure failed: missing block: B:29:0x0078, code lost:
            
                r0.unlock();
             */
            /* JADX WARN: Code restructure failed: missing block: B:30:0x007b, code lost:
            
                if (r2 == null) goto L59;
             */
            /* JADX WARN: Code restructure failed: missing block: B:31:0x007d, code lost:
            
                r11 = r11.this$0;
                r0 = r2.timeout();
                r11 = r11.sink().timeout();
                r3 = r0.timeoutNanos();
                r5 = okio.Timeout.Companion.minTimeout(r11.timeoutNanos(), r0.timeoutNanos());
                r1 = java.util.concurrent.TimeUnit.NANOSECONDS;
                r0.timeout(r5, r1);
             */
            /* JADX WARN: Code restructure failed: missing block: B:32:0x00a6, code lost:
            
                if (r0.hasDeadline() == false) goto L46;
             */
            /* JADX WARN: Code restructure failed: missing block: B:33:0x00a8, code lost:
            
                r5 = r0.deadlineNanoTime();
             */
            /* JADX WARN: Code restructure failed: missing block: B:34:0x00b0, code lost:
            
                if (r11.hasDeadline() == false) goto L66;
             */
            /* JADX WARN: Code restructure failed: missing block: B:35:0x00b2, code lost:
            
                r0.deadlineNanoTime(java.lang.Math.min(r0.deadlineNanoTime(), r11.deadlineNanoTime()));
             */
            /* JADX WARN: Code restructure failed: missing block: B:36:0x00c1, code lost:
            
                r2.write(r12, r13);
             */
            /* JADX WARN: Code restructure failed: missing block: B:40:0x00d0, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:41:0x00d1, code lost:
            
                r12 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:42:0x00d2, code lost:
            
                r0.timeout(r3, r1);
             */
            /* JADX WARN: Code restructure failed: missing block: B:43:0x00d9, code lost:
            
                if (r11.hasDeadline() != false) goto L44;
             */
            /* JADX WARN: Code restructure failed: missing block: B:44:0x00db, code lost:
            
                r0.deadlineNanoTime(r5);
             */
            /* JADX WARN: Code restructure failed: missing block: B:45:0x00de, code lost:
            
                throw r12;
             */
            /* JADX WARN: Code restructure failed: missing block: B:47:0x00e3, code lost:
            
                if (r11.hasDeadline() == false) goto L69;
             */
            /* JADX WARN: Code restructure failed: missing block: B:48:0x00e5, code lost:
            
                r0.deadlineNanoTime(r11.deadlineNanoTime());
             */
            /* JADX WARN: Code restructure failed: missing block: B:49:0x00ec, code lost:
            
                r2.write(r12, r13);
             */
            /* JADX WARN: Code restructure failed: missing block: B:53:0x00fb, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:54:0x00fc, code lost:
            
                r12 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:55:0x00fd, code lost:
            
                r0.timeout(r3, r1);
             */
            /* JADX WARN: Code restructure failed: missing block: B:56:0x0104, code lost:
            
                if (r11.hasDeadline() != false) goto L57;
             */
            /* JADX WARN: Code restructure failed: missing block: B:57:0x0106, code lost:
            
                r0.clearDeadline();
             */
            /* JADX WARN: Code restructure failed: missing block: B:58:0x0109, code lost:
            
                throw r12;
             */
            /* JADX WARN: Code restructure failed: missing block: B:59:0x010a, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:80:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:81:?, code lost:
            
                return;
             */
            @Override // okio.Sink
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void write(okio.Buffer r12, long r13) {
                /*
                    Method dump skipped, instruction units count: 285
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: okio.Pipe.AnonymousClass1.write(okio.Buffer, long):void");
            }
        };
        this.source = new Source() { // from class: okio.Pipe.source.1
            private final Timeout timeout = new Timeout();

            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                ReentrantLock lock = Pipe.this.getLock();
                Pipe pipe = Pipe.this;
                lock.lock();
                try {
                    pipe.setSourceClosed$okio(true);
                    pipe.getCondition().signalAll();
                    fw4 fw4Var = fw4.a;
                } finally {
                    lock.unlock();
                }
            }

            @Override // okio.Source
            public long read(Buffer buffer, long j2) {
                buffer.getClass();
                ReentrantLock lock = Pipe.this.getLock();
                Pipe pipe = Pipe.this;
                lock.lock();
                try {
                    if (pipe.getSourceClosed$okio()) {
                        throw new IllegalStateException("closed");
                    }
                    if (pipe.getCanceled$okio()) {
                        throw new IOException("canceled");
                    }
                    while (pipe.getBuffer$okio().size() == 0) {
                        if (pipe.getSinkClosed$okio()) {
                            lock.unlock();
                            return -1L;
                        }
                        this.timeout.awaitSignal(pipe.getCondition());
                        if (pipe.getCanceled$okio()) {
                            throw new IOException("canceled");
                        }
                    }
                    long j3 = pipe.getBuffer$okio().read(buffer, j2);
                    pipe.getCondition().signalAll();
                    lock.unlock();
                    return j3;
                } catch (Throwable th) {
                    lock.unlock();
                    throw th;
                }
            }

            @Override // okio.Source
            public Timeout timeout() {
                return this.timeout;
            }
        };
    }

    private final void forward(Sink sink, Function1<? super Sink, fw4> function1) {
        Timeout timeout = sink.timeout();
        Timeout timeout2 = sink().timeout();
        long jTimeoutNanos = timeout.timeoutNanos();
        long jMinTimeout = Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos());
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        timeout.timeout(jMinTimeout, timeUnit);
        if (!timeout.hasDeadline()) {
            if (timeout2.hasDeadline()) {
                timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
            }
            try {
                function1.invoke(sink);
                fw4 fw4Var = fw4.a;
                return;
            } finally {
                dk1.b(1);
                timeout.timeout(jTimeoutNanos, timeUnit);
                if (timeout2.hasDeadline()) {
                    timeout.clearDeadline();
                }
                dk1.a(1);
            }
        }
        long jDeadlineNanoTime = timeout.deadlineNanoTime();
        if (timeout2.hasDeadline()) {
            timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
        }
        try {
            function1.invoke(sink);
            fw4 fw4Var2 = fw4.a;
        } finally {
            dk1.b(1);
            timeout.timeout(jTimeoutNanos, timeUnit);
            if (timeout2.hasDeadline()) {
                timeout.deadlineNanoTime(jDeadlineNanoTime);
            }
            dk1.a(1);
        }
    }

    /* JADX INFO: renamed from: -deprecated_sink, reason: not valid java name */
    public final Sink m182deprecated_sink() {
        return this.sink;
    }

    /* JADX INFO: renamed from: -deprecated_source, reason: not valid java name */
    public final Source m183deprecated_source() {
        return this.source;
    }

    public final void cancel() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.canceled = true;
            this.buffer.clear();
            this.condition.signalAll();
            fw4 fw4Var = fw4.a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void fold(Sink sink) {
        Buffer buffer;
        boolean z;
        sink.getClass();
        while (true) {
            this.lock.lock();
            try {
                if (this.foldedSink != null) {
                    throw new IllegalStateException("sink already folded");
                }
                if (this.canceled) {
                    this.foldedSink = sink;
                    throw new IOException("canceled");
                }
                boolean z2 = this.sinkClosed;
                Buffer buffer2 = null;
                if (this.buffer.exhausted()) {
                    this.sourceClosed = true;
                    this.foldedSink = sink;
                    buffer = null;
                    z = true;
                } else {
                    buffer = new Buffer();
                    Buffer buffer3 = this.buffer;
                    buffer.write(buffer3, buffer3.size());
                    this.condition.signalAll();
                    z = false;
                }
                fw4 fw4Var = fw4.a;
                if (z) {
                    if (z2) {
                        sink.close();
                        return;
                    }
                    return;
                }
                if (buffer == null) {
                    try {
                        il1.j("sinkBuffer");
                    } catch (Throwable th) {
                        ReentrantLock reentrantLock = this.lock;
                        reentrantLock.lock();
                        try {
                            this.sourceClosed = true;
                            this.condition.signalAll();
                            fw4 fw4Var2 = fw4.a;
                            throw th;
                        } finally {
                            reentrantLock.unlock();
                        }
                    }
                } else {
                    buffer2 = buffer;
                }
                sink.write(buffer2, buffer.size());
                sink.flush();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final Buffer getBuffer$okio() {
        return this.buffer;
    }

    public final boolean getCanceled$okio() {
        return this.canceled;
    }

    public final Condition getCondition() {
        return this.condition;
    }

    public final Sink getFoldedSink$okio() {
        return this.foldedSink;
    }

    public final ReentrantLock getLock() {
        return this.lock;
    }

    public final long getMaxBufferSize$okio() {
        return this.maxBufferSize;
    }

    public final boolean getSinkClosed$okio() {
        return this.sinkClosed;
    }

    public final boolean getSourceClosed$okio() {
        return this.sourceClosed;
    }

    public final void setCanceled$okio(boolean z) {
        this.canceled = z;
    }

    public final void setFoldedSink$okio(Sink sink) {
        this.foldedSink = sink;
    }

    public final void setSinkClosed$okio(boolean z) {
        this.sinkClosed = z;
    }

    public final void setSourceClosed$okio(boolean z) {
        this.sourceClosed = z;
    }

    public final Sink sink() {
        return this.sink;
    }

    public final Source source() {
        return this.source;
    }
}
