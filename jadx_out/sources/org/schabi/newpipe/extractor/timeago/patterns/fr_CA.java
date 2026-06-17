package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class fr_CA extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"seconde", "secondes"};
    private static final String[] MINUTES = {"minute", "minutes"};
    private static final String[] HOURS = {"heures", "heure"};
    private static final String[] DAYS = {"jour", "jours"};
    private static final String[] WEEKS = {"semaine", "semaines"};
    private static final String[] MONTHS = {"mois"};
    private static final String[] YEARS = {"an", "ans"};
    private static final fr_CA INSTANCE = new fr_CA();

    private fr_CA() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static fr_CA getInstance() {
        return INSTANCE;
    }
}
