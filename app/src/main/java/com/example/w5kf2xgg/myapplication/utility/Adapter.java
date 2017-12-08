package com.example.w5kf2xgg.myapplication.utility;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.w5kf2xgg.myapplication.R;
import com.example.w5kf2xgg.myapplication.TypeCastingClass.Type1;
import com.example.w5kf2xgg.myapplication.TypeCastingClass.Type2;
import com.example.w5kf2xgg.myapplication.TypeCastingClass.Type3;

import java.util.ArrayList;

/**
 * Created by w5KF2XGG on 09-12-2017.
 */

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<Object> datumListForAdapter;

    private final int TYPE1 = 0, TYPE2 = 2, TYPE3 = 3;

    public class ViewHolder1 extends RecyclerView.ViewHolder {

        private TextView label1;

        public ViewHolder1(View v) {
            super(v);
            label1 = (TextView) v.findViewById(R.id.type1Txt);
        }

        public TextView getLabel1() {
            return label1;
        }

        public void setLabel1(TextView label1) {
            this.label1 = label1;
        }
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {

        private TextView label1;

        public ViewHolder2(View v) {
            super(v);
            label1 = (TextView) v.findViewById(R.id.type2Txt);
        }

        public TextView getLabel1() {
            return label1;
        }

        public void setLabel1(TextView label1) {
            this.label1 = label1;
        }
    }

    public class ViewHolder3 extends RecyclerView.ViewHolder {

        private TextView label1;

        public ViewHolder3(View v) {
            super(v);
            label1 = (TextView) v.findViewById(R.id.type3Txt);
        }

        public TextView getLabel1() {
            return label1;
        }

        public void setLabel1(TextView label1) {
            this.label1 = label1;
        }
    }

    public Adapter(ArrayList<Object> datumListForAdapter) {
        this.datumListForAdapter = datumListForAdapter;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case TYPE1:
                View v1 = inflater.inflate(R.layout.type1, parent, false);
                viewHolder = new ViewHolder1(v1);
                break;
            case TYPE2:
                View v2 = inflater.inflate(R.layout.type2, parent, false);
                viewHolder = new ViewHolder2(v2);
                break;
            case TYPE3:
                View v = inflater.inflate(R.layout.type3, parent, false);
                viewHolder = new ViewHolder2(v);
                break;
            default:
                viewHolder = null;
                break;
        }
        return viewHolder;
    }

    private void configureType1ViewHolder(ViewHolder1 vh1, int position) {
        Type1 datumListItem = (Type1) datumListForAdapter.get(position);
        if (datumListItem != null) {
            vh1.getLabel1().setText("Name: " + datumListItem.jsonObject.toString());
        }
    }

    private void configureType2ViewHolder(ViewHolder2 vh1, int position) {
        Type1 datumListItem = (Type1) datumListForAdapter.get(position);
        if (datumListItem != null) {
            vh1.getLabel1().setText("Name: " + datumListItem.jsonObject.toString());
        }
    }

    private void configureType3ViewHolder(ViewHolder3 vh1, int position) {
        Type1 datumListItem = (Type1) datumListForAdapter.get(position);
        if (datumListItem != null) {
            vh1.getLabel1().setText("Name: " + datumListItem.jsonObject.toString());
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case TYPE1:
                ViewHolder1 vh1 = (ViewHolder1) holder;
                configureType1ViewHolder(vh1, position);
                break;
            case TYPE2:
                ViewHolder2 vh2 = (ViewHolder2) holder;
                configureType2ViewHolder(vh2, position);
                break;
            case TYPE3:
                ViewHolder3 vh = (ViewHolder3) holder;
                configureType3ViewHolder(vh, position);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (datumListForAdapter.get(position) instanceof Type1) {
            return TYPE1;
        } else if (datumListForAdapter.get(position) instanceof Type2) {
            return TYPE2;
        } else if (datumListForAdapter.get(position) instanceof Type3) {
            return TYPE3;
        }
        return -1;
    }

    @Override
    public int getItemCount() {
        return datumListForAdapter.size();
    }
}
