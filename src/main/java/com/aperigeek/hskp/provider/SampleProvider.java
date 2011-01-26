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

import android.app.Activity;
import android.os.Bundle;
import com.aperigeek.hskp.R;

/**
 * This class is a sample HotSpot provider, added for testing purposes. It has
 * no preferences, and doesn't do anything concrete.
 *
 * @author Vivien Barousse
 */
public class SampleProvider extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.sample_provider);
    }

}
