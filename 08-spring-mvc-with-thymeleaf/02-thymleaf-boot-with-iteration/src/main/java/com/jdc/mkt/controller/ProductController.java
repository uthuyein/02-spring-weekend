package com.jdc.mkt.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.jdc.mkt.model.entity.Product;
import com.jdc.mkt.model.repo.ProductRepo;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping({ "/", "product" })
@RequiredArgsConstructor
public class ProductController {

	private final ProductRepo repo;

	@GetMapping
	String index(ModelMap map) {
		map.put("products", repo.findAll());
		return "products";
	}
	
	@ModelAttribute("count")
	long size() {
		return repo.count();
	}

	@PostMapping("upload")
	String upload(@RequestPart("file") MultipartFile file) {
		if (null == file) {
			return "Redirect:/product";
		}

		try (var br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			String line = null;
			while(null != (line = br.readLine())) {
				var array = line.split("\t");
				var p = new Product();
				p.setName(array[0]);
				p.setPrice(Double.parseDouble(array[1]));
				repo.save(p);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/product";
	}
}
