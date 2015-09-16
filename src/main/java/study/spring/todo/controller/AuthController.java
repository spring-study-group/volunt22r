package study.spring.todo.controller;

import javax.inject.Provider;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import study.spring.todo.auth.AuthParam;
import study.spring.todo.auth.AuthType;
import study.spring.todo.auth.impl.NativeAuthParam;
import study.spring.todo.model.User;
import study.spring.todo.service.UserService;

@Controller
public class AuthController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private Provider<NativeAuthParam> nativeParamProvider;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String tryLogin(HttpServletRequest request, @RequestParam String mail, @RequestParam String password){
		NativeAuthParam param = nativeParamProvider.get(); //POJO Mapping으로 해야함
		param.setMail(mail);
		param.setPassword(password);
		User user = userService.login(param).getUser();
		request.getSession().setAttribute("user", user.getMail());
		return "calendar";
	}
}
