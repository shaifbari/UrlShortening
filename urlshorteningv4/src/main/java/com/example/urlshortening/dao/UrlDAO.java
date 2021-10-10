package com.example.urlshortening.dao;

import java.util.List;

import com.example.urlshortening.entity.Url;

public interface UrlDAO {
	public String getShortUrl(String urlShort);
	public List<Url> getLongUrl(String urllong);
	public void saveUrl(Url url);

}

