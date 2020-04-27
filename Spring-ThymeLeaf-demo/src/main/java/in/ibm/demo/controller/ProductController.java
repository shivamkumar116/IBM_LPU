package in.ibm.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	@GetMapping("/products")
	public String getProducts(Model model) {
		model.addAttribute("products", productService.getProducts());
		return "products";
	}
	
	@GetMapping("/product/{productID}")
	public String findProductByID(@PathVariable int productID,Model model) {
		model.addAttribute("product",productService.findProductById(productID));
		return "product";
	}
	
	@RequestMapping("/product/new")
	public String getForm(Model model) {
		model.addAttribute("product",new Product());
		return "productForm";
	}
	
	@PostMapping("/product")
	public String save(Product product) {
		productService.create(product);
		 return "redirect:/products/";
	}

}
