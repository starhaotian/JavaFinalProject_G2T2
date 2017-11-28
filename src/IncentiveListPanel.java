import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by starhaotian on 26/11/2017.
 */
public class IncentiveListPanel {

    public IncentiveListPanel() throws IOException {
        JFrame frame = new JFrame("HaoTian List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new ListPanel());

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        new IncentiveListPanel();
    }
}

//incentiveId~webId~title~discount~startDate~endDate~id,category,year,make,model,trim,type,price~description
class ListPanel extends JPanel{
    private JComboBox sort;
    private JLabel incentive_all;
    private JLabel incentive_id, title;
    private JPanel sort_panel,list_panel, display_panel;
    private JTable list_table;

    public ListPanel() throws IOException {


        BoxLayout whole_layout = new BoxLayout(this,BoxLayout.Y_AXIS);
        setLayout(whole_layout);
        setBackground(Color.cyan);

        // sort function
        sort_panel = new JPanel();
        String[] sort_name = {"price $-$$$","price $$$-$", "create time","discount"};
        sort = new JComboBox(sort_name);
        sort.setAlignmentX(Component.RIGHT_ALIGNMENT);
        sort_panel.add(sort);
        sort_panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        sort_panel.setBackground(Color.yellow);
        add(sort_panel);

        title = new JLabel("Incentive List");
        add(title);


        display_panel = new DisplayPanel();
        add(display_panel);

        list_panel = new JPanel();
        list_panel.setBackground(Color.green);
        add(list_panel);

    }
}

class Sort_Panel extends JPanel{

    public Sort_Panel(){

    }
}

class DisplayPanel extends JPanel{
    JTable list_table;

    ArrayList<Incentive> data;

    public DisplayPanel() throws IOException {
        setBackground(Color.pink);
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(1300,600));
        create();
        ListTableModel sm = new ListTableModel(data);
        list_table = new JTable(sm);
        list_table.setBackground(Color.pink);
        for (int i = 0; i < 8; i++ ){
            TableColumn firstColumn = list_table.getColumnModel().getColumn(i);
            firstColumn.setPreferredWidth(200);
        }
        list_table.setPreferredScrollableViewportSize(new Dimension(1400,600));
        list_table.setFillsViewportHeight(true);
        list_table.setAutoCreateColumnsFromModel(true);

        list_table.setRowHeight(150);
        JScrollPane scrollPane = new JScrollPane(list_table);
        add(scrollPane);


    }

    private void create() throws IOException {
        data = new ArrayList<>();
        String filename = "/Users/starhaotian/IdeaProjects/JavaFinalProject_G2T2/src/IncentiveSample.txt";
        FileReader reader = new FileReader(filename);
        BufferedReader in = new BufferedReader(reader);
        String line;

        line = in.readLine();
        int count = 0;
        while (line != null){
            if (count != 0){
                String[] s= line.split("~");
                Incentive incentive = new Incentive(s);
                data.add(incentive);
            }
            count++;
            line = in.readLine();
        }
        in.close();
        reader.close();
    }
}

class ListTableModel implements TableModel{

    ArrayList<Incentive> incentive_data;

    public ListTableModel(ArrayList<Incentive> incentive_data){
        this.incentive_data = incentive_data;
    }

    @Override
    public int getRowCount() {
        return incentive_data.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0)
            return "Incentive Id";
        if (columnIndex == 1)
            return "Web Id";
        if (columnIndex == 2)
            return "Title";
        if (columnIndex == 3)
            return "Discount";
        if (columnIndex == 4)
            return "Start Date";
        if (columnIndex == 5)
            return "End Date";
        if (columnIndex == 6)
            return "Criterion";
        if (columnIndex == 7)
            return "Description";

        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Incentive incentive = incentive_data.get(rowIndex);
        if (columnIndex == 0){
            return incentive.getId();
        }

        if (columnIndex == 1){
            return incentive.getWebId();
        }

        if (columnIndex == 2){
            return incentive.getTitle();
        }

        if (columnIndex == 3){
            return incentive.getDiscount();
        }

        if (columnIndex == 4){
            return incentive.getStartDate();
        }

        if (columnIndex == 5){
            return incentive.getEndDate();
        }

        if (columnIndex == 6){
            ArrayList<String> s =  incentive.getCriterion();
            ArrayList<String> result = new ArrayList<>();
            for (String a : s){
                if (a.equals("no")){
                }else {
                    result.add(a);
                }
            }
            return result;

        }

        if (columnIndex == 7){
            return incentive.getDescription();
        }

        return null;

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}