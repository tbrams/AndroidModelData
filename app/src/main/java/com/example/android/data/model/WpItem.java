package com.example.android.data.model;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.android.data.database.WpTable;

import java.util.UUID;

public class WpItem implements Parcelable {
    private String wpId;
    private String wpName;
    private Double wpLat;
    private Double wpLon;
    private Double wpDistance;
    private String wpAltitude;
    private String tripIndex;
    private String wpSequenceNumber;


    public WpItem() {
    }

    public WpItem(String id, String wpName, Double lat, Double lon, Double wpDistance, String wpAltitude, String tripIndex, String wpSequenceNumber) {
        if (wpId == null) {
            this.wpId= UUID.randomUUID().toString();
        } else {
            this.wpId=id;
        }
        this.wpName = wpName;
        this.wpLat = lat;
        this.wpLon = lon;
        this.wpDistance = wpDistance;
        this.wpAltitude = wpAltitude;
        this.tripIndex = tripIndex;
        this.wpSequenceNumber = wpSequenceNumber;
    }

    public String getWpId() {
        return wpId;
    }

    public void setWpId(String wpId) {
        this.wpId = wpId;
    }

    public String getWpName() {
        return wpName;
    }

    public void setWpName(String wpName) {
        this.wpName = wpName;
    }

    public Double getWpLat() {
        return wpLat;
    }

    public void setWpLat(Double wpLat) {
        this.wpLat = wpLat;
    }

    public Double getWpLon() {
        return wpLon;
    }

    public void setWpLon(Double wpLon) {
        this.wpLon = wpLon;
    }

    public Double getWpDistance() {
        return wpDistance;
    }

    public void setWpDistance(Double wpDistance) {
        this.wpDistance = wpDistance;
    }

    public String getWpAltitude() {
        return wpAltitude;
    }

    public void setWpAltitude(String wpAltitude) {
        this.wpAltitude = wpAltitude;
    }

    public String getTripIndex() {
        return tripIndex;
    }

    public void setTripIndex(String tripIndex) {
        this.tripIndex = tripIndex;
    }

    public String getWpSequenceNumber() {
        return wpSequenceNumber;
    }

    public void setWpSequenceNumber(String wpSequenceNumber) {
        this.wpSequenceNumber = wpSequenceNumber;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues(6);

        values.put(WpTable.COLUMN_ID, wpId);
        values.put(WpTable.COLUMN_NAME, wpName);
        values.put(WpTable.COLUMN_LAT, wpLat);
        values.put(WpTable.COLUMN_LON, wpLon);
        values.put(WpTable.COLUMN_ALT, wpAltitude);
        values.put(WpTable.COLUMN_DIST, wpDistance);
        values.put(WpTable.COLUMN_TRIP_ID, tripIndex);
        values.put(WpTable.COLUMN_SEQUENCE_NUMBER, wpSequenceNumber);

        return values;
    }

    @Override
    public String toString() {
        return "WpItem{" +
                "wpId='" + wpId + '\'' +
                ", wpName='" + wpName + '\'' +
                ", wpLat=" + wpLat +
                ", wpLon=" + wpLon +
                ", wpDistance=" + wpDistance +
                ", wpAltitude='" + wpAltitude + '\'' +
                ", tripIndex='" + tripIndex + '\'' +
                ", wpSequenceNumber='" + wpSequenceNumber + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.wpId);
        dest.writeString(this.wpName);
        dest.writeValue(this.wpLat);
        dest.writeValue(this.wpLon);
        dest.writeValue(this.wpDistance);
        dest.writeString(this.wpAltitude);
        dest.writeString(this.tripIndex);
        dest.writeString(this.wpSequenceNumber);
    }

    protected WpItem(Parcel in) {
        this.wpId = in.readString();
        this.wpName = in.readString();
        this.wpLat = (Double) in.readValue(Double.class.getClassLoader());
        this.wpLon = (Double) in.readValue(Double.class.getClassLoader());
        this.wpDistance = (Double) in.readValue(Double.class.getClassLoader());
        this.wpAltitude = in.readString();
        this.tripIndex = in.readString();
        this.wpSequenceNumber = in.readString();
    }

    public static final Parcelable.Creator<WpItem> CREATOR = new Parcelable.Creator<WpItem>() {
        @Override
        public WpItem createFromParcel(Parcel source) {
            return new WpItem(source);
        }

        @Override
        public WpItem[] newArray(int size) {
            return new WpItem[size];
        }
    };
}
