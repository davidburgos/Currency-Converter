package test.huge.currencyconverter.UI.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import test.huge.currencyconverter.API.model.Currency;
import test.huge.currencyconverter.R;
import test.huge.currencyconverter.UI.adapter.CurrencyAdapter;


public class MainActivityFragment extends Fragment {

    @InjectView(R.id.RvCurrency)
    public RecyclerView mRecyclerView;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<Currency> mCurrencies = new ArrayList<>();

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.inject(this, view);
        initViews();
        return view;
    }

    private void initViews() {

        Currency currency = new Currency();
        currency.setAmount("5000");
        currency.setCurrencyType("EUR");

        mCurrencies.add(currency);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new CurrencyAdapter(mCurrencies);
        mRecyclerView.setAdapter(mAdapter);
    }
}
