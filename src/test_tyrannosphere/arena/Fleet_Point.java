
package test_tyrannosphere.arena;

import test_tyrannosphere.Fleet;

/**
 * In test_tyr.Fleet, we have made our fleet and the ships that go in that fleet
 * @author Sajuuk
 */
public class Fleet_Point {
    
    private Fleet This_Fleet;
    private float x_pos,y_pos,z_pos;
    
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
}
