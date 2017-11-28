import java.util.EventListener;

public interface FilterListener extends EventListener{
    void filterEventOccurred(FilterEvent fe);
}
