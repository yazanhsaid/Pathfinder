package main;
import java.util.*;
class Cell {
    int x, y;
    Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Grid {
	int [][] grid;
	Cell startCell;
	Cell targetCell;
	public Grid (int gridSize) {
		grid = new int[gridSize][gridSize];
		populateGrid(grid);
	}
	
	public void populateGrid(int[][] grid) {
		int rows = grid.length;
		int columns = grid[0].length;
		int startX = rows - 1;
		int startY = 0;	
		int endX = 0;
		int endY = columns - 1;
		
		Random rand = new Random();
		for(int i = 0; i < grid.length; i++) {
		    for(int j = 0; j < grid[i].length; j++) {
		        //avoids placing obstacles where start cell can't move or target cell can't be reached.
		        if((Math.abs(i - startX) <= 1 && Math.abs(j - startY) <= 1) ||
		           (Math.abs(i - endX) <= 1 && Math.abs(j - endY) <= 1)) {
		            continue;
		        }
		        
		        //obstacles are placed at a 30% probability.
		        if(rand.nextDouble() < 0.3) {
		            grid[i][j] = 1;
		        }
			
			}		
		}
		startCell = new Cell(startX,startY);
		targetCell = new Cell(endX, endY);
		Traverse t = new Traverse();
		t.traverse(grid, startCell, targetCell);
		
	}
}
