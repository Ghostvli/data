package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class mu0 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String a(ac3 ac3Var) {
        int i = ac3Var.f;
        if (i == 1000) {
            return "Unspecified";
        }
        if (i == 2008) {
            return "Read Position Out Of Range";
        }
        if (i == 6000) {
            return "DRM Unspecified";
        }
        if (i == 1003) {
            return "Timeout";
        }
        if (i == 1004) {
            return "Failed Runtime Check";
        }
        if (i == 5001) {
            return "Audio Track Init Failed";
        }
        if (i == 5002) {
            return "Audio Track Write Failed";
        }
        switch (i) {
            case 2000:
                return "IO Unspecified";
            case 2001:
                return "Network Connection Failed";
            case 2002:
                return "Network Connection Timeout";
            case 2003:
                return "Invalid HTTP Content Type";
            case 2004:
                return "Bad HTTP Status";
            default:
                switch (i) {
                    case 3001:
                        return "Container Malformed";
                    case 3002:
                        return "Manifest Malformed";
                    case 3003:
                        return "Container Unsupported";
                    case 3004:
                        return "Manifest Unsupported";
                    default:
                        switch (i) {
                            case 4001:
                                return "Decoder Init Failed";
                            case 4002:
                                return "Decoder Query Failed";
                            case 4003:
                                return "Decoding Failed";
                            case 4004:
                                return "Decoding Format Exceeds Capabilities";
                            case 4005:
                                return "Decoding Format Unsupported";
                            case 4006:
                                return "Decoding Resources Reclaimed";
                            default:
                                switch (i) {
                                    case 6002:
                                        return "DRM Provisioning Failed";
                                    case 6003:
                                        return "DRM Content Error";
                                    case 6004:
                                        return "DRM License Acquisition Failed";
                                    case 6005:
                                        return "DRM Disallowed Operation";
                                    case 6006:
                                        return "DRM System Error";
                                    case 6007:
                                        return "DRM Device Revoked";
                                    case 6008:
                                        return "DRM License Expired";
                                    default:
                                        return ac3Var.f();
                                }
                        }
                }
        }
    }
}
