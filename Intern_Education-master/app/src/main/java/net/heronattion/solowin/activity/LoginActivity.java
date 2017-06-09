package net.heronattion.solowin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import net.heronattion.solowin.R;
import net.heronattion.solowin.data.UserData;
import net.heronattion.solowin.util.ContextUtil;
import net.heronattion.solowin.util.ServerUtil;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends BaseActivity {

    private android.widget.EditText idInputEdt;
    private android.widget.EditText pwInputEdt;
    private android.widget.Button loginBtn;
    private android.widget.Button signupBtn;
    private android.widget.Button facebookLoginBtn;
    private TextView findButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setCustomActionBar();

        findButton = (TextView) findViewById(R.id.findButton);

        findButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, FindActivity.class);
                startActivity(intent);
                finish();
            }
        });

//        bindViews();
//        setupEvents();
    }

    @Override
    public void setupEvents() {
        super.setupEvents();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ServerUtil.facebook_login(mContext, "이름", "uid", "이메일", new ServerUtil.JsonResponseHandler() {
                    @Override
                    public void onResponse(JSONObject json) {

                        try {
                            if (json.getString("value").equals("OK")) {
                                Log.d("OK", "OK");

                                UserData userData = new UserData();
                                userData.PKey = 1;
                                userData.userName = "임시사용자";

                                ContextUtil.setUserData(mContext, userData);

                                Intent intent = new Intent(mContext, MainActivity.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(mContext, "로그인에 실패했습니다.", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

    }
//
//    @Override
//    public void bindViews() {
//        super.bindViews();
//
//        this.facebookLoginBtn = (Button) findViewById(R.id.facebookLoginBtn);
//        this.signupBtn = (Button) findViewById(R.id.signupBtn);
//        this.loginBtn = (Button) findViewById(R.id.loginBtn);
//        this.pwInputEdt = (EditText) findViewById(R.id.pwInputEdt);
//        this.idInputEdt = (EditText) findViewById(R.id.idInputEdt);
//    }
}
