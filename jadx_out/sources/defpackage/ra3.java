package defpackage;

import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ra3 {
    public static final Set a = o24.f("android.permission.ACCESS_BACKGROUND_LOCATION", "android.permission.SYSTEM_ALERT_WINDOW", "android.permission.WRITE_SETTINGS", "android.permission.MANAGE_EXTERNAL_STORAGE", "android.permission.REQUEST_INSTALL_PACKAGES", "android.permission.POST_NOTIFICATIONS", "android.permission.BODY_SENSORS_BACKGROUND");
    public static final Map b;
    public static final Map c;
    public static final Map d;
    public static final Map e;

    static {
        Map mapJ = y42.j(fu4.a("android.permission.READ_CALENDAR", "android.permission-group.CALENDAR"), fu4.a("android.permission.WRITE_CALENDAR", "android.permission-group.CALENDAR"), fu4.a("android.permission.READ_CALL_LOG", "android.permission-group.CALL_LOG"), fu4.a("android.permission.WRITE_CALL_LOG", "android.permission-group.CALL_LOG"), fu4.a("android.permission.PROCESS_OUTGOING_CALLS", "android.permission-group.CALL_LOG"), fu4.a("android.permission.CAMERA", "android.permission-group.CAMERA"), fu4.a("android.permission.READ_CONTACTS", "android.permission-group.CONTACTS"), fu4.a("android.permission.WRITE_CONTACTS", "android.permission-group.CONTACTS"), fu4.a("android.permission.GET_ACCOUNTS", "android.permission-group.CONTACTS"), fu4.a("android.permission.ACCESS_FINE_LOCATION", "android.permission-group.LOCATION"), fu4.a("android.permission.ACCESS_COARSE_LOCATION", "android.permission-group.LOCATION"), fu4.a("android.permission.ACCESS_BACKGROUND_LOCATION", "android.permission-group.LOCATION"), fu4.a("android.permission.RECORD_AUDIO", "android.permission-group.MICROPHONE"), fu4.a("android.permission.READ_PHONE_STATE", "android.permission-group.PHONE"), fu4.a("android.permission.READ_PHONE_NUMBERS", "android.permission-group.PHONE"), fu4.a("android.permission.CALL_PHONE", "android.permission-group.PHONE"), fu4.a("android.permission.ANSWER_PHONE_CALLS", "android.permission-group.PHONE"), fu4.a("com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission-group.PHONE"), fu4.a("android.permission.USE_SIP", "android.permission-group.PHONE"), fu4.a("android.permission.ACCEPT_HANDOVER", "android.permission-group.PHONE"), fu4.a("android.permission.BODY_SENSORS", "android.permission-group.SENSORS"), fu4.a("android.permission.ACTIVITY_RECOGNITION", "android.permission-group.ACTIVITY_RECOGNITION"), fu4.a("android.permission.SEND_SMS", "android.permission-group.SMS"), fu4.a("android.permission.RECEIVE_SMS", "android.permission-group.SMS"), fu4.a("android.permission.READ_SMS", "android.permission-group.SMS"), fu4.a("android.permission.RECEIVE_WAP_PUSH", "android.permission-group.SMS"), fu4.a("android.permission.RECEIVE_MMS", "android.permission-group.SMS"), fu4.a("android.permission.READ_EXTERNAL_STORAGE", "android.permission-group.STORAGE"), fu4.a("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission-group.STORAGE"), fu4.a("android.permission.ACCESS_MEDIA_LOCATION", "android.permission-group.STORAGE"));
        b = mapJ;
        Map mapS = y42.s(x42.f(fu4.a("android.permission.MANAGE_EXTERNAL_STORAGE", "android.permission-group.STORAGE")));
        mapS.putAll(mapJ);
        Map mapQ = y42.q(mapS);
        c = mapQ;
        Map mapS2 = y42.s(y42.j(fu4.a("android.permission.BLUETOOTH_SCAN", "android.permission-group.NEARBY_DEVICES"), fu4.a("android.permission.BLUETOOTH_ADVERTISE", "android.permission-group.NEARBY_DEVICES"), fu4.a("android.permission.BLUETOOTH_CONNECT", "android.permission-group.NEARBY_DEVICES")));
        mapS2.putAll(mapQ);
        Map mapQ2 = y42.q(mapS2);
        d = mapQ2;
        Map mapS3 = y42.s(y42.j(fu4.a("android.permission.READ_MEDIA_IMAGES", "android.permission-group.READ_MEDIA_VISUAL"), fu4.a("android.permission.READ_MEDIA_VIDEO", "android.permission-group.READ_MEDIA_VISUAL"), fu4.a("android.permission.READ_MEDIA_AUDIO", "android.permission-group.READ_MEDIA_AURAL"), fu4.a("android.permission.POST_NOTIFICATIONS", "android.permission-group.NOTIFICATIONS"), fu4.a("android.permission.NEARBY_WIFI_DEVICES", "android.permission-group.NEARBY_DEVICES"), fu4.a("android.permission.BODY_SENSORS_BACKGROUND", "android.permission-group.SENSORS")));
        mapS3.putAll(mapQ2);
        e = y42.q(mapS3);
    }

    public static final Set a() {
        return a;
    }
}
