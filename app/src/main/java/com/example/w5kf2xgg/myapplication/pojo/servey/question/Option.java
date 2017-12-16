
package com.example.w5kf2xgg.myapplication.pojo.servey.question;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Option {

    @SerializedName("Choice")
    @Expose
    private String choice;
    @SerializedName("Value")
    @Expose
    private String value;

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
