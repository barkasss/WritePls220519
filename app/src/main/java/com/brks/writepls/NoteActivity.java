package com.brks.writepls;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.content.res.AppCompatResources;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NoteActivity extends AppCompatActivity {

    private String NoteTitle;
    private String NoteText;
    String EditedNoteTitle;
    String EditedNoteText;
    EditText textNote;
    EditText titleNote;
    Button saveBtn;
    int selected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        saveBtn = findViewById(R.id.save_bt1n);
       // saveBtn.setCompoundDrawablesWithIntrinsicBounds(
        //        AppCompatResources.getDrawable(this, R.drawable.save), null, null, null); --иконочка

        titleNote = findViewById(R.id.title_n1ote);
        textNote = findViewById(R.id.main_text_n1ote);


        Intent intent = getIntent();
        NoteTitle = intent.getStringExtra("Title");
        NoteText = intent.getStringExtra("Text");
        intent.getIntExtra("selected",selected);


     //   titleNote.setText(NoteTitle);
    //    textNote.setText(NoteText);




        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //  Intent intent = new Intent(getApplicationContext(),MainActivity.class);
             //   startActivity(intent);  -- создание новой мейн активности

         //   EditedNoteTitle = titleNote.getText().toString();
          //  EditedNoteText = textNote.getText().toString();
          //  Intent intent = new Intent(getApplicationContext(),MainActivity.class);
         //   intent.putExtra("Name",EditedNoteTitle);
          //  intent.putExtra("Text",EditedNoteText);
          //  intent.putExtra("selected",selected);

                finish();
            }
        });




    }
}
