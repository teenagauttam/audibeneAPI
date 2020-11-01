package Hello;

import Bean.DataBean;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import common.ConfigManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReportServices {
    private static Logger logger = LoggerFactory.getLogger(ReportServices.class);
    private static ReportServices reportservices = null;

    public String getResponse(String url) throws Exception {
        Response resp = RestAssured.get(url);
        // Getting Status Code
        int code = resp.getStatusCode();
        logger.info("API Response Status Code for is :::::::: " + code);
        // Getting API Response in string
        String data = resp.asString();
        logger.info("Response data is :::::::: " + data);
        return data;
    }

    public boolean fetchCategories() throws Exception {
        String url = ConfigManager.getProperty("CategoryURL");
        try {
            String data = getResponse(url);
            // String API response
            storeCategories(data);
            return true;
        } catch (Exception e) {
            logger.error("Response code is not fetched successfully for Category API :::::: " + e);
            return false;
        }
    }

    // Method to Storing Response Code
    public boolean storeCategories(String data) {
        try {
            JSONArray jsonArray = new JSONArray(data);
            List<String> list = new ArrayList<String>();
            for (int i = 0; i < jsonArray.length(); i++) {
                list.add(jsonArray.getString(i));
            }
            DataBean.setCatogeries(list);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Pick category and verify in other API Response Code
    public boolean pickAndVerify() {
        String text = DataBean.getCatogeries().get(0);
        String url = ConfigManager.getProperty("SearchURL") + text;
        boolean isExists = false;

        try {
            String data = getResponse(url);
            JSONObject jsonObject = new JSONObject(data);
            for (int i = 0; i < jsonObject.getJSONArray("result").length(); i++) {
                if (jsonObject.getJSONArray("result").getJSONObject(i).getString("value").contains(DataBean.getCatogeries().get(0))) {
                    logger.info("Response data " + "'"+jsonObject.getJSONArray("result").getJSONObject(i).getString("value") +"'"+ " has category text " + "'"+DataBean.getCatogeries().get(0)+"'" + " in it");
                    isExists = true;
                } else {
                    isExists = false;
                }
            }
            return isExists;
        } catch (Exception e) {
            logger.error("Response data of query did not match with Category API " + e);
            return false;
        }
    }
}