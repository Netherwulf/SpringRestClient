package netherwulf.springframework.springrestclient.controllers;

import netherwulf.springframework.springrestclient.services.ApiService;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ServerWebExchange;

@Controller
public class UserController {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(UserController.class);
    private ApiService apiService;

    public UserController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping({"", "/", "/index"})
    public String index(){
        return "index";
    }

    @PostMapping("/users")
    public String formPost(Model model, ServerWebExchange serverWebExchange){

        model.addAttribute(
                "users",
                apiService
                        .getUsers(serverWebExchange
                                    .getFormData()
                                    .map(data -> Integer.valueOf(data.getFirst("limit")))));
        return "userlist";
    }
}
