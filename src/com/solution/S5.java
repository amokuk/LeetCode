package com.solution;

import java.util.*;

public class S5 {
    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        graph.computeIfAbsent("1", l->new ArrayList<>()).add("2");
        graph.computeIfAbsent("1", l->new ArrayList<>()).add("3");
        graph.computeIfAbsent("2", l->new ArrayList<>()).add("1");
        graph.computeIfAbsent("2", l->new ArrayList<>()).add("3");
        graph.computeIfAbsent("3", l->new ArrayList<>()).add("1");
        graph.computeIfAbsent("3", l->new ArrayList<>()).add("2");

        S5 s = new S5();
        String ser = s.serializeGraph(graph);
        graph = s.deserializeGraph(ser);

        System.out.println(graph);
    }

    public String serializeGraph(Map<String, List<String>> graph) {
        StringBuilder res = new StringBuilder();
        for(String node : graph.keySet()) {
            res.append(node + "[");
            for(String nei : graph.get(node)) {
                res.append(nei + "_");
            }
            res.append("]");
        }
        return res.toString();
    }

    public Map<String, List<String>> deserializeGraph(String str) {
        Map<String, List<String>> graph = new HashMap<>();
        int i=0;
        while(i < str.length()) {
            int left = 0, j = i;
            for(; str.charAt(j) != ']'; j++) {
                if(str.charAt(j) == '[') {
                    left = j;
                }
            }
            String node = str.substring(i, left);
            List<String> list = new ArrayList<>();
            String listStr = str.substring(left+1, j);
            String[] neis = listStr.split("_");
            for(String nei : neis) {
                if(nei.length() > 0) {
                    list.add(nei);
                }
            }
            graph.put(node, list);
            i = j+1;
        }
        return graph;
    }
}
