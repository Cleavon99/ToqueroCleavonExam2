package com.toquero.toquerocleavonexam2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivityTwo extends AppCompatActivity {

    CheckBox[] checkBox = new CheckBox[8];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintwo);

        FileInputStream reader = null;
        String msg="";
        try{
            int token;
            StringBuffer buffer = new StringBuffer();
            reader = openFileInput("data6.txt");
            while((token=reader.read())!=-1){
                buffer.append((char)token);
                msg=msg+(char)token;
            }
            reader.close();
            String list[]=msg.split(" ");
            ((TextView)(findViewById(R.id.tv1))).setText(list[0]);
            ((TextView)(findViewById(R.id.tv2))).setText(list[1]);
            ((TextView)(findViewById(R.id.tv3))).setText(list[2]);
            ((TextView)(findViewById(R.id.tv4))).setText(list[3]);
            ((TextView)(findViewById(R.id.tv5))).setText(list[4]);
            ((TextView)(findViewById(R.id.tv6))).setText(list[5]);
            ((TextView)(findViewById(R.id.tv7))).setText(list[6]);
            ((TextView)(findViewById(R.id.tv8))).setText(list[7]);
            ((TextView) (findViewById(R.id.tvcomment))).setText(list[9]);

        }catch (FileNotFoundException e){
            Log.d("error", "File not found error msg");
        }catch (IOException e){
            Log.d("error", "file not found");
        }


}
    public void previous(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
