package org.xi.responsibility.chain;

public class FileReadErrorException extends AbstractException {

    public FileReadErrorException(int level) {
        super(level);
    }

    @Override
    protected void print(String message) {
        System.out.println(message + " File Read Error");
    }
}
