package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

// 自作class（formの入力内容が追加される）
import com.example.demo.Message;

@Controller
public class sampleController {

    // hello, world!
    @RequestMapping("/sample")
    public String sample() {
        return "sample";
    }

    // RequestMapping methodにGETかPOSTか指定する
    // 動的なサイト構成の場合、基本的にModelクラスは固定で入れる必要がある
    @RequestMapping(value = "/input", method = RequestMethod.GET)
    public String input(Model model) {
        // model.addAttribute
        // 第一引数：htmlテンプレート側で呼び出す際のオブジェクト名
        // 第二引数：上記オブジェクトに割り当てるインスタンス
        model.addAttribute("message", new Message());
        return "input";
    }

    // 前のページから値を受け取る際の設定。
    // ModelAttribute(前のページで指定したオブジェクト名) 型 命名
    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    public String confirm(@ModelAttribute("message") Message form) {
        return "confirm";
    }

}