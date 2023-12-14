package com.aweit.dynproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class DynProxy {

	private Object object;
	
	public DynProxy(Object object) {
		this.object = object;
	}
	
	public Object getProxy() {
		ClassLoader loader = object.getClass().getClassLoader();
		Class<?>[] interfaces = object.getClass().getInterfaces();
		InvocationHandler handler = (Object proxy, Method method, Object[] args) -> {
			Object result = null;
			System.out.printf("%s方法執行前,參數%s:%n",method.getName(),Arrays.toString(args));
			try {
				result = method.invoke(object, args);
			} catch (Exception e) {
				System.out.printf("錯誤訊息:%s%n",e.getStackTrace());
			}
			System.out.printf("%s方法執行後,回傳值%s:%n",method.getName(),result);
			return result;
		};
		return Proxy.newProxyInstance(loader, interfaces, handler);
	}
	
}
