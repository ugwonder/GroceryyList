package com.mgbachi_ugo.groceryylist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter mAdapter;
    Button btnAddItem, btnPreview;
    EditText addGrocery, addPrice;
    ArrayList<GroceryList> groceryItems;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        groceryItems = new ArrayList<>();
        addItem();
        displayList();
        preview();


    }

    private void preview() {
        btnPreview = findViewById(R.id.btn_preview);
        btnPreview.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, PreviewActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("groceries", groceryItems);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                }
        );
    }



    private void displayList() {
        mRecyclerView = findViewById(R.id.grocery_list_view);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.this);
        mAdapter = new GroceryRecyclerAdapter(groceryItems);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }
    private void addItem() {
        btnAddItem = findViewById(R.id.btn_add);
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addGrocery = findViewById(R.id.text_grocery_item);
                addPrice = findViewById(R.id.text_grocery_price);
                insertItem(addGrocery.getText().toString(), addPrice.getText().toString());
            }
        });
    }

    private void insertItem(String addGrocery, String addPrice) {
        groceryItems.add(new GroceryList(addGrocery, addPrice));
        mAdapter.notifyItemInserted(groceryItems.size());
    }
}
