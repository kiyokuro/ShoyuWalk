package com.example.kuro.syoyuwalk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by keinon on 2015/09/23.
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        TextView tv1 = (TextView)findViewById(R.id.map);
    }

    public void change(View view){
        Intent intent = new Intent(this,ScanNfcActivity.class);
        startActivity(intent);
    }
}
