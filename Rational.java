//Chesley Tan
//pd9
//HW#28
//2013-11-19

public class Rational implements Comparable{
	private int _numerator, _denominator;
	public Rational(){
		_numerator = 0;
		_denominator = 1;
	}
	public Rational(int numerator, int denominator){
		if (denominator == 0){
			System.out.println("Invalid denominator. Defaulted to 0/1");
			_numerator = 0;
			_denominator = 1;
			return;
		}
		_numerator = numerator;
		_denominator = denominator;
	}
	public String toString(){
		return String.valueOf(_numerator + "/" + _denominator);
	}
	public double floatValue(){
		return (double) ((_numerator * 1.0) / (_denominator * 1.0)); 
	}
	public int getNumerator(){
		return _numerator;
	}
	public int getDenominator(){
		return _denominator;
	}
	public void multiply(Rational r){
		_denominator *= r.getDenominator();
		_numerator *= r.getNumerator();
	}
	public void divide(Rational r){
		_numerator *= r.getDenominator();
		_denominator *= r.getNumerator();
	}
	public void add(Rational r){
		_numerator = (_numerator * r.getDenominator()) + (_denominator * r.getNumerator());
		_denominator = (_denominator * r.getDenominator());
	}
	public void subtract(Rational r){
		_numerator = (_numerator * r.getDenominator()) - (_denominator * r.getNumerator());
		_denominator = (_denominator * r.getDenominator());
	}
	public static int getGCD(int numerator, int denominator){
		int divisor, dividend, remainder;
		divisor = Math.min(numerator,denominator);
		remainder = Math.max(numerator,denominator) % divisor;
		while (remainder != 0){
			dividend = divisor;
			divisor = remainder;
			remainder = dividend % divisor;
		}
		return divisor;
	}
	public int gcd(){
		return getGCD(_numerator,_denominator);
	}
	public void reduce(){
		int gcd = gcd();
		_numerator /= gcd;
		_denominator /= gcd;
	}
	public int compareTo(Object r){
		if (!(r instanceof Rational))
			return -2;
		int crossThis = _numerator * ((Rational) r).getDenominator(); //Use cross multiplcation to find greater
		int crossThat = _denominator * ((Rational) r).getNumerator();
		if (crossThis == crossThat)
			return 0;
		else if (crossThis > crossThat)
			return 1;
		else
			return -1;
				
	}
	public boolean equals(Rational r){
		return (_numerator * r.getDenominator() == _denominator * r.getNumerator());
	}
	public static void main(String[] args){
		Rational a = new Rational(3,4);
		Rational b = new Rational(4,3);
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("a * b = ?");
		a.multiply(b);
		System.out.println(a);
		
		System.out.println("======================================");
		
		a = new Rational(3,4);
		b = new Rational(4,3);	
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("a / b = ?");
		a.divide(b);
		System.out.println(a);
		
		System.out.println("======================================");
		
		a = new Rational(3,4);
		b = new Rational(4,3);	
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("a + b = ?");
		a.add(b);
		System.out.println(a);

		System.out.println("======================================");
		
		a = new Rational(3,4);
		b = new Rational(4,3);	
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("a - b = ?");
		a.subtract(b);
		System.out.println(a);
		
		System.out.println("======================================");
		
		a = new Rational(3,4);
		System.out.println("a: " + a);
		System.out.println("GCD of numerator and denominator?");
		System.out.println(a.gcd());
		
		System.out.println("======================================");
		
		a = new Rational(10,4);
		System.out.println("a: " + a);
		System.out.println("Reduce!");
		a.reduce();
		System.out.println(a);
		
		System.out.println("======================================");
		
		a = new Rational(10,4);
		b = new Rational(20,8);
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("Compare a and b:[0 means equal, 1 means a > b, -1 means b > a]");
		System.out.println(a.compareTo(b));
		
		System.out.println("======================================");
		
		a = new Rational(10,4);
		b = new Rational(21,8);
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("Compare a and b:[0 means equal, 1 means a > b, -1 means b > a]");
		System.out.println(a.compareTo(b));
		
		System.out.println("======================================");
		
		a = new Rational(11,4);
		b = new Rational(20,8);
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("Compare a and b:[0 means equal, 1 means a > b, -1 means b > a]");
		System.out.println(a.compareTo(b));
		
		System.out.println("======================================");
		
		a = new Rational(10,4);
		b = new Rational(20,8);
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("a = b ?");
		System.out.println(a.equals(b));
	}
}
