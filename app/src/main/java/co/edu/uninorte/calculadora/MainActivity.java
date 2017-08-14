package co.edu.uninorte.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private Integer op1,op2,rta,op;
    boolean state0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.textView);
        op1=0;
        op2=0;
        rta=0;
        op=-1;
        state0 = true;
    }

    public void onClickNumber(View view) {

        Integer number = Integer.valueOf(view.getTag().toString());

        if (state0 == false){
            op1 = 0;
        }
        state0 = true;

        int temp;
        if (op == -1) {
            temp = op1;
            Log.d("LaCalculadora op1"," op "+temp + " number " + number);
        } else {
            temp = op2;
            Log.d("LaCalculadora op2"," op "+temp + " number " + number);
        }


        if (temp == 0) {
            temp = (temp ) + number;
        } else {
            temp = (temp * 10) + number;
        }

        if (op == -1) {
            op1 = temp;
            tv.setText(op1.toString());
        } else {
            op2 = temp;
            tv.setText(op2.toString());
        }

    }

    public void onClickRta(View view) {
        Integer r ;
        if (op == 0) {
            r = op1 + op2;
        } else {
            r = op1 - op2;
        }
        tv.setText(r.toString());

        state0 = false;
        op1=r;
        op2=0;
        rta=0;
        op=-1;
    }

    public void onClickOp(View view) {
        Integer number = Integer.valueOf(view.getTag().toString());
        op = number;

    }
}
