package com.linqinen708.mydialog.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_show_dialog, R.id.btn_show_dialog2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_show_dialog://如果在自定义的xml中预先写了内容，就可以不用写东西了
                new MyDialog(this)
                        .setPositiveButton(new MyDialog.OnMyDialogButtonClickListener() {
                            @Override
                            public void onClick() {
                                Toast.makeText(getBaseContext(),"确定",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton(null)//如果只是取消dialog，可以不用写监听，但是要写setNegativeButton方法
                        .show();
                break;
            case R.id.btn_show_dialog2:
                new MyDialog(this)
                        .setTitle("这个是标题")
                        .setMessage("这个是内容")
                        .setPositiveButton("自定义确定", new MyDialog.OnMyDialogButtonClickListener() {
                            @Override
                            public void onClick() {
                                Toast.makeText(getBaseContext(),"自定义确定",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("自定义取消", new MyDialog.OnMyDialogButtonClickListener() {
                            @Override
                            public void onClick() {
                                Toast.makeText(getBaseContext(),"自定义取消",Toast.LENGTH_SHORT).show();

                            }
                        })
                        .show();
                break;
        }
    }
//    如果预先写了确定和取消按钮，就可以不用自己写了

}
