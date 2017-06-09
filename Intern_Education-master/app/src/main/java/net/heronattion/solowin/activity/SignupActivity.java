package net.heronattion.solowin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.heronattion.solowin.R;

import org.w3c.dom.Text;

/**
 * Created by hero on 2017-06-08.
 */

public class SignupActivity extends BaseActivity{

    TextView signupNextButton;
    TextView cancelButton;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        setCustomActionBar();
        title = (TextView) findViewById(R.id.title);
        title.setText("회원가입");

//        titleTxt.setText("회원가입");

        signupNextButton = (TextView) findViewById(R.id.signupNextButton);
        cancelButton = (TextView) findViewById(R.id.cancelButton);

        signupNextButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, SignupInformationActivity.class);
                startActivity(intent);
                finish();
            }
        });

        cancelButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, SplashActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
