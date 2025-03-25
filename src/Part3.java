// Part3.java
public class Part3 {

    public boolean twoOccurrences(String stringa, String stringb) {
        int firstIndex = stringb.indexOf(stringa);
        if (firstIndex == -1) {
            return false;
        }
        int secondIndex = stringb.indexOf(stringa, firstIndex + stringa.length());
        return secondIndex != -1;
    }

    public void testing() {
        String[][] testCasesTwoOccurrences = {
                {"by", "A story by Abby Long"},
                {"a", "banana"},
                {"atg", "ctgtatgta"},
                {"is", "This is a test"},
                {"apple", "pineapple apple pie"},
                {"hello", "world"}
        };

        for (String[] testCase : testCasesTwoOccurrences) {
            String stringa = testCase[0];
            String stringb = testCase[1];
            boolean result = twoOccurrences(stringa, stringb);
            System.out.println("twoOccurrences(\"" + stringa + "\", \"" + stringb + "\") returns " + result);
        }

        String[][] testCasesLastPart = {
                {"an", "banana"},
                {"zoo", "forest"},
                {"is", "This is a test"},
                {"apple", "pineapple apple pie"},
                {"hello", "hello world"}
        };

        for (String[] testCase : testCasesLastPart) {
            String stringa = testCase[0];
            String stringb = testCase[1];
            String result = lastPart(stringa, stringb);
            System.out.println("The part of the string after " + stringa + " in " + stringb + " is " + result);
        }
    }

    public String lastPart(String stringa, String stringb) {
        int firstIndex = stringb.indexOf(stringa);
        if (firstIndex == -1) {
            return stringb;
        }
        return stringb.substring(firstIndex + stringa.length());
    }

}