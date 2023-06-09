package org.example.mvc;

import org.example.mvc.controller.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class RequestMappingHandlerMapping implements HandlerMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    private Map<HandlerKey, Controller> mappings = new HashMap<>();


    void init() {
//        mapping.put("/", new HomeController());
        mappings.put(new HandlerKey("/users/form", RequestMethod.GET), new ForwardController("/user/form")); // 경로 밖에 지정
        mappings.put(new HandlerKey("/users", RequestMethod.GET), new UserListController()); // 경로 안에 지정
        mappings.put(new HandlerKey("/users", RequestMethod.POST), new UserCreateController()); // 경로 안에 지정

        mappings.keySet().forEach(path ->
                logger.info("url path[{}], controller: [{}]", path, mappings.get(path).getClass()));
    }



    @Override
    public Object findHandLer(HandlerKey handlerKey) {
        return mappings.get(handlerKey);
    }
}
