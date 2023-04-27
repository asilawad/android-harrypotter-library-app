package org.asl.mylibrary.activities.bookdetails_activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;


import org.asl.mylibrary.activities.pdfviewer_activities.ChamberSecretActivity;
import org.asl.mylibrary.activities.library_activities.CurrentlyReadingActivity;
import org.asl.mylibrary.activities.pdfviewer_activities.DeathlyHallowsActivity;
import org.asl.mylibrary.activities.library_activities.FavouriteBooksActivity;
import org.asl.mylibrary.activities.pdfviewer_activities.GobletFireActivity;
import org.asl.mylibrary.activities.pdfviewer_activities.Half_bloodPrinceActivity;
import org.asl.mylibrary.activities.pdfviewer_activities.HarryPotterSorcerersStoneActivity;
import org.asl.mylibrary.activities.pdfviewer_activities.OrderPhoenixActivity;
import org.asl.mylibrary.activities.pdfviewer_activities.PrisonerAzkabanActivity;
import org.asl.mylibrary.R;
import org.asl.mylibrary.activities.pdfviewer_activities.TheCursedChildActivity;
import org.asl.mylibrary.activities.library_activities.AlreadyReadBooksActivity;
import org.asl.mylibrary.utils.Utils;
import org.asl.mylibrary.activities.library_activities.WantToReadActivity;
import org.asl.mylibrary.models.Book;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    public static final String BOOK_ID_KEY = "bookId";
    private TextView txtBookName, txtAuthor, txtPages, txtDescription;
    private Button btnAddToWantToRead, btnAddToAlreadyRead, btnAddToCurrentlyReading, btnAddToFavourite , btnOpenBook;
    private ImageView bookImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initViews();

        Intent intent = getIntent();
        if(null != intent){
            int bookId = intent.getIntExtra(BOOK_ID_KEY,-1);

            if(bookId != -1){
                Book incomingBook = Utils.getInstance(this).getBookById(bookId);
                if(null != incomingBook){
                    setDta(incomingBook);

                    handleAlreadyRead(incomingBook);
                    handleWantToyReadBooks(incomingBook);
                    handleCurrentlyReadingBooks(incomingBook);
                    handleFavouriteBooks(incomingBook);
                    handleOpenBook(incomingBook);


                }
            }
        }



    }

    private void handleOpenBook(final Book incomingBook) {

        btnOpenBook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    switch (incomingBook.getId()) {
                        case 1:
                            Intent intent = new Intent(BookActivity.this, HarryPotterSorcerersStoneActivity.class);
                            startActivity(intent);
                            break;

                        case 2: Intent intent2 = new Intent(BookActivity.this, ChamberSecretActivity.class);
                            startActivity(intent2);
                            break;

                        case 3: Intent intent3 = new Intent(BookActivity.this, PrisonerAzkabanActivity.class);
                            startActivity(intent3);
                            break;

                        case 4: Intent intent4 = new Intent(BookActivity.this, GobletFireActivity.class);
                            startActivity(intent4);
                            break;

                        case 5: Intent intent5 = new Intent(BookActivity.this, OrderPhoenixActivity.class);
                            startActivity(intent5);
                            break;

                        case 6: Intent intent6 = new Intent(BookActivity.this, Half_bloodPrinceActivity.class);
                            startActivity(intent6);
                            break;

                        case 7: Intent intent7 = new Intent(BookActivity.this, DeathlyHallowsActivity.class);
                            startActivity(intent7);
                            break;

                        case 8: Intent intent8 = new Intent(BookActivity.this, TheCursedChildActivity.class);
                            startActivity(intent8);
                            break;

                        default:
                            break;
                    }




                }

            });

    }


    private void handleFavouriteBooks(final Book book) {

        ArrayList<Book> favouriteBooks = Utils.getInstance(this).getFavoriteBooks();
        boolean existFavouriteBooks = false;

        for(Book b : favouriteBooks){
            if(b.getId()== book.getId()){
                existFavouriteBooks = true;
            }
        }

        if(existFavouriteBooks){
            btnAddToFavourite.setEnabled(false);
        }else{
            btnAddToFavourite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(Utils.getInstance(BookActivity.this).addToFavourite(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this, FavouriteBooksActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(BookActivity.this, "Something wrong happened, try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleCurrentlyReadingBooks(final Book book) {

        ArrayList<Book> currentlyReadingBooks = Utils.getInstance(this).getCurrentlyReadingBooks();
        boolean existCurrentlyReadingBooks = false;

        for(Book b : currentlyReadingBooks){
            if(b.getId()== book.getId()){
                existCurrentlyReadingBooks = true;
            }
        }

        if(existCurrentlyReadingBooks){
            btnAddToCurrentlyReading.setEnabled(false);
        }else{
            btnAddToCurrentlyReading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(Utils.getInstance(BookActivity.this).addToCurrentlyReading(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this, CurrentlyReadingActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(BookActivity.this, "Something wrong happened, try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleWantToyReadBooks(final Book book) {

        ArrayList<Book> wantToReadBooks = Utils.getInstance(this).getWantToReadBooks();
        boolean existWantToReadBooks = false;

        for(Book b : wantToReadBooks){
            if(b.getId()== book.getId()){
                existWantToReadBooks = true;
            }
        }

        if(existWantToReadBooks){
            btnAddToWantToRead.setEnabled(false);
        }else{
            btnAddToWantToRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(Utils.getInstance(BookActivity.this).addToWantToRead(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this, WantToReadActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(BookActivity.this, "Something wrong happened, try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleAlreadyRead(final Book book) {                                                //Enable and disabled the button,Add the book to Already Read Book ArrayList
        ArrayList<Book> alreadyReadBook = Utils.getInstance(this).getAlreadyReadBooks();
        boolean existInAlreadyReadBook = false;

        for(Book b : alreadyReadBook){
            if(b.getId()== book.getId()){
                existInAlreadyReadBook = true;
            }
        }

        if(existInAlreadyReadBook){
            btnAddToAlreadyRead.setEnabled(false);
        }else{
            btnAddToAlreadyRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(Utils.getInstance(BookActivity.this).addToAlreadyRead(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this, AlreadyReadBooksActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(BookActivity.this, "Something wrong happened, try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setDta(Book book) {

        txtBookName.setText(book.getName());
        txtAuthor.setText(book.getAuthor());
        txtPages.setText(String.valueOf(book.getPages()));
        txtDescription.setText(book.getLongDesc());
        Glide.with(this)
                .asBitmap().load(book.getImageUrl())
                .into(bookImage);
    }

    private void initViews() {

        txtBookName = findViewById(R.id.txtBookName);
        txtAuthor = findViewById(R.id.txtAuthor);
        txtPages = findViewById(R.id.txtPages);
        txtDescription = findViewById(R.id.lab_longDesc);

        btnAddToWantToRead = findViewById(R.id.btnWantToRead);
        btnAddToAlreadyRead = findViewById(R.id.btnAlreadyRead);
        btnAddToCurrentlyReading = findViewById(R.id.btnCurrentlyReading);
        btnAddToFavourite = findViewById(R.id.btnAddToFavourite);
        btnOpenBook = findViewById(R.id.btnOpenBook);

        bookImage = findViewById(R.id.imgBook);

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home: onBackPressed(); break;
            default: break;
        }
        return super.onOptionsItemSelected(item);
    }
}
