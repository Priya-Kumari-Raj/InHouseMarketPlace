package com.cg.market.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.market.dto.ProductDetails;
import com.cg.market.entities.Product;

@Component
public class ProductUtil {

	public ProductDetails toDetails(Product prod) {

		return new ProductDetails(prod.getProdId(), prod.getTitle(), prod.getDescription(), prod.getCategory(),
				prod.getPrice(), prod.getDate(), prod.getEmployee());
	}

	public List<ProductDetails> toDetails(List<Product> products) {
		List<ProductDetails> detailList = new ArrayList<>();
		for (Product product : products) {
			ProductDetails details = toDetails(product);
			System.out.println(details);
			detailList.add(details);
		}
		return detailList;
	}
}
