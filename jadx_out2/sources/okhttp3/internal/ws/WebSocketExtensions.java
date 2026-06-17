package okhttp3.internal.ws;

import defpackage.il1;
import defpackage.rg4;
import defpackage.sg4;
import defpackage.we0;
import defpackage.wg4;
import okhttp3.Headers;
import okhttp3.internal._UtilCommonKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
@IgnoreJRERequirement
public final class WebSocketExtensions {
    public static final Companion Companion = new Companion(null);
    private static final String HEADER_WEB_SOCKET_EXTENSION = "Sec-WebSocket-Extensions";
    public final Integer clientMaxWindowBits;
    public final boolean clientNoContextTakeover;
    public final boolean perMessageDeflate;
    public final Integer serverMaxWindowBits;
    public final boolean serverNoContextTakeover;
    public final boolean unknownValues;

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0020: CONSTRUCTOR 
      (wrap:boolean:?: TERNARY null = ((wrap:int:0x0000: ARITH (r9v0 int) & (1 int) A[WRAPPED] (LINE:1)) != (0 int)) ? false : (r3v0 boolean))
      (wrap:java.lang.Integer:?: TERNARY null = ((wrap:int:0x0006: ARITH (r9v0 int) & (2 int) A[WRAPPED] (LINE:7)) != (0 int)) ? (null java.lang.Integer) : (r4v0 java.lang.Integer))
      (wrap:boolean:?: TERNARY null = ((wrap:int:0x000c: ARITH (r9v0 int) & (4 int) A[WRAPPED] (LINE:13)) != (0 int)) ? false : (r5v0 boolean))
      (wrap:java.lang.Integer:?: TERNARY null = ((wrap:int:0x0011: ARITH (r9v0 int) & (8 int) A[WRAPPED] (LINE:18)) != (0 int)) ? (null java.lang.Integer) : (r6v0 java.lang.Integer))
      (wrap:boolean:?: TERNARY null = ((wrap:int:0x0016: ARITH (r9v0 int) & (16 int) A[WRAPPED] (LINE:23)) != (0 int)) ? false : (r7v0 boolean))
      (wrap:boolean:?: TERNARY null = ((wrap:int:0x001b: ARITH (r9v0 int) & (32 int) A[WRAPPED] (LINE:28)) != (0 int)) ? false : (r8v0 boolean))
     A[MD:(boolean, java.lang.Integer, boolean, java.lang.Integer, boolean, boolean):void (m)] (LINE:33) call: okhttp3.internal.ws.WebSocketExtensions.<init>(boolean, java.lang.Integer, boolean, java.lang.Integer, boolean, boolean):void type: THIS */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public /* synthetic */ WebSocketExtensions(boolean z, Integer num, boolean z2, Integer num2, boolean z3, boolean z4, int i, we0 we0Var) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : num, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? false : z3, (i & 32) != 0 ? false : z4);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ WebSocketExtensions copy$default(WebSocketExtensions webSocketExtensions, boolean z, Integer num, boolean z2, Integer num2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            z = webSocketExtensions.perMessageDeflate;
        }
        if ((i & 2) != 0) {
            num = webSocketExtensions.clientMaxWindowBits;
        }
        if ((i & 4) != 0) {
            z2 = webSocketExtensions.clientNoContextTakeover;
        }
        if ((i & 8) != 0) {
            num2 = webSocketExtensions.serverMaxWindowBits;
        }
        if ((i & 16) != 0) {
            z3 = webSocketExtensions.serverNoContextTakeover;
        }
        if ((i & 32) != 0) {
            z4 = webSocketExtensions.unknownValues;
        }
        boolean z5 = z3;
        boolean z6 = z4;
        return webSocketExtensions.copy(z, num, z2, num2, z5, z6);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean component1() {
        return this.perMessageDeflate;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Integer component2() {
        return this.clientMaxWindowBits;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean component3() {
        return this.clientNoContextTakeover;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Integer component4() {
        return this.serverMaxWindowBits;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean component5() {
        return this.serverNoContextTakeover;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean component6() {
        return this.unknownValues;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final WebSocketExtensions copy(boolean z, Integer num, boolean z2, Integer num2, boolean z3, boolean z4) {
        return new WebSocketExtensions(z, num, z2, num2, z3, z4);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebSocketExtensions)) {
            return false;
        }
        WebSocketExtensions webSocketExtensions = (WebSocketExtensions) obj;
        return this.perMessageDeflate == webSocketExtensions.perMessageDeflate && il1.a(this.clientMaxWindowBits, webSocketExtensions.clientMaxWindowBits) && this.clientNoContextTakeover == webSocketExtensions.clientNoContextTakeover && il1.a(this.serverMaxWindowBits, webSocketExtensions.serverMaxWindowBits) && this.serverNoContextTakeover == webSocketExtensions.serverNoContextTakeover && this.unknownValues == webSocketExtensions.unknownValues;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.perMessageDeflate) * 31;
        Integer num = this.clientMaxWindowBits;
        int iHashCode2 = (((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + Boolean.hashCode(this.clientNoContextTakeover)) * 31;
        Integer num2 = this.serverMaxWindowBits;
        return ((((iHashCode2 + (num2 != null ? num2.hashCode() : 0)) * 31) + Boolean.hashCode(this.serverNoContextTakeover)) * 31) + Boolean.hashCode(this.unknownValues);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean noContextTakeover(boolean z) {
        return z ? this.clientNoContextTakeover : this.serverNoContextTakeover;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.perMessageDeflate + ", clientMaxWindowBits=" + this.clientMaxWindowBits + ", clientNoContextTakeover=" + this.clientNoContextTakeover + ", serverMaxWindowBits=" + this.serverMaxWindowBits + ", serverNoContextTakeover=" + this.serverNoContextTakeover + ", unknownValues=" + this.unknownValues + ')';
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Companion {
        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:1) call: okhttp3.internal.ws.WebSocketExtensions.Companion.<init>():void type: THIS */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public /* synthetic */ Companion(we0 we0Var) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Duplicate block (B:28:0x008b) to fix multi-entry loop: BACK_EDGE: B:28:0x008b -> B:14:0x0052 */
        public final WebSocketExtensions parse(Headers headers) {
            headers.getClass();
            int size = headers.size();
            boolean z = false;
            Integer numQ = null;
            boolean z2 = false;
            Integer numQ2 = null;
            boolean z3 = false;
            boolean z4 = false;
            for (int i = 0; i < size; i++) {
                if (sg4.y(headers.name(i), WebSocketExtensions.HEADER_WEB_SOCKET_EXTENSION, true)) {
                    String strValue = headers.value(i);
                    int i2 = 0;
                    while (i2 < strValue.length()) {
                        int i3 = i2;
                        int iDelimiterOffset$default = _UtilCommonKt.delimiterOffset$default(strValue, ',', i3, 0, 4, (Object) null);
                        int iDelimiterOffset = _UtilCommonKt.delimiterOffset(strValue, ';', i3, iDelimiterOffset$default);
                        String strTrimSubstring = _UtilCommonKt.trimSubstring(strValue, i3, iDelimiterOffset);
                        int i4 = iDelimiterOffset + 1;
                        if (sg4.y(strTrimSubstring, "permessage-deflate", true)) {
                            if (!z) {
                                z4 = true;
                                while (i4 < iDelimiterOffset$default) {
                                    int iDelimiterOffset2 = _UtilCommonKt.delimiterOffset(strValue, ';', i4, iDelimiterOffset$default);
                                    int iDelimiterOffset3 = _UtilCommonKt.delimiterOffset(strValue, '=', i4, iDelimiterOffset2);
                                    String strTrimSubstring2 = _UtilCommonKt.trimSubstring(strValue, i4, iDelimiterOffset3);
                                    String strS0 = iDelimiterOffset3 < iDelimiterOffset2 ? wg4.s0(_UtilCommonKt.trimSubstring(strValue, iDelimiterOffset3 + 1, iDelimiterOffset2), "\"") : null;
                                    int i5 = iDelimiterOffset2 + 1;
                                    if (sg4.y(strTrimSubstring2, "client_max_window_bits", true)) {
                                        if (numQ != null) {
                                            z4 = true;
                                        }
                                        numQ = strS0 != null ? rg4.q(strS0) : null;
                                        i4 = numQ == null ? i5 : i5;
                                    } else if (sg4.y(strTrimSubstring2, "client_no_context_takeover", true)) {
                                        if (z2) {
                                            z4 = true;
                                        }
                                        if (strS0 != null) {
                                            z4 = true;
                                        }
                                        i4 = i5;
                                        z2 = true;
                                    } else if (sg4.y(strTrimSubstring2, "server_max_window_bits", true)) {
                                        if (numQ2 != null) {
                                            z4 = true;
                                        }
                                        numQ2 = strS0 != null ? rg4.q(strS0) : null;
                                        if (numQ2 == null) {
                                        }
                                    } else if (sg4.y(strTrimSubstring2, "server_no_context_takeover", true)) {
                                        if (z3) {
                                            z4 = true;
                                        }
                                        if (strS0 != null) {
                                            z4 = true;
                                        }
                                        i4 = i5;
                                        z3 = true;
                                    }
                                }
                                i2 = i4;
                                z = true;
                            }
                            z4 = true;
                        } else {
                            i2 = i4;
                            z4 = true;
                        }
                    }
                }
            }
            return new WebSocketExtensions(z, numQ, z2, numQ2, z3, z4);
        }

        private Companion() {
        }
    }

    public WebSocketExtensions(boolean z, Integer num, boolean z2, Integer num2, boolean z3, boolean z4) {
        this.perMessageDeflate = z;
        this.clientMaxWindowBits = num;
        this.clientNoContextTakeover = z2;
        this.serverMaxWindowBits = num2;
        this.serverNoContextTakeover = z3;
        this.unknownValues = z4;
    }

    public WebSocketExtensions() {
        this(false, null, false, null, false, false, 63, null);
    }
}
