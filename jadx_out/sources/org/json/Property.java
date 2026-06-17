package org.json;

import java.util.Enumeration;
import java.util.Properties;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Property {
    public static JSONObject toJSONObject(Properties properties) {
        JSONObject jSONObject = new JSONObject();
        if (properties != null && !properties.isEmpty()) {
            Enumeration<?> enumerationPropertyNames = properties.propertyNames();
            while (enumerationPropertyNames.hasMoreElements()) {
                String str = (String) enumerationPropertyNames.nextElement();
                jSONObject.put(str, properties.getProperty(str));
            }
        }
        return jSONObject;
    }

    public static Properties toProperties(JSONObject jSONObject) {
        Properties properties = new Properties();
        if (jSONObject != null) {
            for (String str : jSONObject.keySet()) {
                Object objOpt = jSONObject.opt(str);
                if (!JSONObject.NULL.equals(objOpt)) {
                    properties.put(str, objOpt.toString());
                }
            }
        }
        return properties;
    }
}
