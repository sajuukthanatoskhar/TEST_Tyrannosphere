/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test_tyrannosphere.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
import test_tyrannosphere.Fleet;
import test_tyrannosphere.Fleet_Ship;

/**
 *
 * @author Sajuuk
 */
public final class Battlesphere_Window extends JFrame implements ActionListener {

    Fleet Alpha, Beta; //Our two fleets
    JPanel Alpha_Fleet_Controls, Beta_Fleet_Controls, Time_Controls, AlphaButton, BetaButton; // Control Panels
    JTextArea ConsoleAlpha, ConsoleBeta, Console_Main;
    JButton MakePrimaryAlpha, MakePrimaryBeta, SelectAlpha, SelectBeta;
    JScrollPane Alpha_Scroll, Time_scroll, ConsoleAlphaScroll, ConsoleBetaScroll;
    JList AlphaList, BetaList;
    JComboBox<String> AlphaComboBox, BetaComboBox;
    JButton One_Second;
    JButton Ten_Seconds;
    DefaultListModel Alpha_Ships, Beta_Ships;
    JScrollPane AlphaList_Scroll, BetaList_Scroll;
    int time; // Battle Timer
    int selectedprimaryforAlpha, selectedprimaryforBeta;

    /*
    Constructs all the components/GUI/alpha/beta fleets
    Initialises battle timer to 0. 
     */
    public Battlesphere_Window() {
        AlphaComboBox = new JComboBox<>();
        BetaComboBox = new JComboBox<>();
        time = 0; //Battle Timer
        Alpha_Fleet_Controls = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Alpha_Ships = new DefaultListModel();
        Beta_Ships = new DefaultListModel();
        AlphaList = new JList(Alpha_Ships);
        BetaList = new JList(Beta_Ships);
        Alpha = new Fleet();
        Beta = new Fleet();
        AlphaList_Scroll = new JScrollPane(AlphaList);
        BetaList_Scroll = new JScrollPane(BetaList);
        Beta_Fleet_Controls = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Time_Controls = new JPanel(new FlowLayout(FlowLayout.CENTER));
        read_fleets();// Read all fleets
//        Alpha_Fleet_Controls.add(AlphaList);
//        Beta_Fleet_Controls.add(BetaList);
        AlphaList.setVisible(true);
        BetaList.setVisible(true);
        AlphaList_Scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        BetaList_Scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        ConsoleAlpha = new JTextArea(5, 30);
        ConsoleBeta = new JTextArea(5, 30);
        Console_Main = new JTextArea(10, 40);
        ConsoleAlphaScroll = new JScrollPane(ConsoleAlpha);
        ConsoleBetaScroll = new JScrollPane(ConsoleBeta);
        Time_scroll = new JScrollPane(Console_Main);
        //Setup vertical scroll bars
        ConsoleAlphaScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        ConsoleBetaScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        Time_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //Setting up different consoles that output to user
        ConsoleAlpha.setSize(300, 600);
        ConsoleBeta.setSize(300, 600);
        Console_Main.setSize(300, 600);
        ConsoleAlpha.setLineWrap(true);
        ConsoleBeta.setLineWrap(true);
        Console_Main.setLineWrap(true);
        Console_Main.setEnabled(false);

        //Setting up font for console for fleet feedback
        Font font = new Font("Verdana", Font.BOLD, 12);
        Console_Main.setFont(font);

        this.setLayout(new FlowLayout(FlowLayout.LEADING));
        Alpha_Fleet_Controls.add(AlphaComboBox);
        Alpha_Fleet_Controls.add(ConsoleAlphaScroll);
        Alpha_Fleet_Controls.setSize(300, 800);
        Beta_Fleet_Controls.setSize(300, 800);
        Time_Controls.setSize(300, 800);
        Time_Controls.add(Time_scroll);

        Beta_Fleet_Controls.add(BetaComboBox);
        Beta_Fleet_Controls.add(ConsoleBetaScroll);
//Adding and disabling consoles and panels
        ConsoleAlpha.setEnabled(false);
        ConsoleBeta.setEnabled(false);
        Time_scroll.setEnabled(false);
        this.add(Alpha_Fleet_Controls);
        Alpha_Fleet_Controls.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(Time_Controls);
        Time_Controls.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(Beta_Fleet_Controls);
        Beta_Fleet_Controls.setBorder(BorderFactory.createLineBorder(Color.black));

        //Buttons go in here
        MakePrimaryAlpha = new JButton("Set Primary for Alpha");
        MakePrimaryBeta = new JButton("Set Primary for Beta");
        SelectAlpha = new JButton("Set Alpha Fleet");
        SelectBeta = new JButton("Set Beta Fleet");
        One_Second = new JButton("1 Second");
        Ten_Seconds = new JButton("10 Seconds");

        Alpha_Fleet_Controls.add(MakePrimaryAlpha);
        Beta_Fleet_Controls.add(MakePrimaryBeta);
        Alpha_Fleet_Controls.add(SelectAlpha);
        Beta_Fleet_Controls.add(SelectBeta);
        Time_Controls.add(One_Second);
        Time_Controls.add(Ten_Seconds);

        //Get a verify crash somewhere in this block
        SelectAlpha.addActionListener(this);
        MakePrimaryAlpha.addActionListener(this);
        SelectBeta.addActionListener(this);
        MakePrimaryBeta.addActionListener(this);
        One_Second.addActionListener(this);
        Ten_Seconds.addActionListener(this);
        Alpha_Fleet_Controls.add(AlphaList_Scroll);
        Beta_Fleet_Controls.add(BetaList_Scroll);

        this.setSize(1200, 500);
        this.setVisible(true);
        add_actionlisteners();

    }

    /*
    Button listeners, further explanation are for each button via getSource
     */
    public void actionPerformed(ActionEvent e) {
        String readout, line;
        readout = null;
        BufferedReader reader = null;

        if (e.getSource() == SelectAlpha) { //This is for the button that selects the Alpha fleet
            try {
                ConsoleAlpha.setText("Locking in " + AlphaComboBox.getSelectedItem());
                SelectAlpha.setEnabled(false); //Stops selecting a different fleet
                AlphaComboBox.setEnabled(false); //Stops selecting a different fleet

                //String readout, line;
                readout = null;
                //BufferedReader reader = null;

                /*
                Loading up the fleet composition
                 */
                try {
                    reader = new BufferedReader(new FileReader("fleets/" + AlphaComboBox.getSelectedItem() + "_fleet.flt"));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Battlesphere_Window.class.getName()).log(Level.SEVERE, null, ex);
                }
                Alpha.setName(AlphaComboBox.getSelectedItem());
                int j = -1;
                while ((line = reader.readLine()) != null) {
                    j++; //incrementing through JCombobox
                    Alpha_Ships.add(j, line); //
                    Alpha.Fleet_Members.add(j, new Fleet_Ship(line, Alpha));
                }
                ConsoleAlpha.setText("");
                for (int i = 0; i < Alpha_Ships.size(); i++) {
                    ConsoleAlpha.append(Alpha_Ships.getElementAt(i).toString());
                    ConsoleAlpha.append("\n");
                }

            } catch (IOException ex) {
                Logger.getLogger(Battlesphere_Window.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource() == SelectBeta) { //This is for the button that selects the Beta fleet
            try {
                ConsoleBeta.setText("Locking in " + BetaComboBox.getSelectedItem());
                SelectBeta.setEnabled(false);  // Stops selecting a different fleet
                BetaComboBox.setEnabled(false); //Stops selecting a different fleet
                readout = null;
                //Loading up the fleet composition
                try {
                    reader = new BufferedReader(new FileReader("fleets/" + BetaComboBox.getSelectedItem() + "_fleet.flt"));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Battlesphere_Window.class.getName()).log(Level.SEVERE, null, ex);
                }

                Beta.setName(BetaComboBox.getSelectedItem());
                int j = -1;
                while ((line = reader.readLine()) != null) {
                    j++;
                    Beta_Ships.add(j, line);
                    Beta.Fleet_Members.add(j, new Fleet_Ship(line, Beta));
                }

                ConsoleBeta.setText("");
                for (int i = 0; i < Beta_Ships.size(); i++) {
                    ConsoleBeta.append(Beta_Ships.getElementAt(i).toString());
                    ConsoleBeta.append("\n");
                }

                SelectBeta.setEnabled(false);
                BetaComboBox.setEnabled(false);
            } catch (IOException ex) {
                Logger.getLogger(Battlesphere_Window.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == MakePrimaryAlpha) {
            //DPS will be applied to 

            selectedprimaryforAlpha = BetaList.getSelectedIndex();
            System.out.println(selectedprimaryforAlpha);
            Beta_Ships.getElementAt(selectedprimaryforAlpha);
            System.out.println(Beta_Ships.getElementAt(selectedprimaryforAlpha).toString());

            //Access the fleet member
            Beta.Fleet_Members.get(selectedprimaryforAlpha).getDPS();

            System.out.println("DPS : " + Beta.Fleet_Members.get(selectedprimaryforAlpha).getDPS());
            System.out.println("EHP : " + Beta.Fleet_Members.get(selectedprimaryforAlpha).getEHP());
        }
        if (e.getSource() == MakePrimaryBeta) {
            selectedprimaryforBeta = AlphaList.getSelectedIndex();
            System.out.println(Alpha_Ships.getElementAt(selectedprimaryforBeta).toString());
            Alpha_Ships.getElementAt(selectedprimaryforAlpha);
            System.out.println("DPS : " + Alpha.Fleet_Members.get(selectedprimaryforBeta).getDPS());
            System.out.println("EHP : " + Alpha.Fleet_Members.get(selectedprimaryforBeta).getEHP());
        }

        if (e.getSource() == One_Second) {
            if (Alpha.Fleet_Members.size() > 0 && Beta.Fleet_Members.size() > 0) {
                Alpha.setupFleet();
                Beta.setupFleet();
                time++;
                System.out.println(Beta.Fleet_Members.get(selectedprimaryforAlpha).getEHP());
                if (Beta.Fleet_Members.get(selectedprimaryforAlpha).getEHP() <= 0) {
                    Beta_Ships.remove(selectedprimaryforAlpha);
                    Beta.Fleet_Members.remove(selectedprimaryforAlpha); //Kill it from JList
                    Beta.update();
                    BetaList.setSelectedIndex(0);
                } else {
                    System.out.println("\n" + Beta.Fleet_Members.get(selectedprimaryforBeta).getEHP());
                    Beta.Fleet_Members.get(selectedprimaryforBeta).setEHP(Beta.Fleet_Members.get(selectedprimaryforBeta).getEHP() - Alpha.getDPS()); //This line does not work
                }
                if (Alpha.Fleet_Members.get(selectedprimaryforBeta).getEHP() <= 0) {
                    Alpha_Ships.remove(selectedprimaryforBeta);
                    Alpha.Fleet_Members.remove(selectedprimaryforBeta);
                    Alpha.update();
                    AlphaList.setSelectedIndex(0);
                } else {
                    Alpha.Fleet_Members.get(selectedprimaryforBeta).setEHP(Alpha.Fleet_Members.get(selectedprimaryforBeta).getEHP() - Beta.getDPS()); //This line does not work
                }
                //Beta.getDPS();
                if (Alpha.Fleet_Members.size() > 0 && Beta.Fleet_Members.size() > 0) {
                    Alpha.update();
                    Beta.update();
                    /*
                     * If Alpha/Beta Fleet member EHP is < 0, then 
                     * kill it from JList
                     * kill it's DPS -> 0
                     * Update Fleet DPS and EHP
                     */
                    Console_Main.setText("\nAlpha Fleet Primary EHP: " + Alpha.Fleet_Members.get(selectedprimaryforBeta).getEHP() + "Beta Fleet Priamry EHP: " + Beta.Fleet_Members.get(selectedprimaryforAlpha).getEHP());
                    Console_Main.append("\n Beta Fleet Primary EHP: " + Alpha.Fleet_Members.get(selectedprimaryforBeta).getEHP() + "Alpha Fleet Priamry EHP: " + Alpha.Fleet_Members.get(selectedprimaryforAlpha).getEHP() + "\nTime : " + time);
                }
            } else if (Beta.Fleet_Members.size() == 0 && Alpha.Fleet_Members.size() == 0) {
                Console_Main.setText("\nBoth Fleets are Destroyed\nGlorious Destruction");
            } else if (Alpha.Fleet_Members.size() == 0) {
                Console_Main.setText("\nAlpha Fleet is Destroyed\nAll glory to TEST Alliance Please Ignore");
            } else if (Beta.Fleet_Members.size() == 0) {
                Console_Main.setText("\nBeta Fleet is Destroyed\nAll glory to TEST Alliance Please Ignore");
            }

        }

        if (e.getSource() == Ten_Seconds) {

            time = +10;
        }

    }


    /*
     * 1. Import all fleets from folder
     */
    public void read_fleets() {
        File path = new File("fleets/");
        String filename;

        File[] files = path.listFiles();

        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                filename = files[i].getName().substring(0, files[i].getName().indexOf("_fleet.flt"));
                System.out.println("\n" + filename);
                AlphaComboBox.addItem(filename);
                BetaComboBox.addItem(filename);
            }
        }
    }

    private void add_actionlisteners() {

        AlphaComboBox.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                //Upload stats to console
            }
        });
    }

}
