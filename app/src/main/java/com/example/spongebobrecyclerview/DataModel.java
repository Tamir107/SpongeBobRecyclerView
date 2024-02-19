package com.example.spongebobrecyclerview;

public class DataModel {
    private String name;
    private String subtext;
    private int image;
    private int id_;
    private String description;

    public DataModel(String name, String version, int image, int id_, String description) {
        this.name = name;
        this.subtext = version;
        this.image = image;
        this.id_ = id_;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getSubtext() {
        return subtext;
    }

    public int getImage() {
        return image;
    }

    public int getId_() {
        return id_;
    }
    public String getDescription() { return description; }

}

