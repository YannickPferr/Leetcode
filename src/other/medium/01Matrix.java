package other.medium;

/**
 * Problem: 542. 01 Matrix
 * Difficulty: Medium
 * Link: https://leetcode.com/problems01-matrix
 */
public class 01Matrix{
public int[][]updateMatrix(int[][]mat){
        Deque<Integer[]>q=new ArrayDeque<>();
        for(int i=0;i<mat.length;i++)
        for(int j=0;j<mat[i].length;j++){
        if(mat[i][j]==0)
        q.add(new Integer[]{i,j});
        else
        mat[i][j]=Integer.MAX_VALUE;
        }

        boolean[][]visited=new boolean[mat.length][mat[0].length];
        int count=0;
        while(!q.isEmpty()){
        int levelSize=q.size();
        for(int k=0;k<levelSize; k++){
        Integer[]idx=q.poll();
        int x=idx[0];
        int y=idx[1];
        visited[x][y]=true;
        if(mat[x][y]!=0)
        mat[x][y]=Math.min(mat[x][y],count);

        if(x+1<mat.length&&!visited[x+1][y])
        q.add(new Integer[]{x+1,y});
        if(y+1<mat[0].length&&!visited[x][y+1])
        q.add(new Integer[]{x,y+1});
        if(x-1>=0&&!visited[x-1][y])
        q.add(new Integer[]{x-1,y});
        if(y-1>=0&&!visited[x][y-1])
        q.add(new Integer[]{x,y-1});
        }
        count++;
        }

        return mat;
        }

        }