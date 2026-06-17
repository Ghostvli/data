package defpackage;

import com.google.zxing.client.result.ExpandedProductParsedResult;
import defpackage.wf4;
import java.util.EnumSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ic5 extends wf4 {
    public static final List c = pz1.h("en-GB");
    public static final List d = m20.b("DZ", "AR", "AU", "AT", "AZ", "BH", "BD", "BY", "BE", "BO", "BA", "BR", "BG", "KH", "CA", "CL", "CO", "CR", "HR", "CY", "CZ", "DK", "DO", "EC", "EG", "SV", "EE", "FI", "FR", "GE", "DE", "GH", "GR", "GT", "HN", "HK", "HU", "IS", "IN", "ID", "IQ", "IE", "IL", "IT", "JM", "JP", "JO", "KZ", "KE", "KW", "LA", "LV", ExpandedProductParsedResult.POUND, "LY", "LI", "LT", "LU", "MY", "MT", "MX", "ME", "MA", "NP", "NL", "NZ", "NI", "NG", "MK", "NO", "OM", "PK", "PA", "PG", "PY", "PE", "PH", "PL", "PT", "PR", "QA", "RO", "RU", "SA", "SN", "RS", "SG", "SK", "SI", "ZA", "KR", "ES", "LK", "SE", "CH", "TW", "TZ", "TH", "TN", "TR", "UG", "UA", "AE", "GB", "US", "UY", "VE", "VN", "YE", "ZW");

    public ic5(int i) {
        super(i, "YouTube", EnumSet.of(wf4.b.a.AUDIO, wf4.b.a.VIDEO, wf4.b.a.LIVE, wf4.b.a.COMMENTS));
    }

    @Override // defpackage.wf4
    public gu1 a() {
        return sa5.n();
    }

    @Override // defpackage.wf4
    public gu1 e() {
        return gc5.n();
    }

    @Override // defpackage.wf4
    public ue4 g(vt1 vt1Var) {
        return new md5(this, vt1Var);
    }

    @Override // defpackage.wf4
    public wt1 i() {
        return me5.l();
    }

    @Override // defpackage.wf4
    public List j() {
        return d;
    }

    @Override // defpackage.wf4
    public List k() {
        return c;
    }
}
