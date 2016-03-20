package com.example.deyvison.aula06;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Deyvison on 03/03/2016.
 */
public class Aula06Application extends Application{

    private List<Planeta> planetas;

    @Override
    public void onCreate() {
        super.onCreate();
        planetas = new ArrayList<>();
        criarPlanetas();
    }

    private void criarPlanetas(){
        planetas.add(new Planeta(R.drawable.mercurio,"Mercurio"));

        planetas.add(new Planeta(R.drawable.venus,"Venus"));
        planetas.add(new Planeta(R.drawable.terra,"Terra"));
        planetas.add(new Planeta(R.drawable.marte,"Marte"));
        planetas.add(new Planeta(R.drawable.jupter,"Jupiter"));
        planetas.add(new Planeta(R.drawable.saturno, "Saturno"));
        planetas.add(new Planeta(R.drawable.urano,"Urano"));
        planetas.add(new Planeta(R.drawable.netuno, "Netuno"));
    }

    public List<Planeta> getPlanets(){
        return planetas;
    }

    public void addPlaneta(){
        Random random =  new Random();
        planetas.add(planetas.get(random.nextInt(planetas.size()-1)));
    }

    public void removerPlaneta(int idx){
        planetas.remove(idx);
    }
}
