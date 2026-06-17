package j$.time.format;

import j$.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class v {
    public static final j$.time.d h = new j$.time.d(5);
    public static final Map i;
    public v a;
    public final v b;
    public final List c;
    public final boolean d;
    public int e;
    public char f;
    public int g;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        HashMap map = new HashMap();
        i = map;
        map.put('G', j$.time.temporal.a.ERA);
        map.put('y', j$.time.temporal.a.YEAR_OF_ERA);
        map.put('u', j$.time.temporal.a.YEAR);
        j$.time.temporal.g gVar = j$.time.temporal.i.a;
        map.put('Q', gVar);
        map.put('q', gVar);
        j$.time.temporal.a aVar = j$.time.temporal.a.MONTH_OF_YEAR;
        map.put('M', aVar);
        map.put('L', aVar);
        map.put('D', j$.time.temporal.a.DAY_OF_YEAR);
        map.put('d', j$.time.temporal.a.DAY_OF_MONTH);
        map.put('F', j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        j$.time.temporal.a aVar2 = j$.time.temporal.a.DAY_OF_WEEK;
        map.put('E', aVar2);
        map.put('c', aVar2);
        map.put('e', aVar2);
        map.put('a', j$.time.temporal.a.AMPM_OF_DAY);
        map.put('H', j$.time.temporal.a.HOUR_OF_DAY);
        map.put('k', j$.time.temporal.a.CLOCK_HOUR_OF_DAY);
        map.put('K', j$.time.temporal.a.HOUR_OF_AMPM);
        map.put('h', j$.time.temporal.a.CLOCK_HOUR_OF_AMPM);
        map.put('m', j$.time.temporal.a.MINUTE_OF_HOUR);
        map.put('s', j$.time.temporal.a.SECOND_OF_MINUTE);
        j$.time.temporal.a aVar3 = j$.time.temporal.a.NANO_OF_SECOND;
        map.put('S', aVar3);
        map.put('A', j$.time.temporal.a.MILLI_OF_DAY);
        map.put('n', aVar3);
        map.put('N', j$.time.temporal.a.NANO_OF_DAY);
        map.put('g', j$.time.temporal.k.a);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public v() {
        this.a = this;
        this.c = new ArrayList();
        this.g = -1;
        this.b = null;
        this.d = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void a(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        c(dateTimeFormatter.c());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void b(j$.time.temporal.a aVar, int i2, int i3, boolean z) {
        if (i2 != i3 || z) {
            c(new f(aVar, i2, i3, z));
        } else {
            l(new f(aVar, i2, i3, z));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int c(e eVar) {
        Objects.requireNonNull(eVar, "pp");
        v vVar = this.a;
        int i2 = vVar.e;
        if (i2 > 0) {
            l lVar = new l(eVar, i2, vVar.f);
            vVar.e = 0;
            vVar.f = (char) 0;
            eVar = lVar;
        }
        ((ArrayList) vVar.c).add(eVar);
        this.a.g = -1;
        return ((ArrayList) r4.c).size() - 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void d(char c) {
        c(new c(c));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void e(String str) {
        Objects.requireNonNull(str, "literal");
        if (str.isEmpty()) {
            return;
        }
        if (str.length() == 1) {
            c(new c(str.charAt(0)));
        } else {
            c(new h(str, 1));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void f(FormatStyle formatStyle, FormatStyle formatStyle2) {
        if (formatStyle == null && formatStyle2 == null) {
            j$.nio.file.j.a("Either the date or time style must be non-null");
        } else {
            c(new i(formatStyle, formatStyle2));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g(g0 g0Var) {
        Objects.requireNonNull(g0Var, "style");
        if (g0Var == g0.FULL || g0Var == g0.SHORT) {
            c(new h(g0Var, 0));
        } else {
            j$.nio.file.j.a("Style must be either full or short");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h(String str, String str2) {
        c(new k(str, str2));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:108:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x017a A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x037e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i(String str) {
        boolean z;
        int i2;
        int i3;
        Objects.requireNonNull(str, "pattern");
        int i4 = 0;
        while (i4 < str.length()) {
            char cCharAt = str.charAt(i4);
            if ((cCharAt >= 'A' && cCharAt <= 'Z') || (cCharAt >= 'a' && cCharAt <= 'z')) {
                int i5 = i4 + 1;
                while (i5 < str.length() && str.charAt(i5) == cCharAt) {
                    i5++;
                }
                int i6 = i5 - i4;
                if (cCharAt == 'p') {
                    if (i5 >= str.length() || (((cCharAt = str.charAt(i5)) < 'A' || cCharAt > 'Z') && (cCharAt < 'a' || cCharAt > 'z'))) {
                        i2 = i5;
                        i3 = i6;
                        i6 = 0;
                    } else {
                        i2 = i5 + 1;
                        while (i2 < str.length() && str.charAt(i2) == cCharAt) {
                            i2++;
                        }
                        i3 = i2 - i5;
                    }
                    if (i6 == 0) {
                        j$.nio.file.j.a("Pad letter 'p' must be followed by valid pad pattern: ".concat(str));
                        return;
                    }
                    if (i6 < 1) {
                        j$.nio.file.j.m("The pad width must be at least one but was ", i6);
                        return;
                    }
                    v vVar = this.a;
                    vVar.e = i6;
                    vVar.f = ' ';
                    vVar.g = -1;
                    i6 = i3;
                    i5 = i2;
                }
                j$.time.temporal.p pVar = (j$.time.temporal.p) ((HashMap) i).get(Character.valueOf(cCharAt));
                if (pVar != null) {
                    if (cCharAt == 'A') {
                        o(pVar, i6, 19, f0.NOT_NEGATIVE);
                    } else {
                        if (cCharAt == 'Q') {
                            z = false;
                        } else if (cCharAt == 'S') {
                            b(j$.time.temporal.a.NANO_OF_SECOND, i6, i6, false);
                        } else if (cCharAt == 'a') {
                            if (i6 != 1) {
                                j$.nio.file.j.i("Too many pattern letters: ", cCharAt);
                                return;
                            }
                            k(pVar, g0.SHORT);
                        } else if (cCharAt == 'k') {
                            if (i6 == 1) {
                                m(pVar);
                            } else {
                                if (i6 != 2) {
                                    j$.nio.file.j.i("Too many pattern letters: ", cCharAt);
                                    return;
                                }
                                n(pVar, i6);
                            }
                        } else if (cCharAt == 'q') {
                            z = true;
                        } else if (cCharAt != 's') {
                            if (cCharAt == 'u' || cCharAt == 'y') {
                                if (i6 == 2) {
                                    LocalDate localDate = p.h;
                                    Objects.requireNonNull(localDate, "baseDate");
                                    l(new p(pVar, 2, 2, localDate, 0));
                                } else if (i6 < 4) {
                                    o(pVar, i6, 19, f0.NORMAL);
                                } else {
                                    o(pVar, i6, 19, f0.EXCEEDS_PAD);
                                }
                            } else if (cCharAt == 'g') {
                                o(pVar, i6, 19, f0.NORMAL);
                            } else if (cCharAt != 'h' && cCharAt != 'm') {
                                if (cCharAt != 'n') {
                                    switch (cCharAt) {
                                        case Token.ENUM_ID /* 68 */:
                                            if (i6 == 1) {
                                                m(pVar);
                                            } else {
                                                if (i6 != 2 && i6 != 3) {
                                                    j$.nio.file.j.i("Too many pattern letters: ", cCharAt);
                                                    return;
                                                }
                                                o(pVar, i6, 3, f0.NOT_NEGATIVE);
                                            }
                                            break;
                                        case Token.THISFN /* 69 */:
                                            z = false;
                                            break;
                                        case 'F':
                                            if (i6 != 1) {
                                                j$.nio.file.j.i("Too many pattern letters: ", cCharAt);
                                                return;
                                            }
                                            m(pVar);
                                            break;
                                        case Token.ARRAYLIT /* 71 */:
                                            if (i6 == 1 || i6 == 2 || i6 == 3) {
                                                k(pVar, g0.SHORT);
                                            } else if (i6 == 4) {
                                                k(pVar, g0.FULL);
                                            } else {
                                                if (i6 != 5) {
                                                    j$.nio.file.j.i("Too many pattern letters: ", cCharAt);
                                                    return;
                                                }
                                                k(pVar, g0.NARROW);
                                            }
                                            break;
                                        default:
                                            switch (cCharAt) {
                                                case Token.DEL_REF /* 75 */:
                                                    break;
                                                case Token.REF_CALL /* 76 */:
                                                    z = true;
                                                    break;
                                                case Token.REF_SPECIAL /* 77 */:
                                                    z = false;
                                                    break;
                                                case Token.YIELD /* 78 */:
                                                    break;
                                                default:
                                                    switch (cCharAt) {
                                                        case 'c':
                                                            if (i6 == 1) {
                                                                int i7 = i6;
                                                                l(new s(cCharAt, i7, i7, i7, 0));
                                                            } else {
                                                                if (i6 == 2) {
                                                                    j$.nio.file.j.a("Invalid pattern \"cc\"");
                                                                    return;
                                                                }
                                                                z = true;
                                                            }
                                                            break;
                                                        case 'd':
                                                            break;
                                                        case 'e':
                                                            z = false;
                                                            break;
                                                        default:
                                                            if (i6 != 1) {
                                                                n(pVar, i6);
                                                            } else {
                                                                m(pVar);
                                                            }
                                                            break;
                                                    }
                                                    break;
                                            }
                                        case Token.OBJECTLIT /* 72 */:
                                            break;
                                    }
                                }
                            }
                        }
                        if (i6 == 1 || i6 == 2) {
                            if (cCharAt == 'e') {
                                int i8 = i6;
                                l(new s(cCharAt, i8, i8, i8, 0));
                            } else if (cCharAt == 'E') {
                                k(pVar, g0.SHORT);
                            } else if (i6 == 1) {
                                m(pVar);
                            } else {
                                n(pVar, 2);
                            }
                        } else if (i6 == 3) {
                            k(pVar, z ? g0.SHORT_STANDALONE : g0.SHORT);
                        } else if (i6 == 4) {
                            k(pVar, z ? g0.FULL_STANDALONE : g0.FULL);
                        } else {
                            if (i6 != 5) {
                                j$.nio.file.j.i("Too many pattern letters: ", cCharAt);
                                return;
                            }
                            k(pVar, z ? g0.NARROW_STANDALONE : g0.NARROW);
                        }
                    }
                } else if (cCharAt == 'z') {
                    if (i6 > 4) {
                        j$.nio.file.j.i("Too many pattern letters: ", cCharAt);
                        return;
                    } else if (i6 == 4) {
                        c(new u(g0.FULL, false));
                    } else {
                        c(new u(g0.SHORT, false));
                    }
                } else if (cCharAt == 'V') {
                    if (i6 != 2) {
                        j$.nio.file.j.i("Pattern letter count must be 2: ", cCharAt);
                        return;
                    }
                    c(new t(j$.time.temporal.q.a, "ZoneId()"));
                } else if (cCharAt != 'v') {
                    String str2 = "+0000";
                    if (cCharAt == 'Z') {
                        if (i6 < 4) {
                            h("+HHMM", "+0000");
                        } else if (i6 == 4) {
                            g(g0.FULL);
                        } else {
                            if (i6 != 5) {
                                j$.nio.file.j.i("Too many pattern letters: ", cCharAt);
                                return;
                            }
                            h("+HH:MM:ss", "Z");
                        }
                    } else if (cCharAt == 'O') {
                        if (i6 == 1) {
                            g(g0.SHORT);
                        } else {
                            if (i6 != 4) {
                                j$.nio.file.j.i("Pattern letter count must be 1 or 4: ", cCharAt);
                                return;
                            }
                            g(g0.FULL);
                        }
                    } else if (cCharAt == 'X') {
                        if (i6 > 5) {
                            j$.nio.file.j.i("Too many pattern letters: ", cCharAt);
                            return;
                        }
                        h(k.d[i6 + (i6 == 1 ? 0 : 1)], "Z");
                    } else if (cCharAt == 'x') {
                        if (i6 > 5) {
                            j$.nio.file.j.i("Too many pattern letters: ", cCharAt);
                            return;
                        }
                        if (i6 == 1) {
                            str2 = "+00";
                        } else if (i6 % 2 != 0) {
                            str2 = "+00:00";
                        }
                        h(k.d[i6 + (i6 == 1 ? 0 : 1)], str2);
                    } else if (cCharAt != 'W') {
                        int i9 = i6;
                        if (cCharAt == 'w') {
                            if (i9 > 2) {
                                j$.nio.file.j.i("Too many pattern letters: ", cCharAt);
                                return;
                            }
                            l(new s(cCharAt, i9, i9, 2, 0));
                        } else if (cCharAt != 'Y') {
                            j$.nio.file.j.i("Unknown pattern letter: ", cCharAt);
                            return;
                        } else if (i9 == 2) {
                            l(new s(cCharAt, i9, i9, 2, 0));
                        } else {
                            l(new s(cCharAt, i9, i9, 19, 0));
                        }
                    } else if (i6 > 1) {
                        j$.nio.file.j.i("Too many pattern letters: ", cCharAt);
                        return;
                    } else {
                        int i10 = i6;
                        l(new s(cCharAt, i10, i10, i10, 0));
                    }
                } else if (i6 == 1) {
                    c(new u(g0.SHORT, true));
                } else {
                    if (i6 != 4) {
                        j$.nio.file.j.i("Wrong number of  pattern letters: ", cCharAt);
                        return;
                    }
                    c(new u(g0.FULL, true));
                }
                i4 = i5 - 1;
            } else if (cCharAt == '\'') {
                int i11 = i4 + 1;
                int i12 = i11;
                while (i12 < str.length()) {
                    if (str.charAt(i12) == '\'') {
                        int i13 = i12 + 1;
                        if (i13 < str.length() && str.charAt(i13) == '\'') {
                            i12 = i13;
                        } else {
                            if (i12 < str.length()) {
                                j$.nio.file.j.a("Pattern ends with an incomplete string literal: ".concat(str));
                                return;
                            }
                            String strSubstring = str.substring(i11, i12);
                            if (strSubstring.isEmpty()) {
                                d('\'');
                            } else {
                                e(strSubstring.replace("''", "'"));
                            }
                            i4 = i12;
                        }
                    }
                    i12++;
                }
                if (i12 < str.length()) {
                }
            } else if (cCharAt == '[') {
                q();
            } else if (cCharAt == ']') {
                if (this.a.b == null) {
                    j$.nio.file.j.a("Pattern invalid as it contains ] without previous [");
                    return;
                }
                p();
            } else {
                if (cCharAt == '{' || cCharAt == '}' || cCharAt == '#') {
                    throw new IllegalArgumentException("Pattern includes reserved character: '" + cCharAt + "'");
                }
                d(cCharAt);
            }
            i4++;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void j(j$.time.temporal.a aVar, Map map) {
        Objects.requireNonNull(aVar, "field");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        g0 g0Var = g0.FULL;
        c(new r(aVar, g0Var, new a(new a0(Collections.singletonMap(g0Var, linkedHashMap)))));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void k(j$.time.temporal.p pVar, g0 g0Var) {
        Objects.requireNonNull(g0Var, "textStyle");
        c(new r(pVar, g0Var, b0.c));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void l(j jVar) {
        j jVarD;
        v vVar = this.a;
        int i2 = vVar.g;
        if (i2 < 0) {
            vVar.g = c(jVar);
            return;
        }
        j jVar2 = (j) ((ArrayList) vVar.c).get(i2);
        int i3 = jVar.b;
        int i4 = jVar.c;
        if (i3 == i4 && jVar.d == f0.NOT_NEGATIVE) {
            jVarD = jVar2.e(i4);
            c(jVar.d());
            this.a.g = i2;
        } else {
            jVarD = jVar2.d();
            this.a.g = c(jVar);
        }
        ((ArrayList) this.a.c).set(i2, jVarD);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void m(j$.time.temporal.p pVar) {
        l(new j(pVar, 1, 19, f0.NORMAL));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void n(j$.time.temporal.p pVar, int i2) {
        Objects.requireNonNull(pVar, "field");
        if (i2 < 1 || i2 > 19) {
            j$.nio.file.j.m("The width must be from 1 to 19 inclusive but was ", i2);
        } else {
            l(new j(pVar, i2, i2, f0.NOT_NEGATIVE));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void o(j$.time.temporal.p pVar, int i2, int i3, f0 f0Var) {
        if (i2 == i3 && f0Var == f0.NOT_NEGATIVE) {
            n(pVar, i3);
            return;
        }
        Objects.requireNonNull(pVar, "field");
        Objects.requireNonNull(f0Var, "signStyle");
        if (i2 < 1 || i2 > 19) {
            j$.nio.file.j.m("The minimum width must be from 1 to 19 inclusive but was ", i2);
            return;
        }
        if (i3 < 1 || i3 > 19) {
            j$.nio.file.j.m("The maximum width must be from 1 to 19 inclusive but was ", i3);
            return;
        }
        if (i3 >= i2) {
            l(new j(pVar, i2, i3, f0Var));
            return;
        }
        throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + i3 + " < " + i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void p() {
        v vVar = this.a;
        if (vVar.b == null) {
            throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
        }
        int size = ((ArrayList) vVar.c).size();
        v vVar2 = this.a;
        if (size <= 0) {
            this.a = vVar2.b;
            return;
        }
        d dVar = new d(vVar2.c, vVar2.d);
        this.a = this.a.b;
        c(dVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void q() {
        v vVar = this.a;
        vVar.g = -1;
        this.a = new v(vVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final DateTimeFormatter r(e0 e0Var, j$.time.chrono.l lVar) {
        return s(Locale.getDefault(), e0Var, lVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final DateTimeFormatter s(Locale locale, e0 e0Var, j$.time.chrono.l lVar) {
        Objects.requireNonNull(locale, "locale");
        while (this.a.b != null) {
            p();
        }
        return new DateTimeFormatter(new d(this.c, false), locale, c0.a, e0Var, lVar, null);
    }

    public v(v vVar) {
        this.a = this;
        this.c = new ArrayList();
        this.g = -1;
        this.b = vVar;
        this.d = true;
    }
}
