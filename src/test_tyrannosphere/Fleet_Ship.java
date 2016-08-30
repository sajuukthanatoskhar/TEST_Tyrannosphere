/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test_tyrannosphere;

import test_tyrannosphere.gui.Ship_Builder_Window;

/*
 * This class is for our ships
 */
public class Fleet_Ship extends EVEObject {

    private String Ship_Fleet;
    double  Agility,
            ArmorEM,
            ArmorExplosive,
            ArmorHitpoints,
            ArmorKinetic,
            ArmorThermal,
            CapRechTime,
            Capacitor,
            DPS,
            FallOff,
            Optimal,
            ShieldAmount,
            ShieldEM,
            ShieldExplosive,
            ShieldKinetic,
            ShieldRechTime,
            ShieldThermal,
            SigRad,
            StructureAmount,
            TSig,
            WarpSpeed;
    
    String Name, ShipClass;
    double EHP;
    
    Gun Shipguns;
    MissileLauncher Shipmissile;
    /*
                Agility
                ArmorEM
                ArmorExplosive
                ArmorHitpoints
                ArmorKinetic
                ArmorThermal
                CapRechTime
                Capacitor
                DPS
                FallOff
                Name
                Optimal
                ShieldAmount
                ShieldEM
                ShieldExplosive
                ShieldKinetic
                ShieldRechTime
                ShieldThermal
                ShipClass
                SigRad
                StructureAmount
                TSig
                WarpSpeed
    */
    
    /*
     * Initialiser for ship objects 
     */
    public Fleet_Ship(String FitName)
    {

        setShip_Fleet(FitName);

        //Adding to Fleet
        //AssociatedFleet.Fleet_Members.add(this);
        //AssociatedFleet.update();
    }


    public String getShip_Fleet() {
        return Ship_Fleet;
    }

    public void setShip_Fleet(String Ship_Fleet) {
        this.Ship_Fleet = Ship_Fleet;
    }

    @Override
    void update_position() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void update_dps() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void update_health() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
