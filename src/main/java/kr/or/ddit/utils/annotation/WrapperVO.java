package kr.or.ddit.utils.annotation;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;

@Getter
public class WrapperVO <T>{
    public T vo;
    public List<String> keys;

    public WrapperVO(T vo) {
        this.vo = vo;
        keys = Arrays.stream(vo.getClass().getDeclaredFields())
                .filter(f->f.getAnnotation(CommentsForVO.class)!=null)
                .map(f->f.getName())
                .collect(Collectors.toList());
    }

    public String comments(String fldName) {
        String comments = "";

        if(keys.contains(fldName)) {
            try {
                Field fld = vo.getClass().getDeclaredField(fldName);
                CommentsForVO annotation = fld.getAnnotation(CommentsForVO.class);
                comments = annotation.value();
            } catch (NoSuchFieldException | SecurityException e) {
                throw new RuntimeException(e);
            }
        }

        return comments;
    }


}
