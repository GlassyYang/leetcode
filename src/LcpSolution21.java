import java.util.*;

public class LcpSolution21 {
    //邻接表图
    Set<Integer>[] graph;
    //储存环节点集合
    Set<Integer> hoops;
    //边数据集
    int[][] edges;
    //环入口点
    int firstHoop;
    public int chaseGame(int[][] edges, int startA, int startB) {
        this.edges=edges;
        //建图
        createGraph(edges);
        //第一种情况：A和B直接相连则直接返回1
        if(graph[startA].contains(startB)) return 1;
        //储存环内节点
        hoops=new HashSet<>();
        //记录每个点的父节点
        int[] parent=new int[edges.length+1];
        //dfs找环
        dfs(parent,-1,1,new boolean[edges.length+1]);
        int temp=firstHoop;
        hoops.add(temp);
        //遍历父节点数组，结束条件为该点的父节点是环入口
        while (parent[temp]!=firstHoop){
            temp=parent[temp];
            hoops.add(temp);//将环加入集合
        }
        //得到A和B的距离数组
        int[] valA=getDist(startA,new boolean[edges.length+1]);
        int[] valB=getDist(startB,new boolean[edges.length+1]);
        //得到B进入环的最小距离的点
        int interInd = getInterInd(valB);
        //第二种情况：环的节点大于3并且B可以到达环，则A永远追不上B
        if(hoops.size()>3&&valA[interInd]-1>valB[interInd]) return -1;
        //第三种情况A一定可以追上B
        return maxVal(valA, valB,startB,new boolean[edges.length+1]);

    }
    boolean finished=false;
    /**
     * dfs找环
     * @param parent 父节点数组
     * @param pa 上一个已经访问的点
     * @param ch 当前访问的点
     * @param visited 标记数组
     */
    public void dfs(int[] parent,int pa,int ch,boolean[] visited){
        //判断是否找到环入口点
        if(visited[ch]){
            finished=true;//标记
            firstHoop=ch;//记录环入口
            return;
        }
        visited[ch]=true;
        Set<Integer> set = graph[ch];
        for (Integer i : set) {
            if(!finished&&i!=pa){
                parent[i]=ch;
                dfs(parent,ch,i,visited);
            }
        }
    }

    /**
     * 递归遍历B可以到达的点
     * @param valA A与每个点的距离
     * @param valB B与每个点的距离
     * @param i 可以到达的点
     * @param visited 标记数组
     * @return B与A最远的距离
     */
    public int maxVal(int[] valA,int[]valB,int i,boolean[] visited){
        visited[i]=true;
        Set<Integer> set = graph[i];
        int max=valA[i];
        for (Integer c : set) {
            /**
             * B能够到达点c的条件为：B与c的距离严格大于A与c距离-1
             * valA[ch]-1>valB[ch]
             */
            if(!visited[c]&&valA[c]-1>valB[c]){
                max=Math.max(max,maxVal(valA,valB,c,visited));
            }
        }
        return max;
    }

    /**
     * 求出A或B进入环，花费距离最小的入口点
     * @param val 各个点到A或B的距离数组
     * @return 环入口点坐标
     */
    public int getInterInd(int[] val){
        int minB=1000000;
        int index=-1;
        //遍历环集合
        for (Integer i : hoops) {
            if(val[i]<minB){
                minB=val[i];
                index=i;
            }
        }
        return index;
    }

    /**
     * bfs求出每个点到点start的距离
     * @param start 目标点
     * @return 返回距离数组
     */
    public int[] getDist(int start,boolean[] visited){
        int[] valStart=new int[edges.length+1];
        int v=0;//点到start的距离
        visited[start]=true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        while (!queue.isEmpty()){
            int size = queue.size();
            //得到当前层的节点
            for(int i=0;i<size;i++){
                Integer p = queue.poll();
                valStart[p]=v;
                //下一层的所有节点入队列
                Set<Integer> chs = graph[p];
                for (Integer ch : chs) {
                    if(!visited[ch]){
                        visited[ch]=true;
                        queue.add(ch);
                    }
                }
            }
            //进入下一层，距离加一
            v++;
        }
        return valStart;
    }

    /**
     * 邻接表建图
     * @param edges 边
     */
    public void createGraph(int[][]edges){
        graph=new HashSet[edges.length+1];
        for(int i=1;i<graph.length;i++){
            graph[i]=new HashSet<>();
        }
        for (int[] edge : edges) {
            int i=edge[0];
            int j=edge[1];
            graph[i].add(j);
            graph[j].add(i);
        }
    }
}
