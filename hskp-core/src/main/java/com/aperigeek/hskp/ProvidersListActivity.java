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
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.List;

/**
 *
 * @author Vivien Barousse
 */
public class ProvidersListActivity extends ListActivity {

    private List<ResolveInfo> infos;

    private class ProviderListAdapter implements ListAdapter {

        private LayoutInflater inflater;

        public ProviderListAdapter() {
            inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        public boolean areAllItemsEnabled() {
            return true;
        }

        public boolean isEnabled(int i) {
            return true;
        }

        public void registerDataSetObserver(DataSetObserver dso) {
            // Data set is fixed for now. Observers aren't required in this case
        }

        public void unregisterDataSetObserver(DataSetObserver dso) {
            // Data set is fixed for now. Observers aren't required in this case
        }

        public int getCount() {
            return infos.size();
        }

        public Object getItem(int i) {
            return infos.get(i);
        }

        public long getItemId(int i) {
            return i;
        }

        public boolean hasStableIds() {
            return true;
        }

        public View getView(int i, View oldView, ViewGroup parent) {
            // TODO: Reuse old view
            LinearLayout element = (LinearLayout) inflater.inflate(R.layout.provider_list_item, parent, false);

            TextView providerName = (TextView) element.findViewById(R.id.provider_name);
            ImageView providerIcon = (ImageView) element.findViewById(R.id.provider_icon);

            providerName.setText(infos.get(i).loadLabel(getPackageManager()));
            providerIcon.setImageDrawable(infos.get(i).loadIcon(getPackageManager()));

            return element;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean isEmpty() {
            return infos.isEmpty();
        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent("com.aperigeek.hskp.Provider");
        intent.addCategory("com.aperigeek.hskp.PROVIDER");
        infos = getPackageManager().queryIntentActivities(intent, 0);

        setListAdapter(new ProviderListAdapter());
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
