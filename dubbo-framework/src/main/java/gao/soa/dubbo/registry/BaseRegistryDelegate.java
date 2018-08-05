package gao.soa.dubbo.registry;

import gao.soa.dubbo.spring.configBean.Registry;
import org.springframework.context.ApplicationContext;
import java.util.List;

/*
    这个类的作用就是负责把service配置的信息注册到注册中心
    那么这个注册中心到底是zookeeper还是redis,还是mongodb,其实就是在这个类中来实现
 */
public class BaseRegistryDelegate {
   public static boolean registry(String ref,ApplicationContext application) {
       
       //我们要获取registry标签对应的Registry实例类
       Registry registry = application.getBean(Registry.class);
       
       //这个就是注册中心的某一个实例类，这个实例类是有我们的配置文件来决定
       BaseRegistry baseRegistry = registry.getRegistrys().get(registry.getProtocol());
       
       return baseRegistry.registry(ref,application);
   }
   
   public static List<String> getRegistry(String id,ApplicationContext application) {

       //我们要获取registry标签对应的Registry实例类
       Registry registry = application.getBean(Registry.class);
       
       //这个就是注册中心的某一个实例类，这个实例类是有我们的配置文件来决定
       BaseRegistry baseRegistry = registry.getRegistrys().get(registry.getProtocol());
       
       return baseRegistry.getRegistry(id, application);
   }
}
