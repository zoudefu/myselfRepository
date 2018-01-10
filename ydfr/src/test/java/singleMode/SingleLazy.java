package singleMode;

public class SingleLazy {
	//懒汉模式延迟加载
	//创建SingleObject的一个对象
	private static SingleLazy instance= new SingleLazy();
	//让构造函数为private，这样该类就不会被实例化
	private SingleLazy(){
		
	}
	//必须加锁才能保证单例，但是加锁影响效率
	public static synchronized  SingleLazy getInstance(){
		if(instance==null){
			instance=new SingleLazy();
		} 
		return instance;
		}
	public void showMessage() {
		System.out.println("我是一个简单的懒汉线程安全单例模式");
	}
}
