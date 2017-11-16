package test.helloworld;

import android.app.Fragment;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.solver.widgets.ConstraintTableLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Intent intent = getIntent();
        String key = "MainActivity";
        try
        {
            key = Class.forName("MainActivity").getName();
        }
        catch(ClassNotFoundException e)
        {
            throw new ClassCastException(getClass().getSimpleName() +"MainActivity ClassNotFoundException");
        }
        String msg = intent.getStringExtra(key);
        TextView tv = new TextView(DisplayMessageActivity.this);
        tv.setText(msg);
        ConstraintLayout layout = findViewById(R.id.display_content);
        layout.addView(tv);
    }
}
