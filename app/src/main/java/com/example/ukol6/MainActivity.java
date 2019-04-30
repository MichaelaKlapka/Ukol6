package com.example.ukol6;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String zadanyText;
    private String preklad;
    private TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //vytvořit instanci tridy
                new MyAsyncTask(MainActivity.this, zadanyText, preklad).execute();
                textView = findViewById(R.id.textView);
                textView.setText(preklad);

            }
        });


        EditText editText = findViewById(R.id.editText);
        //kdyz dam Text Watcher, tak mi to automaticky vygeneruje 3 funkce
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //ukladam to cislo jako String - sequence to string
                ///try/catch - code - surround with
                try {
                    zadanyText = s.toString();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

}
