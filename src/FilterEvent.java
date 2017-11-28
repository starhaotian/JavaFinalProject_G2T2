import java.util.ArrayList;
import java.util.EventObject;

public class FilterEvent extends EventObject {
    private ArrayList<String> filterList;

    public FilterEvent(Object source) {
        super(source);
    }

    public FilterEvent(Object source, ArrayList<String> filterList){
        super(source);
        this.filterList = filterList;
    }

    public void setFilterList(ArrayList<String> filterList) {
        this.filterList = filterList;
    }

    public ArrayList<String> getFilterList() {
        return filterList;
    }
}
