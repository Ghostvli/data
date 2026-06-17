package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class pa extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"ਸਕਿੰਟ"};
    private static final String[] MINUTES = {"ਮਿੰਟ"};
    private static final String[] HOURS = {"ਘੰਟਾ", "ਘੰਟੇ"};
    private static final String[] DAYS = {"ਦਿਨ"};
    private static final String[] WEEKS = {"ਹਫ਼ਤਾ", "ਹਫ਼ਤੇ"};
    private static final String[] MONTHS = {"ਮਹੀਨਾ", "ਮਹੀਨੇ"};
    private static final String[] YEARS = {"ਸਾਲ"};
    private static final pa INSTANCE = new pa();

    private pa() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static pa getInstance() {
        return INSTANCE;
    }
}
