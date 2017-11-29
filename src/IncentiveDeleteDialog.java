import javax.swing.*;
import java.awt.*;

public class IncentiveDeleteDialog extends JDialog {
    private JLabel explaination;
    private JTextField textField;
    private JButton submitButton;

    public IncentiveDeleteDialog(){
        setSize(500,800);

        explaination = new JLabel("Please put the incentive ID you want to delete");
        textField = new JTextField();
        textField.setSize(100,80);
        submitButton = new JButton("Submit");
    }

    public void display(){
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridy = 1;
        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(5,5,5,5);

        gc.gridy++;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(explaination, gc);


        gc.gridy++;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(textField, gc);

        gc.gridy++;
        gc.anchor = GridBagConstraints.CENTER;
        add(submitButton, gc);
    }
}
