package com.example.urlshortening.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.urlshortening.entity.Url;
import com.example.urlshortening.service.UrlService;

@RestController
@RequestMapping("/api")
public class UrlController {
	private UrlService urlService;
	@Autowired
	public UrlController(UrlService theUrlService) {
		urlService = theUrlService;
	}
	
	@GetMapping("/urlshort/{urlShort}")
	public String getUrl(@PathVariable String urlShort){
		String u = urlService.getShortUrl(urlShort);
		if (u == null){
			throw new RuntimeException("Url does not exist-" + urlShort);
		}
	return u;
	}  
	
	@GetMapping("/urllong/{urllong}")
	public List<Url> getLongUrl(@PathVariable String urllong){
		List<Url> u = new ArrayList<>();
		u = urlService.getLongUrl(urllong);
		if (u == null){
			throw new RuntimeException("Url does not exist-" + urllong);
		}
	return u;
	}  
}
