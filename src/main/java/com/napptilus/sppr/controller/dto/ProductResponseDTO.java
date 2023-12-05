package com.napptilus.sppr.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeName("Product")
public class ProductResponseDTO  implements Serializable {

    private static final long serialVersionUID = 1L;

    private String productId;

    private String brandId;

    private LocalDateTime fromDateApplication;

    private LocalDateTime toDateApplication;

    private String priceProduct;

    private String priceCurrency; //This is necessary?

    /**
     * Get productId
     * @return productId
     */
    @NotNull
    @JsonProperty("productId")
    public String getProductId() {
        return productId;
    }

    /**
     * Get brandId
     * @return brandId
     */
    @NotNull
    @JsonProperty("brandId")
    public String getBrandId() {
        return brandId;
    }

    /**
     * Get brandId
     * @return brandId
     */
    @NotNull
    @JsonProperty("priceProduct")
    public String getPriceProduct() {
        return priceProduct;
    }

    /**
     * Get brandId
     * @return brandId
     */
    @NotNull
    @JsonProperty("priceCurrency")
    public String getPriceCurrency() {
        return priceCurrency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductResponseDTO product = (ProductResponseDTO) o;
        return Objects.equals(this.productId, product.productId) &&
                Objects.equals(this.brandId, product.brandId) &&
                Objects.equals(this.fromDateApplication, product.fromDateApplication) &&
                Objects.equals(this.toDateApplication, product.toDateApplication) &&
                Objects.equals(this.priceProduct, product.priceProduct) &&
                Objects.equals(this.priceCurrency, product.priceCurrency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, brandId, fromDateApplication, toDateApplication, priceProduct, priceCurrency);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProductResponseDTO {\n");
        sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
        sb.append("    brandId: ").append(toIndentedString(brandId)).append("\n");
        sb.append("    fromDateApplication: ").append(toIndentedString(fromDateApplication)).append("\n");
        sb.append("    toDateApplication: ").append(toIndentedString(toDateApplication)).append("\n");
        sb.append("    priceProduct: ").append(toIndentedString(priceProduct)).append("\n");
        sb.append("    priceCurrency: ").append(toIndentedString(priceCurrency)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
