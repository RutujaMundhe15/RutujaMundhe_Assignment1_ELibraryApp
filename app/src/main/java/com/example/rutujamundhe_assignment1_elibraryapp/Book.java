package com.example.rutujamundhe_assignment1_elibraryapp;


/*This code defines a Book class with attributes for title, image ID, price, and a selection status.
It provides methods to access and modify these attributes for book objects.*/
public class Book {

    private String title;
    private int image;
    private double price;
    private boolean isChecked;

    // Constructor for making a Book object.
    public Book(String title, int image, double price) {
        this.title = title;
        this.image = image;
        this.price = price;
        this.isChecked = false;
    }

    // Get the title of the book.
    public String getTitle()
    {
        return title;
    }

    // Get the ID of the book's picture.
    public int getImage()
    {
        return image;
    }

    // Get the price of the book.
    public double getPrice()
    {
        return price;
    }

    // Check if the book is selected or not.
    public boolean isChecked()
    {
        return isChecked;
    }

    // Set the status.
    public void setChecked(boolean checked)
    {
        isChecked = checked;
    }
}
