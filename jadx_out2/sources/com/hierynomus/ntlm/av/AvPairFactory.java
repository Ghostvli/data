package com.hierynomus.ntlm.av;

import com.hierynomus.protocol.commons.EnumWithValue;
import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.bo1;
import defpackage.ho1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class AvPairFactory {

    /* JADX INFO: renamed from: com.hierynomus.ntlm.av.AvPairFactory$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$hierynomus$ntlm$av$AvId;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        static {
            int[] iArr = new int[AvId.values().length];
            $SwitchMap$com$hierynomus$ntlm$av$AvId = iArr;
            try {
                iArr[AvId.MsvAvEOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$hierynomus$ntlm$av$AvId[AvId.MsvAvNbComputerName.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$hierynomus$ntlm$av$AvId[AvId.MsvAvNbDomainName.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$hierynomus$ntlm$av$AvId[AvId.MsvAvDnsComputerName.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$hierynomus$ntlm$av$AvId[AvId.MsvAvDnsDomainName.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$hierynomus$ntlm$av$AvId[AvId.MsvAvDnsTreeName.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$hierynomus$ntlm$av$AvId[AvId.MsvAvTargetName.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$hierynomus$ntlm$av$AvId[AvId.MsvAvFlags.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$hierynomus$ntlm$av$AvId[AvId.MsvAvTimestamp.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$hierynomus$ntlm$av$AvId[AvId.MsvAvSingleHost.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$hierynomus$ntlm$av$AvId[AvId.MsvAvChannelBindings.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Type inference failed for r5v6. Raw type applied. Possible types: com.hierynomus.ntlm.av.AvPair<byte[]>, com.hierynomus.ntlm.av.AvPair<?> */
    /* JADX DEBUG: Type inference failed for r5v7. Raw type applied. Possible types: com.hierynomus.ntlm.av.AvPair<byte[]>, com.hierynomus.ntlm.av.AvPair<?> */
    public static AvPair<?> read(Buffer<?> buffer) {
        int uInt16 = buffer.readUInt16();
        AvId avId = (AvId) EnumWithValue.EnumUtils.valueOf(uInt16, AvId.class, null);
        if (avId == null) {
            bo1.a("Encountered unknown AvId: ", uInt16);
            return null;
        }
        switch (AnonymousClass1.$SwitchMap$com$hierynomus$ntlm$av$AvId[avId.ordinal()]) {
            case 1:
                return new AvPairEnd().read(buffer);
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return new AvPairString(avId).read2(buffer);
            case 8:
                return new AvPairFlags().read(buffer);
            case 9:
                return new AvPairTimestamp().read(buffer);
            case 10:
                return new AvPairSingleHost().read2(buffer);
            case 11:
                return new AvPairChannelBindings().read(buffer);
            default:
                ho1.a("Encountered unhandled AvId: ", avId);
                return null;
        }
    }
}
