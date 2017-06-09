package net.heronattion.solowin.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import net.heronattion.solowin.R;

/**
 * Created by hero on 2017-06-08.
 */

public class SignupInformation3Activity extends BaseActivity {

    public TextView addSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupinformation3);
        setCustomActionBar();
        TextView title = (TextView) findViewById(R.id.title);
        title.setText("추가정보 입력");

        // 추가사이즈 입력하기 버튼 클릭 시
        addSize = (TextView) findViewById(R.id.addSize);

        addSize.setOnClickListener(new View.OnClickListener() { // ImageButton을 Click시 AlertDialog가 생성되도록 아래과 같이 설계
            @Override
            public void onClick(View v) {
                // LayoutInflater를 통해 위의 custom layout을 AlertDialog에 반영. 이 외에는 거의 동일하다.
                LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.signup_dialog, null);
                TextView customTitle = (TextView) view.findViewById(R.id.customtitle);
                customTitle.setText("어떤 방식으로 측정하시겠습니까?");
                customTitle.setTextColor(Color.BLACK);
                ImageView customIcon = (ImageView) view.findViewById(R.id.customdialogicon);
                AlertDialog.Builder builder = new AlertDialog.Builder(SignupInformation3Activity.this);
                builder.setView(view);
                builder.setPositiveButton("카메라 측정", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(mContext, CameraMeasureActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
                builder.setNegativeButton("수동 측정", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}
