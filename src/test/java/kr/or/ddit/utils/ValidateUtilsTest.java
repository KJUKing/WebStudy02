package kr.or.ddit.utils;

import kr.or.ddit.validate.DeleteGroup;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PersonVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class ValidateUtilsTest {

    @Test
    void validate() {
        PersonVO person = new PersonVO();
        Map<String, List<String>> errors = new HashMap<>();
        ValidateUtils.validate(person, errors, InsertGroup.class);

        log.info("검증 통과 여부 : {}", errors.isEmpty());

        errors.forEach((k, v) -> log.info("{} {}", k, v));
    }
}