package com.bryankoproject.cmps121_asg2.view;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.bryankoproject.cmps121_asg2.R;
import com.bryankoproject.cmps121_asg2.controller.GameContent;
import com.bryankoproject.cmps121_asg2.model.GameLogic;

public class GridViewFragment extends Fragment {

    int positionList[] = {
            0, 1, 2, 3, 4, 5, 6,
            7, 8, 9, 10, 11, 12, 13,
            14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26, 27,
            28, 29, 30, 31, 32, 33, 34,
            35, 36, 37, 38, 39, 40, 41 };

    int takenList[] = {
            0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0,

            0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0,

            0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0};

    int gameBoard[] = {
            R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq,
            R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq,
            R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq,
            R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq,
            R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq,
            R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment;
        //GridFragment fragment = new GridFragment(GameContent.this, gameBoard);
        View rootView = inflater.inflate(R.layout.fragment_grid_view, container, false);
        GridView gridView = (GridView) rootView.findViewById(R.id.boardGrid2);
        //gridView.setAdapter(new GridFragments(fragment));
        return rootView;
    }
}

class GridFragments extends BaseAdapter {
    private int icons [];
    private Context context;
    private LayoutInflater inflater;

    public GridFragments (Context context, int icons[]) {
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
