package defpackage;

import defpackage.za5;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class za5 {
    public static final Pattern a = Pattern.compile("(?s)^ +[/•] +(.*?) +$");

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ String a(String str) {
        Matcher matcher = a.matcher(str);
        return matcher.find() ? matcher.group(1) : str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void b(List list, List list2, ko1 ko1Var) {
        String strO;
        ko1 ko1VarM = ko1Var.m("onTap").m("innertubeCommand");
        int i = ko1Var.i("startIndex", -1);
        boolean z = false;
        int i2 = ko1Var.i(Name.LENGTH, 0);
        if (i < 0 || i2 < 1 || ko1VarM == null || (strO = cc5.O(ko1VarM)) == null) {
            return;
        }
        try {
            URL url = new URL(strO);
            if (!cc5.f0(url)) {
                if (cc5.e0(url)) {
                    z = true;
                }
            }
        } catch (MalformedURLException unused) {
        }
        String str = "<a href=\"" + bt0.l(strO) + "\">";
        Function functionJ = j(ko1Var, z);
        list.add(new a(str, "</a>", i, functionJ));
        list2.add(new a(str, "</a>", i + i2, functionJ));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void d(List list, List list2, ko1 ko1Var) {
        int i = ko1Var.i("startIndex", -1);
        int i2 = ko1Var.i(Name.LENGTH, 0);
        if (i < 0 || i2 < 1) {
            return;
        }
        int i3 = i2 + i;
        if (ko1Var.q("strikethrough")) {
            list.add(new a("<s>", "</s>", i));
            list2.add(new a("<s>", "</s>", i3));
        }
        if (ko1Var.e("italic", Boolean.FALSE)) {
            list.add(new a("<i>", "</i>", i));
            list2.add(new a("<i>", "</i>", i3));
        }
        if (!ko1Var.q("weightLabel") || "FONT_WEIGHT_NORMAL".equals(ko1Var.o("weightLabel"))) {
            return;
        }
        list.add(new a("<b>", "</b>", i));
        list2.add(new a("<b>", "</b>", i3));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ String e(String str, String str2) {
        return str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void g(ko1 ko1Var, final List list, final List list2) {
        ko1Var.b("commandRuns").stream().filter(new co1(ko1.class)).map(new e72(ko1.class)).forEach(new Consumer() { // from class: wa5
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                za5.b(list, list2, (ko1) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void h(ko1 ko1Var, final List list, final List list2) {
        ko1Var.b("styleRuns").stream().filter(new co1(ko1.class)).map(new e72(ko1.class)).forEach(new Consumer() { // from class: va5
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                za5.d(list, list2, (ko1) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String i(ko1 ko1Var) {
        String strO;
        if (yy4.p(ko1Var) || (strO = ko1Var.o("content")) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        g(ko1Var, arrayList, arrayList2);
        h(ko1Var, arrayList, arrayList2);
        Collections.sort(arrayList, Comparator.comparingInt(new ToIntFunction() { // from class: ta5
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return ((za5.a) obj).c;
            }
        }));
        Collections.sort(arrayList2, Comparator.comparingInt(new ToIntFunction() { // from class: ua5
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return ((za5.a) obj).c;
            }
        }));
        return k(arrayList, arrayList2, strO);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Function j(ko1 ko1Var, boolean z) {
        final String strReplaceFirst = ko1Var.m("onTapOptions").m("accessibilityInfo").p("accessibilityLabel", "").replaceFirst(" Channel Link", "");
        return (z || strReplaceFirst.isEmpty() || strReplaceFirst.startsWith("YouTube: ")) ? new Function() { // from class: xa5
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return za5.a((String) obj);
            }
        } : new Function() { // from class: ya5
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return za5.e(strReplaceFirst, (String) obj);
            }
        };
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String k(List list, List list2, String str) {
        int i;
        String strReplace = str.replace((char) 160, ' ');
        Stack stack = new Stack();
        Stack stack2 = new Stack();
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < list2.size()) {
            int iMin = i4 < list.size() ? Math.min(((a) list2.get(i2)).c, ((a) list.get(i4)).c) : ((a) list2.get(i2)).c;
            sb.append(bt0.l(strReplace.substring(i3, iMin)));
            if (((a) list2.get(i2)).c == iMin) {
                a aVar = (a) list2.get(i2);
                i2++;
                while (true) {
                    if (stack.empty()) {
                        break;
                    }
                    a aVar2 = (a) stack.pop();
                    if (aVar2.a(aVar)) {
                        if (aVar2.d != null && (i = aVar2.e) >= 0) {
                            sb.replace(i, sb.length(), (String) aVar2.d.apply(sb.substring(aVar2.e)));
                        }
                        sb.append(aVar2.b);
                    } else {
                        sb.append(aVar2.b);
                        stack2.push(aVar2);
                    }
                }
                while (!stack2.empty()) {
                    a aVar3 = (a) stack2.pop();
                    sb.append(aVar3.a);
                    stack.push(aVar3);
                }
            } else {
                a aVar4 = (a) list.get(i4);
                sb.append(aVar4.a);
                aVar4.e = sb.length();
                stack.push(aVar4);
                i4++;
            }
            i3 = iMin;
        }
        sb.append(bt0.l(strReplace.substring(i3)));
        return sb.toString().replace("\n", "<br>").replace("  ", " &nbsp;");
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final String a;
        public final String b;
        public final int c;
        public final Function d;
        public int e;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(String str, String str2, int i, Function function) {
            this.e = -1;
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = function;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean a(a aVar) {
            return this.a.equals(aVar.a);
        }

        public a(String str, String str2, int i) {
            this(str, str2, i, null);
        }
    }
}
