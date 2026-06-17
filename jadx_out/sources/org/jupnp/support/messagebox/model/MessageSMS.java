package org.jupnp.support.messagebox.model;

import org.jupnp.support.messagebox.model.Message;
import org.jupnp.support.messagebox.parser.MessageElement;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class MessageSMS extends Message {
    private final String body;
    private final DateTime receiveTime;
    private final NumberName receiver;
    private final NumberName sender;

    public MessageSMS(Message.DisplayType displayType, DateTime dateTime, NumberName numberName, NumberName numberName2, String str) {
        super(Message.Category.SMS, displayType);
        this.receiveTime = dateTime;
        this.receiver = numberName;
        this.sender = numberName2;
        this.body = str;
    }

    @Override // org.jupnp.support.messagebox.model.ElementAppender
    public void appendMessageElements(MessageElement messageElement) {
        getReceiveTime().appendMessageElements(messageElement.createChild("ReceiveTime"));
        getReceiver().appendMessageElements(messageElement.createChild("Receiver"));
        getSender().appendMessageElements(messageElement.createChild("Sender"));
        messageElement.createChild("Body").setContent(getBody());
    }

    public String getBody() {
        return this.body;
    }

    public DateTime getReceiveTime() {
        return this.receiveTime;
    }

    public NumberName getReceiver() {
        return this.receiver;
    }

    public NumberName getSender() {
        return this.sender;
    }

    public MessageSMS(DateTime dateTime, NumberName numberName, NumberName numberName2, String str) {
        this(Message.DisplayType.MAXIMUM, dateTime, numberName, numberName2, str);
    }

    public MessageSMS(NumberName numberName, NumberName numberName2, String str) {
        this(new DateTime(), numberName, numberName2, str);
    }
}
