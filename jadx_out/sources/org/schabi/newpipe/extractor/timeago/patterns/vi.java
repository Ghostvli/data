package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class vi extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"giây"};
    private static final String[] MINUTES = {"phút"};
    private static final String[] HOURS = {"giờ", "tiếng"};
    private static final String[] DAYS = {"ngày"};
    private static final String[] WEEKS = {"tuần"};
    private static final String[] MONTHS = {"tháng"};
    private static final String[] YEARS = {"năm"};
    private static final vi INSTANCE = new vi();

    private vi() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static vi getInstance() {
        return INSTANCE;
    }
}
