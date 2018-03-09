package com.neildg.mobidev_handsonrepo.activity_catchup;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.neildg.mobidev_handsonrepo.R;
import com.neildg.mobidev_handsonrepo.activity_musicplayer.SongViewHolder;

import java.util.ArrayList;

/**
 * Created by Administrator on 3/9/2018.
 */

public class PersonAdapter extends RecyclerView.Adapter<PersonViewHolder> {

    private ArrayList<PersonModel> persons;

    public PersonAdapter(ArrayList<PersonModel> persons) {
        this.persons = persons;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewInstance = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_item_layout, parent, false);
        PersonViewHolder viewHolder = new PersonViewHolder(viewInstance);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        PersonModel personToDisplay = this.persons.get(position);
        holder.getPersonNameTxt().setText(personToDisplay.getName());
        holder.getHobbyTxt().setText(personToDisplay.getHobby());
    }

    @Override
    public int getItemCount() {
        return this.persons.size();
    }
}
