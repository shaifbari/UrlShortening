package com.example.urlshortening.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.urlshortening.entity.Url;

@Repository
public class UrlDAOImpl implements UrlDAO {
	private EntityManager entityManager;
	
	@Autowired
	public UrlDAOImpl(EntityManager theEntityManager){
		entityManager = theEntityManager;
	}
	
	@Override
	public String getShortUrl(String urlShort) {
		Url u = new Url();
		u = entityManager.find(Url.class, urlShort);
		return u.getLongUrl();
	}
	
	@Override
	public List<Url> getLongUrl(String urllong) {
		List<Url> list = new ArrayList<>();
		Query theQuery = entityManager.createQuery("select u.shortUrl from Url u where u.longUrl =:theUrlLong");
		theQuery.setParameter("theUrlLong", urllong);
		list = theQuery.getResultList();
		return list;	
	}
	
	@Override
	public void saveUrl(Url url) {
		// TODO Auto-generated method stub
		Url u2 = entityManager.merge(url);
		url.setShortUrl(u2.getShortUrl());
	}

}
