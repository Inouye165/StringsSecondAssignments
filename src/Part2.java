public class Part2 {

    public String findSimpleGene(String dna, String startCodon, String stopCodon) {
        // Adjust codon case based on the DNA string's case.
        // We assume the DNA string is either all uppercase or all lowercase.
        boolean isUpperCase = Character.isUpperCase(dna.charAt(0));
        if (isUpperCase) {
            startCodon = startCodon.toUpperCase();
            stopCodon = stopCodon.toUpperCase();
        } else {
            startCodon = startCodon.toLowerCase();
            stopCodon = stopCodon.toLowerCase();
        }

        // Find the start codon using the parameter.
        int startIndex = dna.indexOf(startCodon);
        if (startIndex == -1) {
            return ""; // No startCodon found
        }

        // Find the stop codon using the parameter, starting after the start codon.
        int stopIndex = dna.indexOf(stopCodon, startIndex + startCodon.length());
        if (stopIndex == -1) {
            return ""; // No stopCodon found after startCodon
        }

        // Check if the length of the substring is a multiple of 3.
        if ((stopIndex - startIndex) % 3 == 0) {
            // Return the gene substring, including the stop codon.
            return dna.substring(startIndex, stopIndex + stopCodon.length());
        } else {
            return ""; // Not a multiple of 3.
        }
    }

    public void testSimpleGene() {
        // Define the codons (they will be adjusted in findSimpleGene as needed)
        String startCodon = "ATG";
        String stopCodon = "TAA";

        String[] dnaStrings = {
            "AAATGCCCTAACTAGATTAAGAAACC",   // Valid gene (uppercase)
            "atgcctaaactagattaagaaccc",     // Valid gene (lowercase)
            "ATCCTATGCTTCGGCTGCTCTAATATGGT", // No valid gene
            "ATCCTTCGGCTGCTCTTTGGT",         // No startCodon
            "ATGCGTCTATGACTAACGG"            // Not a multiple of 3
        };

        for (String dna : dnaStrings) {
            System.out.println("DNA String: " + dna);
            String gene = findSimpleGene(dna, startCodon, stopCodon);
            System.out.println("Gene: " + gene);
            System.out.println(); // Print an empty line for separation
        }
    }

    public static void main(String[] args) {
        Part2 part2 = new Part2();
        part2.testSimpleGene();
    }
}
