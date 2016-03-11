package test.huge.currencyconverter.utils;


import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.Window;

import test.huge.currencyconverter.R;

/**
 * Created by David Alejandro Burgos on 3/11/16 2:27 PM.
 *
 */

public class Dialogs {

    private Context mContext;
    private static ProgressDialog mProgressDialog;

    public Dialogs(Context context) {
        mContext = context;
    }

    public AlertDialog.Builder PopUpDialog(int MessageId){
        return CreatePopUpDialog(mContext.getString(R.string.default_dialog_title), mContext.getString(MessageId));
    }

    public AlertDialog.Builder PopUpDialog(String MessageId){
        return CreatePopUpDialog(mContext.getString(R.string.default_dialog_title), MessageId);
    }

    public AlertDialog.Builder PopUpDialog(int TitleId, int MessageId){
        return CreatePopUpDialog(mContext.getString(TitleId), mContext.getString(MessageId));
    }

    public AlertDialog.Builder PopUpDialog(String TitleId, String MessageId){
        return CreatePopUpDialog(TitleId, MessageId);
    }

    private AlertDialog.Builder CreatePopUpDialog(String TitleId, String MessageId){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext, R.style.AppTheme_Dialog);
        alertDialog.setTitle(TitleId);
        alertDialog.setMessage(MessageId);
        alertDialog.setIcon(R.mipmap.ic_launcher);
        alertDialog.setCancelable(false);
        return alertDialog;
    }

    public void ProgressDialog(int Message){

        CreateProgressDialog(Message).show();
    }

    public void ProgressDialog(){

        CreateProgressDialog(R.string.progress_dialog_text).show();
    }

    private ProgressDialog CreateProgressDialog(int Message){
        if(mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(mContext);
            mProgressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            mProgressDialog.setIndeterminate(true);
            mProgressDialog.setMessage(mContext.getString(Message));
            mProgressDialog.setCancelable(false);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        }
        return mProgressDialog;
    }

    public void ProgressDismiss(){
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

}
