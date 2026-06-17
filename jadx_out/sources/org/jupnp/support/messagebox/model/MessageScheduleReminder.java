package org.jupnp.support.messagebox.model;

import org.jupnp.support.messagebox.model.Message;
import org.jupnp.support.messagebox.parser.MessageElement;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class MessageScheduleReminder extends Message {
    private final String body;
    private final DateTime endTime;
    private final String location;
    private final NumberName owner;
    private final DateTime startTime;
    private final String subject;

    public MessageScheduleReminder(Message.DisplayType displayType, DateTime dateTime, NumberName numberName, String str, DateTime dateTime2, String str2, String str3) {
        super(Message.Category.SCHEDULE_REMINDER, displayType);
        this.startTime = dateTime;
        this.owner = numberName;
        this.subject = str;
        this.endTime = dateTime2;
        this.location = str2;
        this.body = str3;
    }

    @Override // org.jupnp.support.messagebox.model.ElementAppender
    public void appendMessageElements(MessageElement messageElement) {
        getStartTime().appendMessageElements(messageElement.createChild("StartTime"));
        getOwner().appendMessageElements(messageElement.createChild("Owner"));
        messageElement.createChild("Subject").setContent(getSubject());
        getEndTime().appendMessageElements(messageElement.createChild("EndTime"));
        messageElement.createChild("Location").setContent(getLocation());
        messageElement.createChild("Body").setContent(getBody());
    }

    public String getBody() {
        return this.body;
    }

    public DateTime getEndTime() {
        return this.endTime;
    }

    public String getLocation() {
        return this.location;
    }

    public NumberName getOwner() {
        return this.owner;
    }

    public DateTime getStartTime() {
        return this.startTime;
    }

    public String getSubject() {
        return this.subject;
    }

    public MessageScheduleReminder(DateTime dateTime, NumberName numberName, String str, DateTime dateTime2, String str2, String str3) {
        this(Message.DisplayType.MAXIMUM, dateTime, numberName, str, dateTime2, str2, str3);
    }
}
