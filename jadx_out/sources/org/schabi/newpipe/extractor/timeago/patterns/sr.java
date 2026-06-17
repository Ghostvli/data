package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class sr extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"секунде", "секунди"};
    private static final String[] MINUTES = {"минута"};
    private static final String[] HOURS = {"сат", "сата", "сати"};
    private static final String[] DAYS = {"Пре 1 дан", "Пре 2 дана", "Пре 3 дана", "Пре 4 дана", "Пре 5 дана", "Пре 6 дана"};
    private static final String[] WEEKS = {"недеље", "недељу"};
    private static final String[] MONTHS = {"месец", "месеца", "месеци"};
    private static final String[] YEARS = {"година", "године", "годину"};
    private static final sr INSTANCE = new sr();

    private sr() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static sr getInstance() {
        return INSTANCE;
    }
}
