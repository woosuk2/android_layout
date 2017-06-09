package net.heronattion.solowin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import net.heronattion.solowin.R;

/**
 * Created by hero on 2017-06-08.
 */

public class SignupInformationActivity extends BaseActivity {


    private android.widget.Spinner spinner1;
    private TextView nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupinformation);
        this.nextButton = (TextView) findViewById(R.id.nextButton);

        setCustomActionBar();
        TextView title = (TextView) findViewById(R.id.title);
        title.setText("추가정보 입력");

        nextButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, SignupInformation2Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
