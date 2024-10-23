package com.example.myapplication;

import androidx.lifecycle.ViewModel;

public class StateViewModel extends ViewModel {
    private int count = 0;
    private String tekst = "";
    private boolean Check = false;
    private boolean tryb= false;

    public int getCount() {
        return count;
    }
    public void incrementCount() {
        count++;
    }
    public String gettekst() { return tekst; }
    public void Settekst(String tekst) {
        this.tekst = tekst;
    }
    public boolean isChecked() {
        return Check;
    }
    public void SetChecked(boolean isChecked){
        this.Check = isChecked;
    }
    public boolean isTryb() {
        return tryb;
    }
    public void setTryb(boolean isChecked) {
        this.tryb = isChecked;
    }
}
