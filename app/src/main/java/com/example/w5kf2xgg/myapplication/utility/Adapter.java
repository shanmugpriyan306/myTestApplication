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

import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by w5KF2XGG on 09-12-2017.
 */

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<Object> datumListForAdapter;

    private final int TYPE_1 = 0, TYPE_2 = 2, TYPE_3 = 3;

    public class ViewHolder1 extends RecyclerView.ViewHolder {

        private TextView label1, label2;

        public ViewHolder1(View v) {
            super(v);
            label1 = (TextView) v.findViewById(R.id.type1Txt1);
            label2 = (TextView) v.findViewById(R.id.type1Txt2);
        }

        public TextView getLabel1() {
            return label1;
        }

        public void setLabel1(TextView label1) {
            this.label1 = label1;
        }


        public TextView getLabel2() {
            return label2;
        }

        public void setLabel2(TextView label2) {
            this.label2 = label2;
        }
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {

        private TextView label1, label2;

        public ViewHolder2(View v) {
            super(v);
            label1 = (TextView) v.findViewById(R.id.type2Txt1);
            label2 = (TextView) v.findViewById(R.id.type2Txt2);
        }

        public TextView getLabel1() {
            return label1;
        }

        public void setLabel1(TextView label1) {
            this.label1 = label1;
        }


        public TextView getLabel2() {
            return label2;
        }

        public void setLabel2(TextView label2) {
            this.label2 = label2;
        }
    }

    public class ViewHolder3 extends RecyclerView.ViewHolder {

        private TextView label1, label2;

        public ViewHolder3(View v) {
            super(v);
            label1 = (TextView) v.findViewById(R.id.type3Txt1);
            label2 = (TextView) v.findViewById(R.id.type3Txt2);
        }

        public TextView getLabel1() {
            return label1;
        }

        public void setLabel1(TextView label1) {
            this.label1 = label1;
        }


        public TextView getLabel2() {
            return label2;
        }

        public void setLabel2(TextView label2) {
            this.label2 = label2;
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
            case TYPE_1:
                View v1 = inflater.inflate(R.layout.type1, parent, false);
                viewHolder = new ViewHolder1(v1);
                break;
            case TYPE_2:
                View v2 = inflater.inflate(R.layout.type2, parent, false);
                viewHolder = new ViewHolder2(v2);
                break;
            case TYPE_3:
                View v = inflater.inflate(R.layout.type3, parent, false);
                viewHolder = new ViewHolder3(v);
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
            try {
                vh1.getLabel1().setText("Q-Type1: " + datumListItem.jsonObject.getString("question"));
                vh1.getLabel2().setText("Comment-Type1: " + datumListItem.jsonObject.getString("comments"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void configureType2ViewHolder(ViewHolder2 vh1, int position) {
        Type2 datumListItem = (Type2) datumListForAdapter.get(position);
        if (datumListItem != null) {
            try {
                vh1.getLabel1().setText("Q-Type1: " + datumListItem.jsonObject.getString("question"));
                vh1.getLabel2().setText("Comment-Type1: " + datumListItem.jsonObject.getString("comments"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void configureType3ViewHolder(ViewHolder3 vh1, int position) {
        Type3 datumListItem = (Type3) datumListForAdapter.get(position);
        if (datumListItem != null) {
            try {
                vh1.getLabel2().setText("Comment-Type1: " + datumListItem.jsonObject.getString("comments"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case TYPE_1:
                ViewHolder1 vh1 = (ViewHolder1) holder;
                configureType1ViewHolder(vh1, position);
                break;
            case TYPE_2:
                ViewHolder2 vh2 = (ViewHolder2) holder;
                configureType2ViewHolder(vh2, position);
                break;
            case TYPE_3:
                ViewHolder3 vh = (ViewHolder3) holder;
                configureType3ViewHolder(vh, position);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (datumListForAdapter.get(position) instanceof Type1) {
            return TYPE_1;
        } else if (datumListForAdapter.get(position) instanceof Type2) {
            return TYPE_2;
        } else if (datumListForAdapter.get(position) instanceof Type3) {
            return TYPE_3;
        }
        return -1;
    }

    @Override
    public int getItemCount() {
        return datumListForAdapter.size();
    }
}
