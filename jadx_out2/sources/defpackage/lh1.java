package defpackage;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import defpackage.kh1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface lh1 extends IInterface {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class a extends Binder implements lh1 {

        /* JADX INFO: renamed from: lh1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static class C0094a implements lh1 {
            public static lh1 e;
            public IBinder d;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public C0094a(IBinder iBinder) {
                this.d = iBinder;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.d;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.lh1
            public int e() {
                int iE;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (this.d.transact(47, parcelObtain, parcelObtain2, 0) || a.a1() == null) {
                        parcelObtain2.readException();
                        iE = parcelObtain2.readInt();
                    } else {
                        iE = ((lh1) gg3.q(a.a1())).e();
                    }
                    return iE;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.lh1
            public boolean f() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.d.transact(45, parcelObtain, parcelObtain2, 0) && a.a1() != null) {
                        return ((lh1) gg3.q(a.a1())).f();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.lh1
            public cd3 getPlaybackState() {
                cd3 cd3VarCreateFromParcel;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (this.d.transact(28, parcelObtain, parcelObtain2, 0) || a.a1() == null) {
                        parcelObtain2.readException();
                        cd3VarCreateFromParcel = parcelObtain2.readInt() != 0 ? cd3.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        cd3VarCreateFromParcel = ((lh1) gg3.q(a.a1())).getPlaybackState();
                    }
                    return cd3VarCreateFromParcel;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.lh1
            public int getRepeatMode() {
                int repeatMode;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (this.d.transact(37, parcelObtain, parcelObtain2, 0) || a.a1() == null) {
                        parcelObtain2.readException();
                        repeatMode = parcelObtain2.readInt();
                    } else {
                        repeatMode = ((lh1) gg3.q(a.a1())).getRepeatMode();
                    }
                    return repeatMode;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.lh1
            public void m0(kh1 kh1Var) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcelObtain.writeStrongBinder(kh1Var != null ? kh1Var.asBinder() : null);
                    if (this.d.transact(4, parcelObtain, parcelObtain2, 0) || a.a1() == null) {
                        parcelObtain2.readException();
                    } else {
                        ((lh1) gg3.q(a.a1())).m0(kh1Var);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.lh1
            public void t0(kh1 kh1Var) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcelObtain.writeStrongBinder(kh1Var != null ? kh1Var.asBinder() : null);
                    if (this.d.transact(3, parcelObtain, parcelObtain2, 0) || a.a1() == null) {
                        parcelObtain2.readException();
                    } else {
                        ((lh1) gg3.q(a.a1())).t0(kh1Var);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
            attachInterface(this, "android.support.v4.media.session.IMediaSession");
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static lh1 Z0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("android.support.v4.media.session.IMediaSession");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof lh1)) ? new C0094a(iBinder) : (lh1) iInterfaceQueryLocalInterface;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static lh1 a1() {
            return C0094a.e;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 3) {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                t0(kh1.a.Z0(parcel.readStrongBinder()));
                ((Parcel) gg3.q(parcel2)).writeNoException();
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                m0(kh1.a.Z0(parcel.readStrongBinder()));
                ((Parcel) gg3.q(parcel2)).writeNoException();
                return true;
            }
            if (i == 28) {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                cd3 playbackState = getPlaybackState();
                ((Parcel) gg3.q(parcel2)).writeNoException();
                if (playbackState != null) {
                    ((Parcel) gg3.q(parcel2)).writeInt(1);
                    playbackState.writeToParcel(parcel2, 1);
                } else {
                    ((Parcel) gg3.q(parcel2)).writeInt(0);
                }
                return true;
            }
            if (i == 37) {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                int repeatMode = getRepeatMode();
                ((Parcel) gg3.q(parcel2)).writeNoException();
                ((Parcel) gg3.q(parcel2)).writeInt(repeatMode);
                return true;
            }
            if (i == 45) {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                boolean zF = f();
                ((Parcel) gg3.q(parcel2)).writeNoException();
                ((Parcel) gg3.q(parcel2)).writeInt(zF ? 1 : 0);
                return true;
            }
            if (i == 47) {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                int iE = e();
                ((Parcel) gg3.q(parcel2)).writeNoException();
                ((Parcel) gg3.q(parcel2)).writeInt(iE);
                return true;
            }
            if (i != 50) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                ((Parcel) gg3.q(parcel2)).writeString("android.support.v4.media.session.IMediaSession");
                return true;
            }
            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
            Bundle bundleJ = J();
            ((Parcel) gg3.q(parcel2)).writeNoException();
            if (bundleJ != null) {
                ((Parcel) gg3.q(parcel2)).writeInt(1);
                bundleJ.writeToParcel(parcel2, 1);
            } else {
                ((Parcel) gg3.q(parcel2)).writeInt(0);
            }
            return true;
        }
    }

    Bundle J();

    int e();

    boolean f();

    cd3 getPlaybackState();

    int getRepeatMode();

    void m0(kh1 kh1Var);

    void t0(kh1 kh1Var);
}
