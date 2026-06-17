package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Build;
import com.hierynomus.msdtyp.FileTime;
import defpackage.k41;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i41 {
    public static final f32 a = new f32(16);
    public static final ExecutorService b = fr3.a("fonts-androidx", 10, FileTime.NANO100_TO_MILLI);
    public static final Object c = new Object();
    public static final x64 d = new x64();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Callable {
        public final /* synthetic */ String a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ g41 c;
        public final /* synthetic */ int d;

        public a(String str, Context context, g41 g41Var, int i) {
            this.a = str;
            this.b = context;
            this.c = g41Var;
            this.d = i;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            return i41.c(this.a, this.b, av4.a(new Object[]{this.c}), this.d);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements h20 {
        public final /* synthetic */ wo a;

        public b(wo woVar) {
            this.a = woVar;
        }

        @Override // defpackage.h20
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            if (eVar == null) {
                eVar = new e(-3);
            }
            this.a.b(eVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c implements Callable {
        public final /* synthetic */ String a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ List c;
        public final /* synthetic */ int d;

        public c(String str, Context context, List list, int i) {
            this.a = str;
            this.b = context;
            this.c = list;
            this.d = i;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            try {
                return i41.c(this.a, this.b, this.c, this.d);
            } catch (Throwable unused) {
                return new e(-3);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d implements h20 {
        public final /* synthetic */ String a;

        public d(String str) {
            this.a = str;
        }

        @Override // defpackage.h20
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            synchronized (i41.c) {
                try {
                    x64 x64Var = i41.d;
                    ArrayList arrayList = (ArrayList) x64Var.get(this.a);
                    if (arrayList == null) {
                        return;
                    }
                    x64Var.remove(this.a);
                    for (int i = 0; i < arrayList.size(); i++) {
                        ((h20) arrayList.get(i)).accept(eVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static String a(List list, int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < list.size(); i2++) {
            sb.append(((g41) list.get(i2)).d());
            sb.append("-");
            sb.append(i);
            if (i2 < list.size() - 1) {
                sb.append(";");
            }
        }
        return sb.toString();
    }

    public static int b(k41.a aVar) {
        int i = 1;
        if (aVar.e() != 0) {
            return aVar.e() != 1 ? -3 : -2;
        }
        k41.b[] bVarArrC = aVar.c();
        if (bVarArrC != null && bVarArrC.length != 0) {
            i = 0;
            for (k41.b bVar : bVarArrC) {
                int iB = bVar.b();
                if (iB != 0) {
                    if (iB < 0) {
                        return -3;
                    }
                    return iB;
                }
            }
        }
        return i;
    }

    public static e c(String str, Context context, List list, int i) {
        dq4.a("getFontSync");
        try {
            f32 f32Var = a;
            Typeface typeface = (Typeface) f32Var.d(str);
            if (typeface != null) {
                return new e(typeface);
            }
            k41.a aVarE = f41.e(context, list, null);
            int iB = b(aVarE);
            if (iB != 0) {
                return new e(iB);
            }
            Typeface typefaceB = (!aVarE.f() || Build.VERSION.SDK_INT < 29) ? bv4.b(context, null, aVarE.c(), i) : bv4.c(context, null, aVarE.d(), i);
            if (typefaceB == null) {
                return new e(-3);
            }
            f32Var.e(str, typefaceB);
            return new e(typefaceB);
        } catch (PackageManager.NameNotFoundException unused) {
            return new e(-1);
        } finally {
            dq4.b();
        }
    }

    public static Typeface d(Context context, List list, int i, Executor executor, wo woVar) {
        String strA = a(list, i);
        Typeface typeface = (Typeface) a.d(strA);
        if (typeface != null) {
            woVar.b(new e(typeface));
            return typeface;
        }
        b bVar = new b(woVar);
        synchronized (c) {
            try {
                x64 x64Var = d;
                ArrayList arrayList = (ArrayList) x64Var.get(strA);
                if (arrayList != null) {
                    arrayList.add(bVar);
                    return null;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(bVar);
                x64Var.put(strA, arrayList2);
                c cVar = new c(strA, context, list, i);
                if (executor == null) {
                    executor = b;
                }
                fr3.c(executor, cVar, new d(strA));
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Typeface e(Context context, g41 g41Var, wo woVar, int i, int i2) {
        String strA = a(av4.a(new Object[]{g41Var}), i);
        Typeface typeface = (Typeface) a.d(strA);
        if (typeface != null) {
            woVar.b(new e(typeface));
            return typeface;
        }
        if (i2 == -1) {
            e eVarC = c(strA, context, av4.a(new Object[]{g41Var}), i);
            woVar.b(eVarC);
            return eVarC.a;
        }
        try {
            e eVar = (e) fr3.d(b, new a(strA, context, g41Var, i), i2);
            woVar.b(eVar);
            return eVar.a;
        } catch (InterruptedException unused) {
            woVar.b(new e(-3));
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e {
        public final Typeface a;
        public final int b;

        public e(int i) {
            this.a = null;
            this.b = i;
        }

        public boolean a() {
            return this.b == 0;
        }

        public e(Typeface typeface) {
            this.a = typeface;
            this.b = 0;
        }
    }
}
