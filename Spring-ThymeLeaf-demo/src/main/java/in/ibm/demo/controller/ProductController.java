package in.ibm.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import in.ibm.demo.model.Product;
import in.ibm.demo.service.ProductService;

@Controller
public class ProductController {

	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@RequestMapping("/")
	public String hello(Model model) {
		model.addAttribute("theTime", new Date());
		return "Index";
	}

	@RequestMapping("/products")
	public String getProducts(Model model) {
		model.addAttribute("products", productService.getProducts());
		return "product";
	}

}
