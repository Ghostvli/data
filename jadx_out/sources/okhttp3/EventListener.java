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

        public AggregateEventListener(EventListener[] eventListenerArr) {
            eventListenerArr.getClass();
            this.eventListeners = eventListenerArr;
        }

        @Override // okhttp3.EventListener
        public void cacheConditionalHit(Call call, Response response) {
            call.getClass();
            response.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.cacheConditionalHit(call, response);
            }
        }

        @Override // okhttp3.EventListener
        public void cacheHit(Call call, Response response) {
            call.getClass();
            response.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.cacheHit(call, response);
            }
        }

        @Override // okhttp3.EventListener
        public void cacheMiss(Call call) {
            call.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.cacheMiss(call);
            }
        }

        @Override // okhttp3.EventListener
        public void callEnd(Call call) {
            call.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.callEnd(call);
            }
        }

        @Override // okhttp3.EventListener
        public void callFailed(Call call, IOException iOException) {
            call.getClass();
            iOException.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.callFailed(call, iOException);
            }
        }

        @Override // okhttp3.EventListener
        public void callStart(Call call) {
            call.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.callStart(call);
            }
        }

        @Override // okhttp3.EventListener
        public void canceled(Call call) {
            call.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.canceled(call);
            }
        }

        @Override // okhttp3.EventListener
        public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
            call.getClass();
            inetSocketAddress.getClass();
            proxy.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.connectEnd(call, inetSocketAddress, proxy, protocol);
            }
        }

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

        @Override // okhttp3.EventListener
        public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
            call.getClass();
            inetSocketAddress.getClass();
            proxy.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.connectStart(call, inetSocketAddress, proxy);
            }
        }

        @Override // okhttp3.EventListener
        public void connectionAcquired(Call call, Connection connection) {
            call.getClass();
            connection.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.connectionAcquired(call, connection);
            }
        }

        @Override // okhttp3.EventListener
        public void connectionReleased(Call call, Connection connection) {
            call.getClass();
            connection.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.connectionReleased(call, connection);
            }
        }

        @Override // okhttp3.EventListener
        public void dispatcherQueueEnd(Call call, Dispatcher dispatcher) {
            call.getClass();
            dispatcher.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.dispatcherQueueEnd(call, dispatcher);
            }
        }

        @Override // okhttp3.EventListener
        public void dispatcherQueueStart(Call call, Dispatcher dispatcher) {
            call.getClass();
            dispatcher.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.dispatcherQueueStart(call, dispatcher);
            }
        }

        @Override // okhttp3.EventListener
        public void dnsEnd(Call call, String str, List<InetAddress> list) {
            call.getClass();
            str.getClass();
            list.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.dnsEnd(call, str, list);
            }
        }

        @Override // okhttp3.EventListener
        public void dnsStart(Call call, String str) {
            call.getClass();
            str.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.dnsStart(call, str);
            }
        }

        @Override // okhttp3.EventListener
        public void followUpDecision(Call call, Response response, Request request) {
            call.getClass();
            response.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.followUpDecision(call, response, request);
            }
        }

        public final EventListener[] getEventListeners() {
            return this.eventListeners;
        }

        @Override // okhttp3.EventListener
        public void proxySelectEnd(Call call, HttpUrl httpUrl, List<Proxy> list) {
            call.getClass();
            httpUrl.getClass();
            list.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.proxySelectEnd(call, httpUrl, list);
            }
        }

        @Override // okhttp3.EventListener
        public void proxySelectStart(Call call, HttpUrl httpUrl) {
            call.getClass();
            httpUrl.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.proxySelectStart(call, httpUrl);
            }
        }

        @Override // okhttp3.EventListener
        public void requestBodyEnd(Call call, long j) {
            call.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.requestBodyEnd(call, j);
            }
        }

        @Override // okhttp3.EventListener
        public void requestBodyStart(Call call) {
            call.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.requestBodyStart(call);
            }
        }

        @Override // okhttp3.EventListener
        public void requestFailed(Call call, IOException iOException) {
            call.getClass();
            iOException.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.requestFailed(call, iOException);
            }
        }

        @Override // okhttp3.EventListener
        public void requestHeadersEnd(Call call, Request request) {
            call.getClass();
            request.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.requestHeadersEnd(call, request);
            }
        }

        @Override // okhttp3.EventListener
        public void requestHeadersStart(Call call) {
            call.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.requestHeadersStart(call);
            }
        }

        @Override // okhttp3.EventListener
        public void responseBodyEnd(Call call, long j) {
            call.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.responseBodyEnd(call, j);
            }
        }

        @Override // okhttp3.EventListener
        public void responseBodyStart(Call call) {
            call.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.responseBodyStart(call);
            }
        }

        @Override // okhttp3.EventListener
        public void responseFailed(Call call, IOException iOException) {
            call.getClass();
            iOException.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.responseFailed(call, iOException);
            }
        }

        @Override // okhttp3.EventListener
        public void responseHeadersEnd(Call call, Response response) {
            call.getClass();
            response.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.responseHeadersEnd(call, response);
            }
        }

        @Override // okhttp3.EventListener
        public void responseHeadersStart(Call call) {
            call.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.responseHeadersStart(call);
            }
        }

        @Override // okhttp3.EventListener
        public void retryDecision(Call call, IOException iOException, boolean z) {
            call.getClass();
            iOException.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.retryDecision(call, iOException, z);
            }
        }

        @Override // okhttp3.EventListener
        public void satisfactionFailure(Call call, Response response) {
            call.getClass();
            response.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.satisfactionFailure(call, response);
            }
        }

        @Override // okhttp3.EventListener
        public void secureConnectEnd(Call call, Handshake handshake) {
            call.getClass();
            for (EventListener eventListener : this.eventListeners) {
                eventListener.secureConnectEnd(call, handshake);
            }
        }

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

    public void cacheConditionalHit(Call call, Response response) {
        call.getClass();
        response.getClass();
    }

    public void cacheHit(Call call, Response response) {
        call.getClass();
        response.getClass();
    }

    public void cacheMiss(Call call) {
        call.getClass();
    }

    public void callEnd(Call call) {
        call.getClass();
    }

    public void callFailed(Call call, IOException iOException) {
        call.getClass();
        iOException.getClass();
    }

    public void callStart(Call call) {
        call.getClass();
    }

    public void canceled(Call call) {
        call.getClass();
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        call.getClass();
        inetSocketAddress.getClass();
        proxy.getClass();
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        call.getClass();
        inetSocketAddress.getClass();
        proxy.getClass();
        iOException.getClass();
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        call.getClass();
        inetSocketAddress.getClass();
        proxy.getClass();
    }

    public void connectionAcquired(Call call, Connection connection) {
        call.getClass();
        connection.getClass();
    }

    public void connectionReleased(Call call, Connection connection) {
        call.getClass();
        connection.getClass();
    }

    public void dispatcherQueueEnd(Call call, Dispatcher dispatcher) {
        call.getClass();
        dispatcher.getClass();
    }

    public void dispatcherQueueStart(Call call, Dispatcher dispatcher) {
        call.getClass();
        dispatcher.getClass();
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        call.getClass();
        str.getClass();
        list.getClass();
    }

    public void dnsStart(Call call, String str) {
        call.getClass();
        str.getClass();
    }

    public void followUpDecision(Call call, Response response, Request request) {
        call.getClass();
        response.getClass();
    }

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

    public void proxySelectEnd(Call call, HttpUrl httpUrl, List<Proxy> list) {
        call.getClass();
        httpUrl.getClass();
        list.getClass();
    }

    public void proxySelectStart(Call call, HttpUrl httpUrl) {
        call.getClass();
        httpUrl.getClass();
    }

    public void requestBodyEnd(Call call, long j) {
        call.getClass();
    }

    public void requestBodyStart(Call call) {
        call.getClass();
    }

    public void requestFailed(Call call, IOException iOException) {
        call.getClass();
        iOException.getClass();
    }

    public void requestHeadersEnd(Call call, Request request) {
        call.getClass();
        request.getClass();
    }

    public void requestHeadersStart(Call call) {
        call.getClass();
    }

    public void responseBodyEnd(Call call, long j) {
        call.getClass();
    }

    public void responseBodyStart(Call call) {
        call.getClass();
    }

    public void responseFailed(Call call, IOException iOException) {
        call.getClass();
        iOException.getClass();
    }

    public void responseHeadersEnd(Call call, Response response) {
        call.getClass();
        response.getClass();
    }

    public void responseHeadersStart(Call call) {
        call.getClass();
    }

    public void retryDecision(Call call, IOException iOException, boolean z) {
        call.getClass();
        iOException.getClass();
    }

    public void satisfactionFailure(Call call, Response response) {
        call.getClass();
        response.getClass();
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
        call.getClass();
    }

    public void secureConnectStart(Call call) {
        call.getClass();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Companion {
        public /* synthetic */ Companion(we0 we0Var) {
            this();
        }

        private Companion() {
        }
    }
}
