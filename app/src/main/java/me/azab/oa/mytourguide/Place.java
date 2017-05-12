package me.azab.oa.mytourguide;

/**
 * Created by omar on 5/11/2017.
 */

public class Place {

    private String name;
    private int image;
    private String descirption;
    private String locationUrl;

    public Place() {
    }

    public Place(String name, int image, String descirption, String locationUrl) {
        this.name = name;
        this.image = image;
        this.descirption = descirption;
        this.locationUrl = locationUrl;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getDescirption() {
        return descirption;
    }

    public String getLocationUrl() {
        return locationUrl;
    }
}
