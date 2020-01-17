package me.zhengjie.modules.myTest.aopAnnotation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/new/")
public class ToIndex {
    @LogPrint(desc = "属性描述")
    @RequestMapping(value = "/toIndex", method = RequestMethod.GET)
    public ModelAndView toIndex(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return(mav);
    }
}