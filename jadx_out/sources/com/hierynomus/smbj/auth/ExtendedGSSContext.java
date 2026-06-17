package com.hierynomus.smbj.auth;

import com.hierynomus.protocol.transport.TransportException;
import java.lang.reflect.Method;
import java.security.Key;
import org.ietf.jgss.GSSContext;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class ExtendedGSSContext {
    private static final Method inquireSecContext = getInquireSecContextMethod();
    private static Object krb5GetSessionKeyConst;

    private ExtendedGSSContext() {
    }

    private static Method getInquireSecContextMethod() throws ClassNotFoundException {
        Class<?> cls;
        Class<?> cls2;
        try {
            cls = Class.forName("com.sun.security.jgss.ExtendedGSSContext", false, SpnegoAuthenticator.class.getClassLoader());
            cls2 = Class.forName("com.sun.security.jgss.InquireType");
        } catch (ClassNotFoundException e) {
            try {
                cls = Class.forName("com.ibm.security.jgss.ExtendedGSSContext", false, SpnegoAuthenticator.class.getClassLoader());
                cls2 = Class.forName("com.ibm.security.jgss.InquireType");
            } catch (ClassNotFoundException e2) {
                IllegalStateException illegalStateException = new IllegalStateException("The code is running in an unknown java vm");
                illegalStateException.addSuppressed(e);
                illegalStateException.addSuppressed(e2);
                throw illegalStateException;
            }
        }
        krb5GetSessionKeyConst = Enum.valueOf(cls2.asSubclass(Enum.class), "KRB5_GET_SESSION_KEY");
        try {
            return cls.getDeclaredMethod("inquireSecContext", cls2);
        } catch (NoSuchMethodException e3) {
            throw new IllegalStateException(e3);
        }
    }

    public static Key krb5GetSessionKey(GSSContext gSSContext) throws TransportException {
        try {
            return (Key) inquireSecContext.invoke(gSSContext, krb5GetSessionKeyConst);
        } catch (Throwable th) {
            throw new TransportException(th);
        }
    }
}
