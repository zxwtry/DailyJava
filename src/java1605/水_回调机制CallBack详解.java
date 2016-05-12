package java1605;


/*
 * 	Source : InportNew
 * 	URL : http://www.importnew.com/19301.html
 * 	Title : JAVA回调机制(CallBack)详解
 * 	
 * 	1，	学习过 Android 开发，肯定接触过回调，而在Java和JavaWeb开发
 * 		中，回调不常讨论。先定性分析：
 * 			定性分析一：回调肯定是一个异步的过程   //后来证明本文中分析的是同步回调
 * 			定性分析二：回调肯定要使用特定的类来实现
 * 	2，	文章不像是一个技术分析类文章，更像是科普类文章。文中并没有对
 * 		异步回调进行科普，只是科普了同步回调。
 * 	3，	接下来将会实现一个同步回调，设计如下：
 * 		a，创建一个抽象类  人 Person ，人都会饿，都会吃
 * 		b，创建一个中国文化接口，ChinaCulture，懂中国文化的人都会
 * 			使用筷子 Chopsticks
 * 		c，现在有一个类中国人，吃饭时会自动回调筷子
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
}

class Chinese extends Person {

	@Override
	public void hungry() {
		new ChinaCultureEatAcion(this).myEatAction();
	}

}

interface EatAction {
	public void myEatAction();
}

class ChinaCultureEatAcion implements EatAction {
	
	private Person person = null;
	
	public ChinaCultureEatAcion(Person person) {
		this.person = person;
	}

	@Override
	public void myEatAction() {
		System.out.println("using chopsticks");
		person.eat();
	}

}
