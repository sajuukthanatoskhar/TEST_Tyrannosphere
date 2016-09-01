/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test_tyrannosphere.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import test_tyrannosphere.Fleet;

/**
 *
 * @author Sajuuk
 */
public class BuildFleet_Window extends JFrame implements ActionListener {

    JFrame Build_Menu_Window;
    JButton Add_Ship, Remove_Ship, Rename_Fleet;
    JPanel Button_Panel;
    JTextArea Console;
    JList Available_Fits, Current_Fleet;
    JComboBox<Fleet> Fleet_Drop_List;
    JButton Save_Fleet;
    JButton Remove_Fleet;
    DefaultListModel Fits, Fleet_Fit_lists;
    JScrollPane A_Fits_Scroll, Current_Fleet_Scroll;
    JButton Okay;
    String name_changed_to;
    JTextField Name_Field;
    JButton Fleet_Statistics;
    String Renamed_Fleet;
    String Fits_List[];
    private double ArmorExplosive;
    private double agility;
    private double ArmorEM;
    private double ArmorHitpoints;
    private double ArmorKinetic;
    private double ArmorThermal;
    private double CapRechTime;
    private double Capacitor;
    private double DPS;
    private double Weapon_Falloff;
    private String ShipName;
    private double Weapon_Optimal;
    private double ShieldAmount;
    private double ShieldEM;
    private double ShieldExplosive;
    private double ShieldKinetic;
    private double ShieldRechTime;
    private double ShieldThermal;
    private String ShipClass;
    private double SignatureRadius;
    private double StructureAmount;
    private double Weapon_Signature;
    private double Warpspeed;

    public BuildFleet_Window() {
        A_Fits_Scroll = new JScrollPane();
        Renamed_Fleet = new String();
        Current_Fleet_Scroll = new JScrollPane();
        DefaultListModel demoList = new DefaultListModel();
        Fleet_Fit_lists = new DefaultListModel();
        Save_Fleet = new JButton("Save Selected Fleet to Disk");
        Remove_Fleet = new JButton("Remove Selected Fleet from memory");
        Fleet_Drop_List = new JComboBox<>();
        Console = new JTextArea("Terminal Console v1");
        Console.setPreferredSize(new Dimension(300, 400));
        Fleet_Statistics = new JButton("Report Fleet Statistics");
        Name_Field = new JTextField();
        Name_Field.setSize(300, 150);
        Name_Field.setVisible(true);

        Save_Fleet.addActionListener(this);
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(700, 800));
        GridBagConstraints c = new GridBagConstraints();

        Add_Ship = new JButton("Add Ship");
        Remove_Ship = new JButton("Remove Ship");
        Rename_Fleet = new JButton("Rename Fleet");
        Button_Panel = new JPanel();

        Add_Ship.addActionListener(this);

        Button_Panel.setLayout(new GridLayout(4, 2));
        Button_Panel.add(Add_Ship);
        Button_Panel.add(Remove_Ship);

        Button_Panel.add(Fleet_Drop_List);
        Button_Panel.add(Save_Fleet);
        Button_Panel.add(Remove_Fleet);
        Button_Panel.add(Rename_Fleet);
        Button_Panel.setVisible(true);

        Rename_Fleet.addActionListener(this);

        /*
         * Button Panels Location
         */
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.NORTHWEST;

        Button_Panel.setBorder(BorderFactory.createEtchedBorder());

        this.add(Button_Panel, c);
        this.setName("Build Fleet");
        this.setSize(300, 300);

        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridx = 0;
        c.gridy = 2;

        this.add(Console, c);
        Console.setEnabled(false);
        this.setMinimumSize(new Dimension(725, 600));
        this.setVisible(true);

        Remove_Ship.addActionListener(this);

        Console.setLineWrap(true);
        JPanel Fits_List_Panel = new JPanel();
        Fits_List_Panel.setBorder(BorderFactory.createTitledBorder("Available Fits"));
//        Fits_List_Panel.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        JPanel Fleet_List_Panel = new JPanel();
//        Fleet_List_Panel.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        Fleet_List_Panel.setBorder(BorderFactory.createTitledBorder("Current Fleet Fit"));

        Fits = new DefaultListModel();

        fill_fleet();
//        for (int i = 0; i < Fits_List.length; i++) {
//            Fits.addElement(Fits_List[i]);
//        }

        Available_Fits = new JList(Fits);
        Available_Fits.setFixedCellHeight(140);
        Available_Fits.setFixedCellHeight(20);
        Available_Fits.setVisibleRowCount(10);

        Available_Fits.setVisible(true);

        c.gridx = 3;
        c.gridy = 1;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridheight = GridBagConstraints.VERTICAL;
        Fits_List_Panel.add(Available_Fits);
        //this.add(Fits_List_Panel, c);

        Current_Fleet = new JList(Fleet_Fit_lists);
        Current_Fleet.setFixedCellHeight(20);
        Current_Fleet.setFixedCellWidth(140);
        Current_Fleet.setVisibleRowCount(10);
        Current_Fleet.add(Current_Fleet_Scroll);
        Current_Fleet.setVisible(true);

        //TODO: What does this do Sajuuk?
        Fleet_List_Panel.add(Current_Fleet);
        Fleet_List_Panel.setVisible(true);
        this.add(new JScrollPane(Available_Fits), c);

        c.gridx = 4;
        this.add(new JScrollPane(Current_Fleet), c);
        //this.add(Fleet_List_Panel, c);

        set_mouselistener();

        Button_Panel.add(Name_Field);
        Fleet_Statistics.addActionListener(this);
        Button_Panel.add(Fleet_Statistics);
        Fleet_Statistics.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {
            if (e.getSource() == Add_Ship) {
                Console.append("\n$Ship Added: " + Available_Fits.getSelectedValue().toString());
                int i = 0;

                int fromindex = Available_Fits.getSelectedIndex();
                Object from = Available_Fits.getSelectedValue();

                Fleet_Fit_lists.addElement(from);
            }
        } catch (NullPointerException NPE) {
            Console.append("\nError!!! Click a fleet fitting!");
            Console.append("\nError Ship_Fleet 1 : Null Pointer Exception");
            System.out.print("\007");
        }
        try {
            if (e.getSource() == Remove_Ship) {
                Console.append("\n" + Current_Fleet.getSelectedValue().toString() + " Removed");
                int i = 0;

                int fromindex = Current_Fleet.getSelectedIndex();
                Object from = Current_Fleet.getSelectedValue();

                Fleet_Fit_lists.removeElementAt(fromindex);
                Current_Fleet.setSelectedIndex(fromindex - 1);

            }
        } catch (NullPointerException NPE) {
            Console.append("\nError!!! Click a fleet fitting!");
            Console.append("\nError Ship_Fleet 1 : Null Pointer Exception");
            System.out.print("\007");
        }

        if (e.getSource() == Rename_Fleet) {
            String Renamed_Fleet = Name_Field.getText();
            Console.append("\n Renaming! Fleet name is now " + Renamed_Fleet);

        }
        if (e.getSource() == Fleet_Statistics) {
            Renamed_Fleet = Name_Field.getText();
            Console.setText("");  //Clear
            /*
             * This part requires pulling out the EHP, DPS values of the fleet
             */
            double total_DPS = 0, total_EHP = 0;
            for (int i = 0; i < Current_Fleet.getLastVisibleIndex() + 1; i++) {
                //Access the relevant file
                String readout;
                readout = null;
                Console.setText("");
                BufferedReader reader = null;
                System.out.print(Fleet_Fit_lists.getElementAt(i).toString());
                try {
                    reader = new BufferedReader(new FileReader("fits/" + Fleet_Fit_lists.getElementAt(i).toString() + "_fit.tyrfit"));

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(BuildFleet_Window.class.getName()).log(Level.SEVERE, null, ex);
                }
                String line = null;
                try {
                    int j = -1;
                    //This is the line reader for the EHP and DPS for the fit files
                    while ((line = reader.readLine()) != null) {
                        j++;
                        switch (j) {
                            case 0:
                                agility = Double.parseDouble(line);
                                break;
                            case 1:
                                ArmorEM = Double.parseDouble(line);
                                break;
                            case 2:
                                ArmorExplosive = Double.parseDouble(line);
                                break;
                            case 3:
                                ArmorHitpoints = Double.parseDouble(line);
                                break;
                            case 4:
                                ArmorKinetic = Double.parseDouble(line);
                                break;
                            case 5:
                                ArmorThermal = Double.parseDouble(line);
                                break;
                            case 6:
                                CapRechTime = Double.parseDouble(line);
                                break;
                            case 7:
                                Capacitor = Double.parseDouble(line);
                                break;
                            case 8:
                                DPS = Double.parseDouble(line);
                                break;
                            case 9:
                                Weapon_Falloff = Double.parseDouble(line);
                                break;
                            case 10:
                                ShipName = line;
                                break;
                            case 11:
                                Weapon_Optimal = Double.parseDouble(line);
                                break;
                            case 12:
                                ShieldAmount = Double.parseDouble(line);
                                break;
                            case 13:
                                ShieldEM = Double.parseDouble(line);
                                break;
                            case 14:
                                ShieldExplosive = Double.parseDouble(line);
                                break;
                            case 15:
                                ShieldKinetic = Double.parseDouble(line);
                                break;
                            case 16:
                                ShieldRechTime = Double.parseDouble(line);
                                break;
                            case 17:
                                ShieldThermal = Double.parseDouble(line);
                                break;
                            case 18:
                                ShipClass = line;
                                break;
                            case 19:
                                SignatureRadius = Double.parseDouble(line);
                                break;
                            case 20:
                                StructureAmount = Double.parseDouble(line);
                                break;
                            case 21:
                                Weapon_Signature = Double.parseDouble(line);
                                break;
                            case 22:
                                Warpspeed = Double.parseDouble(line);
                                break;
                        }
                        

                    }
                        total_DPS += DPS;
                        total_EHP += ShieldAmount + ArmorHitpoints + StructureAmount/0.6666666;
                } catch (IOException ex) {
                    Logger.getLogger(BuildFleet_Window.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            Console.append("\nFleet " + Renamed_Fleet + " Statistics are as shown:\n\nDPS : " + total_DPS + "\nCombined EHP : " + total_EHP);
//                        Console.append("\nFleet " + Renamed_Fleet + " Statistics are as shown:\n\nDPS : "+ total_DPS +"\nCombined EHP : "+ total_EHP + "\nSmallest EHP: $SmallEHP \nAverage EHP : $AverageEHP\nLogi to Logi RPS : $LogiRPS \nLogi to Ship RPS : $ShipRPS \nLowest Possible Speed : $SlowSpeed");

        }

        if (e.getSource() == Save_Fleet) {
            File Fleetfile = new File("fleets/" + Name_Field.getText().toString() + "_fleet.flt");
            try {

                File f = new File("fleets/");
                if (!f.exists()) {
                    f.mkdir();
                }

                FileOutputStream writer = new FileOutputStream(Fleetfile);
                OutputStreamWriter osw = new OutputStreamWriter(writer);
                Writer w = new BufferedWriter(osw);
                for (int i = 0; i < Fleet_Fit_lists.getSize(); i++) {
                    Current_Fleet.setSelectedIndex(i);
                    w.write(Current_Fleet.getSelectedValue() + "\n");
                }
                w.close();
            } catch (IOException ex) {
            }
        }
    }

    public void fill_fleet() {
        File path = new File("fits/");
        String filename;

        File[] files = path.listFiles();
        Console.setText("Loading files into fleet fittings fits/");
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) { //this line weeds out other directories/folders
                filename = files[i].getName();
                filename = filename.substring(0, filename.indexOf("_fit.tyrfit"));
                //At this point, add the fits to the fleet fittings
                Fits.addElement(filename);
                Console.append("\nAdding " + filename);
            }
        }

    }

    /*
    This activates 
     */
    private void set_mouselistener() {
        Available_Fits.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                String readout;

                readout = null;
                Console.setText("");
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new FileReader("fits/" + Available_Fits.getSelectedValue().toString() + "_fit.tyrfit"));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(BuildFleet_Window.class.getName()).log(Level.SEVERE, null, ex);
                }
                String line = null;

                try {
                    int i = -1;
                    while ((line = reader.readLine()) != null) {
                        i++;
                        switch (i) {
                            case 0:
                                Console.append(line + "\n");
                                break;
                            case 1:
                                Console.append("Total DPS : " + line + "\n");
                                break;
                            case 2:
                                Console.append("Total EHP : " + line + "\n");
                                break;
                        }
                    }
                } catch (IOException ex) {
                    Logger.getLogger(BuildFleet_Window.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
