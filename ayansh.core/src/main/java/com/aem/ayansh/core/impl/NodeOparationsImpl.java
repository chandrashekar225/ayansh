package com.aem.ayansh.core.impl;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.Session;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.ayansh.core.bean.NodeOprations;
import com.aem.ayansh.core.service.NodeOprationsI;
@Component(service=NodeOprationsI.class, immediate=true)
public class NodeOparationsImpl implements NodeOprationsI {
	protected static final Logger log=LoggerFactory.getLogger(NodeOparationsImpl.class);

	@Reference
	private ResourceResolverFactory resolverFactory;
	ResourceResolver resourceResolver = null;
	private Session session;
	Resource resource;
	String resourcePath = "/content/ayansh/en/jcr:content/employ";
	
	@Override
	public boolean registerEmployDetails(String firstName, String lastName, String userName, String password) {
		// TODO Auto-generated method stub
		
		boolean flag=false;
		
		try {
			resourceResolver=resolverFactory.getServiceResourceResolver(getSubServiceMap());
			session=resourceResolver.adaptTo(Session.class);
			resource=resourceResolver.getResource(resourcePath);
			
			java.util.Random r = new java.util.Random();

			int low = 10;
			int high = 1000;
			int result = r.nextInt(high - low) + low;

			String numberValues = "employ" + result;
			Node node=resource.adaptTo(Node.class);
			
			if (node!=null) {
				Node empRoot = node.addNode(numberValues, "nt:unstructured");
				empRoot.setProperty("firstName", firstName);
				empRoot.setProperty("lastName", lastName);
				empRoot.setProperty("userName", userName);
				empRoot.setProperty("password", password);
				session.save();
				flag = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if (session!=null) {
				session.logout();
			}
		}
		
		
		return flag;
	}

	private Map<String, Object> getSubServiceMap() {
		// TODO Auto-generated method stub
		Map<String, Object> serviceMap = null;
		try {
			serviceMap=new HashMap<String, Object>();
			serviceMap.put(ResourceResolverFactory.SUBSERVICE, "chandu");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			
		}
		return serviceMap;
	}

	@Override
	public boolean employLogin(String userName, String password) {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {
			resourceResolver=resolverFactory.getServiceResourceResolver(getSubServiceMap());
			session=resourceResolver.adaptTo(Session.class);
			resource=resourceResolver.getResource(resourcePath);
			Node node=resource.adaptTo(Node.class);
			NodeIterator nitr=node.getNodes();
			while (nitr.hasNext()) {
				Node cNode=nitr.nextNode();
				String username=cNode.getProperty("userName").getValue().getString();
				String pasword=cNode.getProperty("password").getValue().getString();
				Map<String, String> map=new HashMap<String, String>();
				map.put("user", username);
				map.put("pwd", pasword);
				if (map.containsValue(userName) && map.containsValue(password)) {
					flag=true;
					break;
				} else {
					flag=false;
				}
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public NodeOprations getNodeProperties() {
		// TODO Auto-generated method stub
		NodeOprations bean=null;
		try {
			resourceResolver=resolverFactory.getServiceResourceResolver(getSubServiceMap());
			resource=resourceResolver.getResource(resourcePath);
			log.info("resource---------------"+resource);
			
			Node node=resource.adaptTo(Node.class);
			
			String firstName=node.getProperty("firstName").getValue().getString();
			log.info("fname--------------"+firstName);
			String lastName=node.getProperty("lastName").getValue().getString();
			log.info("lastname--------------"+lastName);
			String username=node.getProperty("userName").getValue().getString();
			log.info("username--------------"+username);
			String password=node.getProperty("password").getValue().getString();
			log.info("pwd--------------"+password);
			
			bean=new NodeOprations();
			
			bean.setFirstName(firstName);
			bean.setLastName(lastName);
			bean.setUserName(username);
			bean.setPassword(password);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bean;
	}

	@Override
	public boolean getChildNodeProperties() {
		// TODO Auto-generated method stub
		try {
			resourceResolver=resolverFactory.getServiceResourceResolver(getSubServiceMap());
			resource=resourceResolver.getResource(resourcePath);
			Node node=resource.adaptTo(Node.class);
			NodeIterator nitr=node.getNodes();
			while(nitr.hasNext()) {
				Node parnode=nitr.nextNode();
				NodeIterator childNode=parnode.getNodes();
				while (childNode.hasNext()) {
					Node cNode=childNode.nextNode();
					NodeIterator lnode=cNode.getNodes();
					if (lnode.has) {
						
					}
					
				}
				
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

}
