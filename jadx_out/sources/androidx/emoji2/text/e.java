package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.os.Handler;
import androidx.emoji2.text.c;
import defpackage.cx4;
import defpackage.g41;
import defpackage.gq4;
import defpackage.hg3;
import defpackage.iv4;
import defpackage.k41;
import defpackage.yy;
import defpackage.zt2;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class e extends c.AbstractC0009c {
    public static final a k = new a();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public Typeface a(Context context, k41.b bVar) {
            return k41.a(context, null, new k41.b[]{bVar});
        }

        public k41.a b(Context context, g41 g41Var) {
            return k41.b(context, null, g41Var);
        }

        public void c(Context context, ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b implements c.h {
        public final Context a;
        public final g41 b;
        public final a c;
        public final Object d = new Object();
        public Handler e;
        public Executor f;
        public ThreadPoolExecutor g;
        public c.i h;
        public ContentObserver i;
        public Runnable j;

        public b(Context context, g41 g41Var, a aVar) {
            hg3.h(context, "Context cannot be null");
            hg3.h(g41Var, "FontRequest cannot be null");
            this.a = context.getApplicationContext();
            this.b = g41Var;
            this.c = aVar;
        }

        @Override // androidx.emoji2.text.c.h
        public void a(c.i iVar) {
            hg3.h(iVar, "LoaderCallback cannot be null");
            synchronized (this.d) {
                this.h = iVar;
            }
            d();
        }

        public final void b() {
            synchronized (this.d) {
                try {
                    this.h = null;
                    ContentObserver contentObserver = this.i;
                    if (contentObserver != null) {
                        this.c.c(this.a, contentObserver);
                        this.i = null;
                    }
                    Handler handler = this.e;
                    if (handler != null) {
                        handler.removeCallbacks(this.j);
                    }
                    this.e = null;
                    ThreadPoolExecutor threadPoolExecutor = this.g;
                    if (threadPoolExecutor != null) {
                        threadPoolExecutor.shutdown();
                    }
                    this.f = null;
                    this.g = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void c() {
            synchronized (this.d) {
                try {
                    if (this.h == null) {
                        return;
                    }
                    try {
                        k41.b bVarE = e();
                        int iB = bVarE.b();
                        if (iB == 2) {
                            synchronized (this.d) {
                            }
                        }
                        if (iB != 0) {
                            throw new RuntimeException("fetchFonts result is not OK. (" + iB + ")");
                        }
                        try {
                            gq4.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                            Typeface typefaceA = this.c.a(this.a, bVarE);
                            ByteBuffer byteBufferF = iv4.f(this.a, null, bVarE.d());
                            if (byteBufferF == null || typefaceA == null) {
                                throw new RuntimeException("Unable to open file.");
                            }
                            f fVarB = f.b(typefaceA, byteBufferF);
                            gq4.b();
                            synchronized (this.d) {
                                try {
                                    c.i iVar = this.h;
                                    if (iVar != null) {
                                        iVar.b(fVarB);
                                    }
                                } finally {
                                }
                            }
                            b();
                        } catch (Throwable th) {
                            gq4.b();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        synchronized (this.d) {
                            try {
                                c.i iVar2 = this.h;
                                if (iVar2 != null) {
                                    iVar2.a(th2);
                                }
                                b();
                            } finally {
                            }
                        }
                    }
                } finally {
                }
            }
        }

        public void d() {
            synchronized (this.d) {
                try {
                    if (this.h == null) {
                        return;
                    }
                    if (this.f == null) {
                        ThreadPoolExecutor threadPoolExecutorB = yy.b("emojiCompat");
                        this.g = threadPoolExecutorB;
                        this.f = threadPoolExecutorB;
                    }
                    this.f.execute(new Runnable() { // from class: h41
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f.c();
                        }
                    });
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final k41.b e() {
            try {
                k41.a aVarB = this.c.b(this.a, this.b);
                if (aVarB.e() != 0) {
                    throw new RuntimeException("fetchFonts failed (" + aVarB.e() + ")");
                }
                k41.b[] bVarArrC = aVarB.c();
                if (bVarArrC != null && bVarArrC.length != 0) {
                    return bVarArrC[0];
                }
                zt2.a("fetchFonts failed (empty result)");
                return null;
            } catch (PackageManager.NameNotFoundException e) {
                cx4.a("provider not found", e);
                return null;
            }
        }

        public void f(Executor executor) {
            synchronized (this.d) {
                this.f = executor;
            }
        }
    }

    public e(Context context, g41 g41Var) {
        super(new b(context, g41Var, k));
    }

    public e c(Executor executor) {
        ((b) a()).f(executor);
        return this;
    }
}
