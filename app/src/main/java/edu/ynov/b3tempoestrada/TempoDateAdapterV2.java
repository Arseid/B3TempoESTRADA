package edu.ynov.b3tempoestrada;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.ynov.b3tempoestrada.databinding.TempoDateItemBinding;
import edu.ynov.b3tempoestrada.databinding.TempoDateItemV2Binding;

public class TempoDateAdapterV2 extends RecyclerView.Adapter<TempoDateAdapterV2.TempoDateViewHolderV2>{

    private final List<TempoDate> tempoDates;
    private Context context;

    public TempoDateAdapterV2(List<TempoDate> tempoDates, Context context) {
        this.tempoDates = tempoDates;
        this.context = context;
    }

    @NonNull
    @Override
    public TempoDateAdapterV2.TempoDateViewHolderV2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tempo_date_item_v2, parent,false);
        TempoDateItemV2Binding binding = TempoDateItemV2Binding.bind(v);
        return new TempoDateAdapterV2.TempoDateViewHolderV2(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TempoDateAdapterV2.TempoDateViewHolderV2 holder, int position) {
        holder.binding.dateTv.setText(tempoDates.get(position).getDate());
        holder.binding.colorTv.setText(tempoDates.get(position).getCouleur().toString());
        holder.binding.colorFl.setBackgroundColor(ContextCompat.getColor(context, tempoDates.get(position).getCouleur().getColorResId()));
    }

    @Override
    public int getItemCount() { return tempoDates.size(); }

    public class TempoDateViewHolderV2 extends RecyclerView.ViewHolder {
        TempoDateItemV2Binding binding;

        public TempoDateViewHolderV2(@NonNull TempoDateItemV2Binding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
