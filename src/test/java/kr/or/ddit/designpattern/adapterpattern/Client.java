package kr.or.ddit.designpattern.adapterpattern;

import org.junit.jupiter.api.Test;

public class Client {
    private Target target;

    @Test
    void test() {
//        target = new OtherConcrete();

        target = new Adapter(new Adaptee());
        target.request();
    }
}
