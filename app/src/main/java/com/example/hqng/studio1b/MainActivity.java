package com.example.hqng.studio1b;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button uploadImage = (Button) findViewById(R.id.button4);
        uploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangePhotoDialog dialog = new ChangePhotoDialog();
                dialog.show(getFragmentManager(), getString(R.string.change_photo_dialog));
            }
        });
    }

    /**
     * Compress a bitmap by the @param "quality"
     * Quality can be anywhere from 1 -100 : 100 being the highest quality.
     * @param bitmap
     * @param quality
     * @return
     */
    public Bitmap compressBitmap(Bitmap bitmap, int quality){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, quality, stream);
        return bitmap;
    }
}
