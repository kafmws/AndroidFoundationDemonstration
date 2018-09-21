package com.example.hp.broadcasttest;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

class ActivityCollector {
    private static List<Activity> ActivityCollector = new ArrayList<>();

    public static void add(Activity activity){
        ActivityCollector.add(activity);
    }

    public static void remove(Activity activity){
        ActivityCollector.remove(activity);
    }

    protected static void finishAll(){
        for(Activity activity:ActivityCollector){
            if(!activity.isFinishing())
                activity.finish();
        }
        ActivityCollector.clear();
    }

}
