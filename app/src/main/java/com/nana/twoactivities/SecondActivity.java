package com.nana.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private TextView txtView;
    private EditText edtSend;
    private Button btnSend;
    private final String TAG = "secondactivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtView = (TextView) findViewById(R.id.txtView);
        edtSend = (EditText) findViewById(R.id.edtSend);
        btnSend = (Button) findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, edtSend.getText().toString());

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("messagetwo", edtSend.getText().toString());
                startActivity(intent);
            }
        });

        getMessage();
    }

    public void getMessage() {
        Intent intent = getIntent();
        String msgOne = intent.getStringExtra("messageone");

        if (msgOne != null) {
            txtView.setText(msgOne);
            Log.i(TAG, msgOne);
        } else {
            Toast.makeText(getApplicationContext(), "Sorry message is empty!", Toast.LENGTH_SHORT).show();
        }
    }

}
