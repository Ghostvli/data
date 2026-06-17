package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class cs extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"sekundami", "sekundou"};
    private static final String[] MINUTES = {"minutami", "minutou"};
    private static final String[] HOURS = {"hodinami", "hodinou"};
    private static final String[] DAYS = {"dny", "včera"};
    private static final String[] WEEKS = {"týdnem", "týdny"};
    private static final String[] MONTHS = {"měsícem", "měsíci"};
    private static final String[] YEARS = {"rokem", "roky", "lety"};
    private static final cs INSTANCE = new cs();

    private cs() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static cs getInstance() {
        return INSTANCE;
    }
}
