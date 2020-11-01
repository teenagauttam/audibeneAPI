package Bean;

import java.util.List;

public class DataBean {

    private static List<String> catogeries;


    public static void setCatogeries(List<String> cat) {

        catogeries = cat;
    }

    public static List<String> getCatogeries() {

        return catogeries;
    }
}
