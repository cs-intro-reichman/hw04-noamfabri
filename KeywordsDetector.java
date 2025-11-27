public class KeywordsDetector {
    public static void main(String[] args) {
        String[] sentences = {
            "Our product will transform the market",
            "Programming is both painful and engaging",
            "This has nothing to do with machine learning",
            "We need to leverage our core competencies",
            "Let's talk about data and algorithms",
            "Chatbots are great but must be used carefully",
            "This blockchain-based solution will disrupt the industry",
            "The team showed great Synergy in the last project",
            "Use simple words without hype and fluff",
            "Our new technology presents a significant paradigm shift",
            "Effective presentations must be clear, concise, and humble"
        };
        // Some keywords that typically signal bullshit contents in business presentations 
        String[] keywords = {"synergy", "disrupt", "leverage", "Paradigm", "transform"};
        detectAndPrint(sentences, keywords);
    }

    // Iterates through all the sentences.
    // If a sentence contains one or more of the kewords, prints it.
    public static void detectAndPrint(String[] sentences, String[] keywords) {
        for (int i = 0 ; i < sentences.length ; i++){
        String currentSentence = sentences[i];
        String sentencesToLow = lowerCase(currentSentence);
            for (int j = 0 ; j < keywords.length ; j++){
                String keywordsToLow = lowerCase(keywords[j]);
                if (contains(sentencesToLow, keywordsToLow)) {
                    System.out.println(currentSentence);
                    break;
                }
            }
        }
    }
public static String lowerCase(String str) {
        String newStr = "";
        int L = str.length();
        for (int i = 0 ; i < L ; i++){
            if (str.charAt(i) <= 90 && str.charAt(i) >= 65){
            newStr = newStr + ((char) (str.charAt(i) + 32));
            } else {  
            newStr = newStr + (char) str.charAt(i);
            }
        }
        return newStr;
    }

    public static boolean contains(String str1, String str2) {
        if (str2.length() > str1.length()) return false;
        for (int i = 0 ; i <= str1.length() - str2.length() ; i++){
            boolean found = true;
            for (int j = 0 ; j < str2.length() ; j++){
                if (str1.charAt(i + j) != str2.charAt(j)) {
                    found = false;
                break;
                }
            }
            if (found) return true;
        } 
        return false;
    }
}