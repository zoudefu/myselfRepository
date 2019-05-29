package ydfr;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.furui.ydfr.service.ILoginService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/applicationContext-*.xml"})
public class SpringTest {
 private static Logger logger=LoggerFactory.getLogger(SpringTest.class);
	 @Resource
	 private ILoginService loginService= null;
	 @Resource
	 private JmsTemplate  jmsTemplate;
	 @Test
	 public void  test(){
		 logger.error("logback日志");
		 Map<String, String> map=new HashMap<>();
		 map=loginService.selectUser("zhangsan", "123456");
		 String success=map.get("message");
		 System.out.println("测试Service和Dao跟spring的结合"+success);
	 }    
}
