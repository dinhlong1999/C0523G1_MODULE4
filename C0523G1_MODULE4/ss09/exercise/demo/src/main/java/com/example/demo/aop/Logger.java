package com.example.demo.aop;

import com.example.demo.model.Bill;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
public class Logger {
    private static  int count = 0;
    List<String> log = new ArrayList<>();
    //Ghi log đếm lượt khách
    @After("execution(* com.example.demo.controller.BookController.showList(..))")
    public void countVisitWeb(){
        count++;
        log.add("The numbers visit website " + count);
        System.out.println(log);
    }

    //Thực hiện log ra thông tin sau khi có sự thay đổi sách:
    @AfterReturning("execution(* com.example.demo.controller.BookController.saveBill(..))")
    public void RentSuccess(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        Bill bill = (Bill) args[1];
        log.add("The book had rent: " + bill.getBook().getName());
        System.out.println(log);
    }
    @AfterReturning("execution(* com.example.demo.controller.BookController.giveBook(..))")
    public void giveBook(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        Bill bill = (Bill) args[0];
        log.add("The book had given " + bill.getBook().getName());
        System.out.println(log);
    }
}
