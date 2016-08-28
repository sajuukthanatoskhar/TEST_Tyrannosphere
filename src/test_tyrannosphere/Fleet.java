
package test_tyrannosphere;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import test_tyrannosphere.gui.BuildFleet_Window;

/**
 *
 * @author Sajuuk
 */
public class Fleet extends EVEObject {

    private String FleetName;
    private double DPS;
    private double EHP;
    public List<Fleet_Ship> Fleet_Members = new ArrayList<>();
    double ShipSig, ShipSpeed,ShipAgility,ShipShieldRes[],ShipArmorRes[],ShipStructureRes[],ShipShieldHealth,ShipArmorHealth,ShipStructureHealth;
    double tracking, gunduration, Turret,  gunreloadtime, GEMd, GThD, GKiD, GExD,  TurretSignature,  TurretOptimal,  TurretFalloff,  capacitor_needed, MissileDPS, MissileDuration,  ExplosionRadius,  MissileVelocity,  FlightTime,  MEMD,  MThD,  MKiD, MExD;    
    /*
    X,Y,Z of 
    */
    private float x_pos,y_pos,z_pos;  //All fleets have a starting point at time 0.  
    private float[] vector;  //All fleets have a vector (for their speed)

    public float getX_pos() {
        return x_pos;
    }

    public void setX_pos(float x_pos) {
        this.x_pos = x_pos;
    }

    public float getY_pos() {
        return y_pos;
    }

    public void setY_pos(float y_pos) {
        this.y_pos = y_pos;
    }

    public float getZ_pos() {
        return z_pos;
    }

    public void setZ_pos(float z_pos) {
        this.z_pos = z_pos;
    }

    public float[] getVector() {
        return vector;
    }

    public void setVector(float[] vector) {
        this.vector = vector;
    }
    
    public Fleet() {
    
    }

    public void Print_Fleet_Members() {
        for (int i = 0; i < this.Fleet_Members.size(); i++) {
            System.out.println(this.Fleet_Members.get(i).getShip_Fleet());
        }
    }

    public Fleet(String FleetName) {
        System.out.print("\nFleet " + FleetName + " created\n");
    }

    //If ship has EHP less than 0, it is removed from fleet
    //If That happens - DPS must be removed
    public void PrintDPS() {
        System.out.print(this.DPS);
    }

    /*
     * This updates the values for the fleet everytime we make a new fleet_ship
     * 
     * So far it has
     * 
     * EHP
     * DPS
     * 
     */
    public void update() {
        System.out.print("\nUpdating  Numbers");

        //DPS Calculation
        double Total_DPS = 0;
        double Total_EHP = 0;
        for (int i = 0; i < this.Fleet_Members.size(); i++) {
            Total_DPS += this.Fleet_Members.get(i).getDPS();
            Total_EHP += this.Fleet_Members.get(i).getEHP();
        }
        System.out.print("\n" + Total_DPS);
        this.DPS = Total_DPS;
        this.EHP = Total_EHP;
    }

    public void Print_Fleet_Stats() {
        System.out.print("\nTotal Damage Per Second : \t" + this.DPS);
        System.out.print("\nTotal Effective Hit Points : \t" + this.EHP);
        System.out.print("\nNumber of Ships : \t\t" + this.Fleet_Members.size() + " ships\n");
    }

    public String getFleetName() {
        return FleetName;
    }

    public double getDPS() {
        return DPS;
    }

    public double getEHP() {
        return EHP;
    }

    public String setName(Object selectedItem) {
        return selectedItem.toString();
    }

    public void setupFleet() {
        double Total_DPS = 0;
        double Total_EHP = 0;
        for (int i = 0; i < this.Fleet_Members.size(); i++) {
            Total_DPS += this.Fleet_Members.get(i).getDPS();
            Total_EHP += this.Fleet_Members.get(i).getEHP();
        }
        //System.out.print("\n" + Total_DPS);
        this.DPS = Total_DPS;
        this.EHP = Total_EHP;
    }

    /*
     * This is for the GUI
     */
    public DefaultListModel getshiplist() {
        DefaultListModel Model = new DefaultListModel();
        
        for(int i = 0; i < this.Fleet_Members.size();i++)
        {
            Model.setElementAt(this.Fleet_Members.get(i).toString(), i);
        }
        System.out.print("\nDone Importing ships to Model");
        return Model;
    }

    public Fleet_Ship getShip(String line) throws IOException {
        double ShipDPS = 0;
        double ShipEHP = 0;
        String linereader;
String readout;

                readout = null;
                
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new FileReader("fits/" + line + "_fit.tyrfit"));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(BuildFleet_Window.class.getName()).log(Level.SEVERE, null, ex);
                }

                
                    int i = -1;
                    while ((linereader = reader.readLine()) != null) {
                        i++;
                        switch (i) {
                            case 0:
                                //Console.append(linereader + "\n");
                                break;
                            case 1:
                                ShipDPS = Double.parseDouble(linereader);
                                break;
                            case 2:
                                ShipEHP = Double.parseDouble(linereader);
                                break;
                        }
                    }
        

                    /*
                     * 
                     */
        Fleet_Ship ship = new Fleet_Ship(line,ShipDPS,ShipEHP,ShipSig,ShipSpeed,ShipAgility,ShipShieldRes,ShipArmorRes,ShipStructureRes,ShipShieldHealth,ShipArmorHealth,ShipStructureHealth, 
                                         tracking, gunduration,  Turret,  gunreloadtime, GEMd, GThD, GKiD, GExD,  TurretSignature,  TurretOptimal,  TurretFalloff,  capacitor_needed,
                                         MissileDPS, MissileDuration,  ExplosionRadius,  MissileVelocity,  FlightTime,  MEMD,  MThD,  MKiD, MExD);
        System.out.println(line);
        System.out.println(ship.Shipguns); //Print out stats relating to our beloved ships' Guns and Missile stats
        System.out.println(ship.Shipmissile);
        System.out.println(ship.EHP);
        
        
        return ship;
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
