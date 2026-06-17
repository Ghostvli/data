package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ta extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"வினாடி", "வினாடிகளுக்கு"};
    private static final String[] MINUTES = {"நிமிடங்கள்", "நிமிடம்"};
    private static final String[] HOURS = {"மணிநேரத்திற்கு"};
    private static final String[] DAYS = {"நாட்களுக்கு", "நாளுக்கு"};
    private static final String[] WEEKS = {"வாரங்களுக்கு", "வாரம்"};
    private static final String[] MONTHS = {"மாதங்கள்", "மாதம்"};
    private static final String[] YEARS = {"ஆண்டு", "ஆண்டுகளுக்கு"};
    private static final ta INSTANCE = new ta();

    private ta() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static ta getInstance() {
        return INSTANCE;
    }
}
