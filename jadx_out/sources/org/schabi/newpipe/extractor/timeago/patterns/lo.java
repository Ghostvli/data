package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class lo extends t93 {
    private static final String WORD_SEPARATOR = "";
    private static final String[] SECONDS = {"ວິນາທີກ່ອນນີ້"};
    private static final String[] MINUTES = {"ນາທີກ່ອນນີ້", "ນາ\u200bທີ\u200bກ່ອນ\u200bນີ້"};
    private static final String[] HOURS = {"ຊົ່ວ\u200bໂມງ\u200bກ່ອນ\u200bນີ້"};
    private static final String[] DAYS = {"ມື້ກ່ອນນີ້"};
    private static final String[] WEEKS = {"ອາ\u200bທິດ\u200bກ່ອນ\u200bນີ້"};
    private static final String[] MONTHS = {"ເດືອນ\u200bກ່ອນ\u200bນີ້"};
    private static final String[] YEARS = {"ປີ\u200bກ່ອນ\u200bນີ້"};
    private static final lo INSTANCE = new lo();

    private lo() {
        super("", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static lo getInstance() {
        return INSTANCE;
    }
}
