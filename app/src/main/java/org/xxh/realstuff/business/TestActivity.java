package org.xxh.realstuff.business;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.xxh.realstuff.R;
import org.xxh.realstuff.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiexinhong (xiexinhong@meituan.com) on 16/11/21.
 */

public class TestActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
//        ListView listView = (ListView) findViewById(R.id.lv_content);
//        List<String> list = new ArrayList<>();
//        for (int i=0;i<40;i++) {
//            list.add("Content:"+i);
//        }
//        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.test_list_item,list));

    }
}
