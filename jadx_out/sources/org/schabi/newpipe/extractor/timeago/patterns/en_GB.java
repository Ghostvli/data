package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;
import org.jupnp.binding.xml.Descriptor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class en_GB extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"second", "seconds", Descriptor.Device.SEC_PREFIX};
    private static final String[] MINUTES = {"minute", "minutes", "min"};
    private static final String[] HOURS = {"hour", "hours", "hr"};
    private static final String[] DAYS = {"day", "days"};
    private static final String[] WEEKS = {"week", "weeks", "wk"};
    private static final String[] MONTHS = {"month", "months", "mo"};
    private static final String[] YEARS = {"year", "years", "yr"};
    private static final en_GB INSTANCE = new en_GB();

    private en_GB() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static en_GB getInstance() {
        return INSTANCE;
    }
}
