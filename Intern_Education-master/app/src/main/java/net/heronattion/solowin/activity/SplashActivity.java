package net.heronattion.solowin.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import net.heronattion.solowin.R;
import net.heronattion.solowin.activity.BaseActivity;
import net.heronattion.solowin.activity.LoginActivity;
import net.heronattion.solowin.util.ContextUtil;

public class SplashActivity extends BaseActivity {
    Button loginButton;
    Button signupButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        loginButton = (Button) findViewById(R.id.loginButton);
        signupButton = (Button) findViewById(R.id.signupButton);

        loginButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        signupButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, SignupActivity.class);
                startActivity(intent);
                finish();
            }
        });


//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//                moveToProperActivity();
//            }
//        }, 1500);
    }



    @Override
    public void onBackPressed() {
    }

    void moveToProperActivity() {

        if (ContextUtil.getMyUserData(mContext).PKey == -1) {
            // TODO - 로그인 화면으로 이동해야함

            Intent intent = new Intent(mContext, LoginActivity.class);
            startActivity(intent);

        }
        else {

            // 메인화면으로 이동

            Intent intent = new Intent(mContext, MainActivity.class);
            startActivity(intent);
        }

        finish();

    }

}
