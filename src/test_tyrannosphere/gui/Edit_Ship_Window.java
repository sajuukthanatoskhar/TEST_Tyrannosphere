/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test_tyrannosphere.gui;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Sajuuk
 */
public class Edit_Ship_Window extends Upgraded_JFrame {
    
    JTextField Name_of_Fit, DPS,EHP,Sig,ShipShResEM,ShipShResTh,ShipShResKi,ShipShResEx,ShipArResEM,ShipArResTh,ShipArResKi,ShipArResEx
            ,ShipStRes,ShipShHp,ShipArHp,ShipStHp;
    JLabel Name, DPS_L,EHP_L,Sig_L,ShipShResEM_L,ShipShResTh_L,ShipShResKi_L,ShipShResEx_L,ShipArResEM_L,ShipArResTh_L,ShipArResKi_L,ShipArResEx_L
            ,ShipStRes_L,ShipShHp_L,ShipArHp_L,ShipStHp_L;
    JPanel FleetStatsPanel;
    JButton Okay;
    JTextArea Console;
    
    public Edit_Ship_Window() {
        Name_of_Fit = new JTextField();
        DPS = new JTextField();
        EHP = new JTextField();
        Name = new JLabel();
        DPS_L = new JLabel();
        EHP_L = new JLabel();
        
        FleetStatsPanel = new JPanel();
        Console = new JTextArea();
        
        FleetStatsPanel.add(Name);
        FleetStatsPanel.add(Name_of_Fit);
        FleetStatsPanel.add(DPS_L);
        FleetStatsPanel.add(DPS);
        FleetStatsPanel.add(EHP_L);
        FleetStatsPanel.add(EHP);
        
        
        FleetStatsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        FleetStatsPanel.setVisible(true);


        
                
        
        this.setSize(300, 300);
        this.setLayout(new GridBagLayout());
        this.setVisible(true);
        
        
        
        
    }
}
