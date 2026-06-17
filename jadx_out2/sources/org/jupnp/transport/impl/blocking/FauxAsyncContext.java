package org.jupnp.transport.impl.blocking;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class FauxAsyncContext {
    private static final long TIME_TO_WAIT = 15000;
    private boolean isCompleted;
    private volatile boolean isRunning;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private Long timeout = Long.valueOf(TIME_TO_WAIT);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public FauxAsyncContext(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        this.request = httpServletRequest;
        this.response = httpServletResponse;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void complete() {
        synchronized (this) {
            this.isRunning = false;
            notifyAll();
            this.isCompleted = true;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public HttpServletRequest getRequest() {
        return this.request;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public HttpServletResponse getResponse() {
        return this.response;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getTimeout() {
        return this.timeout.longValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isCompleted() {
        return this.isCompleted;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTimeout(long j) {
        if (j > 0) {
            this.timeout = Long.valueOf(j);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void waitForTimeoutOrCompletion() {
        synchronized (this) {
            try {
                if (this.isCompleted) {
                    return;
                }
                this.isRunning = true;
                Long l = this.timeout;
                long jLongValue = l != null ? l.longValue() : Long.MAX_VALUE;
                while (this.isRunning) {
                    long jMin = Math.min(jLongValue, TIME_TO_WAIT);
                    try {
                        wait(jMin);
                        jLongValue -= jMin;
                        if (jLongValue <= 0) {
                            this.isRunning = false;
                            return;
                        }
                    } catch (InterruptedException unused) {
                        this.isRunning = false;
                        return;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
