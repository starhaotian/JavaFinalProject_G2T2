//package finalProject;

import com.sun.awt.AWTUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class manageIncentivesLayout extends JFrame {
    private JTable table;
    private JButton add, delete, edit, search;
    private JTextField searchField;
    private JComboBox make, year, color;

    public manageIncentivesLayout(){
        setTitle("Manage Incentives");
        create();
        addComponents();
        makeListeners();
        display();
    }

    public void create(){
        table = new JTable();
        add = new JButton("add");
        delete = new JButton("delete");
        edit = new JButton("edit");
        search = new JButton("search");
        searchField = new JTextField(20);
        make = new JComboBox();
        year = new JComboBox();
        color = new JComboBox();
    }

    public void addComponents(){
        Container con = getContentPane();
        con.setLayout(new BorderLayout());
        con.add(makeSearchPanel(),"North");
        con.add(makeButtonPanel(),"South");
        con.add(makeBlankPanel(),"East");
        con.add(makeFilterPanel(),"West");
        con.add(makeTablePanel(),"Center");
    }

    private JPanel makeSearchPanel(){
        JPanel panel = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        searchField.setPreferredSize(new Dimension(50,27));
        search.setPreferredSize(new Dimension(100,27));
        panel2.add(searchField);
        panel2.add(search);
        panel.add(panel2,"Center");
        panel.add(panel3,"South");
        panel.add(panel4,"North");
        panel2.setBackground(Color.WHITE);
        panel3.setBackground(Color.WHITE);
        panel4.setBackground(Color.WHITE);
        return panel;
    }

    private JPanel makeButtonPanel(){
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(add);
        panel.add(delete);
        panel.add(edit);
        panel.setBackground(Color.WHITE);
        return panel;
    }


    private JPanel makeFilterPanel(){
        JPanel panel = new JPanel();
        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        panel.setLayout(gridBag);
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0;
        c.weighty = 0;
        c.anchor = GridBagConstraints.NORTHWEST;
        panel.add(make,c);
        c.gridy++;
        c.weighty = 25;
        panel.add(year,c);
        c.gridy++;
        c.weighty = 6000;
        panel.add(color,c);
        panel.setBackground(Color.WHITE);
        return panel;
    }

    private JPanel makeTablePanel(){
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(table));
        panel.setBackground(Color.WHITE);
        return panel;
    }
    private JPanel makeBlankPanel(){
        JPanel panel = new JPanel(new FlowLayout());
        panel.setBackground(Color.WHITE);
        return panel;
    }

    public void makeListeners(){
        manageIncentivesActionListener mial = new manageIncentivesActionListener();
        add.addActionListener(mial);
        delete.addActionListener(mial);
        edit.addActionListener(mial);
    }

    class manageIncentivesActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == add){
                //
            }
            if(e.getSource() == delete){
                //
            }
            if(e.getSource() == edit){
                //
            }
            table.updateUI();
        }
    }

    public void display(){
        setSize(2300,1200);
        setVisible(true);
        pack();
    }
    public static void main(String[] args){
        manageIncentivesLayout mil = new manageIncentivesLayout();
    }
}
