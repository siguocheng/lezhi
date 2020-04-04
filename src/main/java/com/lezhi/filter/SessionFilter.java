package com.lezhi.filter;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.lezhi.entity.ResultBean;
import com.lezhi.entity.User;

@Component
public class SessionFilter implements Filter {

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

		String localtion =httpServletRequest.getRequestURL().toString();
		
		// 不是登陆接口，需要判断session是否过期
		if (!url.contains("login") && !url.contains(".") && localtion.contains("admin")) {
			User user = (User)httpServletRequest.getSession().getAttribute("user");
			if (user == null) {
				
				httpServletResponse.setContentType("application/json; charset=utf-8");
				ResultBean resultBean = new ResultBean<>();
				resultBean.setCode(ResultBean.NO_LOGIN);
				resultBean.setMsg("请登陆");
				response.getWriter().write(JSONObject.toJSONString(resultBean));
			} else {
				filterChain.doFilter(request, response);
			}
		} else {
			filterChain.doFilter(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

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
