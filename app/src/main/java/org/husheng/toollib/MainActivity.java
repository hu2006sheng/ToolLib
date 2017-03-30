package org.husheng.toollib;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.husheng.toolslibrary.BigDecimalUtils;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text= (TextView) findViewById(R.id.text);
        text.setText(BigDecimalUtils.add(1.5,1.21)+"");
    }
}
