package com.neildg.mobidev_handsonrepo.activity_catchup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.neildg.mobidev_handsonrepo.R;

import java.util.ArrayList;

public class PersonListActivity extends AppCompatActivity {

    private RecyclerView personView;
    private PersonAdapter personAdapter;
    private ArrayList<PersonModel> personList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_list);

        this.setupData();
        this.setupRecyclerView();
    }

    private void setupData() {
        PersonModel person = new PersonModel("Melissa", "Reading");
        personList.add(person);

        person = new PersonModel("Emmanuel", "Writing and Drawing");
        personList.add(person);

        person = new PersonModel("Gian", "Running and Wrestling");
        personList.add(person);

        person = new PersonModel("Frances", "Workout! :O");
        personList.add(person);

        person = new PersonModel("Luigi", "Boxing");
        personList.add(person);
    }

    private void setupRecyclerView() {
        this.personView = this.findViewById(R.id.person_view);
        this.personAdapter = new PersonAdapter(this.personList);
        RecyclerView.LayoutManager recylerLayoutManager = new LinearLayoutManager(this);
        this.personView.setLayoutManager(recylerLayoutManager);
        this.personView.setItemAnimator(new DefaultItemAnimator());
        this.personView.setAdapter(this.personAdapter);

        RecyclerView.LayoutManager layout2 = new LinearLayoutManager(this);
    }
}
