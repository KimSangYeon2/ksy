package algorithm_0806;

import java.util.ArrayList;
import java.util.Stack;

public class practice_DFS_arraylist {
	
    static boolean[] visited = new boolean[7]; //방문 배열
    static ArrayList<Integer>[] A = new ArrayList[7];//ArrayList타입 배열
    static ArrayList<Integer> procedure = new ArrayList<>(); //탐색 순서 list

    public static void main(String[] args){
    
 	//배열의 각 요소마다 ArrayList를 가진다.
        for(int i=1;i<=6;i++) {
            A[i] = new ArrayList<>();
        }
        A[1].add(2);
        A[1].add(3);
        A[2].add(5);
        A[2].add(6);
        A[3].add(4);
        A[4].add(6);
        
        //1번노드에서 DFS 실행
        DFS(1);

        System.out.println(procedure.toString()); 
        // [1, 3, 4, 6, 2, 5] (스택)
        // [1, 2, 6, 5, 3, 4] (재귀)
        // 인접리스트에 들어있는 값의 순서에 따라 탐색 순서가 달라질 수 있으나, 두가지 경우 모두 DFS가 맞다.
    }
    
//    //스택
//    public static void DFS(int v){
//        Stack<Integer> stack = new Stack<>();
//
//        stack.push(v);;
//        
//        while(!stack.isEmpty()){
//            int cur = stack.pop();
//            visited[cur] = true;
//            procedure.add(cur);
//
//            //해당 노드의 인접리스트를 검사하며, visited가 false인 경우에만 stack.push
//            for (int i : A[cur]) {
//                if(!visited[i]){
//                    stack.push(i);
//                }
//            }
//        }
//    }
    
    //재귀
    static void DFS(int v){
        //방문배열이 true면 return
        if(visited[v]) return;

        //v 노드에 방문했으므로, 해당 방문배열을 true로 바꿔주고, 탐색순서 리스트에 추가해줌
        visited[v] = true;
        procedure.add(v);

        //해당노드의 ArrayList(인접노드)를 모두 돌며 방문배열이 false인 경우에
        for(int i : A[v]){
            if(!visited[i]){
                DFS(i); //해당 노드에 대해서 DFS를 다시 실행한다.
            }
        }
    }

}
