/*
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
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
 * @author Vivien Barousse
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
