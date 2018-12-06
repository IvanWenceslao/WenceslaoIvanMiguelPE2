package com.wenceslao.ivanmiguelw;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editName, editAge, editGender;
    TextView textShowName, textShowAge, textShowGender;
    Button btnSave, btnSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        editName = (EditText)findViewById(R.id.editText_Name);
        editAge = (EditText)findViewById(R.id.editText_Age);
        editGender = (EditText)findViewById(R.id.editText_Gender);
        btnSave = (Button)findViewById(R.id.button_save);
        btnSearch = (Button)findViewById(R.id.button_search);
        textShowName = (TextView)findViewById(R.id.textShow_Name);
        textShowAge = (TextView)findViewById(R.id.textShow_Age);
        textShowGender = (TextView)findViewById(R.id.textShow_Gender);
        AddData();
    }

    public void AddData(){
        btnSave.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        boolean isInserted =  myDb.insertData(editName.getText().toString(),
                                editAge.getText().toString(),
                                editGender.getText().toString() );
                        if(isInserted == true)
                            Toast.makeText(MainActivity.this,"Data inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Data not inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    /*
    public void showResult() {
        textShowName.setText(table.getString(1));
        textShowAge.setText(table.getString(2));
        textShowGender.setText(table.getstring(3));
    }*/

}
