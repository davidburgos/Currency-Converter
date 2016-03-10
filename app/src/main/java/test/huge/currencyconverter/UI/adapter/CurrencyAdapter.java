package test.huge.currencyconverter.UI.adapter;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import test.huge.currencyconverter.R;
import test.huge.currencyconverter.rest.model.ItemRates;

/**
 * Created by David Alejandro Burgos on 3/10/16 9:43 AM.
 *
 */

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.ViewHolder> {

    private ArrayList<ItemRates> mDataset;
    private int quantity = 0;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.TvCurrencyTotal)
        public AppCompatTextView mTvCurrencyTotal;

        @InjectView(R.id.TvCurrencyType)
        public AppCompatTextView mTvCurrencyType;

        @InjectView(R.id.TvCurrencyValue)
        public AppCompatTextView mTvCurrencyValue;


        public ViewHolder(View v) {
            super(v);
            ButterKnife.inject(this, v);
        }
    }

    public CurrencyAdapter(ArrayList<ItemRates> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public CurrencyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_currency, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        ItemRates rate = mDataset.get(position);

        holder.mTvCurrencyType.setText(rate.getCurrencyType());
        holder.mTvCurrencyValue.setText(rate.getAmount());
        holder.mTvCurrencyTotal.setText(rate.getResult().toString());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void add(int position, ItemRates item) {
        mDataset.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(ItemRates item) {
        int position = mDataset.indexOf(item);
        mDataset.remove(position);
        notifyItemRemoved(position);
    }

    public void setData(ArrayList<ItemRates> currencies) {
        this.mDataset = currencies;
        notifyDataSetChanged();
    }

    public void refreshData() {

        for (ItemRates item : mDataset) {
            item.setResult(item.getAmountInt() * this.quantity);
        }
        notifyDataSetChanged();
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
