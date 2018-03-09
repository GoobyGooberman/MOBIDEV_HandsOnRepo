package com.neildg.mobidev_handsonrepo.activity_catchup;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.neildg.mobidev_handsonrepo.R;

/**
 * Created by Administrator on 3/9/2018.
 */

public class PersonViewHolder extends RecyclerView.ViewHolder {

    private TextView personNameTxt;
    private TextView hobbyTxt;

    public PersonViewHolder(View itemView) {
        super(itemView);

        this.personNameTxt = itemView.findViewById(R.id.person_name_txt);
        this.hobbyTxt = itemView.findViewById(R.id.hobby_txt);
    }

    public TextView getPersonNameTxt() {
        return this.personNameTxt;
    }

    public TextView getHobbyTxt() {
        return this.hobbyTxt;
    }
}
