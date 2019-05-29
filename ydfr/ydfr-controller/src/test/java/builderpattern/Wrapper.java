package builderpattern;
//实现包装类的接口，实现接口里的方法
public class Wrapper implements Packing{
    
	@Override
	public String pack() {
		return "Wrapper";
	}

}
