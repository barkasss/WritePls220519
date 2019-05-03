package com.brks.writepls;

import java.util.Comparator;

public class CompareSh implements Comparator<ShoppingElement> {
    @Override
    public int compare(ShoppingElement o1, ShoppingElement o2) {


        return -Boolean.compare(o1.isStatus(),o2.isStatus());
    }
}
