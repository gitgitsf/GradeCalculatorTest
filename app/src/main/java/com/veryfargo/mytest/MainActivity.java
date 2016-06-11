package com.veryfargo.mytest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    GradeCalculator mGradeCalculator;
    public static final double TOTAL_SCRORE = 100d;

    TextView tvMessage;
    EditText etName;
    EditText etScore;
    Button   btnGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupView();  // do findViewById
        btnGrade.setOnClickListener(this); // se onClick() for action

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


    @Override
    public void onClick(View v) {

        mGradeCalculator = new GradeCalculator();
        double enteredScore=0d;
        if ( !TextUtils.isEmpty(etScore.getText().toString()) ) {
            enteredScore = Double.parseDouble(etScore.getText().toString() );
        }

        tvMessage.setText("Hello, " + etName.getText().toString() + ", you got a " +
               mGradeCalculator.whatIsMyGrade(TOTAL_SCRORE, enteredScore) + "!");

    }

    private void setupView() {
        tvMessage = (TextView) findViewById(R.id.tvMessage);
        etName = (EditText) findViewById(R.id.etName);
        etScore = (EditText) findViewById(R.id.etScore);
        btnGrade = (Button) findViewById(R.id.btnGrade);
    }

    public void whatIsMyGrade() {
        mGradeCalculator = new GradeCalculator();
        double enteredScore = Double.parseDouble(etScore.getText().toString() );

        tvMessage.setText("Hello,  " + etName.getText().toString() + ", you got a " +
                mGradeCalculator.whatIsMyGrade(TOTAL_SCRORE, enteredScore)  + "!");

    }
}
