
package com.aperigeek.hskp;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter(this,
                R.layout.list_item,
                new Object[] {"Item 1", "Item 2", "Item 3"}));
    }

}
