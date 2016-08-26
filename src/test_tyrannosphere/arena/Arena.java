package test_tyrannosphere.arena;

import java.util.ArrayList;
import java.util.List;
import test_tyrannosphere.Fleet_Ship;

/**
 * The arena is the backend where the fleets do battle
 * For EVE Nerds, this is the system where you will engage your hostile fleet.  
 * @author Sajuuk
 */
public class Arena {
    
    private float radius;
    private int time; //We start at 0, always.  Time is measured in seconds, because EVE is lovely like that
    public List<Fleet_Point> Arena_Fleets = new ArrayList<>();  //Keeping a list of all the unique fleet_points for this Arena
    
    
    public Arena(float size)
    {
        //this.numberoffleets = fleetnumber;
        this.radius = size;
        this.time = 0; //Starting at 0
    }
    
    public void addfleet(Fleet_Point new_fleet)
    {
        //TODO: Functionality to add new fleet_point(!) to arena
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
    
    
    /*
    This function is the time+1 fleet updater
    */
    public void fleets_update()
    {
        
        
        
        this.setTime(this.getTime() + 1);
    }
    
}
