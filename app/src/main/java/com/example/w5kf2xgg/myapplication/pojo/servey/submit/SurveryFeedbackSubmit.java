
package com.example.w5kf2xgg.myapplication.pojo.servey.submit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SurveryFeedbackSubmit {

    @SerializedName("integrationID")
    @Expose
    private String integrationID;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("result")
    @Expose
    private Result result;

    public String getIntegrationID() {
        return integrationID;
    }

    public void setIntegrationID(String integrationID) {
        this.integrationID = integrationID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

}
