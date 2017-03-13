package andr1.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by Seva_ on 13.03.2017.
 */

public class activity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        TextView text1 = (TextView) findViewById(R.id.text1);
        TextView text2 = (TextView) findViewById(R.id.text2);
        TextView text3 = (TextView) findViewById(R.id.text3);
        text1.setText(getIntent().getExtras().getString("@string/first"));
        text2.setText(getIntent().getExtras().getString("@string/second"));
        text3.setText(getIntent().getExtras().getString("@string/third"));
    }

    public void onClikEdit(View view) {
        finish();
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }


}
