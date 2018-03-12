package Pathfinding;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Node {

	private /* final */ Point pos;
	
	private int g;
	private Double h = null;
	//private double f;

	private ArrayList<Node> adjacentNodes;
	private boolean obstructed = false;

	public Node(int x, int y) {
		this(new Point(x, y));
	}

	public Node(Point pos) {
		this();
		this.pos = pos;
	}

	public Node() {
		adjacentNodes = new ArrayList<Node>();
	}

	public Node(int x, int y, boolean obstructed) {
		this(x, y);
		this.obstructed = obstructed;
	}

	public Point getPos() {
		return pos;
	}

	public void addAdjacentNode(Node node) {
		if (!adjacentNodes.contains(node))
			adjacentNodes.add(node);
	}

	public ArrayList<Node> getAdjacentNodes() {
		return adjacentNodes;
	}

	public boolean isObstructed() {
		return obstructed;
	}

	//////////////////////////// - STUFF FOR A* - ////////////////////////////////////////
	
	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public double getH() {
		return h;
	}

	public void calculateH(Point start, Point end) {
		h = Math.sqrt(Math.pow(end.getX() - start.getY(), 2) + Math.pow(end.getY() - start.getY(), 2));
	}

	public double getF() {
		return g * h;
	}

}
