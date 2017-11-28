import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchPanel extends JPanel {
    private JLabel searchNotice;
    private TextField textField;
    private JButton searchButton;
    private SearchListener searchListener;

    public SearchPanel(){
        Dimension dim = getPreferredSize();
        dim.height = 40;
        setPreferredSize(dim);
        searchNotice = new JLabel("Search by incentive ID or name:");
        searchNotice.setPreferredSize(new Dimension(200, 34));
        textField = new TextField();
        textField.setPreferredSize(new Dimension(400, 30));
        searchButton = new JButton("Search");
        searchButton.setPreferredSize(new Dimension(100,34));
        paneLayout();

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchContent = textField.getText();

                SearchEvent se = new SearchEvent(e, searchContent);
                if (searchListener != null){
                    searchListener.searchEventOccurred(se);
                }
            }
        });



    }

    public void paneLayout(){
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();


        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.gridy = 0;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0, 0, 15);
        add(searchNotice, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(textField, gc);

        gc.gridx = 2;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(searchButton, gc);
    }

    public void setSearchListener(SearchListener searchListener){
        this.searchListener = searchListener;
    }
}
