public class ST026 {

}

class ST026_Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return isContain(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean isContain(TreeNode A, TreeNode B) { // Does the tree rooted on A contain the tree rooted on B?
        if (B == null) return true; // the leaf of the substructure tree has been matched
        if (A == null || A.val != B.val) return false;
        return isContain(A.left, B.left) && isContain(A.right, B.right);
    }
}