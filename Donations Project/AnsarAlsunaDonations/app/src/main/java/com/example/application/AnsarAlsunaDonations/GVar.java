package com.example.application.AnsarAlsunaDonations;

import android.app.Application;

/**
 * Created by Yaseen on 10/01/2017.
 */

public class GVar extends Application {
    private Integer Hour;
    private Integer Minute;

    public void setHour(Integer hour) {
        Hour = hour;
    }

    public void setMinute(Integer minute) {
        Minute = minute;
    }

    public Integer getHour() {
        return Hour;
    }

    public Integer getMinute() {
        return Minute;
    }
}
