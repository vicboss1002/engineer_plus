package jp.co.engineer_plus.controller;

import jp.co.engineer_plus.form.BusinessPlanForm;
import jp.co.engineer_plus.form.LoginForm;
import jp.co.engineer_plus.service.EqServiceException;
import jp.co.engineer_plus.service.LoginService;
import jp.co.engineer_plus.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * ログイン制御コントローラ
 */
@Controller
@SessionAttributes(value = {
		"isLogin",
		"userId",
		"templateName"
})
public class LoginController {
	@Autowired
	private LoginService service;
	
    @ModelAttribute("loginForm")
    public LoginForm setUpLoginForm() {
    	return new LoginForm();
    }
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String getLogin(Model model) {
		return "login";
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String postLogin(@ModelAttribute("loginForm") LoginForm form,
			@ModelAttribute("templateName") String templateName,
			SessionStatus sessionStatus, Model model) {
		try {
			service.execute(form);
			model.addAttribute("userId", form.getUserId());
			model.addAttribute("isLogin", "true");
		} catch(EqServiceException e) {
			e.printStackTrace();
			sessionStatus.setComplete();
		}
		return templateName == null || templateName.isEmpty()? "login": "redirect:" + templateName;
	}
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String getLogout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "index";
	}
}
