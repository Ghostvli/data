package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class my extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"စက္ကန့်"};
    private static final String[] MINUTES = {"မိနစ်"};
    private static final String[] HOURS = {"နာရီ"};
    private static final String[] DAYS = {"ရက်"};
    private static final String[] WEEKS = {"ပတ်"};
    private static final String[] MONTHS = {"လ"};
    private static final String[] YEARS = {"နှစ်"};
    private static final my INSTANCE = new my();

    private my() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static my getInstance() {
        return INSTANCE;
    }
}
