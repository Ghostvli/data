package defpackage;

import android.text.TextUtils;
import defpackage.ki4;
import defpackage.t41;
import defpackage.yz3;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class d95 implements hz0 {
    public static final Pattern i = Pattern.compile("LOCAL:([^,]+)");
    public static final Pattern j = Pattern.compile("MPEGTS:(-?\\d+)");
    public final String a;
    public final yo4 b;
    public final ki4.a d;
    public final boolean e;
    public mz0 f;
    public int h;
    public final r73 c = new r73();
    public byte[] g = new byte[1024];

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public d95(String str, yo4 yo4Var, ki4.a aVar, boolean z) {
        this.a = str;
        this.b = yo4Var;
        this.d = aVar;
        this.e = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public void a(long j2, long j3) {
        throw new IllegalStateException();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public void b(mz0 mz0Var) {
        if (this.e) {
            mz0Var = new li4(mz0Var, this.d);
        }
        this.f = mz0Var;
        mz0Var.u(new yz3.b(-9223372036854775807L));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public int d(jz0 jz0Var, yf3 yf3Var) throws r83 {
        gg3.q(this.f);
        int length = (int) jz0Var.getLength();
        int i2 = this.h;
        byte[] bArr = this.g;
        if (i2 == bArr.length) {
            this.g = Arrays.copyOf(bArr, ((length != -1 ? length : bArr.length) * 3) / 2);
        }
        byte[] bArr2 = this.g;
        int i3 = this.h;
        int i4 = jz0Var.read(bArr2, i3, bArr2.length - i3);
        if (i4 != -1) {
            int i5 = this.h + i4;
            this.h = i5;
            if (length == -1 || i5 != length) {
                return 0;
            }
        }
        h();
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public boolean e(jz0 jz0Var) {
        jz0Var.j(this.g, 0, 6, false);
        this.c.d0(this.g, 6);
        if (f95.b(this.c)) {
            return true;
        }
        jz0Var.j(this.g, 6, 3, false);
        this.c.d0(this.g, 9);
        return f95.b(this.c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final gr4 g(long j2) {
        gr4 gr4VarE = this.f.e(0, 3);
        gr4VarE.g(new t41.b().A0("text/vtt").o0(this.a).E0(j2).Q());
        this.f.o();
        return gr4VarE;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h() throws r83 {
        r73 r73Var = new r73(this.g);
        f95.e(r73Var);
        long jH = 0;
        long jD = 0;
        for (String strB = r73Var.B(); !TextUtils.isEmpty(strB); strB = r73Var.B()) {
            if (strB.startsWith("X-TIMESTAMP-MAP")) {
                Matcher matcher = i.matcher(strB);
                if (!matcher.find()) {
                    throw r83.a("X-TIMESTAMP-MAP doesn't contain local timestamp: ".concat(strB), null);
                }
                Matcher matcher2 = j.matcher(strB);
                if (!matcher2.find()) {
                    throw r83.a("X-TIMESTAMP-MAP doesn't contain media timestamp: ".concat(strB), null);
                }
                jD = f95.d((String) gg3.q(matcher.group(1)));
                jH = yo4.h(Long.parseLong((String) gg3.q(matcher2.group(1))));
            }
        }
        Matcher matcherA = f95.a(r73Var);
        if (matcherA == null) {
            g(0L);
            return;
        }
        long jD2 = f95.d((String) gg3.q(matcherA.group(1)));
        long jB = this.b.b(yo4.l((jH + jD2) - jD));
        gr4 gr4VarG = g(jB - jD2);
        this.c.d0(this.g, this.h);
        gr4VarG.a(this.c, this.h);
        gr4VarG.b(jB, 1, this.h, 0, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public void release() {
    }
}
