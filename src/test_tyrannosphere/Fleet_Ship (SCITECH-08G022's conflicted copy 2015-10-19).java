/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test_tyrannosphere;

/*
 * This class is for our ships
 */
public class Fleet_Ship {

    private String Ship_Fleet;
    double EHP, DPS, signature, speed, agility;
    double ShieldRes[], ArmorRes[], StructureRes[];
    double Shield, Armor, Structure;

    public Fleet_Ship(double DPS,double EHP)
    {
        this.DPS = DPS;
        this.EHP = EHP;
    }
    
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
