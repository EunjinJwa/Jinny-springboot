import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class TestCode {

    public static void main(String[] args) {

        jsonTest();

//        dateTest();

//        testDouble();

    }

    private static void testDouble() {
        double num = 2.56900;
        System.out.println((long)(num*1000));
    }

    private static void dateTest() {





        try {
            //java.util.Date date = inputFormat.parse(dateTimeString);

//            System.out.println(date);
//
//            System.out.println(date.getTime());

//
//            Long currentTimestamp = (System.currentTimeMillis()/1000)*1000;
//            System.out.println(currentTimestamp);
//            System.out.println(inputFormat.format(currentTimestamp));


            String dateTimeString = "2020-08-27T10:20:00Z";

            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

            java.util.Date fromDate = inputFormat.parse(dateTimeString);


            System.out.println( inputFormat.format(fromDate.getTime()+1000));




            // 날짜 더하기
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            String dateString = "2020-08-31T20:30:00Z";
            String dateString2 = "2020-08-31T21:30:00Z";
            java.util.Date statusUpdatedDt = dateFormat.parse(dateString);
            java.util.Date dateString2Dt = dateFormat.parse(dateString2);
            Calendar cal = Calendar.getInstance();
            cal.setTime(statusUpdatedDt);
            cal.add(Calendar.HOUR, 1);


            System.out.println(dateString2Dt.getTime() - statusUpdatedDt.getTime());
            System.out.println(statusUpdatedDt.getTime());
            System.out.println(cal.getTime());
            System.out.println(dateFormat.format(cal.getTime()));





        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void jsonTest(){
        List<BadgeNameByLanguage> dataList = new ArrayList<>();
        dataList.add(new BadgeNameByLanguage("A", "name1"));
        dataList.add(new BadgeNameByLanguage("B", "name2"));

        Gson gson = new Gson();
        String toString = gson.toJson(dataList);
        System.out.println(toString);
        System.out.println(dataList.toString());





        JsonObject contentsJson = new JsonObject();
        contentsJson.addProperty("fishBuffetLevel", "AA");
        contentsJson.addProperty("fishBuffetStatus", "STATUS dd");
        contentsJson.addProperty("rewardAmount", 150000);
        contentsJson.addProperty("currencyId", "USD");
        contentsJson.addProperty("status", "");

        System.out.println(contentsJson.toString());


        String jsonString = "{\"test\":{\"ava\":\"ttt\",\"bb\":50}}";
        JsonElement json = gson.fromJson(jsonString, JsonElement.class);
        System.out.println(json);

        JsonElement a = json.getAsJsonObject().get("test").getAsJsonObject().get("ava");

        System.out.println(a == null ? "" : a.getAsString());


        String jsonString2 = "[{\"language\": \"0\", \"name\": \"ALL\"}]";
        System.out.println(jsonString2);
        JsonArray list2 = gson.fromJson(jsonString2, JsonArray.class);
        System.out.println(list2.get(0).getAsJsonObject().get("name").getAsString());


    }

}




class BadgeNameByLanguage
{
    private String language;
    private String name;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BadgeNameByLanguage(String language, String name) {
        this.language = language;
        this.name = name;
    }
}
