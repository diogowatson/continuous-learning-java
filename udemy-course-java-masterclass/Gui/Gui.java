import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** class extends JFrame so basic implementation can be used in constructor */
public class Gui extends JFrame {
    String[] labels = {"sku", "first name", "last name"};//define labels of the gui
    JLabel[] Jlabels = new JLabel[3];//define JLabel objects
    JTextField[] fields = new JTextField[3];//define fiels Objects
    JButton button;
    Employee temp = new Employee();//temporary Emplloyee object

    public Gui() {
        super("tests frame");//sets name in the bottom of window
        setLayout(new FlowLayout());//set flow out as base

        for (int i = 0; i < labels.length; i++) {//dynamically creates labels and fields
            Jlabels[i] = new JLabel(labels[i]);
            add(Jlabels[i]);
            fields[i] = new JTextField(10);
            fields[i].addActionListener((actionEvent) -> {//lambda to action listener
                       if (actionEvent.getSource() == fields[0]) {
                            String in = fields[0].getText();//get the text field into a String
                            temp.sku = (Integer.parseInt(in));//parse the string to intenger since sku is intenger
                            System.out.println(temp.sku);//just ot test and check values in console
                        }
                        if (actionEvent.getSource() == fields[1]) {
                            temp.fName = fields[1].getText();
                            System.out.println(temp.fName);
                        }
                        if (actionEvent.getSource() == fields[2]) {
                            temp.lName = fields[2].getText();
                            System.out.println(temp.toString());
                        }
                    }
            );
            add(fields[i]);
        }
        //implement button
        button = new JButton("submmit information");//button iside text
        add(button);
        button.addActionListener((actionEvent) -> {

            JFrame response = new JFrame("data");
            Box box = Box.createVerticalBox();//create a box
            JTextArea text = new JTextArea(temp.toString(), 10, 15);

            box.add(text);
            response.add(box);
            response.setSize(400, 400);
            response.setVisible(true);
        });//set the button action to inner class
        setSize(700, 100);
        setVisible(true);

    }
}
