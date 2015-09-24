package com.example.kuro.syoyuwalk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by keinon on 2015/09/23.
 */
public class ScanNfcActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scan_nfc_layout);
    }

    //NFCをスキャンしたらQuestionクラスに遷移
    public void goQuestion(View view){
        Intent intent = new Intent(this,QuestionActivity.class);
        startActivity(intent);
    }

    public void goResult(View view){
        Intent intent = new Intent(this,ResultActivity.class);
        startActivity(intent);
    }
}
