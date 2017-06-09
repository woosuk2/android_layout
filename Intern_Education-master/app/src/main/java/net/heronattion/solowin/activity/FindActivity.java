package net.heronattion.solowin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.heronattion.solowin.R;

/**
 * Created by hero on 2017-06-08.
 */

public class FindActivity extends BaseActivity{

    TextView cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);

        setCustomActionBar();


//        bindViews();
//        setupEvents();
    }
}
