package com.brks.writepls;

import java.util.Comparator;

public class Compare implements Comparator<ToDo> {

    @Override
    public int compare(ToDo o1, ToDo o2) {

        return  -(o1.getImportance() - o2.getImportance());
    }
}
