package test_tyrannosphere.arena;

import java.util.ArrayList;

/**
 * The arena is the backend where the fleets do battle
 * For EVE Nerds, this is the system where you will engage your hostile fleet.  
 * @author Sajuuk
 */
public class Arena {
    
    private float radius;
    private int time; 
    private ArrayList numberoffleets;
    
    
    public Arena(ArrayList fleetnumber, float size)
    {
        this.numberoffleets = fleetnumber;
        this.radius = size;
    }
    
    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
    
    public void fleets_update()
    {
        
    }
    
}
