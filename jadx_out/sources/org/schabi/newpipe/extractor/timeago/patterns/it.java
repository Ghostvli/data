package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class it extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"secondi", "secondo"};
    private static final String[] MINUTES = {"minuti", "minuto"};
    private static final String[] HOURS = {"ora", "ore"};
    private static final String[] DAYS = {"giorni", "giorno"};
    private static final String[] WEEKS = {"settimana", "settimane"};
    private static final String[] MONTHS = {"mese", "mesi"};
    private static final String[] YEARS = {"anni", "anno"};
    private static final it INSTANCE = new it();

    private it() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static it getInstance() {
        return INSTANCE;
    }
}
