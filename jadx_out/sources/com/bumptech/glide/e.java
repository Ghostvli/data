package com.bumptech.glide;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.b;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.data.c;
import defpackage.ak;
import defpackage.an;
import defpackage.bb;
import defpackage.bk;
import defpackage.cj3;
import defpackage.ck;
import defpackage.dk;
import defpackage.dq4;
import defpackage.ds3;
import defpackage.e04;
import defpackage.e7;
import defpackage.ek;
import defpackage.fg0;
import defpackage.fs3;
import defpackage.g25;
import defpackage.gw4;
import defpackage.hw4;
import defpackage.i01;
import defpackage.ir2;
import defpackage.iw4;
import defpackage.jk1;
import defpackage.jr2;
import defpackage.jx4;
import defpackage.ka0;
import defpackage.kk;
import defpackage.ks3;
import defpackage.l02;
import defpackage.la1;
import defpackage.lr2;
import defpackage.m01;
import defpackage.m73;
import defpackage.ma;
import defpackage.nn0;
import defpackage.nx4;
import defpackage.os3;
import defpackage.pa1;
import defpackage.px4;
import defpackage.q91;
import defpackage.qe4;
import defpackage.r91;
import defpackage.ra1;
import defpackage.s9;
import defpackage.s91;
import defpackage.sn0;
import defpackage.t91;
import defpackage.te4;
import defpackage.ug1;
import defpackage.ul0;
import defpackage.um;
import defpackage.up3;
import defpackage.vm;
import defpackage.vv0;
import defpackage.we4;
import defpackage.wm;
import defpackage.wt2;
import defpackage.xm;
import defpackage.ym;
import defpackage.z91;
import defpackage.zf4;
import defpackage.zm;
import defpackage.zr3;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements pa1.b {
        public boolean a;
        public final /* synthetic */ com.bumptech.glide.a b;
        public final /* synthetic */ List c;
        public final /* synthetic */ s9 d;

        public a(com.bumptech.glide.a aVar, List list, s9 s9Var) {
            this.b = aVar;
            this.c = list;
            this.d = s9Var;
        }

        @Override // pa1.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public up3 get() {
            if (this.a) {
                e04.a("Recursive Registry initialization! In your AppGlideModule and LibraryGlideModules, Make sure you're using the provided Registry rather calling glide.getRegistry()!");
                return null;
            }
            dq4.a("Glide registry");
            this.a = true;
            try {
                return e.a(this.b, this.c, this.d);
            } finally {
                this.a = false;
                dq4.b();
            }
        }
    }

    public static up3 a(com.bumptech.glide.a aVar, List list, s9 s9Var) {
        kk kkVarF = aVar.f();
        ma maVarE = aVar.e();
        Context applicationContext = aVar.i().getApplicationContext();
        d dVarG = aVar.i().g();
        up3 up3Var = new up3();
        b(applicationContext, up3Var, kkVarF, maVarE, dVarG);
        c(applicationContext, aVar, up3Var, list, s9Var);
        return up3Var;
    }

    public static void b(Context context, up3 up3Var, kk kkVar, ma maVar, d dVar) {
        ds3 vmVar;
        ds3 qe4Var;
        String str;
        up3 up3Var2;
        up3Var.p(new fg0());
        int i = Build.VERSION.SDK_INT;
        if (i >= 27) {
            up3Var.p(new vv0());
        }
        Resources resources = context.getResources();
        List listG = up3Var.g();
        zm zmVar = new zm(context, listG, kkVar, maVar);
        ds3 ds3VarM = g25.m(kkVar);
        nn0 nn0Var = new nn0(up3Var.g(), resources.getDisplayMetrics(), kkVar, maVar);
        if (i < 28 || !dVar.a(b.C0052b.class)) {
            vmVar = new vm(nn0Var);
            qe4Var = new qe4(nn0Var, maVar);
        } else {
            qe4Var = new jk1();
            vmVar = new wm();
        }
        if (i >= 28) {
            up3Var.e("Animation", InputStream.class, Drawable.class, e7.f(listG, maVar));
            up3Var.e("Animation", ByteBuffer.class, Drawable.class, e7.a(listG, maVar));
        }
        fs3 fs3Var = new fs3(context);
        ek ekVar = new ek(maVar);
        ak akVar = new ak();
        s91 s91Var = new s91();
        ContentResolver contentResolver = context.getContentResolver();
        up3Var.a(ByteBuffer.class, new xm()).a(InputStream.class, new te4(maVar)).e("Bitmap", ByteBuffer.class, Bitmap.class, vmVar).e("Bitmap", InputStream.class, Bitmap.class, qe4Var);
        if (ParcelFileDescriptorRewinder.c()) {
            str = "Animation";
            up3Var.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new m73(nn0Var));
        } else {
            str = "Animation";
        }
        up3Var.e("Bitmap", AssetFileDescriptor.class, Bitmap.class, g25.c(kkVar));
        String str2 = str;
        up3Var.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, ds3VarM).c(Bitmap.class, Bitmap.class, iw4.a.a()).e("Bitmap", Bitmap.class, Bitmap.class, new gw4()).b(Bitmap.class, ekVar).e("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new bk(resources, vmVar)).e("BitmapDrawable", InputStream.class, BitmapDrawable.class, new bk(resources, qe4Var)).e("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new bk(resources, ds3VarM)).b(BitmapDrawable.class, new ck(kkVar, ekVar)).e(str2, InputStream.class, r91.class, new we4(listG, zmVar, maVar)).e(str2, ByteBuffer.class, r91.class, zmVar).b(r91.class, new t91()).c(q91.class, q91.class, iw4.a.a()).e("Bitmap", q91.class, Bitmap.class, new z91(kkVar)).d(Uri.class, Drawable.class, fs3Var).d(Uri.class, Bitmap.class, new zr3(fs3Var, kkVar)).q(new an.a()).c(File.class, ByteBuffer.class, new ym.b()).c(File.class, InputStream.class, new m01.e()).d(File.class, File.class, new i01()).c(File.class, ParcelFileDescriptor.class, new m01.b()).c(File.class, File.class, iw4.a.a()).q(new c.a(maVar));
        if (ParcelFileDescriptorRewinder.c()) {
            up3Var2 = up3Var;
            up3Var2.q(new ParcelFileDescriptorRewinder.a());
        } else {
            up3Var2 = up3Var;
        }
        wt2 wt2VarG = ul0.g(context);
        wt2 wt2VarC = ul0.c(context);
        wt2 wt2VarE = ul0.e(context);
        Class cls = Integer.TYPE;
        up3Var2.c(cls, InputStream.class, wt2VarG).c(Integer.class, InputStream.class, wt2VarG).c(cls, AssetFileDescriptor.class, wt2VarC).c(Integer.class, AssetFileDescriptor.class, wt2VarC).c(cls, Drawable.class, wt2VarE).c(Integer.class, Drawable.class, wt2VarE).c(Uri.class, InputStream.class, os3.f(context)).c(Uri.class, AssetFileDescriptor.class, os3.e(context));
        ks3.c cVar = new ks3.c(resources);
        ks3.a aVar = new ks3.a(resources);
        ks3.b bVar = new ks3.b(resources);
        up3Var2.c(Integer.class, Uri.class, cVar).c(cls, Uri.class, cVar).c(Integer.class, AssetFileDescriptor.class, aVar).c(cls, AssetFileDescriptor.class, aVar).c(Integer.class, InputStream.class, bVar).c(cls, InputStream.class, bVar);
        up3Var2.c(String.class, InputStream.class, new ka0.c()).c(Uri.class, InputStream.class, new ka0.c()).c(String.class, InputStream.class, new zf4.c()).c(String.class, ParcelFileDescriptor.class, new zf4.b()).c(String.class, AssetFileDescriptor.class, new zf4.a()).c(Uri.class, InputStream.class, new bb.c(context.getAssets())).c(Uri.class, AssetFileDescriptor.class, new bb.b(context.getAssets())).c(Uri.class, InputStream.class, new jr2.a(context)).c(Uri.class, InputStream.class, new lr2.a(context));
        if (i >= 29) {
            up3Var2.c(Uri.class, InputStream.class, new cj3.c(context));
            up3Var2.c(Uri.class, ParcelFileDescriptor.class, new cj3.b(context));
        }
        boolean zA = dVar.a(b.e.class);
        up3Var2.c(Uri.class, InputStream.class, new jx4.d(contentResolver, zA)).c(Uri.class, ParcelFileDescriptor.class, new jx4.b(contentResolver, zA)).c(Uri.class, AssetFileDescriptor.class, new jx4.a(contentResolver, zA)).c(Uri.class, InputStream.class, new px4.a()).c(URL.class, InputStream.class, new nx4.a()).c(Uri.class, File.class, new ir2.a(context)).c(ra1.class, InputStream.class, new ug1.a()).c(byte[].class, ByteBuffer.class, new um.a()).c(byte[].class, InputStream.class, new um.d()).c(Uri.class, Uri.class, iw4.a.a()).c(Drawable.class, Drawable.class, iw4.a.a()).d(Drawable.class, Drawable.class, new hw4()).r(Bitmap.class, BitmapDrawable.class, new dk(resources)).r(Bitmap.class, byte[].class, akVar).r(Drawable.class, byte[].class, new sn0(kkVar, akVar, s91Var)).r(r91.class, byte[].class, s91Var);
        ds3 ds3VarD = g25.d(kkVar);
        up3Var2.d(ByteBuffer.class, Bitmap.class, ds3VarD);
        up3Var2.d(ByteBuffer.class, BitmapDrawable.class, new bk(resources, ds3VarD));
    }

    public static void c(Context context, com.bumptech.glide.a aVar, up3 up3Var, List list, s9 s9Var) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            la1 la1Var = (la1) it.next();
            try {
                la1Var.b(context, aVar, up3Var);
            } catch (AbstractMethodError e) {
                l02.a("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: ".concat(la1Var.getClass().getName()), e);
                return;
            }
        }
        if (s9Var != null) {
            s9Var.a(context, aVar, up3Var);
        }
    }

    public static pa1.b d(com.bumptech.glide.a aVar, List list, s9 s9Var) {
        return new a(aVar, list, s9Var);
    }
}
