/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test_tyrannosphere;

import test_tyrannosphere.gui.Ship_Builder_Window;

/*
 * This class is for our ships
 */
public class Fleet_Ship {

    private String Ship_Fleet;
    double EHP, DPS, signature, speed, agility;
    double ShieldRes[], ArmorRes[], StructureRes[];
    double Shield, Armor, Structure;
    Gun Shipguns;
    MissileLauncher Shipmissile;
    
    
    /*
     * Initialiser for ship objects 
     */
    public Fleet_Ship(String FitName,double DPS,double EHP,double signature,double speed,double agility,double ShieldRes[], double ArmorRes[], double StructureRes[], double Shield, double Armor,double Structure,
                      double tracking, double gunduration, double Turret, double gunreloadtime,double GEMd,double GThD,double GKiD,double GExD, double TurretSignature, double TurretOptimal, double TurretFalloff, double capacitor_needed,
                      double MissileDPS,double MissileDuration, double ExplosionRadius, double MissileVelocity, double FlightTime, double MEMD, double MThD, double MKiD,double MExD)
    {

        this.EHP = EHP;
        this.signature = signature;
        this.speed = speed;
        this.agility = agility;
        this.ShieldRes = ShieldRes;
        this.ArmorRes = ArmorRes;
        this.StructureRes = StructureRes;
        this.Shield = Shield;
        this.Armor = Armor; 
        this.Structure = Structure;
        /*
         * If the ship uses a combination of both, the program allows for that, but not for different combinations of guns or missile launchers (this is dumb)
         */     
        this.Shipguns = new Gun(tracking, gunduration, Turret, gunreloadtime, GEMd, GThD, GKiD, GExD, TurretSignature, TurretOptimal, TurretFalloff, capacitor_needed); 
        this.Shipmissile = new MissileLauncher(MissileDPS, MissileDuration, ExplosionRadius, MissileVelocity, FlightTime, MEMD, MThD, MKiD, MExD);
        
        setShip_Fleet(FitName);

        //Adding to Fleet
        //AssociatedFleet.Fleet_Members.add(this);
        //AssociatedFleet.update();
    }
    /*
     * Dead Code, subject to deletion
     */
    public Fleet_Ship(double A, double B, String FitName, Fleet AssociatedFleet, double[] Shield_Resistances,double[] Armor_Resistances ,double[] Structure_Resistances,double shield,double armor,double structure,double signature,double speed,double agility) 
    {
        setShield(Shield);
        setShieldRes(ShieldRes);
        setArmor(Armor);
        setArmorRes(ArmorRes);
        setStructure(Structure);
        setStructureRes(StructureRes);
        
        
        setDPS(A);
        setEHP(B);
        setShip_Fleet(FitName);

        //Adding to Fleet
        AssociatedFleet.Fleet_Members.add(this);
        AssociatedFleet.update();
    }

    public String getShip_Fleet() {
        return Ship_Fleet;
    }

    public void setShip_Fleet(String Ship_Fleet) {
        this.Ship_Fleet = Ship_Fleet;
    }

    public double getEHP() {
        return EHP;
    }

    public void setEHP(double EHP) {
        this.EHP = EHP;
    }

    public double getDPS() {
        return DPS;
    }

    public void setDPS(double DPS) {
        this.DPS = DPS;
    }

    public double getSignature() {
        return signature;
    }

    public void setSignature(double signature) {
        this.signature = signature;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getAgility() {
        return agility;
    }

    public void setAgility(double agility) {
        this.agility = agility;
    }

    public double[] getShieldRes() {
        return ShieldRes;
    }

    public void setShieldRes(double[] ShieldRes) {
        this.ShieldRes = ShieldRes;
    }

    public double[] getArmorRes() {
        return ArmorRes;
    }

    public void setArmorRes(double[] ArmorRes) {
        this.ArmorRes = ArmorRes;
    }

    public double[] getStructureRes() {
        return StructureRes;
    }

    public void setStructureRes(double[] StructureRes) {
        this.StructureRes = StructureRes;
    }

    public double getShield() {
        return Shield;
    }

    public void setShield(double Shield) {
        this.Shield = Shield;
    }

    public double getArmor() {
        return Armor;
    }

    public void setArmor(double Armor) {
        this.Armor = Armor;
    }

    public double getStructure() {
        return Structure;
    }

    public void setStructure(double Structure) {
        this.Structure = Structure;
    }
}
