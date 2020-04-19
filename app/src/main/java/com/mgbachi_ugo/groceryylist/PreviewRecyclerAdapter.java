package com.mgbachi_ugo.groceryylist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PreviewRecyclerAdapter extends RecyclerView.Adapter<PreviewRecyclerAdapter.ViewHolder>  {
    private ArrayList<GroceryList> mGroceryList;

    public PreviewRecyclerAdapter(ArrayList<GroceryList> mGroceryList) {
        this.mGroceryList = mGroceryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.addlistitem, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GroceryList list = mGroceryList.get(position);
        holder.groceryItem.setText(list.getGrocery());
        holder.groceryItemPrice.setText(list.getPrice());

    }

    @Override
    public int getItemCount() {
        return mGroceryList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView groceryItem, groceryItemPrice;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            groceryItem = itemView.findViewById(R.id.grocery_item_view);
            groceryItemPrice = itemView.findViewById(R.id.grocery_price_view);

        }
    }
}
