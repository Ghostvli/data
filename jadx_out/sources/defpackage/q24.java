package defpackage;

import android.content.Intent;
import com.fongmi.android.tv.App;
import com.github.catvod.utils.Prefers;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class q24 {
    public static boolean A() {
        return a() == 2;
    }

    public static boolean B() {
        return Prefers.getBoolean("boot_live");
    }

    public static boolean C() {
        return Prefers.getBoolean("caption");
    }

    public static boolean D() {
        return Prefers.getBoolean("change", true);
    }

    public static boolean E() {
        return Prefers.getBoolean("danmaku_load");
    }

    public static boolean F() {
        return Prefers.getBoolean("danmaku_show");
    }

    public static boolean G() {
        return Prefers.getBoolean("disclaimer_accepted", false);
    }

    public static boolean H() {
        return Prefers.getBoolean("hide_play_url");
    }

    public static boolean I() {
        return Prefers.getBoolean("incognito");
    }

    public static boolean J() {
        return Prefers.getBoolean("invert");
    }

    public static boolean K() {
        return Prefers.getBoolean("prefer_aac");
    }

    public static boolean L() {
        return Prefers.getBoolean("search_sort", true);
    }

    public static boolean M() {
        return Prefers.getBoolean("tunnel");
    }

    public static boolean N() {
        return Prefers.getBoolean("zte_nat_auto");
    }

    public static void O(boolean z) {
        Prefers.put("across", Boolean.valueOf(z));
    }

    public static void P(boolean z) {
        Prefers.put("adblock", Boolean.valueOf(z));
    }

    public static void Q(boolean z) {
        Prefers.put("audio_prefer", Boolean.valueOf(z));
    }

    public static void R(int i) {
        Prefers.put("background", Integer.valueOf(i));
    }

    public static void S(boolean z) {
        Prefers.put("boot_live", Boolean.valueOf(z));
    }

    public static void T(int i) {
        Prefers.put("buffer", Integer.valueOf(i));
    }

    public static void U(boolean z) {
        Prefers.put("caption", Boolean.valueOf(z));
    }

    public static void V(boolean z) {
        Prefers.put("change", Boolean.valueOf(z));
    }

    public static void W(boolean z) {
        Prefers.put("danmaku_load", Boolean.valueOf(z));
    }

    public static void X(boolean z) {
        Prefers.put("danmaku_show", Boolean.valueOf(z));
    }

    public static void Y(boolean z) {
        Prefers.put("disclaimer_accepted", Boolean.valueOf(z));
    }

    public static void Z(String str) {
        Prefers.put("doh", str);
    }

    public static int a() {
        return Prefers.getInt("background", 2);
    }

    public static void a0(int i) {
        Prefers.put("exo_decode", Integer.valueOf(i));
    }

    public static int b() {
        return Math.min(Math.max(Prefers.getInt("buffer"), 1), 10);
    }

    public static void b0(boolean z) {
        Prefers.put("hide_play_url", Boolean.valueOf(z));
    }

    public static String c() {
        return Prefers.getString("doh");
    }

    public static void c0(String str) {
        Prefers.put("hot", str);
    }

    public static int d() {
        return Prefers.getInt("exo_decode", 1);
    }

    public static void d0(boolean z) {
        Prefers.put("incognito", Boolean.valueOf(z));
    }

    public static String e() {
        return Prefers.getString("hot");
    }

    public static void e0(boolean z) {
        Prefers.put("invert", Boolean.valueOf(z));
    }

    public static String f() {
        return Prefers.getString("keyword");
    }

    public static void f0(String str) {
        Prefers.put("keyword", str);
    }

    public static int g() {
        return Prefers.getInt("scale_live", n());
    }

    public static void g0(int i) {
        Prefers.put("scale_live", Integer.valueOf(i));
    }

    public static int h() {
        return Prefers.getInt("mpv_decode", 1);
    }

    public static void h0(int i) {
        Prefers.put("mpv_decode", Integer.valueOf(i));
    }

    public static int i() {
        return Prefers.getInt("play_end_action", 1);
    }

    public static void i0(int i) {
        Prefers.put("play_end_action", Integer.valueOf(i));
    }

    public static int j() {
        return Prefers.getInt("player_engine", 2);
    }

    public static void j0(int i) {
        Prefers.put("player_engine", Integer.valueOf(i));
    }

    public static int k() {
        return Prefers.getInt("render", 0);
    }

    public static void k0(boolean z) {
        Prefers.put("prefer_aac", Boolean.valueOf(z));
    }

    public static int l() {
        return Prefers.getInt("reset", 0);
    }

    public static void l0(int i) {
        Prefers.put("render", Integer.valueOf(i));
    }

    public static int m() {
        return Prefers.getInt("rtsp_transport", 1);
    }

    public static void m0(int i) {
        Prefers.put("reset", Integer.valueOf(i));
    }

    public static int n() {
        return Prefers.getInt("scale");
    }

    public static void n0(int i) {
        Prefers.put("rtsp_transport", Integer.valueOf(i));
    }

    public static int o() {
        return Prefers.getInt("size", 2);
    }

    public static void o0(int i) {
        Prefers.put("scale", Integer.valueOf(i));
    }

    public static float p() {
        return Math.min(Math.max(Prefers.getFloat("speed", 3.0f), 2.0f), 5.0f);
    }

    public static void p0(boolean z) {
        Prefers.put("search_sort", Boolean.valueOf(z));
    }

    public static float q() {
        return Prefers.getFloat("subtitle_text_size");
    }

    public static void q0(int i) {
        Prefers.put("size", Integer.valueOf(i));
    }

    public static int r() {
        return Prefers.getInt("sync_mode");
    }

    public static void r0(float f) {
        Prefers.put("speed", Float.valueOf(f));
    }

    public static String s() {
        return Prefers.getString("ua");
    }

    public static void s0(float f) {
        Prefers.put("subtitle_position", Float.valueOf(f));
    }

    public static int t() {
        return Prefers.getInt("wall", 1);
    }

    public static void t0(float f) {
        Prefers.put("subtitle_text_size", Float.valueOf(f));
    }

    public static int u() {
        return Prefers.getInt("wall_type", 0);
    }

    public static void u0(int i) {
        Prefers.put("sync_mode", Integer.valueOf(i));
    }

    public static boolean v() {
        return new Intent("android.settings.CAPTIONING_SETTINGS").resolveActivity(App.b().getPackageManager()) != null;
    }

    public static void v0(boolean z) {
        Prefers.put("tunnel", Boolean.valueOf(z));
    }

    public static boolean w() {
        return Prefers.getBoolean("across", true);
    }

    public static void w0(String str) {
        Prefers.put("ua", str);
    }

    public static boolean x() {
        return Prefers.getBoolean("adblock", true);
    }

    public static void x0(int i) {
        Prefers.put("wall", Integer.valueOf(i));
    }

    public static boolean y() {
        return Prefers.getBoolean("audio_prefer");
    }

    public static void y0(int i) {
        Prefers.put("wall_type", Integer.valueOf(i));
    }

    public static boolean z() {
        return a() == 0;
    }

    public static void z0(boolean z) {
        Prefers.put("zte_nat_auto", Boolean.valueOf(z));
    }
}
