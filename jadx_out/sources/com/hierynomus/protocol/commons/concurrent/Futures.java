package com.hierynomus.protocol.commons.concurrent;

import com.hierynomus.protocol.commons.concurrent.AFuture;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Futures {
    public static <T, E extends Throwable> T get(Future<T> future, long j, TimeUnit timeUnit, ExceptionWrapper<E> exceptionWrapper) throws Throwable {
        try {
            return future.get(j, timeUnit);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw exceptionWrapper.wrap(e);
        } catch (ExecutionException e2) {
            e = e2;
            throw exceptionWrapper.wrap(e);
        } catch (TimeoutException e3) {
            e = e3;
            throw exceptionWrapper.wrap(e);
        }
    }

    public static <T> Future<List<T>> sequence(List<Future<T>> list) {
        return new SequencedFuture(list);
    }

    public static <F, T> Future<T> transform(Future<F> future, AFuture.Function<F, T> function) {
        return new TransformedFuture(future, function);
    }

    public static <T, E extends Throwable> T get(Future<T> future, ExceptionWrapper<E> exceptionWrapper) throws Throwable {
        try {
            return future.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw exceptionWrapper.wrap(e);
        } catch (ExecutionException e2) {
            throw exceptionWrapper.wrap(e2);
        }
    }
}
