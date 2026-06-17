package com.fongmi.android.tv.receiver;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.fongmi.android.tv.service.PlaybackService;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ActionReceiver extends BroadcastReceiver {
    public static PendingIntent a(Context context, String str) {
        return PendingIntent.getBroadcast(context, 0, new Intent(str).setPackage(context.getPackageName()), 201326592);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (!PlaybackService.isRunning() || intent.getAction() == null) {
            return;
        }
        Intent intent2 = new Intent(context, (Class<?>) PlaybackService.class);
        intent2.setAction(intent.getAction());
        context.startService(intent2);
    }
}
