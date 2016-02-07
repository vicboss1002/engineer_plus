package jp.co.engineer_plus.controller;

import javax.servlet.Filter;

import jp.co.engineer_plus.entity.EpUser;
import jp.co.engineer_plus.repositories.EqUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * メインページ制御コントローラ
 */
@Controller
public class MainController {

	@Autowired
	private EqUserRepository userRepository;
	
	/**
	 * トップページへ遷移
	 * @return index.html
	 */
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	/**
	 * DB疎通テスト用
	 * @param model
	 * @return
	 */
	@RequestMapping("/test")
	public String test(Model model) {
		Iterable<EpUser> list = userRepository.findAll();
		model.addAttribute("results", list);
		return "test";
	}

	/**
	 * 文字エンコーディングのフィルターを返す
	 * @return フィルター
	 */
	@Bean
	public Filter characterEncodingFilter() {
		  CharacterEncodingFilter filter = new CharacterEncodingFilter();
		  filter.setEncoding("UTF-8");
		  filter.setForceEncoding(true);
		  return filter;
	}

}
