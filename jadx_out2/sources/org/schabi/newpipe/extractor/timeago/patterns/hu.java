package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class hu extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"másodperce"};
    private static final String[] MINUTES = {"perce"};
    private static final String[] HOURS = {"órája"};
    private static final String[] DAYS = {"napja"};
    private static final String[] WEEKS = {"hete"};
    private static final String[] MONTHS = {"hónapja"};
    private static final String[] YEARS = {"éve"};
    private static final hu INSTANCE = new hu();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private hu() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static hu getInstance() {
        return INSTANCE;
    }
}
