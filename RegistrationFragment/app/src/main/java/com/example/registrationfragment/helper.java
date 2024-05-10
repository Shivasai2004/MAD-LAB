package com.example.registrationfragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class helper extends ViewModel {

    private final MutableLiveData<String> fn = new MutableLiveData<>();
    private final MutableLiveData<String> ln= new MutableLiveData<>();
    private final MutableLiveData<String> gd= new MutableLiveData<>();
    private final MutableLiveData<String> db = new MutableLiveData<>();
    private final MutableLiveData<String> adr = new MutableLiveData<>();

    public void setFname(String fname) {
        fn.setValue(fname);
    }

    public LiveData<String> getFname() {
        return fn;
    }



    public void setLname(String lname) {
        ln.setValue(lname);
    }

    public LiveData<String> getLname() {
        return ln;


    }

    public void setGen(String gen) {
        gd.setValue(gen);
    }

    public LiveData<String> getGen() {
        return gd;
    }



    public void setDob(String dob) {
        db.setValue(dob);
    }

    public LiveData<String> getDob() {
        return db;
    }




    public void setAddr(String addr) {
        adr.setValue(addr);
    }

    public LiveData<String> getAddr() {
        return adr;
    }

}
