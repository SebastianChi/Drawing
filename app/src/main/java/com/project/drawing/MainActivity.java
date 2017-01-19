package com.project.drawing;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "DrawMainActivity";

    private static final String GENERAL_DRAW_FRAGMENT_TAG = GeneralDrawFragment.class.getName();
    private static final String NUMBER_DRAW_FRAGMENT_TAG = NumberDrawFragment.class.getName();
    private static final String MULTIPLE_DRAW_FRAGMENT_TAG = MultipleDrawFragment.class.getName();

    enum DrawMode {
        GENERAL,
        NUMBER,
        MULTIPLE
    }
    private DrawMode mMode = DrawMode.GENERAL;
    private String mCurrentTag = GENERAL_DRAW_FRAGMENT_TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.action_general:
                Toast.makeText(this, "General selected", Toast.LENGTH_SHORT)
                        .show();
                mMode = DrawMode.GENERAL;
                break;
            // action with ID action_settings was selected
            case R.id.action_number:
                Toast.makeText(this, "Number selected", Toast.LENGTH_SHORT)
                        .show();
                mMode = DrawMode.NUMBER;
                break;
            case R.id.action_multiple:
                Toast.makeText(this, "Multiple selected", Toast.LENGTH_SHORT)
                        .show();
                mMode = DrawMode.MULTIPLE;
                break;
            default:
                break;
        }
        updateDrawTitleAndTag();
        return true;
    }

    private void setupUI() {
        updateDrawTitleAndTag();
        presentFragmentByTag(GENERAL_DRAW_FRAGMENT_TAG);
    }

    private void updateDrawTitleAndTag() {
        TextView titleView = (TextView) findViewById(R.id.draw_title);
        switch (mMode) {
            case NUMBER:
                mCurrentTag = NUMBER_DRAW_FRAGMENT_TAG;
                titleView.setText(getString(R.string.number_mode));
                break;
            case MULTIPLE:
                mCurrentTag = MULTIPLE_DRAW_FRAGMENT_TAG;
                titleView.setText(getString(R.string.multiple_pair_mode));
                break;
            case GENERAL:
                default:
                    mCurrentTag = GENERAL_DRAW_FRAGMENT_TAG;
                    titleView.setText(getString(R.string.general_mode));
                break;
        }
    }

    private void presentFragmentByTag(@NonNull String tag) {
        if (getSupportFragmentManager().findFragmentByTag(tag) == null) {
            Fragment fragment;
            if (tag.equals(GENERAL_DRAW_FRAGMENT_TAG)) {
                fragment = GeneralDrawFragment.newInstance();
            } else {
                return;
            }
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.present_fragment, fragment, tag)
                    .commit();
        }
    }

    public int getDrawNumber() {
        int drawNumber = 0;
        EditText input = (EditText) findViewById(R.id.draw_number_input);
        if(input.getText() != null && input.getText().length() > 0) {
            drawNumber = Integer.parseInt(input.getText().toString());
        }
        return drawNumber;
    }
}
