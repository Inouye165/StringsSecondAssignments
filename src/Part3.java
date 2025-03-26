import util.GeneUtils;

public class Part3 {

    /**
     * Counts the number of genes in a given DNA string.
     *
     * @param dna The DNA string.
     * @return The number of genes found.
     */
    public int countGenes(String dna) {
        int count = 0;
        int startIndex = 0;

        while (true) {
            int atgIndex = dna.indexOf("ATG", startIndex);
            if (atgIndex == -1) break;

            // Use GeneUtils to find the valid stop codon indices
            int taaIndex = GeneUtils.findStopCodon(dna, atgIndex, "TAA");
            int tagIndex = GeneUtils.findStopCodon(dna, atgIndex, "TAG");
            int tgaIndex = GeneUtils.findStopCodon(dna, atgIndex, "TGA");

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

            if (minIndex < dna.length()) {
                count++;
                startIndex = minIndex + 3;
            } else {
                startIndex = atgIndex + 3;
            }
        }
        return count;
    }

    public void testCountGenes() {
        System.out.println("=== Testing countGenes ===");
        String dna1 = "ATGTAAGATGCCCTAGT";
        System.out.println("DNA: " + dna1 + " -> Genes: " + countGenes(dna1));
        // Additional test cases...
    }

    public static void main(String[] args) {
        Part3 part3 = new Part3();
        part3.testCountGenes();
    }
}
