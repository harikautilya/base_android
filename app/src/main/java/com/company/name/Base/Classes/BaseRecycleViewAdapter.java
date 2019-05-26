package com.company.name.Base.Classes;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kautilya on 06/02/18.
 */
public class BaseRecycleViewAdapter<K extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<K> {


    @Override
    public K onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(K holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class BaseViewHolder extends RecyclerView.ViewHolder {
        protected String LOG_TAG = this.getClass().getName();

        public BaseViewHolder(View itemView) {
            super(itemView);
        }
    }
}