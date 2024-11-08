package kr.or.ddit.vo;

import java.time.LocalDate;

import lombok.Data;
import lombok.ToString;

@Data
public class CartVO {
    private String cartMember;
    private String cartNo;
    private String cartProd;
    private int cartQty;
    private LocalDate cartDate;

    @ToString.Exclude
    private ProdVO prod;
}
