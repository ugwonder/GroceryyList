package com.mgbachi_ugo.groceryylist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class PreviewActivity extends AppCompatActivity {
    private RecyclerView.Adapter<PreviewRecyclerAdapter.ViewHolder> mAdapter;
    private RecyclerView mRecyclerView;

    TextView name, slack, email, total;
    String pTotal = "The total price is : ";
    String pEmail = "Email: ugochukwu_mgbachi@yahoo.com";
    String pName = "Name: Mgbachi Ugochukwu";
    String pSlack = "Slack Username: Ugwonder";
    ArrayList<GroceryList> groceryList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        Bundle bundleList = getIntent().getExtras();

        groceryList = (ArrayList<GroceryList>) bundleList.getSerializable("groceries");
        displayDetails();
        displayList();
        Button btnShare = findViewById(R.id.btn_share);
        btnShare.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        share();
                    }
                }
        );
        


    }

    private void share() {
        String Subject = "Grocery List";
        String text = "This is the Grocery List";
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc2822");
        intent.putExtra(Intent.EXTRA_SUBJECT, Subject);
        intent.putExtra(Intent.EXTRA_TEXT, text);
        startActivity(intent);
    }


    private void displayList() {
        mRecyclerView = findViewById(R.id.preview_list_view);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(PreviewActivity.this);
        mAdapter = new PreviewRecyclerAdapter(groceryList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void displayDetails() {
        total = findViewById(R.id.total_grocery_price);
        name = findViewById(R.id.name_preview);
        slack = findViewById(R.id.slack_preview);
        email = findViewById(R.id.email_preview);
        total.setText(pTotal);
        name.setText(pName);
        slack.setText(pSlack);
        email.setText(pEmail);
    }
}
