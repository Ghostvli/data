package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class uz extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"soniya"};
    private static final String[] MINUTES = {"daqiqa"};
    private static final String[] HOURS = {"soat"};
    private static final String[] DAYS = {"kun"};
    private static final String[] WEEKS = {"hafta"};
    private static final String[] MONTHS = {"oy"};
    private static final String[] YEARS = {"yil"};
    private static final uz INSTANCE = new uz();

    private uz() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static uz getInstance() {
        return INSTANCE;
    }
}
