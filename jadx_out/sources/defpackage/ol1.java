package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ol1 extends IOException {
    public rs2 f;
    public boolean g;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a extends ol1 {
        public a(String str) {
            super(str);
        }
    }

    public ol1(IOException iOException) {
        super(iOException.getMessage(), iOException);
        this.f = null;
    }

    public static ol1 b() {
        return new ol1("Protocol message end-group tag did not match expected tag.");
    }

    public static ol1 c() {
        return new ol1("Protocol message contained an invalid tag (zero).");
    }

    public static ol1 d() {
        return new ol1("Protocol message had invalid UTF-8.");
    }

    public static a e() {
        return new a("Protocol message tag had invalid wire type.");
    }

    public static ol1 f() {
        return new ol1("CodedInputStream encountered a malformed varint.");
    }

    public static ol1 g() {
        return new ol1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static ol1 h() {
        return new ol1("Failed to parse the message.");
    }

    public static ol1 i() {
        return new ol1("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
    }

    public static ol1 l() {
        return new ol1("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
    }

    public static ol1 m() {
        return new ol1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public boolean a() {
        return this.g;
    }

    public void j() {
        this.g = true;
    }

    public ol1 k(rs2 rs2Var) {
        this.f = rs2Var;
        return this;
    }

    public ol1(String str) {
        super(str);
        this.f = null;
    }
}
