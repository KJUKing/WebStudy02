package kr.or.ddit.vo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import kr.or.ddit.validate.UpdateGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of = "prodId")
@ToString
public class ProdVO implements Serializable{
    @NotBlank(groups = UpdateGroup.class)
    private String prodId;
    @NotBlank
    private String prodName;
    @NotBlank
    @Size(min=4, max=4)
    private String prodLgu;
    @NotBlank
    @Size(min=6, max=6)
    private String prodBuyer;
    @NotNull
    @Min(0)
    private Long prodCost;
    @NotNull
    @Min(0)
    private Long prodPrice;
    @NotNull
    @Min(0)
    private Long prodSale;
    @NotBlank
    private String prodOutline;
    @ToString.Exclude
    private String prodDetail;
    //	@NotBlank
    private String prodImg;
    @NotNull
    private Long prodTotalstock;
    private LocalDate prodInsdate;
    @NotNull
    private Long prodProperstock;
    private String prodSize;
    private String prodColor;
    private String prodDelivery;
    private String prodUnit;
    private Long prodQtyin;
    private Long prodQtysale;
    private Long prodMileage;

    private LprodVO lprod; // ProdVO Has A LprodVO (1:1)
    private BuyerVO buyer; // ProdVO Has A BuyerVO (1:1)
}












