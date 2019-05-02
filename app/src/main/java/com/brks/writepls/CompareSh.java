package com.brks.writepls;

import java.util.Comparator;

public class CompareSh implements Comparator<ShoppingElement> {
    @Override
    public int compare(ShoppingElement o1, ShoppingElement o2) {
        return o1.isStatus() - o1.isStatus();
    }
}
