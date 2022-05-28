package com.example.demo.controller;

import com.example.demo.dto.InventoryDto;
import com.example.demo.dto.SignupUserDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.ManufactureOrders;
import com.example.demo.entity.User;
import com.example.demo.service.ManufactureOrderService;
import com.example.demo.service.ManufactureService;
import com.example.demo.service.MyUserDetailService;
import com.example.demo.service.UserService;
import com.example.demo.userDetail.MyUserDetails;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Controller
public class UserController {

    @Autowired
    private MyUserDetailService myUserDetailService;

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ManufactureOrderService manufactureOrderService;

//    @GetMapping(value = "/get")
//    public String getallusers(Model model){
//        model.addAttribute("getuser",userService.getalluser());
//        return "myusers";
//    }

    @RequestMapping(value = "/postsignup",method = RequestMethod.POST)
    public ModelAndView addUser(@Valid @ModelAttribute SignupUserDto signupUserDto){
       UserDto userDto= myUserDetailService.CreateUser(signupUserDto);
       if(userDto==null){
           ModelAndView modelAndView=new ModelAndView("redirect:getsignup");
           modelAndView.addObject("UserAlreadyExists","Already Exists!");
           return modelAndView;
       }
       return new ModelAndView("login");
    }

    @RequestMapping(value = "/getsignup",method= RequestMethod.GET)
    public String SignUpForm(Model model){
        SignupUserDto signupUserDto=new SignupUserDto();
        model.addAttribute("myUser",signupUserDto);
    return "signup";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/login")
    public String Login(){
        return "login";
    }

    @RequestMapping(value = "/shivamdash",method = RequestMethod.GET)
    public String UserDashboard(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails myUserDetails=myUserDetailService.getUser(authentication.getName());
        UserDto userDto=modelMapper.map(myUserDetails,UserDto.class);
        model.addAttribute("userdashdata",userDto);
            return "userdashboard";
    }


    @RequestMapping(value = "/Manufacturedash",method = RequestMethod.GET)
    public String ManufactureDashboard(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails myUserDetails=myUserDetailService.getUser(authentication.getName());
        UserDto userDto=modelMapper.map(myUserDetails,UserDto.class);
        model.addAttribute("manufacturedashdata",userDto);
        Map<String, Integer> graphData = new TreeMap<>();
        graphData.put("2016", 147);
        graphData.put("2017", 1256);
        graphData.put("2018", 3856);
        graphData.put("2019", 8000);
        graphData.put("2020", 15000);
        graphData.put("2021", 20000);
        graphData.put("2022", 6000);
        model.addAttribute("chartData", graphData);
        model.addAttribute("barData", graphData);
        InventoryDto inventoryDto=new InventoryDto();
        model.addAttribute("addmanfinvent",inventoryDto);
        List<ManufactureOrders> manufactureOrders=manufactureOrderService.getAllorders(authentication.getName());
        model.addAttribute("orders",manufactureOrders);
        ManufactureOrders manufactureOrders1=new ManufactureOrders();
        model.addAttribute("manuorder",manufactureOrders1);
        return "ManufactureDashboard";
    }

    @RequestMapping(value = "/gett",method = RequestMethod.GET)
    public String my(@RequestParam(value = "id",required = false) String email,Model model){
        User user=userService.gett(email);
        String x=user.toString();
        model.addAttribute("abc",x);
        return "check";
    }

    @GetMapping("/get")
    public String ssss(){
        return "check";
    }

}
