package com.neuSep17.ui.Dealer;

import com.neuSep17.dto.Category;
import com.neuSep17.dto.Incentive;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class IncentiveDialog extends JDialog {

    private Incentive incentive;
    private JLabel labelTitle, labelDiscount,labelStart,labelEnd,labelCriterion,labelDescription;

    private JTextField fieldTitle,fieldDiscount,fieldStart,fieldEnd,fieldPrice;

    private JTextArea description;
    private JScrollPane scrollPane;

    private JComboBox comboBoxRange, comboBoxCategory,comboBoxYear,comboBoxMake,comboBoxPrice;
    private JButton buttonSave;
    private JButton buttonCancel;

    public IncentiveDialog(String dealerId){
        createComponents();
        addComponents();
        makeListeners();
        display();
        setTitle("add incentive");
    }

    //edit constructor
    public IncentiveDialog(String dealerId, Incentive incentive){
        this.incentive = new Incentive(new String[]{
                "000006","gmps-camino","All Sale","500.0","2010-01-01","2100-12-31",
                "all,no,no,no,no,no,no,no","All the vehicle apply"});

        initComponents();
       //createComponents();
        addComponents();
        //makeListeners();
        display();
        setTitle("add incentive");
    }

    //jing
    private void initComponents() {
//       fieldDiscount.

        labelTitle = new JLabel("Title: ");
        labelDiscount = new JLabel("Discount: ");
        labelStart = new JLabel("Start Date: ");
        labelEnd = new JLabel("End Date: ");
        labelCriterion = new JLabel("Criterion: ");
        labelDescription = new JLabel("Description: ");


        fieldTitle = new JTextField(incentive.getTitle(),20);
        fieldDiscount = new JTextField(String.valueOf(incentive.getDiscount()),20);
        fieldStart = new JTextField(incentive.getStartDate(),20);
        fieldEnd = new JTextField(incentive.getEndDate(),20);

        description = new JTextArea(incentive.getDescription(),3,20);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        scrollPane = new JScrollPane(description);

        //criterion data,get data from vehicle
        ArrayList<String> criterion = incentive.getCriterion();
        String[] crit = new String[5];
        int i = 0;
        while (i < 4){
            crit[i] = criterion.get(i);
            i++;
        }
        crit[4] = criterion.get(criterion.size() - 1);

        for (String s : crit){
            System.out.println(s);
        }


        comboBoxRange = new JComboBox(new String[]{"All","No"});
        comboBoxCategory = new JComboBox(Category.values());
        comboBoxYear = new JComboBox(new String[] {"2010","2011","2012","2013"});
        comboBoxMake = new JComboBox(new String[] {"Cadillac","Chevrolet","Cadillac","Toyota"});
        comboBoxPrice = new JComboBox(new String[] {"500","1000","1500","2000"});
        createComboBox(comboBoxRange,"range");
        createComboBox(comboBoxCategory,"category");
        createComboBox(comboBoxYear,"year");
        createComboBox(comboBoxMake,"make");
        createComboBox(comboBoxPrice,"price");

        //set the selected item
        comboBoxRange.insertItemAt(crit[0],0);
        comboBoxRange.setSelectedItem(comboBoxRange.getItemAt(0));
        comboBoxCategory.insertItemAt(crit[1],0);
        comboBoxCategory.setSelectedItem(comboBoxCategory.getItemAt(0));
        comboBoxYear.insertItemAt(crit[2],0);
        comboBoxYear.setSelectedItem(comboBoxYear.getItemAt(0));
        comboBoxMake.insertItemAt(crit[3],0);
        comboBoxMake.setSelectedItem(comboBoxMake.getItemAt(0));
        comboBoxPrice.insertItemAt(crit[4],0);
        comboBoxPrice.setSelectedItem(comboBoxPrice.getItemAt(0));


        //logical of the range of criterion



        buttonSave = new JButton("Save");
        buttonCancel = new JButton("Cancel");
    }

    //lulu
    private void makeListeners() {

    }

    //jing
    private void validateForm(){

    }

    //jing
    private void saveIncentive(){
//        incentive.
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
        comboBoxCategory = new JComboBox(Category.values());
        comboBoxYear = new JComboBox(new String[] {"2010","2011","2012"});
        comboBoxMake = new JComboBox(new String[] {"Cadillac","Chevrolet","Cadillac"});
        createComboBox(comboBoxRange,"range");
        createComboBox(comboBoxCategory,"category");
        createComboBox(comboBoxYear,"year");
        createComboBox(comboBoxMake,"make");

        comboBoxCategory.insertItemAt("choose category...",0);
        comboBoxCategory.setSelectedItem(comboBoxCategory.getItemAt(0));


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
        add(comboBoxPrice,c);
        c.gridy++;
    }
    public static void main(String[] args){

        new IncentiveDialog("",null);
    }
}