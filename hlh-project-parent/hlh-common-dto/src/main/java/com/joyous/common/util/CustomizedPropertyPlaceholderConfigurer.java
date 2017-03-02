//package com.joyous.common.util;
//
//import com.lvmama.lvf.common.config.ConfigClient;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
//import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
//
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.Properties;
//import java.util.ServiceLoader;
//
//public class CustomizedPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
//
//	private static Map<String, Object> ctxPropertiesMap;
//
//    @Override
//    protected void processProperties(
//            ConfigurableListableBeanFactory beanFactoryToProcess,
//            Properties props) throws BeansException {
//        super.processProperties(beanFactoryToProcess, props);
//        ctxPropertiesMap = new HashMap<String, Object>();
//        for (Object key : props.keySet()) {
//            String keyStr = key.toString();
//            String value = props.getProperty(keyStr);
//            ctxPropertiesMap.put(keyStr, value);
//        }
//    }
//
//    public static <T> T getContextProperty(String name) {
//        return (T)ctxPropertiesMap.get(name);
//    }
//
//    public void reload(){
//    	this.loadFromProperties();
//    	ServiceLoader<ConfigClient> serviceLoader = ServiceLoader.load(ConfigClient.class);
//		Iterator<ConfigClient> iterators = serviceLoader.iterator();
//		while (iterators.hasNext()) {
//			this.loadFromCustomizedSources(iterators.next());
//		}
//    }
//
//    //原有的配置文件properties读取（铺打底数据）
//    private void loadFromProperties(){
//    	try{
//    		Properties result = mergeProperties();
////    		logger.error("reload properties!"+result);
//    		HashMap nc =new HashMap<String, Object>();
//    		nc.putAll(result);
//    		ctxPropertiesMap=nc;
//    	}catch(Exception ex){
//    		logger.error("reload properties error!",ex);
//    	}
//    }
//
//    //从自定义数据源读取配置，进行覆盖（增量更新）
//    private void loadFromCustomizedSources(ConfigClient configClient){
//    	try{
//    		Map<String, String> map = configClient.queryAll();
//    		if(!map.isEmpty()){
//    			ctxPropertiesMap.putAll(map);
//    		}
//    	}catch(Exception ex){
//    		logger.error("reload Customized properties error!",ex);
//    	}
//    }
//
//}
