package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class sq extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"sekonda", "sekondë"};
    private static final String[] MINUTES = {"minuta", "minutë"};
    private static final String[] HOURS = {"orë"};
    private static final String[] DAYS = {"ditë"};
    private static final String[] WEEKS = {"javë"};
    private static final String[] MONTHS = {"muaj"};
    private static final String[] YEARS = {"vit", "vjet"};
    private static final sq INSTANCE = new sq();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private sq() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static sq getInstance() {
        return INSTANCE;
    }
}
