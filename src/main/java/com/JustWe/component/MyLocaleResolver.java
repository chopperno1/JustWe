package com.JustWe.component;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 本地化设置
 *
 */
public class MyLocaleResolver implements LocaleResolver{

    /**
     * 信息本地化
     *
     * @param httpServletRequest
     * @return
     */
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        // 设置页面语言种类，例：l=en_US ，l=zh_CN
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
