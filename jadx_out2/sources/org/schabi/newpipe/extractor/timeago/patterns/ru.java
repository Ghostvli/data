package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ru extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"секунд", "секунду", "секунды", "только что"};
    private static final String[] MINUTES = {"минут", "минуту", "минуты"};
    private static final String[] HOURS = {"час", "часа", "часов"};
    private static final String[] DAYS = {"день", "дней", "дня"};
    private static final String[] WEEKS = {"Неделю", "недели"};
    private static final String[] MONTHS = {"месяц", "месяца", "месяцев"};
    private static final String[] YEARS = {"Год", "года", "лет"};
    private static final ru INSTANCE = new ru();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private ru() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ru getInstance() {
        return INSTANCE;
    }
}
