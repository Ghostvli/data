package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;
import j$.time.temporal.ChronoUnit;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class iw extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"שניות", "שנייה"};
    private static final String[] MINUTES = {"דקה", "דקות"};
    private static final String[] HOURS = {"שעה", "שעות"};
    private static final String[] DAYS = {"יום", "ימים"};
    private static final String[] WEEKS = {"שבוע", "שבועות"};
    private static final String[] MONTHS = {"חודש", "חודשים"};
    private static final String[] YEARS = {"שנה", "שנים"};
    private static final iw INSTANCE = new iw();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private iw() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
        putSpecialCase(ChronoUnit.HOURS, "שעתיים", 2);
        putSpecialCase(ChronoUnit.DAYS, "יומיים", 2);
        putSpecialCase(ChronoUnit.WEEKS, "שבועיים", 2);
        putSpecialCase(ChronoUnit.MONTHS, "חודשיים", 2);
        putSpecialCase(ChronoUnit.YEARS, "שנתיים", 2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static iw getInstance() {
        return INSTANCE;
    }
}
