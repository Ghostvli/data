package defpackage;

import java.io.IOException;
import java.util.List;
import org.jupnp.model.ServiceReference;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class bg extends gu1 {
    public static final bg a = new bg();

    public static bg n() {
        return a;
    }

    @Override // defpackage.wt1
    public String e(String str) throws s83 {
        try {
            return String.valueOf(xo1.d(a33.a().b(yy4.u(str)).c(), "data-band").j(Name.MARK));
        } catch (fo3 | IOException | ArrayIndexOutOfBoundsException | mo1 e) {
            uo1.a("Download failed", e);
            return null;
        }
    }

    @Override // defpackage.wt1
    public boolean h(String str) {
        String lowerCase = str.toLowerCase();
        String[] strArrSplit = lowerCase.split(ServiceReference.DELIMITER);
        if (strArrSplit.length != 3 && strArrSplit.length != 4) {
            return false;
        }
        if ((strArrSplit.length != 4 || strArrSplit[3].equals("releases") || strArrSplit[3].equals("music") || strArrSplit[3].equals("album") || strArrSplit[3].equals("track")) && !strArrSplit[2].equals("daily.bandcamp.com")) {
            return dg.g(lowerCase);
        }
        return false;
    }

    @Override // defpackage.gu1
    public String l(String str, List list, String str2) throws s83 {
        ko1 ko1VarB = dg.b(str);
        if (!ko1VarB.d("error")) {
            return yy4.u(ko1VarB.o("bandcamp_url"));
        }
        ny4.a("JSON does not contain a channel URL (invalid id?) or is otherwise invalid");
        return null;
    }
}
