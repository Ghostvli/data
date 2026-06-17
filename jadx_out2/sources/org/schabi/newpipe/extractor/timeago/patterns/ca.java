package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ca extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"segon", "segons"};
    private static final String[] MINUTES = {"minut", "minuts"};
    private static final String[] HOURS = {"hora", "hores"};
    private static final String[] DAYS = {"dia", "dies"};
    private static final String[] WEEKS = {"setmana", "setmanes"};
    private static final String[] MONTHS = {"mes", "mesos"};
    private static final String[] YEARS = {"any", "anys"};
    private static final ca INSTANCE = new ca();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private ca() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ca getInstance() {
        return INSTANCE;
    }
}
