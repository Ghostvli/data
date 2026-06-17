package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class az extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"saniyə"};
    private static final String[] MINUTES = {"dəqiqə"};
    private static final String[] HOURS = {"saat"};
    private static final String[] DAYS = {"gün"};
    private static final String[] WEEKS = {"həftə"};
    private static final String[] MONTHS = {"ay"};
    private static final String[] YEARS = {"il"};
    private static final az INSTANCE = new az();

    private az() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static az getInstance() {
        return INSTANCE;
    }
}
