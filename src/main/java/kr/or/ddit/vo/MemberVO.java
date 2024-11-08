package kr.or.ddit.vo;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

import kr.or.ddit.mvc.multipart.MultipartFile;
import kr.or.ddit.utils.annotation.CommentsForVO;
import kr.or.ddit.validate.DeleteGroup;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.validate.constraint.TelephoneNumber;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 회원관리용 Domain Layer
 *
 */
@Getter
@Setter
@EqualsAndHashCode(of = {"memId", "memRegno1", "memRegno2"})
@ToString
public class MemberVO implements Serializable{
    @NotBlank(groups = {Default.class, DeleteGroup.class})
    @Size(max = 15, groups = {Default.class, DeleteGroup.class})
    @CommentsForVO("아이디")
    private String memId;
    @NotBlank(groups = {Default.class, DeleteGroup.class})
    @Size(min = 4, max = 8, groups = {Default.class, DeleteGroup.class})
    @ToString.Exclude
    private transient String memPass;
    @NotBlank
    @CommentsForVO("이름")
    private String memName;
    @NotBlank(groups = InsertGroup.class)
    @Size(min = 6, max = 6, groups = InsertGroup.class)
    @ToString.Exclude
    @CommentsForVO("주민번호1")
    private transient String memRegno1;
    @NotBlank(groups = InsertGroup.class)
    @Size(min = 7, max = 7, groups = InsertGroup.class)
    @ToString.Exclude
    @CommentsForVO("주민번호2")
    private transient String memRegno2;
    @CommentsForVO("생일")
    private LocalDateTime memBir;
    @NotBlank
    @CommentsForVO("우편번호")
    private String memZip;
    @NotBlank
    @CommentsForVO("주소1")
    private String memAdd1;
    @NotBlank
    @CommentsForVO("주소2")
    private String memAdd2;

    @TelephoneNumber()
    @CommentsForVO("집전번")
    private String memHometel;
    @Pattern(regexp = "\\d{2,3}-\\d{3,4}-\\d{4}")
    @CommentsForVO("회사전번")
    private String memComtel;
    @Pattern(regexp = "\\d{3}-\\d{3,4}-\\d{4}")
    @CommentsForVO("휴대폰")
    private String memHp;

    @NotBlank
    @Email
    @CommentsForVO("이메일")
    private String memMail;
    @CommentsForVO("직업")
    private String memJob;
    @CommentsForVO("취미")
    private String memLike;
    @CommentsForVO("기념일")
    private String memMemorial;
    @CommentsForVO("기념일자")
    private LocalDate memMemorialday;
    @Min(0)
    @CommentsForVO("마일리지")
    private Long memMileage;
    private boolean memDelete;
    @CommentsForVO("역할")
    private String memRole;

    // 회원 프로필 관리용 프러퍼티 (BLOB - Binary Large OBject)
    private byte[] memImg; // 데이터베이스 지원
    private MultipartFile memImage; // 클라이언트 업로드 파일 지원

    public void setMemImage(MultipartFile memImage) throws IOException {
        if(memImage==null || memImage.isEmpty()) return;

        this.memImage = memImage;
        this.memImg = memImage.getBytes();
    }

    public String getBase64Img() {
        if(memImg!=null && memImg.length > 0) {
            return Base64.getEncoder().encodeToString(memImg);
        }else {
            return null;
        }
    }

    // 구매기록용 프로퍼티
    @ToString.Exclude
    private List<CartVO> cartList;
}












