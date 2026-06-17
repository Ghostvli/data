package org.jupnp.support.messagebox.model;

import org.jupnp.support.messagebox.parser.MessageElement;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class NumberName implements ElementAppender {
    private String name;
    private String number;

    public NumberName(String str, String str2) {
        this.number = str;
        this.name = str2;
    }

    @Override // org.jupnp.support.messagebox.model.ElementAppender
    public void appendMessageElements(MessageElement messageElement) {
        messageElement.createChild("Number").setContent(getNumber());
        messageElement.createChild("Name").setContent(getName());
    }

    public String getName() {
        return this.name;
    }

    public String getNumber() {
        return this.number;
    }
}
