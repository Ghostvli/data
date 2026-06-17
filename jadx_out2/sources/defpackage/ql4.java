package defpackage;

import com.thegrizzlylabs.sardineandroid.util.SardineUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ql4 {
    public static final ql4 d = t();
    public final Map a;
    public final ql4 b;
    public ArrayList c;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ql4(ql4 ql4Var) {
        this(ql4Var.b, q(ql4Var));
        if (ql4Var.a.isEmpty()) {
            return;
        }
        for (Map.Entry entry : ql4Var.a.entrySet()) {
            HashMap map = new HashMap(((Map) entry.getValue()).size());
            for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                map.put((String) entry2.getKey(), ((al4) entry2.getValue()).clone());
            }
            this.a.put((String) entry.getKey(), map);
        }
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0002: CONSTRUCTOR  A[MD:():void (c)] (LINE:3) call: java.util.HashMap.<init>():void type: CONSTRUCTOR */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ Map k(String str) {
        return new HashMap();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ql4 o() {
        return new ql4(d, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ArrayList q(ql4 ql4Var) {
        if (ql4Var.c == null) {
            return null;
        }
        return new ArrayList(ql4Var.c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ql4 t() {
        String[] strArr = {"object", "base", "font", "tt", "i", "b", "u", "big", "small", "em", "strong", "dfn", "code", "samp", "kbd", "var", "cite", "abbr", "time", "acronym", "mark", "ruby", "rt", "rp", "rtc", "a", "img", "wbr", "map", "q", "sub", "sup", "bdo", "iframe", "embed", "span", "input", "select", "textarea", "label", "optgroup", "option", "legend", "datalist", "keygen", "output", "progress", "meter", "area", "param", "source", "track", "summary", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track", "data", "bdi", SardineUtil.CUSTOM_NAMESPACE_PREFIX, "strike", "nobr", "rb"};
        String[] strArr2 = {"title", "a", "p", "h1", "h2", "h3", "h4", "h5", "h6", "pre", "address", "li", "th", "td", "script", "style", "ins", "del", SardineUtil.CUSTOM_NAMESPACE_PREFIX, "button"};
        return new ql4().u("http://www.w3.org/1999/xhtml", new String[]{"html", "head", "body", "frameset", "script", "noscript", "style", "meta", "link", "title", "frame", "noframes", "section", "nav", "aside", "hgroup", "header", "footer", "p", "h1", "h2", "h3", "h4", "h5", "h6", "button", "ul", "ol", "pre", "div", "blockquote", "hr", "address", "figure", "figcaption", "form", "fieldset", "ins", "del", "dl", "dt", "dd", "li", "table", "caption", "thead", "tfoot", "tbody", "colgroup", "col", "tr", "th", "td", "video", "audio", "canvas", "details", "menu", "plaintext", "template", "article", "main", "center", "template", "dir", "applet", "marquee", "listing", "#root"}, new Consumer() { // from class: hl4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((al4) obj).l(al4.l);
            }
        }).u("http://www.w3.org/1999/xhtml", strArr, new Consumer() { // from class: ll4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((al4) obj).l(0);
            }
        }).u("http://www.w3.org/1999/xhtml", strArr2, new Consumer() { // from class: ml4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((al4) obj).l(al4.m);
            }
        }).u("http://www.w3.org/1999/xhtml", new String[]{"meta", "link", "base", "frame", "img", "br", "wbr", "embed", "hr", "input", "keygen", "col", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track"}, new Consumer() { // from class: nl4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((al4) obj).l(al4.k);
            }
        }).u("http://www.w3.org/1999/xhtml", new String[]{"pre", "plaintext", "title", "textarea", "script"}, new Consumer() { // from class: ol4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((al4) obj).l(al4.p);
            }
        }).u("http://www.w3.org/1999/xhtml", new String[]{"title", "textarea"}, new Consumer() { // from class: pl4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((al4) obj).l(al4.q);
            }
        }).u("http://www.w3.org/1999/xhtml", new String[]{"iframe", "noembed", "noframes", "script", "style", "xmp"}, new Consumer() { // from class: dl4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((al4) obj).l(al4.r);
            }
        }).u("http://www.w3.org/1999/xhtml", s54.a, new Consumer() { // from class: el4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((al4) obj).l(al4.s);
            }
        }).u("http://www.w3.org/1998/Math/MathML", new String[]{"math"}, new Consumer() { // from class: fl4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((al4) obj).l(al4.l);
            }
        }).u("http://www.w3.org/1998/Math/MathML", new String[]{"mi", "mo", "msup", "mn", "mtext"}, new Consumer() { // from class: gl4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((al4) obj).l(0);
            }
        }).u("http://www.w3.org/2000/svg", new String[]{"svg", "femerge", "femergenode"}, new Consumer() { // from class: il4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((al4) obj).l(al4.l);
            }
        }).u("http://www.w3.org/2000/svg", new String[]{"text"}, new Consumer() { // from class: jl4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((al4) obj).l(0);
            }
        }).u("http://www.w3.org/2000/svg", new String[]{"script"}, new Consumer() { // from class: kl4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((al4) obj).l(al4.r);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (obj instanceof ql4) {
            return Objects.equals(this.a, ((ql4) obj).a);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return Objects.hashCode(this.a);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ql4 p(al4 al4Var) {
        al4Var.l(al4.j);
        r(al4Var);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void r(al4 al4Var) {
        ArrayList arrayList = this.c;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((Consumer) it.next()).accept(al4Var);
            }
        }
        ((Map) this.a.computeIfAbsent(al4Var.f, new Function() { // from class: cl4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ql4.k((String) obj);
            }
        })).put(al4Var.g, al4Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public al4 s(String str, String str2) {
        al4 al4VarS;
        al4 al4Var;
        zy4.j(str);
        zy4.j(str2);
        Map map = (Map) this.a.get(str2);
        if (map != null && (al4Var = (al4) map.get(str)) != null) {
            return al4Var;
        }
        ql4 ql4Var = this.b;
        if (ql4Var == null || (al4VarS = ql4Var.s(str, str2)) == null) {
            return null;
        }
        al4 al4VarA = al4VarS.clone();
        r(al4VarA);
        return al4VarA;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ql4 u(String str, String[] strArr, Consumer consumer) {
        for (String str2 : strArr) {
            al4 al4VarS = s(str2, str);
            if (al4VarS == null) {
                al4VarS = new al4(str2, str2, str);
                al4VarS.i = 0;
                p(al4VarS);
            }
            consumer.accept(al4VarS);
        }
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public al4 v(String str, String str2, g83 g83Var) {
        return w(str, null, str2, g83Var.f());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public al4 w(String str, String str2, String str3, boolean z) {
        zy4.j(str);
        zy4.j(str3);
        String strTrim = str.trim();
        zy4.h(strTrim);
        al4 al4VarS = s(strTrim, str3);
        if (al4VarS != null) {
            return al4VarS;
        }
        if (str2 == null) {
            str2 = g83.a(strTrim);
        }
        if (!z) {
            strTrim = str2;
        }
        al4 al4VarS2 = s(str2, str3);
        if (al4VarS2 == null) {
            al4 al4Var = new al4(strTrim, str2, str3);
            r(al4Var);
            return al4Var;
        }
        if (!z || strTrim.equals(str2)) {
            return al4VarS2;
        }
        al4 al4VarA = al4VarS2.clone();
        al4VarA.g = strTrim;
        r(al4VarA);
        return al4VarA;
    }

    public ql4() {
        this(null, null);
    }

    public ql4(ql4 ql4Var, ArrayList arrayList) {
        this.a = new HashMap();
        this.b = ql4Var;
        this.c = arrayList;
    }
}
