package com.fongmi.android.tv.bean;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
@Root(name = "tv", strict = false)
public class Tv {

    @ElementList(entry = "channel", inline = true, required = false)
    private List<Channel> channel;

    @Attribute(name = "date", required = false)
    private String date;

    @ElementList(entry = "programme", inline = true, required = false)
    private List<Programme> programme;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    @Root(name = "channel")
    public static class Channel {

        @ElementList(entry = "display-name", inline = true, required = false)
        private List<DisplayName> displayName;

        @Element(name = "icon", required = false)
        private Icon icon;

        @Attribute(name = Name.MARK, required = false)
        private String id;

        private Icon getIcon() {
            Icon icon = this.icon;
            return icon == null ? new Icon() : icon;
        }

        public List<DisplayName> getDisplayName() {
            List<DisplayName> list = this.displayName;
            return list == null ? new ArrayList() : list;
        }

        public String getId() {
            return TextUtils.isEmpty(this.id) ? "" : this.id;
        }

        public String getSrc() {
            return getIcon().getSrc();
        }

        public boolean hasSrc() {
            return !getIcon().getSrc().isEmpty();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    @Root(name = "display-name")
    public static class DisplayName {

        @Text
        private String text;

        public String getText() {
            return TextUtils.isEmpty(this.text) ? "" : this.text;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    @Root(name = "icon")
    public static class Icon {

        @Attribute(name = "src")
        private String src;

        public String getSrc() {
            return TextUtils.isEmpty(this.src) ? "" : this.src;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    @Root(name = "programme")
    public static class Programme {

        @Attribute(name = "channel", required = false)
        private String channel;

        @Attribute(name = "start", required = false)
        private String start;

        @Attribute(name = "stop", required = false)
        private String stop;

        @Element(name = "title", required = false)
        private String title;

        public String getChannel() {
            return TextUtils.isEmpty(this.channel) ? "" : this.channel;
        }

        public String getStart() {
            return TextUtils.isEmpty(this.start) ? "" : this.start;
        }

        public String getStop() {
            return TextUtils.isEmpty(this.stop) ? "" : this.stop;
        }

        public String getTitle() {
            return TextUtils.isEmpty(this.title) ? "" : this.title;
        }
    }

    public List<Channel> getChannel() {
        List<Channel> list = this.channel;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public String getDate() {
        return TextUtils.isEmpty(this.date) ? "" : this.date;
    }

    public List<Programme> getProgramme() {
        List<Programme> list = this.programme;
        return list == null ? Collections.EMPTY_LIST : list;
    }
}
