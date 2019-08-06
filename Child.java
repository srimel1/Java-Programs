public class Child extends Mother{

	int valueC,valueD;

	public Child(int a,int b) {

		valueC = a;

		valueD = b;

	}

	public Child(int a,int b,int c,int d) {

		super(a,b);

		this.valueC = c;

		this.valueD = d;

	}

	public int getValueC() {

		return valueC;

	}

	public void setValueC(int valueC) {

		this.valueC = valueC;

	}

	public int getValueD() {

		return valueD;

	}

	public void setValueD(int valueD) {

		this.valueD = valueD;

	}

	public int Add(int a,int b,int c) {

		return a/b-c;

	}

}