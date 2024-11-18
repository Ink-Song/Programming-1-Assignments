public class TextAnalyser {
    //static String TEXT = " “I wish it need not have happened in my time,” said Frodo. “So do I,” said Gandalf, “and so do all who live to see such times. But that is not for them to decide. All we have to decide is what to do with the time that is given us.” ";
    //static String alphabet = "abcdefghijklmnopqrstuvwxyzøæå ";
    private final int[] characterInfo;


    public TextAnalyser(String text) {
        int[] antallCharacter = new int[30];
        String txt = text.toLowerCase();//converts text to lowercase

        for (int i = 0; i < txt.length(); i++) {
            int uniChar = txt.codePointAt(i); // converts lowercase text to an int corresponding to a unicode character
            if(uniChar > 96 && uniChar < 122) {
                antallCharacter[uniChar-97]++;// If the unicode int is within a certain range, get its position between 0-28 and add increase that index.
            }
            else {
                antallCharacter[29]++; // If the character isn't a letter of the alphabet, index "other"
            }

        }
        this.characterInfo = antallCharacter; // Set the Object variable and end construction.
//        for (int i = 0; i < antallCharacter.length; i++) {
//            char cn = alphabet.charAt(i);
//            if(i < 29){
//                System.out.println("Character: " + String.valueOf(cn) + " represented " + antallCharacter[i] + " times.");
//            }
//            else{
//                System.out.println("Character: Other" + " represented " + antallCharacter[i] + " times.");
//            }
//        }
    }
    public int getAntallBokstaver(){ //Gets the total number of letters in the text, remove anything that isn't a letter.
        //return the number of letters (not including spaces and other characters.
//        for (int i = 0; i < characterInfo.length-1; i++) {
//            result += characterInfo[i];
//        }
        return this.getNumberOfCharacters() - characterInfo[29];
    }
    public int getAntallForskjelligeBokstaver() { // Count the number of different letters in the text.
        int result = 0;
        for (int i = 0; i < characterInfo.length - 1; i++) {
            if (characterInfo[i] > 0) {
                result++;
            }
        }
        return result;
    }
    public int getNumberOfCharacters() { // Just gets the number of characters in the text total.
        int result = 0;
        for (int j : characterInfo) {
            result += j;
        }
        return result;
    }
    public float calculatePercentNonChar(){ // Calculates the percentage of the characters in the text that aren't letters.
        float character = (float) this.getNumberOfCharacters(); //cast int to float
        float nonCharacter = (float) this.characterInfo[29]; //cast int to float
        return (nonCharacter / character)*100; //divide and multiply to get percentage
    }
    public int getTallyCharacter(String character){ //count the total iterations of a specific character
        if(character.length() > 1){
            throw new IllegalArgumentException("Input has more than one character. Single Character Expected");
        }
        character = character.toLowerCase();
        int uniChar = character.codePointAt(0);
        return characterInfo[uniChar-97];
    }

    public char getMostFrequentCharacter(){ // Get the most frequent character.
        int highest = 0;
        for (int i = 0; i < characterInfo.length - 1; i++) {
            if(characterInfo[i] > characterInfo[highest]){
                highest = i;
            }
        }
        return (char) (highest + 97); // Cast int to character!
    }



//    public static void main(String[] args) {
//        int[] antallCharacter = new int[30];
//        String txt = TEXT.toLowerCase();
//
////        for (int i = 0; i < alphabet.length(); i++) {
////            int uniChar = alphabet.codePointAt(i);
////            System.out.println(uniChar);
////        }
//
//        for (int i = 0; i < txt.length(); i++) {
//            int uniChar = txt.codePointAt(i);
//            if(uniChar > 96 && uniChar < 122) {
//                antallCharacter[uniChar-97]++;
//            }
//            else {
//                antallCharacter[29]++;
//            }
//
//        }
//        for (int i = 0; i < antallCharacter.length; i++) {
//            char cn = alphabet.charAt(i);
//            if(i < 29){
//                System.out.println("Character: " + String.valueOf(cn) + " represented " + antallCharacter[i] + " times.");
//            }
//            else{
//                System.out.println("Character: Other" + " represented " + antallCharacter[i] + " times.");
//            }
//        }
//        /*
//        for (int i = 0; i < txt.length(); i++) {
//            char ch = txt.charAt(i);
//            System.out.println("Character: " + String.valueOf(ch));
//            for (int j = 0; j < alphabet.length(); j++) {
//                if (ch == alphabet.charAt(j)) {
//                    antallCharacter[j]++;
//                    break;
//                }
//                else if(j == alphabet.length() - 1){
//                    antallCharacter[29]++;
//                    System.out.println("other detected.");
//                }
//            }
//        }
//        for (int i = 0; i < antallCharacter.length; i++) {
//            char cn = alphabet.charAt(i);
//            System.out.println("Character: " +  String.valueOf(cn) + " represented " + antallCharacter[i] + " times.");
//        } */
//    }

}
