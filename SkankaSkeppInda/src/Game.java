
public class Game {
	private static boolean endGame;
	private static int[] hits;
	private static int[][] bombs;
	private static int[][] boats;
	//private static int[][] bombs;
	private static Player players;
	private static String[] names;
	//private Board boards;
	//private Boat boats;
	private GUI gui;
	
	public static void main(String[] args) {
		//lägg till allt som skall läggas till
		
		//initieringsmetoder?
		
		//metod Skapa spelare
		
		//metod lägg ut båtar
		
		//GUI gui;
		
		gui = new GUI();
		
		
		
		boats = GUI.drawPutBoats();
		
		
		
		while ( endGame == false ){
			//loopa igenom själva spelen
			
			
			//några ifsatser antar jag
			
			
			// Dra ner info från 
			//Anropa GUI med infon vi fick där upp
			gui.draw(bombs);
			
			
			
			
			endGame = checkEndGame();
		}
	}
	
	private static boolean checkEndGame(){
		//todo
		return false;
	}
	
	private static void putBoats(){
		
		//return false;
	}
	
}
