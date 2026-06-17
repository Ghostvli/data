package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import androidx.profileinstaller.c;
import defpackage.e04;
import defpackage.lh3;
import defpackage.mh3;
import defpackage.pk0;
import defpackage.ps0;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public final AssetManager a;
    public final Executor b;
    public final c.InterfaceC0037c c;
    public final File e;
    public final String f;
    public final String g;
    public final String h;
    public pk0[] j;
    public byte[] k;
    public boolean i = false;
    public final byte[] d = d();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public b(AssetManager assetManager, Executor executor, c.InterfaceC0037c interfaceC0037c, String str, String str2, String str3, File file) {
        this.a = assetManager;
        this.b = executor;
        this.c = interfaceC0037c;
        this.f = str;
        this.g = str2;
        this.h = str3;
        this.e = file;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static byte[] d() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            return mh3.a;
        }
        switch (i) {
            case 24:
            case 25:
                return mh3.e;
            case 26:
                return mh3.d;
            case 27:
                return mh3.c;
            case 28:
            case 29:
            case 30:
                return mh3.b;
            default:
                return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean j() {
        int i = Build.VERSION.SDK_INT;
        return i >= 31 || i == 24 || i == 25;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final b b(pk0[] pk0VarArr, byte[] bArr) {
        InputStream inputStreamG;
        try {
            inputStreamG = g(this.a, this.h);
        } catch (FileNotFoundException e) {
            this.c.b(9, e);
        } catch (IOException e2) {
            this.c.b(7, e2);
        } catch (IllegalStateException e3) {
            this.j = null;
            this.c.b(8, e3);
        }
        if (inputStreamG == null) {
            if (inputStreamG != null) {
                inputStreamG.close();
            }
            return null;
        }
        try {
            this.j = lh3.r(inputStreamG, lh3.p(inputStreamG, lh3.b), bArr, pk0VarArr);
            inputStreamG.close();
            return this;
        } catch (Throwable th) {
            try {
                inputStreamG.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void c() {
        if (this.i) {
            return;
        }
        e04.a("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean e() {
        if (this.d == null) {
            k(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        }
        boolean zExists = this.e.exists();
        File file = this.e;
        if (!zExists) {
            try {
                if (!file.createNewFile()) {
                    k(4, null);
                    return false;
                }
            } catch (IOException unused) {
                k(4, null);
                return false;
            }
        } else if (!file.canWrite()) {
            k(4, null);
            return false;
        }
        this.i = true;
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final InputStream f(AssetManager assetManager) {
        try {
            return g(assetManager, this.g);
        } catch (FileNotFoundException e) {
            this.c.b(6, e);
            return null;
        } catch (IOException e2) {
            this.c.b(7, e2);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final InputStream g(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e) {
            String message = e.getMessage();
            if (message != null && message.contains("compressed")) {
                this.c.a(5, null);
            }
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public b h() {
        b bVarB;
        c();
        if (this.d != null) {
            InputStream inputStreamF = f(this.a);
            if (inputStreamF != null) {
                this.j = i(inputStreamF);
            }
            pk0[] pk0VarArr = this.j;
            if (pk0VarArr != null && j() && (bVarB = b(pk0VarArr, this.d)) != null) {
                return bVarB;
            }
        }
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final pk0[] i(InputStream inputStream) {
        try {
            try {
                try {
                    pk0[] pk0VarArrX = lh3.x(inputStream, lh3.p(inputStream, lh3.a), this.f);
                    try {
                        inputStream.close();
                        return pk0VarArrX;
                    } catch (IOException e) {
                        this.c.b(7, e);
                        return pk0VarArrX;
                    }
                } catch (IllegalStateException e2) {
                    this.c.b(8, e2);
                    return null;
                }
            } catch (IOException e3) {
                this.c.b(7, e3);
                return null;
            }
        } finally {
            try {
                inputStream.close();
            } catch (IOException e4) {
                this.c.b(7, e4);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void k(final int i, final Object obj) {
        this.b.execute(new Runnable() { // from class: lk0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.c.b(i, obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public b l() {
        ByteArrayOutputStream byteArrayOutputStream;
        pk0[] pk0VarArr = this.j;
        byte[] bArr = this.d;
        if (pk0VarArr != null && bArr != null) {
            c();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    lh3.F(byteArrayOutputStream, bArr);
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e) {
                this.c.b(7, e);
            } catch (IllegalStateException e2) {
                this.c.b(8, e2);
            }
            if (!lh3.C(byteArrayOutputStream, bArr, pk0VarArr)) {
                this.c.b(5, null);
                this.j = null;
                byteArrayOutputStream.close();
                return this;
            }
            this.k = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            this.j = null;
        }
        return this;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: java.lang.Object[] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.lang.Object[] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean m() {
        byte[] bArr = this.k;
        if (bArr == null) {
            return false;
        }
        c();
        try {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.e);
                    try {
                        FileChannel channel = fileOutputStream.getChannel();
                        try {
                            FileLock fileLockTryLock = channel.tryLock();
                            try {
                                ps0.l(byteArrayInputStream, fileOutputStream, fileLockTryLock);
                                k(1, null);
                                if (fileLockTryLock != null) {
                                    fileLockTryLock.close();
                                }
                                channel.close();
                                fileOutputStream.close();
                                byteArrayInputStream.close();
                                return true;
                            } finally {
                            }
                        } finally {
                        }
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (FileNotFoundException e) {
                k(6, e);
                return false;
            } catch (IOException e2) {
                k(7, e2);
                return false;
            }
        } finally {
            this.k = null;
            this.j = null;
        }
    }
}
