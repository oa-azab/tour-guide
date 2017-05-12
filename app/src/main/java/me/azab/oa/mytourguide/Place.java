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

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescirption() {
        return descirption;
    }

    public void setDescirption(String descirption) {
        this.descirption = descirption;
    }

    public String getLocationUrl() {
        return locationUrl;
    }

    public void setLocationUrl(String locationUrl) {
        this.locationUrl = locationUrl;
    }
}
