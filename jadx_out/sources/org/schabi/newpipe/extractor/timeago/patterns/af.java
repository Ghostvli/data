package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class af extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"sekonde", "sekondes"};
    private static final String[] MINUTES = {"minute", "minuut"};
    private static final String[] HOURS = {"ure", "uur"};
    private static final String[] DAYS = {"dae", "dag"};
    private static final String[] WEEKS = {"week", "weke"};
    private static final String[] MONTHS = {"maand", "maande"};
    private static final String[] YEARS = {"jaar"};
    private static final af INSTANCE = new af();

    private af() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static af getInstance() {
        return INSTANCE;
    }
}
