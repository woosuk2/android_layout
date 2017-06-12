package net.heronattion.solowin.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import net.heronattion.solowin.R;
import net.heronattion.solowin.network.HttpClient;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cz.msebera.android.httpclient.Header;

/**
 * Created by hero on 2017-06-08.
 */

public class SignupActivity extends BaseActivity{

    TextView signupNextButton;
    TextView cancelButton;
    private TextView title;
    private TextView manButton;
    private TextView womanButton;
    private int manFlag = 0;
    private int womanFlag = 0;
    private android.widget.CheckBox checkAll;
    private TextView checkAllText;
    private android.widget.CheckBox check1;
    private TextView checkText1;
    private android.widget.CheckBox check2;
    private TextView checkText2;
    private android.widget.CheckBox check3;
    private TextView checkText3;
    private android.widget.CheckBox check4;
    private TextView checkText4;
    private android.widget.EditText signupID;
    private android.widget.EditText signupPassword;
    private android.widget.EditText signupPassword2;

    private String Passwrod_PATTERN = "^.*(?=.{8,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$";
//    private String Email_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        setCustomActionBar();
        title = (TextView) findViewById(R.id.title);
        title.setText("회원가입");

        bindViews();
        setupEvents();
    }


    @Override
    public void setupEvents() {
        super.setupEvents();

        manButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(womanFlag == 0) {
                    if(manFlag == 0){
                        manButton.setBackgroundResource(R.drawable.select_inputtext);
                        manFlag = 1;
                    } else {
                        manButton.setBackgroundResource(R.drawable.loginbutton);
                        manFlag = 0;
                    }
                }
            }
        });

        womanButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(manFlag == 0){
                    if(womanFlag == 0){
                        womanButton.setBackgroundResource(R.drawable.select_inputtext);
                        womanFlag = 1;
                    } else {
                        womanButton.setBackgroundResource(R.drawable.loginbutton);
                        womanFlag = 0;
                    }
                }
            }
        });

        checkAll.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkAll.isChecked()){
                    check1.setChecked(true);
                    check2.setChecked(true);
                    check3.setChecked(true);
                    check4.setChecked(true);
                }
                else {
                    check1.setChecked(false);
                    check2.setChecked(false);
                    check3.setChecked(false);
                    check4.setChecked(false);
                }
            }
        });

        check1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!check1.isChecked() || checkAll.isChecked()) {
                    checkAll.setChecked(false);
                }
            }
        });

        check2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!check2.isChecked() || checkAll.isChecked()) {
                    checkAll.setChecked(false);
                }
            }
        });

        check3.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!check3.isChecked() || checkAll.isChecked()) {
                    checkAll.setChecked(false);
                }
            }
        });

        check4.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!check4.isChecked() || checkAll.isChecked()) {
                    checkAll.setChecked(false);
                }
            }
        });

        checkText1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.signup_dialog, null);
                TextView customTitle = (TextView) view.findViewById(R.id.customtitle);
                customTitle.setText("약관1");
                customTitle.setTextColor(Color.BLACK);
                AlertDialog.Builder builder = new AlertDialog.Builder(SignupActivity.this);
                builder.setView(view);
                builder.setPositiveButton("동의", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        check1.setChecked(true);
                    }
                });
                builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(!check1.isChecked() || checkAll.isChecked()) {
                            checkAll.setChecked(false);
                        }
                        check1.setChecked(false);
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        checkText2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.signup_dialog, null);
                TextView customTitle = (TextView) view.findViewById(R.id.customtitle);
                customTitle.setText("약관1");
                customTitle.setTextColor(Color.BLACK);
                AlertDialog.Builder builder = new AlertDialog.Builder(SignupActivity.this);
                builder.setView(view);
                builder.setPositiveButton("동의", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        check2.setChecked(true);
                    }
                });
                builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(!check2.isChecked() || checkAll.isChecked()) {
                            checkAll.setChecked(false);
                        }
                        check2.setChecked(false);
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        checkText3.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.signup_dialog, null);
                TextView customTitle = (TextView) view.findViewById(R.id.customtitle);
                customTitle.setText("약관3");
                customTitle.setTextColor(Color.BLACK);
                AlertDialog.Builder builder = new AlertDialog.Builder(SignupActivity.this);
                builder.setView(view);
                builder.setPositiveButton("동의", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        check3.setChecked(true);
                    }
                });
                builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(!check3.isChecked() || checkAll.isChecked()) {
                            checkAll.setChecked(false);
                        }
                        check3.setChecked(false);
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        checkText4.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.signup_dialog, null);
                TextView customTitle = (TextView) view.findViewById(R.id.customtitle);
                customTitle.setText("약관4");
                customTitle.setTextColor(Color.BLACK);
                AlertDialog.Builder builder = new AlertDialog.Builder(SignupActivity.this);
                builder.setView(view);
                builder.setPositiveButton("동의", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        check4.setChecked(true);
                    }
                });
                builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(!check4.isChecked() || checkAll.isChecked()) {
                            checkAll.setChecked(false);
                        }
                        check4.setChecked(false);
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


        //가입 버튼
        signupNextButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(signupID.getText().toString().length() == 0 || signupPassword.getText().toString().length() == 0 || signupPassword2.getText().toString().length() == 0){
                    Toast.makeText(SignupActivity.this, "아이디와 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
                else if(!EmailValidate(signupID.getText().toString())){
                    Toast.makeText(SignupActivity.this, "이메일 형식을 맞춰주세요.", Toast.LENGTH_SHORT).show();
                }
                else if(!PasswrodValidate(signupPassword.getText().toString())){
                    Toast.makeText(SignupActivity.this, "비밀번호는 영문, 숫자 조합 8~20자로 설정하셔야 합니다.", Toast.LENGTH_SHORT).show();
                }
                else if(!check1.isChecked() || !check2.isChecked() || !check3.isChecked()){
                    Toast.makeText(SignupActivity.this, "필수 약관에 동의해주세요.", Toast.LENGTH_SHORT).show();
                }
                else if(!signupPassword.getText().toString().equals(signupPassword2.getText().toString())){
                    Toast.makeText(SignupActivity.this, "비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show();
                }
                else {
                    signupButtonEvent();
                    Intent intent = new Intent(mContext, SignupInformationActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        // 취소버튼
        cancelButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, SplashActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void bindViews() {
        super.bindViews();

        this.signupNextButton = (TextView) findViewById(R.id.signupNextButton);
        this.cancelButton = (TextView) findViewById(R.id.cancelButton);
        this.checkText4 = (TextView) findViewById(R.id.checkText4);
        this.check4 = (CheckBox) findViewById(R.id.check4);
        this.checkText3 = (TextView) findViewById(R.id.checkText3);
        this.check3 = (CheckBox) findViewById(R.id.check3);
        this.checkText2 = (TextView) findViewById(R.id.checkText2);
        this.check2 = (CheckBox) findViewById(R.id.check2);
        this.checkText1 = (TextView) findViewById(R.id.checkText1);
        this.check1 = (CheckBox) findViewById(R.id.check1);
        this.checkAllText = (TextView) findViewById(R.id.checkAllText);
        this.checkAll = (CheckBox) findViewById(R.id.checkAll);
        this.womanButton = (TextView) findViewById(R.id.womanButton);
        this.manButton = (TextView) findViewById(R.id.manButton);
        this.signupPassword2 = (EditText) findViewById(R.id.signupPassword2);
        this.signupPassword = (EditText) findViewById(R.id.signupPassword);
        this.signupID = (EditText) findViewById(R.id.signupID);


    }

    private void signupButtonEvent() {
        //포스트로 넘겨줄 값을 지정해줌
        RequestParams params = new RequestParams();

        //왼쪽 인자는 PHP POST 키값을 나타내고 오른쪽 인자는 보낼 값을 나타냄
        params.put("ID", signupID.getText().toString());
        params.put("PW", signupPassword.getText().toString());

        //HttpClient 클래스에 기본 URL이 정해져 있음 http://heronation.net/ 이하의 경로를 적어주면 됨
        HttpClient.post("sizeax/JYD/php/signup.php", params, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                //TODO : 통신에 성공했을 때 이벤트를 적어주면 됨
                String response = new String(responseBody);

                switch(response) {
                    case "duplicated":
                        Toast.makeText(SignupActivity.this, "중복된 이메일입니다.", Toast.LENGTH_SHORT).show();
                        break;
                    case "Fail" :
                        Toast.makeText(SignupActivity.this, "회원가입에 실패했습니다.", Toast.LENGTH_SHORT).show();
                        break;
                    default :
                        Toast.makeText(SignupActivity.this, "가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                        break;
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                //TODO : 통신에 실패했을 때 이벤트를 적어주면 됨
                //서버와의 통신이 원할하지 않습니다.
                Toast.makeText(SignupActivity.this, "서버와 통신이 원활하지 않습니다.", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private boolean PasswrodValidate(String hex) {
        Pattern pattern = Pattern.compile(Passwrod_PATTERN);
        Matcher matcher = pattern.matcher(hex);
        return matcher.matches();
    }

    private boolean EmailValidate(String email) {
        String Email_PATTERN = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";
        Pattern pattern = Pattern.compile(Email_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
//    public static boolean checkEmail(String email){
//        Pattern p = Pattern.compile(regex);
//        Matcher m = p.matcher(email);
//        boolean isNormal = m.matches();
//        return isNormal;
//    }


}
