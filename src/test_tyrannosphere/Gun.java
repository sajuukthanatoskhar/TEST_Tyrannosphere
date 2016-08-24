/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test_tyrannosphere;

/**
 *
 * @author garethw
 */
class Gun {
    private double tracking,duration,DPS,reloadtime,EMD,ThD,KiD,ExD,signature,optimal,falloff;
    private double capacitor_needed;
    


    public Gun(double tracking, double duration, double DPS, double reloadtime, double EMD, double ThD, double KiD, double ExD, double signature, double optimal, double falloff, double capacitor_needed) {
        this.tracking = tracking;
        this.duration = duration;
        this.DPS = DPS;
        this.reloadtime = reloadtime;
        this.EMD = EMD;
        this.ThD = ThD;
        this.KiD = KiD;
        this.ExD = ExD;
        this.signature = signature;
        this.optimal = optimal;
        this.falloff = falloff;
        this.capacitor_needed = capacitor_needed;
    }

    /*
     * Constructor for Arties/Autocannon
     */
    public Gun(double tracking, double duration, double DPS, double reloadtime, double EMD, double ThD, double KiD, double ExD, double signature, double optimal, double falloff) {
        this.tracking = tracking;
        this.duration = duration;
        this.DPS = DPS;
        this.reloadtime = reloadtime;
        this.EMD = EMD;
        this.ThD = ThD;
        this.KiD = KiD;
        this.ExD = ExD;
        this.signature = signature;
        this.optimal = optimal;
        this.falloff = falloff;
        this.capacitor_needed = 0;
    }

    
    
    
    public double getTracking() {
        return tracking;
    }

    public void setTracking(double tracking) {
        this.tracking = tracking;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getDPS() {
        return DPS;
    }

    public void setDPS(double DPS) {
        this.DPS = DPS;
    }

    public double getReloadtime() {
        return reloadtime;
    }

    public void setReloadtime(double reloadtime) {
        this.reloadtime = reloadtime;
    }

    public double getEMD() {
        return EMD;
    }

    public void setEMD(double EMD) {
        this.EMD = EMD;
    }

    public double getThD() {
        return ThD;
    }

    public void setThD(double ThD) {
        this.ThD = ThD;
    }

    public double getKiD() {
        return KiD;
    }

    public void setKiD(double KiD) {
        this.KiD = KiD;
    }

    public double getExD() {
        return ExD;
    }

    public void setExD(double ExD) {
        this.ExD = ExD;
    }

    public double getSignature() {
        return signature;
    }

    public void setSignature(double signature) {
        this.signature = signature;
    }

    public double getOptimal() {
        return optimal;
    }

    public void setOptimal(double optimal) {
        this.optimal = optimal;
    }

    public double getFalloff() {
        return falloff;
    }

    public void setFalloff(double falloff) {
        this.falloff = falloff;
    }

    public double getCapacitor_needed() {
        return capacitor_needed;
    }

    public void setCapacitor_needed(double capacitor_needed) {
        this.capacitor_needed = capacitor_needed;
    }
            
    
}
