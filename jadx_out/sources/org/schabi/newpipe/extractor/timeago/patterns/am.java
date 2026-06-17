package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class am extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"ሰኮንዶች", "ሴኮንድ"};
    private static final String[] MINUTES = {"ደቂቃ", "ደቂቃዎች"};
    private static final String[] HOURS = {"ሰዓት", "ሰዓቶች"};
    private static final String[] DAYS = {"ቀን", "ቀኖች"};
    private static final String[] WEEKS = {"ሳምንታት", "ሳምንት"};
    private static final String[] MONTHS = {"ወራት", "ወር"};
    private static final String[] YEARS = {"ዓመታት", "ዓመት"};
    private static final am INSTANCE = new am();

    private am() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static am getInstance() {
        return INSTANCE;
    }
}
