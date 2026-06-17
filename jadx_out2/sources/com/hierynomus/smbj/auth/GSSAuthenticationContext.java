package com.hierynomus.smbj.auth;

import javax.security.auth.Subject;
import org.ietf.jgss.GSSCredential;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class GSSAuthenticationContext extends AuthenticationContext {
    GSSCredential creds;
    Subject subject;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public GSSAuthenticationContext(String str, String str2, Subject subject, GSSCredential gSSCredential) {
        super(str, new char[0], str2);
        this.subject = subject;
        this.creds = gSSCredential;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public GSSCredential getCreds() {
        return this.creds;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Subject getSubject() {
        return this.subject;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smbj.auth.AuthenticationContext
    public String toString() {
        return "GSSAuthenticationContext[" + this.subject + ']';
    }
}
