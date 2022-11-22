package org.dream.firstAPI.Controllers;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {
    @GetMapping( "hello/")
    public static String getPage(){

        return "Hello from our API.....nerd";
    }

    @GetMapping(value = "/")
    public static String getPage1(){

        return "Hello from our API";
    }


}
