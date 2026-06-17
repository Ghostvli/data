package org.jupnp.support.model;

import org.w3c.dom.Element;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class PersonWithRole extends Person {
    private String role;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PersonWithRole(String str, String str2) {
        super(str);
        this.role = str2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getRole() {
        return this.role;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setOnElement(Element element) {
        element.setTextContent(toString());
        if (getRole() != null) {
            element.setAttribute("role", getRole());
        }
    }

    public PersonWithRole(String str) {
        super(str);
    }
}
