package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ro extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"secunde", "secundă"};
    private static final String[] MINUTES = {"minut", "minute"};
    private static final String[] HOURS = {"ore", "oră"};
    private static final String[] DAYS = {"zi", "zile"};
    private static final String[] WEEKS = {"săptămâni", "săptămână"};
    private static final String[] MONTHS = {"luni", "lună"};
    private static final String[] YEARS = {"an", "ani"};
    private static final ro INSTANCE = new ro();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private ro() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ro getInstance() {
        return INSTANCE;
    }
}
