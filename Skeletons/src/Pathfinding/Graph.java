package Pathfinding;

import java.awt.Point;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import rp.robotics.mapping.GridMap;

public class Graph {
	// private Set<Node> nodes = new HashSet<Node>();
	private Node[][] grid;
	// Unused nodes
	private ConcurrentMap<Point, Node> nodes = new ConcurrentHashMap<Point, Node>();
	private GridMap gridMap;

	public Graph(GridMap gridMap) {
		this.gridMap = gridMap;
		grid = new Node[gridMap.getXSize()][gridMap.getYSize()];
		gridMapToGraph();
	}

	private void gridMapToGraph() {
		for (int x = 0; x < gridMap.getXSize(); x++) {
			for (int y = 0; y < gridMap.getYSize(); y++) {
				Node node;
				if (!gridMap.isObstructed(x, y)) {
					//nodes.put(new Point(x, y), node = new Node(x, y));
					node = new Node(x,y);
				} else {
					//nodes.put(new Point(x, y), node = new Node(true));
					node = new Node(x, y, true);
				}
				grid[x][y] = node;
			}
		}

		// Add connections
		for (int x = 0; x < gridMap.getXSize(); x++) {
			for (int y = 0; y < gridMap.getYSize(); y++) {

				if (gridMap.isValidGridPosition(x, y)) {
					connectToNeighbour(gridMap, x, y, 1, 0);
					connectToNeighbour(gridMap, x, y, 0, 1);
					connectToNeighbour(gridMap, x, y, -1, 0);
					connectToNeighbour(gridMap, x, y, 0, -1);
				}
			}
		}
	}

	private void connectToNeighbour(GridMap gridMap, int _x, int _y, int _dx, int _dy) {

		if (gridMap.isValidTransition(_x, _y, _x + _dx, _y + _dy)) {

			grid[_x][_y].addAdjacentNode(grid[_x + _dx][_y + _dy]);

		}

	}

	/*
	 * public PriorityQueue<Point> aStar(Point start, Point destination){ int dx;
	 * int dy; Set<NodeData> nodeTable = new Set<NodeData>();
	 * if(gridMap.isValidGridPosition((dx = destination.x), (dy = destination.y))) {
	 * Queue<Point> waypoints = new PriorityQueue<Point>(); int x = start.x; int y =
	 * start.y;
	 * 
	 * Node currentNode = grid[x][y]; while() {
	 * 
	 * }
	 * 
	 * return waypoints; }else { throw new
	 * RuntimeException("Invalid destination set"); } }
	 */

	public void drawGrid() {
		for (int x = 0; x < gridMap.getXSize(); x++) {
			System.out.println();
			for (int y = 0; y < gridMap.getYSize(); y++) {
				if (grid[x][y].isObstructed()) {
					System.out.print("#");
				} else {
					System.out.print("o");
				}
			}
		}
	}

}
