package com.example.deyvison.aula06;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Deyvison on 03/03/2016.
 */
public class PlanetaAdapter extends BaseAdapter{

    private Context context;
    private List<Planeta> planetas;
    private boolean isGrid;
    private Aula06Application application;

    public PlanetaAdapter(Context context, boolean isGrid) {
        this.context = context;
        this.application = (Aula06Application) context.getApplicationContext();
        this.planetas = application.getPlanets();
        this.isGrid = isGrid;
    }

    @Override
    public int getCount() {
        return planetas.size();
    }

    @Override
    public Object getItem(int position) {
        return planetas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public void setIsGrid(boolean isGrid){
        this.isGrid = isGrid;
    }
    public boolean getIsGrid(){
        return isGrid;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;

        if(isGrid){
            view = LayoutInflater.from(context).inflate(R.layout.layout_grid_item, parent, false);
        }else{
            view = LayoutInflater.from(context).inflate(R.layout.layout_item_list, parent, false);
        }

        Planeta planeta = planetas.get(position);


        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        TextView textView = (TextView) view.findViewById(R.id.textView);

        imageView.setImageResource(planeta.getIdImage());
        textView.setText(planeta.getNome());

        return view;
    }
}
