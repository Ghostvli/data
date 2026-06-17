package com.hierynomus.msdtyp.ace;

import com.hierynomus.msdtyp.SID;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.smb.SMBBuffer;
import defpackage.d;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ACE {
    private static final int HEADER_STRUCTURE_SIZE = 4;
    AceHeader aceHeader;

    /* JADX INFO: renamed from: com.hierynomus.msdtyp.ace.ACE$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$hierynomus$msdtyp$ace$AceType;

        static {
            int[] iArr = new int[AceType.values().length];
            $SwitchMap$com$hierynomus$msdtyp$ace$AceType = iArr;
            try {
                iArr[AceType.ACCESS_ALLOWED_ACE_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$hierynomus$msdtyp$ace$AceType[AceType.ACCESS_ALLOWED_CALLBACK_ACE_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$hierynomus$msdtyp$ace$AceType[AceType.ACCESS_ALLOWED_CALLBACK_OBJECT_ACE_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$hierynomus$msdtyp$ace$AceType[AceType.ACCESS_ALLOWED_OBJECT_ACE_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$hierynomus$msdtyp$ace$AceType[AceType.ACCESS_DENIED_ACE_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$hierynomus$msdtyp$ace$AceType[AceType.ACCESS_DENIED_CALLBACK_ACE_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$hierynomus$msdtyp$ace$AceType[AceType.ACCESS_DENIED_CALLBACK_OBJECT_ACE_TYPE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$hierynomus$msdtyp$ace$AceType[AceType.ACCESS_DENIED_OBJECT_ACE_TYPE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$hierynomus$msdtyp$ace$AceType[AceType.SYSTEM_AUDIT_ACE_TYPE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$hierynomus$msdtyp$ace$AceType[AceType.SYSTEM_AUDIT_CALLBACK_ACE_TYPE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$hierynomus$msdtyp$ace$AceType[AceType.SYSTEM_AUDIT_CALLBACK_OBJECT_ACE_TYPE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$hierynomus$msdtyp$ace$AceType[AceType.SYSTEM_AUDIT_OBJECT_ACE_TYPE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$hierynomus$msdtyp$ace$AceType[AceType.SYSTEM_MANDATORY_LABEL_ACE_TYPE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$hierynomus$msdtyp$ace$AceType[AceType.SYSTEM_RESOURCE_ATTRIBUTE_ACE_TYPE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$hierynomus$msdtyp$ace$AceType[AceType.SYSTEM_SCOPED_POLICY_ID_ACE_TYPE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    public ACE(AceHeader aceHeader) {
        new AceHeader();
        this.aceHeader = aceHeader;
    }

    public static ACE read(SMBBuffer sMBBuffer) throws Buffer.BufferException {
        ACE ace;
        int iRpos = sMBBuffer.rpos();
        AceHeader from = AceHeader.readFrom(sMBBuffer);
        switch (AnonymousClass1.$SwitchMap$com$hierynomus$msdtyp$ace$AceType[from.getAceType().ordinal()]) {
            case 1:
                ace = AceType1.read(from, sMBBuffer);
                break;
            case 2:
                ace = AceType3.read(from, sMBBuffer, iRpos);
                break;
            case 3:
                ace = AceType4.read(from, sMBBuffer, iRpos);
                break;
            case 4:
                ace = AceType2.read(from, sMBBuffer, iRpos);
                break;
            case 5:
                ace = AceType1.read(from, sMBBuffer);
                break;
            case 6:
                ace = AceType3.read(from, sMBBuffer, iRpos);
                break;
            case 7:
                ace = AceType4.read(from, sMBBuffer, iRpos);
                break;
            case 8:
                ace = AceType2.read(from, sMBBuffer, iRpos);
                break;
            case 9:
                ace = AceType1.read(from, sMBBuffer);
                break;
            case 10:
                ace = AceType3.read(from, sMBBuffer, iRpos);
                break;
            case 11:
                ace = AceType4.read(from, sMBBuffer, iRpos);
                break;
            case 12:
                ace = AceType4.read(from, sMBBuffer, iRpos);
                break;
            case 13:
                ace = AceType1.read(from, sMBBuffer);
                break;
            case 14:
                ace = AceType3.read(from, sMBBuffer, iRpos);
                break;
            case 15:
                ace = AceType1.read(from, sMBBuffer);
                break;
            default:
                d.a("Unknown ACE type: ", from.getAceType());
                return null;
        }
        sMBBuffer.rpos(iRpos + from.getAceSize());
        return ace;
    }

    public abstract long getAccessMask();

    public AceHeader getAceHeader() {
        return this.aceHeader;
    }

    public abstract SID getSid();

    public final void write(SMBBuffer sMBBuffer) {
        int iWpos = sMBBuffer.wpos();
        sMBBuffer.wpos(iWpos + 4);
        writeBody(sMBBuffer);
        int iWpos2 = sMBBuffer.wpos();
        sMBBuffer.wpos(iWpos);
        this.aceHeader.writeTo(sMBBuffer, iWpos2 - iWpos);
        sMBBuffer.wpos(iWpos2);
    }

    public abstract void writeBody(SMBBuffer sMBBuffer);
}
