import java.io.Console;

public class App {
	public static void main(String[] args) {
		System.out.println("A game of Hangman, life and death...we're not playing around");
		Console myConsole = System.console();
		Hangman hangmanGame = new Hangman();

		//game while loop
		while(hangmanGame.stillAlive() && !(hangmanGame.weHaveAWinner())){
			System.out.println(hangmanGame.drawGallow());
			System.out.println(hangmanGame.drawUnderscores());
			String letterChoice = myConsole.readLine();
			System.out.println(hangmanGame.play(letterChoice)); //display current board
		}

		if(hangmanGame.weHaveAWinner()){
			System.out.println(hangmanGame.drawGallow());
			System.out.println(hangmanGame.drawUnderscores());
			System.out.println("We have a winner!");
		}
		else {
			System.out.println(hangmanGame.drawGallow());
			System.out.println(hangmanGame.drawUnderscores());
			System.out.println("You're dead...FRED!");
		}
	}
}
