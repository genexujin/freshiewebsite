package com.freshie.site.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.freshie.site.db.BlogPostDAO;
import com.freshie.site.pojo.BlogPost;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/{resource}", method = RequestMethod.GET)
	public String home(Locale locale, Model model,
			@PathVariable String resource) {
		if (resource != null && resource.equals("home")) {
			return homePage(locale, model, 1);
		}
		return null;
	}
	
	@RequestMapping(value = "/{resource}/{pageNum}", method = RequestMethod.GET)
	public String homeWithPageNumber(Locale locale, Model model,
			@PathVariable String resource, @PathVariable int pageNum) {
		if (resource != null && resource.equals("home")) {
			return homePage(locale, model, pageNum);
		}
		return null;
	}

	private String homePage(Locale locale, Model model, int pageNum) {
		logger.info("Welcome home! The client locale is {}.", locale);
		List<BlogPost> blogPosts = getHomePosts(pageNum);
		long count = getHomePostsCount();

		model.addAttribute("posts", blogPosts);
		model.addAttribute("hotPosts", blogPosts);
		model.addAttribute("postCounts", count);
		model.addAttribute("currentPage", pageNum);

		return "home";
	}

	/**
	 * Home Blog posts
	 * 
	 * @return
	 */
	private List<BlogPost> getHomePosts(int pageNum) {

		List<BlogPost> blogPosts = BlogPostDAO.getPostsByPageNum(pageNum);
		
		return blogPosts;
	}
	
	/**
	 * Home Blog posts count
	 * 
	 * @return
	 */
	private long getHomePostsCount() {

		long count = BlogPostDAO.getCounts();
		
		return count;
	}

}
