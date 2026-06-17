package is.xyz.mpv;

import defpackage.fu4;
import defpackage.y42;
import java.util.Map;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class KeyMappingKt {
    private static final Map<Integer, String> KeyMapping = y42.j(fu4.a(62, "SPACE"), fu4.a(66, "ENTER"), fu4.a(61, "TAB"), fu4.a(67, "BS"), fu4.a(Integer.valueOf(Token.ASSIGN_MOD), "DEL"), fu4.a(Integer.valueOf(Token.IMPORT), "INS"), fu4.a(Integer.valueOf(Token.FUNCTION), "HOME"), fu4.a(Integer.valueOf(Token.EXPORT), "END"), fu4.a(92, "PGUP"), fu4.a(93, "PGDWN"), fu4.a(Integer.valueOf(Token.ASSIGN_DIV), "ESC"), fu4.a(120, "PRINT"), fu4.a(22, "RIGHT"), fu4.a(21, "LEFT"), fu4.a(20, "DOWN"), fu4.a(19, "UP"), fu4.a(126, "PLAYONLY"), fu4.a(127, "PAUSEONLY"), fu4.a(85, "PLAYPAUSE"), fu4.a(86, "STOP"), fu4.a(90, "FORWARD"), fu4.a(89, "REWIND"), fu4.a(87, "NEXT"), fu4.a(88, "PREV"), fu4.a(130, "RECORD"), fu4.a(Integer.valueOf(Token.SET), "CHANNEL_UP"), fu4.a(Integer.valueOf(Token.LET), "CHANNEL_DOWN"), fu4.a(Integer.valueOf(Token.CONST), "ZOOMIN"), fu4.a(Integer.valueOf(Token.SETCONST), "ZOOMOUT"), fu4.a(Integer.valueOf(Token.DO), "F1"), fu4.a(Integer.valueOf(Token.FOR), "F2"), fu4.a(Integer.valueOf(Token.BREAK), "F3"), fu4.a(Integer.valueOf(Token.CONTINUE), "F4"), fu4.a(Integer.valueOf(Token.VAR), "F5"), fu4.a(Integer.valueOf(Token.WITH), "F6"), fu4.a(Integer.valueOf(Token.CATCH), "F7"), fu4.a(Integer.valueOf(Token.FINALLY), "F8"), fu4.a(Integer.valueOf(Token.VOID), "F9"), fu4.a(140, "F10"), fu4.a(Integer.valueOf(Token.EMPTY), "F11"), fu4.a(Integer.valueOf(Token.COMPUTED_PROPERTY), "F12"), fu4.a(Integer.valueOf(Token.LABEL), "KP0"), fu4.a(Integer.valueOf(Token.TARGET), "KP1"), fu4.a(Integer.valueOf(Token.LOOP), "KP2"), fu4.a(Integer.valueOf(Token.EXPR_VOID), "KP3"), fu4.a(Integer.valueOf(Token.EXPR_RESULT), "KP4"), fu4.a(Integer.valueOf(Token.JSR), "KP5"), fu4.a(150, "KP6"), fu4.a(Integer.valueOf(Token.TYPEOFNAME), "KP7"), fu4.a(Integer.valueOf(Token.USE_STACK), "KP8"), fu4.a(Integer.valueOf(Token.SETPROP_OP), "KP9"), fu4.a(Integer.valueOf(Token.COLONCOLON), "KP_DEC"), fu4.a(160, "KP_ENTER"), fu4.a(Integer.valueOf(Token.TAGGED_TEMPLATE_LITERAL), "F13"), fu4.a(Integer.valueOf(Token.DOTDOTDOT), "F14"), fu4.a(Integer.valueOf(Token.NULLISH_COALESCING), "F15"), fu4.a(Integer.valueOf(Token.QUESTION_DOT), "F16"));

    public static final Map<Integer, String> getKeyMapping() {
        return KeyMapping;
    }
}
