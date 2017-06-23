package d0289570.android_hw4_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        Intent intent = getIntent();
        if(intent.getStringExtra("KEY_MSG")!=null)
            textView.setText("Hello "+intent.getStringExtra("KEY_MSG"));
    }
}
