package com.example.torsh.screenrotaion;

import android.content.res.Configuration;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private Button button;
    private TextView textView;
    private final String KEY_MESSAGE = "message";
    private final String KEY_BTN_TEXT = "btn1_text";
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // if in landscape mode Android looks for activity_main.xml in layout-land directory!
        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate");

        button = (Button) findViewById(R.id.btn1);
        textView = (TextView) findViewById(R.id.tv1);
        imageView = (ImageView) findViewById(R.id.imageView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setText("LOGOUT");
                textView.setText("Testing ...");
            }
        });
    }

    // for storing values of text field and buttons during rotation
    // use unique id's for widgets to restore their values
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);

        Log.i(TAG, "onRestoreInstanceState()");

        // the if -statement can be moved inside onCreate method
        // since onCreate has saveInstanceState as parameter
        // This will eliminate the explicit use of onRestoreInstanceState method
        // but the code is more clean in this way, improved readability
        // but a few extra method calls ...!
        if(savedInstanceState != null) {
            button.setText(savedInstanceState.getString(KEY_BTN_TEXT));
            textView.setText(savedInstanceState.getString(KEY_MESSAGE));
        }

    }

    // for getting the saved values from the destroyed activity
    // KEY's are the same in onRestore... and onSaveInst... methods
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        Log.i(TAG, "onSaveInstanceState()");

        outState.putString(KEY_MESSAGE, textView.getText().toString());
        outState.putString(KEY_BTN_TEXT, button.getText().toString());
    }

    // For manual configuration change use onConfigurationChanged()
    // to update the resources
    // This way is not recommended and it is against the guidelines !!
    // 1st add android:configChanges = "orientation|screenSize" to manifest file
    // inside the activity tag
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        Log.i(TAG, "onConfigurationChanged()");

        // newConfig is a Configuration object that stores config data
        // change image according to the screen orientation
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(getApplicationContext(), "Portrait Mode", Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.portrait_im);
        } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(getApplicationContext(), "Landscape Mode", Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.landscape_im);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }



}
