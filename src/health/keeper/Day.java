/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package health.keeper;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author arifu
 */
public class Day implements Serializable{
    
    public String date;
    public String calorieIntake;
    public String foods;
    public String activity;
    public String calorieBurnt;

    public Day(String date, String calorieIntake, String foods, String activity, String calorieBurnt) {
        this.date = date;
        this.calorieIntake = calorieIntake;
        this.foods = foods;
        this.activity = activity;
        this.calorieBurnt = calorieBurnt;
    }
    
    
    
}
