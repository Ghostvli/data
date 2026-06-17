package com.fongmi.android.tv.db;

import android.content.Context;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.bean.Backup;
import com.fongmi.android.tv.db.AppDatabase;
import com.github.catvod.utils.Path;
import defpackage.bk0;
import defpackage.bu3;
import defpackage.dh;
import defpackage.f84;
import defpackage.fq1;
import defpackage.hz;
import defpackage.kq4;
import defpackage.kt2;
import defpackage.mx1;
import defpackage.p9;
import defpackage.to;
import defpackage.ul4;
import defpackage.w01;
import defpackage.w41;
import defpackage.xt3;
import defpackage.yd1;
import j$.time.LocalDate;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AppDatabase extends bu3 {
    public static volatile AppDatabase o;

    public static /* synthetic */ void K(File file, to toVar) {
        File fileCache = Path.cache("restore");
        w01.n(file, fileCache);
        Backup backupObjectFrom = Backup.objectFrom(Path.read(fileCache));
        if (backupObjectFrom.getConfig().isEmpty()) {
            Objects.requireNonNull(toVar);
            App.d(new p9(toVar));
        } else {
            backupObjectFrom.restore();
            Path.clear(fileCache);
            Objects.requireNonNull(toVar);
            App.d(new dh(toVar));
        }
    }

    public static /* synthetic */ void L(to toVar) {
        File file = new File(Path.tv(), "tv-" + LocalDate.now().format(w41.a) + ".bk");
        Backup backupCreate = Backup.create();
        if (backupCreate.getConfig().isEmpty()) {
            Objects.requireNonNull(toVar);
            App.d(new p9(toVar));
            return;
        }
        Path.write(file, backupCreate.toString().getBytes());
        w01.m(file);
        Objects.requireNonNull(toVar);
        App.d(new dh(toVar));
        O();
    }

    public static void M() {
        N(new to());
    }

    public static void N(final to toVar) {
        ul4.c(new Runnable() { // from class: o9
            @Override // java.lang.Runnable
            public final void run() {
                AppDatabase.L(toVar);
            }
        });
    }

    public static void O() {
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = Path.tv().listFiles();
        if (fileArrListFiles == null) {
            fileArrListFiles = new File[0];
        }
        for (File file : fileArrListFiles) {
            if (file.getName().startsWith("tv") && file.getName().endsWith(".bk.gz")) {
                arrayList.add(file);
            }
        }
        if (!arrayList.isEmpty()) {
            arrayList.sort(new Comparator() { // from class: q9
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return Long.compare(((File) obj2).lastModified(), ((File) obj).lastModified());
                }
            });
        }
        if (arrayList.size() > 7) {
            for (int i = 7; i < arrayList.size(); i++) {
                Path.clear((File) arrayList.get(i));
            }
        }
    }

    public static AppDatabase P(Context context) {
        return (AppDatabase) xt3.a(context, AppDatabase.class, "tv").a(kt2.a).a(kt2.b).a(kt2.c).a(kt2.d).a(kt2.e).d(true).b().c();
    }

    public static synchronized AppDatabase Q() {
        try {
            if (o == null) {
                o = P(App.b());
            }
        } catch (Throwable th) {
            throw th;
        }
        return o;
    }

    public static void Y(final File file, final to toVar) {
        ul4.c(new Runnable() { // from class: r9
            @Override // java.lang.Runnable
            public final void run() {
                AppDatabase.K(file, toVar);
            }
        });
    }

    public abstract hz R();

    public abstract bk0 S();

    public abstract yd1 T();

    public abstract fq1 U();

    public abstract mx1 V();

    public abstract f84 W();

    public abstract kq4 X();
}
