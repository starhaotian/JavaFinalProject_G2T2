import java.util.EventListener;

public interface IncentiveSortListener extends EventListener {
    void sortEventOccurred(IncentiveSortEvent ise);
}
