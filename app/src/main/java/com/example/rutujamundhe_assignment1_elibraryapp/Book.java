package com.example.rutujamundhe_assignment1_elibraryapp;

public class Book {

    private String title;
    private int imageResource;
    private double price;
    private boolean isChecked;

    public Book(String title, int imageResource, double price) {
        this.title = title;
        this.imageResource = imageResource;
        this.price = price;
        this.isChecked = false;
    }

    public String getTitle() {
        return title;
    }

    public int getImageResource() {
        return imageResource;
    }

    public double getPrice() {
        return price;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
