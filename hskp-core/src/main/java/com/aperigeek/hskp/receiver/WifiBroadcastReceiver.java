
package com.aperigeek.hskp.receiver;

import java.util.logging.Logger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * @author Colin Hebert
 */
public class WifiBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Logger.getLogger(WifiBroadcastReceiver.class.getCanonicalName()).info("WiFi state change detected");
    }

}
