import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IncentiveSearchPanel extends JPanel {
    private JLabel title;
    private JLabel searchNotice;
    private TextField textField;
    private JButton searchButton;
    private IncentiveSearchListener searchListener;

    public IncentiveSearchPanel(){
        Dimension dim = getPreferredSize();
        dim.height = 100;
        setPreferredSize(dim);

        title = new JLabel("Manage Incentives");
        title.setPreferredSize(new Dimension(650,60));
        title.setFont(new Font("Menlo", Font.PLAIN, 35));
        searchNotice = new JLabel("Search by key words:");
        searchNotice.setPreferredSize(new Dimension(250, 34));
        searchNotice.setFont(new Font("Menlo", Font.PLAIN, 18));
        textField = new TextField();
        textField.setPreferredSize(new Dimension(850, 34));
        searchButton = new JButton("Search");
        searchButton.setPreferredSize(new Dimension(80,34));


        panelLayout();

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchContent = textField.getText();

                IncentiveSearchEvent se = new IncentiveSearchEvent(e, searchContent);
                if (searchListener != null){
                    searchListener.searchEventOccurred(se);
                }
            }
        });

    }

    public void panelLayout(){
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.gridx = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.CENTER;
        add(title, gc);


        gc.gridy++;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(searchNotice, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(textField, gc);

        gc.gridx = 2;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(searchButton, gc);
    }

    public void setSearchListener(IncentiveSearchListener searchListener){
        this.searchListener = searchListener;
    }
}
