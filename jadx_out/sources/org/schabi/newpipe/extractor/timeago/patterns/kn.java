package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class kn extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"ಸೆಕೆಂಡುಗಳ", "ಸೆಕೆಂಡ್"};
    private static final String[] MINUTES = {"ನಿಮಿಷಗಳ", "ನಿಮಿಷದ"};
    private static final String[] HOURS = {"ಗಂಟೆಗಳ", "ಗಂಟೆಯ"};
    private static final String[] DAYS = {"ದಿನಗಳ", "ದಿನದ"};
    private static final String[] WEEKS = {"ವಾರಗಳ", "ವಾರದ"};
    private static final String[] MONTHS = {"ತಿಂಗಳ", "ತಿಂಗಳುಗಳ"};
    private static final String[] YEARS = {"ವರ್ಷಗಳ", "ವರ್ಷದ"};
    private static final kn INSTANCE = new kn();

    private kn() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static kn getInstance() {
        return INSTANCE;
    }
}
