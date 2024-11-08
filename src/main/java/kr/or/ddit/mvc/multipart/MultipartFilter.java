package kr.or.ddit.mvc.multipart;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

/**
 * multipart request 를 wrapper request로 변경함.
 *
 */
@Slf4j
public class MultipartFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("{} 필터 초기화", getClass().getSimpleName());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String contentType = request.getContentType();

        if(contentType!=null && contentType.startsWith("multipart/form-data")) {
            HttpServletRequest req = (HttpServletRequest) request;
            MultipartHttpServletRequest wrapper = new MultipartHttpServletRequest(req);

            chain.doFilter(wrapper, response);
        }else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

}
