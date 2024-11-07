package kr.or.ddit.vo;

import kr.or.ddit.validate.DeleteGroup;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.validate.UpdateGroup;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;
import javax.validation.groups.Default;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 회원관리용 Domain Layer
 */
@Getter
@Setter
@EqualsAndHashCode(of = {"memId", "memRegno1", "memRegno2"})
@ToString
public class MemberVO implements Serializable {
    @NotBlank(groups = {Default.class, DeleteGroup.class})
    @Size(min = 3, max = 15, groups = {Default.class, DeleteGroup.class})
    private String memId;
    @ToString.Exclude
    @NotBlank(groups = {Default.class, DeleteGroup.class})
    @Size(min = 4, max = 8, groups = {Default.class, DeleteGroup.class})
    private transient String memPass;
    @NotBlank
    private String memName;
    @Size(min = 6, max = 6, groups = InsertGroup.class)
    @ToString.Exclude
    @NotBlank(groups = InsertGroup.class)
    private transient String memRegno1;
    @Size(min = 7, max = 7, groups = InsertGroup.class)
    @ToString.Exclude
    @NotBlank(groups = InsertGroup.class)
    private transient String memRegno2;
    private LocalDateTime memBir;
    @NotBlank
    private String memZip;
    @NotBlank
    private String memAdd1;
    @NotBlank
    private String memAdd2;

    @Pattern(regexp = "\\d{2,3}-\\d{3,4}-\\d{4}")
    private String memHometel;
    @Pattern(regexp = "\\d{2,3}-\\d{3,4}-\\d{4}")
    private String memComtel;
    @Pattern(regexp = "\\d{3}-\\d{4}-\\d{4}")
    private String memHp;


    @NotBlank
    @Email
    private String memMail;
    private String memJob;
    private String memLike;
    private String memMemorial;
    private LocalDate memMemorialday;
    @Min(0)
    private Long memMileage;
    private boolean memDelete;
    private String memRole;

}
