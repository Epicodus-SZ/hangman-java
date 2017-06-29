import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Hangman {
  private String mSecretWord;
  private String[] mExpectedWords = {"apple", "phone", "these", "watermelon", "jackets"};
  private List<String> guessedLetters = new ArrayList<String>();
  private int WrongGuesses;
  private boolean alive;
  private boolean winner;

  public Hangman() {
    //initializa a new game
    setSecretWord();
    WrongGuesses = 0;
    alive = true;
    winner = false;
  }

  public void putGuessedLetter(String putLetter) {
    guessedLetters.add(putLetter);
  }

  public String getSecretWord(){
    return mSecretWord;
  }

  //test method
  public void testSecretWord(String setString){
    mSecretWord = setString;
  }

  //test method
  public List<String> getGuessedLetters(){
    return guessedLetters;
  }

  public String setSecretWord(){
    Random randomNumber = new Random();
    int numberRolled = randomNumber.nextInt(5);
    mSecretWord = mExpectedWords[numberRolled];
    return mSecretWord;
  }

  //getter to see if we're still alive
  public boolean stillAlive(){
    return alive;
  }

  //getter to see if we have a winner
  public boolean weHaveAWinner(){
    return winner;
  }

  public boolean letterIsInWord(String guessedLetter){
    //for each letter in secretword loop
    int pos = mSecretWord.indexOf(guessedLetter);
      if (pos == -1) {
          // letter not found
          return false;
      }
      else {
          // letter exists at zero-based position pos
          // CAUTION: it might also exist in later positions!
          return true;
      }
    //return true i
  }

  public String drawUnderscores(String word){
    char[] lettersInWord = word.toCharArray();
    String returnString = "";

    for (char letter : lettersInWord) {
      //see if letter is in guessedLetters
      if(guessedLetters.contains(String.valueOf(letter))){
        returnString += letter + " ";
      }
      else {
        returnString += "_ ";
      }
    }
    return returnString.trim();
  }

  public String play(String guessedLetter){
    putGuessedLetter(guessedLetter); //put guessedLetter in guessed array (method)
    String attempt = drawUnderscores(mSecretWord); //draw what's to be displayed

    if(letterIsInWord(guessedLetter)){
      if(!attempt.contains("_")) {
        winner = true;
      }//test to see if Drawn == Secretword we have a winner
    } else {
      WrongGuesses++;
      if (WrongGuesses==7) {alive=false;}
      //if the counter is 7 your dead
    }

    return attempt;
  }
}
