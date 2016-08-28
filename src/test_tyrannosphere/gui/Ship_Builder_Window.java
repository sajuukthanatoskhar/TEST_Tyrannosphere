/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test_tyrannosphere.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Sajuuk
 */
public class Ship_Builder_Window extends JFrame implements ActionListener{

    
    JTextField Name_of_Fit, DPS,EHP,ShResEM,ShResTh,ShResKi,ShResEx,ArResEM,ArResTh,ArResKi,ArResEx,HuRes;
    JLabel Name, DPS_L,EHP_L,Signature_L,ShResEM_L,ShResTh_L,ShResKi_L,ShResEx_L,ArResEM_L,ArResTh_L,ArResKi_L,ArResEx_L,HuRes_L;
    JPanel FleetStatsPanel,GunMissileStatsPanel;
    JButton Okay,Apply;
    JTextArea Console;
    JTextField Signature;
    JLabel WeaponName_L,WeaponFalloff_L,WeaponFireRate_L,WeaponOptimal,WeaponSignature_L,WeaponTrackingSpeed_L;
    
    //TODO: Needs Guns,Missiles, Need Presets for them (Ammo)

    JButton MissileAmmoSet,GunAmmoSet;
    JButton GunsMissileOkay; //This button should lock out the 
    JTextField tracking_text,duration_text,turretDPS_text,reloadtime_text,EMD_text,ThD_text,KiD_text,ExD_text,turretsignature_text,turretoptimal_text,turretfalloff_text,capacitor_needed_text;
    JLabel tracking_label,duration_label,turretDPS_label,reloadtime_label,EMD_label,ThD_label,KiD_label,ExD_label,turretsignature_label,turretoptimal_label,turretfalloff_label,capacitor_needed_label;
    JTextField MissileDPS_text,MissileDuration_text,MissileExplosionRadius_text,MissileVelocity_text,MissileFlightTime_text, MEMD_text,MThD_text,MKiD_text,MExD_text;
    JLabel MissileDPS_label,MissileDuration_label,MissileExplosionRadius_label,MissileVelocity_label,MissileFlightTime_label, MEMD_label,MThD_label,MKiD_label,MExD_label;
    JLabel MissilePanelLabel,TurretPanelLabel;
    JPanel MissileSection, GunSection;
    
    public Ship_Builder_Window() {
        Name_of_Fit = new JTextField("Text Name");
        DPS = new JTextField("Some Number");
        EHP = new JTextField("Some NUmber");
        Name = new JLabel("Name of Fit");
        DPS_L = new JLabel("DPS of Ship");  //THis will be made obselete
        EHP_L = new JLabel("EHP of Ship");
        ShResEM_L = new JLabel("Shield EM");
        ShResTh_L = new JLabel("Shield Thermal");
        ShResKi_L = new JLabel("Shield Kinetic");
        ShResEx_L = new JLabel("Shield Explosive");
        ArResEM_L = new JLabel("Armor EM");
        ArResTh_L = new JLabel("Armor Thermal");
        ArResKi_L = new JLabel("Armor Kinetic");
        ArResEx_L = new JLabel("Armor Explosive");
        HuRes_L = new JLabel("Hull Resistances");
        ShResEM = new JTextField("Some Number");
        ShResKi = new JTextField("Some Number");
        ShResTh = new JTextField("Some Number");
        ShResEx = new JTextField("Some Number");
        ArResEM = new JTextField("Some Number");
        ArResTh = new JTextField("Some Number");
        ArResKi = new JTextField("Some Number");
        ArResEx = new JTextField("Some Number");
        HuRes = new JTextField("Some Number");
        Signature = new JTextField("Some Number");
        Signature_L = new JLabel("Signature");
        FleetStatsPanel = new JPanel();
        GunMissileStatsPanel =  new JPanel();
        Console = new JTextArea();
        Okay = new JButton("Confirm Ship");
        Okay.setPreferredSize(new Dimension(140,50));
        Apply = new JButton("Apply");
        Apply.setVisible(true);
        Apply.addActionListener(this);
        
        
        
        FleetStatsPanel.add(Name);
        FleetStatsPanel.add(Name_of_Fit);
        FleetStatsPanel.add(DPS_L);
        FleetStatsPanel.add(DPS);
        FleetStatsPanel.add(EHP_L);
        FleetStatsPanel.add(EHP);
        FleetStatsPanel.add(Signature_L);
        FleetStatsPanel.add(Signature);
        FleetStatsPanel.add(ShResEM_L);
        FleetStatsPanel.add(ShResEM);
        FleetStatsPanel.add(ShResTh_L);
        FleetStatsPanel.add(ShResTh);
        FleetStatsPanel.add(ShResKi_L);
        FleetStatsPanel.add(ShResKi);
        FleetStatsPanel.add(ShResEx_L);
        FleetStatsPanel.add(ShResEx);
        FleetStatsPanel.add(ArResEM_L);
        FleetStatsPanel.add(ArResEM);
        FleetStatsPanel.add(ArResTh_L);
        FleetStatsPanel.add(ArResTh);
        FleetStatsPanel.add(ArResKi_L);
        FleetStatsPanel.add(ArResKi);
        FleetStatsPanel.add(ArResEx_L);
        FleetStatsPanel.add(ArResEx);
        FleetStatsPanel.add(HuRes_L);
        FleetStatsPanel.add(HuRes);
        
        
        
        
        FleetStatsPanel.setLayout(new GridLayout(0,1));
        FleetStatsPanel.setVisible(true);
        Console.setVisible(true);
        Okay.setVisible(true);
                
        Okay.addActionListener(this);
        
        Console.setEnabled(false);
        //GunMissileStats Panel
        JPanel GunMissileStatsPanel = new JPanel();

        //Missile Section
        JPanel MissileSection = new JPanel();
        MissileSection.setLayout(new GridLayout(10,1));
        /*
         * Include
         *     JTextField MissileDPS_text,MissileDuration_text,MissileExplosionRadius_text,MissileVelocity_text,MissileFlightTime_text, MEMD_text,MThD_text,MKiD_text,MExD_text;
         *     JLabel MissileDPS_label,MissileDuration_label,MissileExplosionRadius_label,MissileVelocity_label,MissileFlightTime_label, MEMD_label,MThD_label,MKiD_label,MExD_label;
         */
        
        //Gun Section
        JPanel GunSection = new JPanel();

        GunSection.setLayout(new GridLayout(10,2));
         /*
         * Include
         * 
         *     JLabel tracking_label,duration_label,turretDPS_label,reloadtime_label,EMD_label,ThD_label,KiD_label,ExD_label,turretsignature_label,turretoptimal_label,turretfalloff_label,capacitor_needed_label;
         */
            JTextField tracking_text = new JTextField("Text goes here");
            JTextField duration_text = new JTextField("Text goes here");
            JTextField turretDPS_text = new JTextField("Text goes here");
            JTextField reloadtime_text = new JTextField("Text goes here");
            JTextField EMD_text = new JTextField("Text goes here");
            JTextField ThD_text = new JTextField("Text goes here");
            JTextField KiD_text = new JTextField("Text goes here");
            JTextField ExD_text = new JTextField("Text goes here");
            JTextField turretsignature_text = new JTextField("Text goes here");
            JTextField turretoptimal_text = new JTextField("Text goes here");
            JTextField turretfalloff_text = new JTextField("Text goes here");
            JTextField capacitor_needed_text = new JTextField("Text goes here");

            JLabel tracking_label = new JLabel("Text goes here");
            JLabel duration_label = new JLabel("Text goes here");
            JLabel turretDPS_label = new JLabel("Text goes here");
            JLabel reloadtime_label = new JLabel("Text goes here");
            JLabel EMD_label = new JLabel("Text goes here");
            JLabel ThD_label = new JLabel("Text goes here");
            JLabel KiD_label = new JLabel("Text goes here");
            JLabel ExD_label = new JLabel("Text goes here");
            JLabel turretsignature_label = new JLabel("Text goes here");
            JLabel turretoptimal_label = new JLabel("Text goes here");
            JLabel turretfalloff_label = new JLabel("Text goes here");
            JLabel capacitor_needed_label = new JLabel("Text goes here");

            GunSection.add(tracking_label);
            GunSection.add(tracking_text);
            GunSection.add(duration_label);
            GunSection.add(duration_text);
            GunSection.add(turretDPS_label);
            GunSection.add(turretDPS_text);
            GunSection.add(reloadtime_label);
            GunSection.add(reloadtime_text);
            GunSection.add(EMD_label);
            GunSection.add(EMD_text);
            GunSection.add(ThD_label);
            GunSection.add(ThD_text);
            GunSection.add(KiD_label);
            GunSection.add(KiD_text);
            GunSection.add(ExD_label);
            GunSection.add(ExD_text);
            GunSection.add(turretsignature_label);
            GunSection.add(turretsignature_text);
            GunSection.add(turretoptimal_label);
            GunSection.add(turretoptimal_text);
            GunSection.add(turretfalloff_label);
            GunSection.add(turretfalloff_text);
            GunSection.add(capacitor_needed_label);
            GunSection.add(capacitor_needed_text);        
        
            GunMissileStatsPanel.add(new JScrollPane(GunSection));
            GunMissileStatsPanel.add(new JScrollPane(MissileSection));
            GunMissileStatsPanel.setLayout(new GridLayout (3,0));
            GunMissileStatsPanel.add(MissileSection);
            GunMissileStatsPanel.add(GunSection);
        this.add(FleetStatsPanel);
        this.add(GunMissileStatsPanel);
       // this.add(Console);
        this.add(Apply);
        this.add(Okay);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension (600, 800));
        this.setLayout(new GridLayout(4,4));
        this.setVisible(true);
    }
    
    public void ActionListener()
    {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Okay)
        {
            File Fleetfile = new File("fits/"+Name_of_Fit.getText() + "_fit.tyrfit");
            try {
                FileOutputStream writer = new FileOutputStream(Fleetfile);
                OutputStreamWriter osw = new OutputStreamWriter(writer);
                Writer w = new BufferedWriter(osw);
                w.write(Name_of_Fit.getText() +"\n");
                w.write(DPS.getText()+"\n");
                w.write(EHP.getText());
                w.close();
            } catch (IOException ex) {
            }
            this.dispose();
        }
                if(e.getSource() == Apply)
        {
            File Fleetfile = new File("fits/"+Name_of_Fit.getText() + "_fit.tyrfit");
            try {
                FileOutputStream writer = new FileOutputStream(Fleetfile);
                OutputStreamWriter osw = new OutputStreamWriter(writer);
                Writer w = new BufferedWriter(osw);
                w.write(Name_of_Fit.getText() +"\n");
                w.write(DPS.getText()+"\n");
                w.write(EHP.getText());
                w.close();
            } catch (IOException ex) {
            }

        }
    }
}
