package com.example.android.happymeals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MenuActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    int[] images = {

            R.drawable.burger,
            R.drawable.chowmin,
            R.drawable.pizza,
            R.drawable.coffee,
            R.drawable.momo

    };
    String[] names = {
            "BURGER",
            "CHOWMIN",
            "PIZZA",
            "COFFEE",
            "MOMO"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        recyclerView = findViewById(R.id.recyler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new FoodListAdapter(names, images));

    }

    private class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.ViewHolder> {
        String[] names;
        int[] images;

        FoodListAdapter(String[] names, int[] images) {
            this.names = names;
            this.images = images;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customlayout, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.mTextView.setText(names[position]);
            Glide.with(holder.itemView.getContext()).load(images[position]).into(holder.imageView);
        }

        @Override
        public int getItemCount() {
            return names.length;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            private ImageView imageView;
            private TextView mTextView;

            ViewHolder(final View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.itemImage);
                mTextView = itemView.findViewById(R.id.itemName);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(itemView.getContext(),names[getAdapterPosition()],Toast.LENGTH_SHORT).show();
                        /*Intent intent= new Intent(itemView.getContext(),DetailActivity.class);
                        Bundle arguments = new Bundle();
                        arguments.putString("name",names[getAdapterPosition()]);
                        intent.putExtras(arguments);
                        startActivity(intent);*/
                        String itemName = names[getAdapterPosition()];
                        if (itemName.equals("BURGER")){

                        }else if(itemName.equals("PIZZA")){
                            
                        }
                    }
                });
            }
        }
    }
}
