package kr.or.ddit.designpattern.adapterpattern;

public class OtherConcrete implements Target {

    @Override
    public void request() {
        System.out.printf("%s 에서 요청 처리했음", getClass().getName());
    }
}
