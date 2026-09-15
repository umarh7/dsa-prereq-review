public class TestFraction {
    public static void main(String[] args) {
        //runing cmd: java TestFraction.java
        Fraction a = new Fraction(3, 6);
        Fraction b = new Fraction(3, 6);
        Fraction c = a.addFraction(b);
        // ... all five test blocks here
        System.out.println(a.toString());
        System.out.println(c.toString());
    }

}
