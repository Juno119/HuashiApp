package net.muxi.huashiapp.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import net.muxi.huashiapp.util.AlarmUtil;

/**
 * Created by ybao on 16/5/16.
 */
public class AlarmLiveReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null && Intent.ACTION_USER_PRESENT.equals(intent.getAction())){
            AlarmUtil.register(context);
        }
    }

}
