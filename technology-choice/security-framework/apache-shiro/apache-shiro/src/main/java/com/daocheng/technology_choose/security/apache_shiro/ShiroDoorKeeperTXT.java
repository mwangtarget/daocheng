package com.daocheng.technology_choose.security.apache_shiro;

import javax.naming.AuthenticationException;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A Default TXT realm of Shiro
 *
 */
public class ShiroDoorKeeperTXT 
{
	private static final  Logger log = LoggerFactory.getLogger(ShiroDoorKeeperTXT.class);
    public static void main( String[] args )
    {

       
        Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro_txt.ini");
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

         Subject currentUser = SecurityUtils.getSubject();
     
         // let's login the current user so we can check against roles and permissions:
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken("bondtrader", "1235");
            token.setRememberMe(true);
            try {
                currentUser.login(token);
            } catch (UnknownAccountException uae) {
                log.info("There is no user with username of " + token.getPrincipal());
            } catch (IncorrectCredentialsException ice) {
                log.info("Password for account " + token.getPrincipal() + " was incorrect!");
            } catch (LockedAccountException lae) {
                log.info("The account for username " + token.getPrincipal() + " is locked.  " +
                        "Please contact your administrator to unlock it.");
            }
         
        }

        log.info("User [" + currentUser.getPrincipal() + "] logged in successfully.");

        //Test a positive role:
        if (currentUser.hasRole("enduser")) {
            log.info("You belong to end user");
        } else {
            log.info("Sorry, you're not end user");
        }

        //Test a positive permission (not instance-level)
        if (currentUser.isPermitted("trade:create")) {
            log.info("You can book trades");
        } else {
            log.info("Sorry, not allowed to book trades");
        }

     
        //all done - log out!
        currentUser.logout();

        System.exit(0);
    }
    
    
}
