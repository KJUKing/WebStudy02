package kr.or.ddit.mvc.multipart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.Part;

import org.apache.commons.lang3.StringUtils;

public class MultipartHttpServletRequest extends HttpServletRequestWrapper {

    private Map<String, List<MultipartFile>> fileMap;

    public MultipartHttpServletRequest(HttpServletRequest request) throws IOException, ServletException {
        super(request);
        parseRequest(request);
    }

    private void parseRequest(HttpServletRequest req) throws IOException, ServletException {
        fileMap = new HashMap<>();
        for(Part single : req.getParts()) {
            String contentType = single.getContentType();
            if(StringUtils.isBlank(contentType)) continue;

            MultipartFile file = new StandardServletMultipartFile(single);
            String partName = file.getName();
            List<MultipartFile> fileList = fileMap.get(partName);
            if(fileList==null) {
                fileList = new ArrayList<>();
                fileMap.put(partName, fileList);
            }
            fileList.add(file);
        }
    }

    public Map<String, List<MultipartFile>> getFileMap() {
        return fileMap;
    }

    public MultipartFile getFile(String partName){
        return Optional.ofNullable(fileMap.get(partName))
                .filter(l->l.size()>0)
                .map(l->l.get(0))
                .orElse(null);
    }

    public List<MultipartFile> getFiles(String partName){
        return fileMap.get(partName);
    }
}








