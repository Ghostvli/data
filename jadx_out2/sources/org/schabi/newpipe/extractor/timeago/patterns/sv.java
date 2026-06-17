package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class sv extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"sekund", "sekunder"};
    private static final String[] MINUTES = {"minut", "minuter"};
    private static final String[] HOURS = {"timmar", "timme"};
    private static final String[] DAYS = {"dag", "dagar"};
    private static final String[] WEEKS = {"vecka", "veckor"};
    private static final String[] MONTHS = {"månad", "månader"};
    private static final String[] YEARS = {"år"};
    private static final sv INSTANCE = new sv();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private sv() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static sv getInstance() {
        return INSTANCE;
    }
}
