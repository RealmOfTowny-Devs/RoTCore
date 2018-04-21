package rotcore;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class ClassReflection {

	Object getNewInstanceOf(Class<?> c) {
		Constructor<?> constructor = null;
		try {
			constructor = c.getDeclaredConstructor(new Class[0]);
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
        constructor.setAccessible(true);
        Object instance = null;
		try {
			instance = constructor.newInstance(new Object[0]);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
        System.out.println(instance);
        return instance;
	}

}
