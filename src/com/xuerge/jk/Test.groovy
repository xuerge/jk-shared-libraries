package com.xuerge.jk

class Test {
    public static void main(String[] args) {
        def a = ['mvn clean','mvn install']
        print(a.join("&&"));
    }
}
