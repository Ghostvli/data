package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class bs extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"sekundi", "sekunde", "sekundu"};
    private static final String[] MINUTES = {"minuta", "minute", "minutu"};
    private static final String[] HOURS = {"h", "sat", "sata", "sati"};
    private static final String[] DAYS = {"dan", "dana"};
    private static final String[] WEEKS = {"sedm."};
    private static final String[] MONTHS = {"mj.", "mjesec", "mjeseca", "mjeseci"};
    private static final String[] YEARS = {"godina", "godine", "godinu"};
    private static final bs INSTANCE = new bs();

    private bs() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static bs getInstance() {
        return INSTANCE;
    }
}
