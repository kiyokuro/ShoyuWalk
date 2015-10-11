package com.example.kuro.syoyuwalk;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by keinon on 2015/09/23.
 */
public class ResultActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_layout);

        int Rid[] = {R.id.q1,R.id.q2,R.id.q3,R.id.q4,R.id.q5,R.id.q6,R.id.q7,R.id.q8,R.id.q9
                ,R.id.q10,R.id.q11,R.id.q12,R.id.q13,R.id.q14,R.id.q15,R.id.q16,R.id.q17,R.id.q18};
        String[] list = new String[18];
        for(int n=0;n<10;n++){
            list[n]=""+n;//問題に何を答えたかを代入,
        }

        for(int i=0; i<18;i++){
            TextView tv = (TextView)findViewById(Rid[i]);
            tv.setText("Q"+(i+1)+" : "+list[i]);

        }
        TextView ango = (TextView)findViewById(R.id.ango);
        //ここで正解数を取得
        int answerCount = 0;
        switch (answerCount){
            case 0:
                ango.setText("680");
                break;
            case 1:
                ango.setText("43");
                break;
            case  2:
                ango.setText("119");
                break;
            case 3:
                ango.setText("230");
                break;
            case 4:
                ango.setText("87");
                break;
            case 5:
                ango.setText("756");
                break;
            case 6:
                ango.setText("232");
                break;
            case 7:
                ango.setText("431");
                break;
            case 8:
                ango.setText("885");
                break;
            case 9:
                ango.setText("219");
                break;
            case 10:
                ango.setText("36");
                break;
            case 11:
                ango.setText("16");
                break;
            case 12:
                ango.setText("105");
                break;
            case 13:
                ango.setText("694");
                break;
            case 14:
                ango.setText("154");
                break;
            case 15:
                ango.setText("300");
                break;
            case 16:
                ango.setText("489");
                break;
            case 17:
                ango.setText("868");
                break;
            case 18:
                ango.setText("876");
                break;
            default:
                ango.setText("error");
                break;
        }


    }
}
