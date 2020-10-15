package com.bankManagement.project.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulFilterConfiguration extends ZuulFilter {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public boolean shouldFilter() {
		//Checks a few conditions and accordingly return true or false as to allow filter or not
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		HttpServletRequest req = RequestContext.getCurrentContext().getRequest();
		logger.info(req.getRequestURI());
		System.out.println("HERE");
		return null;
	}

	@Override
	public String filterType() {
		// can be pre, post, error depending when you want the filter to run
		return "pre";
	}

	@Override
	public int filterOrder() {
		// priority for filters
		return 1;
	}

}
