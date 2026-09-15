public class Fraction {
    private final int numerator;
    private final int denominator;

    public Fraction(int n, int d) {
        if (d == 0) throw new IllegalArgumentException("denominator cannot be zero");
        if (d < 0) { n = -n; d = -d; }
        int g = gcd(n, d);
        this.numerator = n / g;
        this.denominator = d / g;
    }
    //Static = Non-static methods belong to an object and can use 
    // its fields (this exists) — add needs this fraction's numerator, 
    // so it's non-static. Static methods belong to the class, 
    // no object involved, no this — gcd(12,18) is pure input→output 
    // math touching no fields, so it's static (and main is static 
    // because it runs before any object exists).
    public static int gcd(int n, int d){
        n = Math.abs(n);
        d = Math.abs(d);
        if(d==0) return n;
        return gcd(d,n%d);
    }

    //Arithmatics four public methods, each ~2 lines, each ends in return new Fraction(...)
    public Fraction addFraction(Fraction other){
        int upperNum = ((numerator)*(other.denominator))+((other.numerator)*(denominator));
        int newDenom = denominator*other.denominator;
        return new Fraction(upperNum,newDenom);
    }

    public Fraction subFraction(Fraction other){
        int upperNum = ((numerator)*(other.denominator))-((other.numerator)*(denominator));
        int newDenom = denominator*other.denominator;
        return new Fraction(upperNum, newDenom);
    }

    public Fraction mFraction(Fraction other){
        int n = numerator*other.numerator;
        int d = denominator*other.denominator;
        return new Fraction(n, d);
    }

    public Fraction dFraction(Fraction other){
        int n = numerator*other.denominator;
        int d = denominator*other.numerator;
        if (d == 0) throw new IllegalArgumentException("denominator cannot be zero");
        return new Fraction(n, d);
    }

    // OVERRIDES — three, each with @Override:
    @Override 
    public String toString(){
        return (denominator==1) ? ""+numerator : numerator+"/"+denominator+"";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                 // same reference? same object → equal
        if (!(o instanceof Fraction)) return false; // not a Fraction (or null) → not equal
        Fraction f = (Fraction) o;                  // safe downcast — instanceof just proved it
        return this.numerator == f.numerator
            && this.denominator == f.denominator;   // canonical form makes field-compare sufficient
    }

    @Override
    public int hashCode() {
        return 31 * numerator + denominator;
    }

}
