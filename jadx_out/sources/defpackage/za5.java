package defpackage;

import defpackage.za5;
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

    public static /* synthetic */ String a(String str) {
        Matcher matcher = a.matcher(str);
        return matcher.find() ? matcher.group(1) : str;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void b(java.util.List r7, java.util.List r8, defpackage.ko1 r9) {
        /*
            java.lang.String r0 = "onTap"
            ko1 r0 = r9.m(r0)
            java.lang.String r1 = "innertubeCommand"
            ko1 r0 = r0.m(r1)
            java.lang.String r1 = "startIndex"
            r2 = -1
            int r1 = r9.i(r1, r2)
            java.lang.String r2 = "length"
            r3 = 0
            int r2 = r9.i(r2, r3)
            if (r1 < 0) goto L69
            r4 = 1
            if (r2 < r4) goto L69
            if (r0 != 0) goto L22
            goto L69
        L22:
            java.lang.String r0 = defpackage.cc5.O(r0)
            if (r0 != 0) goto L29
            goto L69
        L29:
            java.net.URL r5 = new java.net.URL     // Catch: java.net.MalformedURLException -> L3b
            r5.<init>(r0)     // Catch: java.net.MalformedURLException -> L3b
            boolean r6 = defpackage.cc5.f0(r5)     // Catch: java.net.MalformedURLException -> L3b
            if (r6 != 0) goto L3a
            boolean r5 = defpackage.cc5.e0(r5)     // Catch: java.net.MalformedURLException -> L3b
            if (r5 == 0) goto L3b
        L3a:
            r3 = r4
        L3b:
            java.lang.String r0 = defpackage.bt0.l(r0)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "<a href=\""
            r4.<init>(r5)
            r4.append(r0)
            java.lang.String r0 = "\">"
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            java.util.function.Function r9 = j(r9, r3)
            za5$a r3 = new za5$a
            java.lang.String r4 = "</a>"
            r3.<init>(r0, r4, r1, r9)
            r7.add(r3)
            za5$a r7 = new za5$a
            int r1 = r1 + r2
            r7.<init>(r0, r4, r1, r9)
            r8.add(r7)
        L69:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.za5.b(java.util.List, java.util.List, ko1):void");
    }

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

    public static /* synthetic */ String e(String str, String str2) {
        return str;
    }

    public static void g(ko1 ko1Var, final List list, final List list2) {
        ko1Var.b("commandRuns").stream().filter(new co1(ko1.class)).map(new e72(ko1.class)).forEach(new Consumer() { // from class: wa5
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                za5.b(list, list2, (ko1) obj);
            }
        });
    }

    public static void h(ko1 ko1Var, final List list, final List list2) {
        ko1Var.b("styleRuns").stream().filter(new co1(ko1.class)).map(new e72(ko1.class)).forEach(new Consumer() { // from class: va5
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                za5.d(list, list2, (ko1) obj);
            }
        });
    }

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
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return ((za5.a) obj).c;
            }
        }));
        Collections.sort(arrayList2, Comparator.comparingInt(new ToIntFunction() { // from class: ua5
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return ((za5.a) obj).c;
            }
        }));
        return k(arrayList, arrayList2, strO);
    }

    public static Function j(ko1 ko1Var, boolean z) {
        final String strReplaceFirst = ko1Var.m("onTapOptions").m("accessibilityInfo").p("accessibilityLabel", "").replaceFirst(" Channel Link", "");
        return (z || strReplaceFirst.isEmpty() || strReplaceFirst.startsWith("YouTube: ")) ? new Function() { // from class: xa5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return za5.a((String) obj);
            }
        } : new Function() { // from class: ya5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return za5.e(strReplaceFirst, (String) obj);
            }
        };
    }

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

        public a(String str, String str2, int i, Function function) {
            this.e = -1;
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = function;
        }

        public boolean a(a aVar) {
            return this.a.equals(aVar.a);
        }

        public a(String str, String str2, int i) {
            this(str, str2, i, null);
        }
    }
}
