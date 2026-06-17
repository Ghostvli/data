package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class zu extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"amasekhondi", "isekhondi"};
    private static final String[] MINUTES = {"amaminithi", "iminithi"};
    private static final String[] HOURS = {"amahora", "ihora"};
    private static final String[] DAYS = {"izinsuku", "usuku"};
    private static final String[] WEEKS = {"amaviki", "iviki"};
    private static final String[] MONTHS = {"inyanga", "izinyanga"};
    private static final String[] YEARS = {"iminyaka", "unyaka"};
    private static final zu INSTANCE = new zu();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private zu() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static zu getInstance() {
        return INSTANCE;
    }
}
