package defpackage;

import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.media.metrics.LogSessionId;
import android.os.Build;
import android.text.TextUtils;
import defpackage.oo0;
import defpackage.xi3;
import defpackage.yv0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.jupnp.support.model.dlna.DLNAProfiles;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class z71 implements yv0 {
    public static final yv0.c d = new yv0.c() { // from class: w71
        @Override // yv0.c
        public final yv0 a(UUID uuid) {
            return z71.n(uuid);
        }
    };
    public final UUID a;
    public final MediaDrm b;
    public int c;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public static boolean a(MediaDrm mediaDrm, String str, int i) {
            return mediaDrm.requiresSecureDecoder(str, i);
        }

        public static void b(MediaDrm mediaDrm, byte[] bArr, ie3 ie3Var) {
            LogSessionId logSessionIdA = ie3Var.a();
            if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                return;
            }
            y71.a(gg3.q(mediaDrm.getPlaybackComponent(bArr))).setLogSessionId(logSessionIdA);
        }
    }

    public z71(UUID uuid) {
        gg3.q(uuid);
        gg3.e(!kn.c.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.a = uuid;
        MediaDrm mediaDrm = new MediaDrm(u(uuid));
        this.b = mediaDrm;
        this.c = 1;
        if (kn.e.equals(uuid) && C()) {
            x(mediaDrm);
        }
    }

    public static boolean A(UUID uuid) {
        return MediaDrm.isCryptoSchemeSupported(u(uuid));
    }

    public static boolean C() {
        return "ASUS_Z00AD".equals(Build.MODEL);
    }

    public static z71 D(UUID uuid) throws zw4 {
        try {
            return new z71(uuid);
        } catch (UnsupportedSchemeException e) {
            throw new zw4(1, e);
        } catch (Exception e2) {
            throw new zw4(2, e2);
        }
    }

    public static /* synthetic */ yv0 n(UUID uuid) {
        try {
            return D(uuid);
        } catch (zw4 unused) {
            xz1.d("FrameworkMediaDrm", "Failed to instantiate a FrameworkMediaDrm for uuid: " + uuid + ".");
            return new sp0();
        }
    }

    public static /* synthetic */ void o(z71 z71Var, yv0.b bVar, MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
        z71Var.getClass();
        bVar.a(z71Var, bArr, i, i2, bArr2);
    }

    public static byte[] p(byte[] bArr) {
        r73 r73Var = new r73(bArr);
        int iD = r73Var.D();
        short sF = r73Var.F();
        short sF2 = r73Var.F();
        if (sF != 1 || sF2 != 1) {
            xz1.g("FrameworkMediaDrm", "Unexpected record count or type. Skipping LA_URL workaround.");
            return bArr;
        }
        short sF3 = r73Var.F();
        Charset charset = StandardCharsets.UTF_16LE;
        String strO = r73Var.O(sF3, charset);
        if (strO.contains("<LA_URL>")) {
            return bArr;
        }
        int iIndexOf = strO.indexOf("</DATA>");
        if (iIndexOf == -1) {
            xz1.i("FrameworkMediaDrm", "Could not find the </DATA> tag. Skipping LA_URL workaround.");
        }
        String str = strO.substring(0, iIndexOf) + "<LA_URL>https://x</LA_URL>" + strO.substring(iIndexOf);
        int i = iD + 52;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.putInt(i);
        byteBufferAllocate.putShort(sF);
        byteBufferAllocate.putShort(sF2);
        byteBufferAllocate.putShort((short) (str.length() * 2));
        byteBufferAllocate.put(str.getBytes(charset));
        return byteBufferAllocate.array();
    }

    public static byte[] r(UUID uuid, byte[] bArr) {
        return kn.d.equals(uuid) ? pu.a(bArr) : bArr;
    }

    public static byte[] s(UUID uuid, byte[] bArr) {
        byte[] bArrE;
        xi3.a aVarD;
        UUID uuid2 = kn.f;
        if (uuid2.equals(uuid)) {
            byte[] bArrE2 = xi3.e(bArr, uuid);
            if (bArrE2 != null) {
                bArr = bArrE2;
            }
            bArr = xi3.a(uuid2, p(bArr));
        }
        if (v(uuid) && (aVarD = xi3.d(bArr)) != null) {
            bArr = xi3.b(kn.c, aVarD.d, aVarD.c);
        }
        if (uuid2.equals(uuid) && "Amazon".equals(Build.MANUFACTURER)) {
            String str = Build.MODEL;
            if (("AFTB".equals(str) || "AFTS".equals(str) || "AFTM".equals(str) || "AFTT".equals(str)) && (bArrE = xi3.e(bArr, uuid)) != null) {
                return bArrE;
            }
        }
        return bArr;
    }

    public static String t(UUID uuid, String str) {
        return (Build.VERSION.SDK_INT < 26 && kn.d.equals(uuid) && (DLNAProfiles.DLNAMimeTypes.MIME_VIDEO_MPEG_4.equals(str) || DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_MPEG_4.equals(str))) ? "cenc" : str;
    }

    public static UUID u(UUID uuid) {
        return v(uuid) ? kn.c : uuid;
    }

    public static boolean v(UUID uuid) {
        return Build.VERSION.SDK_INT < 27 && Objects.equals(uuid, kn.d);
    }

    public static void x(MediaDrm mediaDrm) {
        mediaDrm.setPropertyString("securityLevel", "L3");
    }

    public static oo0.b z(UUID uuid, List list) {
        if (!kn.e.equals(uuid)) {
            return (oo0.b) list.get(0);
        }
        if (Build.VERSION.SDK_INT >= 28 && list.size() > 1) {
            oo0.b bVar = (oo0.b) list.get(0);
            int length = 0;
            for (int i = 0; i < list.size(); i++) {
                oo0.b bVar2 = (oo0.b) list.get(i);
                byte[] bArr = (byte[]) gg3.q(bVar2.j);
                if (Objects.equals(bVar2.i, bVar.i) && Objects.equals(bVar2.h, bVar.h) && xi3.c(bArr)) {
                    length += bArr.length;
                }
            }
            byte[] bArr2 = new byte[length];
            int i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                byte[] bArr3 = (byte[]) gg3.q(((oo0.b) list.get(i3)).j);
                int length2 = bArr3.length;
                System.arraycopy(bArr3, 0, bArr2, i2, length2);
                i2 += length2;
            }
            return bVar.d(bArr2);
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            oo0.b bVar3 = (oo0.b) list.get(i4);
            if (xi3.g((byte[]) gg3.q(bVar3.j)) == 1) {
                return bVar3;
            }
        }
        return (oo0.b) list.get(0);
    }

    public final boolean B() {
        if (!this.a.equals(kn.e)) {
            return this.a.equals(kn.d);
        }
        String strY = y("version");
        return (strY.startsWith("v5.") || strY.startsWith("14.") || strY.startsWith("15.") || strY.startsWith("16.0")) ? false : true;
    }

    @Override // defpackage.yv0
    public Map a(byte[] bArr) {
        return this.b.queryKeyStatus(bArr);
    }

    @Override // defpackage.yv0
    public yv0.d b() {
        MediaDrm.ProvisionRequest provisionRequest = this.b.getProvisionRequest();
        return new yv0.d(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    @Override // defpackage.yv0
    public byte[] d() {
        return this.b.openSession();
    }

    @Override // defpackage.yv0
    public boolean e(byte[] bArr, String str) throws Throwable {
        MediaCrypto mediaCrypto;
        if (Build.VERSION.SDK_INT >= 31 && B()) {
            MediaDrm mediaDrm = this.b;
            return a.a(mediaDrm, str, mediaDrm.getSecurityLevel(bArr));
        }
        MediaCrypto mediaCrypto2 = null;
        try {
            try {
                mediaCrypto = new MediaCrypto(u(this.a), bArr);
            } catch (Throwable th) {
                th = th;
            }
        } catch (MediaCryptoException unused) {
        }
        try {
            boolean zRequiresSecureDecoderComponent = mediaCrypto.requiresSecureDecoderComponent(str);
            mediaCrypto.release();
            return zRequiresSecureDecoderComponent;
        } catch (MediaCryptoException unused2) {
            mediaCrypto2 = mediaCrypto;
            boolean z = !this.a.equals(kn.d);
            if (mediaCrypto2 != null) {
                mediaCrypto2.release();
            }
            return z;
        } catch (Throwable th2) {
            th = th2;
            mediaCrypto2 = mediaCrypto;
            if (mediaCrypto2 != null) {
                mediaCrypto2.release();
            }
            throw th;
        }
    }

    @Override // defpackage.yv0
    public void f(byte[] bArr, byte[] bArr2) {
        this.b.restoreKeys(bArr, bArr2);
    }

    @Override // defpackage.yv0
    public void g(byte[] bArr) {
        this.b.closeSession(bArr);
    }

    @Override // defpackage.yv0
    public byte[] h(byte[] bArr, byte[] bArr2) {
        if (kn.d.equals(this.a)) {
            bArr2 = pu.b(bArr2);
        }
        return this.b.provideKeyResponse(bArr, bArr2);
    }

    @Override // defpackage.yv0
    public void i(final yv0.b bVar) {
        this.b.setOnEventListener(bVar == null ? null : new MediaDrm.OnEventListener() { // from class: x71
            @Override // android.media.MediaDrm.OnEventListener
            public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
                z71.o(this.a, bVar, mediaDrm, bArr, i, i2, bArr2);
            }
        });
    }

    @Override // defpackage.yv0
    public void j(byte[] bArr) throws DeniedByServerException {
        this.b.provideProvisionResponse(bArr);
    }

    @Override // defpackage.yv0
    public yv0.a k(byte[] bArr, List list, int i, HashMap map) throws NotProvisionedException {
        oo0.b bVarZ;
        byte[] bArrS;
        String strT;
        if (list != null) {
            bVarZ = z(this.a, list);
            bArrS = s(this.a, (byte[]) gg3.q(bVarZ.j));
            strT = t(this.a, bVarZ.i);
        } else {
            bVarZ = null;
            bArrS = null;
            strT = null;
        }
        MediaDrm.KeyRequest keyRequest = this.b.getKeyRequest(bArr, bArrS, strT, i, map);
        byte[] bArrR = r(this.a, keyRequest.getData());
        String strQ = q(keyRequest.getDefaultUrl());
        if (TextUtils.isEmpty(strQ) && bVarZ != null && !TextUtils.isEmpty(bVarZ.h)) {
            strQ = bVarZ.h;
        }
        return new yv0.a(bArrR, strQ, keyRequest.getRequestType());
    }

    @Override // defpackage.yv0
    public int l() {
        return 2;
    }

    @Override // defpackage.yv0
    public void m(byte[] bArr, ie3 ie3Var) {
        if (Build.VERSION.SDK_INT >= 31) {
            try {
                a.b(this.b, bArr, ie3Var);
            } catch (UnsupportedOperationException unused) {
                xz1.i("FrameworkMediaDrm", "setLogSessionId failed.");
            }
        }
    }

    public final String q(String str) {
        if ("<LA_URL>https://x</LA_URL>".equals(str)) {
            return "";
        }
        if (Build.VERSION.SDK_INT >= 33 && "https://default.url".equals(str)) {
            String strY = y("version");
            if (Objects.equals(strY, "1.2") || Objects.equals(strY, "aidl-1")) {
                return "";
            }
        }
        return str;
    }

    @Override // defpackage.yv0
    public synchronized void release() {
        int i = this.c - 1;
        this.c = i;
        if (i == 0) {
            this.b.release();
        }
    }

    @Override // defpackage.yv0
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public v71 c(byte[] bArr) {
        return new v71(u(this.a), bArr);
    }

    public String y(String str) {
        return this.b.getPropertyString(str);
    }
}
