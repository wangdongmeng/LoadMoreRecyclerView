package com.example.hua.loadmorerecyclerview;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.hua.loadmorerecyclerview.wrapper.LoadMoreWrapper;
import com.example.hua.loadmorerecyclerview.wrapper.LoadMoreWrapperAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

//    private LoadMoreAdapter mAdapter;

    private LoadMoreWrapper wrapper;
    private LoadMoreWrapperAdapter mAdapter;

    private List<Person> mPersons;

    //每次加载显示的数据
    private int pageSize = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        initView();

    }


    private void initView() {

        //先预加载pageSize个数据
        final List<Person> persons = MyApplication.getDaoInstant().getPersonDao().queryBuilder().limit(pageSize).list();

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter =  new LoadMoreWrapperAdapter();
        wrapper = new LoadMoreWrapper(mAdapter);
        mAdapter.setPersons(persons);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);

        mRecyclerView.setAdapter(wrapper);

        //加载更多
        mRecyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener() {
            @Override
            protected void onLoadMore() {
                wrapper.setLoadState(wrapper.LOADING);
                //如果每次加载的数据比当前的数据小，就处于加载状态
                if (persons.size() < mPersons.size()) {
                    //每次加载的数据
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            List<Person> list = MyApplication.getDaoInstant().getPersonDao().queryBuilder().limit(pageSize).offset(persons.size()).list();
                            persons.addAll(list);
                            mAdapter.setPersons(persons);
                            wrapper.setLoadState(wrapper.LOADING_COMPLETE);
                        }
                    }, 1000);

                } else {
                    wrapper.setLoadState(wrapper.LOADING_END);
                }
            }
        });

    }

    private void initData() {
        mPersons = new ArrayList<>();

        Person person = new Person();
        person.setName("A");
        person.setSex("女");
        mPersons.add(person);

        person = new Person();
        person.setName("B");
        person.setSex("男");
        mPersons.add(person);


        person = new Person();
        person.setName("C");
        person.setSex("女");
        mPersons.add(person);

        person = new Person();
        person.setName("D");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("E");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("F");
        person.setSex("女");
        mPersons.add(person);

        person = new Person();
        person.setName("G");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("H");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("I");
        person.setSex("女");
        mPersons.add(person);

        person = new Person();
        person.setName("G");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("K");
        person.setSex("女");
        mPersons.add(person);

        person = new Person();
        person.setName("L");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("M");
        person.setSex("女");
        mPersons.add(person);

        person = new Person();
        person.setName("N");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("N");
        person.setSex("女");
        mPersons.add(person);



        person = new Person();
        person.setName("B");
        person.setSex("男");
        mPersons.add(person);


        person = new Person();
        person.setName("C");
        person.setSex("女");
        mPersons.add(person);

        person = new Person();
        person.setName("D");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("E");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("F");
        person.setSex("女");
        mPersons.add(person);

        person = new Person();
        person.setName("G");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("H");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("I");
        person.setSex("女");
        mPersons.add(person);

        person = new Person();
        person.setName("G");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("K");
        person.setSex("女");
        mPersons.add(person);

        person = new Person();
        person.setName("L");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("M");
        person.setSex("女");
        mPersons.add(person);

        person = new Person();
        person.setName("N");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("N");
        person.setSex("女");
        mPersons.add(person);



        person = new Person();
        person.setName("B");
        person.setSex("男");
        mPersons.add(person);


        person = new Person();
        person.setName("C");
        person.setSex("女");
        mPersons.add(person);

        person = new Person();
        person.setName("D");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("E");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("F");
        person.setSex("女");
        mPersons.add(person);

        person = new Person();
        person.setName("G");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("H");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("I");
        person.setSex("女");
        mPersons.add(person);

        person = new Person();
        person.setName("G");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("K");
        person.setSex("女");
        mPersons.add(person);

        person = new Person();
        person.setName("L");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("M");
        person.setSex("女");
        mPersons.add(person);

        person = new Person();
        person.setName("N");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("N");
        person.setSex("女");
        mPersons.add(person);



        person = new Person();
        person.setName("B");
        person.setSex("男");
        mPersons.add(person);


        person = new Person();
        person.setName("C");
        person.setSex("女");
        mPersons.add(person);

        person = new Person();
        person.setName("D");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("E");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("F");
        person.setSex("女");
        mPersons.add(person);

        person = new Person();
        person.setName("G");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("H");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("I");
        person.setSex("女");
        mPersons.add(person);

        person = new Person();
        person.setName("G");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("K");
        person.setSex("女");
        mPersons.add(person);

        person = new Person();
        person.setName("L");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("M");
        person.setSex("女");
        mPersons.add(person);

        person = new Person();
        person.setName("N");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("N");
        person.setSex("女");
        mPersons.add(person);


        person = new Person();
        person.setName("B");
        person.setSex("男");
        mPersons.add(person);


        person = new Person();
        person.setName("C");
        person.setSex("女");
        mPersons.add(person);

        person = new Person();
        person.setName("D");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("E");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("F");
        person.setSex("女");
        mPersons.add(person);

        person = new Person();
        person.setName("G");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("H");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("I");
        person.setSex("女");
        mPersons.add(person);

        person = new Person();
        person.setName("G");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("K");
        person.setSex("女");
        mPersons.add(person);

        person = new Person();
        person.setName("L");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("M");
        person.setSex("女");
        mPersons.add(person);

        person = new Person();
        person.setName("N");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("N");
        person.setSex("女");
        mPersons.add(person);


        person = new Person();
        person.setName("B");
        person.setSex("男");
        mPersons.add(person);


        person = new Person();
        person.setName("C");
        person.setSex("女");
        mPersons.add(person);

        person = new Person();
        person.setName("D");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("E");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("F");
        person.setSex("女");
        mPersons.add(person);

        person = new Person();
        person.setName("G");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("H");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("I");
        person.setSex("女");
        mPersons.add(person);

        person = new Person();
        person.setName("G");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("K");
        person.setSex("女");
        mPersons.add(person);

        person = new Person();
        person.setName("L");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("M");
        person.setSex("女");
        mPersons.add(person);

        person = new Person();
        person.setName("N");
        person.setSex("男");
        mPersons.add(person);

        person = new Person();
        person.setName("N");
        person.setSex("女");
        mPersons.add(person);



        MyApplication.getDaoInstant().getPersonDao().insertOrReplaceInTx(mPersons);


    }
}
