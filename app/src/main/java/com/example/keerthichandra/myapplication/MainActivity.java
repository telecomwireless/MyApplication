package com.example.keerthichandra.myapplication;

import android.support.v7.app.ActionBarActivity;

import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;

import static android.view.View.OnClickListener;


public class MainActivity extends ActionBarActivity {
    private EditText Scr;  // This is the calculator screen
    private float numberBf; // in this variable result is stored
    private String Operation;   // this variable stores the type of operation
    private ButtonClickListener btnClick; // Buttonclick class is located at the bottom of this code

    @Override
    protected void onCreate(Bundle savedInstanceState) //initializing activity, saved instancestate  is used to load the previous state of the app first

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //
        Scr = (EditText) findViewById(R.id.keer); //
        int idList[] = {R.id.B1, R.id.B2, R.id.B3, R.id.B4, R.id.B5, R.id.B6, R.id.B7, R.id.B8, R.id.B9, R.id.B10, R.id.B11, R.id.B12,
                R.id.B13, R.id.B14, R.id.B15, R.id.B16};

        for (int id : idList)  // for each-loop
        {
            View v = findViewById(id);
            btnClick = new ButtonClickListener();
            v.setOnClickListener(btnClick);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void mMath(String str) {    // this method takes input from
        numberBf = Float.parseFloat(Scr.getText().toString());
        Operation = str; //save operation
        //clear screen
        Scr.setText("+");


    }

    public void getKeyboard(String str) {
        String ScrCurrent = Scr.getText().toString();
        ScrCurrent += str;
        Scr.setText(ScrCurrent);
    }

    public void mResult() {
        float NumAf = Float.parseFloat(Scr.getText().toString());
        float result = 0;
        if (Operation.equals("+")) {
            result = NumAf + numberBf;
        }
        else if (Operation.equals("-")) {
            result = numberBf - NumAf ;
        }
        else if (Operation.equals("*")) {
            result = NumAf * numberBf;
        }
       else if(Operation.equals("/"))
        {
            result =  numberBf/NumAf ;
        }

        Scr.setText(String.valueOf(result));
    }


    class ButtonClickListener implements OnClickListener {  // my problem
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.B4:  //clear button
                    Scr.setText("0");
                    numberBf = 0;
                    Operation = "";
                    break;
                case R.id.B14:
                    mMath("+");
                    break;
                case R.id.B15:
                    mMath("-");
                    break;

                case R.id.B8:
                    mMath("*");
                    break;
                case R.id.B12:
                    mMath("/");
                    break;
                case R.id.B16:
                    mResult();
                    break;
                default:
                    String numb = ((Button) v).getText().toString();
                    getKeyboard(numb);
                    break;
            }
        }

    }


}

