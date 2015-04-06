package com.example.priteshpatel.captureimage;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {

    static final int REQUSET_IMAGE_CAPTURE=1;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn=(Button)findViewById(R.id.psbutton);
        iv=(ImageView)findViewById(R.id.psimageView);
        //Disable the button if user has no camera
        if(!hasCamera())
        {
            btn.setEnabled(false);
        }
    }
    private boolean hasCamera(){
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }
    //Launch camera on take picture button
    public void launchCamera(View view){
        Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //Take a picture and send it onActivity
        startActivityForResult(i,REQUSET_IMAGE_CAPTURE);

    }
    //get Image on Take picture


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUSET_IMAGE_CAPTURE && resultCode==RESULT_OK)
        {
            //Get photo
            Bundle extras=data.getExtras();
            Bitmap pic=(Bitmap)extras.get("data");
            iv.setImageBitmap(pic);
        }
    }
}
