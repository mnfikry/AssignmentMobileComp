package com.example.assignmentmobilecomp;

public class Location {
    String address,image,located,phone,title;

    public Location() {
    }

    public Location(String address, String image, String located, String phone, String title) {
        this.address = address;
        this.image = image;
        this.located = located;
        this.phone = phone;
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLocated() {
        return located;
    }

    public void setLocated(String located) {
        this.located = located;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
