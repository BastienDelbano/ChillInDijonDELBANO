package org.diiage.delbano.chillindijondelbano;

/**
 * Created by Bastien on 16/03/2018.
 */

public class Location {
    private String address;
    private String postalCode;
    private String city;
    private android.location.Location position;

    public Location(String address, String postalCode, String city, android.location.Location position) {
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.position = position;
    }

    public String getAddress() {
        return address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public android.location.Location getLatitude() {
        return position;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setLatitude(android.location.Location position) {
        this.position = position;
    }

}
