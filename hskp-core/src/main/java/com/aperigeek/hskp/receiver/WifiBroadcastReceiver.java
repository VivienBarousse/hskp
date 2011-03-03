
package com.aperigeek.hskp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

/**
 * @author Colin Hebert
 * @author Vivien Barousse
 */
public class WifiBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        WifiManager manager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo connectionInfo = manager.getConnectionInfo();
        String ssid = connectionInfo.getSSID();
        if (ssid != null) {
            Intent broadcastIntent = new Intent("com.aperigeek.hskp.receiver." + ssid);
            context.sendBroadcast(broadcastIntent);
        }
    }

}
