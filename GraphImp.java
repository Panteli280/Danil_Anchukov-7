package com.company;

public class GraphImp {
    private int maxN = 10;
    private int verSize;
    //назван так, потому что array уже есть
    private int[][] mas;
    private Vertex[] verList;
    private GraphStack myStack = new GraphStack();

    public GraphImp() {
        verList = new Vertex[maxN];
        mas = new int[maxN][maxN];
        verSize = 0;
    }

    public void addVer(String name) {
        verList[verSize++] = new Vertex(name);
    }

    public void addEdge(int from, int to) {
        mas[from][to] = 1;
        mas[to][from] = 1;
    }

    public void search(int from, int to) {
        for (int v = 0; v < verSize; v++) {
            String name = verList[v].name;
            if (v != from && v != to) {
                for (int j = 0; j < verSize; j++)
                    verList[j].isVisited = false;
                //отметив вершину как уже пройденную, мы делаем её несуществующей во время глубинного обхода
                verList[v].isVisited = true;
                if (passInDeep(from, to) == false)
                    System.out.println(name);
            }
        }
    }

    //стандартный глубинный обход с 2мя модификациями. Вместо вывода списка вершин просто определяет, есть ли такой путь
    public boolean passInDeep(int index, int to) {
        myStack.update();
        verList[index].isVisited = true;
        myStack.push(index);
        while (!myStack.isEmpty()) {
            if (verList[myStack.peek()] == verList[to])
                return true;
            int neighbor = checker(myStack.peek());
            if (neighbor == -1){
                neighbor = myStack.pop();
            }
            else {
                verList[neighbor].isVisited = true;
                myStack.push(neighbor);
            }
        }
        return false;
    }

    //проверка на возможность попасть в вершину и из неё. Если попасть возможно, то дополнительно указывает, куда. Отсюда и не boolean
     public int checker(int vertex) {
        for (int i = 0; i < verSize; i++) {
            if (mas[vertex][i] == 1 && verList[i].isVisited == false) {
                return i;
            }
        }
        return -1;
    }
}
