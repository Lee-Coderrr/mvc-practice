package org.example.mvc.view;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
    private Object view;
    private Map<String, Object> model = new HashMap<>();

    public ModelAndView(Object view) {
        this.view = view;
    }

    public Map<String, Object> getModel() {
        return Collections.unmodifiableMap(model);
    }

    public String getViewName() {
        return (this.view instanceof String ? (String) this.view : null);
    }
}
