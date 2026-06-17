package org.jupnp.support.messagebox.model;

import org.jupnp.support.messagebox.model.Message;
import org.jupnp.support.messagebox.parser.MessageElement;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class MessageIncomingCall extends Message {
    private final DateTime callTime;
    private final NumberName callee;
    private final NumberName caller;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public MessageIncomingCall(Message.DisplayType displayType, DateTime dateTime, NumberName numberName, NumberName numberName2) {
        super(Message.Category.INCOMING_CALL, displayType);
        this.callTime = dateTime;
        this.callee = numberName;
        this.caller = numberName2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.support.messagebox.model.ElementAppender
    public void appendMessageElements(MessageElement messageElement) {
        getCallTime().appendMessageElements(messageElement.createChild("CallTime"));
        getCallee().appendMessageElements(messageElement.createChild("Callee"));
        getCaller().appendMessageElements(messageElement.createChild("Caller"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DateTime getCallTime() {
        return this.callTime;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public NumberName getCallee() {
        return this.callee;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public NumberName getCaller() {
        return this.caller;
    }

    public MessageIncomingCall(DateTime dateTime, NumberName numberName, NumberName numberName2) {
        this(Message.DisplayType.MAXIMUM, dateTime, numberName, numberName2);
    }

    public MessageIncomingCall(NumberName numberName, NumberName numberName2) {
        this(new DateTime(), numberName, numberName2);
    }
}
