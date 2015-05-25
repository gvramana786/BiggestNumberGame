package com.example.android.biggestnumbergame;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends ActionBarActivity {

    private int num1,num2,points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        points=0;
        rolls();
    }

    void rolls()
    {
        Random r = new Random();
        num1 = r.nextInt(1000);
        num2 = r.nextInt(1000);
        while(num1==num2)
        {
            num2 = r.nextInt(1000);
        }
        Button b;
        b = (Button)findViewById(R.id.button1);
        b.setText("" + num1);
        b = (Button)findViewById(R.id.button2);
        b.setText("" + num2);
    }

    void check(int n,int m)
    {
        if(n>m)
        {
            points++;
            Toast.makeText(this,"Correct", Toast.LENGTH_SHORT).show();
        }
        else
        {
            points--;
            Toast.makeText(this,"Incorrect", Toast.LENGTH_SHORT).show();
        }

        TextView tv;
        tv = (TextView)findViewById(R.id.score);
        tv.setText("Points: "+points);
    }

    public void button1_click(View view)
    {
        check(num1,num2);
        rolls();
    }

    public void button2_click(View view)
    {
        check(num2,num1);
        rolls();
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
}
