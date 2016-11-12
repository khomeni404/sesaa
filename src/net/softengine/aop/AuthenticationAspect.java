package net.softengine.aop;

import net.softengine.constant.SecurityConstants;
import net.softengine.security.SessionUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.servlet.ModelAndView;

@Aspect
public class AuthenticationAspect {

	@Pointcut("within(@org.springframework.stereotype.Controller *) " +
			"&& !within(@org.springframework.stereotype.Controller net.softengine.security.AuthenticationController) ")
	public void allControllers(){}

	@Pointcut("execution(* *(..))")
    public void methodPointcut() {}

	@Around("allControllers() && methodPointcut()")
	public Object proceedToAction(ProceedingJoinPoint joinPoint) throws Throwable {
        Object sessionUserInstance = SessionUtil.getSession().getAttribute(SecurityConstants.SESSION_USER);
//        if (sessionUserInstance instanceof Staff || sessionUserInstance instanceof Customer){
//            return joinPoint.proceed();
//        }else{
            return new ModelAndView("redirect:/");
//        }
    }

}
