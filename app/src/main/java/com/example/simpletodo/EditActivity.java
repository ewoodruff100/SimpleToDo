 package com.example.simpletodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

 public class EditActivity extends AppCompatActivity {

    EditText etItem;
    Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etItem = findViewById(R.id.etItem);
        btnSave = findViewById(R.id.btnSave);
        getSupportActionBar().setTitle("Edit item");
        etItem.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));

        //when done changing, click Save
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create intent for results
                Intent intent = new Intent();
                //pass edited data
                intent.putExtra(MainActivity.KEY_ITEM_TEXT, etItem.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));
                //set result from intent
                setResult(RESULT_OK, intent);
                //finish, close screen and go back
                finish();
            }
        });
    }
}