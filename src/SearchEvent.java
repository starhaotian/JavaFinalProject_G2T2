import java.util.EventObject;

public class SearchEvent extends EventObject {

    private String searchContent;

    public SearchEvent(Object source) {
        super(source);
    }

    public SearchEvent(Object source, String searchContent) {
        super(source);
        this.searchContent = searchContent;
    }

    public String getSearchContent() {
        return searchContent;
    }

    public void setSearchContent(String searchContent) {
        this.searchContent = searchContent;
    }
}
