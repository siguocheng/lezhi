/**
 * 名称: SessionFilter.java
 * 描述:
 *
 * @author shengling.guan
 * date: 2018年5月23日 上午10:00:58
 */
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
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
    	
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String url = httpServletRequest.getRequestURI().substring(httpServletRequest.getContextPath().length());
        LOGGER.info("url:" + url);
        //开始判断
        if (url.startsWith("/") && url.length() > 1) {
            //在这里把url处理掉  进来的是“/***.do”  处理后是“***.do”  即把分隔符剔除掉
            url = url.substring(1);
        }
        
        Cookie[] cookies = httpServletRequest.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
            	String value = cookie.getValue();
				StringBuilder builder = new StringBuilder();
				builder.append(cookie.getName()+"="+value+";");
				builder.append("Secure;");//Cookie设置Secure标识
				builder.append("HttpOnly;");//Cookie设置HttpOnly
				
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


    
    private boolean isIncludeiot(String url) {
      if (url.startsWith("iot/")) {
            return true;
        }
        return false;
    }

    /**
     * 不需要登录校验
     *
     * @param url
     * @return
     */
    private boolean isInclude(String url) {
        if ("login.do".equals(url) || "loadVerifyCode.do".equals(url)) {
            return true;
        } else if (url.startsWith("iot/") && !isIotIgnoreUrl(url)) {
            return true;
        }else if(url.contains("uploadProject")){//过滤图片
            return true;
        } else if (url.contains("uploadBigProject")) { //过滤大屏图片
        	return true;
        } else if (url.contains("uploadVideoProject")) { //过滤大屏视频
        	return true;
        } else if (url.contains("DTUFirmware")) { //过滤固件
        	return true;
        } else if (url.contains("firmware")) { //过滤固件
        	return true;
        } else if (url.contains("projectPic")) {
        	return true;
        } else if (url.contains("uploadScreenProjectPicture")) {
        	return true;
        } else if(url.contains("uploadEquipmenTypePicture")){ //新增机型图片
        	return true;
        } else if(url.contains("uploadTradePicture")){ // 行业
        	return true;
        }
        return false;
    }

    /**
     * 调用iot微服务不能忽略的url
     * @param url
     * @return
     */
    private boolean isIotIgnoreUrl(String url){
    
    	List<String> list = new ArrayList<String>();
    	
    	list.add("iot/projectList.do");
    	list.add("iot/isProjectExist.do");
    	list.add("iot/deviceList.do");
    	list.add("iot/countList.do");
    	list.add("iot/alarmList.do");
    	list.add("iot/waterList.do");
    	list.add("iot/electricityList.do");
    	list.add("iot/gasList.do");
    	list.add("iot/envTemperatueList.do");
    	list.add("iot/pictureList.do");
    	list.add("iot/dtuList.do");
    	list.add("iot/getBoilerProjectDashboard");
    	
    	if (list.contains(url)) {
    		return true;
    	}
    	
    	return false;
    }

    private void loginFail(ServletResponse response, String message) throws IOException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setContentType("application/json; charset=utf-8");
        response.getWriter().write("{\"code\":\"loginAuthFail\",\"message\":\""+ message +"\"}");
    }

    private void readTimeout(ServletResponse response, String message) throws IOException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setContentType("application/json; charset=utf-8");
        response.getWriter().write("{\"code\":\"read time out\",\"message\":\""+ message +"\"}");
    }

    // 字符串读取
    // 方法一
    public static String ReadAsChars(HttpServletRequest request)
    {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder("");
        try
        {
            br = request.getReader();
            String str;
            while ((str = br.readLine()) != null)
            {
                sb.append(str);
            }
            br.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (null != br)
            {
                try
                {
                    br.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
}
