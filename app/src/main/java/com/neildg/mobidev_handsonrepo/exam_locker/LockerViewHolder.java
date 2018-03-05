package com.neildg.mobidev_handsonrepo.exam_locker;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.neildg.mobidev_handsonrepo.R;

/**
 * Created by NeilDG on 2/11/2018.
 */

public class LockerViewHolder extends RecyclerView.ViewHolder {

    private TextView itemView;

    public LockerViewHolder(View itemView) {
        super(itemView);

        this.itemView = itemView.findViewById(R.id.locker_key_view);
    }

    public TextView getLockerKeyView() {
        return this.itemView;
    }
}
