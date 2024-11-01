package kr.or.ddit.designpattern.adapterpattern;


/**
 * int number =4;
 * new Integer(number).toHexString()
 */
public class Adapter implements Target{

    private Adaptee adaptee; //hss A관계(aggregation관계)

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}
