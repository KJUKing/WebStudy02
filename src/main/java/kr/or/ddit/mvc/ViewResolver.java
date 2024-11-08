package kr.or.ddit.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * logical view name 으로 부터 실제 뷰를 찾고, 이동하는 전략.
 * 1. redirect: 접두어 사용
 * 2. 타일즈의 definintion 이 필요한 경우.
 * 3. single jsp 사용
 *
 */
public interface ViewResolver {
    public void resolveView(String lvn, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException;
    public default void setPrefix(String prefix) {}
    public default void setSuffix(String suffix) {}

}
