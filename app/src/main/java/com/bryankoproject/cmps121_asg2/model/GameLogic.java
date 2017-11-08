package com.bryankoproject.cmps121_asg2.model;

import android.support.annotation.Nullable;

/**
 * Created by imbko on 11/8/2017.
 */

public class GameLogic {

    public boolean horCheck (int taken[], int player, int pos) {
        if (player == taken[pos+1+35] && player == taken[pos+2+35] && player == taken[pos+3+35]) return true;
        else if (player == taken[pos-1+35] && player == taken[pos+1+35] && player == taken[pos+2+35]) return true;
        else if (player == taken[pos-2+35] && player == taken[pos-1+35] && player == taken[pos+1+35]) return true;
        else if (player == taken[pos-3+35] && player == taken[pos-2+35] && player == taken[pos-1+35]) return true;
        else return false;
    }

    public boolean virtCheck (int taken[], int player, int pos) {
        if (player == taken[pos+7+35] && player == taken[pos+14+35] && player == taken[pos+21+35]) return true;
        else if (player == taken[pos-7+35] && player == taken[pos+7+35] && player == taken[pos+14+35]) return true;
        else if (player == taken[pos-14+35] && player == taken[pos-7+35] && player == taken[pos+7+35]) return true;
        else if (player == taken[pos-21+35] && player == taken[pos-14+35] && player == taken[pos-7+35]) return true;
        else return false;
    }

    public boolean rdiagCheck (int taken[], int player, int pos) {
        if (player == taken[pos+6+35] && player == taken[pos+12+35] && player == taken[pos+18+35]) return true;
        else if (player == taken[pos-6+35] && player == taken[pos+6+35] && player == taken[pos+12+35]) return true;
        else if (player == taken[pos-12+35] && player == taken[pos-6+35] && player == taken[pos+6+35]) return true;
        else if (player == taken[pos-18+35] && player == taken[pos-12+35] && player == taken[pos-6+35]) return true;
        else return false;
    }

    public boolean ldiagCheck (int taken[], int player, int pos) {
        if (player == taken[pos+8+35] && player == taken[pos+16+35] && player == taken[pos+24+35]) return true;
        else if (player == taken[pos-8+35] && player == taken[pos+8+35] && player == taken[pos+16+35]) return true;
        else if (player == taken[pos-16+35] && player == taken[pos-8+35] && player == taken[pos+8+35]) return true;
        else if (player == taken[pos-24+35] && player == taken[pos-16+35] && player == taken[pos-8+35]) return true;
        else return false;
    }


}
