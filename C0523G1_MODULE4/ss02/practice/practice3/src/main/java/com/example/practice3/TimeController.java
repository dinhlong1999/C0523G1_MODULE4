package com.example.practice3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {
    @GetMapping("/world-clock")
    public String getTimeByTimeZone(ModelMap modelMap, @RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city){
        //lấy ra time  hiện tại
        Date date = new Date();

        //Lấy ra time zone hiện tại
        TimeZone local = TimeZone.getDefault();

        //Lấy ra time zone của 1 thành phố cụ thể
        TimeZone locale = TimeZone.getTimeZone(city);

        //Tính thời gian hiện tại của 1 thành phố cụ thể
        long localTime = date.getTime() + (locale.getRawOffset() - locale.getRawOffset());

        //Cài đặt lại thời gain cho biến date thành thười gian hieện tại của 1 thành phố
        date.setTime(localTime);

        //Chuyển dữ liệu và gửi qua view
        modelMap.addAttribute("city",city);
        modelMap.addAttribute("date", date);

        return "index";





    }
}
