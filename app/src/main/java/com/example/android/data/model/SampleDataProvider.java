package com.example.android.data.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SampleDataProvider {
    public static List<TripItem> sTripList;
    public static Map<String, TripItem> sTripMap;

    static {
        sTripList = new ArrayList<>();
        sTripMap = new HashMap<>();

        addItem(new TripItem(null, "Experiment 1 / EKRK - EKOD","11/16/2016", 152.8));
        addItem(new TripItem(null, "Testing / Sengeloese-Roskilde","11/17/2016", 3.4));
        addItem(new TripItem(null, "Back home to Tølløse","11/19/2016", 14.0));
        addItem(new TripItem(null, "Rundt på Sjælland","11/21/2016", 64.0));
        addItem(new TripItem(null, "Navigation #23","11/23/2016", 79.0));
        addItem(new TripItem(null, "Eksperiment","11/24/2016", 78.9));
    }

    private static void addItem(TripItem trip) {
        sTripList.add(trip);
        sTripMap.put(trip.getTripId(), trip);
    }
}
