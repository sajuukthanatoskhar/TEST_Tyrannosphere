/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test_tyrannosphere;

/*
 * This class is for our ships
 */
public class Fleet_Ship extends EVEObject {

    private String Ship_Fleet;
    private double  Agility,
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