import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    private FilterPanel filterPanel;
    private SearchPanel searchPanel;
    private TextArea textArea;

    public MainFrame(){
        super("Manage Incentives");

        setLayout(new BorderLayout());

        filterPanel = new FilterPanel();
        searchPanel = new SearchPanel();

        textArea = new TextArea();

        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        add(searchPanel, BorderLayout.NORTH);
        add(filterPanel, BorderLayout.WEST);
        add(textArea, BorderLayout.EAST);




        searchPanel.setSearchListener(new SearchListener(){
            public void searchEventOccurred(SearchEvent se){
                String searchContent = se.getSearchContent();
                textArea.append(searchContent);
            }
        });

        filterPanel.setFilterListener(new FilterListener(){
            @Override
            public void filterEventOccurred(FilterEvent fe) {
                ArrayList<String> filterList = fe.getFilterList();
                for (String filter : filterList){
                    textArea.append(filter);
                }
            }
        });
    }
}
