package test.huge.currencyconverter.UI.adapter;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import test.huge.currencyconverter.API.model.Currency;
import test.huge.currencyconverter.R;

/**
 * Created by David Alejandro Burgos on 3/10/16 9:43 AM.
 *
 */

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.ViewHolder> {

    private ArrayList<Currency> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.TvCurrencyAmount)
        public AppCompatTextView mTvCurrencyAmount;

        @InjectView(R.id.TvCurrencyType)
        public AppCompatTextView mTvCurrencyType;


        public ViewHolder(View v) {
            super(v);
            ButterKnife.inject(this, v);
        }
    }

    public CurrencyAdapter(ArrayList<Currency> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public CurrencyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_currency, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Currency currency = mDataset.get(position);

        holder.mTvCurrencyAmount.setText(currency.getAmount());
        holder.mTvCurrencyType.setText(currency.getCurrencyType());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void add(int position, Currency item) {
        mDataset.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(Currency item) {
        int position = mDataset.indexOf(item);
        mDataset.remove(position);
        notifyItemRemoved(position);
    }
}
