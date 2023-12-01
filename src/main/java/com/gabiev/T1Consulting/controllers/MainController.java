package com.gabiev.T1Consulting.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class MainController {

    @GetMapping("/chars/{str}")
    public Map<Character, Integer> chars(@PathVariable String str) {

        Map<Character, Integer> map = str.chars().mapToObj(i -> (char) i)
                .collect(Collectors.toMap((c) -> c, (c) -> 1, Integer::sum))
                .entrySet().stream().sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, n) -> o, LinkedHashMap::new));

        return map;
    }
}
