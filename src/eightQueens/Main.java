package eightQueens;

import java.awt.Point;
import java.util.ArrayList;

public class Main {

	static ArrayList<Point> queenSpots = new ArrayList<>(); 

	public static void main(String[] args) {
		ArrayList<Point> chessboard = new ArrayList<>();
		// initialize array list
		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 8; j++) {
				chessboard.add(new Point(i, j));
			}
		}
		placeQueens(chessboard, 8);
	}

	//Recursive method to place the queens
	public static boolean placeQueens(ArrayList<Point> chessboard, int queens) {
		if( queens == 0) {
			//print all solutions
			for (Point p : queenSpots) {
				System.out.print("( " + p.x + "," + p.y + " );");
			}
			System.out.println();
			return true;
		}
		for (int i = 1; i <= 8; i++) {
			//checking object availability 
			if(chessboard.contains(new Point(queens, i))) {
				//make new board and add queens to it
				ArrayList<Point> newBoard = addQueen(chessboard, new Point(queens,i));
				placeQueens(newBoard, queens-1); //place queen on the new board and pass it
				queenSpots.remove(new Point(queens,i)); //remove the placed one
				
			}
		}
		return false;
		
	}

	public static ArrayList<Point> addQueen(ArrayList<Point> chessboard, Point p) {
		ArrayList<Point> newBoard = new ArrayList<>();
		queenSpots.add(p);
		for (Point q : chessboard) {
			if (q.x != p.x && q.y != p.y && (q.x - p.y) != (p.x - q.y)
					&& (q.x - q.y) != (p.x - p.y)) {
				newBoard.add(q);
			} 
		}
		return newBoard;
	}

}
