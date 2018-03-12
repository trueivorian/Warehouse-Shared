package Pathfinding;
import java.awt.Point;
import java.awt.geom.Point2D;

import rp.robotics.mapping.GridMap;
import rp.robotics.mapping.MapUtils;

public class GridMapExperiment {
	
	//private warehouseGrid;
	
	//private Point2D currentPos = new Point(0, 0);
	
	public static void main(String[] args) {
		GridMap warehouseGrid = MapUtils.createRealWarehouse();
		
		Graph graph = new Graph(warehouseGrid);
		graph.drawGrid();
		
	}
}
