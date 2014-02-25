package com.freshie.site.db;

import java.util.List;

import com.freshie.site.Config;
import com.freshie.site.pojo.BlogPost;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.query.Query;

public class BlogPostDAO {

	public static void savePost(BlogPost post) {
		MongoService.getDatastore().save(post);
	}

	public static List<BlogPost> getPostsByPageNum(int pageNum) {

		Datastore ds = MongoService.getDatastore();
		int offset = pageNum * Config.getInt("page_size");
		int limit = Config.getInt("page_size");
//		System.out.println("offset: " + offset);
//		System.out.println("limit: " + limit);
		Query<BlogPost> q = ds.createQuery(BlogPost.class).order("id").offset(offset).limit(limit);
		List<BlogPost> entities = q.asList();

		return entities;
	}
	
	public static List<BlogPost> getAllPosts() {

		Datastore ds = MongoService.getDatastore();		
		Query<BlogPost> q = ds.createQuery(BlogPost.class);
		List<BlogPost> entities = q.asList();

		return entities;
	}



	public static long getCounts() {
		Datastore ds = MongoService.getDatastore();
		return ds.getCount(BlogPost.class);
	}

	public static void removePost(BlogPost post) {
		MongoService.getDatastore().delete(post);
	}

	public BlogPost loadPost(String key) {
		return null;

	}

}
