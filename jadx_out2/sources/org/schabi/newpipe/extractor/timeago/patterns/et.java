package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class et extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"sekund", "sekundit"};
    private static final String[] MINUTES = {"minut", "minutit"};
    private static final String[] HOURS = {"tund", "tundi"};
    private static final String[] DAYS = {"päev", "päeva"};
    private static final String[] WEEKS = {"nädal", "nädalat"};
    private static final String[] MONTHS = {"kuu", "kuud"};
    private static final String[] YEARS = {"aasta", "aastat"};
    private static final et INSTANCE = new et();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private et() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static et getInstance() {
        return INSTANCE;
    }
}
