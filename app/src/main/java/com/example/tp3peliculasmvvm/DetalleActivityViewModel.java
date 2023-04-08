package com.example.tp3peliculasmvvm;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class DetalleActivityViewModel extends AndroidViewModel {

    private Context context;

    public DetalleActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }
}
