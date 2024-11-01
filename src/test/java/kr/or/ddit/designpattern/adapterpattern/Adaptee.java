package kr.or.ddit.designpattern.adapterpattern;

public class Adaptee {
    public void specificRequest() {
        System.out.printf("%s에서 아주 특별한 요청을 처리했음.\n", getClass().getName());
    }
}
