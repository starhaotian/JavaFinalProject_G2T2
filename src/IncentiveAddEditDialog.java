import javax.swing.*;
import java.awt.*;

public class IncentiveAddEditDialog extends JDialog {
    private Incentive incentive;
    private JLabel labelTitle, labelDiscount,labelStart,labelEnd,labelCriterion,labelDescription;

    private JTextField fieldTitle,fieldDiscount,fieldStart,fieldEnd,fieldPrice;

    private JTextArea description;
    private JScrollPane scrollPane;

    private JComboBox comboBoxRange, comboBoxCategory,comboBoxYear,comboBoxMake;
    private JButton buttonSave;
    private JButton buttonCancel;

    public IncentiveAddEditDialog(String dealerId){
        createComponents();
        addComponents();
        display();
        setTitle("add incentive");
    }

    //edit constructor
    public IncentiveAddEditDialog(String dealerId, Incentive incentive){
        initComponents();
        addComponents();
        display();
        setTitle("add incentive");
    }

    //jing
    private void initComponents() {
        //fieldDiscount.
        fieldTitle = new JTextField(incentive.getTitle(),20);
    }

    private void createComponents() {
        labelTitle = new JLabel("Title: ");
        labelDiscount = new JLabel("Discount: ");
        labelStart = new JLabel("Start Date: ");
        labelEnd = new JLabel("End Date: ");
        labelCriterion = new JLabel("Criterion: ");
        labelDescription = new JLabel("Description: ");

        fieldTitle = new JTextField(20);
        fieldDiscount = new JTextField(20);
        fieldStart = new JTextField(20);
        fieldEnd = new JTextField(20);

        description = new JTextArea(3,20);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        scrollPane = new JScrollPane(description);

        //test data
        comboBoxRange = new JComboBox(new String[]{"All"});
//        comboBoxCategory = new JComboBox(Category.values());
        comboBoxCategory = new JComboBox(new String[] {"NEW", "USED", "CERTIFIED"});
        comboBoxYear = new JComboBox(new String[] {"2010","2011","2012"});
        comboBoxMake = new JComboBox(new String[] {"Cadillac","Chevrolet","Cadillac"});
        createComboBox(comboBoxRange,"range");
        createComboBox(comboBoxCategory,"category");
        createComboBox(comboBoxYear,"year");
        createComboBox(comboBoxMake,"make");


        buttonSave = new JButton("Save");
        buttonCancel = new JButton("Cancel");
    }

    private void createComboBox(JComboBox comboBox, String name){
        comboBox.insertItemAt("Choose "+name+"...",0);
        comboBox.setSelectedItem(comboBox.getItemAt(0));
    }
    private void display() {
        setSize(500, 800);
        setVisible(true);
    }

    private void addComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridy = 0;
        constraints.insets = new Insets(5,5,5,5);
        constraints.anchor = GridBagConstraints.WEST;

        addLine(constraints,labelTitle,fieldTitle);
        addLine(constraints,labelDiscount,fieldDiscount);
        addLine(constraints,labelStart,fieldStart);
        addLine(constraints,labelEnd,fieldEnd);
        addCriterion(constraints);
//        constraints.ipady = 40;
        addLine(constraints,labelDescription,scrollPane);


//        constraints.ipady = 0;
        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelButtons.add(buttonSave);
        panelButtons.add(buttonCancel);

        constraints.gridy++;
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        add(panelButtons,constraints);
    }

    private void addLine(GridBagConstraints c, JComponent label, JComponent text){
        c.gridx = 0;
        add(label,c);
        c.gridx = 1;
        add(text,c);
        c.gridy++;
    }

    private void addCriterion(GridBagConstraints c){

        c.gridx = 0;
        add(labelCriterion,c);
        c.gridheight = 1;
        c.gridx = 1;
        add(comboBoxRange,c);
        c.gridy++;
        add(comboBoxCategory,c);
        c.gridy++;
        add(comboBoxMake,c);
        c.gridy++;
        add(comboBoxYear,c);
        c.gridy++;
    }

}

