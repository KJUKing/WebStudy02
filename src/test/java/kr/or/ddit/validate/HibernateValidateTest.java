package kr.or.ddit.validate;

import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;
import java.util.*;

@Slf4j
public class HibernateValidateTest {

    static Validator validator;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();

    }

    @Test
    void test() {
        MemberVO target = new MemberVO();
//        target.setMemId("a001");
//        target.setMemPass("java");
//        target.setMemZip("aaaa");
//        target.setMemName("aaa");
//        target.setMemAdd1("대전");
//        target.setMemMail("aaad@gmail.com");
//        target.setMemAdd2("오류");
//        target.setMemRegno1("1");
//        target.setMemRegno2("1");

        Set<ConstraintViolation<MemberVO>> constraintViolations = validator.validate(target);
        Map<String, List<String>> errors = new HashMap<>();
        log.info("검증에 통과하지 못한 프로퍼티 개수 : {}", constraintViolations.size());
        if (!constraintViolations.isEmpty()) {
            for (ConstraintViolation<MemberVO> single : constraintViolations) {
                String propertyPath = single.getPropertyPath().toString();
                String message = single.getMessage();
                List<String> msgList = errors.get(propertyPath);
                if (msgList == null) {
                    msgList = new ArrayList<>();
                    errors.put(propertyPath, msgList);
                }
                msgList.add(message);
            }//for end
            errors.forEach((key, value) -> log.info("{} : {}", key, value));
        }
    }

//    @AfterAll
//    static void tearDownAfterClass() throws Exception {
//        log.info("after all");
//    }
//
//    @BeforeEach
//    void setUp() throws Exception {
//        log.info("before each");
//    }
//
//    @AfterEach
//    void tearDown() throws Exception {
//        log.info("after each");
//    }
//
//    @Test
//    void test1() {
//        log.info("test case 1");
//    }
//    @Test
//    void test2() {
//        log.info("test case 2");
//    }
}
