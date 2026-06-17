package defpackage;

import java.util.Locale;
import okhttp3.internal.ws.WebSocketProtocol;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public enum w91 {
    NO_ERROR(0, "No error"),
    OPEN_FAILED(101, "Failed to open given input"),
    READ_FAILED(102, "Failed to read from given input"),
    NOT_GIF_FILE(103, "Data is not in GIF format"),
    NO_SCRN_DSCR(Token.ASSIGN_LOGICAL_AND, "No screen descriptor detected"),
    NO_IMAG_DSCR(Token.ASSIGN_LSH, "No image descriptor detected"),
    NO_COLOR_MAP(Token.ASSIGN_RSH, "Neither global nor local color map found"),
    WRONG_RECORD(Token.ASSIGN_URSH, "Wrong record type detected"),
    DATA_TOO_BIG(Token.ASSIGN_ADD, "Number of pixels bigger than width * height"),
    NOT_ENOUGH_MEM(Token.ASSIGN_SUB, "Failed to allocate required memory"),
    CLOSE_FAILED(110, "Failed to close given input"),
    NOT_READABLE(Token.ASSIGN_DIV, "Given file was not opened for read"),
    IMAGE_DEFECT(Token.ASSIGN_MOD, "Image is defective, decoding aborted"),
    EOF_TOO_SOON(Token.ASSIGN_EXP, "Image EOF detected before image complete"),
    NO_FRAMES(1000, "No frames found, at least one frame required"),
    INVALID_SCR_DIMS(WebSocketProtocol.CLOSE_CLIENT_GOING_AWAY, "Invalid screen size, dimensions must be positive"),
    INVALID_IMG_DIMS(1002, "Invalid image size, dimensions must be positive"),
    IMG_NOT_CONFINED(1003, "Image size exceeds screen size"),
    REWIND_FAILED(1004, "Input source rewind failed, animation stopped"),
    INVALID_BYTE_BUFFER(WebSocketProtocol.CLOSE_NO_STATUS_CODE, "Invalid and/or indirect byte buffer specified"),
    UNKNOWN(-1, "Unknown error");

    public final String f;
    public int g;

    w91(int i, String str) {
        this.g = i;
        this.f = str;
    }

    public static w91 b(int i) {
        for (w91 w91Var : values()) {
            if (w91Var.g == i) {
                return w91Var;
            }
        }
        w91 w91Var2 = UNKNOWN;
        w91Var2.g = i;
        return w91Var2;
    }

    public String e() {
        return String.format(Locale.ENGLISH, "GifError %d: %s", Integer.valueOf(this.g), this.f);
    }
}
