package test.huge.currencyconverter.UI.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.Bind;
import butterknife.ButterKnife;
import test.huge.currencyconverter.R;
import test.huge.currencyconverter.UI.base.BaseActivity;
import test.huge.currencyconverter.UI.fragment.ActivityFragment;

public class MainActivity extends BaseActivity {

    protected boolean mIsOnline;

    @Bind(R.id.connection_ribbon)
    public AppCompatTextView mConnectionRibbon;

    private ActivityFragment mFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mFragment = new ActivityFragment();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, mFragment)
                .commit();
    }

    private void registerReceivers() {
        registerReceiver(mConnReceiver,
                new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceivers();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mConnReceiver);
    }

    private BroadcastReceiver mConnReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            mIsOnline = !intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);

            if(mIsOnline) {
                mConnectionRibbon.setVisibility(View.GONE);
                mFragment.loadService();
            }
            else {
                mConnectionRibbon.setVisibility(View.VISIBLE);
            }
        }
    };
}
