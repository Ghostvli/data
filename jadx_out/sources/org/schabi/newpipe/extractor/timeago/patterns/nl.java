package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class nl extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"seconde", "seconden"};
    private static final String[] MINUTES = {"minuten", "minuut"};
    private static final String[] HOURS = {"uur"};
    private static final String[] DAYS = {"dag", "dagen"};
    private static final String[] WEEKS = {"week", "weken"};
    private static final String[] MONTHS = {"maand", "maanden"};
    private static final String[] YEARS = {"jaar"};
    private static final nl INSTANCE = new nl();

    private nl() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static nl getInstance() {
        return INSTANCE;
    }
}
