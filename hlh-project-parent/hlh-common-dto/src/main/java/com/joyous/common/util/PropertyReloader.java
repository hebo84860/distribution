//package com.joyous.common.util;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//@Component
//public class PropertyReloader {
//
//	@Autowired(required=false)
//	private CustomizedPropertyPlaceholderConfigurer customizedPropertyPlaceholderConfigurer;
//
//	@Scheduled(initialDelay = 1 * 1000,fixedDelay = 5 * 60 * 1000)
//    public void reload(){
//		if(customizedPropertyPlaceholderConfigurer!=null){
//			customizedPropertyPlaceholderConfigurer.reload();
//		}
//	}
//
//}
