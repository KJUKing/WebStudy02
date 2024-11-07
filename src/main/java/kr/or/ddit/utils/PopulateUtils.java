package kr.or.ddit.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Map;

import javax.servlet.ServletException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang3.StringUtils;

public class PopulateUtils {
    static {
        Converter dateConverter = new Converter() {

            @Override
            public <T> T convert(Class<T> type, Object value) {
                if(value==null) {
                    return null;
                }else if(StringUtils.isBlank(value.toString())) {
                    return null;
                }else {
                    String origin = value.toString();
                    try {
                        Method parseMtd = type.getDeclaredMethod("parse", CharSequence.class);
                        return (T) parseMtd.invoke(null, origin);
//						return (T) LocalDate.parse(origin);
                    } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        };
        ConvertUtils.register(dateConverter, LocalDateTime.class);
        ConvertUtils.register(dateConverter, LocalDate.class);
        ConvertUtils.register(dateConverter, YearMonth.class);
    }

    public static <T> void populate(T bean, Map<String, ? extends Object> map) {
        try {
            BeanUtils.populate(bean, map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}











