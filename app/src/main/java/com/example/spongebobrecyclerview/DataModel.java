package com.example.spongebobrecyclerview;

public class DataModel {
    private String name;
    private String version;
    private int image;
    private int id_;

    public DataModel(String name, String version, int image, int id_) {
        this.name = name;
        this.version = version;
        this.image = image;
        this.id_ = id_;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public int getImage() {
        return image;
    }

    public int getId_() {
        return id_;
    }
}
