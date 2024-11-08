package kr.or.ddit.mvc.multipart;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

/**
 * 하나의 파트(body의 부분집합)을 캡슐화할 수 있는 추상타입
 *
 */
public interface MultipartFile {
    public byte[] getBytes() throws IOException;
    public String getContentType();
    public InputStream getInputStream() throws IOException;
    public String getName();
    public String getOriginalFilename();
    public long getSize();
    public boolean isEmpty();
    public void transferTo(File dest) throws IOException;
    public default void transferTo(Path dest) throws IOException {}
}
