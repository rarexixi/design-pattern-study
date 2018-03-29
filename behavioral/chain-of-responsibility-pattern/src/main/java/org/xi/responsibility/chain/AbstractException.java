package org.xi.responsibility.chain;

public abstract class AbstractException {

    protected int level;
    protected AbstractException successor;

    protected AbstractException(int level) {
        this.level = level;
    }

    public void setSuccessor(AbstractException successor) {
        this.successor = successor;
    }

    public void catchException(int level, String message) {

        if (this.level <= level) {
            print(message);
            return;
        }

        if (successor != null) {
            successor.catchException(level, message);
        }
    }

    abstract protected void print(String message);
}
