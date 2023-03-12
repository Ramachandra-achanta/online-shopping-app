package com.shoppingapp.login.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.shoppingapp.login.kafka.config.KafkaProducer;
import com.shoppingapp.login.model.ProductData;
import com.shoppingapp.login.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Autowired
	private KafkaProducer kafkaProducer;
	

	@Override
	public List<ProductData> getAllProducts() {
		kafkaProducer.sendMessage("All Products Count - "+productRepository.count());
		return productRepository.findAll();
	}

	@Override
	public ProductData getProductsByName(String name) throws Exception {
		Optional<ProductData> product = productRepository.findByName(name);
		long productcount = productRepository.countProducts(name);
		kafkaProducer.sendMessage(name+"Product Count - "+productcount);
		if (product.isPresent()) {
			return product.get();
		} else {
			throw new Exception("No products found with provided name");
		}
	}

	@Override
	public ProductData addProduct(ProductData productData) {
		return productRepository.save(productData);
	}

	@Override
	public ProductData updateProductStatus(String name, String status) throws Exception {
		Query query = new Query();
		query.addCriteria(Criteria.where("productName").is(name));
		Update update = new Update();
		update.set("productStatus", status);
		kafkaProducer.sendMessage("Product status - "+status);
		return mongoTemplate.findAndModify(query, update, ProductData.class);
	}

	@Override
	public String deleteProduct(String name) {
		Optional<ProductData> optionalProduct =  productRepository.deleteByName(name);
		if (optionalProduct.isPresent()) {
			return "Product deleted succesfully";
		}
		return "Product not found";
		
	}


}
