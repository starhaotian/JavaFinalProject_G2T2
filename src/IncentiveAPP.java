import javax.swing.*;
import java.io.IOException;

public class IncentiveAPP {

    public static void main (String[] args) throws Exception{

        SwingUtilities.invokeLater(() -> {
            try {
                new IncentiveMainFrame();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}

