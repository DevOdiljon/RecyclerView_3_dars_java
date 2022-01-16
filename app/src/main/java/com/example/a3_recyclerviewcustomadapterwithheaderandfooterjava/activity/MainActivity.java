package com.example.a3_recyclerviewcustomadapterwithheaderandfooterjava.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.a3_recyclerviewcustomadapterwithheaderandfooterjava.R;
import com.example.a3_recyclerviewcustomadapterwithheaderandfooterjava.adapter.CustomAdapter;
import com.example.a3_recyclerviewcustomadapterwithheaderandfooterjava.model.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Context context;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        List<Member> members = prepareMemberList();
        refreshAdapter(members);

    }

    void initViews(){
        context = this;
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
    }

    private void refreshAdapter(List<Member> members) {
        CustomAdapter adapter = new CustomAdapter(context, members);
        recyclerView.setAdapter(adapter);
    }

    private List<Member> prepareMemberList() {
        List<Member> members = new ArrayList<>();

        members.add(new Member());

        for (int i = 0; i < 20; i++){
            Random random = new Random();
            int count = random.nextInt();

            if (count % 2 == 0){
                members.add(new Member("Odiljon","Android developer", true));
            }else {
                members.add(new Member("Alijon", "Mathematics and physics teacher", false));
            }
        }
        members.add(new Member());
        return members;
    }
}