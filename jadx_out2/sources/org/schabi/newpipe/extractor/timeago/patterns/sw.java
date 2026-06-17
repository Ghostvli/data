package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class sw extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"sekunde"};
    private static final String[] MINUTES = {"dakika"};
    private static final String[] HOURS = {"saa"};
    private static final String[] DAYS = {"siku"};
    private static final String[] WEEKS = {"wiki"};
    private static final String[] MONTHS = {"Mwezi", "miezi"};
    private static final String[] YEARS = {"Miaka", "Mwaka"};
    private static final sw INSTANCE = new sw();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private sw() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static sw getInstance() {
        return INSTANCE;
    }
}
