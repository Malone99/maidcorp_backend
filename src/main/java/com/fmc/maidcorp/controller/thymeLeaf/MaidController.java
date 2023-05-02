//package com.fmc.maidcorp.controller.thymeLeaf;
//
//import com.fmc.maidcorp.domain.MaidProfile;
//import com.fmc.maidcorp.service.impl.MaidProfileServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("maidcorp/api/")
//public class MaidController {
//
//    final MaidProfileServiceImpl service;
//    @Autowired
//
//    public MaidController(MaidProfileServiceImpl service) {
//        this.service = service;
//    }
//
//    @GetMapping("/findAll")
//    public ModelAndView getAllMaids(){
//        ModelAndView modelAndView = new ModelAndView("list_of_maids");
//        List<MaidProfile> allMaids=service.findAll();
//        modelAndView.addObject("allMaids", allMaids);
//        return  modelAndView;
//    }
//}
