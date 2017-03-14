package andr1.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView editText3 = (TextView) findViewById(R.id.text3);
        editText3.setBackgroundResource(R.color.tvBackgroundGrey);
    }

    public void onClikSave(View view) {
        EditText editText1 = (EditText) findViewById(R.id.text1);
        EditText editText2 = (EditText) findViewById(R.id.text2);
        TextView editText3 = (TextView) findViewById(R.id.text3);

        if (!((editText1.getText().toString().equals("")) || (editText2.getText().toString().equals("")) ||
                (editText3.getText().toString().equals("")))) {
            Intent intent = new Intent(MainActivity.this, activity2.class);
            intent.putExtra("@string/first", editText1.getText().toString());
            intent.putExtra("@string/second", editText2.getText().toString());
            intent.putExtra("@string/third", editText3.getText().toString());
            startActivity(intent);
        }
    }

    public void onClickTextVeiw(View view) {
        callDatePicker();
    }

    private void callDatePicker() {
        final TextView editTextDate = (TextView) findViewById(R.id.text3);
        final Calendar cal = Calendar.getInstance();
        int mYear = cal.get(Calendar.YEAR);
        int mMonth = cal.get(Calendar.MONTH);
        int mDay = cal.get(Calendar.DAY_OF_MONTH);

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
