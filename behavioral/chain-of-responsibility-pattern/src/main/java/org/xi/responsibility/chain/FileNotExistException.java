package org.xi.responsibility.chain;

public class FileNotExistException extends AbstractException {

    public FileNotExistException(int level) {
        super(level);
    }

    @Override
    protected void print(String message) {
        System.out.println(message + " File Not Exist");
    }
}
