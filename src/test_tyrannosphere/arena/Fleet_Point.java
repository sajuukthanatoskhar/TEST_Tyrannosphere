
package test_tyrannosphere.arena;

import test_tyrannosphere.Fleet;

/**
 * In test_tyr.Fleet, we have made our fleet and the ships that go in that fleet
 * The fleets are then represented as points with vectors to represent them fighting as a unit.  
 * Maybe later we can individual ships being represented on the field as opposed to entire fleets
 * @author Sajuuk
 */
public class Fleet_Point {
    
    private Fleet This_Fleet;  //The fleet attached to this Fleet_Point
    private float x_pos,y_pos,z_pos;  //All fleets have a starting point at time 0.  
    private float[] vector;  //All fleets have a vector (for their speed)
    
    
    
    /*
    Initialise the fleet_point, assigning a fleet and an initial x,y,z location
    */
    public Fleet_Point(Fleet myfleet, float x, float y, float z)
    {
        this.This_Fleet = myfleet;
        this.x_pos = x;
        this.y_pos = y; 
        this.z_pos = z; 
        
    }
    
    //As it says on the tin, we are approaching another fleet
    public void approach_fleet(float range, Fleet_Point target)
    {
        //TODO: Tell fleet to approach a fleet
    }

    public void approach_fleet(float range, float[] location)
    {
        //TODO: Tell fleet to approach a target location
        
    }
    
    public void approach(float[] directionvector)
    {
       this.vector = directionvector;
    }
    
    public void orbit_fleet(float range, Fleet_Point target)
    {
        //TODO: Tell fleet to orbit fleet
    }
    
    public void keep_at_range_fleet(float range, Fleet_Point target)
    {
        //TODO: Tell fleet to keep at range
    }
    
    
}
