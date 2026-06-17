package defpackage;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import okio.internal.Buffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class z95 {
    public final g a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a extends g {
        public final Window a;
        public final ha4 b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(Window window, ha4 ha4Var) {
            this.a = window;
            this.b = ha4Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // z95.g
        public void a(int i) {
            for (int i2 = 1; i2 <= 512; i2 <<= 1) {
                if ((i & i2) != 0) {
                    g(i2);
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // z95.g
        public void e(int i) {
            this.a.getDecorView().setTag(356039078, Integer.valueOf(i));
            if (i == 0) {
                k(6144);
                return;
            }
            if (i == 1) {
                k(Buffer.SEGMENTING_THRESHOLD);
                h(2048);
            } else {
                if (i != 2) {
                    return;
                }
                k(2048);
                h(Buffer.SEGMENTING_THRESHOLD);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // z95.g
        public void f(int i) {
            for (int i2 = 1; i2 <= 512; i2 <<= 1) {
                if ((i & i2) != 0) {
                    j(i2);
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void g(int i) {
            if (i == 1) {
                h(4);
            } else if (i == 2) {
                h(2);
            } else {
                if (i != 8) {
                    return;
                }
                this.b.a();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void h(int i) {
            View decorView = this.a.getDecorView();
            decorView.setSystemUiVisibility(i | decorView.getSystemUiVisibility());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void i(int i) {
            this.a.addFlags(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void j(int i) {
            if (i == 1) {
                k(4);
                l(1024);
            } else if (i == 2) {
                k(2);
            } else {
                if (i != 8) {
                    return;
                }
                this.b.b();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void k(int i) {
            View decorView = this.a.getDecorView();
            decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void l(int i) {
            this.a.clearFlags(i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b extends a {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(Window window, ha4 ha4Var) {
            super(window, ha4Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // z95.g
        public boolean b() {
            return (this.a.getDecorView().getSystemUiVisibility() & 8192) != 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // z95.g
        public void d(boolean z) {
            if (!z) {
                k(8192);
                return;
            }
            l(67108864);
            i(Integer.MIN_VALUE);
            h(8192);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c extends b {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(Window window, ha4 ha4Var) {
            super(window, ha4Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // z95.g
        public void c(boolean z) {
            if (!z) {
                k(16);
                return;
            }
            l(134217728);
            i(Integer.MIN_VALUE);
            h(16);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class e extends d {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e(Window window, z95 z95Var, ha4 ha4Var) {
            super(window, z95Var, ha4Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // z95.d, z95.g
        public void e(int i) {
            this.b.setSystemBarsBehavior(i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class f extends e {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public f(Window window, z95 z95Var, ha4 ha4Var) {
            super(window, z95Var, ha4Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // z95.d, z95.g
        public boolean b() {
            return (this.b.getSystemBarsAppearance() & 8) != 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class g {
        public abstract void a(int i);

        public abstract boolean b();

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void c(boolean z) {
        }

        public abstract void d(boolean z);

        public abstract void e(int i);

        public abstract void f(int i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public z95(Window window, View view) {
        ha4 ha4Var = new ha4(view);
        int i = Build.VERSION.SDK_INT;
        if (i >= 35) {
            this.a = new f(window, this, ha4Var);
            return;
        }
        if (i >= 30) {
            this.a = new d(window, this, ha4Var);
        } else if (i >= 26) {
            this.a = new c(window, ha4Var);
        } else {
            this.a = new b(window, ha4Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void a(int i) {
        this.a.a(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean b() {
        return this.a.b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void c(boolean z) {
        this.a.c(z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void d(boolean z) {
        this.a.d(z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e(int i) {
        this.a.e(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void f(int i) {
        this.a.f(i);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d extends g {
        public final z95 a;
        public final WindowInsetsController b;
        public final ha4 c;
        public final x64 d;
        public Window e;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(WindowInsetsController windowInsetsController, z95 z95Var, ha4 ha4Var) {
            this.d = new x64();
            this.b = windowInsetsController;
            this.a = z95Var;
            this.c = ha4Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // z95.g
        public void a(int i) {
            if ((i & 8) != 0) {
                this.c.a();
            }
            this.b.hide(i & (-9));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // z95.g
        public boolean b() {
            this.b.setSystemBarsAppearance(0, 0);
            return (this.b.getSystemBarsAppearance() & 8) != 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // z95.g
        public void c(boolean z) {
            Window window = this.e;
            if (z) {
                if (window != null) {
                    g(16);
                }
                this.b.setSystemBarsAppearance(16, 16);
            } else {
                if (window != null) {
                    h(16);
                }
                this.b.setSystemBarsAppearance(0, 16);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // z95.g
        public void d(boolean z) {
            Window window = this.e;
            if (z) {
                if (window != null) {
                    g(8192);
                }
                this.b.setSystemBarsAppearance(8, 8);
            } else {
                if (window != null) {
                    h(8192);
                }
                this.b.setSystemBarsAppearance(0, 8);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // z95.g
        public void e(int i) {
            Window window = this.e;
            if (window == null) {
                this.b.setSystemBarsBehavior(i);
                return;
            }
            window.getDecorView().setTag(356039078, Integer.valueOf(i));
            if (i == 0) {
                h(6144);
                return;
            }
            if (i == 1) {
                h(Buffer.SEGMENTING_THRESHOLD);
                g(2048);
            } else {
                if (i != 2) {
                    return;
                }
                h(2048);
                g(Buffer.SEGMENTING_THRESHOLD);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // z95.g
        public void f(int i) {
            if ((i & 8) != 0) {
                this.c.b();
            }
            this.b.show(i & (-9));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void g(int i) {
            View decorView = this.e.getDecorView();
            decorView.setSystemUiVisibility(i | decorView.getSystemUiVisibility());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void h(int i) {
            View decorView = this.e.getDecorView();
            decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
        }

        public d(Window window, z95 z95Var, ha4 ha4Var) {
            this(window.getInsetsController(), z95Var, ha4Var);
            this.e = window;
        }
    }
}
