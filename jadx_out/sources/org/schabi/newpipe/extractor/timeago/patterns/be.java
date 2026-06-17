package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class be extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"секунд", "секунду", "секунды"};
    private static final String[] MINUTES = {"хвілін", "хвіліну", "хвіліны"};
    private static final String[] HOURS = {"гадзін", "гадзіну", "гадзіны"};
    private static final String[] DAYS = {"дзень", "дзён", "дня", "дні"};
    private static final String[] WEEKS = {"тыдзень", "тыдня", "тыдні"};
    private static final String[] MONTHS = {"месяц", "месяца", "месяцы", "месяцаў"};
    private static final String[] YEARS = {"год", "года", "гады", "гадоў"};
    private static final be INSTANCE = new be();

    private be() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static be getInstance() {
        return INSTANCE;
    }
}
