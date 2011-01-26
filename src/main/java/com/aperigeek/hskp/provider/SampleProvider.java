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

package com.aperigeek.hskp.provider;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import com.aperigeek.hskp.R;

/**
 * This class is a sample HotSpot provider, added for testing purposes. It has
 * no preferences, and doesn't do anything concrete.
 *
 * @author Vivien Barousse
 */
public class SampleProvider extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter(this,
                R.layout.provider_list_item,
                new Object[]{"This is a sample provider"}));
    }

}
