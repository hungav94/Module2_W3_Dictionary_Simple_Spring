package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DictionaryController {

    @GetMapping("/dictionary")
    public String index() {
        return "index";
    }

    @GetMapping("/result")
    public ModelAndView result(@RequestParam String eng, ModelMap map) {
        map.put("hello", "Xin chao");
        map.put("book", "Quyen vo");
        map.put("computer", "May tinh");
        map.put("how", "The nao");

        String result = (String) map.get(eng);
        ModelAndView modelAndView = null;
        if (result != null) {
            modelAndView = new ModelAndView("/result");
            modelAndView.addObject("result", result);
            modelAndView.addObject("eng", eng);
        }
        return modelAndView;
    }
}
