package com.brks.writepls;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity  {


    public boolean a ;

    final NotesFragment notesFragment = new NotesFragment();
    final RemindersFragment remindersFragment = new RemindersFragment();
    final SettingsFragment settingsFragment = new SettingsFragment();
    final ToDoListFragment toDoListFragment = new ToDoListFragment();
    final ShoppingListFragment shoppingListFragment = new ShoppingListFragment();

    Button upBtn;
    Button downBtn;
    Button btnPrp;
    Button btnBlue;
    Button btnGreen;
    Button btnGrey;
    Button btnPink;
    LinearLayout btns;

  //  SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
  //  int theme;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {

      //  theme = sp.getInt("THEME", R.style.AppTheme);
      //  setTheme(theme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  btns = findViewById(R.id.switchTBtn);

        upBtn = findViewById(R.id.upperBtn);
        upBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upBtn.setVisibility(View.GONE);
                btns.setVisibility(View.VISIBLE);
                downBtn.setVisibility(View.VISIBLE);

            }
        });

        downBtn = findViewById(R.id.downBtn);
        downBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upBtn.setVisibility(View.VISIBLE);
                btns.setVisibility(View.GONE);
                downBtn.setVisibility(View.GONE);
            }
        });
        btnPrp = findViewById(R.id.btnPrp);
        btnPrp.setOnClickListener(this);
        btnBlue = findViewById(R.id.btnBlue);
        btnBlue.setOnClickListener(this);
        btnGreen = findViewById(R.id.btnGreen);
        btnGreen.setOnClickListener(this);
        btnGrey = findViewById(R.id.btnGrey);
        btnGrey.setOnClickListener(this);
        btnPink = findViewById(R.id.btnPink);
        btnPink.setOnClickListener(this); */



        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new NotesFragment()).commit();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragment = notesFragment;


                switch (menuItem.getItemId()) {
                    case R.id.action_notes:
                   //     loadSettNotif();
                     //   if(a)
                   //         Toast.makeText(MainActivity.this, "Your Notes", Toast.LENGTH_SHORT).show();
                        selectedFragment = notesFragment;
                        break;
                    case R.id.action_reminders:
                   //     loadSettNotif();
                    //    if(a)
                      //      Toast.makeText(MainActivity.this, "Your Reminders", Toast.LENGTH_SHORT).show();
                        selectedFragment = remindersFragment;
                        break;
                  //  case R.id.action_settings:
                    //    loadSettNotif();
                    //    if(a)
                     //       Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                     //   selectedFragment = settingsFragment;
                      //  a = settingsFragment.getSPUisChecked();
                      //  saveSettNotif();
                   //     break;
                    case R.id.action_to_do_list :
                      //  loadSettNotif();
                       // if(a)
                        //    Toast.makeText(MainActivity.this, "Your To Do Lists", Toast.LENGTH_SHORT).show();
                        selectedFragment = toDoListFragment;
                        break;
                    case R.id.action_to_buy_list:
                        selectedFragment = shoppingListFragment;
                        break;

                }

                assert selectedFragment != null;
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedFragment).commit();
             //   a = settingsFragment.getSPUisChecked();
              //  saveSettNotif();



                return true;
            }
        });

        

    }
    //OnCreate end

  /*  @Override
    public void onClick(View v) {
        Editor editor = sp.edit();
        int th;
        switch (v.getId()){
            case R.id.btnBlue:
                setTheme(R.style.CyanTheme);
                th = R.style.CyanTheme;
                break;
            case R.id.btnGreen:
                setTheme(R.style.GreenTheme);

                break;
            case R.id.btnPrp:

                break;
            case R.id.btnGrey:

                break;
            case R.id.btnPink:

                break;
            editor.putInt("THEME", th);
            editor.apply();

        }
    } */







}







