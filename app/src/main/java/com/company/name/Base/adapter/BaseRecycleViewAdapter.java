package com.company.name.Base.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by kautilya on 06/02/18.
 */
public abstract class BaseRecycleViewAdapter<T, K extends BaseRecycleViewAdapter.BaseViewHolder> extends RecyclerView.Adapter<K> implements Filterable {

    protected List<T> data;
    protected List<T> storage;
    protected Context context;
    private boolean filterable;
    private ItemClickListener<T> onClickListener;


    public BaseRecycleViewAdapter(List<T> data, Context context, boolean filterable) {
        this.data = data;
        this.context = context;
        this.filterable = filterable;
        if (filterable) {
            this.storage = new ArrayList<>();
            this.storage.addAll(data);
        }
    }

    public BaseRecycleViewAdapter(List<T> data, Context context, boolean filterable, ItemClickListener<T> onClickListener) {
        this.data = data;
        this.context = context;
        this.filterable = filterable;
        if (filterable) {
            this.storage = new ArrayList<>();
            this.storage.addAll(data);
        }
        this.onClickListener = onClickListener;
    }

    @Override
    public void onBindViewHolder(K holder, int position) {
        if (holder != null)
            holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setFilterable(boolean filterable) {
        this.filterable = filterable;
    }

    public void addMoreData(List<T> job_info) {
        int start = getItemCount();
        data.addAll(job_info);
        notifyItemRangeInserted(start, getItemCount());
    }

    public abstract class BaseViewHolder<L extends ViewDataBinding> extends RecyclerView.ViewHolder {
        protected String LOG_TAG = this.getClass().getName();

        L mViewDataBinding;

        public BaseViewHolder(View itemView) {
            super(itemView);
            mViewDataBinding = DataBindingUtil.bind(itemView);
        }

        protected void bind(final T object) {
            getmViewDataBinding().getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onClickListener != null)
                        onClickListener.onItemClick(object);
                }
            });
        }

        public L getmViewDataBinding() {
            return mViewDataBinding;
        }
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    public List<T> getData() {
        return data;
    }

    public interface ItemClickListener<T> {
        void onItemClick(T object);
    }

}