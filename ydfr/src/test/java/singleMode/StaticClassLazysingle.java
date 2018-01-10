package singleMode;

public class StaticClassLazysingle { 
	private static class SingletonHolder {  
    private static final StaticClassLazysingle INSTANCE = new StaticClassLazysingle();  
    }  
    private StaticClassLazysingle (){}  
    public static final StaticClassLazysingle getInstance() {  
    return SingletonHolder.INSTANCE;  
    }  }
