package test.huge.currencyconverter.UI.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import test.huge.currencyconverter.R;
import test.huge.currencyconverter.utils.Dialogs;

/**
 * Created by David Alejandro Burgos on 3/11/16 9:35 AM.
 *
 */

public class BaseActivity extends AppCompatActivity {

    public Dialogs Dialogs;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Dialogs = new Dialogs(this);
    }

    public void showErrorMessage(int idMessage){
        Dialogs.PopUpDialog(idMessage)
                .setPositiveButton(getString(R.string.default_ok_text), null)
                .setIcon(android.R.drawable.ic_menu_info_details)
                .show();
    }
}
