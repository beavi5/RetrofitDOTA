package com.example.beavi5.retrofittest.retrofit.models;

/**
 * Created by beavi5 on 21.09.2017.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Player {

    @SerializedName("account_id")
    @Expose
    private Integer accountId;
    @SerializedName("avatarfull")
    @Expose
    private String avatarfull;
    @SerializedName("personaname")
    @Expose
    private String personaname;
    @SerializedName("last_match_time")
    @Expose
    private String lastMatchTime;
    @SerializedName("similarity")
    @Expose
    private Integer similarity;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAvatarfull() {
        return avatarfull;
    }

    public void setAvatarfull(String avatarfull) {
        this.avatarfull = avatarfull;
    }

    public String getPersonaname() {
        return personaname;
    }

    public void setPersonaname(String personaname) {
        this.personaname = personaname;
    }

    public String getLastMatchTime() {
        return lastMatchTime;
    }

    public void setLastMatchTime(String lastMatchTime) {
        this.lastMatchTime = lastMatchTime;
    }

    public Integer getSimilarity() {
        return similarity;
    }

    public void setSimilarity(Integer similarity) {
        this.similarity = similarity;
    }

}
