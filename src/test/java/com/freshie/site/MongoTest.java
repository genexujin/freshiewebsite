package com.freshie.site;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.freshie.site.db.BlogPostDAO;
import com.freshie.site.db.MongoService;
import com.freshie.site.pojo.BlogPost;

public class MongoTest {
	
	static List<BlogPost> posts =  new ArrayList<BlogPost>();
	
	@BeforeClass
	public static void setUp() throws Exception {
		
		
		ArrayList tagList = new ArrayList();
		String[] tags = new String[] { "艺术", "新闻", "情感", "慈善" };
		for (String tag : tags)
			tagList.add(tag);
		
		for (int i = 0; i <= 104; i++) {
			BlogPost post = new BlogPost();
			post.setDate(new Date());
			post.setCommentCount(i);
			post.setDescription("At vero eos et accusamus et iusto odiodignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similiquesunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est etexpedita distinctio.");
			post.setContent("At vero eos et accusamus et iusto odiodignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similiquesunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est etexpedita distinctio.");
			post.setForwardCount(i);
			post.setImage("http://gene-img.oss-cn-qingdao.aliyuncs.com/shadow_mountain_01.jpg");
			post.setTitle("Holes everywhere!");
			post.setTags(tagList);
			post.setSourceName("Viral Nova");
			post.setSourceURL("http://www.viralnova.com/huge-sink-holes-everywhere/");
			post.setUrl("url"+i);
			posts.add(post);
			
//			System.out.println("added one record!");
		}
		
	}

	@AfterClass
	public static void tearDown() throws Exception {
//		MongoService.getDatastore().delete(MongoService.getDatastore().createQuery(BlogPost.class));
	}
	
	@Test
	public void saveAll(){
		for(BlogPost post: posts)
			BlogPostDAO.savePost(post);
		System.out.println("saved counts" + posts.size());
		assertEquals(posts.size(), BlogPostDAO.getCounts());
	}
	
	@Test
	public void laodAllTest() {
		
		List<BlogPost> entities = BlogPostDAO.getAllPosts();
		
		for(BlogPost post: entities) System.out.println(post.getId());
				
	}
	
	@Test
	public void laodAPageTest() {
		
		List<BlogPost> entities = BlogPostDAO.getPostsByPageNum(3);
//		System.out.println(entities.size());
		for(BlogPost post: entities) System.out.println(post.getUrl());
		
		BlogPost post1 = entities.get(0);
//		System.out.println(post1.getUrl());
		assertEquals(post1.getUrl().equals("url30"),true);
		assertEquals(entities.size(),10);
//		BlogPost post2 = datastore.get(BlogPost.class, post.getUrl());
//		assert(post2.getUrl().equals(post.getUrl()));
		
	}
	

}
