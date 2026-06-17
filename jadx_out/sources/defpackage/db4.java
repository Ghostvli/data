package defpackage;

import android.net.Uri;
import com.fongmi.android.tv.bean.Episode;
import com.fongmi.android.tv.bean.Flag;
import com.fongmi.android.tv.bean.Result;
import com.fongmi.android.tv.bean.Vod;
import defpackage.bo4;
import defpackage.db4;
import defpackage.ra5;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class db4 {
    public final List a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void a();

        boolean b(Uri uri);

        String c(String str);

        void stop();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        public static volatile db4 a = new db4();
    }

    public db4() {
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        arrayList.add(new n41());
        arrayList.add(new kn1());
        arrayList.add(new yi3());
        arrayList.add(new zg4());
        arrayList.add(new bo4());
        arrayList.add(new uk4());
        arrayList.add(new oz4());
        arrayList.add(new ra5());
    }

    public static db4 f() {
        return b.a;
    }

    public final void c(Iterator it, List list) {
        String url = ((Episode) it.next()).getUrl();
        if (bo4.a.i(url)) {
            list.add(bo4.a.g(url));
            it.remove();
        } else if (ra5.a.f(url)) {
            list.add(ra5.a.e(url));
            it.remove();
        }
    }

    public void d() {
        if (this.a == null) {
            return;
        }
        ul4.c(new Runnable() { // from class: za4
            @Override // java.lang.Runnable
            public final void run() {
                this.f.h();
            }
        });
    }

    public String e(Result result) {
        Uri uri = result.getUrl().uri();
        String strV = result.getUrl().v();
        a aVarG = g(uri);
        if (aVarG != null) {
            result.setParse(0);
        }
        if (aVarG instanceof oz4) {
            result.setParse(1);
        }
        return aVarG == null ? strV : aVarG.c(strV);
    }

    public final a g(final Uri uri) {
        return (a) this.a.stream().filter(new Predicate() { // from class: ab4
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((db4.a) obj).b(uri);
            }
        }).findFirst().orElse(null);
    }

    public final /* synthetic */ void h() {
        this.a.forEach(new Consumer() { // from class: cb4
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((db4.a) obj).a();
            }
        });
    }

    public void i(Vod vod) throws Exception {
        ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool();
        try {
            for (Flag flag : vod.getFlags()) {
                ArrayList arrayList = new ArrayList();
                Iterator<Episode> it = flag.getEpisodes().iterator();
                while (it.hasNext()) {
                    c(it, arrayList);
                }
                Iterator it2 = executorServiceNewCachedThreadPool.invokeAll(arrayList, 30L, TimeUnit.SECONDS).iterator();
                while (it2.hasNext()) {
                    try {
                        flag.getEpisodes().addAll((Collection) ((Future) it2.next()).get());
                    } catch (CancellationException unused) {
                    }
                }
            }
            if (executorServiceNewCachedThreadPool != null) {
                d45.a(executorServiceNewCachedThreadPool);
            }
        } catch (Throwable th) {
            if (executorServiceNewCachedThreadPool != null) {
                try {
                    d45.a(executorServiceNewCachedThreadPool);
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void j() {
        List list = this.a;
        if (list == null) {
            return;
        }
        list.forEach(new Consumer() { // from class: bb4
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((db4.a) obj).stop();
            }
        });
    }
}
