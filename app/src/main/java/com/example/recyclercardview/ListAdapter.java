package com.example.recyclercardview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.time.chrono.MinguoDate;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<listElement> mData;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapter(List<listElement> itemlist, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemlist;
    }

    @Override
    public int getItemCount() {return mData.size();
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.list_element, null);
        return new ListAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position){
        holder.bindData(mData.get(position));
    }

    public void setItems(List<listElement> items){mData = items;}

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconimage;
        TextView name, city, status;

        ViewHolder(View itemView){
            super(itemView);
            iconimage = itemView.findViewById(R.id.iconimageview);
            name = itemView.findViewById(R.id.txtname);
            city = itemView.findViewById(R.id.txtciudad);
            status = itemView.findViewById(R.id.txtstatus);

        }

        void bindData(final listElement item){
            iconimage.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
            name.setText(item.getNombre());
            city.setText(item.getCiudad());
            status.setText(item.getEstado());
        }

    }

}
