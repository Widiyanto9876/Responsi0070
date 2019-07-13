package com.responsi.mvp.adapter;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.responsi.mvp.R;
import com.responsi.mvp.model.Name;
import com.responsi.mvp.model.ResultsItem;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder> {

    Context mContext;
    List<ResultsItem> resultsItemList;
//    List<Name> nameList;

    public PeopleAdapter(Context mContext , List<ResultsItem> resultsItemList) {
        this.mContext = mContext;
        this.resultsItemList = resultsItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        ResultsItem data = resultsItemList.get(position);
//        Name namedata = nameList.get(position);
        String nameFull = resultsItemList.get(position).getName().getFirst()+""+resultsItemList.get(position).getName().getLast();

        Glide.with(mContext)
                .load(data.getPicture())
                .into(viewHolder.mImageGambar);

        viewHolder.mTextName.setText(nameFull );
        viewHolder.mTextPhone.setText(data.getPhone());
        viewHolder.mTextEmail.setText(data.getEmail());


    }

    @Override
    public int getItemCount() {
        return resultsItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView mImageGambar;
        TextView mTextName;
        TextView mTextPhone;
        TextView mTextEmail;
        RelativeLayout mLayoutHistory;

        public ViewHolder( View itemView) {
            super(itemView);
            mImageGambar = itemView.findViewById(R.id.ivImage);
            mTextName = itemView.findViewById(R.id.tvname);
            mTextPhone = itemView.findViewById(R.id.tvPhone);
            mTextEmail = itemView.findViewById(R.id.tvEmail);




                }
    }
}
