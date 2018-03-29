package org.xi.responsibility;

import org.xi.responsibility.chain.FileErrorException;
import org.xi.responsibility.chain.FileNotExistException;
import org.xi.responsibility.chain.FileReadErrorException;
import org.xi.responsibility.chain.Level;

public class Main {

    public static void main(String[] args) {
        FileErrorException fileErrorException = new FileErrorException(Level.FileError);
        FileReadErrorException fileReadErrorException = new FileReadErrorException(Level.FileReadError);
        FileNotExistException fileNotExistException = new FileNotExistException(Level.FileNotExist);

        fileErrorException.setSuccessor(fileReadErrorException);
        fileReadErrorException.setSuccessor(fileNotExistException);

        fileErrorException.catchException(Level.FileNotExist, "文件不存在");
        fileErrorException.catchException(Level.FileReadError, "文件读取错误");
        fileErrorException.catchException(Level.FileError, "文件错误");
    }
}
