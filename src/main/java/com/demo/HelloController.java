package com.demo;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mail.MailService;

@Controller
@Configuration
@EnableAutoConfiguration
public class HelloController{

  
	

   // @RequestMapping(value = "/springexceptiontest/{name}", method = RequestMethod.GET)
 //   public String viewEdit(@PathVariable("name") final String name, Model model) {
  //      if (name.equals("null")) throw new ResourceNotFoundException();
  //      model.addAttribute("msg", name);
 // //      return "problem";
 //   }

	@Value("${name}")
    public String name;
	 
	
	public HelloController(){};
	

	
	@Autowired
	private MailService mail;
	private CompanyDao dao;
	
	@RequestMapping(value="/contact", method=RequestMethod.GET)
    public String contactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "Contact";
    }

    @RequestMapping(value="/contact", method=RequestMethod.POST)
    public String contactSubmit(@ModelAttribute Contact contact, Model model) throws MessagingException {
        System.out.println("email "+  contact.getEmail()  );
        System.out.println("to "+contact.getEmail());
        System.out.println("subject "+contact.getName());
        System.out.println("body " +contact.getMessage());
        mail.send(contact.getEmail(), contact.getName(), contact.getMessage());
        return "Contact";
    }
	
	
    
	//UserDao repository = context.getBean(UserDao.class);
	
   @RequestMapping({"/"})
    public String Hello() {
      // System.out.println(""+name);
     //  Company test=
      
    		//   dao.findAll();
    		//Company testcompany=dao.findOne("1");
    		//System.out.println(testcompany.getcompanyname());
    	//	System.out.println(testcompany.getidcompany());
    		
    		
      // System.out.println("another"+test);
     //  String test;
     //  Company comp=dao.findByCompanyName("Roosevelt");
    //   test=String.valueOf(comp.getIdCompany());
    //   System.out.println("here again "+test);
       return "Start";
   }

    public class NubeServerCustomization extends ServerProperties {

    	  @Override
    	  public void customize(ConfigurableEmbeddedServletContainer container) {

    	    super.customize(container);
    	    container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,
    	            "/404.html"));
    	    container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,
    	            "/jsp/500.jsp"));
    	    container.addErrorPages(new ErrorPage("/jsp/error.jsp"));
    	  }

    	}
   

    @Bean
    public ServerProperties getServerProperties() {
        return new NubeServerCustomization();
    }

  
    
}
