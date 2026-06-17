package defpackage;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class w3 {
    public final View a;
    public final int b;
    public final String c;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final View a;
        public final int b;
        public String c;

        public a(View view, int i) {
            this.a = view;
            this.b = i;
        }

        public w3 a() {
            return new w3(this.a, this.b, this.c);
        }

        public a b(String str) {
            this.c = str;
            return this;
        }
    }

    public w3(View view, int i, String str) {
        this.a = view;
        this.b = i;
        this.c = str;
    }
}
