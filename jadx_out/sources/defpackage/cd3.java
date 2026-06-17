package defpackage;

import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class cd3 implements Parcelable {
    public static final Parcelable.Creator<cd3> CREATOR = new a();
    public final int f;
    public final long g;
    public final long h;
    public final float i;
    public final long j;
    public final int k;
    public final CharSequence l;
    public final long m;
    public List n;
    public final long o;
    public final Bundle p;
    public PlaybackState q;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public cd3 createFromParcel(Parcel parcel) {
            return new cd3(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public cd3[] newArray(int i) {
            return new cd3[i];
        }
    }

    public cd3(Parcel parcel) {
        this.f = parcel.readInt();
        this.g = parcel.readLong();
        this.i = parcel.readFloat();
        this.m = parcel.readLong();
        this.h = parcel.readLong();
        this.j = parcel.readLong();
        this.l = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        List listCreateTypedArrayList = parcel.createTypedArrayList(c.CREATOR);
        this.n = listCreateTypedArrayList == null ? xi1.u() : listCreateTypedArrayList;
        this.o = parcel.readLong();
        this.p = parcel.readBundle(pi2.class.getClassLoader());
        this.k = parcel.readInt();
    }

    public static cd3 c(PlaybackState playbackState) {
        ArrayList arrayList = null;
        if (playbackState == null) {
            return null;
        }
        List<PlaybackState.CustomAction> customActions = playbackState.getCustomActions();
        if (customActions != null) {
            arrayList = new ArrayList(customActions.size());
            for (PlaybackState.CustomAction customAction : customActions) {
                if (customAction != null) {
                    arrayList.add(c.c(customAction));
                }
            }
        }
        cd3 cd3Var = new cd3(playbackState.getState(), playbackState.getPosition(), playbackState.getBufferedPosition(), playbackState.getPlaybackSpeed(), playbackState.getActions(), 0, playbackState.getErrorMessage(), playbackState.getLastPositionUpdateTime(), arrayList, playbackState.getActiveQueueItemId(), fy4.y(playbackState.getExtras()));
        cd3Var.q = playbackState;
        return cd3Var;
    }

    public long A() {
        return this.m;
    }

    public float B() {
        return this.i;
    }

    public PlaybackState C() {
        if (this.q == null) {
            PlaybackState.Builder builder = new PlaybackState.Builder();
            builder.setState(this.f, this.g, this.i, this.m);
            builder.setBufferedPosition(this.h);
            builder.setActions(this.j);
            builder.setErrorMessage(this.l);
            Iterator it = this.n.iterator();
            while (it.hasNext()) {
                PlaybackState.CustomAction customAction = (PlaybackState.CustomAction) ((c) it.next()).s();
                if (customAction != null) {
                    builder.addCustomAction(customAction);
                }
            }
            builder.setActiveQueueItemId(this.o);
            builder.setExtras(this.p);
            this.q = builder.build();
        }
        return this.q;
    }

    public long D() {
        return this.g;
    }

    public int E() {
        return this.f;
    }

    public long d() {
        return this.j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long s() {
        return this.o;
    }

    public String toString() {
        return "PlaybackState {state=" + this.f + ", position=" + this.g + ", buffered position=" + this.h + ", speed=" + this.i + ", updated=" + this.m + ", actions=" + this.j + ", error code=" + this.k + ", error message=" + this.l + ", custom actions=" + this.n + ", active item id=" + this.o + "}";
    }

    public long u() {
        return this.h;
    }

    public long v(Long l) {
        return Math.max(0L, this.g + ((long) (this.i * (l != null ? l.longValue() : SystemClock.elapsedRealtime() - this.m))));
    }

    public List w() {
        return this.n;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f);
        parcel.writeLong(this.g);
        parcel.writeFloat(this.i);
        parcel.writeLong(this.m);
        parcel.writeLong(this.h);
        parcel.writeLong(this.j);
        TextUtils.writeToParcel(this.l, parcel, i);
        parcel.writeTypedList(this.n);
        parcel.writeLong(this.o);
        parcel.writeBundle(this.p);
        parcel.writeInt(this.k);
    }

    public int x() {
        return this.k;
    }

    public CharSequence y() {
        return this.l;
    }

    public Bundle z() {
        return this.p;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c implements Parcelable {
        public static final Parcelable.Creator<c> CREATOR = new a();
        public final String f;
        public final CharSequence g;
        public final int h;
        public final Bundle i;
        public PlaybackState.CustomAction j;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public c[] newArray(int i) {
                return new c[i];
            }
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class b {
            public final String a;
            public final CharSequence b;
            public final int c;
            public Bundle d;

            public b(String str, CharSequence charSequence, int i) {
                if (TextUtils.isEmpty(str)) {
                    jl.a("You must specify an action to build a CustomAction");
                    throw null;
                }
                if (TextUtils.isEmpty(charSequence)) {
                    jl.a("You must specify a name to build a CustomAction");
                    throw null;
                }
                if (i == 0) {
                    jl.a("You must specify an icon resource id to build a CustomAction");
                    throw null;
                }
                this.a = str;
                this.b = charSequence;
                this.c = i;
            }

            public c a() {
                return new c(this.a, this.b, this.c, this.d);
            }

            public b b(Bundle bundle) {
                this.d = bundle;
                return this;
            }
        }

        public c(Parcel parcel) {
            this.f = (String) gg3.q(parcel.readString());
            this.g = (CharSequence) gg3.q((CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel));
            this.h = parcel.readInt();
            this.i = parcel.readBundle(pi2.class.getClassLoader());
        }

        public static c c(Object obj) {
            PlaybackState.CustomAction customAction = (PlaybackState.CustomAction) obj;
            c cVar = new c(customAction.getAction(), customAction.getName(), customAction.getIcon(), fy4.y(customAction.getExtras()));
            cVar.j = customAction;
            return cVar;
        }

        public String d() {
            return this.f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public Object s() {
            PlaybackState.CustomAction customAction = this.j;
            if (customAction != null) {
                return customAction;
            }
            PlaybackState.CustomAction.Builder builder = new PlaybackState.CustomAction.Builder(this.f, this.g, this.h);
            builder.setExtras(this.i);
            return builder.build();
        }

        public String toString() {
            return "Action:mName='" + ((Object) this.g) + ", mIcon=" + this.h + ", mExtras=" + this.i;
        }

        public Bundle u() {
            return this.i;
        }

        public int v() {
            return this.h;
        }

        public CharSequence w() {
            return this.g;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f);
            TextUtils.writeToParcel(this.g, parcel, i);
            parcel.writeInt(this.h);
            parcel.writeBundle(this.i);
        }

        public c(String str, CharSequence charSequence, int i, Bundle bundle) {
            this.f = str;
            this.g = charSequence;
            this.h = i;
            this.i = bundle;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final List a;
        public int b;
        public long c;
        public long d;
        public float e;
        public long f;
        public int g;
        public CharSequence h;
        public long i;
        public long j;
        public Bundle k;

        public b(cd3 cd3Var) {
            ArrayList arrayList = new ArrayList();
            this.a = arrayList;
            this.j = -1L;
            this.b = cd3Var.f;
            this.c = cd3Var.g;
            this.e = cd3Var.i;
            this.i = cd3Var.m;
            this.d = cd3Var.h;
            this.f = cd3Var.j;
            this.g = cd3Var.k;
            this.h = cd3Var.l;
            List list = cd3Var.n;
            if (list != null) {
                arrayList.addAll(list);
            }
            this.j = cd3Var.o;
            this.k = cd3Var.p;
        }

        public b a(c cVar) {
            this.a.add(cVar);
            return this;
        }

        public cd3 b() {
            return new cd3(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.a, this.j, this.k);
        }

        public b c(long j) {
            this.f = j;
            return this;
        }

        public b d(long j) {
            this.j = j;
            return this;
        }

        public b e(long j) {
            this.d = j;
            return this;
        }

        public b f(int i, CharSequence charSequence) {
            this.g = i;
            this.h = charSequence;
            return this;
        }

        public b g(Bundle bundle) {
            this.k = bundle;
            return this;
        }

        public b h(int i, long j, float f, long j2) {
            this.b = i;
            this.c = j;
            this.i = j2;
            this.e = f;
            return this;
        }

        public b() {
            this.a = new ArrayList();
            this.j = -1L;
        }
    }

    public cd3(int i, long j, long j2, float f, long j3, int i2, CharSequence charSequence, long j4, List list, long j5, Bundle bundle) {
        this.f = i;
        this.g = j;
        this.h = j2;
        this.i = f;
        this.j = j3;
        this.k = i2;
        this.l = charSequence;
        this.m = j4;
        this.n = list == null ? xi1.u() : new ArrayList(list);
        this.o = j5;
        this.p = bundle;
    }
}
