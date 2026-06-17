package com.fongmi.android.tv.bean;

import android.text.TextUtils;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.bean.Channel;
import com.github.catvod.utils.Trans;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import defpackage.sm3;
import defpackage.vr3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Group {

    @SerializedName("channel")
    private List<Channel> channel;

    @SerializedName("name")
    private String name;

    @SerializedName("pass")
    private String pass;
    private int position;
    private boolean selected;
    private int width;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Group(String str, boolean z) {
        this.name = str;
        this.position = -1;
        if (str.contains("_")) {
            parse(z);
        }
        if (str.isEmpty()) {
            setName(vr3.l(sm3.t0));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List<Group> arrayFrom(String str) {
        List<Group> list = (List) App.c().fromJson(str, new TypeToken<List<Group>>() { // from class: com.fongmi.android.tv.bean.Group.1
        }.getType());
        return list == null ? Collections.EMPTY_LIST : list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Group create(int i) {
        return new Group(vr3.l(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void parse(boolean z) {
        String[] strArrSplit = this.name.split("_", 2);
        setName(strArrSplit[0]);
        if (z || strArrSplit.length == 1) {
            return;
        }
        setPass(strArrSplit[1]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void add(final Channel channel) {
        Channel channelOrElse = getChannel().stream().filter(new Predicate() { // from class: jb1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((Channel) obj).equals(channel);
            }
        }).findFirst().orElse(null);
        if (channelOrElse != null) {
            channelOrElse.getUrls().addAll(channel.getUrls());
        } else {
            getChannel().add(Channel.create(channel));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Channel current() {
        return getChannel().get(getPosition()).group(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Group) {
            Group group = (Group) obj;
            if (getName().equals(group.getName()) && getChannel().size() == group.getChannel().size()) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Channel find(final Channel channel) {
        Channel channelOrElse = getChannel().stream().filter(new Predicate() { // from class: kb1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((Channel) obj).equals(channel);
            }
        }).findFirst().orElse(null);
        if (channelOrElse != null) {
            return channelOrElse;
        }
        getChannel().add(channel);
        return channel;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List<Channel> getChannel() {
        List<Channel> arrayList = this.channel;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        this.channel = arrayList;
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getName() {
        return TextUtils.isEmpty(this.name) ? "" : this.name;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getPass() {
        return TextUtils.isEmpty(this.pass) ? "" : this.pass;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getPosition() {
        return this.position;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getWidth() {
        return this.width;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isEmpty() {
        return getChannel().isEmpty();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isHidden() {
        return !TextUtils.isEmpty(getPass());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isKeep() {
        return getName().equals(vr3.l(sm3.J));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isSelected() {
        return this.selected;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setChannel(List<Channel> list) {
        this.channel = list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setName(String str) {
        this.name = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setPass(String str) {
        this.pass = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setPosition(int i) {
        this.position = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setSelected(boolean z) {
        this.selected = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setWidth(int i) {
        this.width = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean skip() {
        return isKeep();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Group trans() {
        if (Trans.pass()) {
            return this;
        }
        this.name = Trans.s2t(this.name);
        return this;
    }

    public static Group create() {
        return create(sm3.t0);
    }

    public static Group create(String str, boolean z) {
        return new Group(str, z);
    }

    public Group(String str) {
        this(str, false);
    }

    public int find(String str) {
        return getChannel().lastIndexOf(Channel.create(str));
    }

    public int find(int i) {
        return getChannel().lastIndexOf(Channel.create(i));
    }
}
