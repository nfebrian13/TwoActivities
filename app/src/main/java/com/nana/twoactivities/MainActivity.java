package com.nana.twoactivities;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView txtView;
    private EditText edtSend;
    private Button btnSend;
    private final String TAG = "mainactivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtView = (TextView) findViewById(R.id.txtView);
        edtSend = (EditText) findViewById(R.id.edtSend);
        btnSend = (Button) findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, edtSend.getText().toString());
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("messageone", edtSend.getText().toString());
                startActivity(intent);
            }
        });

        getMessage();

    }

    public void getMessage() {
        Intent intent = getIntent();
        String msgSecond = intent.getStringExtra("messagetwo");

        if (msgSecond != null) {
            Log.i(TAG, msgSecond);
            txtView.setText(msgSecond);
        } else {
            Toast.makeText(getApplicationContext(), "Sorry message is empty!", Toast.LENGTH_SHORT).show();
        }
    }
}
