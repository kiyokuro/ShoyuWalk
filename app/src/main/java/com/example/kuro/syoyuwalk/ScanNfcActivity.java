package com.example.kuro.syoyuwalk;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.tech.IsoDep;
import android.nfc.tech.MifareClassic;
import android.nfc.tech.MifareUltralight;
import android.nfc.tech.Ndef;
import android.nfc.tech.NdefFormatable;
import android.nfc.tech.NfcA;
import android.nfc.tech.NfcB;
import android.nfc.tech.NfcF;
import android.nfc.tech.NfcV;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by keinon on 2015/09/23.
 */
public class ScanNfcActivity extends Activity {

    private NfcAdapter mNfcAdapter;
    private PendingIntent mPendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scan_nfc_layout);

        Intent intent = getIntent();
        String action = intent.getAction();
        // NFCかどうかActionの判定
        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action)
                ||  NfcAdapter.ACTION_TECH_DISCOVERED.equals(action)
                ||  NfcAdapter.ACTION_TAG_DISCOVERED.equals(action)) {
            //Log.d(TAG, "NFC DISCOVERD:" + action);
            // IDmを表示させる
            String idm = getIdm(getIntent());
            if (idm != null) {
                TextView idmView = (TextView) findViewById(R.id.id_view);
                idmView.setText(idm);

            }
        }
        mNfcAdapter = NfcAdapter.getDefaultAdapter(getApplicationContext());
        mPendingIntent = PendingIntent.getActivity(getApplicationContext(), 0,
                new Intent(getApplicationContext(), getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        String idm = getIdm(intent);
        if (idm != null) {
            TextView idmView = (TextView) findViewById(R.id.id_view);
            idmView.setText(idm);

            //スキャンしたNFCタグのIDがゴールの物か判定する
            if(idm=="1234567890") {
                //ResultActivityに遷移
                Intent intent1 = new Intent(this, Result.class);
                intent.putExtra("nfcId",idm);
                startActivity(intent1);
            }else{
                //QuesionActivityに遷移
                Intent intent1 = new Intent(this, Question.class);
                intent.putExtra("nfcId",idm);
                startActivity(intent1);
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mNfcAdapter != null) {
            setNfcIntentFilter(this, mNfcAdapter, mPendingIntent);
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mNfcAdapter != null) {
            mNfcAdapter.disableForegroundDispatch(this);
        }
    }

    /**
     * IDmを取得する
     * @param intent
     * @return
     */
    private String getIdm(Intent intent) {
        String idm = null;
        StringBuffer idmByte = new StringBuffer();
        byte[] rawIdm = intent.getByteArrayExtra(NfcAdapter.EXTRA_ID);
        if (rawIdm != null) {
            for (int i = 0; i < rawIdm.length; i++) {
                idmByte.append(Integer.toHexString(rawIdm[i] & 0xff));
            }
            idm = idmByte.toString();
        }
        return idm;
    }

    /**
     * フォアグラウンドディスパッチシステムで、アプリ起動時には優先的にNFCのインテントを取得するように設定する
     */
    private void setNfcIntentFilter(Activity activity, NfcAdapter nfcAdapter, PendingIntent seder) {
        // NDEF type指定
        IntentFilter typeNdef = new IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED);
        try {
            typeNdef.addDataType("*/*");
        } catch (IntentFilter.MalformedMimeTypeException e) {
            e.printStackTrace();
        }
        // NDEF スキーマ(http)指定
        IntentFilter httpNdef = new IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED);
        httpNdef.addDataScheme("http");
        IntentFilter[] filters = new IntentFilter[] {
                typeNdef, httpNdef
        };
        // TECH指定
        String[][] techLists = new String[][] {
                new String[] { IsoDep.class.getName() },
                new String[] { NfcA.class.getName() },
                new String[] { NfcB.class.getName() },
                new String[] { NfcF.class.getName() },
                new String[] { NfcV.class.getName() },
                new String[] { Ndef.class.getName() },
                new String[] { NdefFormatable.class.getName() },
                new String[] { MifareClassic.class.getName() },
                new String[] { MifareUltralight.class.getName() }
        };
        nfcAdapter.enableForegroundDispatch(activity, seder, filters, techLists);
    }

    //NFCをスキャンしたらQuestionクラスに遷移
    public void goQuestion(View view){
        Intent intent = new Intent(this,Question.class);
        startActivity(intent);
    }

    public void goResult(View view){
        Intent intent = new Intent(this,Result.class);
        startActivity(intent);
    }
}
