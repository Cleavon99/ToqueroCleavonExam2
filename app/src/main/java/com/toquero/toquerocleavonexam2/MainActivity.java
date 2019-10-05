package com.toquero.toquerocleavonexam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {



    CheckBox[] checkBox = new CheckBox[8];
    EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit = findViewById(R.id.editText);
        checkBox[0] = findViewById(R.id.cb1);
        checkBox[1] = findViewById(R.id.cb2);
        checkBox[2] = findViewById(R.id.cb3);
        checkBox[3] = findViewById(R.id.cb4);
        checkBox[4] = findViewById(R.id.cb5);
        checkBox[5] = findViewById(R.id.cb6);
        checkBox[6] = findViewById(R.id.cb7);
        checkBox[7] = findViewById(R.id.cb8);

    }

    public void save(View v){
        String data = "";
        FileOutputStream writer = null;
        String checkedBoxes = "";

        for(int i = 0; i < 8; i++){
            if(checkBox[i].isChecked()){
                checkedBoxes+=checkBox[i].getText().toString() +" ";
            }
        }
        try {
            String data1 = edit.getText().toString();
            writer = openFileOutput("data6.txt", MODE_APPEND);
            writer.write(checkedBoxes.getBytes());
            writer.write(data1.getBytes());
        }catch (IOException e){
            Log.d("error", "IOException");
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                Log.d("error", "File not found 2");
            }
        }
        Toast.makeText(this, "Data Saved...", Toast.LENGTH_LONG).show();
    }

    public void next(View v) {
        Intent intent = new Intent(this, MainActivityTwo.class);
        startActivity(intent);
    }
}
