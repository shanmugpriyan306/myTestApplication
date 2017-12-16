
package com.example.w5kf2xgg.myapplication.pojo.servey.question;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("metric")
    @Expose
    private String metric;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("datatype")
    @Expose
    private String datatype;
    @SerializedName("order")
    @Expose
    private String order;
    @SerializedName("option")
    @Expose
    private List<Option> option = null;
    @SerializedName("disagree")
    @Expose
    private List<Disagree> disagree = null;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public List<Option> getOption() {
        return option;
    }

    public void setOption(List<Option> option) {
        this.option = option;
    }

    public List<Disagree> getDisagree() {
        return disagree;
    }

    public void setDisagree(List<Disagree> disagree) {
        this.disagree = disagree;
    }

}
