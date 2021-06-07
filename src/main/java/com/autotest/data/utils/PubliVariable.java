package com.autotest.data.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PubliVariable {
//	private static final String KEY1 = "__randomStr";
//	private static final String KEY2 = "__email";
//	private static final String KEY3 = "__mobile";
//	private static final String KEY4 = "__idCard";
//	private static final String KEY5 = "__randomNum";
//	private static final String KEY6 = "__addr";
//	private static final String KEY7= "__gender";
//	private static final String KEY8 = "__time";
//	private static final String KEY9 = "__date";
//	private static final String KEY10= "__name";
//	private static final String KEY11 = "__unique";
//	private static final String KEY12 = "__uuid";
	
	public String execute(String methodName,String para) {	
		String Str=null;
		try {
            Class<?> clazz = Class.forName("com.autotest.data.utils.PubliVariable");
            Method method = clazz.getMethod(methodName, String.class);
            Object obj = method.invoke(clazz.newInstance(),para);
            Str=String.valueOf(obj);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }	
		return Str;
	}

	public synchronized String __randomStr(String value) {
		String[] varValue=value.split(",");
		java.util.Random random=new java.util.Random();
		int a=random.nextInt(varValue.length);		
		return varValue[a];
	}
	public String __email(String value) {
		String str=__randomStr(value);
		return str;
	}
	public String __mobile(String value) {
		String str=__randomStr(value);
		return str;
	}
	public String __idCard(String value) {
		String str=__randomStr(value);
		return str;
	}
	public String __randomNum(String value) {
		return value;
	}
	public String __addr(String value) {
		String str=__randomStr(value);
		return str;
	}
	public String __gender(String value) {
		String str=__randomStr(value);
		return str;
	}
	public String __time(String value) {
		return value;
	}
	public String __date(String value) {
		return value;
	}
	public String __name(String value) {
		String str=__randomStr(value);
		return str;
	}
	public String __unique(String value) {
		return value;
	}
	public String __uuid(String value) {
		return value;
	}
	
}
