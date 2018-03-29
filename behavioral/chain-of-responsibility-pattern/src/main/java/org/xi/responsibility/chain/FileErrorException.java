package org.xi.responsibility.chain;

public class FileErrorException extends AbstractException {

    public FileErrorException(int level) {
        super(level);
    }

    @Override
    protected void print(String message) {
        System.out.println(message + " File Error");
    }
}
