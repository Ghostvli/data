package defpackage;

import defpackage.wm0;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class zm0 extends ms1 {
    public zm0(String str, String str2, String str3) {
        super(str);
        zy4.j(str2);
        zy4.j(str3);
        f().c("name", str).c("publicId", str2).c("systemId", str3);
        i0();
    }

    @Override // defpackage.l33
    public String C() {
        return "#doctype";
    }

    @Override // defpackage.l33
    public void J(uj3 uj3Var, wm0.a aVar) {
        if (aVar.j() != wm0.a.EnumC0128a.html || e0("publicId") || e0("systemId")) {
            uj3Var.b("<!DOCTYPE");
        } else {
            uj3Var.b("<!doctype");
        }
        if (e0("name")) {
            uj3Var.b(" ").b(e("name"));
        }
        if (e0("pubSysKey")) {
            uj3Var.b(" ").b(e("pubSysKey"));
        }
        if (e0("publicId")) {
            uj3Var.b(" \"").b(e("publicId")).a('\"');
        }
        if (e0("systemId")) {
            uj3Var.b(" \"").b(e("systemId")).a('\"');
        }
        uj3Var.a('>');
    }

    public final boolean e0(String str) {
        return !fg4.j(e(str));
    }

    public String f0() {
        return e("name");
    }

    public String g0() {
        return e("publicId");
    }

    public void h0(String str) {
        if (str != null) {
            d("pubSysKey", str);
        }
    }

    public final void i0() {
        if (e0("publicId")) {
            f().c("pubSysKey", "PUBLIC");
        } else if (e0("systemId")) {
            f().c("pubSysKey", "SYSTEM");
        }
    }
}
