package ramvan.com.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TextView)findViewById(R.id.change_color)).setOnClickListener(this);
        ((TextView)findViewById(R.id.default_color)).setOnClickListener(this);
        ((TextView)findViewById(R.id.with_action)).setOnClickListener(this);
        ((TextView)findViewById(R.id.change_text_color)).setOnClickListener(this);
        ((TextView)findViewById(R.id.custom_back_text_color)).setOnClickListener(this);
        ((TextView)findViewById(R.id.custom_action_color)).setOnClickListener(this);
        ((TextView)findViewById(R.id.show_fragment)).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.show_fragment:
                showSnackInFragment();
                break;

            case R.id.change_color:
                changeSnackColor();
                break;

            case R.id.default_color:
                showDefaultSnack();
                break;

            case R.id.with_action:
                showSnackWithAction();
                break;

            case R.id.change_text_color:
                changeSnackTextColor();
                break;

            case R.id.custom_back_text_color:
                changeSnackBackAndTextColor();
                break;

            case R.id.custom_action_color:
                changeActionTextColor();
                break;
        }
    }

    /**
     * show the fragment
     */
    private void showSnackInFragment() {
        Intent mIntent = new Intent(MainActivity.this , SecondActivity.class);
        startActivity(mIntent);
    }

    /**
     * showing the default SnackBar
     */
    private void changeActionTextColor() {
        Snackbar mSnackbar  = Snackbar.make(findViewById(R.id.top_layout), "This is default SnackBar", Snackbar.LENGTH_SHORT);
        mSnackbar.setAction("RETRY", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Here you can create any action according to your need.
                // for instance i am showing just snack bar again.
                Snackbar.make(findViewById(R.id.top_layout), "Clicked on Retry.", Snackbar.LENGTH_SHORT).show();
            }
        });
        mSnackbar.setActionTextColor(Color.YELLOW);
        mSnackbar.show();
    }

    /**
     * showing the snackBar text color
     */
    private void changeSnackBackAndTextColor() {
        Snackbar snackbar = Snackbar.make(findViewById(R.id.top_layout), "This is Custom Background and Text Color SnackBar", Snackbar.LENGTH_SHORT);
        View sbView = snackbar.getView();
        sbView.setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);
        snackbar.show();
    }

    /**
     * showing the snackBar text color
     */
    private void changeSnackTextColor() {
        Snackbar snackbar = Snackbar.make(findViewById(R.id.top_layout), "This is Custom Text Color SnackBar", Snackbar.LENGTH_SHORT);
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.RED);
        snackbar.show();
    }

    /**
     * showing the SnackBar with callback
     */
    private void showSnackWithAction() {
        Snackbar.make(findViewById(R.id.top_layout), "This is an Action SnackBar", Snackbar.LENGTH_SHORT)
                .setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Here you can create any action according to your need.
                        // for instance i am showing just snack bar again.
                        Snackbar.make(findViewById(R.id.top_layout), "The previous action was undone", Snackbar.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    /**
     * showing the default SnackBar
     */
    private void showDefaultSnack() {
        Snackbar.make(findViewById(R.id.top_layout), "This is default SnackBar", Snackbar.LENGTH_SHORT).show();
    }

    /**
     * showing the color changed snackBar
     */
    private void changeSnackColor() {
        Snackbar snackbar = Snackbar.make(findViewById(R.id.top_layout), "This is Custom SnackBar", Snackbar.LENGTH_SHORT);
        View sbView = snackbar.getView();
        sbView.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
        snackbar.show();
    }
}
