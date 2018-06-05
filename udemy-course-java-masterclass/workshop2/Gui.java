package Workshop2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Gui extends JFrame {
    private final String[] labels = {"Account", "First Name", "Last Name", "Balance"};//define labels
    final JLabel[] jLabels = new JLabel[labels.length];//JLabel objects
    final JTextField[] jFields = new JTextField[labels.length];//JFields Objects
    JTextArea text = new JTextArea();
    Account temp = new Account();//temp Account to load files
    SaveAccount save = null;
    //*Constructor-> takes no argument and reads and save default file
    // Creates an Object that generates an Gui for the user, gets his input
    // and serialize it. It wont save duplicate objects. Duplicate objects are considered the ones that
    // all parameters are the same*/
    public Gui() {
        super("JAVA Worshop 2");
        try {
            save = new SaveAccount("/home/diogowatson/dev/workshop2/Save.ses");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.printStackTrace();
        }
        this.setLayout(new FlowLayout());
        //create labels and text fields
        for (int i = 0; i < labels.length; i++) {
            jLabels[i] = new JLabel(labels[i]);
            add(jLabels[i]);
            jFields[i] = new JTextField(6);
            add(jFields[i]);
        }
        /**The fallowing code generate the button that creates the object */
        JButton createButton = new JButton("create Object");
        createButton.addActionListener((actionEvent)-> {
                String in = jFields[0].getText();
                try {
                    temp.setAccount(Integer.parseInt(in));
                    temp.setFirstName(jFields[1].getText());
                    temp.setFirstName(jFields[1].getText());
                    temp.setLastName(jFields[2].getText());

                } catch (AccountException ex) {
                    ex.printStackTrace();
                }
                String in2 = jFields[3].getText();
                temp.setBalance(Double.parseDouble(in2));
                try {
                    Account temp2 = new Account(temp.getAccount(),
                            temp.getFirstName(),
                            temp.getLastName(),
                            temp.getBalance());
                    save.addAccountsObject(temp2);
                } catch (AccountException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    ex.printStackTrace();
                }
                for (JTextField text : jFields) {
                    text.setText("");
                }
                try {
                    save.save();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    ex.getMessage();
                }
            }
        );
        //button to save objects in the array to the seriliazed file
        JButton loadButton = new JButton("Load Objects");
        loadButton.addActionListener((actionEvent)-> { //added Lambda Expression instead of inner class
            ReadAccount load = new ReadAccount("/home/diogowatson/dev/workshop2/Save.ses");
              try {
                    load.readFile();
                }catch (IOException ex){
                  JOptionPane.showMessageDialog(null, ex.getMessage());
                    ex.getMessage();
                }
                JFrame response = new JFrame("data");
                Box box = Box.createVerticalBox();//create a box
                JTextArea text = new JTextArea(load.listAccounts());
                String out = load.listAccounts();
                box.add(new JScrollPane(text));
                response.add(box);
                response.setSize(400,400);
                response.setVisible(true);
            }
        );
        add(createButton);
        add(loadButton);
        setSize(800, 100);
        setVisible(true);
    }
}//end of class
