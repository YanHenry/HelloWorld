package test.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ContentFragment.OnContentSelectedListener, MsgSendFragment.onMsgSendSelectedListener
{
    private final String TAG = getClass().getSimpleName();
    private Button bt1;
    private boolean bflag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 创建一个要放入 Activity 布局中的新 Fragment
        MsgSendFragment firstFragment = new MsgSendFragment();
        // 如果此 Activity 是通过 Intent 发出的特殊指令来启动的，
        // 请将该 Intent 的 extras 以参数形式传递给该 Fragment
        firstFragment.setArguments(getIntent().getExtras());
        // 将该 Fragment 添加到“fragment_container” FrameLayout 中
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ta = fm.beginTransaction();
        ta.add(R.id.fraglayout, firstFragment).commit();
        bflag = true;
        bt1 = findViewById(R.id.button);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bflag)
                {
                    bflag = false;
                    ContentFragment cf = new ContentFragment();
                    cf.setArguments(getIntent().getExtras());
                    getSupportFragmentManager().beginTransaction().replace(R.id.fraglayout, cf).commit();
                }
                else
                {
                    bflag = true;
                    MsgSendFragment hf = new MsgSendFragment();
                    hf.setArguments(getIntent().getExtras());
                    getSupportFragmentManager().beginTransaction().replace(R.id.fraglayout, hf).commit();
                }
            }
        });
    }
    @Override
    public void onContentSelected(int position) {
        Log.i(TAG, "====onContentSelected");
        Toast.makeText(MainActivity.this, "Content is selected!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMsgSendSelected(String msg) {
        Intent intent = new Intent(MainActivity.this,DisplayMessageActivity.class);
        intent.putExtra(TAG, msg);
        startActivity(intent);
    }
}
