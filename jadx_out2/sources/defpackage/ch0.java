package defpackage;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.media3.exoplayer.o;
import defpackage.fk;
import defpackage.gi1;
import defpackage.pe0;
import defpackage.s82;
import defpackage.y72;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ch0 implements lq3 {
    public final Context a;
    public final lg0 b;
    public boolean e;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean l;
    public boolean m;
    public int c = 0;
    public long d = 5000;
    public l82 f = l82.a;
    public boolean j = true;
    public long k = 15000;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ch0(Context context) {
        this.a = context;
        this.b = new lg0(context);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.lq3
    public o a(o oVar, Handler handler, c35 c35Var, od odVar, tm4 tm4Var, et2 et2Var) {
        if (oVar.d() == 2) {
            return j(oVar, this.a, this.c, this.f, this.e, handler, c35Var, this.d);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.lq3
    public o[] b(Handler handler, c35 c35Var, od odVar, tm4 tm4Var, et2 et2Var) {
        Handler handler2;
        ArrayList arrayList = new ArrayList();
        l(this.a, this.c, this.f, this.e, handler, c35Var, this.d, arrayList);
        pd pdVarD = d(this.a, this.g, this.h);
        if (pdVarD != null) {
            handler2 = handler;
            c(this.a, this.c, this.f, this.e, pdVarD, handler2, odVar, arrayList);
        } else {
            handler2 = handler;
        }
        k(this.a, tm4Var, handler2.getLooper(), this.c, arrayList);
        h(this.a, et2Var, handler2.getLooper(), this.c, arrayList);
        e(this.a, this.c, arrayList);
        f(this.a, arrayList);
        i(this.a, handler2, this.c, arrayList);
        return (o[]) arrayList.toArray(new o[0]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void c(Context context, int i, l82 l82Var, boolean z, pd pdVar, Handler handler, od odVar, ArrayList arrayList) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        o oVar;
        arrayList.add(new z72(context, m(), l82Var, z, handler, odVar, pdVar));
        if (i == 0) {
            return;
        }
        int size = arrayList.size();
        if (i == 2) {
            size--;
        }
        try {
            try {
                i2 = size + 1;
            } catch (ClassNotFoundException unused) {
            }
            try {
                arrayList.add(size, (o) Class.forName("androidx.media3.decoder.midi.MidiRenderer").getConstructor(Context.class, Handler.class, od.class, pd.class).newInstance(context, handler, odVar, pdVar));
                xz1.g("DefaultRenderersFactory", "Loaded MidiRenderer.");
            } catch (ClassNotFoundException unused2) {
                size = i2;
                i2 = size;
            }
            try {
                try {
                    i3 = i2 + 1;
                    try {
                        arrayList.add(i2, (o) Class.forName("androidx.media3.decoder.opus.LibopusAudioRenderer").getConstructor(Handler.class, od.class, pd.class).newInstance(handler, odVar, pdVar));
                        xz1.g("DefaultRenderersFactory", "Loaded LibopusAudioRenderer.");
                    } catch (ClassNotFoundException unused3) {
                        i2 = i3;
                        i3 = i2;
                    }
                } catch (Exception e) {
                    l02.a("Error instantiating Opus extension", e);
                    return;
                }
            } catch (ClassNotFoundException unused4) {
            }
            try {
                try {
                    i4 = i3 + 1;
                } catch (ClassNotFoundException unused5) {
                }
                try {
                    arrayList.add(i3, (o) Class.forName("androidx.media3.decoder.flac.LibflacAudioRenderer").getConstructor(Handler.class, od.class, pd.class).newInstance(handler, odVar, pdVar));
                    xz1.g("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
                } catch (ClassNotFoundException unused6) {
                    i3 = i4;
                    i4 = i3;
                }
                try {
                    try {
                        i5 = i4 + 1;
                    } catch (ClassNotFoundException unused7) {
                    }
                    try {
                        arrayList.add(i4, (o) Class.forName("androidx.media3.decoder.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, od.class, pd.class).newInstance(handler, odVar, pdVar));
                        xz1.g("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
                    } catch (ClassNotFoundException unused8) {
                        i4 = i5;
                        i5 = i4;
                    }
                    try {
                        try {
                            Class<?> cls = Class.forName("androidx.media3.decoder.iamf.IamfAudioRenderer$Builder");
                            Object objNewInstance = cls.getConstructor(pd.class).newInstance(pdVar);
                            cls.getMethod("setEventHandlerAndListener", Handler.class, od.class).invoke(objNewInstance, handler, odVar);
                            oVar = (o) cls.getMethod("build", null).invoke(objNewInstance, null);
                            gg3.q(oVar);
                            i6 = i5 + 1;
                        } catch (Exception e2) {
                            l02.a("Error instantiating IAMF extension", e2);
                            return;
                        }
                    } catch (ReflectiveOperationException unused9) {
                    }
                    try {
                        arrayList.add(i5, oVar);
                        xz1.g("DefaultRenderersFactory", "Loaded IamfAudioRenderer.");
                    } catch (ReflectiveOperationException unused10) {
                        i5 = i6;
                        i6 = i5;
                    }
                    try {
                        arrayList.add(i6, (o) Class.forName("androidx.media3.decoder.mpegh.MpeghAudioRenderer").getConstructor(Handler.class, od.class, pd.class).newInstance(handler, odVar, pdVar));
                        xz1.g("DefaultRenderersFactory", "Loaded MpeghAudioRenderer.");
                    } catch (ClassNotFoundException unused11) {
                    } catch (Exception e3) {
                        l02.a("Error instantiating MPEG-H extension", e3);
                    }
                } catch (Exception e4) {
                    l02.a("Error instantiating FFmpeg extension", e4);
                }
            } catch (Exception e5) {
                l02.a("Error instantiating FLAC extension", e5);
            }
        } catch (Exception e6) {
            l02.a("Error instantiating MIDI extension", e6);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public pd d(Context context, boolean z, boolean z2) {
        return new pe0.f(context).i(z).h(z2).g();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e(Context context, int i, ArrayList arrayList) {
        arrayList.add(new hp());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void f(Context context, ArrayList arrayList) {
        g(arrayList);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g(ArrayList arrayList) {
        arrayList.add(new ni1(n(this.a), null));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void h(Context context, et2 et2Var, Looper looper, int i, ArrayList arrayList) {
        for (int i2 = 0; i2 < 4; i2++) {
            arrayList.add(new ft2(et2Var, looper));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void i(Context context, Handler handler, int i, ArrayList arrayList) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public o j(o oVar, Context context, int i, l82 l82Var, boolean z, Handler handler, c35 c35Var, long j) {
        if (!this.i || oVar.getClass() != s82.class) {
            return null;
        }
        s82.d dVarQ = new s82.d(context).t(m()).z(l82Var).s(j).u(z).w(handler).x(c35Var).y(50).r(this.j).q(this.k);
        if (Build.VERSION.SDK_INT >= 34) {
            dVarQ = dVarQ.p(this.l);
        }
        return dVarQ.o();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void k(Context context, tm4 tm4Var, Looper looper, int i, ArrayList arrayList) {
        arrayList.add(new vm4(tm4Var, looper));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void l(Context context, int i, l82 l82Var, boolean z, Handler handler, c35 c35Var, long j, ArrayList arrayList) {
        char c;
        int i2;
        int i3;
        Class<?> cls = Integer.TYPE;
        Class<?> cls2 = Long.TYPE;
        s82.d dVarV = new s82.d(context).t(m()).z(l82Var).s(j).u(z).w(handler).x(c35Var).y(50).r(this.j).q(this.k).v(this.m);
        if (Build.VERSION.SDK_INT >= 34) {
            dVarV = dVarV.p(this.l);
        }
        arrayList.add(dVarV.o());
        if (i == 0) {
            return;
        }
        int size = arrayList.size();
        if (i == 2) {
            size--;
        }
        try {
            try {
                c = 3;
                try {
                    i2 = size + 1;
                    try {
                        arrayList.add(size, (o) Class.forName("androidx.media3.decoder.vp9.LibvpxVideoRenderer").getConstructor(cls2, Handler.class, c35.class, cls).newInstance(Long.valueOf(j), handler, c35Var, 50));
                        xz1.g("DefaultRenderersFactory", "Loaded LibvpxVideoRenderer.");
                    } catch (ClassNotFoundException unused) {
                        size = i2;
                        i2 = size;
                    }
                } catch (ClassNotFoundException unused2) {
                }
            } catch (ClassNotFoundException unused3) {
                c = 3;
            }
            try {
                try {
                    Class<?> cls3 = Class.forName("androidx.media3.decoder.av1.Libdav1dVideoRenderer");
                    Class<?>[] clsArr = new Class[4];
                    clsArr[0] = cls2;
                    clsArr[1] = Handler.class;
                    clsArr[2] = c35.class;
                    clsArr[c] = cls;
                    Constructor<?> constructor = cls3.getConstructor(clsArr);
                    Object[] objArr = new Object[4];
                    objArr[0] = Long.valueOf(j);
                    objArr[1] = handler;
                    objArr[2] = c35Var;
                    objArr[c] = 50;
                    o oVar = (o) constructor.newInstance(objArr);
                    i3 = i2 + 1;
                    try {
                        arrayList.add(i2, oVar);
                        xz1.g("DefaultRenderersFactory", "Loaded Libdav1dVideoRenderer.");
                    } catch (ClassNotFoundException unused4) {
                        i2 = i3;
                        i3 = i2;
                    }
                } catch (ClassNotFoundException unused5) {
                }
                try {
                    Class<?> cls4 = Class.forName("androidx.media3.decoder.ffmpeg.ExperimentalFfmpegVideoRenderer");
                    Class<?>[] clsArr2 = new Class[4];
                    clsArr2[0] = cls2;
                    clsArr2[1] = Handler.class;
                    clsArr2[2] = c35.class;
                    clsArr2[c] = cls;
                    Constructor<?> constructor2 = cls4.getConstructor(clsArr2);
                    Object[] objArr2 = new Object[4];
                    objArr2[0] = Long.valueOf(j);
                    objArr2[1] = handler;
                    objArr2[2] = c35Var;
                    objArr2[c] = 50;
                    arrayList.add(i3, (o) constructor2.newInstance(objArr2));
                    xz1.g("DefaultRenderersFactory", "Loaded FfmpegVideoRenderer.");
                } catch (ClassNotFoundException unused6) {
                } catch (Exception e) {
                    l02.a("Error instantiating FFmpeg extension", e);
                }
            } catch (Exception e2) {
                l02.a("Error instantiating AV1 extension", e2);
            }
        } catch (Exception e3) {
            l02.a("Error instantiating VP9 extension", e3);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public y72.b m() {
        return this.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public gi1.a n(Context context) {
        return new fk.b(context);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ch0 o(boolean z) {
        this.e = z;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ch0 p(int i) {
        this.c = i;
        return this;
    }
}
