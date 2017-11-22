import java.util.ArrayList;
import java.util.List;

/**
 * Created by starhaotian on 21/11/2017.
 */
public class Incentive {


    private String id;//dealer id
    private int incentive_Id;
    private String title;
    private double discount;
    private String start_date;
    private String end_date;
    private List<String> criterion;
    private String description;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getDiscount() {
        return discount;
    }


    public String getStart_date() {
        return start_date;
    }


    public String getEnd_date() {
        return end_date;
    }


    public List<String> getCriterion() {
        return criterion;
    }

    public String getDescription() {
        return description;
    }


    public int getIncentive_Id() {
        return incentive_Id;
    }


    public Incentive(String[] arr) {
        this.id = arr[0];
        this.incentive_Id = Integer.parseInt(arr[1]);
        this.title = arr[2];
        this.discount = Double.parseDouble(arr[3]);
        this.start_date = arr[4];
        this.end_date = arr[5];
        String[] curr_criterion = arr[6].split(",");
        this.criterion = java.util.Arrays.asList(curr_criterion);
        this.description = arr[7];
    }

    @Override
    public String toString() {
        String str = this.id + "~" + this.incentive_Id + "~" + this.title + "~" + this.discount + "~" +
                this.start_date + "~" + this.end_date + "~" + this.criterion + "~" + this.description;
        return str;
    }


    //test method
    public static void main(String[] args){
        String[] arr = new String[]{"1","0002","christmas","100","2017.2.1","2017.5.6","mazda,2017,white","happy"};
        Incentive incentive_a = new Incentive(arr);
        System.out.println(incentive_a);
    }


}
