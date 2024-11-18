import org.w3c.dom.Text;

public class Main {
    public static void main(String[] args) {

        String text1 = "Central Intelligence Agency!";
        String text2 = """
        Ikke alt som er gull vil glitre, Ikke alle som vandrer har gått vill, Gammel styrke kan bil seig og ei forvitre, dypest rot når frosten ikke til, Av asken skal ild bli atter vekket, Fra skygger skal lys igjen fly, Når nysmid blir klingen som var knekket, Skal en troneløs bli konge på ny.""";

        String text3 = """
                “I wish it need not have happened in my time," said Frodo.
                "So do I," said Gandalf, "and so do all who live to see such times. But that is not for them to decide. All we have to decide is what to do with the time that is given us.""";
        String text4 = "Hello. World. Five";
        TextHandler textHandler = new TextHandler(text2);
        TextHandler thirdText = new TextHandler(text3);

        TextHandler fourthText = new TextHandler(text4);


        NewString MY_STRING = new NewString(text1);
        System.out.println(MY_STRING.removeLetter('a'));
        System.out.println(MY_STRING.abbreviate());

        System.out.println("First Text: ");
        System.out.println(textHandler.getUppercase());
        System.out.println("Average word length: "+textHandler.calculateAverageLength());
        System.out.println("Number of words: " + textHandler.countWords());

        System.out.println("Second Text: ");
        System.out.println(thirdText.getText());
        System.out.println("Words Per Period: " + thirdText.wordsPerPeriod());
        System.out.println(thirdText.replaceWord("Gandalf", "Dumbledore"));

        System.out.println(fourthText.calculateAverageLength());
    }
}