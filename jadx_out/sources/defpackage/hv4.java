package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import defpackage.j41;
import defpackage.k41;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class hv4 {
    public ConcurrentHashMap a = new ConcurrentHashMap();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements b {
        public a() {
        }

        @Override // hv4.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int a(k41.b bVar) {
            return bVar.e();
        }

        @Override // hv4.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(k41.b bVar) {
            return bVar.f();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        int a(Object obj);

        boolean b(Object obj);
    }

    public static Object f(Object[] objArr, int i, b bVar) {
        return g(objArr, (i & 1) == 0 ? 400 : 700, (i & 2) != 0, bVar);
    }

    public static Object g(Object[] objArr, int i, boolean z, b bVar) {
        Object obj = null;
        int i2 = Integer.MAX_VALUE;
        for (Object obj2 : objArr) {
            int iAbs = (Math.abs(bVar.a(obj2) - i) * 2) + (bVar.b(obj2) == z ? 0 : 1);
            if (obj == null || i2 > iAbs) {
                obj = obj2;
                i2 = iAbs;
            }
        }
        return obj;
    }

    public abstract Typeface a(Context context, j41.c cVar, Resources resources, int i);

    public abstract Typeface b(Context context, CancellationSignal cancellationSignal, k41.b[] bVarArr, int i);

    public Typeface c(Context context, CancellationSignal cancellationSignal, List list, int i) {
        throw new IllegalStateException("createFromFontInfoWithFallback must only be called on API 29+");
    }

    public Typeface d(Context context, InputStream inputStream) {
        File fileE = iv4.e(context);
        if (fileE == null) {
            return null;
        }
        try {
            if (iv4.d(fileE, inputStream)) {
                return Typeface.createFromFile(fileE.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileE.delete();
        }
    }

    public Typeface e(Context context, Resources resources, int i, String str, int i2) {
        File fileE = iv4.e(context);
        if (fileE == null) {
            return null;
        }
        try {
            if (iv4.c(fileE, resources, i)) {
                return Typeface.createFromFile(fileE.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileE.delete();
        }
    }

    public k41.b h(k41.b[] bVarArr, int i) {
        return (k41.b) f(bVarArr, i, new a());
    }
}
