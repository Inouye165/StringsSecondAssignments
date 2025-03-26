public class Part3 {

    /**
     * This method finds the index of the stop codon (e.g., "TAA", "TAG", or "TGA")
     * in the DNA string that is a multiple of 3 away from the startIndex.
     * If no such stop codon is found, it returns -1.
     *
     * @param dna The DNA string.
     * @param startIndex The index where the gene starts (the index of "ATG").
     * @param stopCodon The stop codon to search for.
     * @return The index of the valid stop codon, or -1 if none is found.
     */
    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        // Start searching from the position just after the "ATG" codon.
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1) {
            // Check if the distance from startIndex to currIndex is a multiple of 3.
            if ((currIndex - startIndex) % 3 == 0) {
                return currIndex;
            }
            // Otherwise, look for the next occurrence of the stopCodon.
            currIndex = dna.indexOf(stopCodon, currIndex + 1);
        }
        // No valid stop codon found.
        return -1;
    }

    /**
     * This method counts the number of genes in the given DNA string.
     * A gene is defined as a substring that starts with "ATG" and ends with
     * one of the stop codons ("TAA", "TAG", or "TGA") such that the length
     * from "ATG" to the stop codon is a multiple of 3.
     *
     * @param dna The DNA string.
     * @return The number of genes found.
     */
    public int countGenes(String dna) {
        int count = 0;       // Counter for the number of genes
        int startIndex = 0;  // Current index in the DNA string

        // Loop until no more "ATG" is found.
        while (true) {
            // Find the next "ATG" start codon.
            int atgIndex = dna.indexOf("ATG", startIndex);
            if (atgIndex == -1) { // No more start codon; break out of loop.
                break;
            }

            // Find the index of the closest valid stop codon.
            int taaIndex = findStopCodon(dna, atgIndex, "TAA");
            int tagIndex = findStopCodon(dna, atgIndex, "TAG");
            int tgaIndex = findStopCodon(dna, atgIndex, "TGA");

            // Determine the smallest valid index among the three stop codon indexes.
            int minIndex = dna.length();
            if (taaIndex != -1 && taaIndex < minIndex) {
                minIndex = taaIndex;
            }
            if (tagIndex != -1 && tagIndex < minIndex) {
                minIndex = tagIndex;
            }
            if (tgaIndex != -1 && tgaIndex < minIndex) {
                minIndex = tgaIndex;
            }
            
            // If a valid stop codon was found (minIndex changed from dna.length())
            if (minIndex < dna.length()) {
                count++;  // We found a gene, so increment the counter.
                // Move startIndex to just after this gene to search for the next one.
                startIndex = minIndex + 3;
            } else {
                // No valid stop codon was found for this "ATG", so move past it.
                startIndex = atgIndex + 3;
            }
        }
        return count;
    }

    /**
     * This method tests the countGenes method by calling it with several
     * example DNA strings and printing the results.
     */
    public void testCountGenes() {
        System.out.println("=== Testing countGenes ===");

        // Test case 1: Two genes in the DNA string.
        String dna1 = "ATGTAAGATGCCCTAGT";
        int count1 = countGenes(dna1);
        System.out.println("DNA: " + dna1);
        System.out.println("Number of genes: " + count1 + " (Expected: 2)");
        System.out.println();

        // Test case 2: One gene.
        String dna2 = "ATGCCCGGGAAATAA";
        int count2 = countGenes(dna2);
        System.out.println("DNA: " + dna2);
        System.out.println("Number of genes: " + count2 + " (Expected: 1)");
        System.out.println();

        // Test case 3: No gene present.
        String dna3 = "GATTACA";
        int count3 = countGenes(dna3);
        System.out.println("DNA: " + dna3);
        System.out.println("Number of genes: " + count3 + " (Expected: 0)");
        System.out.println();

        // Test case 4: Multiple genes in one string.
        String dna4 = "ATGAAATGAAAATGTAGATGTAA";
        int count4 = countGenes(dna4);
        System.out.println("DNA: " + dna4);
        System.out.println("Number of genes: " + count4 + " (Expected: depends on gene positions)");
        System.out.println();

        // Test case 5: Two genes with different stop codons.
        String dna5 = "ATGCGCTAAATGCGCTAG";
        int count5 = countGenes(dna5);
        System.out.println("DNA: " + dna5);
        System.out.println("Number of genes: " + count5 + " (Expected: 2)");
        System.out.println();
    }

    /**
     * The main method to run the test for countGenes.
     */
    public static void main(String[] args) {
        Part3 part3 = new Part3();
        part3.testCountGenes();
    }
}
