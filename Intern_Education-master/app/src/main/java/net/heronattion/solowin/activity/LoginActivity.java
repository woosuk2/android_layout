package net.heronattion.solowin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import net.heronattion.solowin.R;
import net.heronattion.solowin.network.HttpClient;

import cz.msebera.android.httpclient.Header;

public class LoginActivity extends BaseActivity {

    private TextView findButton;
    private Button loginButton;
    private android.widget.EditText loginID;
    private android.widget.EditText loginPW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        bindViews();
        setupEvents();
        setCustomActionBar();

    }

    @Override
    public void setupEvents() {
        super.setupEvents();

        // 로그인 버튼 클릭시
        loginButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginButtonEvent();
            }
        });
        // 비밀번호 찾기 버튼 클릭 시
        findButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, FindActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void bindViews() {
        super.bindViews();

        this.loginPW = (EditText) findViewById(R.id.loginPW);
        this.loginID = (EditText) findViewById(R.id.loginID);
        this.findButton = (TextView) findViewById(R.id.findButton);
        this.loginButton = (Button) findViewById(R.id.loginButton);

    }

    private void loginButtonEvent() {
        //포스트로 넘겨줄 값을 지정해줌
        RequestParams params = new RequestParams();

        //왼쪽 인자는 PHP POST 키값을 나타내고 오른쪽 인자는 보낼 값을 나타냄
        params.put("userId", loginID.getText().toString());
        params.put("userPassword", loginPW.getText().toString());

        //HttpClient 클래스에 기본 URL이 정해져 있음 http://heronation.net/ 이하의 경로를 적어주면 됨
        HttpClient.post("sizeax/php/tryLogin.php", params, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                //TODO : 통신에 성공했을 때 이벤트를 적어주면 됨

                String response = new String(responseBody);

                switch(response) {

                    case "id_pw_empty":

                        Toast.makeText(LoginActivity.this, "아이디가 비었습니다.", Toast.LENGTH_SHORT).show();

                        break;

                    case "fail" :

                        Toast.makeText(LoginActivity.this, "로그인에 실패했습니다.", Toast.LENGTH_SHORT).show();

                        break;

                    case "server_connect_fail":

                        Toast.makeText(LoginActivity.this, "서버 연결이 불안정합니다.", Toast.LENGTH_SHORT).show();

                        break;

                    default :

                        Toast.makeText(LoginActivity.this, R.string.login_welcome_message, Toast.LENGTH_SHORT).show();
//                        intentActivity(getApplicationContext(), ProductListActivity.class);

                        break;
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                //TODO : 통신에 실패했을 때 이벤트를 적어주면 됨
                //서버와의 통신이 원할하지 않습니다.

                Toast.makeText(LoginActivity.this, "서버와 통신이 원활하지 않습니다.", Toast.LENGTH_SHORT).show();

            }
        });
    }

}
