package com.strongpoint.manager;

import java.util.HashMap;
import java.util.Map;

public abstract class Singleton {
	
	private static Map<Class<? extends Singleton>, Singleton> INSTANCES_MAP = new HashMap<Class<? extends Singleton>, Singleton>();

    public synchronized static <E extends Singleton> Singleton getInstance(Class<E> instanceClass) throws Exception {
        if(INSTANCES_MAP.containsKey(instanceClass)){
            return INSTANCES_MAP.get(instanceClass);
        } else {
            E instance = instanceClass.newInstance();
            INSTANCES_MAP.put(instanceClass, instance);
            return instance;
        }
    }

    protected Singleton(){
    }
}
