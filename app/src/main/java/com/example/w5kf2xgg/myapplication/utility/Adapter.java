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

    private final int TYPE_1 = 0, TYPE_2 = 2, TYPE_3 = 3;

    public class ImageViewHolder extends RecyclerView.ViewHolder {

        private TextView label1, label2;

        public ImageViewHolder(View v) {
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

    public class RadioViewHolder extends RecyclerView.ViewHolder {

        private TextView label1, label2;

        public RadioViewHolder(View v) {
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

    public class CommentViewHolder extends RecyclerView.ViewHolder {

        private TextView label1, label2;

        public CommentViewHolder(View v) {
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
                View imageVH = inflater.inflate(R.layout.type1, parent, false);
                viewHolder = new ImageViewHolder(imageVH);
                break;
            case TYPE_2:
                View radioVH = inflater.inflate(R.layout.type2, parent, false);
                viewHolder = new RadioViewHolder(radioVH);
                break;
            case TYPE_3:
                View commentViewHolder = inflater.inflate(R.layout.type3, parent, false);
                viewHolder = new CommentViewHolder(commentViewHolder);
                break;
            default:
                viewHolder = null;
                break;
        }
        return viewHolder;
    }

    private void configureType1ViewHolder(ImageViewHolder vh1, int position) {
        Type1 datumListItem = (Type1) datumListForAdapter.get(position);
        if (datumListItem != null) {

            vh1.getLabel1().setText("Q-Type1: " + datumListItem.datumList.get(0).getQuestion());
            vh1.getLabel2().setText("Comment-Type1: " + datumListItem.datumList.get(1).getText());
        }
    }

    private void configureType2ViewHolder(RadioViewHolder vh2, int position) {
        Type2 datumListItem = (Type2) datumListForAdapter.get(position);
        if (datumListItem != null) {

            vh2.getLabel1().setText("Q-Type1: " + datumListItem.datumList.get(0).getQuestion());
            vh2.getLabel2().setText("Comment-Type1: " + datumListItem.datumList.get(1).getText());

        }
    }

    private void configureType3ViewHolder(CommentViewHolder vh3, int position) {
        Type3 datumListItem = (Type3) datumListForAdapter.get(position);
        if (datumListItem != null) {

            vh3.getLabel1().setText("Q-Type1: " + datumListItem.datumList.get(0).getText());
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case TYPE_1:
                ImageViewHolder vh1 = (ImageViewHolder) holder;
                configureType1ViewHolder(vh1, position);
                break;
            case TYPE_2:
                RadioViewHolder vh2 = (RadioViewHolder) holder;
                configureType2ViewHolder(vh2, position);
                break;
            case TYPE_3:
                CommentViewHolder vh = (CommentViewHolder) holder;
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
