package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class uk extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"секунд", "секунди", "секунду"};
    private static final String[] MINUTES = {"хвилин", "хвилини", "хвилину"};
    private static final String[] HOURS = {"годин", "години", "годину"};
    private static final String[] DAYS = {"день", "дні", "днів"};
    private static final String[] WEEKS = {"тиждень", "тижні"};
    private static final String[] MONTHS = {"місяць", "місяці", "місяців"};
    private static final String[] YEARS = {"роки", "років", "рік"};
    private static final uk INSTANCE = new uk();

    private uk() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static uk getInstance() {
        return INSTANCE;
    }
}
