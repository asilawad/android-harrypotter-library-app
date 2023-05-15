package org.asl.mylibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.asl.mylibrary.activities.library_activities.AllBooksActivity;
import org.asl.mylibrary.activities.library_activities.AlreadyReadBooksActivity;
import org.asl.mylibrary.activities.library_activities.CurrentlyReadingActivity;
import org.asl.mylibrary.activities.library_activities.FavouriteBooksActivity;
import org.asl.mylibrary.activities.library_activities.WantToReadActivity;
import org.asl.mylibrary.utils.Utils;

//Main activity file that contain the logic for the main screen of the app
public class MainActivity extends AppCompatActivity {

    // Declare buttons used on the main screen
    private Button btnAllBooks,
            btnAlreadyRead,
            btnWantToRead,
            btnCurrentlyReading,
            btnFavorite,btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //sets the layout of the activity to the activity_main
        setContentView(R.layout.activity_main);

        // Initialize the buttons on the main screen
        initViews();

        // Set click listeners for each button
        btnAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllBooksActivity.class);
                startActivity(intent);
            }
        });


        btnAlreadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AlreadyReadBooksActivity.class);
                startActivity(intent);
            }
        });

        btnCurrentlyReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CurrentlyReadingActivity.class);
                startActivity(intent);
            }
        });
        btnWantToRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WantToReadActivity.class);
                startActivity(intent);
            }
        });

        btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FavouriteBooksActivity.class);
                startActivity(intent);
            }
        });



        Utils.getInstance(this);
    }



//    The initViews method initializes the button variables by finding them in the layout using their IDs.
    private void initViews() {
        btnAllBooks = findViewById(R.id.btnAllBooks);
        btnAlreadyRead = findViewById(R.id.btnAlreadyRead);
        btnWantToRead = findViewById(R.id.btnWantToRead);
        btnCurrentlyReading = findViewById(R.id.btnCurrentlyReading);
        btnFavorite = findViewById(R.id.btnFavorite);
        btnAbout = findViewById(R.id.btnAbout);
    }

}
