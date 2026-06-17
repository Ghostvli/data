package defpackage;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class bg3 implements jj4, ij0 {
    public final Context f;
    public final String g;
    public final File h;
    public final Callable i;
    public final int j;
    public final jj4 k;
    public ma0 l;
    public boolean m;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public bg3(Context context, String str, File file, Callable callable, int i, jj4 jj4Var) {
        context.getClass();
        jj4Var.getClass();
        this.f = context;
        this.g = str;
        this.h = file;
        this.i = callable;
        this.j = i;
        this.k = jj4Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ij0
    public jj4 a() {
        return this.k;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void c(File file, boolean z) throws IOException {
        ReadableByteChannel readableByteChannelNewChannel;
        if (this.g != null) {
            readableByteChannelNewChannel = Channels.newChannel(this.f.getAssets().open(this.g));
            readableByteChannelNewChannel.getClass();
        } else if (this.h != null) {
            readableByteChannelNewChannel = new FileInputStream(this.h).getChannel();
            readableByteChannelNewChannel.getClass();
        } else {
            Callable callable = this.i;
            if (callable == null) {
                e04.a("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
                return;
            }
            try {
                readableByteChannelNewChannel = Channels.newChannel((InputStream) callable.call());
                readableByteChannelNewChannel.getClass();
            } catch (Exception e) {
                throw new IOException("inputStreamCallable exception on call", e);
            }
        }
        File fileCreateTempFile = File.createTempFile("room-copy-helper", ".tmp", this.f.getCacheDir());
        fileCreateTempFile.deleteOnExit();
        FileChannel channel = new FileOutputStream(fileCreateTempFile).getChannel();
        channel.getClass();
        x01.a(readableByteChannelNewChannel, channel);
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            ze5.a("Failed to create directories for ", file.getAbsolutePath());
            return;
        }
        h(fileCreateTempFile, z);
        if (fileCreateTempFile.renameTo(file)) {
            return;
        }
        throw new IOException("Failed to move intermediate file (" + fileCreateTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jj4, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        a().close();
        this.m = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jj4
    public String getDatabaseName() {
        return a().getDatabaseName();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jj4
    public hj4 getWritableDatabase() {
        if (!this.m) {
            l(true);
            this.m = true;
        }
        return a().getWritableDatabase();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h(File file, boolean z) {
        ma0 ma0Var = this.l;
        if (ma0Var == null) {
            il1.j("databaseConfiguration");
            ma0Var = null;
        }
        ma0Var.getClass();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void i(ma0 ma0Var) {
        ma0Var.getClass();
        this.l = ma0Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void l(boolean z) {
        String databaseName = getDatabaseName();
        if (databaseName == null) {
            e04.a("Required value was null.");
            return;
        }
        File databasePath = this.f.getDatabasePath(databaseName);
        ma0 ma0Var = this.l;
        ma0 ma0Var2 = null;
        if (ma0Var == null) {
            il1.j("databaseConfiguration");
            ma0Var = null;
        }
        bh3 bh3Var = new bh3(databaseName, this.f.getFilesDir(), ma0Var.v);
        try {
            bh3.c(bh3Var, false, 1, null);
            if (!databasePath.exists()) {
                try {
                    c(databasePath, z);
                    bh3Var.d();
                    return;
                } catch (IOException e) {
                    throw new RuntimeException("Unable to copy database file.", e);
                }
            }
            try {
                int iC = j70.c(databasePath);
                if (iC == this.j) {
                    bh3Var.d();
                    return;
                }
                ma0 ma0Var3 = this.l;
                if (ma0Var3 == null) {
                    il1.j("databaseConfiguration");
                    ma0Var3 = null;
                }
                if (ma0Var3.d.d(iC, this.j) != null) {
                    bh3Var.d();
                    return;
                }
                ma0 ma0Var4 = this.l;
                if (ma0Var4 == null) {
                    il1.j("databaseConfiguration");
                } else {
                    ma0Var2 = ma0Var4;
                }
                if (ma0Var2.f(iC, this.j)) {
                    bh3Var.d();
                    return;
                }
                if (this.f.deleteDatabase(databaseName)) {
                    try {
                        c(databasePath, z);
                        fw4 fw4Var = fw4.a;
                    } catch (IOException e2) {
                        Log.w("ROOM", "Unable to copy database file.", e2);
                    }
                } else {
                    Log.w("ROOM", "Failed to delete database file (" + databaseName + ") for a copy destructive migration.");
                }
                bh3Var.d();
                return;
            } catch (IOException e3) {
                Log.w("ROOM", "Unable to read database version.", e3);
                bh3Var.d();
                return;
            }
        } catch (Throwable th) {
            bh3Var.d();
            throw th;
        }
        bh3Var.d();
        throw th;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jj4
    public void setWriteAheadLoggingEnabled(boolean z) {
        a().setWriteAheadLoggingEnabled(z);
    }
}
