public class Part2 {

    public int howMany(String stringa, String stringb) {
        int count = 0;
        int index = 0;

        while (true) {
            index = stringb.indexOf(stringa, index);

            if (index == -1) {
                break;
            }

            count++;
            index += stringa.length(); // move past the found string to avoid overlap
        }

        return count;
    }

    public void testHowMany() {
        runTest("GAA", "ATGAACGAATTGAATC", 3, 1);
        runTest("AA", "ATAAAA", 2, 2);
        runTest("A", "ABABABA", 4, 3);
        runTest("XYZ", "XYZXYZXYZ", 3, 4);
        runTest("XY", "XYXYXY", 3, 5);
        runTest("Z", "ZZZZ", 4, 6);
        runTest("ABC", "DEF", 0, 7);
        runTest("", "ABCDE", 0, 8); // Optional: handles empty stringa
    }

    private void runTest(String stringa, String stringb, int expected, int testNum) {
        int result = howMany(stringa, stringb);
        System.out.println("Test " + testNum + ":");
        System.out.println("  stringa: \"" + stringa + "\"");
        System.out.println("  stringb: \"" + stringb + "\"");
        System.out.println("  Expected: " + expected);
        System.out.println("  Actual:   " + result);
        System.out.println("  Result:   " + (result == expected ? "✅ PASS" : "❌ FAIL"));
        System.out.println();
    }
}
