package com.caracocha.fdm;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by xabi on 6/21/15.
 */
public class ItemViewHolder extends RecyclerView.ViewHolder {
    private static final String DEBUG_TAG = "ItemViewHolder";

    // EVENT item
    protected ImageView ivEvent;
    protected TextView tvTitle;
    protected TextView tvTime;
    protected TextView tvPlace;

    // DAY item
    protected TextView tvDay;

    // INFO item
    protected TextView tvInfo;

    public ItemViewHolder(View itemView, int iViewType) {
        super(itemView);
        switch (iViewType) {
            case Item.iEVENT:
                ivEvent = (ImageView) itemView.findViewById(R.id.item_event_image);
                tvTitle = (TextView) itemView.findViewById(R.id.item_event_title);
                tvTime = (TextView) itemView.findViewById(R.id.item_event_time);
                tvPlace = (TextView) itemView.findViewById(R.id.item_event_place);
                break;
            case Item.iDAY:
                tvDay = (TextView) itemView.findViewById(R.id.item_day_day);
                break;
            case Item.iINFO:
                tvInfo = (TextView) itemView.findViewById(R.id.item_info_text);
                break;
            case Item.iAD:
                break;
            default:
                Log.d(DEBUG_TAG, "Wrong iViewType (" + iViewType + ")");
        }
    }
}