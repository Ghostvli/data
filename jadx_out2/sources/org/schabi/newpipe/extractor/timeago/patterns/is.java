package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class is extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"sekúndu", "sekúndum", "second", "seconds"};
    private static final String[] MINUTES = {"mínútu", "mínútum", "minute", "minutes"};
    private static final String[] HOURS = {"klukkustund", "klukkustundum", "hour", "hours"};
    private static final String[] DAYS = {"degi", "dögum", "day", "days"};
    private static final String[] WEEKS = {"viku", "vikum", "week", "weeks"};
    private static final String[] MONTHS = {"mánuði", "mánuðum"};
    private static final String[] YEARS = {"ári", "árum"};
    private static final is INSTANCE = new is();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private is() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static is getInstance() {
        return INSTANCE;
    }
}
