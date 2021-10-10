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
	
	@GetMapping("/urlshort/{urllong}")
	public String getUrl(@PathVariable String urllong){
		String u = urlService.getShortUrl(urllong);
		if (u == null){
			throw new RuntimeException("Url does not exist-" + urllong);
		}
	return u;
	}  
	
	@GetMapping("/urllong/{urlshort}")
	public List<Url> getLongUrl(@PathVariable String urlshort){
		List<Url> u = new ArrayList<>();
		u = urlService.getLongUrl(urlshort);
		if (u == null){
			throw new RuntimeException("Url does not exist-" + urlshort);
		}
	return u;
	}  
	
	@PostMapping("/urlshort")
	public Url addUrl(@RequestBody Url theUrl){
		theUrl.setShortUrl(""+theUrl.getLongUrl().hashCode());
		urlService.saveUrl(theUrl);
		return theUrl;
	}
	
}
