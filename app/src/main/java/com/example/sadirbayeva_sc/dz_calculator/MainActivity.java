package com.example.sadirbayeva_sc.dz_calculator;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements OnClickListener {

    final int MENU_RESET_ID = 1;
    final int MENU_QUIT_ID = 0;

    EditText el1;
    EditText el2;

    Button button1;
    Button button2;
    Button button3;
    Button button4;

    TextView result;
    String oper = " ";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        el1 = (EditText) findViewById(R.id.el_1);
        el2 = (EditText) findViewById(R.id.el_2);


        button1 = (Button) findViewById(R.id.btnAdd);
        button2= (Button) findViewById(R.id.btnMin);
        button3 = (Button) findViewById(R.id.btnDel);
        button4 = (Button) findViewById(R.id.btnMult);
        result = (TextView) findViewById(R.id.Res);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }

    public void onClick(View v) {
        float num1 = 0;
        float num2 = 0;
        float info_res = 0;

        if (TextUtils.isEmpty(el1.getText().toString()) || TextUtils.isEmpty(el2.getText().toString())) {
            return;
        }

        num1 = Float.parseFloat(el1.getText().toString());
        num2 = Float.parseFloat(el2.getText().toString());

        switch (v.getId()) {
            case R.id.btnAdd:
                oper = "+";
                info_res = num1 + num2;
                break;
            case R.id.btnMin:
                oper = "-";
                info_res = num1 - num2;
                break;
            case R.id.btnDel:
                oper = "/";
                info_res = num1 / num2;
                break;
            case R.id.btnMult:
                oper = "+";
                info_res = num1 * num2;
                break;
            default:
                break;
        }

        result.setText(num1 + " " + oper + " " + num2 + "=" + info_res);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_RESET_ID, 0, "Reset");
        menu.add(0, MENU_QUIT_ID, 0, "Quit");
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case MENU_RESET_ID:
                el1.setText("");
                el2.setText("");
                result.setText("");
                break;
            case MENU_QUIT_ID:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

