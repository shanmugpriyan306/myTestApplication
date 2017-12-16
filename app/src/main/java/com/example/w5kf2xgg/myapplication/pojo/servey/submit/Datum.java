
package com.example.w5kf2xgg.myapplication.pojo.servey.submit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("metric")
    @Expose
    private String metric;
    @SerializedName("datatype")
    @Expose
    private String datatype;
    @SerializedName("answer_text")
    @Expose
    private String answerText;
    @SerializedName("answer_value")
    @Expose
    private String answerValue;

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

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public String getAnswerValue() {
        return answerValue;
    }

    public void setAnswerValue(String answerValue) {
        this.answerValue = answerValue;
    }

}
