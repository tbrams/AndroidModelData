package com.example.android.data.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SampleTripDataProvider {
    public static List<TripItem> sTripList;
    public static Map<String, TripItem> sTripMap;

    static {
        sTripList = new ArrayList<>();
        sTripMap = new HashMap<>();

        addItem(new TripItem("e8d0070b-5544-44ce-99f9-2893318f1af0", "Experiment 1 / EKRK - EKOD","11/16/2016", 152.8));
        addItem(new TripItem("6b7ee70a-c8b8-4dac-9003-ed8595163ab1", "Testing / Sengeloese-Roskilde","11/17/2016", 3.4));
        addItem(new TripItem("f1cbb632-eebc-491e-938d-fb1ad693db4b", "Back home to Tølløse","11/19/2016", 14.0));
        addItem(new TripItem("27ed12a9-0a3d-47c2-aac5-3b7cda915d99", "Rundt på Sjælland","11/21/2016", 64.0));
        addItem(new TripItem("472bd675-3dfb-4017-80be-410b3a09fa6e", "Navigation #23","11/23/2016", 79.0));
        addItem(new TripItem("1df276de-454b-463d-9be5-780869f4503c", "Eksperiment","11/24/2016", 78.9));
    }

    private static void addItem(TripItem trip) {
        sTripList.add(trip);
        sTripMap.put(trip.getTripId(), trip);
    }
}
