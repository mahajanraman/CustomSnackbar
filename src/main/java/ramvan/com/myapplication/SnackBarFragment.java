package ramvan.com.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Mahajan on 07-Aug-16.
 */
public class SnackBarFragment  extends Fragment implements View.OnClickListener{

    private View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.custom_snack , container , false);
        TextView wrong = (TextView) mView.findViewById(R.id.wrong_snackbar);
        TextView corrcet = (TextView) mView.findViewById(R.id.correct_snackbar);
        wrong.setOnClickListener(this);
        corrcet.setOnClickListener(this);
        return mView;
    }

    /**
     * showing the default SnackBar
     */
    private void wrongSnack(View view) {
        Snackbar.make(view.getRootView(), "This is a wrog  SnackBar", Snackbar.LENGTH_LONG).show();
    }

    /**
     * showing the default SnackBar
     */
    private void correctSnack(View view) {
        Snackbar.make(mView.findViewById(R.id.top_layout), "This is a correct SnackBar", Snackbar.LENGTH_LONG).show();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.wrong_snackbar:
                wrongSnack(view);
                break;

            case R.id.correct_snackbar:
                correctSnack(view);
                break;


        }
    }
}
