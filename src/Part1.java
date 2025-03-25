public class Part1 {

    public String findSimpleGene(String dna) {
        // Find the start codon "ATG"
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) {
            return ""; // No ATG found
        }

        // Find the stop codon "TAA" after the start codon
        int stopIndex = dna.indexOf("TAA", startIndex + 3);
        if (stopIndex == -1) {
            return ""; // No TAA found after ATG
        }

        // Check if the length of the substring is a multiple of 3
        if ((stopIndex - startIndex) % 3 == 0) {
            return dna.substring(startIndex, stopIndex + 3); // Include TAA
        } else {
            return ""; // Not a multiple of 3
        }
    }

    public void testSimpleGene() {
        String[] dnaStrings = {
                "AAATGCCCTAACTAGATTAAGAAACC",   // Valid gene
                "ATCCTATGCTTCGGCTGCTCTAATATGGT", // No TAA *after* ATG
                "ATCCTTCGGCTGCTCTTTGGT",       // No ATG
                "ATCCTATGCTTCGGCTGCTCTATGGT",   // No ATG or TAA
                "ATGCGTCTATGACTAACGG"          // Not a multiple of 3
        };

        for (String dna : dnaStrings) {
            System.out.println("DNA String: " + dna);
            String gene = findSimpleGene(dna);
            System.out.println("Gene: " + gene);
            System.out.println(); // Print an empty line for separation
        }
    }
}