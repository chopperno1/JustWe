package com.JustWe.component;

import com.sun.corba.se.spi.orbutil.closure.Closure;
import com.sun.corba.se.spi.resolver.LocalResolver;
import org.apache.commons.lang3.StringUtils;
import org.omg.CORBA.Object;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 在链接上携带区域信息（页面切换语言）
 *
 */
public class MyLocaleResolver implements LocaleResolver{

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        // 例：l=en_US ，l=zh_CN
        String l = httpServletRequest.getParameter("l");
        Locale locale = Locale.getDefault();
        if(!StringUtils.isEmpty(l) && l.indexOf("_") > 0) {
            String[] localInfo = l.split("_");
            locale = new Locale(localInfo[0], localInfo[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
