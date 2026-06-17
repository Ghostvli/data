package okhttp3;

import defpackage.ta;
import defpackage.we0;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class EventListener {
    public static final Companion Companion = new Companion(null);
    public static final EventListener NONE = new EventListener() { // from class: okhttp3.EventListener$Companion$NONE$1
    };

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class AggregateEventListener extends EventListener {
        private final EventListener[] eventListeners;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public AggregateEventListener(EventListener[] eventListenerArr) {
            eventListenerArr.getClass();
            this.eventListeners = eventListenerArr;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okhttp3.EventListener
        public void cacheConditionalHit(Call call, Response response) {
            call.getClass();
            response.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.cacheConditionalHit(call, response);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okhttp3.EventListener
        public void cacheHit(Call call, Response response) {
            call.getClass();
            response.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.cacheHit(call, response);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okhttp3.EventListener
        public void cacheMiss(Call call) {
            call.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.cacheMiss(call);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okhttp3.EventListener
        public void callEnd(Call call) {
            call.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.callEnd(call);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okhttp3.EventListener
        public void callFailed(Call call, IOException iOException) {
            call.getClass();
            iOException.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.callFailed(call, iOException);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okhttp3.EventListener
        public void callStart(Call call) {
            call.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.callStart(call);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okhttp3.EventListener
        public void canceled(Call call) {
            call.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.canceled(call);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okhttp3.EventListener
        public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
            call.getClass();
            inetSocketAddress.getClass();
            proxy.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.connectEnd(call, inetSocketAddress, proxy, protocol);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okhttp3.EventListener
        public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
            call.getClass();
            inetSocketAddress.getClass();
            proxy.getClass();
            iOException.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okhttp3.EventListener
        public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
            call.getClass();
            inetSocketAddress.getClass();
            proxy.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.connectStart(call, inetSocketAddress, proxy);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okhttp3.EventListener
        public void connectionAcquired(Call call, Connection connection) {
            call.getClass();
            connection.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.connectionAcquired(call, connection);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okhttp3.EventListener
        public void connectionReleased(Call call, Connection connection) {
            call.getClass();
            connection.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.connectionReleased(call, connection);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okhttp3.EventListener
        public void dispatcherQueueEnd(Call call, Dispatcher dispatcher) {
            call.getClass();
            dispatcher.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.dispatcherQueueEnd(call, dispatcher);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okhttp3.EventListener
        public void dispatcherQueueStart(Call call, Dispatcher dispatcher) {
            call.getClass();
            dispatcher.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.dispatcherQueueStart(call, dispatcher);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okhttp3.EventListener
        public void dnsEnd(Call call, String str, List<InetAddress> list) {
            call.getClass();
            str.getClass();
            list.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.dnsEnd(call, str, list);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okhttp3.EventListener
        public void dnsStart(Call call, String str) {
            call.getClass();
            str.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.dnsStart(call, str);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okhttp3.EventListener
        public void followUpDecision(Call call, Response response, Request request) {
            call.getClass();
            response.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.followUpDecision(call, response, request);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final EventListener[] getEventListeners() {
            return this.eventListeners;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okhttp3.EventListener
        public void proxySelectEnd(Call call, HttpUrl httpUrl, List<Proxy> list) {
            call.getClass();
            httpUrl.getClass();
            list.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.proxySelectEnd(call, httpUrl, list);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okhttp3.EventListener
        public void proxySelectStart(Call call, HttpUrl httpUrl) {
            call.getClass();
            httpUrl.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.proxySelectStart(call, httpUrl);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okhttp3.EventListener
        public void requestBodyEnd(Call call, long j) {
            call.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.requestBodyEnd(call, j);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okhttp3.EventListener
        public void requestBodyStart(Call call) {
            call.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.requestBodyStart(call);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okhttp3.EventListener
        public void requestFailed(Call call, IOException iOException) {
            call.getClass();
            iOException.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.requestFailed(call, iOException);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okhttp3.EventListener
        public void requestHeadersEnd(Call call, Request request) {
            call.getClass();
            request.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.requestHeadersEnd(call, request);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okhttp3.EventListener
        public void requestHeadersStart(Call call) {
            call.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.requestHeadersStart(call);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okhttp3.EventListener
        public void responseBodyEnd(Call call, long j) {
            call.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.responseBodyEnd(call, j);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okhttp3.EventListener
        public void responseBodyStart(Call call) {
            call.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.responseBodyStart(call);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okhttp3.EventListener
        public void responseFailed(Call call, IOException iOException) {
            call.getClass();
            iOException.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.responseFailed(call, iOException);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okhttp3.EventListener
        public void responseHeadersEnd(Call call, Response response) {
            call.getClass();
            response.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.responseHeadersEnd(call, response);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okhttp3.EventListener
        public void responseHeadersStart(Call call) {
            call.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.responseHeadersStart(call);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okhttp3.EventListener
        public void retryDecision(Call call, IOException iOException, boolean z) {
            call.getClass();
            iOException.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.retryDecision(call, iOException, z);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okhttp3.EventListener
        public void satisfactionFailure(Call call, Response response) {
            call.getClass();
            response.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.satisfactionFailure(call, response);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okhttp3.EventListener
        public void secureConnectEnd(Call call, Handshake handshake) {
            call.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.secureConnectEnd(call, handshake);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okhttp3.EventListener
        public void secureConnectStart(Call call) {
            call.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.secureConnectStart(call);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface Factory {
        EventListener create(Call call);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void cacheConditionalHit(Call call, Response response) {
        call.getClass();
        response.getClass();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void cacheHit(Call call, Response response) {
        call.getClass();
        response.getClass();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void cacheMiss(Call call) {
        call.getClass();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void callEnd(Call call) {
        call.getClass();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void callFailed(Call call, IOException iOException) {
        call.getClass();
        iOException.getClass();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void callStart(Call call) {
        call.getClass();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void canceled(Call call) {
        call.getClass();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        call.getClass();
        inetSocketAddress.getClass();
        proxy.getClass();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        call.getClass();
        inetSocketAddress.getClass();
        proxy.getClass();
        iOException.getClass();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        call.getClass();
        inetSocketAddress.getClass();
        proxy.getClass();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void connectionAcquired(Call call, Connection connection) {
        call.getClass();
        connection.getClass();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void connectionReleased(Call call, Connection connection) {
        call.getClass();
        connection.getClass();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void dispatcherQueueEnd(Call call, Dispatcher dispatcher) {
        call.getClass();
        dispatcher.getClass();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void dispatcherQueueStart(Call call, Dispatcher dispatcher) {
        call.getClass();
        dispatcher.getClass();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        call.getClass();
        str.getClass();
        list.getClass();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void dnsStart(Call call, String str) {
        call.getClass();
        str.getClass();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void followUpDecision(Call call, Response response, Request request) {
        call.getClass();
        response.getClass();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final EventListener plus(EventListener eventListener) {
        eventListener.getClass();
        EventListener eventListener2 = NONE;
        if (this == eventListener2) {
            return eventListener;
        }
        EventListener[] eventListeners = this instanceof AggregateEventListener ? ((AggregateEventListener) this).getEventListeners() : new EventListener[]{this};
        if (eventListener == eventListener2) {
            return this;
        }
        return new AggregateEventListener((EventListener[]) ta.t(eventListeners, eventListener instanceof AggregateEventListener ? ((AggregateEventListener) eventListener).getEventListeners() : new EventListener[]{eventListener}));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void proxySelectEnd(Call call, HttpUrl httpUrl, List<Proxy> list) {
        call.getClass();
        httpUrl.getClass();
        list.getClass();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void proxySelectStart(Call call, HttpUrl httpUrl) {
        call.getClass();
        httpUrl.getClass();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void requestBodyEnd(Call call, long j) {
        call.getClass();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void requestBodyStart(Call call) {
        call.getClass();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void requestFailed(Call call, IOException iOException) {
        call.getClass();
        iOException.getClass();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void requestHeadersEnd(Call call, Request request) {
        call.getClass();
        request.getClass();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void requestHeadersStart(Call call) {
        call.getClass();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void responseBodyEnd(Call call, long j) {
        call.getClass();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void responseBodyStart(Call call) {
        call.getClass();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void responseFailed(Call call, IOException iOException) {
        call.getClass();
        iOException.getClass();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void responseHeadersEnd(Call call, Response response) {
        call.getClass();
        response.getClass();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void responseHeadersStart(Call call) {
        call.getClass();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void retryDecision(Call call, IOException iOException, boolean z) {
        call.getClass();
        iOException.getClass();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void satisfactionFailure(Call call, Response response) {
        call.getClass();
        response.getClass();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void secureConnectEnd(Call call, Handshake handshake) {
        call.getClass();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void secureConnectStart(Call call) {
        call.getClass();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Companion {
        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:1) call: okhttp3.EventListener.Companion.<init>():void type: THIS */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public /* synthetic */ Companion(we0 we0Var) {
            this();
        }

        private Companion() {
        }
    }
}
