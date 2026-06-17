package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class te extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"సెకను", "సెకన్ల"};
    private static final String[] MINUTES = {"నిమిషం", "నిమిషాల"};
    private static final String[] HOURS = {"గంట", "గంటల"};
    private static final String[] DAYS = {"రోజు", "రోజుల"};
    private static final String[] WEEKS = {"వారం", "వారాల"};
    private static final String[] MONTHS = {"నెల", "నెలల"};
    private static final String[] YEARS = {"సంవత్సరం", "సంవత్సరాల"};
    private static final te INSTANCE = new te();

    private te() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static te getInstance() {
        return INSTANCE;
    }
}
