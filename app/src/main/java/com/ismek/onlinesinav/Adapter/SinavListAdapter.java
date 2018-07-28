package com.ismek.onlinesinav.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ismek.onlinesinav.Listener.SinavListener;
import com.ismek.onlinesinav.R;
import com.ismek.onlinesinav.entity.Sinav;

import java.util.List;


public class SinavListAdapter extends Adapter<SinavListAdapter.SinavViewHolder>{

    private Context context;
    private List<Sinav> sinavList;
    private SinavListener listener;

    public SinavListAdapter(Context context, List<Sinav> list, SinavListener listener) {
        this.context = context;
        this.sinavList = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SinavViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_sinavlistesi,parent,false);
        return new SinavViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SinavViewHolder holder, int position) {
        Sinav sinav = sinavList.get(position);

        //holder.txtSinavAdi.setText(sinav.getSinavAdi());
        holder.txtSinavZamani.setText(sinav.getSinavTarihi()+" "+sinav.getBsSaati());
        holder.txtSinavSalonu.setText(sinav.getSinavSalonu());
    }

    @Override
    public int getItemCount() {
        return sinavList.size();
    }

    public class SinavViewHolder extends RecyclerView.ViewHolder{


        public TextView txtSinavAdi;
        public TextView txtSinavZamani;
        public TextView txtSinavSalonu;
        public ImageButton btnKatil;

        public SinavViewHolder(final View itemView) {
            super(itemView);

            txtSinavAdi = itemView.findViewById(R.id.sinavAdi);
            txtSinavSalonu = itemView.findViewById(R.id.salonNo);
            txtSinavZamani = itemView.findViewById(R.id.sinavZamani);
            btnKatil = itemView.findViewById(R.id.btnKatil);

            btnKatil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClicked(itemView,getAdapterPosition());
                }
            });
        }
    }
}
