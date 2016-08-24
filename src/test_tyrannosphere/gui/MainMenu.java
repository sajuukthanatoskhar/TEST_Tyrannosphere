/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test_tyrannosphere.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * For TEST Alliance, with love and pizza
 *
 * Main Menu Class for TEST Tyranosphere
 *
 * @author Sajuuk
 */
public final class MainMenu extends Upgraded_JFrame {

    private JFrame Main_Menu_Window;
    private JButton Build_Fleet, Battle_Fleet, Build_Ship, Quit;
    private JButton Edit_Ship;
    private JLabel Title, MMD;

    public MainMenu() {
        Main_Menu_Window = new JFrame();
        Main_Menu_Window.setSize(300, 550);
        Main_Menu_Window.setLayout(new FlowLayout(FlowLayout.CENTER));

        Build_Fleet = new JButton("Build a New Fleet");
        Battle_Fleet = new JButton("Battle two fleets");
        Build_Ship = new JButton("Build a ship");
        Edit_Ship = new JButton("Edit a ship loadout");
        
        Quit = new JButton("Quit");
        Build_Ship.setPreferredSize(new Dimension(250, 30));
        Battle_Fleet.setPreferredSize(new Dimension(250, 30));
        Build_Fleet.setPreferredSize(new Dimension(250, 30));
        Edit_Ship.setPreferredSize(new Dimension(250, 30));
        Quit.setPreferredSize(new Dimension(250, 30));
        Title = new JLabel("TEST Tyranosphere");
        MMD = new JLabel();





        // Import ImageIcon     
        ImageIcon iconLogo = new ImageIcon("MMD.jpg");
        // In init() method write this code
        MMD.setIcon(iconLogo);

        Title.setFont(new Font("Stencil", 0, 28));


        Main_Menu_Window.add(Title);
        Main_Menu_Window.add(MMD);
        Main_Menu_Window.add(Build_Fleet);
        Main_Menu_Window.add(Battle_Fleet);
        Main_Menu_Window.add(Build_Ship);
        Main_Menu_Window.add(Edit_Ship);
        Main_Menu_Window.add(Quit);

        Main_Menu_Window.setVisible(true);
        Main_Menu_Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Main_Menu_Window.setResizable(false);

        mouse_actionlisteners();


       // Upgrade_GUI_Looks();
    }

    public void Upgrade_GUI_Looks() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }
    }

    public void mouse_actionlisteners() {
        getBuild_Fleet().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuildFleet_Window BuildFleet_Window = new BuildFleet_Window();
            }
        });

        getBattle_Fleet().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Battlesphere_Window Battlesphere_GUI = new Battlesphere_Window();
            }
        });

        getQuit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        getBuild_Ship().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Ship_Builder_Window Ship_Build_Window = new Ship_Builder_Window();
            }
        });

    }

    public JButton getBuild_Fleet() {
        return Build_Fleet;
    }

    public JButton getBattle_Fleet() {
        return Battle_Fleet;
    }

    public JButton getBuild_Ship() {
        return Build_Ship;
    }

    public JButton getQuit() {
        return Quit;
    }

    public JButton getEdit_Ship() {
        return Edit_Ship;
    }
}
