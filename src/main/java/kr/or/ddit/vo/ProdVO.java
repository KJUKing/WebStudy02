package kr.or.ddit.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@EqualsAndHashCode(of = "prodId")
@ToString()
public class ProdVO implements Serializable {
    @NotBlank
    private String prodId;
    @NotBlank
    private String prodName;
    @Size(min = 4, max = 4)
    @NotBlank
    private String prodLgu;
    @NotBlank
    @Size(min = 6, max = 6)
    private String prodBuyer;
    @Min(0)
    @NotNull
    private Long prodCost;
    @Min(0)
    @NotNull
    private Long prodPrice;
    @Min(0)
    @NotNull
    private Long prodSale;
    @NotBlank
    private String prodOutline;
    @ToString.Exclude
    private String prodDetail;
    @NotBlank
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

    private LprodVO lprod; // Has A 이경우에는 ProdVO Has A LprodVO (1:1)
    private BuyerVO buyer; // Has A 이경우에는 ProdVO Has A BuyerVO (1:1)




}
