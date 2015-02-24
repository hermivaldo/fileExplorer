package br.com.example.androidfileexplorer;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;


@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MainActivity extends Activity {

    private static final int REQUEST_PATH = 1;
    String curFileName;    
    EditText edittext;
    ImageView mImage;
	private ViewGroup mV;
    
    @Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mV = (ViewGroup) findViewById(R.id.tela);
    
    mImage = (ImageView) findViewById(R.id.imageView1);
    edittext = (EditText)findViewById(R.id.editText);
}

public void getfile(View view){
    Intent intent1 = new Intent(this, FileChooser.class);
    startActivityForResult(intent1,REQUEST_PATH);
}
// Listen for results.
protected void onActivityResult(int requestCode, int resultCode, Intent data){
    // See which child activity is calling us back.
    if (requestCode == REQUEST_PATH){
            if (resultCode == RESULT_OK) {
            	
                    curFileName = data.getStringExtra("GetFileName");
                    Bitmap map = BitmapFactory.decodeFile(curFileName);
                    mImage.setImageBitmap(map);
                    edittext.setText(curFileName);
                    this.mV.invalidate();
                    this.setContentView(mV);
                    
            }
     }
}
}