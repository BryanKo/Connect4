package com.bryankoproject.cmps121_asg2.view;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bryankoproject.cmps121_asg2.R;

/**
 * Created by imbko on 11/7/2017.
 */

public class GridFragment extends BaseAdapter{
    private int icons [];
    private Context context;
    private LayoutInflater inflater;

    public GridFragment (Context context, int icons[]) {
        this.context = context;
        this.icons = icons;
    }

    @Override
    public int getCount() {
        return icons.length;
    }

    @Override
    public Object getItem(int position) {
        return icons[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View gridView = convertView;

        if (convertView == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridView = inflater.inflate(R.layout.board_row_design, null);
        }

        ImageView icon = (ImageView) gridView.findViewById(R.id.ivCell);

        icon.setImageResource(icons[position]);
        return gridView;
    }
}
