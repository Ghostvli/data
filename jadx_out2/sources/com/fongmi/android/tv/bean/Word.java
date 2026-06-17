package com.fongmi.android.tv.bean;

import android.text.TextUtils;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.bean.Word;
import com.github.catvod.utils.Trans;
import com.google.gson.annotations.SerializedName;
import defpackage.nl0;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Word {

    @SerializedName("data")
    private List<Data> data;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Data implements nl0 {

        @SerializedName(alternate = {"name"}, value = "title")
        private String title;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String getTitle() {
            return TextUtils.isEmpty(this.title) ? "" : this.title;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: isSameContent(Ljava/lang/Object;)Z */
        @Override // defpackage.nl0
        public boolean isSameContent(Data data) {
            return getTitle().equals(data.getTitle());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: isSameItem(Ljava/lang/Object;)Z */
        @Override // defpackage.nl0
        public boolean isSameItem(Data data) {
            return getTitle().equals(data.getTitle());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Data trans() {
            this.title = Trans.s2t(this.title);
            return this;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Word objectFrom(String str) {
        Word word = (Word) App.c().fromJson(str, Word.class);
        return word == null ? new Word() : word.trans();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List<Data> getData() {
        List<Data> list = this.data;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Word trans() {
        if (Trans.pass()) {
            return this;
        }
        getData().forEach(new Consumer() { // from class: ba5
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((Word.Data) obj).trans();
            }
        });
        return this;
    }
}
