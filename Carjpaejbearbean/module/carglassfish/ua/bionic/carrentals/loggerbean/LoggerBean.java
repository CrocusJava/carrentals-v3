package carglassfish.ua.bionic.carrentals.loggerbean;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import org.apache.log4j.Logger;

public class LoggerBean {
	
	@AroundInvoke
	public Object log(InvocationContext context) throws Exception{
		Logger log=Logger.getLogger(context.getClass());
		log.info(context.getMethod().getDeclaringClass());
		log.info(context.getMethod().getName());
		log.info(context.getParameters());
		return context.proceed();
	}

}
