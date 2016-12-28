package com.example.android.data.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SampleDataProvider {
    public static List<DataItem> sDataItemList;
    public static Map<String, DataItem> sDataItemMap;

    static {
        sDataItemList = new ArrayList<>();
        sDataItemMap = new HashMap<>();
    }
}
