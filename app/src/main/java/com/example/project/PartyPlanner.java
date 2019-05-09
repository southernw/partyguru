package com.example.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PartyPlanner {
    ArrayList<String> names;

    public PartyPlanner() {

       names = new ArrayList<>();
        names.add("Bob Ross");
        names.add("Bear Grylls");
        names.add("Thanos");
        names.add("Joyce");
        names.add("Southern");
        names.add("Cathy");
        names.add("Ron");
        names.add("Kendall");
        names.add("Ralph");
    }

    public String getRandomName() {
        Random random = new Random();
        String rndName;
        rndName = names.get(random.nextInt(names.size()));
        return rndName;
    }
}
