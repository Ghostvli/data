package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class th extends t93 {
    private static final String WORD_SEPARATOR = "";
    private static final String[] SECONDS = {"วินาทีที่ผ่านมา"};
    private static final String[] MINUTES = {"นาทีที่ผ่านมา"};
    private static final String[] HOURS = {"ชั่วโมงที่ผ่านมา"};
    private static final String[] DAYS = {"วันที่ผ่านมา"};
    private static final String[] WEEKS = {"สัปดาห์ที่ผ่านมา"};
    private static final String[] MONTHS = {"เดือนที่ผ่านมา"};
    private static final String[] YEARS = {"ปีที่ผ่านมา"};
    private static final th INSTANCE = new th();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private th() {
        super("", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static th getInstance() {
        return INSTANCE;
    }
}
