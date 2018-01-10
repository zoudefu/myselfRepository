package singleMode;
public class SingletonPatterDemo {
	public static void main(String[] args) {
	//不合法的构造函数
	//编译时出错：构造函数SigleObject（）是不可见的
	//SingleObject instance= new SingleObject();
	
	//获取唯一的可用对象
	SingleLazy aa=SingleLazy.getInstance();
	//显示消息
	aa.showMessage();
}
	
}
