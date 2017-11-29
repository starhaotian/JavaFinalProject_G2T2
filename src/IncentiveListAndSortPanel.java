import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class IncentiveListAndSortPanel extends JPanel {
    private IncentiveSortPanel sortPanel;
    private IncentiveListPanel listPanel;

    public IncentiveListAndSortPanel() throws IOException {
        sortPanel = new IncentiveSortPanel();
        listPanel = new IncentiveListPanel();

        panelLayout();
    }

    public void panelLayout(){
        Dimension dim = getPreferredSize();
        dim.width = 1000;
        setPreferredSize(dim);

        BoxLayout whole_layout = new BoxLayout(this,BoxLayout.Y_AXIS);
        setLayout(whole_layout);
        setBackground(new Color(206, 206, 206));
        add(sortPanel);
        add(listPanel);
    }
}

class IncentiveSortPanel extends JPanel{
    private JComboBox sortCombo;


    public IncentiveSortPanel(){
        String[] sort_name = {"discount high to low","discount low to high", "create time"};
        sortCombo = new JComboBox(sort_name);
        sortCombo.setAlignmentX(Component.RIGHT_ALIGNMENT);
        add(sortCombo);
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        setBackground(new Color(206, 206, 206));
        setPreferredSize(new Dimension(1000,30));
    }
}

class IncentiveListPanel extends JPanel{
    private JTable list_table;
    private TempFileReader tempFileReader;
    private ArrayList<Incentive> data;
    private IncentiveListTableModel listInput;

    public IncentiveListPanel() throws IOException {
        setBackground(new Color(206, 206, 206));
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(1000,530));

        tempFileReader = new TempFileReader();
        data = tempFileReader.read();
        listInput = new IncentiveListTableModel(data);
        list_table = new JTable(listInput);
        list_table.setBackground(new Color(206, 206, 206));
        for (int i = 0; i < 8; i++ ){
            TableColumn firstColumn = list_table.getColumnModel().getColumn(i);
            firstColumn.setPreferredWidth(150);
        }
        list_table.setPreferredScrollableViewportSize(new Dimension(980,530));
        list_table.setFillsViewportHeight(true);
        list_table.setAutoCreateColumnsFromModel(true);

        list_table.setRowHeight(100);
        JScrollPane scrollPane = new JScrollPane(list_table);
        add(scrollPane);


    }
}