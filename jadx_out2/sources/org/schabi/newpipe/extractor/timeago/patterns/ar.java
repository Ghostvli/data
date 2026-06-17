package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ar extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"ثانية", "ثانيتين", "ثوانٍ"};
    private static final String[] MINUTES = {"دقائق", "دقيقة", "دقيقتين"};
    private static final String[] HOURS = {"ساعات", "ساعة", "ساعتين"};
    private static final String[] DAYS = {"أيام", "يوم", "يومين"};
    private static final String[] WEEKS = {"أسابيع", "أسبوع", "أسبوعين"};
    private static final String[] MONTHS = {"أشهر", "شهر", "شهرين", "شهرًا"};
    private static final String[] YEARS = {"سنة", "سنتين", "سنوات"};
    private static final ar INSTANCE = new ar();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private ar() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ar getInstance() {
        return INSTANCE;
    }
}
