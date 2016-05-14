package jp.co.engineer_plus.utility;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * JavaBeansのUtilクラス
 */
public class JavaBeansUtil {
	/**
	 * sourceが持つgetterから取得した値をdestinationのsetterに渡す<br />
	 * 例）　destination.setXX(sorce.getXX());
	 * @param source 設定元のJavaBeansオブジェクト
	 * @param destination 設定先のJavaBeansオブジェクト
	 */
	public static void exchange(Object source, Object destination) {
		List<Method> list = Arrays.asList(source.getClass().getDeclaredMethods())
				.stream().filter(e -> {
					return e.getName().startsWith("get");
				}).collect(Collectors.toList());
		try {
			for (Method m : list) {
				destination
						.getClass()
						.getMethod(m.getName().replace("get", "set"),
								m.getReturnType())
						.invoke(destination, m.invoke(source));
			}
		} catch (ReflectiveOperationException e) {
			throw new RuntimeException(e);
		}
	}
}
