package com.example.controller;

import com.example.domain.Administrator;
import com.example.form.InsertAdministratorForm;
import com.example.form.LoginForm;
import com.example.service.AdministratorService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 管理者関連機能の処理の制御を行うコントローラ.
 */

@Controller
@RequestMapping("/")
public class AdministratorController {
    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private HttpSession session;

    /**
     * 管理者登録画面を表示する.
     *
     * @param form フォーム
     * @return 管理者登録画面
     */
    @GetMapping("/to-insert")
    public String toInsert(InsertAdministratorForm form) {
        return "administrator/insert";
    }

    /**
     * 管理者情報を登録する.
     *
     * @param form 管理者情報登録時に使用するフォーム
     * @return ログイン画面
     */
    @PostMapping("/insert")
    public String insert(InsertAdministratorForm form) {
        Administrator administrator = new Administrator();
        BeanUtils.copyProperties(form, administrator);
        administratorService.insert(administrator);
        return "redirect:/";
    }

    /**
     * ログイン画面にフォワードする.
     *
     * @param form ログイン時に使用するフォーム
     * @return ログイン画面
     */
    @GetMapping("/")
    public String toLogin(LoginForm form) {
        return "administrator/login";
    }

    /**
     * ログイン処理を行う.
     *
     * @param form  ログイン時に使用するフォーム
     * @param model エラーメッセージ格納用のリクエストスコープ
     * @return 失敗時は再度ログイン画面へ、成功時は顧客リストへ
     */
    @PostMapping("/login")
    public String login(LoginForm form, Model model) {
        Administrator administrator = administratorService.login(form.getMailAddress(), form.getPassword());

        if (administrator == null) {
            model.addAttribute("error", "メールアドレスまたはパスワードが不正です");
            return "administrator/login";
        }

        session.setAttribute("administratorName", administrator.getName());

        return "redirect:/employee/show-list";
    }

    /**
     * ログアウト.
     *
     * @param form フォーム
     * @return ログイン画面
     */
    @GetMapping("/logout")
    public String logout(LoginForm form) {
        session.invalidate();

        return "redirect:/";
    }
}
