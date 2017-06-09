package net.heronattion.solowin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import net.heronattion.solowin.R;

/**
 * Created by hero on 2017-06-08.
 */

public class SignupInformation2Activity extends BaseActivity {

    private android.widget.EditText textView2;
    private TextView nextButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupinformation2);
        this.nextButton2 = (TextView) findViewById(R.id.nextButton2);
        this.textView2 = (EditText) findViewById(R.id.textView2);

        setCustomActionBar();
        TextView title = (TextView) findViewById(R.id.title);
        title.setText("추가정보 입력");

        nextButton2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, SignupInformation3Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
