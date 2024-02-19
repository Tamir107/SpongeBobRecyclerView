package com.example.spongebobrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface{

    ArrayList<DataModel> dataSet;
    private RecyclerView recyclerView;
    private CustomAdapter adapter;
    private SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });

        dataSet = new ArrayList<>();
        recyclerView =  findViewById(R.id.mRecyclerView);

        setUpModels();

        adapter = new CustomAdapter(dataSet, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void filterList(String text) {
        ArrayList<DataModel> filteredList = new ArrayList<>();
        for(DataModel dataModel : dataSet){
            if (dataModel.getName().toLowerCase().contains(text.toLowerCase()))
                filteredList.add(dataModel);
        }

        if(filteredList.isEmpty()){
            Toast.makeText(this,"No data found", Toast.LENGTH_SHORT).show();
        }else{
            adapter.setFilteredList(filteredList);
        }
    }

    private void setUpModels(){
        for( int i=0; i < myData.nameArray.length; i++){
            dataSet.add(new DataModel(
                    myData.nameArray[i],
                    myData.subtextArray[i],
                    myData.drawableArray[i],
                    myData.id_[i],
                    myData.descriptionArray[i]
            ));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);

        intent.putExtra("NAME", dataSet.get(position).getName());
        intent.putExtra("IMAGE", dataSet.get(position).getImage());
        intent.putExtra("DESCRIPTION", dataSet.get(position).getDescription());
        intent.putExtra("ID", dataSet.get(position).getId_());
        intent.putExtra("SUBTEXT", dataSet.get(position).getSubtext());

        startActivity(intent);
    }
}