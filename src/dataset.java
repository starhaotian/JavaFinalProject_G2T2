import java.util.Random;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by starhaotian on 21/11/2017.
 */
public class dataset {
    //id~incentive_id~title~discount~start_date~end_date~criterion～description


    public static void main(String[] args){
        int[] id = {1,2,3,4,5};
        String[] intensive_id = {"0001","0002","0003","0004","0005"};
        String[] title = {"Halloween", "Thanksgiving", "Customer Service Day", "Christmas","Independence Day"};
        float[] discount = {500, 300, 1500, 800, 600};
        String[] criterion = {"ALL", "no,white,toyoto,no,no","no,no,no,no,2017","no,black,no,SUV,no","no,no,Volkswagen,Saloon,2015"};
        String[] start_date = {"2012.2.1", "2014.2.5","2016.5.8","2015.11.23","2016.7.4"};
        String[] end_date = {"2017.1.2", "2017.5.6","2017.2.5","2017.10.2","2017.11.24"};
        String[] description = {"this is a huge discount", "buy now", "do not miss it", "you could get a extra gas gift card", "you could get an addition"};
        for (int i = 0; i < 100; i++){
            int a = (int)(4 * Math.random());
            int b = (int)(4 * Math.random());
            int c = (int)(4 * Math.random());
            int d = (int)(4 * Math.random());
            int e = (int)(4 * Math.random());
            int f = (int)(4 * Math.random());
            int g = (int)(4 * Math.random());
            int h = (int)(4 * Math.random());
            System.out.println(id[a] + "~" + intensive_id[b]+ "~" +title[c]+ "~" +discount[d]+ "~" +
            start_date[f]+ "~" +end_date[g]+ "~" +criterion[e]+ "~" +description[h]
            );
        }
    }
}