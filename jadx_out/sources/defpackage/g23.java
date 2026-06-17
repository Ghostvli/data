package defpackage;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.l;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class g23 implements i {
    public f23 f;
    public boolean g = false;
    public int h;

    public void a(int i) {
        this.h = i;
    }

    @Override // androidx.appcompat.view.menu.i
    public void b(e eVar, boolean z) {
    }

    @Override // androidx.appcompat.view.menu.i
    public void c(boolean z) {
        if (this.g) {
            return;
        }
        f23 f23Var = this.f;
        if (z) {
            f23Var.d();
        } else {
            f23Var.q();
        }
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean e(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean f(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.i
    public int getId() {
        return this.h;
    }

    public void h(f23 f23Var) {
        this.f = f23Var;
    }

    @Override // androidx.appcompat.view.menu.i
    public void i(Context context, e eVar) {
        this.f.b(eVar);
    }

    @Override // androidx.appcompat.view.menu.i
    public void j(Parcelable parcelable) {
        if (parcelable instanceof a) {
            a aVar = (a) parcelable;
            this.f.p(aVar.f);
            this.f.n(ag.c(this.f.getContext(), aVar.g));
        }
    }

    public void k(boolean z) {
        this.g = z;
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean l(l lVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.i
    public Parcelable m() {
        a aVar = new a();
        aVar.f = this.f.getSelectedItemId();
        aVar.g = ag.d(this.f.getBadgeDrawables());
        return aVar;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a implements Parcelable {
        public static final Parcelable.Creator<a> CREATOR = new C0081a();
        public int f;
        public o73 g;

        /* JADX INFO: renamed from: g23$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class C0081a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public a[] newArray(int i) {
                return new a[i];
            }
        }

        public a(Parcel parcel) {
            this.f = parcel.readInt();
            this.g = (o73) parcel.readParcelable(getClass().getClassLoader());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f);
            parcel.writeParcelable(this.g, 0);
        }

        public a() {
        }
    }
}
