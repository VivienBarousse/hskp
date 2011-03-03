/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aperigeek.hskp.provider.sample;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 *
 * @author viv
 */
public class SampleReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: Auto connect to your HotSpot!

        NotificationManager notifManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notif = new Notification(R.drawable.icon, "Connected @ SampleHotSpot!", System.currentTimeMillis());
        Intent notifIntent = new Intent(context, SampleProvider.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, notifIntent, 0);
        notif.setLatestEventInfo(context, "Connected @ SampleHotSpot", "Automagically connected to SampleHotSpot", pendingIntent);
        notifManager.notify(1, notif);
    }

}
