package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class eu extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"segundo"};
    private static final String[] MINUTES = {"minutu"};
    private static final String[] HOURS = {"ordu", "ordubete"};
    private static final String[] DAYS = {"egun"};
    private static final String[] WEEKS = {"aste", "astebete"};
    private static final String[] MONTHS = {"hilabete"};
    private static final String[] YEARS = {"urte", "urtebete"};
    private static final eu INSTANCE = new eu();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private eu() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static eu getInstance() {
        return INSTANCE;
    }
}
