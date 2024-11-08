package kr.or.ddit.mvc.multipart;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

import javax.servlet.http.Part;

import org.apache.commons.lang3.StringUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StandardServletMultipartFile implements MultipartFile {
    private final Part adaptee;

    @Override
    public byte[] getBytes() throws IOException {
        try(
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                InputStream is = adaptee.getInputStream();
        ){
            byte[] buffer = new byte[1024];
            int poi = -1; // EOF 문자
            while((poi = is.read(buffer))!=-1) {
                baos.write(buffer, 0, poi);
            }
            baos.flush();
            return baos.toByteArray();
        }
    }

    @Override
    public String getContentType() {
        return adaptee.getContentType();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return adaptee.getInputStream();
    }

    @Override
    public String getName() {
        return adaptee.getName();
    }

    @Override
    public String getOriginalFilename() {
        return adaptee.getSubmittedFileName();
    }

    @Override
    public long getSize() {
        return adaptee.getSize();
    }

    @Override
    public boolean isEmpty() {
        return adaptee.getSize()==0 && StringUtils.isBlank(adaptee.getSubmittedFileName());
    }

    @Override
    public void transferTo(File dest) throws IOException {
        adaptee.write(dest.getAbsolutePath());
    }

    @Override
    public void transferTo(Path dest) throws IOException {
        adaptee.write(dest.toString());
    }

}











