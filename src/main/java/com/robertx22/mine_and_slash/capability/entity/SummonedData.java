package com.robertx22.mine_and_slash.capability.entity;

import java.util.HashMap;

public class SummonedData {
    private HashMap<String, Integer> summonedTypes = new HashMap<>();

    public void addSummonedType(String type, int amount) {
        summonedTypes.put(type, summonedTypes.getOrDefault(type, 0) + amount);
    }

    public int getSummonedAmount(String type) {
        return summonedTypes.getOrDefault(type, 0);
    }

    public boolean hasSummoned(String spell) {
        return summonedTypes.get(spell) != null;
    }
}
