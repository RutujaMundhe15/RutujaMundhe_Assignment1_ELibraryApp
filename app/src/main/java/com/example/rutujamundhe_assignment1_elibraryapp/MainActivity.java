package com.example.rutujamundhe_assignment1_elibraryapp;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BookAdapter.OnBookSelectedListener {

    private List<Book> books;
    private TextView totalCost;
    private LinearLayout selectedBooksLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instate UI components
        GridView bookGridView = findViewById(R.id.bookGridView);
        totalCost = findViewById(R.id.totalCostTextView);
        selectedBooksLayout = findViewById(R.id.selectedBooksLayout);

        // Instate a rundown of Book objects with titles, pictures, and costs.
        books = new ArrayList<>();
        books.add(new Book("Different Winter", R.drawable.book1, 10.0));
        books.add(new Book("The Psychology of Money", R.drawable.book2, 15.0));
        books.add(new Book("The Girl with no Name", R.drawable.book3, 15.0));
        books.add(new Book("Rich Dad Poor Dad", R.drawable.book4, 15.0));
        books.add(new Book("Dark Paradise", R.drawable.book5, 15.0));
        books.add(new Book("Regretting You", R.drawable.book6, 15.0));
        books.add(new Book("If You Tell", R.drawable.book7, 15.0));
        books.add(new Book("The Silent Patient", R.drawable.book8, 15.0));
        books.add(new Book("From Blood and Ash", R.drawable.book9, 15.0));


        BookAdapter bookAdapter = new BookAdapter(this, books, this);
        bookGridView.setAdapter(bookAdapter);

        // Making a custom BookAdapter and set it for the GridView
        bookGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CheckBox checkBox = view.findViewById(R.id.bookCheckBox);
                boolean isChecked = checkBox.isChecked();
                Book book = books.get(position);

                if (isChecked) {
                    onBookSelected(book); //Calling method
                } else {
                    onBookDeselected(book); //Calling method
                }
            }
        });
    }

    @Override
    public void onBookSelected(Book book) {
        addSelectedBook(book); //Implemented logic to add Book
        updateSelectedBooks(); // Method call if updated
    }

    @Override
    public void onBookDeselected(Book book) {
        removeSelectedBook(book); // Implement the logic to delete the Book
        updateSelectedBooks(); // Method call if Updated
    }

    //This technique is made to show the chose books in another format
    void updateSelectedBooks() {
        selectedBooksLayout.removeAllViews(); // Clear the layout

        double totalAmount = 0.0;

        for (Book book : books) {
            if (book.isChecked()) {
                // Make another view for each chosen book
                LinearLayout bookLayout = new LinearLayout(this);
                bookLayout.setOrientation(LinearLayout.VERTICAL);

                TextView bookTitle = new TextView(this);
                bookTitle.setText("Title: " + book.getTitle());

                // Set the text size (in sp - scale-independent pixels)
                float textSizeInSp = 18;
                bookTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSizeInSp);

                bookLayout.addView(bookTitle);


                TextView priceTextView = new TextView(this);
                priceTextView.setText("Price: $" + book.getPrice());

                priceTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSizeInSp);
                bookLayout.addView(priceTextView);

                selectedBooksLayout.addView(bookLayout);

                totalAmount += book.getPrice();
            }
        }

        totalCost.setText("Total Cost: $" + totalAmount);
    }


    // Add the chose book to the list
    void addSelectedBook(Book book) {
        book.setChecked(true);
    }

    // Remove the deselected book from the list
    void removeSelectedBook(Book book) {
        book.setChecked(false);
    }
}
