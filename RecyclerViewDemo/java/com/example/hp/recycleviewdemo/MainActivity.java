package com.example.hp.recycleviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_main_activity);
        initializeFruits();
        RecyclerView recyclerView = findViewById(R.id.rv_fruitList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }

    private void initializeFruits(){
        for(int i = 1;i<=2;i++){
            fruitList.add(new Fruit("apple",R.drawable.apple_pic));
            fruitList.add(new Fruit("banana",R.drawable.banana_pic));
            fruitList.add(new Fruit("orange",R.drawable.orange_pic));
            fruitList.add(new Fruit("watermelon",R.drawable.watermelon_pic));
            fruitList.add(new Fruit("pear",R.drawable.pear_pic));
            fruitList.add(new Fruit("grape",R.drawable.grape_pic));
            fruitList.add(new Fruit("pineapple",R.drawable.pineapple_pic));
            fruitList.add(new Fruit("strawberry",R.drawable.strawberry_pic));
            fruitList.add(new Fruit("cherry",R.drawable.cherry_pic));
            fruitList.add(new Fruit("mango",R.drawable.mango_pic));
        }
    }

}
