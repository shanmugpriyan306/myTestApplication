
package com.example.w5kf2xgg.myapplication.pojo.servey.question;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SurveryQuestion {

    @SerializedName("result")
    @Expose
    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

}
