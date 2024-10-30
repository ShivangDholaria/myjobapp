package com.jobapp.myjobapp.model;

public class Job {
    private Long id;
    private String title;
    private String description;
    private String minSal;
    private String maxSal;
    private String location;
    

    public Job(Long id, String title, String description, String minSal, String maxSal, String location) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.minSal = minSal;
        this.maxSal = maxSal;
        this.location = location;
    }


    public Long getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }


    public String getDescription() {
        return description;
    }


    public String getMinSal() {
        return minSal;
    }


    public String getMaxSal() {
        return maxSal;
    }


    public String getLocation() {
        return location;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public void setMinSal(String minSal) {
        this.minSal = minSal;
    }


    public void setMaxSal(String maxSal) {
        this.maxSal = maxSal;
    }


    public void setLocation(String location) {
        this.location = location;
    }
    
}
