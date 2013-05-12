package de.codingContest.gui;

import de.codingContest.logic.FileReader;
import de.codingContest.logic.PatternRecognition;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author J. F. Kammann
 * @email janis.kammann@hotmail.de
 *
 */
public class MainWindow extends JFrame {

    private JLabel lblNucleobases, lblCrytosines, lblGuanine, lblAdenine,
            lblThymine, lblPurinesPyrimidines, lblTyberius, lblEyeColor,
            lblFromingen, lblCTAG, fieldNucleobases, fieldCrytosines, fieldGuanine, fieldAdenine,
            fieldThymine, fieldPurinesPyrimidines, fieldTyberius, fieldEyeColor,
            fieldFromingen, fieldCTAG;
    private JButton btnComplementarySequence;
    private PatternRecognition patternRecognition;
    private JPanel panelDescription, panelFields;

    public static void main(String[] args) {
        new MainWindow();
    }

    public MainWindow() {
        setSize(500, 500);
        setLocation(500, 300);
        setLayout(new GridLayout(1, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeGUI();
        setVisible(true);
    }

    /*
     * This method initialises all crucial components of the GUI.
     */
    private void initializeGUI() {
        //Menubar
        JMenuBar menubar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem eMenuItem = new JMenuItem("Load File");
        eMenuItem.setToolTipText("Load File");
        eMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JFileChooser fc = new JFileChooser();
                FileReader reader = new FileReader();
                int returnVal = fc.showOpenDialog(new JFrame());

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    setData(reader.read(file.getPath()));
                }
            }
        });
        file.add(eMenuItem);
        menubar.add(file);
        setJMenuBar(menubar);


        //Initializing all JPanel variables.
        panelDescription = new JPanel();
        panelDescription.setLayout(new BoxLayout(panelDescription, BoxLayout.Y_AXIS));
        panelFields = new JPanel();
        panelFields.setLayout(new BoxLayout(panelFields, BoxLayout.Y_AXIS));

        //Inititalizing all JLabel variables.
        lblNucleobases = new JLabel("Nucleobases: ");
        lblCrytosines = new JLabel("Cytosines: ");
        lblGuanine = new JLabel("Guanine: ");
        lblAdenine = new JLabel("Adenine: ");
        lblThymine = new JLabel("Thymine: ");
        lblPurinesPyrimidines = new JLabel("More Purines than Pyrimidnines: ");

        lblTyberius = new JLabel("Tyberius syndrom: ");
        lblEyeColor = new JLabel("Brown - Eyecolor: ");
        lblFromingen = new JLabel("Fromingens dischrypsia: ");

        lblCTAG = new JLabel("First occurrence of \"CTAG\": ");

        //Initializing all JTextField variables.
        fieldNucleobases = new JLabel();
        fieldCrytosines = new JLabel();
        fieldGuanine = new JLabel();
        fieldAdenine = new JLabel();
        fieldThymine = new JLabel();
        fieldPurinesPyrimidines = new JLabel();
        fieldTyberius = new JLabel();
        fieldEyeColor = new JLabel();
        fieldFromingen = new JLabel();
        fieldCTAG = new JLabel();

        //Initializing JButton
        btnComplementarySequence = new JButton("Show Complementary DNA Sequence.");
        btnComplementarySequence.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnComplementarySequence) {
                    JOptionPane.showMessageDialog(new JFrame(), patternRecognition.getComplementarySequence());
                }
            }
        });

        //Adding all JLabels and JTextFields to the belonging JPanel.
        panelDescription.add(lblNucleobases);
        panelDescription.add(Box.createRigidArea(new Dimension(0, 5)));
        panelDescription.add(lblCrytosines);
        panelDescription.add(Box.createRigidArea(new Dimension(0, 5)));
        panelDescription.add(lblGuanine);
        panelDescription.add(Box.createRigidArea(new Dimension(0, 5)));
        panelDescription.add(lblAdenine);
        panelDescription.add(Box.createRigidArea(new Dimension(0, 5)));
        panelDescription.add(lblThymine);
        panelDescription.add(Box.createRigidArea(new Dimension(0, 5)));
        panelDescription.add(lblPurinesPyrimidines);
        panelDescription.add(Box.createRigidArea(new Dimension(0, 15)));
        panelDescription.add(lblTyberius);
        panelDescription.add(Box.createRigidArea(new Dimension(0, 5)));
        panelDescription.add(lblEyeColor);
        panelDescription.add(Box.createRigidArea(new Dimension(0, 5)));
        panelDescription.add(lblFromingen);
        panelDescription.add(Box.createRigidArea(new Dimension(0, 15)));
        panelDescription.add(lblCTAG);
        panelDescription.add(Box.createRigidArea(new Dimension(0, 15)));
        panelDescription.add(btnComplementarySequence);

        panelFields.add(fieldNucleobases);
        panelFields.add(Box.createRigidArea(new Dimension(0, 5)));
        panelFields.add(fieldCrytosines);
        panelFields.add(Box.createRigidArea(new Dimension(0, 5)));
        panelFields.add(fieldGuanine);
        panelFields.add(Box.createRigidArea(new Dimension(0, 5)));
        panelFields.add(fieldAdenine);
        panelFields.add(Box.createRigidArea(new Dimension(0, 5)));
        panelFields.add(fieldThymine);
        panelFields.add(Box.createRigidArea(new Dimension(0, 5)));
        panelFields.add(fieldPurinesPyrimidines);
        panelFields.add(Box.createRigidArea(new Dimension(0, 15)));
        panelFields.add(fieldTyberius);
        panelFields.add(Box.createRigidArea(new Dimension(0, 5)));
        panelFields.add(fieldEyeColor);
        panelFields.add(Box.createRigidArea(new Dimension(0, 5)));
        panelFields.add(fieldFromingen);
        panelFields.add(Box.createRigidArea(new Dimension(0, 15)));
        panelFields.add(fieldCTAG);

        // Adding the three main panels to MainWindow's JFrame.
        add(panelDescription);
        add(panelFields);
        pack();
    }

    /**
     * Sets the Data into the GUI.
     * @param dnaSequence 
     */
    public void setData(String dnaSequence) {
        patternRecognition = new PatternRecognition(dnaSequence);

        fieldNucleobases.setText("" + patternRecognition.countNucleobases().getTotal());
        fieldCrytosines.setText("" + patternRecognition.countNucleobases().getCytosines());
        fieldGuanine.setText("" + patternRecognition.countNucleobases().getGuanines());
        fieldAdenine.setText("" + patternRecognition.countNucleobases().getAdenines());
        fieldThymine.setText("" + patternRecognition.countNucleobases().getThymines());
        fieldPurinesPyrimidines.setText("" + patternRecognition.checkIfMorePurinesThanPyrimidines());
        fieldTyberius.setText("" + patternRecognition.testOfTyberiusSyndrom());
        fieldEyeColor.setText("" + patternRecognition.testOfBrownEyeColor());
        fieldFromingen.setText("" + patternRecognition.checkForFromingen());
        fieldCTAG.setText("" + patternRecognition.searchForCTAG());
        repaint();
    }
}
