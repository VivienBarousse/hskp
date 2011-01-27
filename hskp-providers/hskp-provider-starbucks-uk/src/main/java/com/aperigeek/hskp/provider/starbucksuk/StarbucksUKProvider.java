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

package com.aperigeek.hskp.provider.starbucksuk;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * This class is a HotSpot provider for Starbucks hot spots.
 *
 * This providers works only in the UK, where the hot spots are provided by
 * British Telecom (OpenBT-Starbucks networks)
 *
 * @author Vivien Barousse
 */
public class StarbucksUKProvider extends Activity implements OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.properties);
        
        CheckBox acceptTos = (CheckBox) findViewById(R.id.accept_tos);
        EditText username = (EditText) findViewById(R.id.username);
        EditText password = (EditText) findViewById(R.id.password);

        SharedPreferences prefs = getSharedPreferences("StarbucksUKProvider", 0);
        acceptTos.setChecked(prefs.getBoolean("acceptTos", false));
        username.setText(prefs.getString("username", null));
        password.setText(prefs.getString("password", null));

        Button buttonDone = (Button) findViewById(R.id.button_done);
        Button buttonCancel = (Button) findViewById(R.id.button_cancel);
        buttonDone.setOnClickListener(this);
        buttonCancel.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.button_done) {
            CheckBox acceptTos = (CheckBox) findViewById(R.id.accept_tos);
            EditText username = (EditText) findViewById(R.id.username);
            EditText password = (EditText) findViewById(R.id.password);

            SharedPreferences prefs = getSharedPreferences("StarbucksUKProvider", 0);
            Editor editor = prefs.edit();

            editor.putBoolean("acceptTos", acceptTos.isChecked());
            editor.putString("username", username.getText().toString());
            editor.putString("password", password.getText().toString());

            editor.commit();
        }
        
        finish();
    }

}
