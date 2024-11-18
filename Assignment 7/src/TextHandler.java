public class TextHandler {
    private final NewString text;

    public TextHandler(String text) {
        this.text = new NewString(text);
    }

    public String getText() {
        return this.text.getBase();
    }
    public String getUppercase(){
        return this.text.getBase().toUpperCase();
    }

    public int countWords(){
        String string = text.getBase();
        String[] words = getWords();
        return words.length;
    }

    public String[] getWords(){
        return text.getBase().split(" ",-2);
    }

    public float calculateAverageLength(){
        String[] words = getWords();
        int[] letterCount = new int[words.length];
        float sum = 0;
        for(int i = 0; i < words.length; i++){
            //System.out.println(words[i]);
            words[i] = words[i].toLowerCase();
            for(int j = 0; j < words[i].length(); j++){
                if(words[i].charAt(j) > 96 && words[i].charAt(j) < 123 || words[i].charAt(j) == 229 || words[i].charAt(j) == 230 || words[i].charAt(j) == 248) {
                    letterCount[i]++;
                }
                else{
                    continue;
                }
            }
        }
        for (int i = 0; i < letterCount.length; i++) {
            //System.out.println(words[i]);
            //System.out.println("Letter Count for word " + i + " = " + letterCount[i]);
            sum += letterCount[i];
        }
        return sum / words.length;
    }
    public float wordsPerPeriod(){
        String[] periods = text.getBase().split("[.!;?]");
        int[] wordsPerPeriod = new int[periods.length];
        float sum = 0;
        for (int i = 0; i < periods.length; i++) {
            String[] words = periods[i].split(" ");
            for (int j = 0; j < words.length; j++) {
                wordsPerPeriod[i] ++;
            }
        }
        System.out.println("Number of periods: " + periods.length);
        for (int i = 0; i < wordsPerPeriod.length; i++) {
            //System.out.println("Period number " + i + " = " + periods[i]);
            //System.out.println("Number of words in current period = " + wordsPerPeriod[i]);
            sum += wordsPerPeriod[i];
            //System.out.println("Current Sum: " + sum);
        }
        return sum/periods.length;
    }
    public String replaceWord(String find, String replace){
        return text.getBase().replaceAll(find,replace);
    }

}
