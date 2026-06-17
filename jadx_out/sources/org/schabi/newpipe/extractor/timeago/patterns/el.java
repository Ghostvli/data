package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class el extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"δευτερόλεπτα", "δευτερόλεπτο"};
    private static final String[] MINUTES = {"λεπτά", "λεπτό"};
    private static final String[] HOURS = {"ώρα", "ώρες"};
    private static final String[] DAYS = {"ημέρα", "ημέρες"};
    private static final String[] WEEKS = {"εβδομάδα", "εβδομάδες"};
    private static final String[] MONTHS = {"μήνα", "μήνες"};
    private static final String[] YEARS = {"χρόνια", "χρόνο"};
    private static final el INSTANCE = new el();

    private el() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static el getInstance() {
        return INSTANCE;
    }
}
