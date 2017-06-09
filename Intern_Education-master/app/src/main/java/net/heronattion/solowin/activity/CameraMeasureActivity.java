package net.heronattion.solowin.activity;

import android.os.Bundle;
import android.widget.TextView;

import net.heronattion.solowin.R;

/**
 * Created by hero on 2017-06-09.
 */

public class CameraMeasureActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_measure);

        setCustomActionBar();
        TextView title = (TextView) findViewById(R.id.title);
        title.setText("카메라 측정");
    }
}
