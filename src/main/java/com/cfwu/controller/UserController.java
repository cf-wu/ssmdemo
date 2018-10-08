package com.cfwu.controller;

import com.alibaba.fastjson.JSONObject;
import com.cfwu.entity.User;
import com.cfwu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/getuser", method = RequestMethod.GET)
    public String getUser(@RequestParam("uid") int uid, HttpServletRequest request, Model model) {
        System.out.println("showname");
        User user = userService.getUserById(uid);
        if (user != null) {
            request.setAttribute("name", user.getUserName());
            model.addAttribute("mame", user.getUserName());
            return "showName";
        }
        request.setAttribute("error", "没有找到该用户！");
        return "error";
    }

    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public String getMessage(@RequestParam("id") int id, HttpServletRequest request, Model model) {
        User user = userService.getUserById(id);
        String json = JSONObject.toJSONString(user);
        JSONObject object = JSONObject.parseObject(json);
        return "error";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
 /*   @ResponseBody,produces = "text/plain;charset=utf-8"*/
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        User user = userService.getUserById(Integer.parseInt(id));
        String s = JSONObject.toJSON(user).toString();
        System.out.println("================> json is ======:" + s);
        PrintWriter writer = response.getWriter();
        writer.println(s);
        writer.flush();
        writer.close();
    }
}
