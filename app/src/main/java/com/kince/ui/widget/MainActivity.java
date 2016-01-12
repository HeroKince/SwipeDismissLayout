package com.kince.ui.widget;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements SwipeDismissLayout.OnDismissedListener, SwipeDismissLayout.OnSwipeProgressChangedListener {

    SwipeDismissLayout swipeDismissLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        swipeDismissLayout = (SwipeDismissLayout) findViewById(R.id.sdl);
        swipeDismissLayout.setOnDismissedListener(this);
        swipeDismissLayout.setOnSwipeProgressChangedListener(this);
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
    public void onDismissed(SwipeDismissLayout layout) {

        Log.i("Kince", "onDismissed");
        finish();
    }

    /**
     * Called when the layout has been swiped and the position of the window should change.
     *
     * @param layout
     * @param progress  A number in [0, 1] representing how far to the
     *                  right the window has been swiped
     * @param translate A number in [0, w], where w is the width of the
     */
    @Override
    public void onSwipeProgressChanged(SwipeDismissLayout layout, float progress, float translate) {
        Log.i("Kince", "progress = " + progress + " translate = " + translate);
        layout.scrollTo((int) -translate, 0);
    }

    @Override
    public void onSwipeCancelled(SwipeDismissLayout layout) {
        layout.scrollTo((int)0, 0);
    }

}
