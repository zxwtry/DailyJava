package java1605;

/*
 * 	Source : InportNew
 * 	URL : http://www.importnew.com/19301.html
 * 	Title : JAVA回调机制(CallBack)详解
 * 	
 * 	1，	学习过 Android 开发，肯定接触过回调，而在Java和JavaWeb开发
 * 		中，回调不常讨论。
 * 	2，	文章不像是一个技术分析类文章，更像是科普类文章。文中并没有对
 * 		异步回调进行科普，只是科普了同步回调。
 * 	3，	接下来将会实现一个同步回调，设计如下：
 * 		a，创建一个抽象类  人 Person ，人都会饿，都会吃
 * 		b，创建一个接口，EatAction，懂中国文化的人都会使用筷子，
 * 			加ChineseCultureEatAction实现类
 * 		
 */
public class 水_回调机制CallBack详解 {
	public static void main(String[] args) {
		Chinese chinese = new Chinese();
		chinese.hungry();
	}
}

abstract class Person {
	public abstract void hungry();
	public void eat() {
		System.out.println("eating ... ");
	}
	
	void eatAction(EatAction eatAction) {
		eatAction.myEatAction();
	}
}

class Chinese extends Person {

	@Override
	public void hungry() {
		eatAction(new ChineseCultureEatAcion(this));
	}

}

interface EatAction {
	public void myEatAction();
}

class ChineseCultureEatAcion implements EatAction {
	
	private Person person = null;
	
	public ChineseCultureEatAcion(Person person) {
		this.person = person;
	}

	@Override
	public void myEatAction() {
		System.out.println("using chopsticks");
		person.eat();
	}
}
