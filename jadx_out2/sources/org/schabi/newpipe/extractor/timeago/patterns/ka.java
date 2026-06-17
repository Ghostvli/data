package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ka extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"წამის"};
    private static final String[] MINUTES = {"წუთის"};
    private static final String[] HOURS = {"საათის"};
    private static final String[] DAYS = {"დღის"};
    private static final String[] WEEKS = {"კვირის"};
    private static final String[] MONTHS = {"თვის"};
    private static final String[] YEARS = {"წლის"};
    private static final ka INSTANCE = new ka();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private ka() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ka getInstance() {
        return INSTANCE;
    }
}
