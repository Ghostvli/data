package com.hierynomus.mssmb2;

import com.hierynomus.mserref.NtStatus;
import com.hierynomus.mssmb2.messages.SMB2Cancel;
import com.hierynomus.mssmb2.messages.SMB2ChangeNotifyResponse;
import com.hierynomus.mssmb2.messages.SMB2Close;
import com.hierynomus.mssmb2.messages.SMB2CreateResponse;
import com.hierynomus.mssmb2.messages.SMB2Echo;
import com.hierynomus.mssmb2.messages.SMB2Flush;
import com.hierynomus.mssmb2.messages.SMB2IoctlRequest;
import com.hierynomus.mssmb2.messages.SMB2IoctlResponse;
import com.hierynomus.mssmb2.messages.SMB2LockResponse;
import com.hierynomus.mssmb2.messages.SMB2Logoff;
import com.hierynomus.mssmb2.messages.SMB2NegotiateResponse;
import com.hierynomus.mssmb2.messages.SMB2QueryDirectoryResponse;
import com.hierynomus.mssmb2.messages.SMB2QueryInfoResponse;
import com.hierynomus.mssmb2.messages.SMB2ReadResponse;
import com.hierynomus.mssmb2.messages.SMB2SessionSetup;
import com.hierynomus.mssmb2.messages.SMB2SetInfoResponse;
import com.hierynomus.mssmb2.messages.SMB2TreeConnectResponse;
import com.hierynomus.mssmb2.messages.SMB2TreeDisconnect;
import com.hierynomus.mssmb2.messages.SMB2WriteResponse;
import com.hierynomus.smb.SMBPacket;
import com.hierynomus.smbj.common.SMBRuntimeException;
import defpackage.j02;
import defpackage.n02;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2MessageConverter {
    private static final long FSCTL_DFS_GET_REFERRALS = 393620;
    private static final long FSCTL_PIPE_PEEK = 1130508;
    private static final long FSCTL_PIPE_TRANSCEIVE = 1163287;
    private static final long FSCTL_SRV_COPYCHUNK = 1327346;
    private static final long FSCTL_SRV_COPYCHUNK_WRITE = 1343730;
    private static final j02 logger = n02.k(SMB2MessageConverter.class);

    /* JADX INFO: renamed from: com.hierynomus.mssmb2.SMB2MessageConverter$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$hierynomus$mssmb2$SMB2MessageCommandCode;

        static {
            int[] iArr = new int[SMB2MessageCommandCode.values().length];
            $SwitchMap$com$hierynomus$mssmb2$SMB2MessageCommandCode = iArr;
            try {
                iArr[SMB2MessageCommandCode.SMB2_NEGOTIATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$hierynomus$mssmb2$SMB2MessageCommandCode[SMB2MessageCommandCode.SMB2_SESSION_SETUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$hierynomus$mssmb2$SMB2MessageCommandCode[SMB2MessageCommandCode.SMB2_TREE_CONNECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$hierynomus$mssmb2$SMB2MessageCommandCode[SMB2MessageCommandCode.SMB2_TREE_DISCONNECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$hierynomus$mssmb2$SMB2MessageCommandCode[SMB2MessageCommandCode.SMB2_LOGOFF.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$hierynomus$mssmb2$SMB2MessageCommandCode[SMB2MessageCommandCode.SMB2_CREATE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$hierynomus$mssmb2$SMB2MessageCommandCode[SMB2MessageCommandCode.SMB2_CHANGE_NOTIFY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$hierynomus$mssmb2$SMB2MessageCommandCode[SMB2MessageCommandCode.SMB2_QUERY_DIRECTORY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$hierynomus$mssmb2$SMB2MessageCommandCode[SMB2MessageCommandCode.SMB2_ECHO.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$hierynomus$mssmb2$SMB2MessageCommandCode[SMB2MessageCommandCode.SMB2_READ.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$hierynomus$mssmb2$SMB2MessageCommandCode[SMB2MessageCommandCode.SMB2_CLOSE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$hierynomus$mssmb2$SMB2MessageCommandCode[SMB2MessageCommandCode.SMB2_FLUSH.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$hierynomus$mssmb2$SMB2MessageCommandCode[SMB2MessageCommandCode.SMB2_WRITE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$hierynomus$mssmb2$SMB2MessageCommandCode[SMB2MessageCommandCode.SMB2_IOCTL.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$hierynomus$mssmb2$SMB2MessageCommandCode[SMB2MessageCommandCode.SMB2_QUERY_INFO.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$hierynomus$mssmb2$SMB2MessageCommandCode[SMB2MessageCommandCode.SMB2_SET_INFO.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$hierynomus$mssmb2$SMB2MessageCommandCode[SMB2MessageCommandCode.SMB2_CANCEL.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$hierynomus$mssmb2$SMB2MessageCommandCode[SMB2MessageCommandCode.SMB2_LOCK.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$hierynomus$mssmb2$SMB2MessageCommandCode[SMB2MessageCommandCode.SMB2_OPLOCK_BREAK.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
        }
    }

    private SMB2Packet getPacketInstance(SMB2PacketData sMB2PacketData) {
        SMB2MessageCommandCode message = sMB2PacketData.getHeader().getMessage();
        switch (AnonymousClass1.$SwitchMap$com$hierynomus$mssmb2$SMB2MessageCommandCode[message.ordinal()]) {
            case 1:
                return new SMB2NegotiateResponse();
            case 2:
                return new SMB2SessionSetup();
            case 3:
                return new SMB2TreeConnectResponse();
            case 4:
                return new SMB2TreeDisconnect();
            case 5:
                return new SMB2Logoff();
            case 6:
                return new SMB2CreateResponse();
            case 7:
                return new SMB2ChangeNotifyResponse();
            case 8:
                return new SMB2QueryDirectoryResponse();
            case 9:
                return new SMB2Echo();
            case 10:
                return new SMB2ReadResponse();
            case 11:
                return new SMB2Close();
            case 12:
                return new SMB2Flush();
            case 13:
                return new SMB2WriteResponse();
            case 14:
                return new SMB2IoctlResponse();
            case 15:
                return new SMB2QueryInfoResponse();
            case 16:
                return new SMB2SetInfoResponse();
            case 17:
                return new SMB2Cancel();
            case 18:
                return new SMB2LockResponse();
            default:
                logger.error("Unknown SMB2 Message Command type: " + message);
                throw new SMBRuntimeException("Unknown SMB2 Message Command type: " + message);
        }
    }

    private boolean isSuccess(SMBPacket<?, ?> sMBPacket, SMB2PacketData sMB2PacketData) {
        if (sMB2PacketData.isSuccess()) {
            return true;
        }
        SMB2MessageCommandCode message = sMB2PacketData.getHeader().getMessage();
        long statusCode = sMB2PacketData.getHeader().getStatusCode();
        int i = AnonymousClass1.$SwitchMap$com$hierynomus$mssmb2$SMB2MessageCommandCode[message.ordinal()];
        if (i == 2) {
            return statusCode == NtStatus.STATUS_MORE_PROCESSING_REQUIRED.getValue();
        }
        if (i == 7) {
            return statusCode == NtStatus.STATUS_NOTIFY_ENUM_DIR.getValue();
        }
        if (i != 10) {
            if (i == 14) {
                long controlCode = ((SMB2IoctlRequest) sMBPacket).getControlCode();
                return (controlCode == FSCTL_PIPE_PEEK || controlCode == FSCTL_PIPE_TRANSCEIVE || controlCode == FSCTL_DFS_GET_REFERRALS) ? statusCode == NtStatus.STATUS_BUFFER_OVERFLOW.getValue() : (controlCode == FSCTL_SRV_COPYCHUNK || controlCode == FSCTL_SRV_COPYCHUNK_WRITE) && statusCode == NtStatus.STATUS_INVALID_PARAMETER.getValue();
            }
            if (i != 15) {
                return false;
            }
        }
        return statusCode == NtStatus.STATUS_BUFFER_OVERFLOW.getValue();
    }

    public SMB2Packet readPacket(SMBPacket<?, ?> sMBPacket, SMB2PacketData sMB2PacketData) {
        SMB2Packet packetInstance = getPacketInstance(sMB2PacketData);
        if (isSuccess(sMBPacket, sMB2PacketData)) {
            packetInstance.read(sMB2PacketData);
            return packetInstance;
        }
        packetInstance.readError(sMB2PacketData);
        return packetInstance;
    }
}
