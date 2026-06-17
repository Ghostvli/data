package net.engio.mbassy.bus.error;

import java.lang.reflect.Method;
import net.engio.mbassy.bus.IMessagePublication;
import net.engio.mbassy.subscription.SubscriptionContext;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class PublicationError {
    private Throwable cause;
    private String errorMsg;
    private Method handler;
    private Object listener;
    private Object message;
    private IMessagePublication publication;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PublicationError(Throwable th, String str, Method method, Object obj, IMessagePublication iMessagePublication) {
        this.cause = th;
        this.errorMsg = str;
        this.handler = method;
        this.listener = obj;
        this.publication = iMessagePublication;
        this.message = iMessagePublication != null ? iMessagePublication.getMessage() : null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Throwable getCause() {
        return this.cause;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Method getHandler() {
        return this.handler;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object getListener() {
        return this.listener;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getMessage() {
        return this.errorMsg;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object getPublishedMessage() {
        return this.message;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PublicationError setCause(Throwable th) {
        this.cause = th;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PublicationError setHandler(Method method) {
        this.handler = method;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PublicationError setListener(Object obj) {
        this.listener = obj;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PublicationError setMessage(String str) {
        this.errorMsg = str;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PublicationError setPublication(IMessagePublication iMessagePublication) {
        this.publication = iMessagePublication;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PublicationError setPublishedMessage(Object obj) {
        this.message = obj;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        String property = System.getProperty("line.separator");
        return "PublicationError{" + property + "\tcause=" + this.cause + property + "\tmessage='" + this.errorMsg + '\'' + property + "\thandler=" + this.handler + property + "\tlistener=" + this.listener + property + "\tpublishedMessage=" + getPublishedMessage() + '}';
    }

    public PublicationError(Throwable th, String str, IMessagePublication iMessagePublication) {
        this.cause = th;
        this.errorMsg = str;
    }

    public PublicationError(Throwable th, String str, SubscriptionContext subscriptionContext) {
        this.cause = th;
        this.errorMsg = str;
        this.handler = subscriptionContext.getHandler().getMethod();
    }

    public PublicationError(Throwable th, String str) {
        this.cause = th;
        this.errorMsg = str;
    }

    public PublicationError() {
    }
}
