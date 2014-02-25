package com.freshie.site.db;

import java.net.UnknownHostException;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.freshie.site.Config;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoOptions;
import com.mongodb.ServerAddress;

public class MongoService {

	private static final Logger logger = LoggerFactory
			.getLogger(MongoService.class);

	private static Datastore datastore;

	/**
	 * Get data source handler
	 * 
	 * @return
	 */
	public static Datastore getDatastore() {
		if (datastore == null) {
			
			//get connection singlton
			System.setProperty("MONGO.POOLSIZE", Config.getValue("db_poolsize"));
			Mongo mongo = null;
			mongo = getClient();
			
			//set the pool size
			MongoOptions options = mongo.getMongoOptions();
			options.autoConnectRetry = true; 
			options.connectionsPerHost = Config.getInt("db_poolsize"); 
			
			//authentication
			logger.info("authenticating to target mongo db...");
			mongo.getDB(Config.getValue("db_blogdb")).authenticate(
					Config.getValue("db_username"),
					Config.getValue("db_password").toCharArray());
			
			//wrap it with morphia
			datastore = new Morphia().mapPackage("com.freshie.site.pojo")
					.createDatastore(mongo, Config.getValue("db_blogdb"));
		}

		return datastore;
	}

	/**
	 * connect to mongo
	 * 
	 * @return
	 */
	private static MongoClient getClient() {
		try {
			logger.info("connecting to mongodb server...");
			return new MongoClient(Arrays.asList(new ServerAddress(Config
					.getValue("db_server"), Integer.valueOf(Config
					.getValue("db_port")))));

		} catch (UnknownHostException uh) {
			logger.error("error occurs during connecting to mongodb server...");
			uh.printStackTrace();
		}
		return null;
	}

}
