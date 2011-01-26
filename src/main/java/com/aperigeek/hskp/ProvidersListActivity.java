/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aperigeek.hskp;

import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.List;

/**
 *
 * @author viv
 */
public class ProvidersListActivity extends ListActivity {

    private List<ResolveInfo> infos;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent("com.aperigeek.hskp.Provider");
        intent.addCategory("com.aperigeek.hskp.PROVIDER");
        infos = getPackageManager().queryIntentActivities(intent, 0);

        Object[] results = new Object[infos.size()];
        for (int i = 0; i < infos.size(); i++) {
            results[i] = infos.get(i).loadLabel(getPackageManager()).toString();
        }

        setListAdapter(new ArrayAdapter(this,
                R.layout.list_item,
                results));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        ActivityInfo activity = infos.get(position).activityInfo;

        Intent intent = new Intent("com.aperigeek.hskp.Provider");
        intent.addCategory("com.aperigeek.hskp.PROVIDER");
        intent.setClassName(activity.packageName, activity.name);

        startActivity(intent);
    }

}
