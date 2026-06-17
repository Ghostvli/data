package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import com.thegrizzlylabs.sardineandroid.DavResource;
import defpackage.aa0;
import defpackage.ag2;
import defpackage.ja0;
import defpackage.yv0;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class vg1 implements ag2 {
    public final aa0.a a;
    public final String b;
    public final boolean c;
    public final Map d;

    public vg1(String str, boolean z, aa0.a aVar) {
        gg3.d((z && TextUtils.isEmpty(str)) ? false : true);
        this.a = aVar;
        this.b = str;
        this.c = z;
        this.d = new HashMap();
    }

    @Override // defpackage.ag2
    public ag2.b a(UUID uuid, yv0.d dVar) {
        Charset charset = StandardCharsets.UTF_8;
        byte[] bArrB = in.b("{\"signedRequest\":\"".getBytes(charset), dVar.a(), "\"}".getBytes(charset));
        return ap0.a(this.a.b(), dVar.b(), bArrB, zi1.m("Content-Type", qr2.F0.toString(), "Content-Length", String.valueOf(bArrB.length)));
    }

    @Override // defpackage.ag2
    public ag2.b b(UUID uuid, yv0.a aVar) throws bg2 {
        String strB = aVar.b();
        if (this.c || TextUtils.isEmpty(strB)) {
            strB = this.b;
        }
        if (TextUtils.isEmpty(strB)) {
            ja0.b bVar = new ja0.b();
            Uri uri = Uri.EMPTY;
            throw new bg2(bVar.i(uri).a(), uri, zi1.j(), 0L, new IllegalStateException("No license URL"));
        }
        HashMap map = new HashMap();
        UUID uuid2 = kn.f;
        map.put("Content-Type", uuid2.equals(uuid) ? "text/xml" : kn.d.equals(uuid) ? "application/json" : DavResource.DEFAULT_CONTENT_TYPE);
        if (uuid2.equals(uuid)) {
            map.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        }
        synchronized (this.d) {
            map.putAll(this.d);
        }
        return ap0.a(this.a.b(), strB, aVar.a(), map);
    }

    public void c(String str, String str2) {
        gg3.q(str);
        gg3.q(str2);
        synchronized (this.d) {
            this.d.put(str, str2);
        }
    }
}
