package kr.or.ddit.mvc;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ContentNegotiatingViewResolver implements ViewResolver {

    @Override
    public void resolveView(String lvn, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String accept = req.getHeader("accept");
        if(accept.contains("json")) {
            Map<String, Object> models = new HashMap<>();
            Enumeration<String> names = req.getAttributeNames();
            while (names.hasMoreElements()) {
                String name = (String) names.nextElement();
                models.put(name, req.getAttribute(name));
            }
            resp.setContentType("application/json;charset=UTF-8");
            try(
                    OutputStream os = resp.getOutputStream();
            ){
                new ObjectMapper().writeValue(os, models);
            }
        }else {
            throw new RuntimeException(String.format("현재 요청은 %s 로 처리 불가", getClass().getSimpleName()));
        }
    }

}


