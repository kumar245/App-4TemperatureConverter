package com.kumar.user.app_4temperatureconverter;

import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tVResult;
    Button CelButton;
    Button FarButton;
    EditText enTem;

    DecimalFormat decimalFormat=new DecimalFormat("0.0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tVResult= (TextView) findViewById(R.id.tvResult);
        CelButton= (Button) findViewById(R.id.buCelcius);
        FarButton= (Button) findViewById(R.id.buFar);
        enTem= (EditText) findViewById(R.id.editText);
        tVResult.setTextSize(30);
        CelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String editText=enTem.getText().toString();
                if (editText.isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter a Value", Toast.LENGTH_SHORT).show();
                }
                else {
                    double doubleEditText=Double.parseDouble(editText);
                   double convertVal = farTocel(doubleEditText);
                    String strResulCel=String.valueOf(decimalFormat.format(convertVal));
                    tVResult.setText(strResulCel + "C");
                }

            }
        });
        FarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editText2=enTem.getText().toString();

                if (editText2.isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter a Value", Toast.LENGTH_SHORT).show();
                }
                else {
                    double IntEditText=Double.parseDouble(editText2);
                  double celTofarResult = celTofar(IntEditText);
                    String farResult=String .valueOf(decimalFormat.format(celTofarResult));
                    tVResult.setText(farResult + "F");

                }

            }
        });
    }

    private double farTocel(double far) {
        double dresult;
        dresult=(far-32)*5/9;
        return dresult;
    }

    private double celTofar(double cel ) {
        double dfar;
        dfar=(cel*9/5)+32;
        return dfar;
    }
}
