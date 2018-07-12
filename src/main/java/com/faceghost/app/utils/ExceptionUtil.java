package com.faceghost.app.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
/**
 * 异常工具类
 * 
 * @author faceghost.com/profile/java_world
 */
public class ExceptionUtil {

	/**
	 * 获取异常的全部信息
	 * @param ex
	 * @return
	 */
	public static String getExDetail(Throwable ex) {
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);

		try {
			pw.close();
			sw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pw != null)
					pw.close();
				if (sw != null)
					sw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return sw.toString();
	}

}
