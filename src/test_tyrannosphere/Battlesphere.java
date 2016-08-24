/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test_tyrannosphere;

/**
 *
 * @author Sajuuk
 */
public class Battlesphere {

    private Fleet Alpha;
    private Fleet Omega;

    public Fleet getAlpha() {
        return Alpha;
    }

    public void setAlpha(Fleet Alpha) {
        this.Alpha = Alpha;
    }

    public Fleet getOmega() {
        return Omega;
    }

    public void setOmega(Fleet Omega) {
        this.Omega = Omega;
    }

    public Battlesphere(Fleet A, Fleet B) {
        setAlpha(A);
        setOmega(B);

        Battle_Resolution();

    }

    public void Battle_Resolution() {

        double AlphaEHP, OmegaEHP;

        AlphaEHP = getAlpha().getEHP();
        OmegaEHP = getOmega().getEHP();

        System.out.print("\nEntering Battlesphere\n" + getOmega().getDPS() + "\n" + getAlpha().getDPS() + "\n");



        while (AlphaEHP > 0 && OmegaEHP > 0) {
            AlphaEHP = AlphaEHP - (double) getOmega().getDPS();
            OmegaEHP = OmegaEHP - (double) getAlpha().getDPS();

            //Oh no, what about logistics, Sajuuk?
            //Damage distribution?

            //Primary a ship or have at it?
        }

        if (AlphaEHP <= 0) {
            System.out.print("\nOmega Wins with " + OmegaEHP + "  hit points left");
        } else if (OmegaEHP <= 0) {
            System.out.print("\nAlpha Wins with " + AlphaEHP + "  hit points left");
        } else {
            System.out.print("\nError");
        }
    }
}
