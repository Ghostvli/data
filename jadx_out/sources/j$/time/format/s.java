package j$.time.format;

import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class s extends j {
    public final char g;
    public final int h;

    public s(char c, int i, int i2, int i3, int i4) {
        super(null, i2, i3, f0.NOT_NEGATIVE, i4);
        this.g = c;
        this.h = i;
    }

    @Override // j$.time.format.j, j$.time.format.e
    public final int H(w wVar, CharSequence charSequence, int i) {
        return f(wVar.a.b).H(wVar, charSequence, i);
    }

    @Override // j$.time.format.j
    public final j d() {
        if (this.e == -1) {
            return this;
        }
        return new s(this.g, this.h, this.b, this.c, -1);
    }

    @Override // j$.time.format.j
    public final j e(int i) {
        return new s(this.g, this.h, this.b, this.c, this.e + i);
    }

    public final j f(Locale locale) {
        j$.time.temporal.t tVar;
        ConcurrentMap concurrentMap = j$.time.temporal.u.g;
        Objects.requireNonNull(locale, "locale");
        j$.time.temporal.u uVarA = j$.time.temporal.u.a(j$.time.c.a[((((int) (((long) (r7.getFirstDayOfWeek() - 1)) % 7)) + 7) + j$.time.c.SUNDAY.ordinal()) % 7], Calendar.getInstance(new Locale(locale.getLanguage(), locale.getCountry())).getMinimalDaysInFirstWeek());
        char c = this.g;
        if (c == 'W') {
            tVar = uVarA.d;
        } else {
            if (c == 'Y') {
                j$.time.temporal.t tVar2 = uVarA.f;
                int i = this.h;
                if (i == 2) {
                    return new p(tVar2, 2, 2, p.h, this.e);
                }
                return new j(tVar2, i, 19, i < 4 ? f0.NORMAL : f0.EXCEEDS_PAD, this.e);
            }
            if (c == 'c' || c == 'e') {
                tVar = uVarA.c;
            } else {
                if (c != 'w') {
                    throw new IllegalStateException("unreachable");
                }
                tVar = uVarA.e;
            }
        }
        return new j(tVar, this.b, this.c, f0.NOT_NEGATIVE, this.e);
    }

    @Override // j$.time.format.j
    public final String toString() {
        StringBuilder sb = new StringBuilder(30);
        sb.append("Localized(");
        int i = this.h;
        char c = this.g;
        if (c != 'Y') {
            if (c == 'W') {
                sb.append("WeekOfMonth");
            } else if (c == 'c' || c == 'e') {
                sb.append("DayOfWeek");
            } else if (c == 'w') {
                sb.append("WeekOfWeekBasedYear");
            }
            sb.append(",");
            sb.append(i);
        } else if (i == 1) {
            sb.append("WeekBasedYear");
        } else if (i == 2) {
            sb.append("ReducedValue(WeekBasedYear,2,2,2000-01-01)");
        } else {
            sb.append("WeekBasedYear,");
            sb.append(i);
            sb.append(",19,");
            sb.append(i < 4 ? f0.NORMAL : f0.EXCEEDS_PAD);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // j$.time.format.j, j$.time.format.e
    public final boolean u(y yVar, StringBuilder sb) {
        return f(yVar.b.b).u(yVar, sb);
    }
}
