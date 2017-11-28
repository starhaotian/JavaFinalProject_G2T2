import java.util.EventListener;

public interface SearchListener extends EventListener {
    void searchEventOccurred(SearchEvent se);
}
