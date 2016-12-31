package com.example.android.data.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SampleWpDataProvider {
    public static List<WpItem> sWpList;
    public static Map<String, WpItem> sWpMap;

    static {
        sWpList = new ArrayList<>();
        sWpMap = new HashMap<>();

        addItem(new WpItem(null, "EKRK", null, "1200", "e8d0070b-5544-44ce-99f9-2893318f1af0", "1"));
        addItem(new WpItem(null, "Solrød",3.8,"1200", "e8d0070b-5544-44ce-99f9-2893318f1af0", "2"));
        addItem(new WpItem(null, "Hvidovre",11.5,"1200", "e8d0070b-5544-44ce-99f9-2893318f1af0", "3"));
        addItem(new WpItem(null, "Farum",11.8,"1200", "e8d0070b-5544-44ce-99f9-2893318f1af0", "4"));
        addItem(new WpItem(null, "Ølsted",12.2,"1200", "e8d0070b-5544-44ce-99f9-2893318f1af0", "5"));
        addItem(new WpItem(null, "Holbæk",17.3,"1200", "e8d0070b-5544-44ce-99f9-2893318f1af0", "6"));
        addItem(new WpItem(null, "Eskildsoe",11.5,"1200", "e8d0070b-5544-44ce-99f9-2893318f1af0", "7"));
        addItem(new WpItem(null, "Gundsoelille",2.1,"1200", "e8d0070b-5544-44ce-99f9-2893318f1af0", "8"));
        addItem(new WpItem(null, "EKRK",8.4,"1200", "e8d0070b-5544-44ce-99f9-2893318f1af0", "9"));
        addItem(new WpItem(null, "Store Merløse",15.1,"1200", "e8d0070b-5544-44ce-99f9-2893318f1af0", "10"));
        addItem(new WpItem(null, "Halskov",23.0,"1200", "e8d0070b-5544-44ce-99f9-2893318f1af0", "11"));
        addItem(new WpItem(null, "Sprogø",5.4,"1200", "e8d0070b-5544-44ce-99f9-2893318f1af0", "12"));
        addItem(new WpItem(null, "Knudshoved'",5.6,"1200", "e8d0070b-5544-44ce-99f9-2893318f1af0", "13"));
        addItem(new WpItem(null, "Rolfsted'",8.9,"1200", "e8d0070b-5544-44ce-99f9-2893318f1af0", "14"));
        addItem(new WpItem(null, "Munkebo",8.8,"1200", "e8d0070b-5544-44ce-99f9-2893318f1af0", "15"));
        addItem(new WpItem(null, "Klintebjerg",2.5,"1200", "e8d0070b-5544-44ce-99f9-2893318f1af0", "16"));
        addItem(new WpItem(null, "Otterup",2.2,"1200", "e8d0070b-5544-44ce-99f9-2893318f1af0", "17"));
        addItem(new WpItem(null, "Beldringe",2.9,"1200", "e8d0070b-5544-44ce-99f9-2893318f1af0", "18"));

        addItem(new WpItem(null, "Sengeløse",null,"1200", "6b7ee70a-c8b8-4dac-9003-ed8595163ab1", "1"));
        addItem(new WpItem(null, "Roskilde",5.6,"1200", "6b7ee70a-c8b8-4dac-9003-ed8595163ab1", "2"));

        addItem(new WpItem(null, "WP0",null,"1200", "f1cbb632-eebc-491e-938d-fb1ad693db4b", "1"));
        addItem(new WpItem(null, "WP1",7.6,"1200", "f1cbb632-eebc-491e-938d-fb1ad693db4b", "2"));
        addItem(new WpItem(null, "WP2",7.2,"1200", "f1cbb632-eebc-491e-938d-fb1ad693db4b", "3"));

        addItem(new WpItem(null, "Lejre", null,"1200", "27ed12a9-0a3d-47c2-aac5-3b7cda915d99", "1"));
        addItem(new WpItem(null, "Kr. Såby", 4.0,"1200", "27ed12a9-0a3d-47c2-aac5-3b7cda915d99", "2"));
        addItem(new WpItem(null, "Kr. Hyllinge", 4.9,"1200", "27ed12a9-0a3d-47c2-aac5-3b7cda915d99", "3"));
        addItem(new WpItem(null, "Orø", 4.8,"1200", "27ed12a9-0a3d-47c2-aac5-3b7cda915d99", "4"));
        addItem(new WpItem(null, "Hagested", 7.4,"1200", "27ed12a9-0a3d-47c2-aac5-3b7cda915d99", "5"));
        addItem(new WpItem(null, "Stigs Bjergby", 6.5,"1200", "27ed12a9-0a3d-47c2-aac5-3b7cda915d99", "6"));
        addItem(new WpItem(null, "Verup", 6.9,"1200", "27ed12a9-0a3d-47c2-aac5-3b7cda915d99", "7"));
        addItem(new WpItem(null, "Bromme", 5.0,"1200", "27ed12a9-0a3d-47c2-aac5-3b7cda915d99", "8"));
        addItem(new WpItem(null, "Vrangstrup", 7.3,"1200", "27ed12a9-0a3d-47c2-aac5-3b7cda915d99", "9"));
        addItem(new WpItem(null, "Sneslev", 4.7,"1200", "27ed12a9-0a3d-47c2-aac5-3b7cda915d99", "10"));
        addItem(new WpItem(null, "Gørslev", 6.1,"1200", "27ed12a9-0a3d-47c2-aac5-3b7cda915d99", "11"));
        addItem(new WpItem(null, "Køge", 5.3,"1200", "27ed12a9-0a3d-47c2-aac5-3b7cda915d99", "12"));
        addItem(new WpItem(null, "EKRK", 6.4,"1200", "27ed12a9-0a3d-47c2-aac5-3b7cda915d99", "13"));

        addItem(new WpItem(null, "EKRK", null,"1200", "472bd675-3dfb-4017-80be-410b3a09fa6e", "1"));
        addItem(new WpItem(null, "Store Valby", 6.5,"1200", "472bd675-3dfb-4017-80be-410b3a09fa6e", "2"));
        addItem(new WpItem(null, "Kalred", 29.4,"1200", "472bd675-3dfb-4017-80be-410b3a09fa6e", "3"));
        addItem(new WpItem(null, "TNO VOR", 7.4,"1200", "472bd675-3dfb-4017-80be-410b3a09fa6e", "4"));
        addItem(new WpItem(null, "Tølløse", 14.6,"1200", "472bd675-3dfb-4017-80be-410b3a09fa6e", "5"));
        addItem(new WpItem(null, "Bjæverskov", 13.,"1200", "472bd675-3dfb-4017-80be-410b3a09fa6e", "6"));
        addItem(new WpItem(null, "EKRK", 8.2,"1200", "472bd675-3dfb-4017-80be-410b3a09fa6e", "7"));

        addItem(new WpItem(null, "EKRK", null,"1200", "1df276de-454b-463d-9be5-780869f4503c", "1"));
        addItem(new WpItem(null, "St Valby", 6.6,"1200", "1df276de-454b-463d-9be5-780869f4503c", "2"));
        addItem(new WpItem(null, "WP3", 23.0,"1200", "1df276de-454b-463d-9be5-780869f4503c", "4"));
        addItem(new WpItem(null, "Kalred", 8.9,"1200", "1df276de-454b-463d-9be5-780869f4503c", "5"));
        addItem(new WpItem(null, "Tølløse", 17.5,"1200", "1df276de-454b-463d-9be5-780869f4503c", "6"));
        addItem(new WpItem(null, "Bjæverskov", 13.2,"1200", "1df276de-454b-463d-9be5-780869f4503c", "7"));
        addItem(new WpItem(null, "Køge", 3.8,"1200", "1df276de-454b-463d-9be5-780869f4503c", "8"));
        addItem(new WpItem(null, "EKRK", 6.0,"1200", "1df276de-454b-463d-9be5-780869f4503c", "9"));

    }

    private static void addItem(WpItem wp) {
        sWpList.add(wp);
        sWpMap.put(wp.getWpId(), wp);
    }
}
