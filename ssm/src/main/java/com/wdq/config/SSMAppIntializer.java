package com.wdq.config;

import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by wdq on 2018/3/26.
 */
public class SSMAppIntializer implements WebApplicationInitializer{
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        registerCharacterEncodingFilter(servletContext);
        registerDruidServlet(servletContext);
    }

     private void registerCharacterEncodingFilter(ServletContext context){
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        FilterRegistration.Dynamic filter = context.addFilter("characterEncodingFilter", encodingFilter);
        filter.addMappingForUrlPatterns(null, false, "/*");
    }

    public void registerDruidServlet(ServletContext context){
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistration.Dynamic dynamic = context.addServlet("statViewServlet", statViewServlet);
        dynamic.setLoadOnStartup(3);
        dynamic.setInitParameter("allow", "127.0.0.1");
        dynamic.setInitParameter("loginUsername", "wdq");
        dynamic.setInitParameter("loginPassword", "wdq");
        dynamic.setInitParameter("resetEnable", "false");
        dynamic.addMapping("/druid/*");

    }

}
