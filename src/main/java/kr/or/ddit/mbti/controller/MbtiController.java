package kr.or.ddit.mbti.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.mbti.service.MbtiService;
import kr.or.ddit.mbti.service.MbtiServiceImpl;
import kr.or.ddit.mvc.ViewResolverComposite;
import kr.or.ddit.utils.PopulateUtils;
import kr.or.ddit.utils.ValidateUtils;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.vo.MbtiVO;

/**
 *  다건조회: /mbti (GET)
 *  단건조회: /mbti/estj (GET)
 *  등록 : /mbti (POST)
 *  수정 : /mbti/estj (PUT)
 *  삭제 : /mbti/estj (DELETE)
 *
 */
@WebServlet("/mbti/*")
@MultipartConfig
public class MbtiController extends HttpServlet{
    private MbtiService service = new MbtiServiceImpl();

    private void getMbtiList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<MbtiVO> mbtiList = service.readMbtiList();
        req.setAttribute("mbtiList", mbtiList);
    }

    private void getMbtiSingle(String mtType, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MbtiVO mbti = service.readMbti(mtType);
        req.setAttribute("mbti", mbti);
    }

    private Pattern regex = Pattern.compile("/mbti/([a-z]{4})");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        Matcher matcher = regex.matcher(uri);
        if(matcher.find()) {
            String mtType = matcher.group(1);
            getMbtiSingle(mtType, req, resp);
        }else {
            getMbtiList(req, resp);
        }

        new ViewResolverComposite().resolveView(null, req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MbtiVO mbti = new MbtiVO();
        req.setAttribute("mbti", mbti);
        PopulateUtils.populate(mbti, req.getParameterMap());
        Map<String, List<String>> errors = new HashMap<>();
        req.setAttribute("errors", errors);
        ValidateUtils.validate(mbti, errors, UpdateGroup.class);
        boolean success = false;
        if(errors.isEmpty()) {
            service.modifyMbti(mbti);
            success = true;
        }
        req.setAttribute("success", success);

        new ViewResolverComposite().resolveView(null, req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Matcher matcher = regex.matcher(req.getRequestURI());
        if(matcher.find()) {
            String mtType = matcher.group(1);
            service.removeMbti(mtType);
            req.setAttribute("success", true);

            new ViewResolverComposite().resolveView(null, req, resp);
        }else {
            resp.sendError(400, "전체 삭제는 지원하지 않아요.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MbtiVO mbti = new MbtiVO();
        req.setAttribute("mbti", mbti);
        PopulateUtils.populate(mbti, req.getParameterMap());
        Map<String, List<String>> errors = new HashMap<>();
        req.setAttribute("errors", errors);
        ValidateUtils.validate(mbti, errors, InsertGroup.class);
        boolean success = false;
        if(errors.isEmpty()) {
            service.createMbti(mbti);
            success = true;
        }

        String lvn = "redirect:/mbti/"+mbti.getMtType();

        new ViewResolverComposite().resolveView(lvn, req, resp);
    }
}














