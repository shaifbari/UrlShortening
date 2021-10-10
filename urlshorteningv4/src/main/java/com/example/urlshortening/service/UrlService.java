package com.example.urlshortening.service;

import java.util.List;

import com.example.urlshortening.entity.Url;

public interface UrlService {
	public String getShortUrl(String urlShort);
	public List<Url> getLongUrl(String urllong);
	public void saveUrl(Url url);

}
