package com.company;

public class Main {

    public static void main(String[] args) {
        GraphImp graph = new GraphImp() ;
        graph.addVer("A");
        graph.addVer("B");
        graph.addVer("C");
        graph.addVer("D");
        graph.addVer("E");
        graph.addVer("F");
        graph.addVer("G");
        //первая ветка
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        //вторая ветка
        graph.addEdge(0, 5);
        graph.addEdge(5, 6);
        //соединение
        graph.addEdge(6, 2);
        //при выборе любой ветки элементы C(2) и D(3) обязательны
        graph.search(0, 4);
    }
}