package org.jupnp.transport.spi;

import defpackage.j02;
import defpackage.n02;
import java.net.URI;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.jupnp.model.message.StreamRequestMessage;
import org.jupnp.model.message.StreamResponseMessage;
import org.jupnp.transport.spi.StreamClientConfiguration;
import org.jupnp.util.Exceptions;
import org.jupnp.util.SpecificationViolationReporter;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractStreamClient<C extends StreamClientConfiguration, REQUEST> implements StreamClient<C> {
    private static final int FAILED_REQUESTS_MAX_SIZE = 100;
    private final j02 logger = n02.k(StreamClient.class);
    private Map<URI, Long> failedRequests = new ConcurrentHashMap();
    private Map<URI, Long> failedTries = new ConcurrentHashMap();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class RequestWrapper implements Callable<StreamResponseMessage> {
        Long startTime = null;
        Callable<StreamResponseMessage> task;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public RequestWrapper(Callable<StreamResponseMessage> callable) {
            this.task = callable;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: call()Ljava/lang/Object; */
        @Override // java.util.concurrent.Callable
        public StreamResponseMessage call() {
            this.startTime = Long.valueOf(System.nanoTime());
            return this.task.call();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void cleanOldFailedRequests(long j) {
        if (this.failedRequests.size() <= 100) {
            return;
        }
        Iterator<Map.Entry<URI, Long>> it = this.failedRequests.entrySet().iterator();
        while (it.hasNext()) {
            if (j - it.next().getValue().longValue() > TimeUnit.SECONDS.toNanos(getConfiguration().getRetryAfterSeconds())) {
                it.remove();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void handleRequestFailure(StreamRequestMessage streamRequestMessage) {
        if (getConfiguration().getRetryAfterSeconds() <= 0) {
            return;
        }
        long jNanoTime = System.nanoTime();
        this.failedRequests.put(streamRequestMessage.getUri(), Long.valueOf(jNanoTime));
        this.failedTries.put(streamRequestMessage.getUri(), Long.valueOf(this.failedTries.get(streamRequestMessage.getUri()).longValue() + 1));
        if (this.failedRequests.size() > 100) {
            cleanOldFailedRequests(jNanoTime);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void handleRequestTimeout(StreamRequestMessage streamRequestMessage, RequestWrapper requestWrapper) {
        if (getConfiguration().getRetryAfterSeconds() <= 0) {
            return;
        }
        long jNanoTime = System.nanoTime();
        Long l = requestWrapper.startTime;
        if (l != null) {
            if (jNanoTime - l.longValue() > TimeUnit.SECONDS.toNanos(getConfiguration().getTimeoutSeconds())) {
                this.failedRequests.put(streamRequestMessage.getUri(), Long.valueOf(jNanoTime));
            }
        }
        this.failedTries.put(streamRequestMessage.getUri(), Long.valueOf(this.failedTries.get(streamRequestMessage.getUri()).longValue() + 1));
        cleanOldFailedRequests(jNanoTime);
    }

    public abstract void abort(REQUEST request);

    public abstract Callable<StreamResponseMessage> createCallable(StreamRequestMessage streamRequestMessage, REQUEST request);

    public abstract REQUEST createRequest(StreamRequestMessage streamRequestMessage);

    public abstract boolean logExecutionException(Throwable th);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void onFinally(REQUEST request) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.spi.StreamClient
    public StreamResponseMessage sendRequest(StreamRequestMessage streamRequestMessage) {
        this.logger.h("Preparing HTTP request: {}", streamRequestMessage);
        if (streamRequestMessage.getUri().toString().split(":")[0].equals("https")) {
            SpecificationViolationReporter.report("HTTPS invalid.  Ignoring call ".concat(String.valueOf(streamRequestMessage.getUri())), new Object[0]);
            return null;
        }
        long jNanoTime = System.nanoTime();
        this.failedTries.putIfAbsent(streamRequestMessage.getUri(), 0L);
        Long l = this.failedRequests.get(streamRequestMessage.getUri());
        Long l2 = this.failedTries.get(streamRequestMessage.getUri());
        int retryAfterSeconds = getConfiguration().getRetryAfterSeconds();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        if (retryAfterSeconds > 0 && l != null) {
            if (jNanoTime - l.longValue() < timeUnit.toNanos(getConfiguration().getRetryAfterSeconds()) && l2.longValue() >= getConfiguration().getRetryIterations()) {
                this.logger.s("Will not attempt request because it failed {} times in the last {} seconds: {}", l2, Integer.valueOf(getConfiguration().getRetryAfterSeconds()), streamRequestMessage);
                return null;
            }
            if (jNanoTime - l.longValue() >= timeUnit.toNanos(getConfiguration().getRetryAfterSeconds()) || l2.longValue() <= 0) {
                this.logger.q("Clearing failed attempt after {} tries", l2);
                this.failedRequests.remove(streamRequestMessage.getUri());
                this.failedTries.put(streamRequestMessage.getUri(), 0L);
            } else {
                this.logger.f("Previous attempt failed {} times.  Will retry {}", l2, streamRequestMessage);
            }
        }
        REQUEST requestCreateRequest = createRequest(streamRequestMessage);
        if (requestCreateRequest == null) {
            return null;
        }
        RequestWrapper requestWrapper = new RequestWrapper(createCallable(streamRequestMessage, requestCreateRequest));
        Future futureSubmit = getConfiguration().getRequestExecutorService().submit(requestWrapper);
        try {
            try {
                this.logger.i("Waiting {} seconds for HTTP request to complete: {}", Integer.valueOf(getConfiguration().getTimeoutSeconds()), streamRequestMessage);
                StreamResponseMessage streamResponseMessage = (StreamResponseMessage) futureSubmit.get(getConfiguration().getTimeoutSeconds(), timeUnit);
                long jNanoTime2 = (System.nanoTime() - jNanoTime) / 1000000;
                this.logger.i("Got HTTP response in {} ms: {}", Long.valueOf(jNanoTime2), streamRequestMessage);
                if (getConfiguration().getLogWarningSeconds() > 0 && jNanoTime2 > timeUnit.toMillis(getConfiguration().getLogWarningSeconds())) {
                    this.logger.m("HTTP request took a long time ({} ms): {}", Long.valueOf(jNanoTime2), streamRequestMessage);
                }
                onFinally(requestCreateRequest);
                return streamResponseMessage;
            } catch (InterruptedException unused) {
                this.logger.h("Interruption, aborting request: {}", streamRequestMessage);
                abort(requestCreateRequest);
                throw new InterruptedException("HTTP request interrupted and aborted");
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (!logExecutionException(cause)) {
                    String strConcat = "HTTP request failed: ".concat(String.valueOf(streamRequestMessage));
                    boolean zG = this.logger.g();
                    j02 j02Var = this.logger;
                    if (zG) {
                        j02Var.u(strConcat, Exceptions.unwrap(cause));
                    } else {
                        j02Var.m("{} ({})", strConcat, Exceptions.unwrap(cause).getMessage());
                    }
                }
                handleRequestFailure(streamRequestMessage);
                onFinally(requestCreateRequest);
                return null;
            } catch (TimeoutException unused2) {
                this.logger.A("Timeout of {} seconds while waiting for HTTP request to complete, aborting: {}", Integer.valueOf(getConfiguration().getTimeoutSeconds()), streamRequestMessage);
                abort(requestCreateRequest);
                handleRequestTimeout(streamRequestMessage, requestWrapper);
                onFinally(requestCreateRequest);
                return null;
            }
        } catch (Throwable th) {
            onFinally(requestCreateRequest);
            throw th;
        }
    }
}
