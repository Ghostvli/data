package okhttp3.internal.http2;

import defpackage.gt0;
import defpackage.ht0;
import defpackage.we0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class ErrorCode {
    private static final /* synthetic */ gt0 $ENTRIES;
    private static final /* synthetic */ ErrorCode[] $VALUES;
    public static final Companion Companion;
    private final int httpCode;
    public static final ErrorCode NO_ERROR = new ErrorCode("NO_ERROR", 0, 0);
    public static final ErrorCode PROTOCOL_ERROR = new ErrorCode("PROTOCOL_ERROR", 1, 1);
    public static final ErrorCode INTERNAL_ERROR = new ErrorCode("INTERNAL_ERROR", 2, 2);
    public static final ErrorCode FLOW_CONTROL_ERROR = new ErrorCode("FLOW_CONTROL_ERROR", 3, 3);
    public static final ErrorCode SETTINGS_TIMEOUT = new ErrorCode("SETTINGS_TIMEOUT", 4, 4);
    public static final ErrorCode STREAM_CLOSED = new ErrorCode("STREAM_CLOSED", 5, 5);
    public static final ErrorCode FRAME_SIZE_ERROR = new ErrorCode("FRAME_SIZE_ERROR", 6, 6);
    public static final ErrorCode REFUSED_STREAM = new ErrorCode("REFUSED_STREAM", 7, 7);
    public static final ErrorCode CANCEL = new ErrorCode("CANCEL", 8, 8);
    public static final ErrorCode COMPRESSION_ERROR = new ErrorCode("COMPRESSION_ERROR", 9, 9);
    public static final ErrorCode CONNECT_ERROR = new ErrorCode("CONNECT_ERROR", 10, 10);
    public static final ErrorCode ENHANCE_YOUR_CALM = new ErrorCode("ENHANCE_YOUR_CALM", 11, 11);
    public static final ErrorCode INADEQUATE_SECURITY = new ErrorCode("INADEQUATE_SECURITY", 12, 12);
    public static final ErrorCode HTTP_1_1_REQUIRED = new ErrorCode("HTTP_1_1_REQUIRED", 13, 13);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static final /* synthetic */ ErrorCode[] $values() {
        return new ErrorCode[]{NO_ERROR, PROTOCOL_ERROR, INTERNAL_ERROR, FLOW_CONTROL_ERROR, SETTINGS_TIMEOUT, STREAM_CLOSED, FRAME_SIZE_ERROR, REFUSED_STREAM, CANCEL, COMPRESSION_ERROR, CONNECT_ERROR, ENHANCE_YOUR_CALM, INADEQUATE_SECURITY, HTTP_1_1_REQUIRED};
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        ErrorCode[] errorCodeArr$values = $values();
        $VALUES = errorCodeArr$values;
        $ENTRIES = ht0.a(errorCodeArr$values);
        Companion = new Companion(null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private ErrorCode(String str, int i, int i2) {
        this.httpCode = i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static gt0 getEntries() {
        return $ENTRIES;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ErrorCode valueOf(String str) {
        return (ErrorCode) Enum.valueOf(ErrorCode.class, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ErrorCode[] values() {
        return (ErrorCode[]) $VALUES.clone();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int getHttpCode() {
        return this.httpCode;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Companion {
        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:1) call: okhttp3.internal.http2.ErrorCode.Companion.<init>():void type: THIS */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public /* synthetic */ Companion(we0 we0Var) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final ErrorCode fromHttp2(int i) {
            for (ErrorCode errorCode : ErrorCode.values()) {
                if (errorCode.getHttpCode() == i) {
                    return errorCode;
                }
            }
            return null;
        }

        private Companion() {
        }
    }
}
