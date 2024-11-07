package kr.or.ddit.mvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ViewResolverComposite implements ViewResolver {
    private List<ViewResolver> viewResolvers;
    {
        viewResolvers = new ArrayList<>();
        viewResolvers.add(new TilesViewResolver());

        viewResolvers.add(new InternalResourceViewResolver());

    }

    @Override
    public void resolveView(String lvn, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (lvn.startsWith("redirect:")) {
            String location = lvn.replace("redirect:", req.getContextPath());
            resp.sendRedirect(location);
        } else {
            for(ViewResolver singleVR : viewResolvers) {
                try {
                    singleVR.resolveView(lvn, req, resp);
                    break;
                }catch (Exception e) {
                    log.warn("logical view name -{}- 을 {} 가 해결하지 못했음.", lvn, singleVR.getClass().getSimpleName());
                    continue;
                }
            }
        }
    }

}












