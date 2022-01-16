package com.example.a3_recyclerviewcustomadapterwithheaderandfooterjava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a3_recyclerviewcustomadapterwithheaderandfooterjava.R;
import com.example.a3_recyclerviewcustomadapterwithheaderandfooterjava.model.Member;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_AVIALABLE_TRUE = 0;
    private static final int TYPE_AVIALABLE_FALSE = 1;
    private static final int TYPE_AVIALABLE_HEADER = 2;
    private static final int TYPE_AVIALABLE_FOOTER = 3;

    Context context;
    List<Member> members;
    public CustomAdapter(Context context, List<Member> members){
        this.context = context;
        this.members = members;
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeader(position)) return TYPE_AVIALABLE_HEADER;
        if (isFooter(position)) return TYPE_AVIALABLE_FOOTER;

        Member member = members.get(position);
        if (member.isAvtivity()){
            return TYPE_AVIALABLE_TRUE;
        }
        return TYPE_AVIALABLE_FALSE;
    }

    private boolean isHeader(int position) {
        return position == 0;
    }

    private boolean isFooter(int position) {
        return position == members.size() - 1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_AVIALABLE_HEADER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_header, parent, false);
            return new CustomViewHolderHEADER(view);
        }
        if (viewType == TYPE_AVIALABLE_FOOTER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_footer, parent, false);
            return new CustomViewHolderFOOTER(view);
        }

        if (viewType == TYPE_AVIALABLE_TRUE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout_true, parent, false);
            return new CustomViewHolderTRUE(view);
        }

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout_false, parent, false);
        return new CustomViewHolderFALSE(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (isHeader(position) || isFooter(position)) return;

        Member member = members.get(position);

        if (holder instanceof CustomViewHolderFALSE){
            TextView false_name =((CustomViewHolderFALSE) holder).name;
            TextView false_about = ((CustomViewHolderFALSE) holder).about;

            false_name.setText(member.getName());
            false_about.setText(member.getAbout());
        }

        if (holder instanceof CustomViewHolderTRUE){
            TextView true_name =((CustomViewHolderTRUE) holder).name;
            TextView true_about = ((CustomViewHolderTRUE) holder).about;

            true_name.setText(member.getName());
            true_about.setText(member.getAbout());
        }
    }

    private class CustomViewHolderHEADER extends RecyclerView.ViewHolder {
        public  View view;
        public CustomViewHolderHEADER(View v) {
            super(v);
            view = v;
        }
    }

    public class CustomViewHolderTRUE extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView about;
        private View view;
        public CustomViewHolderTRUE(View v) {
            super(v);
            view = v;
            name = view.findViewById(R.id.tv_true_name);
            about = view.findViewById(R.id.tv_true_about);
        }
    }
    public class CustomViewHolderFALSE extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView about;
        private View view;
        public CustomViewHolderFALSE(View v) {
            super(v);
            view = v;
            name = view.findViewById(R.id.tv_false_name);
            about = view.findViewById(R.id.tv_false_about);
        }
    }

    private class CustomViewHolderFOOTER extends RecyclerView.ViewHolder {
        public View view;
        public CustomViewHolderFOOTER(View v) {
            super(v);
            view = v;
        }
    }
}
