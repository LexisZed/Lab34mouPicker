package my.edu.tarc.lab34moupicker;

import java.util.Calendar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    TextView buttonDate;
    TextView textAge;
    TextView textAmount;
    TextView textBalance;
    double Amount;
    double Balance;
    double EligibleAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonDate = findViewById(R.id.buttonDOB);
        textAge = findViewById(R.id.textViewAge);
        textAmount = findViewById(R.id.textViewEligibleAmount);
        textBalance = findViewById(R.id.editTextAccountBalance);
    }

    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),getString(R.string.datepicker));
    }

    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (month_string +
                "/" + day_string + "/" + year_string);

        buttonDate.setText(dateMessage);

        Integer Age = Calendar.getInstance().get(Calendar.YEAR) - year;
        textAge.setText("Age : " + Age.toString());


        if (Age >= 16 && Age <= 20){
            Amount = 5000;
        }
        else if (Age >= 21 && Age <= 25){
            Amount = 14000;
        }
        else if (Age >= 26 && Age <= 30){
            Amount = 29000;
        }
        else if (Age >= 31 && Age <= 35){
            Amount = 50000;
        }
        else if (Age >= 36 && Age <= 40){
            Amount = 78000;
        }
        else if (Age >= 41 && Age <= 45){
            Amount = 116000;
        }
        else if (Age >= 46 && Age <= 50){
            Amount = 165000;
        }
        else if (Age >= 51 && Age <= 55){
            Amount = 228000;
        }
        else {
            Amount = 0;
        }

        //Toast.makeText(this,getString(R.string.date) + dateMessage,
        //        Toast.LENGTH_SHORT).show();
    }

    public void Calculate(View view){
        String GetBalance = textBalance.getText().toString();
        Balance = Double.parseDouble(GetBalance);
        EligibleAmount = Balance - Amount;

        if (EligibleAmount <= 0){
            textAmount.setText("This user is not eligible for this shit.");
        }
        else {
            double EligibleAmountNo2;
            EligibleAmountNo2 = EligibleAmount * 30 / 100;
            textAmount.setText("Eligible Amount : " + EligibleAmountNo2);
        }
    }

    public void Reset(View view){
        buttonDate.setText("Select Date Of Birth");
        textAge.setText("Age : ");
        textAmount.setText("Eligible Amount : ");
        textBalance.setText("");
    }
}
