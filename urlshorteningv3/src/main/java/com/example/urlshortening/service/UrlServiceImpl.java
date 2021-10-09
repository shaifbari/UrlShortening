package com.example.urlshortening.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.urlshortening.dao.UrlDAO;
import com.example.urlshortening.entity.Url;
@Service
public class UrlServiceImpl implements UrlService {
	private UrlDAO urlDao;
	
	@Autowired
	public UrlServiceImpl(UrlDAO theUrlDao) {
		urlDao = theUrlDao;
	}
	@Override
	@Transactional
	public String getShortUrl(String urlShort) {
		return urlDao.getShortUrl(urlShort);
	}
	@Override
	@Transactional
	public List<Url> getLongUrl(String urllong) {
		return urlDao.getLongUrl(urllong);
	}
}
