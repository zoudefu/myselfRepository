package singleMode;

public class Hungry {
	//饿汉模式执行效率高  浪费内存 线程安全的
	private static Hungry instance = new Hungry();  
    private Hungry (){}  
    public static Hungry getInstance() {  
    return instance;  
    }

}
