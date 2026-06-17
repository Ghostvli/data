package defpackage;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class rp3 implements Serializable {
    public static final a g = new a(null);
    public final Pattern f;

    /* JADX WARN: Illegal instructions before constructor call */
    public rp3(String str) {
        str.getClass();
        Pattern patternCompile = Pattern.compile(str);
        patternCompile.getClass();
        this(patternCompile);
    }

    public final l52 a(CharSequence charSequence, int i) {
        charSequence.getClass();
        Matcher matcherRegion = this.f.matcher(charSequence).useAnchoringBounds(false).useTransparentBounds(true).region(i, charSequence.length());
        if (matcherRegion.lookingAt()) {
            return new m52(matcherRegion, charSequence);
        }
        return null;
    }

    public final boolean b(CharSequence charSequence) {
        charSequence.getClass();
        return this.f.matcher(charSequence).matches();
    }

    public final String c(CharSequence charSequence, String str) {
        charSequence.getClass();
        str.getClass();
        String strReplaceAll = this.f.matcher(charSequence).replaceAll(str);
        strReplaceAll.getClass();
        return strReplaceAll;
    }

    public String toString() {
        String string = this.f.toString();
        string.getClass();
        return string;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public /* synthetic */ a(we0 we0Var) {
            this();
        }

        public a() {
        }
    }

    public rp3(Pattern pattern) {
        pattern.getClass();
        this.f = pattern;
    }
}
