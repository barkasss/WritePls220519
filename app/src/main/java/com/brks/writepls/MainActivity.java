package com.brks.writepls;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sPref;
    public boolean a ;
    public static final String SWITCH_NOTIFICATIONS = "switch_pop_up";
    final NotesFragment notesFragment = new NotesFragment();
    final RemindersFragment remindersFragment = new RemindersFragment();
    final SettingsFragment settingsFragment = new SettingsFragment();
    final ToDoListFragment toDoListFragment = new ToDoListFragment();
    final ShoppingListFragment shoppingListFragment = new ShoppingListFragment();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        Bundle bundle = new Bundle();

    }

        //OnCreate end

    private void saveSettNotif() {
        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putBoolean(SWITCH_NOTIFICATIONS,a);
        ed.commit();
    }
    private void loadSettNotif() {
        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);
        a = sPref.getBoolean(SWITCH_NOTIFICATIONS, true);
    }




}







