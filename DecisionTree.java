class DecisionTree {
    private DecisionTree left;
    private DecisionTree right;
    private String decision;

    /**
     * creates a new decisionTree
     * @param decision of this node
     * @param left is hit
     * @param right is stand
     */
    public DecisionTree(String decision, DecisionTree left, DecisionTree right) {
        this.decision = decision;
        this.left = left;
        this.right = right;
    }

    /**
     * creates decisionTree without left or right nodes
     * @param decision of this node
     */
    public DecisionTree(String decision) {
        this.decision = decision;
    }

    /**
     * gets the left node
     * @return left
     */
    public DecisionTree getLeft() {
        return left;
    }

    /**
     * gets right node
     * @return right
     */
    public DecisionTree getRight() {
        return right;
    }

    /**
     * sets the decision of this node
     * @param decision of this node
     */
    public void setVal(String decision) {
        this.decision = decision;
    }

    /**
     * sets the left node
     * @param d left node
     */
    public void setLeft(DecisionTree d) {
        this.left = d;
    }

    /**
     * sets the right node
     * @param d right node
     */
    public void setRight(DecisionTree d) {
        this.right = d;
    }

    /**
     * returns the decision
     * @return decision of this node
     */
    public String decision() {
        return decision;
    }
}