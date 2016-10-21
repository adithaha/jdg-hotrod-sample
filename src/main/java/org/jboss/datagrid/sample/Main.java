package org.jboss.datagrid.sample;

import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private final static Logger LOGGER = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) {
		
		String host = "localhost:11222"; // can be multihost "host1:11222;host2:11222,..."
		String name = "default"; // default cache
		
		RemoteCacheManager cacheManager;
		RemoteCache<String, String> cache;
		
		LOGGER.info("initializing datagrid cache manager...");
		
		ConfigurationBuilder configBuilder = new ConfigurationBuilder();
		configBuilder.addServers(host);
		
		cacheManager =  new RemoteCacheManager(configBuilder.build());
		cache = cacheManager.getCache(name);
		LOGGER.info("initialization completed");
		
		LOGGER.info("");
		LOGGER.info("---putting data into cache---");
		
		LOGGER.info("putting 'key1' to cache");
		cache.put("key1", "value1");
		LOGGER.info("putting 'key2' to cache");
		cache.put("key2", "value2");
		LOGGER.info("putting 'key3' to cache");
		cache.put("key3", "value3");
		
		LOGGER.info("");
		LOGGER.info("---getting data from cache---");
		
		String result = cache.get("key1");
		LOGGER.info("getting 'key1' from cache '"+result+"'");
		result = cache.get("key2");
		LOGGER.info("getting 'key2' from cache '"+result+"'");
		result = cache.get("key3");
		LOGGER.info("getting 'key3' from cache '"+result+"'");
		
		LOGGER.info("");
		LOGGER.info("---removing data from cache---");
		
		LOGGER.info("removing 'key1' from cache");
		cache.remove("key1");
		LOGGER.info("removing 'key2' from cache");
		cache.remove("key2");
		LOGGER.info("removing 'key3' from cache");
		cache.remove("key3");
		
		LOGGER.info("");
		LOGGER.info("---finished---");
		
	}
	
	
	
}
