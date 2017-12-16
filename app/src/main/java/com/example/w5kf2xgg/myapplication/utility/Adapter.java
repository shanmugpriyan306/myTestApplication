package com.example.w5kf2xgg.myapplication.utility;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.w5kf2xgg.myapplication.R;
import com.example.w5kf2xgg.myapplication.TypeCastingClass.Type1;
import com.example.w5kf2xgg.myapplication.TypeCastingClass.Type2;
import com.example.w5kf2xgg.myapplication.TypeCastingClass.Type3;
import com.example.w5kf2xgg.myapplication.pojo.servey.submit.Datum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by w5KF2XGG on 09-12-2017.
 */

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Object> datumListForAdapter;
    private AdapterButtonClickListener adapterButtonClickListener;
    private Context context;

    public Adapter(ArrayList<Object> datumListForAdapter,
                   AdapterButtonClickListener adapterButtonClickListener, Context context) {
        this.datumListForAdapter = datumListForAdapter;
        this.adapterButtonClickListener = adapterButtonClickListener;
        this.context = context;
    }

    private final int TYPE_1 = 0, TYPE_2 = 2, TYPE_3 = 3, TYPE_4 = 4;

    public class ImageViewHolder extends RecyclerView.ViewHolder {

        private TextView label1, label2;
        private EditText editTextComments;
        private RadioGroup radioGroup;

        public ImageViewHolder(View v) {
            super(v);
            label1 = (TextView) v.findViewById(R.id.type1Txt1);
            label2 = (TextView) v.findViewById(R.id.type1Txt2);
            editTextComments = (EditText) v.findViewById(R.id.type1_comments);
            radioGroup = (RadioGroup) v.findViewById(R.id.radioGroup);
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

        public EditText getEditTextComments() {
            return editTextComments;
        }

        public void setEditTextComments(EditText editTextComments) {
            this.editTextComments = editTextComments;
        }

        public RadioGroup getRadioGroup() {
            return radioGroup;
        }

        public void setRadioGroup(RadioGroup radioGroup) {
            this.radioGroup = radioGroup;
        }
    }

    public class RadioViewHolder extends RecyclerView.ViewHolder {

        private TextView label1, label2;
        private EditText editTextComments;
        private RadioGroup radioGroup;

        public RadioViewHolder(View v) {
            super(v);
            label1 = (TextView) v.findViewById(R.id.type2Txt1);
            label2 = (TextView) v.findViewById(R.id.type2Txt2);
            editTextComments = (EditText) v.findViewById(R.id.type2_comments);
            radioGroup = (RadioGroup) v.findViewById(R.id.radioGroup);
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

        public EditText getEditTextComments() {
            return editTextComments;
        }

        public void setEditTextComments(EditText editTextComments) {
            this.editTextComments = editTextComments;
        }

        public RadioGroup getRadioGroup() {
            return radioGroup;
        }

        public void setRadioGroup(RadioGroup radioGroup) {
            this.radioGroup = radioGroup;
        }
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder {

        private TextView label1, label2;
        private EditText type_3_comment_edit_text;

        public CommentViewHolder(View v) {
            super(v);
            label1 = (TextView) v.findViewById(R.id.type3Txt1);
            label2 = (TextView) v.findViewById(R.id.type3Txt2);
            type_3_comment_edit_text = (EditText) v.findViewById(R.id.type_3_comment_edit_text);
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

        public EditText getType_3_comment_edit_text() {
            return type_3_comment_edit_text;
        }

        public void setType_3_comment_edit_text(EditText type_3_comment_edit_text) {
            this.type_3_comment_edit_text = type_3_comment_edit_text;
        }
    }

    public class ButtonViewHolder extends RecyclerView.ViewHolder {

        private Button buttonSubmitFeedBack;

        public ButtonViewHolder(View v) {
            super(v);
            buttonSubmitFeedBack = (Button) v.findViewById(R.id.buttonSubmitFeedBack);
        }

        public Button getButtonSubmitFeedBack() {
            return buttonSubmitFeedBack;
        }

        public void setButtonSubmitFeedBack(Button buttonSubmitFeedBack) {
            this.buttonSubmitFeedBack = buttonSubmitFeedBack;
        }
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
            case TYPE_4:
                View buttViewHolder = inflater.inflate(R.layout.type4, parent, false);
                viewHolder = new ButtonViewHolder(buttViewHolder);
                break;

            default:
                viewHolder = null;
                break;
        }
        return viewHolder;
    }

    private void configureType1ViewHolder(final ImageViewHolder vh1, final int position) {
        final Type1 datumListItem = (Type1) datumListForAdapter.get(position);
        if (datumListItem != null) {

            vh1.getLabel1().setText("Q-Type1: " + datumListItem.datum.getQuestion());
            vh1.getLabel2().setText("Comment-Type1: " + datumListItem.datum.getText());

            for (int row = 0; row < datumListItem.datum.getOption().size(); row++) {
                vh1.radioGroup.setOrientation(LinearLayout.HORIZONTAL);
                RadioButton rdbtn = new RadioButton(context);
                rdbtn.setTag(datumListItem.datum.getOption().get(row).getValue());
                rdbtn.setText(datumListItem.datum.getOption().get(row).getChoice());
                vh1.radioGroup.addView(rdbtn);
            }


            vh1.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    RadioButton rb = (RadioButton) radioGroup.findViewById(i);
                    if (!rb.getTag().equals("1")) {
                        final List<Datum> datum = new ArrayList<>();

                        final Datum datumObj1 = new Datum();
                        final Datum datumObj2 = new Datum();

                        datumObj1.setQuestion(datumListItem.datum.getQuestion());
                        datumObj1.setMetric(datumListItem.datum.getMetric());
                        datumObj1.setDatatype(datumListItem.datum.getDatatype());

                        datumObj2.setQuestion(datumListItem.datum.getDisagree().get(0).getQuestion());
                        datumObj2.setMetric(datumListItem.datum.getDisagree().get(0).getMetric());
                        datumObj2.setDatatype(datumListItem.datum.getDisagree().get(0).getDatatype());
                        datumObj1.setAnswerText((String) rb.getText());
                        datumObj1.setAnswerValue((String) rb.getTag());
                        datum.add(datumObj1);
                        adapterButtonClickListener.onItemClick(datum, position);

                    }
                }
            });

            vh1.editTextComments.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if (charSequence.length() != 0) {
                        final List<Datum> datum = new ArrayList<>();

                        final Datum datumObj1 = new Datum();
                        final Datum datumObj2 = new Datum();

                        datumObj1.setQuestion(datumListItem.datum.getQuestion());
                        datumObj1.setMetric(datumListItem.datum.getMetric());
                        datumObj1.setDatatype(datumListItem.datum.getDatatype());

                        RadioButton radioButtonSelected = (RadioButton)
                                vh1.radioGroup.findViewById(vh1.radioGroup.getCheckedRadioButtonId());

                        if (radioButtonSelected.isChecked()) {
                            datumObj1.setAnswerText((String) radioButtonSelected.getText());
                            datumObj1.setAnswerValue((String) radioButtonSelected.getTag());
                        }

                        datumObj2.setQuestion(datumListItem.datum.getDisagree().get(0).getQuestion());
                        datumObj2.setMetric(datumListItem.datum.getDisagree().get(0).getMetric());
                        datumObj2.setDatatype(datumListItem.datum.getDisagree().get(0).getDatatype());
                        datumObj2.setAnswerText(charSequence.toString());

                        datum.add(datumObj1);
                        datum.add(datumObj2);

                        adapterButtonClickListener.onItemClick(datum, position);
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }
    }

    private void configureType2ViewHolder(final RadioViewHolder vh2, final int position) {
        final Type2 datumListItem = (Type2) datumListForAdapter.get(position);
        if (datumListItem != null) {

            vh2.getLabel1().setText("Q-Type2: " + datumListItem.datum.getQuestion());
            vh2.getLabel2().setText("Comment-Type2: " + datumListItem.datum.getText());

            for (int row = 0; row < datumListItem.datum.getOption().size(); row++) {
                vh2.radioGroup.setOrientation(LinearLayout.HORIZONTAL);
                RadioButton rdbtn = new RadioButton(context);
                rdbtn.setTag(datumListItem.datum.getOption().get(row).getValue());
                rdbtn.setText(datumListItem.datum.getOption().get(row).getChoice());
                vh2.radioGroup.addView(rdbtn);
            }


            vh2.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    RadioButton rb = (RadioButton) radioGroup.findViewById(i);
                    if (!rb.getTag().equals("1")) {
                        final List<Datum> datum = new ArrayList<>();

                        final Datum datumObj1 = new Datum();
                        final Datum datumObj2 = new Datum();

                        datumObj1.setQuestion(datumListItem.datum.getQuestion());
                        datumObj1.setMetric(datumListItem.datum.getMetric());
                        datumObj1.setDatatype(datumListItem.datum.getDatatype());

                        datumObj2.setQuestion(datumListItem.datum.getDisagree().get(0).getQuestion());
                        datumObj2.setMetric(datumListItem.datum.getDisagree().get(0).getMetric());
                        datumObj2.setDatatype(datumListItem.datum.getDisagree().get(0).getDatatype());
                        datumObj1.setAnswerText((String) rb.getText());
                        datumObj1.setAnswerValue((String) rb.getTag());
                        datum.add(datumObj1);
                        adapterButtonClickListener.onItemClick(datum, position);

                    }
                }
            });

            vh2.editTextComments.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if (charSequence.length() != 0) {
                        final List<Datum> datum = new ArrayList<>();

                        final Datum datumObj1 = new Datum();
                        final Datum datumObj2 = new Datum();

                        datumObj1.setQuestion(datumListItem.datum.getQuestion());
                        datumObj1.setMetric(datumListItem.datum.getMetric());
                        datumObj1.setDatatype(datumListItem.datum.getDatatype());

                        RadioButton radioButtonSelected = (RadioButton)
                                vh2.radioGroup.findViewById(vh2.radioGroup.getCheckedRadioButtonId());
                        datumObj1.setAnswerText((String) radioButtonSelected.getText());
                        datumObj1.setAnswerValue((String) radioButtonSelected.getTag());

                        datumObj2.setQuestion(datumListItem.datum.getDisagree().get(0).getQuestion());
                        datumObj2.setMetric(datumListItem.datum.getDisagree().get(0).getMetric());
                        datumObj2.setDatatype(datumListItem.datum.getDisagree().get(0).getDatatype());
                        datumObj2.setAnswerText(charSequence.toString());

                        datum.add(datumObj1);
                        datum.add(datumObj2);

                        adapterButtonClickListener.onItemClick(datum, position);
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }
    }

    private void configureType3ViewHolder(CommentViewHolder vh3, int position) {
        Type3 datumListItem = (Type3) datumListForAdapter.get(position);
        if (datumListItem != null) {

            vh3.getLabel1().setText("Q-Type1: " + datumListItem.datum.getText());

        }
    }

    private void configureType4ViewHolder(ButtonViewHolder vh4, int position) {
        String datumListItem = (String) datumListForAdapter.get(position);
        if (datumListItem != null) {
            vh4.getButtonSubmitFeedBack().setText("Submit");
            vh4.getButtonSubmitFeedBack().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    adapterButtonClickListener.click();
                }
            });
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
                CommentViewHolder vh3 = (CommentViewHolder) holder;
                configureType3ViewHolder(vh3, position);
                break;
            case TYPE_4:
                ButtonViewHolder vh4 = (ButtonViewHolder) holder;
                configureType4ViewHolder(vh4, position);
                break;
        }
    }


    @Override
    public int getItemCount() {
        return datumListForAdapter.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (datumListForAdapter.get(position) instanceof Type1) {
            return TYPE_1;
        } else if (datumListForAdapter.get(position) instanceof Type2) {
            return TYPE_2;
        } else if (datumListForAdapter.get(position) instanceof Type3) {
            return TYPE_3;
        } else if (datumListForAdapter.get(position) instanceof String) {
            return TYPE_4;
        }
        return -1;
    }

    public interface AdapterButtonClickListener {
        public void click();

        public void onItemClick(List<Datum> submitDatum, int position);
    }
}