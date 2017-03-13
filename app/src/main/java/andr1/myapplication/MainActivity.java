package andr1.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        TextView editText3 = (TextView) findViewById(R.id.text3);
        editText3.setBackgroundResource(R.color.tvBackgroundGrey);
    }

    public void onClikSave(View view) {
        EditText editText1 = (EditText) findViewById(R.id.text1);
        EditText editText2 = (EditText) findViewById(R.id.text2);
        TextView editText3 = (TextView) findViewById(R.id.text3);

        //TextView editTextDate = (TextView) findViewById(R.id.text3);
        if (!((editText1.getText().toString().equals("")) || (editText2.getText().toString().equals("")) ||
                (editText3.getText().toString().equals("")))) {
            Intent intent = new Intent(MainActivity.this, activity2.class);
            intent.putExtra("@string/first", editText1.getText().toString());
            intent.putExtra("@string/second", editText2.getText().toString());
            intent.putExtra("@string/third", editText3.getText().toString());
            startActivity(intent);
        }
    }

    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page")
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    public void onClickTextVeiw(View view) {
        callDatePicker();
//        BlankFragment myDialogFragment = new BlankFragment();
//        FragmentManager manager = getSupportFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        myDialogFragment.show(transaction, "dialog");
    }

    private void callDatePicker() {
        // получаем текущую дату
        final TextView editTextDate = (TextView) findViewById(R.id.text3);
        final Calendar cal = Calendar.getInstance();
        int mYear = cal.get(Calendar.YEAR);
        int mMonth = cal.get(Calendar.MONTH);
        int mDay = cal.get(Calendar.DAY_OF_MONTH);

        // инициализируем диалог выбора даты текущими значениями
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String editTextDateParam = dayOfMonth + "." + (monthOfYear + 1) + "." + year;
                        editTextDate.setText(editTextDateParam);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
}
