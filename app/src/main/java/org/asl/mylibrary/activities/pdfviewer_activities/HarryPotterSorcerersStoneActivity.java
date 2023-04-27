package org.asl.mylibrary.activities.pdfviewer_activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.github.barteksc.pdfviewer.PDFView;

import org.asl.mylibrary.MainActivity;
import org.asl.mylibrary.R;

public class HarryPotterSorcerersStoneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_book);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        PDFView pdfView = findViewById(R.id.pdfView);
        pdfView.fromAsset("sorcerers_stone.pdf").load();


    }


    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

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









