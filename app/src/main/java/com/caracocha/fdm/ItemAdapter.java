package com.caracocha.fdm;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by xabi on 6/21/15.
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private static final String DEBUG_TAG = "ItemAdapter";

    Context context;
    ArrayList<Item> alItems;

    public ItemAdapter(ArrayList alItems, Context context) {
        this.alItems = alItems;
        this.context = context;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int iViewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = null;
        switch (iViewType) {
            case Item.iEVENT:
                view = inflater.inflate(R.layout.item_event, viewGroup, false);
                break;
            case Item.iDAY:
                view = inflater.inflate(R.layout.item_day, viewGroup, false);
                break;
            case Item.iINFO:
                view = inflater.inflate(R.layout.item_info, viewGroup, false);
                break;
            default:
                break;
        }
        return new ItemViewHolder(view, iViewType);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder itemViewHolder, int i) {
        Item item = alItems.get(i);
        switch (getItemViewType(i)) {
            case Item.iEVENT:
                itemViewHolder.tvTitle.setText(item.sTitle);
                itemViewHolder.tvTime.setText(item.sStartTime);
                itemViewHolder.tvPlace.setText(item.sPlace);
                itemViewHolder.ivEvent.setImageResource(context.getResources().getIdentifier(item.sCategory.toLowerCase(), "drawable", context.getPackageName()));
                break;
            case Item.iDAY:
                itemViewHolder.tvDay.setText(item.sMessage);
                break;
            case Item.iINFO:
                break;
            default:
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        String sType = alItems.get(position).sType;
        if (sType == Item.EVENT) {
            return Item.iEVENT;
        } else if (sType == Item.DAY) {
            return Item.iDAY;
        } else if (sType == Item.INFO) {
            return Item.iINFO;
        } else if (sType == Item.AD) {
            return Item.iAD;
        } else {
            return -1;
        }
    }

    @Override
    public int getItemCount() {
        return alItems.size();
    }
}