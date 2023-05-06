package datastructure;

public class Demo {

	void a() {
		this.b();
	}
	void b() {
		this.a();
	}
	public static void main(String[] args) {
		new Demo().a();
	}
}
