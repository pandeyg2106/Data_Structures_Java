package Algorithms.Trees;

public class YoungestCommonAncestor {

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }

    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        // Write your code here.
        int deapthOne = getDeapth(descendantOne, topAncestor);
        int deapthTwo = getDeapth(descendantTwo, topAncestor);
        int diff = Math.abs((deapthOne - deapthTwo));
        if (deapthOne > deapthTwo)
            return backTrackAncestralTree(descendantOne, descendantTwo, diff);
        else
            return backTrackAncestralTree(descendantTwo, descendantOne, diff);
    }

        private static int getDeapth(AncestralTree descendant, AncestralTree topAncestor) {
            int deapth = 0;
            while (descendant != topAncestor) {
                deapth++;
                descendant = descendant.ancestor;
            }
            return deapth;
        }

        private static AncestralTree backTrackAncestralTree(AncestralTree lowerDescendant, AncestralTree higherDescendant, int diff) {
            while(diff > 0){
                lowerDescendant = lowerDescendant.ancestor;
                diff--;
            }
            while(lowerDescendant != higherDescendant){
                lowerDescendant = lowerDescendant.ancestor;
                higherDescendant = higherDescendant.ancestor;
            }
            return lowerDescendant;
        }
}
