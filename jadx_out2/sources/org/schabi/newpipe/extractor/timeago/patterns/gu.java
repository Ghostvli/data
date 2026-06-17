package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class gu extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"સેકંડ"};
    private static final String[] MINUTES = {"મિનિટ"};
    private static final String[] HOURS = {"કલાક"};
    private static final String[] DAYS = {"દિવસ"};
    private static final String[] WEEKS = {"અઠવાડિયા"};
    private static final String[] MONTHS = {"મહિના"};
    private static final String[] YEARS = {"વર્ષ"};
    private static final gu INSTANCE = new gu();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private gu() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static gu getInstance() {
        return INSTANCE;
    }
}
