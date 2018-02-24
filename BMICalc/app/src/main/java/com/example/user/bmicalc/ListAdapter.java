package com.example.user.bmicalc;

import android.widget.ArrayAdapter;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2/23/2018.
 */

public class ListAdapter extends ArrayAdapter{
    List list = new ArrayList();
    public ListAdapter(Context context,int resource){
        super(context,resource);
    }

    @Override
    public void add(Object obj)
    {
        super.add(obj);
        list.add(obj);
    }
}
