package com.example.kuro.syoyuwalk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by keinon on 2015/09/23.
 */
public class Question extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_layout);
    }

    public void answer(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
