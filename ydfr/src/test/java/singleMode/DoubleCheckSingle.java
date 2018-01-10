package singleMode;


public class DoubleCheckSingle {
	private volatile static  DoubleCheckSingle doubleCheckSingle;
	
	private DoubleCheckSingle(){
		
	}
	public static DoubleCheckSingle getSingleton(){
		if(doubleCheckSingle==null){
			synchronized (DoubleCheckSingle.class) {
				if (doubleCheckSingle==null) {
					doubleCheckSingle=new DoubleCheckSingle();
				}
			}
		}
		return doubleCheckSingle;
		
	}

}
