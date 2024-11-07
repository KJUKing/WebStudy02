package kr.or.ddit.vo;

import lombok.Data;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.List;

@Data
public class BuyerVO implements Serializable {

    @NotBlank
    private String buyerId;
    @NotBlank
    private String buyerName;
    @NotBlank
    private String buyerLgu;
    private String buyerBank;
    private String buyerBankno;
    private String buyerBankname;
    private String buyerZip;
    private String buyerAdd1;
    private String buyerAdd2;
    private String buyerComtel;
    private String buyerFax;
    private String buyerMail;
    private String buyerCharger;
    private String buyerTelext;

    private List<ProdVO> prodList; // BuyerVO has Many ProdVO (1:N) 관계  하나의 부모는 여러 자식을 갖는다.
    private LprodVO lprod; // BuyerVO Has A LprodVO (1:1) 자식이 하나의 부모를 갖는다
}