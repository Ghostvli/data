package org.jupnp.model.message.header;

import defpackage.fq0;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class MaxAgeHeader extends UpnpHeader<Integer> {
    public static final Pattern MAX_AGE_REGEX = Pattern.compile(".*max-age\\s*=\\s*([0-9]+).*");

    public MaxAgeHeader() {
        setValue(1800);
    }

    @Override // org.jupnp.model.message.header.UpnpHeader
    public String getString() {
        return "max-age=" + getValue().toString();
    }

    @Override // org.jupnp.model.message.header.UpnpHeader
    public void setString(String str) {
        Matcher matcher = MAX_AGE_REGEX.matcher(str.toLowerCase(Locale.ENGLISH));
        if (matcher.matches()) {
            setValue(Integer.valueOf(Integer.parseInt(matcher.group(1))));
        } else {
            fq0.a("Invalid cache-control value, can't parse max-age seconds: ".concat(str));
        }
    }

    public MaxAgeHeader(Integer num) {
        setValue(num);
    }
}
