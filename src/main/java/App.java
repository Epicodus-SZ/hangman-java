import java.io.Console;

public class App {
	public static void main(String[] args) {
		Console myConsole = System.console();
		Hangman hangmanGame = new Hangman();

		//game while loop
		while(hangmanGame.stillAlive() && !(hangmanGame.weHaveAWinner())){

			String letterChoice = myConsole.readLine();
			System.out.println(hangmanGame.play(letterChoice)); //display current board
		}

		if(hangmanGame.weHaveAWinner()){
			System.out.println("We have a winner!");
		}
		else {
			System.out.println("You're dead!");
		}
	}
}
