package com.example.assignmentmobilecomp;

import com.google.firebase.Timestamp;

public class showTime {
    boolean seat1,seat2,seat3,seat4,seat5;
    private com.google.firebase.Timestamp timeScreening;

    public showTime() {
    }

    public showTime(boolean seat1, boolean seat2, boolean seat3, boolean seat4, boolean seat5, Timestamp timeScreening) {
        this.seat1 = seat1;
        this.seat2 = seat2;
        this.seat3 = seat3;
        this.seat4 = seat4;
        this.seat5 = seat5;
        this.timeScreening = timeScreening;
    }

    public boolean isSeat1() {
        return seat1;
    }

    public void setSeat1(boolean seat1) {
        this.seat1 = seat1;
    }

    public boolean isSeat2() {
        return seat2;
    }

    public void setSeat2(boolean seat2) {
        this.seat2 = seat2;
    }

    public boolean isSeat3() {
        return seat3;
    }

    public void setSeat3(boolean seat3) {
        this.seat3 = seat3;
    }

    public boolean isSeat4() {
        return seat4;
    }

    public void setSeat4(boolean seat4) {
        this.seat4 = seat4;
    }

    public boolean isSeat5() {
        return seat5;
    }

    public void setSeat5(boolean seat5) {
        this.seat5 = seat5;
    }

    public Timestamp getTimeScreening() {
        return timeScreening;
    }

    public void setTimeScreening(Timestamp timeScreening) {
        this.timeScreening = timeScreening;
    }
}
