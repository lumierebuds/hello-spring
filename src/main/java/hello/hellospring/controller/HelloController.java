package hello.hellospring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {

    // MVC
    @GetMapping("/hello")
    public String Hello(Model model) {

        model.addAttribute("data", "MTE WORLD");
        return "hello";
    }

    @GetMapping("/hello-mvc")
    public String HelloMvc(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("data", name);
        return "hello-mvc";
    }

    // API
    @GetMapping("/hello-string")
    @ResponseBody
    public String HelloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("/hello-api")
    @ResponseBody
    public Hello HelloHello(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}


