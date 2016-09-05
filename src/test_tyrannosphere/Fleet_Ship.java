/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test_tyrannosphere;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import test_tyrannosphere.gui.BuildFleet_Window;

/*
 * This class is for our ships
 */
public class Fleet_Ship extends EVEObject {

    private Fleet Ship_Fleet;
    private double Agility,
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
    private double EHP;

    private double position[];
    
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
       We include the fleet it will be joining, in addition to the fit
     */
    public Fleet_Ship(String FitName, Fleet OwnedFleet) throws FileNotFoundException {

        this.setShip_Fleet(OwnedFleet);
        this.setName(FitName);
        String line = FitName;

        BufferedReader reader = new BufferedReader(new FileReader("fits/" + line + "_fit.tyrfit"));

        //Reading stuff from file, line by line until EOF
        try {
            int j = -1;
            //This is the line reader for the EHP and DPS for the fit files
            while ((line = reader.readLine()) != null) {
                j++;
                switch (j) {
                    case 0:
                        //agility = Double.parseDouble(line);
                        break;
                    case 1:
                        //ArmorEM = Double.parseDouble(line);
                        break;
                    case 2:
                        //ArmorExplosive = Double.parseDouble(line);
                        break;
                    case 3:
                        ArmorHitpoints = Double.parseDouble(line);
                        break;
                    case 4:
                        //ArmorKinetic = Double.parseDouble(line);
                        break;
                    case 5:
                        //ArmorThermal = Double.parseDouble(line);
                        break;
                    case 6:
                        //CapRechTime = Double.parseDouble(line);
                        break;
                    case 7:
                        //Capacitor = Double.parseDouble(line);
                        break;
                    case 8:
                        DPS = Double.parseDouble(line);
                        break;
                    case 9:
                        //Weapon_Falloff = Double.parseDouble(line);
                        break;
                    case 10:
                        //ShipName = line;
                        break;
                    case 11:
                        //Weapon_Optimal = Double.parseDouble(line);
                        break;
                    case 12:
                        ShieldAmount = Double.parseDouble(line);
                        break;
                    case 13:
                        //ShieldEM = Double.parseDouble(line);
                        break;
                    case 14:
                        //ShieldExplosive = Double.parseDouble(line);
                        break;
                    case 15:
                        //ShieldKinetic = Double.parseDouble(line);
                        break;
                    case 16:
                        //ShieldRechTime = Double.parseDouble(line);
                        break;
                    case 17:
                        //ShieldThermal = Double.parseDouble(line);
                        break;
                    case 18:
                        ShipClass = line;
                        break;
                    case 19:
                        //SignatureRadius = Double.parseDouble(line);
                        break;
                    case 20:
                        StructureAmount = Double.parseDouble(line);
                        break;
                    case 21:
                        //Weapon_Signature = Double.parseDouble(line);
                        break;
                    case 22:
                        //Warpspeed = Double.parseDouble(line);
                        break;
                }
            }
            this.setDPS(DPS);
            this.EHP = ShieldAmount + ArmorHitpoints + StructureAmount / 0.6666666;
        } catch (IOException ex) {
            Logger.getLogger(BuildFleet_Window.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Fleet getShip_Fleet() {
        return Ship_Fleet;
    }

    public void setShip_Fleet(Fleet Ship_Fleet) {
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

    public double getAgility() {
        return Agility;
    }

    public void setAgility(double Agility) {
        this.Agility = Agility;
    }

    public double getArmorEM() {
        return ArmorEM;
    }

    public void setArmorEM(double ArmorEM) {
        this.ArmorEM = ArmorEM;
    }

    public double getArmorExplosive() {
        return ArmorExplosive;
    }

    public void setArmorExplosive(double ArmorExplosive) {
        this.ArmorExplosive = ArmorExplosive;
    }

    public double getArmorHitpoints() {
        return ArmorHitpoints;
    }

    public void setArmorHitpoints(double ArmorHitpoints) {
        this.ArmorHitpoints = ArmorHitpoints;
    }

    public double getArmorKinetic() {
        return ArmorKinetic;
    }

    public void setArmorKinetic(double ArmorKinetic) {
        this.ArmorKinetic = ArmorKinetic;
    }

    public double getArmorThermal() {
        return ArmorThermal;
    }

    public void setArmorThermal(double ArmorThermal) {
        this.ArmorThermal = ArmorThermal;
    }

    public double getCapRechTime() {
        return CapRechTime;
    }

    public void setCapRechTime(double CapRechTime) {
        this.CapRechTime = CapRechTime;
    }

    public double getCapacitor() {
        return Capacitor;
    }

    public void setCapacitor(double Capacitor) {
        this.Capacitor = Capacitor;
    }

    public double getDPS() {
        return DPS;
    }

    public void setDPS(double DPS) {
        this.DPS = DPS;
    }

    public double getFallOff() {
        return FallOff;
    }

    public void setFallOff(double FallOff) {
        this.FallOff = FallOff;
    }

    public double getOptimal() {
        return Optimal;
    }

    public void setOptimal(double Optimal) {
        this.Optimal = Optimal;
    }

    public double getShieldAmount() {
        return ShieldAmount;
    }

    public void setShieldAmount(double ShieldAmount) {
        this.ShieldAmount = ShieldAmount;
    }

    public double getShieldEM() {
        return ShieldEM;
    }

    public void setShieldEM(double ShieldEM) {
        this.ShieldEM = ShieldEM;
    }

    public double getShieldExplosive() {
        return ShieldExplosive;
    }

    public void setShieldExplosive(double ShieldExplosive) {
        this.ShieldExplosive = ShieldExplosive;
    }

    public double getShieldKinetic() {
        return ShieldKinetic;
    }

    public void setShieldKinetic(double ShieldKinetic) {
        this.ShieldKinetic = ShieldKinetic;
    }

    public double getShieldRechTime() {
        return ShieldRechTime;
    }

    public void setShieldRechTime(double ShieldRechTime) {
        this.ShieldRechTime = ShieldRechTime;
    }

    public double getShieldThermal() {
        return ShieldThermal;
    }

    public void setShieldThermal(double ShieldThermal) {
        this.ShieldThermal = ShieldThermal;
    }

    public double getSigRad() {
        return SigRad;
    }

    public void setSigRad(double SigRad) {
        this.SigRad = SigRad;
    }

    public double getStructureAmount() {
        return StructureAmount;
    }

    public void setStructureAmount(double StructureAmount) {
        this.StructureAmount = StructureAmount;
    }

    public double getTSig() {
        return TSig;
    }

    public void setTSig(double TSig) {
        this.TSig = TSig;
    }

    public double getWarpSpeed() {
        return WarpSpeed;
    }

    public void setWarpSpeed(double WarpSpeed) {
        this.WarpSpeed = WarpSpeed;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getShipClass() {
        return ShipClass;
    }

    public void setShipClass(String ShipClass) {
        this.ShipClass = ShipClass;
    }

    public double getEHP() {
        this.EHP = this.getShieldAmount() + this.getArmorHitpoints() + this.getStructureAmount() / 0.6666666;
        return EHP;
    }

    public void setEHP(double EHP) {
        this.EHP = EHP;
    }

    public double[] getPosition() {
        return position;
    }

    public void setPosition(double[] position) {
        this.position = position;
    }

    public Gun getShipguns() {
        return Shipguns;
    }

    public void setShipguns(Gun Shipguns) {
        this.Shipguns = Shipguns;
    }

    public MissileLauncher getShipmissile() {
        return Shipmissile;
    }

    public void setShipmissile(MissileLauncher Shipmissile) {
        this.Shipmissile = Shipmissile;
    }
}
