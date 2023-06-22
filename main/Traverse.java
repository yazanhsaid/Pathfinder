package main;
import java.util.*;

public class Traverse {
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    
	public void traverse(int[][] grid, Cell start, Cell target) {
		if(grid == null || (grid.length == 0 && grid[0].length == 0)) {
			return;
		}
		
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		Queue<Cell> queue = new LinkedList<>();
		
		queue.offer(start);
		visited[start.x][start.y] = true;
		
		while(!queue.isEmpty()) {
			Cell current = queue.remove();
			System.out.println(current.x + " " + current.y);
			
            if (current.x == target.x && current.y == target.y) {
                System.out.println("Reached the target!");
                return;
            }	
            
            for(int i = 0; i < 4; i++) {
            	int newX = current.x + dx[i];
                int newY = current.y + dy[i];
            
	            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && !visited[newX][newY] && grid[newX][newY] == 0) {
	                queue.offer(new Cell(newX, newY));
	                visited[newX][newY] = true;
	            }
            }
		
		}
		
	}
	
}
