/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test_tyrannosphere;

/**
 *
 * @author Sajuuk
 */
public class MissileLauncher {
    
    private double DPS, Range, Duration, ExplosionRadius, Velocity, FlightTime, EMD,ThD,KiD,ExD;

    public MissileLauncher(double DPS, double Duration, double ExplosionRadius, double Velocity, double FlightTime, double EMD, double ThD, double KiD, double ExD) {
        this.DPS = DPS;
        this.Duration = Duration;
        this.ExplosionRadius = ExplosionRadius;
        this.Velocity = Velocity;
        this.FlightTime = FlightTime;
        this.EMD = EMD;
        this.ThD = ThD;
        this.KiD = KiD;
        this.ExD = ExD;
        this.Range = Velocity*FlightTime;
    }

    public double getDPS() {
        return DPS;
    }

    public void setDPS(double DPS) {
        this.DPS = DPS;
    }

    public double getRange() {
        return Range;
    }

    public void setRange(double Range) {
        this.Range = Range;
    }

    public double getDuration() {
        return Duration;
    }

    public void setDuration(double Duration) {
        this.Duration = Duration;
    }

    public double getExplosionRadius() {
        return ExplosionRadius;
    }

    public void setExplosionRadius(double ExplosionRadius) {
        this.ExplosionRadius = ExplosionRadius;
    }

    public double getVelocity() {
        return Velocity;
    }

    public void setVelocity(double Velocity) {
        this.Velocity = Velocity;
    }

    public double getFlightTime() {
        return FlightTime;
    }

    public void setFlightTime(double FlightTime) {
        this.FlightTime = FlightTime;
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
    
    
    
}
