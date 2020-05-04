package ru.dilmar.restTest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guest")
public class ControllerRestTest {

    @GetMapping("/name/{id}")
    public String getMethod(@PathVariable int id){
    String[]  name={"a","b","c"};

        if ( (id >= name.length) || (id < 0) ) {
            throw new ControllerRestException("Student id not found - " + id);
        }

    return name[id];
}
}
