/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
 * @author viv
 */
public class SampleProvider2 extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter(this,
                R.layout.provider_list_item,
                new Object[]{"This is a sample provider (again)"}));
    }

}
