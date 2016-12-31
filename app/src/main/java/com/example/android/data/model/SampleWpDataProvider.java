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

        addItem(new WpItem(null, "EKRK", 55.59,	12.13, null, "1200", "e8d0070b-5544-44ce-99f9-2893318f1af0", "1"));
        addItem(new WpItem(null, "Solrød", 55.53, 12.18,3.8,"1200", "e8d0070b-5544-44ce-99f9-2893318f1af0", "2"));
        addItem(new WpItem(null, "Hvidovre", 55.63, 12.47,11.5,"1200", "e8d0070b-5544-44ce-99f9-2893318f1af0", "3"));
        addItem(new WpItem(null, "Farum", 55.82, 12.37,11.8,"1200", "e8d0070b-5544-44ce-99f9-2893318f1af0", "4"));
        addItem(new WpItem(null, "Ølsted", 55.92, 12.06,12.2,"1200", "e8d0070b-5544-44ce-99f9-2893318f1af0", "5"));
        addItem(new WpItem(null, "Holbæk", 55.70, 11.74, 17.3,"1200", "e8d0070b-5544-44ce-99f9-2893318f1af0", "6"));
        addItem(new WpItem(null, "Eskildsoe", 55.73, 12.08, 11.5,"1200", "e8d0070b-5544-44ce-99f9-2893318f1af0", "7"));
        addItem(new WpItem(null, "Gundsoelille", 55.72, 12.13, 2.1,"1200", "e8d0070b-5544-44ce-99f9-2893318f1af0", "8"));
        addItem(new WpItem(null, "EKRK", 55.58, 12.15, 8.4,"1200", "e8d0070b-5544-44ce-99f9-2893318f1af0", "9"));
        addItem(new WpItem(null, "Store Merløse", 55.54, 11.71,15.1,"1200", "e8d0070b-5544-44ce-99f9-2893318f1af0", "10"));
        addItem(new WpItem(null, "Halskov", 55.35, 11.13, 23.0,"1200", "e8d0070b-5544-44ce-99f9-2893318f1af0", "11"));
        addItem(new WpItem(null, "Sprogø", 55.34, 10.98, 5.4,"1200", "e8d0070b-5544-44ce-99f9-2893318f1af0", "12"));
        addItem(new WpItem(null, "Knudshoved", 55.30, 10.83, 5.6,"1200", "e8d0070b-5544-44ce-99f9-2893318f1af0", "13"));
        addItem(new WpItem(null, "Rolfsted'", 55.32, 10.57, 8.9,"1200", "e8d0070b-5544-44ce-99f9-2893318f1af0", "14"));
        addItem(new WpItem(null, "Munkebo", 55.46, 10.51, 8.8,"1200", "e8d0070b-5544-44ce-99f9-2893318f1af0", "15"));
        addItem(new WpItem(null, "Klintebjerg", 55.48, 10.45, 2.5,"1200", "e8d0070b-5544-44ce-99f9-2893318f1af0", "16"));
        addItem(new WpItem(null, "Otterup", 55.50, 10.39, 2.2,"1200", "e8d0070b-5544-44ce-99f9-2893318f1af0", "17"));
        addItem(new WpItem(null, "Beldringe", 55.47, 10.33, 2.9,"1200", "e8d0070b-5544-44ce-99f9-2893318f1af0", "18"));

        addItem(new WpItem(null, "Sengeløse", 55.68, 12.23, null,"1200", "6b7ee70a-c8b8-4dac-9003-ed8595163ab1", "1"));
        addItem(new WpItem(null, "Roskilde", 55.64, 12.08, 5.6,"1200", "6b7ee70a-c8b8-4dac-9003-ed8595163ab1", "2"));

        addItem(new WpItem(null, "WP0", 55.64, 12.09, null,"1200", "f1cbb632-eebc-491e-938d-fb1ad693db4b", "1"));
        addItem(new WpItem(null, "WP1", 55.71, 11.90, 7.6,"1200", "f1cbb632-eebc-491e-938d-fb1ad693db4b", "2"));
        addItem(new WpItem(null, "WP2", 55.61, 11.77, 7.2,"1200", "f1cbb632-eebc-491e-938d-fb1ad693db4b", "3"));

        addItem(new WpItem(null, "Lejre", 55.60, 11.97, null,"1200", "27ed12a9-0a3d-47c2-aac5-3b7cda915d99", "1"));
        addItem(new WpItem(null, "Kr. Såby", 55.65, 11.88, 4.0,"1200", "27ed12a9-0a3d-47c2-aac5-3b7cda915d99", "2"));
        addItem(new WpItem(null, "Kr. Hyllinge", 55.72, 11.92, 4.9,"1200", "27ed12a9-0a3d-47c2-aac5-3b7cda915d99", "3"));
        addItem(new WpItem(null, "Orø", 55.78, 11.81, 4.8,"1200", "27ed12a9-0a3d-47c2-aac5-3b7cda915d99", "4"));
        addItem(new WpItem(null, "Hagested", 55.75,	11.60, 7.4,"1200", "27ed12a9-0a3d-47c2-aac5-3b7cda915d99", "5"));
        addItem(new WpItem(null, "Stigs Bjergby", 55.67, 11.46, 6.5,"1200", "27ed12a9-0a3d-47c2-aac5-3b7cda915d99", "6"));
        addItem(new WpItem(null, "Verup", 55.56, 11.51, 6.9,"1200", "27ed12a9-0a3d-47c2-aac5-3b7cda915d99", "7"));
        addItem(new WpItem(null, "Bromme", 55.48, 11.53, 5.0,"1200", "27ed12a9-0a3d-47c2-aac5-3b7cda915d99", "8"));
        addItem(new WpItem(null, "Vrangstrup", 55.40, 11.70, 7.3,"1200", "27ed12a9-0a3d-47c2-aac5-3b7cda915d99", "9"));
        addItem(new WpItem(null, "Sneslev", 55.39, 11.84, 4.7,"1200", "27ed12a9-0a3d-47c2-aac5-3b7cda915d99", "10"));
        addItem(new WpItem(null, "Gørslev", 55.44, 11.99, 6.1,"1200", "27ed12a9-0a3d-47c2-aac5-3b7cda915d99", "11"));
        addItem(new WpItem(null, "Køge",55.48, 12.13, 5.3,"1200", "27ed12a9-0a3d-47c2-aac5-3b7cda915d99", "12"));
        addItem(new WpItem(null, "EKRK", 55.59, 12.13, 6.4,"1200", "27ed12a9-0a3d-47c2-aac5-3b7cda915d99", "13"));

        addItem(new WpItem(null, "EKRK", 55.59, 12.13, null,"1200", "472bd675-3dfb-4017-80be-410b3a09fa6e", "1"));
        addItem(new WpItem(null, "Store Valby", 55.69, 12.13, 6.5,"1200", "472bd675-3dfb-4017-80be-410b3a09fa6e", "2"));
        addItem(new WpItem(null, "Kalred", 55.70, 11.26, 29.4,"1200", "472bd675-3dfb-4017-80be-410b3a09fa6e", "3"));
        addItem(new WpItem(null, "TNO VOR", 55.77, 11.44, 7.4,"1200", "472bd675-3dfb-4017-80be-410b3a09fa6e", "4"));
        addItem(new WpItem(null, "Tølløse", 55.61, 11.76, 14.6,"1200", "472bd675-3dfb-4017-80be-410b3a09fa6e", "5"));
        addItem(new WpItem(null, "Bjæverskov", 55.46, 12.03, 13.,"1200", "472bd675-3dfb-4017-80be-410b3a09fa6e", "6"));
        addItem(new WpItem(null, "Køge", 55.48, 12.14, 4.0, "1200", "472bd675-3dfb-4017-80be-410b3a09fa6e", "7"));
        addItem(new WpItem(null, "EKRK",  55.58, 12.13, 8.2,"1200", "472bd675-3dfb-4017-80be-410b3a09fa6e", "8"));

        addItem(new WpItem(null, "EKRK", 55.59, 12.13, null,"1200", "1df276de-454b-463d-9be5-780869f4503c", "1"));
        addItem(new WpItem(null, "St Valby", 55.69, 12.14, 6.6,"1200", "1df276de-454b-463d-9be5-780869f4503c", "2"));
        addItem(new WpItem(null, "WP3", 55.79, 11.48, 23.0,"1200", "1df276de-454b-463d-9be5-780869f4503c", "4"));
        addItem(new WpItem(null, "Kalred", 55.70, 11.27, 8.9,"1200", "1df276de-454b-463d-9be5-780869f4503c", "5"));
        addItem(new WpItem(null, "Tølløse", 55.61, 11.76, 17.5,"1200", "1df276de-454b-463d-9be5-780869f4503c", "6"));
        addItem(new WpItem(null, "Bjæverskov", 55.46, 12.03, 13.2,"1200", "1df276de-454b-463d-9be5-780869f4503c", "7"));
        addItem(new WpItem(null, "Køge", 55.48, 12.14, 3.8,"1200", "1df276de-454b-463d-9be5-780869f4503c", "8"));
        addItem(new WpItem(null, "EKRK", 55.58, 12.13, 6.0,"1200", "1df276de-454b-463d-9be5-780869f4503c", "9"));

    }

    private static void addItem(WpItem wp) {
        sWpList.add(wp);
        sWpMap.put(wp.getWpId(), wp);
    }
}
