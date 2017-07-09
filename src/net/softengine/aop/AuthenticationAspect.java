package net.softengine.aop;

import net.softengine.security.SessionUtil;
import net.softengine.security.model.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.servlet.ModelAndView;

@Aspect
public class AuthenticationAspect {

    @Pointcut("within(@org.springframework.stereotype.Controller *) " +
            "&& !within(@org.springframework.stereotype.Controller net.softengine.security.AuthenticationController) ")
    public void allControllers() {
    }

    @Pointcut("execution(* *(..))")
    public void methodPointcut() {
    }

    @Around("allControllers() && methodPointcut()")
    public Object proceedToAction(ProceedingJoinPoint joinPoint) throws Throwable {
        User sessionUserInstance = SessionUtil.getSessionUser();
        /*Date lastActivity = sessionUserInstance.getLastActivity();
        if(( new Date().getTime()-lastActivity.getTime()) > 60000){
            return new ModelAndView("redirect:/");
        }
        sessionUserInstance.setLastActivity(new Date());*/
        if (sessionUserInstance instanceof User) {
            return joinPoint.proceed();
        } else {
            return new ModelAndView("redirect:/auth/logout.se?message=Only Employee, Member and Customer are allowed to access");
            //return new ModelAndView("redirect:/");
        }
    }

}
