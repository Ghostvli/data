package defpackage;

import android.net.Uri;
import android.util.Base64;
import com.fongmi.android.tv.bean.Episode;
import com.fongmi.android.tv.bean.Vod;
import defpackage.bu1;
import defpackage.db4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ra5 implements db4.a {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends to3 implements Callable {
        public static final Pattern b = Pattern.compile("(youtube\\.com|youtu\\.be).*list=");
        public final String a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(String str) {
            this.a = str;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private /* synthetic */ boolean a(Object obj) {
            return (obj instanceof a) && Objects.equals(this.a, ((a) obj).a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private /* synthetic */ Object[] b() {
            return new Object[]{this.a};
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static a e(String str) {
            return new a(str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static boolean f(String str) {
            return b.matcher(str).find();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void c(fc5 fc5Var, List list, bu1.a aVar) {
            for (ye4 ye4Var : aVar.a()) {
                if (ye4Var.g() != -1) {
                    list.add(Episode.create(ye4Var.b(), ye4Var.e()));
                }
            }
            if (aVar.c()) {
                try {
                    c(fc5Var, list, fc5Var.w(aVar.b()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: call()Ljava/lang/Object; */
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public List call() {
            try {
                fc5 fc5Var = new fc5(x14.a, gc5.n().c(this.a));
                fc5Var.c(a33.c());
                fc5Var.b();
                ArrayList arrayList = new ArrayList();
                c(fc5Var, arrayList, fc5Var.u());
                return arrayList;
            } catch (Exception unused) {
                return Collections.EMPTY_LIST;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean equals(Object obj) {
            return a(obj);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final int hashCode() {
            return Objects.hashCode(this.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final String toString() {
            return yq.a(b(), a.class, "a");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ra5() {
        a33.e(b33.l(), pz1.b(Locale.getDefault()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // db4.a
    public void a() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // db4.a
    public boolean b(Uri uri) {
        String strD = qx4.d(uri);
        return strD.contains("youtube.com") || strD.contains("youtu.be");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // db4.a
    public String c(String str) {
        xe4 xe4VarR = xe4.r(str);
        qp3.n(d(xe4VarR).trans());
        return k(xe4VarR) ? h(xe4VarR) : i(xe4VarR);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Vod d(xe4 xe4Var) {
        try {
            Vod vod = new Vod();
            vod.setName(xe4Var.d());
            vod.setDirector(xe4Var.u());
            vod.setContent(xe4Var.m().a());
            vod.setPic(((di1) xe4Var.t().get(xe4Var.t().size() - 1)).a());
            return vod;
        } catch (Exception unused) {
            Vod vod2 = new Vod();
            vod2.setName(xe4Var.d());
            vod2.setContent(xe4Var.m().a());
            return vod2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String e(qd qdVar, String str) {
        int iK = qdVar.k();
        int iE = qdVar.e();
        return String.format(Locale.getDefault(), "<AdaptationSet lang='chi'>\n<ContentComponent contentType='%s'/>\n<Representation id='%d' bandwidth='%d' codecs='%s' mimeType='%s' %s>\n<BaseURL>%s</BaseURL>\n<SegmentBase indexRange='%s'>\n<Initialization range='%s'/>\n</SegmentBase>\n</Representation>\n</AdaptationSet>", "audio", Integer.valueOf(iK), Integer.valueOf(iE), qdVar.f(), qdVar.d().e(), str, qdVar.c().replace("&", "&amp;"), qdVar.h() + "-" + qdVar.g(), qdVar.j() + "-" + qdVar.i());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String f(f35 f35Var, String str) {
        int iM = f35Var.m();
        int iE = f35Var.e();
        return String.format(Locale.getDefault(), "<AdaptationSet lang='chi'>\n<ContentComponent contentType='%s'/>\n<Representation id='%d' bandwidth='%d' codecs='%s' mimeType='%s' %s>\n<BaseURL>%s</BaseURL>\n<SegmentBase indexRange='%s'>\n<Initialization range='%s'/>\n</SegmentBase>\n</Representation>\n</AdaptationSet>", "video", Integer.valueOf(iM), Integer.valueOf(iE), f35Var.f(), f35Var.d().e(), str, f35Var.c().replace("&", "&amp;"), f35Var.j() + "-" + f35Var.i(), f35Var.l() + "-" + f35Var.k());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String g(qd qdVar) {
        return String.format(Locale.getDefault(), "subsegmentAlignment='true' audioSamplingRate='%d'", Integer.valueOf(qdVar.l().r()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String h(xe4 xe4Var) {
        return !xe4Var.o().isEmpty() ? xe4Var.o() : !xe4Var.l().isEmpty() ? xe4Var.l() : "";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String i(xe4 xe4Var) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        List<qd> listK = xe4Var.k();
        List<f35> listV = xe4Var.v();
        for (qd qdVar : listK) {
            sb2.append(e(qdVar, g(qdVar)));
        }
        for (f35 f35Var : listV) {
            sb.append(f(f35Var, j(f35Var)));
        }
        return "data:application/dash+xml;base64," + Base64.encodeToString(String.format(Locale.getDefault(), "<MPD xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns='urn:mpeg:dash:schema:mpd:2011' xsi:schemaLocation='urn:mpeg:dash:schema:mpd:2011 DASH-MPD.xsd' type='static' mediaPresentationDuration='PT%sS' minBufferTime='PT1.500S' profiles='urn:mpeg:dash:profile:isoff-on-demand:2011'>\n<Period duration='PT%sS' start='PT0S'>\n%s\n%s\n</Period>\n</MPD>", Long.valueOf(xe4Var.n()), Long.valueOf(xe4Var.n()), sb, sb2).getBytes(), 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String j(f35 f35Var) {
        return String.format(Locale.getDefault(), "height='%d' width='%d' frameRate='%d' maxPlayoutRate='1' startWithSAP='1'", Integer.valueOf(f35Var.h()), Integer.valueOf(f35Var.n()), Integer.valueOf(f35Var.g()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean k(xe4 xe4Var) {
        return gf4.LIVE_STREAM.equals(xe4Var.s());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // db4.a
    public void stop() {
    }
}
