/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test_tyrannosphere;

import test_tyrannosphere.gui.MainMenu;

/**
 *
 * @author Sajuuk
 */
public class TEST_Tyrannosphere {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        
        MainMenu StartofProgram = new MainMenu();
        
        
        double[] resistA= {50,50,50,50},resistB = {50,50,50,50},resistC = {50,50,50,50};
        Fleet Fleet_A;
        Fleet_A = new Fleet("Red");
        //Add Some Rifters
        Fleet_Ship LongDong = new Fleet_Ship(500, 500, "Longdong", Fleet_A, resistA , resistB ,resistC, 500, 500, 500, 500, 1200, 0.18);


        Fleet_A.Print_Fleet_Members();

        Fleet_A.Print_Fleet_Stats();

        //Fleet Fleet_B;
        //Fleet_B = new Fleet("Blue");
//        Fleet_Ship Slash1 = new Fleet_Ship(150, 2500, "Newbro Slasher", Fleet_B);

        //Add Some Slashers

        //Fleet_B.Print_Fleet_Members();
        //Fleet_B.Print_Fleet_Stats();

        //Battlesphere Tyranosphere = new Battlesphere(Fleet_A, Fleet_B);

    }
}
