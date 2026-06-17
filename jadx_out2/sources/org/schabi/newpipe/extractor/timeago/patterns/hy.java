package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class hy extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"վայրկյան"};
    private static final String[] MINUTES = {"րոպե"};
    private static final String[] HOURS = {"ժամ"};
    private static final String[] DAYS = {"օր"};
    private static final String[] WEEKS = {"շաբաթ"};
    private static final String[] MONTHS = {"ամիս"};
    private static final String[] YEARS = {"տարի"};
    private static final hy INSTANCE = new hy();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private hy() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static hy getInstance() {
        return INSTANCE;
    }
}
