package org.diiage.delbano.chillindijondelbano;

/**
 * Created by Bastien on 16/03/2018.
 */

public class Signboard {

    private String id;
    private String type;
    private String name;
    private Location location;

    public Signboard(String id, String type, String name, Location location) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.location = location;
    }


    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
