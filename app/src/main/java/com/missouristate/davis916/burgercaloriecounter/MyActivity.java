/*
 * Laura Davis CIS 262-902
 * 15 February 2018
 * This app gives the user a selection
 * of patty, cheese, and toppings for a burger.
 * The app calculates the total calories
 * according to the user's choices.
 */
package com.missouristate.davis916.burgercaloriecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TabHost;
import android.widget.TextView;

public class MyActivity extends AppCompatActivity {

    //Declare UI objects to be referenced
    private RadioGroup pattyRG;
    private CheckBox prosciuttoCBX;
    private RadioGroup cheeseRG;
    private SeekBar sauceSBR;
    private TextView caloriesTV;

    //Declare variables for computing calories
    private Burger burger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        //Initialize UI objects and variables
        burger = new Burger();
        initialize();

        //Register change listeners
        registerChangeListener();
    }//end onCreate

    //Get reference to each UI component
    private void initialize(){
        pattyRG = (RadioGroup) findViewById(R.id.radioGroup1);
        prosciuttoCBX = (CheckBox) findViewById(R.id.checkBox1);
        cheeseRG = (RadioGroup) findViewById(R.id.radioGroup2);
        sauceSBR = (SeekBar) findViewById(R.id.seekBar1);
        caloriesTV = (TextView) findViewById(R.id.textView2);

        displayCalories();
    }//end initialize

    //Register the listeners
    private void registerChangeListener(){
        pattyRG.setOnCheckedChangeListener(foodListener);
        prosciuttoCBX.setOnClickListener(baconListener);
        cheeseRG.setOnCheckedChangeListener(foodListener);
        sauceSBR.setOnSeekBarChangeListener(sauceListener);
    }//end registerChangeListener

    /*
    configure listener
    hex values must come from "...\\app\\build\\generated\\source\\r\\debug\\com\\company\\user\\burgercaloriecounter\\R.java"
    */
    private OnCheckedChangeListener foodListener = new OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup rbgroup, int radioId){
            switch (radioId){
                case 0x7f070055: //Beef patty
                    burger.setPattyCalories(Burger.BEEF);
                    break;
                case 0x7f070056: //Lamb patty
                    burger.setPattyCalories(Burger.LAMB);
                    break;
                case 0x7f070057: //Ostrich patty
                    burger.setPattyCalories(Burger.OSTRICH);
                    break;
                case 0x7f070058: //Asiago cheese
                    burger.setCheeseCalories(Burger.ASIAGO);
                    break;
                case 0x7f070059: //Creme fraiche
                    burger.setCheeseCalories(Burger.CREME_FRAICHE);
            }
            displayCalories();
        }//end onCheckChanged
    };//end OnCheckedChangedListener foodListener

    //configure listener
    private OnClickListener baconListener = new OnClickListener() {
        public void onClick(View v){
            if(((CheckBox) v) .isChecked())
                burger.setProsciuttoCalories(Burger.PROSCIUTTO);
            else
                burger.clearProsciuttoCalories();

            displayCalories();
        }//end onClick

    };//end OnClickListener baconListener

    //configure listener
    private OnSeekBarChangeListener sauceListener = new OnSeekBarChangeListener() {
          public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
              burger.setSauceCalories(seekBar.getProgress());
              displayCalories();
          }//end onProgressChanged

        public void onStartTrackingTouch(SeekBar seekBar){}

        public void onStopTrackingTouch(SeekBar seekBar){}

    };//end OnSeekBarChangeListener sauceListener

    //display the computed calories
    private void displayCalories(){
        //construct an output string and display the TextView
        String calorieText = "Calories: " + burger.getTotalCalories();
        caloriesTV.setText(calorieText);
    }//end displayCalories

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //inflate the menu
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }//end onCreateOptionsMenu

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        /* Handle action bar item clicks here
           The action bar will automatically handle clicks
           on the Home/Up button, so long as you specify
           a parent activity in AndroidManifest.xml
         */
        int id = item.getItemId();
        if (id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }//end onOptionsItemSelected

}//end MyActivity
