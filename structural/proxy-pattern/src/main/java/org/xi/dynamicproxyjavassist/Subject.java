package org.xi.dynamicproxyjavassist;

public interface Subject {

    @Select("hello")
    String hello(String str);
}