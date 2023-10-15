package com.example.rutujamundhe_assignment1_elibraryapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;


// This class addresses the custom adapter for the book GridView.

public class BookAdapter extends BaseAdapter {

    private MainActivity mainActivity;
    private List<Book> books;
    private OnBookSelectedListener bookSelectedListener;

    // Interface to handle book selection and deselection events
    public interface OnBookSelectedListener {
        void onBookSelected(Book book);
        void onBookDeselected(Book book);
    }

    // Constructor for making a BookAdapter object.
    public BookAdapter(MainActivity mainActivity, List<Book> books, OnBookSelectedListener bookSelectedListener) {
        this.mainActivity = mainActivity;
        this.books = books;
        this.bookSelectedListener = bookSelectedListener;
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int position) {
        return books.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {

            view = LayoutInflater.from(mainActivity).inflate(R.layout.book_item, parent, false);
        }

        // Get the book object at the current position.
        Book book = books.get(position);

        ImageView bookImage = view.findViewById(R.id.bookImage);
        CheckBox bookCheckBox = view.findViewById(R.id.bookCheckBox);
        TextView bookPrice = view.findViewById(R.id.bookPrice);

        // Set the book image
        bookImage.setImageResource(book.getImage());

        // Set the price of the book
        bookPrice.setText("Price: $" + book.getPrice());

        // Set the CheckBox state
        bookCheckBox.setChecked(book.isChecked());

        // Add an OnCheckedChangeListener to the CheckBox to deal with book checked and unrestrained.
        bookCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            book.setChecked(isChecked);
            if (isChecked) {
                bookSelectedListener.onBookSelected(book);
            } else {
                bookSelectedListener.onBookDeselected(book);
            }
        });

        return view;
    }
}
