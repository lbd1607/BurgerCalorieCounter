package com.missouristate.davis916.burgercaloriecounter;

/**
 * Laura Davis CIS 262-902
 * 15 February 2018
 * This class sets constant values for each
 * of the options and uses the Burger constructor
 * to provide initial values for ingredients.
 * This class acts as a controller for the app.
 */

public class Burger {
    static final int BEEF = 100;
    static final int LAMB = 170;
    static final int OSTRICH = 150;
    static final int ASIAGO = 90;
    static final int CREME_FRAICHE = 120;
    static final int PROSCIUTTO = 115;

    private int mPattyCal;
    private int mCheeseCal;
    private int mProsciuttoCal;
    private int mSauceCal;

    //The Burger constructor sets the initial ingredients
    public Burger(){
        mPattyCal = BEEF;
        mCheeseCal = ASIAGO;
        mProsciuttoCal = 0;
        mSauceCal = 0;
    }//end of Burger constructor

    //gets calories from patty
    public void setPattyCalories(int calories){
        mPattyCal = calories;
    }//end of setPattyCalories

    //gets calories from cheese
    public void setCheeseCalories(int calories){
        mCheeseCal = calories;
    }//end setCheeseCalories

    //gets calories from prosciutto
    public void setProsciuttoCalories(int calories){
        mProsciuttoCal = calories;
    }//end setProsciuttoCalories

    //resets prosciutto calories back to zero
    public void clearProsciuttoCalories(){
        mProsciuttoCal = 0;
    }//end clearProsciuttoCalories

    //gets calories from sauce
    public void setSauceCalories(int calories){
        mSauceCal = calories;
    }//end setSauceCalories

    //gets total calories by adding values from above methods
    public int getTotalCalories(){
        return mPattyCal + mCheeseCal + mProsciuttoCal + mSauceCal;
    }//end getTotalCalories

}//end of Burger class
