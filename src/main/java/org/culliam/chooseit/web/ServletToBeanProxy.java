package org.culliam.chooseit.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Expose a Spring-managed bean to a Servlet defined in web.xml.
 * 
 * @author Culliam (william.cai@live.com)
 */
public class ServletToBeanProxy implements Servlet {

	private Servlet target;

	@Override
	public void destroy() {
		target.destroy();
	}

	@Override
	public ServletConfig getServletConfig() {
		return target.getServletConfig();
	}

	@Override
	public String getServletInfo() {
		return target.getServletInfo();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		String targetBean = config.getInitParameter("targetBean");
		String beanName = null;
		ApplicationContext ctx = getContext(config);
		if ((targetBean != null) && ctx.containsBean(targetBean)) {
			beanName = targetBean;
		} else if (targetBean != null) {
			throw new ServletException("targetBean '" + targetBean
					+ "' not found in context");
		} else {
			String targetClassString = config.getInitParameter("targetClass");
			if ((targetClassString == null) || "".equals(targetClassString)) {
				throw new ServletException(
						"targetClass or targetBean must be specified");
			}
			Class<?> targetClass;
			try {
				targetClass = Thread.currentThread().getContextClassLoader()
						.loadClass(targetClassString);
			} catch (ClassNotFoundException ex) {
				throw new ServletException("Class of type " + targetClassString
						+ " not found in classloader");
			}

			Map<?, ?> beans = BeanFactoryUtils.beansOfTypeIncludingAncestors(
					ctx, targetClass, true, true);

			if (beans.size() == 0) {
				throw new ServletException(
						"Bean context must contain at least one bean of type "
								+ targetClassString);
			}

			beanName = (String) beans.keySet().iterator().next();
		}
		Object object = ctx.getBean(beanName);

		if (!(object instanceof Servlet)) {
			throw new ServletException("Bean '" + beanName
					+ "' does not implement javax.servlet.Servlet");
		}

		target = (Servlet) object;
		// init:
		target.init(config);

	}

	@Override
	public void service(ServletRequest req, ServletResponse resp)
			throws ServletException, IOException {
		target.service(req, resp);
	}

	protected ApplicationContext getContext(ServletConfig config) {
		return WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
	}

}
