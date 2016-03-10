package test.huge.currencyconverter.UI.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.okhttp.OkHttpClient;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;
import retrofit.client.Response;
import test.huge.currencyconverter.R;
import test.huge.currencyconverter.UI.adapter.CurrencyAdapter;
import test.huge.currencyconverter.rest.ApiService;
import test.huge.currencyconverter.rest.model.CurrencyResponse;
import test.huge.currencyconverter.rest.model.ItemRates;
import test.huge.currencyconverter.rest.model.Rates;


public class MainActivityFragment extends Fragment {

    private static final String CUR_GBP = "GBP";
    private static final String CUR_EUR = "EUR";
    private static final String CUR_JPY = "JPY";
    private static final String CUR_BRL = "BRL";

    @InjectView(R.id.RvCurrency)
    public RecyclerView mRecyclerView;

    @InjectView(R.id.EtQuantity)
    public AppCompatEditText mEtQuantity;

    private CurrencyAdapter mAdapter;

    private ArrayList<ItemRates> mCurrencies = new ArrayList<>();

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    private OkHttpClient getClient() {
        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(5, TimeUnit.MINUTES);
        client.setReadTimeout(5, TimeUnit.MINUTES);
        return client;
    }

    private void initData() {

        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(getString(R.string.BaseURL))
                .setClient(new OkClient(getClient()))
                .build();

        ApiService apiService = adapter.create(ApiService.class);

        apiService.getRates(getString(R.string.BaseCurrency), CUR_GBP + "," + CUR_EUR + "," + CUR_JPY + "," + CUR_BRL, new Callback<CurrencyResponse>() {
            @Override
            public void success(CurrencyResponse currencyResponse, Response response) {

                if (response.getStatus() == 200 && currencyResponse != null) {

                    Rates rates = currencyResponse.getRates();

                    ItemRates itemRateGBP = new ItemRates(CUR_GBP, rates.getGBP().toString());
                    ItemRates itemRateEUR = new ItemRates(CUR_EUR, rates.getEUR().toString());
                    ItemRates itemRateJPY = new ItemRates(CUR_JPY, rates.getJPY().toString());
                    ItemRates itemRateBRL = new ItemRates(CUR_BRL, rates.getBRL().toString());

                    mCurrencies.clear();
                    mCurrencies.add(itemRateGBP);
                    mCurrencies.add(itemRateEUR);
                    mCurrencies.add(itemRateJPY);
                    mCurrencies.add(itemRateBRL);
                    mAdapter.setData(mCurrencies);
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i("TEST",error.getMessage());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.inject(this, view);
        initViews();
        return view;
    }

    private void initViews() {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new CurrencyAdapter(mCurrencies);
        mRecyclerView.setAdapter(mAdapter);

        mEtQuantity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if(s != null && s.length() > 0){
                    mAdapter.setQuantity(Integer.valueOf(s.toString()));
                }
                else{
                    mAdapter.setQuantity(0);
                }
                mAdapter.refreshData();
            }
        });
    }
}
