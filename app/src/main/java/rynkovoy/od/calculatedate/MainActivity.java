package rynkovoy.od.calculatedate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvDiff;
    EditText etDate;
    ImageView image;
    Button btnCalc;
    Button btnClear;
    SimpleDateFormat dateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDiff = (TextView) findViewById(R.id.tvDiff);
        image = (ImageView) findViewById(R.id.iv);
        btnCalc = (Button) findViewById(R.id.btnCalc);
        btnClear = (Button) findViewById(R.id.btnClear);
        etDate = (EditText) findViewById(R.id.etDate);
        image.setImageResource(R.drawable.q);

        btnCalc.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        int yyyy = 0;
        int mm = 0;
        int dd = 0;

        String zodiacSigns = "not define";

        String date = etDate.getText() + "";

        if(date.contains("."))dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        else if(date.contains(":"))dateFormat = new SimpleDateFormat("dd:MM:yyyy");
        else if(date.contains("/"))dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        else if(date.contains("\\"))dateFormat = new SimpleDateFormat("dd\\MM\\yyyy");
        else if(date.contains("-"))dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        else if(date.contains("*"))dateFormat = new SimpleDateFormat("dd*MM*yyyy");
        else if(date.contains("_"))dateFormat = new SimpleDateFormat("dd_MM_yyyy");

        dateFormat.setLenient(false);

        if (date.length() == 10) {
            yyyy = Integer.parseInt(date.substring(6, 10));
            dd = Integer.parseInt(date.substring(0, 2));
            mm = Integer.parseInt(date.substring(3, 5));

            if (mm==1 && dd>=21 || mm==2 && dd<=19) zodiacSigns="Aquarius";
            else if (mm==2 && dd>=20 || mm==3 && dd<=20) zodiacSigns="Pisces";
            else if (mm==3 && dd>=21 || mm==4 && dd<=20) zodiacSigns="Aries";
            else if (mm==4 && dd>=21 || mm==5 && dd<=20) zodiacSigns="Taurus";
            else if (mm==5 && dd>=21 || mm==6 && dd<=21) zodiacSigns="Gemini";
            else if (mm==6 && dd>=22 || mm==7 && dd<=22) zodiacSigns="Cancer";
            else if (mm==7 && dd>=23 || mm==8 && dd<=23) zodiacSigns="Leo";
            else if (mm==8 && dd>=24 || mm==9 && dd<=23) zodiacSigns="Virgo";
            else if (mm==9 && dd>=24 || mm==10 && dd<=23) zodiacSigns="Libra";
            else if (mm==10 && dd>=24 || mm==11 && dd<=22) zodiacSigns="Scorpio";
            else if (mm==11 && dd>=23 || mm==12 && dd<=22) zodiacSigns="Sagittarius";
            else if (mm==12 && dd>=23 || mm==1 && dd<=20) zodiacSigns="Capricorn";
        }
        int i = 0;
        while (true) {
            if(yyyy < 1900){
                image.setImageResource(R.drawable.steklo);
                break;
            }else if (yyyy == 1900 + i) {
                image.setImageResource(R.drawable.rat);
                break;
            } else if (yyyy == 1901 + i) {
                image.setImageResource(R.drawable.bull);
                break;
            } else if (yyyy == 1902 + i) {
                image.setImageResource(R.drawable.tiger);
                break;
            } else if (yyyy == 1903 + i) {
                image.setImageResource(R.drawable.rabbit);
                break;
            } else if (yyyy == 1904 + i) {
                image.setImageResource(R.drawable.dragon);
                break;
            } else if (yyyy == 1905 + i) {
                image.setImageResource(R.drawable.snake);
                break;
            } else if (yyyy == 1906 + i) {
                image.setImageResource(R.drawable.horse);
                break;
            } else if (yyyy == 1907 + i) {
                image.setImageResource(R.drawable.sheep);
                break;
            } else if (yyyy == 1908 + i) {
                image.setImageResource(R.drawable.monkey);
                break;
            } else if (yyyy == 1909 + i) {
                image.setImageResource(R.drawable.chicken);
                break;
            } else if (yyyy == 1910 + i) {
                image.setImageResource(R.drawable.dog);
                break;
            } else if (yyyy == 1911 + i) {
                image.setImageResource(R.drawable.pig);
                break;
            } else i += 12;
        }

        switch (view.getId()) {
            case R.id.btnCalc:
                try {
                    Date myDate = dateFormat.parse(date);
                    tvDiff.setText((System.currentTimeMillis() - myDate.getTime()) / 24 / 60 / 60 / 1000 + " days have passed\nZodiac signs: " + zodiacSigns);

                } catch (ParseException e) {
                    image.setImageResource(R.drawable.q);
                    if (date.equals("")) {
                        Toast.makeText(getApplicationContext(), "Enter the date!", Toast.LENGTH_SHORT).show();
                    }if(yyyy < 1900 || yyyy > 99999) {
                        Toast.makeText(getApplicationContext(), "Wrong date!", Toast.LENGTH_SHORT).show();
                        etDate.setText("");
                    }else if(date.length() != 10){
                        Toast.makeText(getApplicationContext(), "Wrong date format!", Toast.LENGTH_SHORT).show();
                        etDate.setText("");
                    }else {
                        Toast.makeText(getApplicationContext(), "Wrong date!", Toast.LENGTH_SHORT).show();
                        etDate.setText("");
                    }
                }
                break;

            case R.id.btnClear:
                image.setImageResource(R.drawable.q);
                etDate.setText("");
                tvDiff.setText("");
                break;
        }



    }
}