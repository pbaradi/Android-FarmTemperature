package com.android.farmtemperature;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int temperature;
    int humidity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickSet(View view){
        EditText temperature_id = (EditText)findViewById(R.id.temperature);
        temperature = Integer.valueOf(temperature_id.getText().toString());
        EditText humidity_id = (EditText)findViewById(R.id.humidity);
        humidity = Integer.valueOf(humidity_id.getText().toString());

        Intent intent = new Intent("com.android.farm.temperature.broadcast.request");
        intent.putExtra("temperature",temperature);
        intent.putExtra("humidity", humidity);

        sendBroadcast(intent);
        Toast.makeText(MainActivity.this, "Temperature Set!",
                Toast.LENGTH_LONG).show();
    }

    public void onClickCancel(View view){
        EditText temperature_id = (EditText)findViewById(R.id.temperature);
        temperature_id.setText(null);
        EditText humidity_id = (EditText)findViewById(R.id.humidity);
        humidity_id.setText(null);

    }


}
