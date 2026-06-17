package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class de extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"Sekunde", "Sekunden"};
    private static final String[] MINUTES = {"Minute", "Minuten"};
    private static final String[] HOURS = {"Stunde", "Stunden"};
    private static final String[] DAYS = {"Tag", "Tagen"};
    private static final String[] WEEKS = {"Woche", "Wochen"};
    private static final String[] MONTHS = {"Monat", "Monaten"};
    private static final String[] YEARS = {"Jahr", "Jahren"};
    private static final de INSTANCE = new de();

    private de() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static de getInstance() {
        return INSTANCE;
    }
}
