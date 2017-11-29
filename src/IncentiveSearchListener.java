import java.util.EventListener;

public interface IncentiveSearchListener extends EventListener {
    void searchEventOccurred(IncentiveSearchEvent se);
}

