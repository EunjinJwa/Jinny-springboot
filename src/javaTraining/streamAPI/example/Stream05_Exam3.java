package javaTraining.streamAPI.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Kassy.
 * Date: 2019-10-18
 *
 * Stream API 예시 연습
 */
public class Stream05_Exam3 {

    public static void main(String[] args) {
        final List<Product> producs =
                Arrays.asList(
                        new Product(1L, "A", new BigDecimal(100.50)),
                        new Product(2L, "B", new BigDecimal(23.50)),
                        new Product(3L, "C", new BigDecimal(900)),
                        new Product(4L, "D", new BigDecimal(84.50)),
                        new Product(5L, "E", new BigDecimal(30.50))
                );

        List resultList = producs.stream()
                .filter(product -> product.getPrice().compareTo(new BigDecimal("30")) >= 0)
                .collect(Collectors.toList());
        System.out.println(resultList);
    }
}


@AllArgsConstructor
@Data
class Product {
    private Long id;

    public Product(long l, String a, BigDecimal price) {
        id = l;
        name = a;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    private String name;
    private BigDecimal price;

}

@AllArgsConstructor
@Data
class OrderedItem {
    private Long id;
    private Product product;
    private int quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}





