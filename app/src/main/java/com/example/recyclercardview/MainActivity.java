package com.example.recyclercardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
List<listElement> elements;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inic();
    }

    private void inic() {
        elements = new ArrayList<>();
        elements.add(new listElement("#775447", "Juan", "Choluteca", "Activo"));
        elements.add(new listElement("#607d8b", "Bayron", "Choluteca", "Activo"));
        elements.add(new listElement("#03a9f4", "Eduardo", "Monjaras", "Cancelado"));
        elements.add(new listElement("#f44336", "Kevin", "Choluteca", "Inactivo"));
        elements.add(new listElement("#009688", "Dany", "Choluteca", "Activo"));

        ListAdapter listAdapter = new ListAdapter(elements, this);
        RecyclerView recyclerView = findViewById(R.id.listrecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);

    }


}