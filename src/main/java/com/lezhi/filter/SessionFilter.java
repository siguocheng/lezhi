package com.lezhi.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

//@Component
public class SessionFilter implements Filter {

	private static final int FIVE_MINUTES = 5 * 60 * 1000;

	private static final Logger LOGGER = LoggerFactory.getLogger(SessionFilter.class);

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		String url = httpServletRequest.getRequestURI().substring(httpServletRequest.getContextPath().length());
		LOGGER.info("url:" + url);
		// 开始判断
		if (url.startsWith("/") && url.length() > 1) {
			// 在这里把url处理掉 进来的是“/***.do” 处理后是“***.do” 即把分隔符剔除掉
			url = url.substring(1);
		}

		Cookie[] cookies = httpServletRequest.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				String value = cookie.getValue();
				StringBuilder builder = new StringBuilder();
				builder.append(cookie.getName() + "=" + value + ";");
				builder.append("Secure;");// Cookie设置Secure标识
				builder.append("HttpOnly;");// Cookie设置HttpOnly

//				Calendar cal = Calendar.getInstance();
//				cal.add(Calendar.HOUR, 1);
//				Date date = cal.getTime();
//				Locale locale = Locale.CHINA;
//				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss",locale);
//				builder.append("Expires="+sdf.format(date));

				httpServletResponse.addHeader("Set-Cookie", builder.toString());
//                cookie.setSecure(true);
//                cookie.setHttpOnly(true);
			}
		}

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * 不需要登录校验
	 *
	 * @param url
	 * @return
	 */
	private boolean isInclude(String url) {

		return false;
	}

	private void loginFail(ServletResponse response, String message) throws IOException {
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		httpServletResponse.setContentType("application/json; charset=utf-8");
		response.getWriter().write("{\"code\":\"loginAuthFail\",\"message\":\"" + message + "\"}");
	}

	private void readTimeout(ServletResponse response, String message) throws IOException {
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		httpServletResponse.setContentType("application/json; charset=utf-8");
		response.getWriter().write("{\"code\":\"read time out\",\"message\":\"" + message + "\"}");
	}

	// 字符串读取
	// 方法一
	public static String ReadAsChars(HttpServletRequest request) {

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder("");
		try {
			br = request.getReader();
			String str;
			while ((str = br.readLine()) != null) {
				sb.append(str);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != br) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}
}
