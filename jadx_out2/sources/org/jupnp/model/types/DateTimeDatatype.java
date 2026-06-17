package org.jupnp.model.types;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DateTimeDatatype extends AbstractDatatype<Calendar> {
    protected String[] readFormats;
    protected String writeFormat;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DateTimeDatatype(String[] strArr, String str) {
        this.readFormats = strArr;
        this.writeFormat = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Date getDateValue(String str, String[] strArr) {
        String strNormalizeTimeZone = normalizeTimeZone(str);
        Date date = null;
        for (String str2 : strArr) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
            simpleDateFormat.setTimeZone(getTimeZone());
            try {
                date = simpleDateFormat.parse(strNormalizeTimeZone);
            } catch (ParseException unused) {
            }
        }
        return date;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: getString(Ljava/lang/Object;)Ljava/lang/String; */
    @Override // org.jupnp.model.types.AbstractDatatype, org.jupnp.model.types.Datatype
    public String getString(Calendar calendar) {
        if (calendar == null) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.writeFormat);
        simpleDateFormat.setTimeZone(getTimeZone());
        return simpleDateFormat.format(calendar.getTime());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public TimeZone getTimeZone() {
        return TimeZone.getDefault();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String normalizeTimeZone(String str) {
        return str.endsWith("Z") ? str.substring(0, str.length() - 1).concat("+0000") : (str.length() > 7 && str.charAt(str.length() + (-3)) == ':' && (str.charAt(str.length() + (-6)) == '-' || str.charAt(str.length() + (-6)) == '+')) ? str.substring(0, str.length() - 3).concat(str.substring(str.length() - 2)) : str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: valueOf(Ljava/lang/String;)Ljava/lang/Object; */
    @Override // org.jupnp.model.types.AbstractDatatype, org.jupnp.model.types.Datatype
    public Calendar valueOf(String str) {
        if (str.isEmpty()) {
            return null;
        }
        Date dateValue = getDateValue(str, this.readFormats);
        if (dateValue == null) {
            throw new InvalidValueException("Can't parse date/time from: ".concat(str));
        }
        Calendar calendar = Calendar.getInstance(getTimeZone());
        calendar.setTime(dateValue);
        return calendar;
    }
}
