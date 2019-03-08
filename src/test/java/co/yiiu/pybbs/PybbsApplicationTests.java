package co.yiiu.pybbs;

import co.yiiu.pybbs.mapper.AdminUserMapper;
import co.yiiu.pybbs.model.AdminUser;
import co.yiiu.pybbs.model.Topic;
import co.yiiu.pybbs.service.TopicService;
import co.yiiu.pybbs.util.MyPage;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class PybbsApplicationTests {
  @Autowired
  TopicService topicService;
  @Autowired
  AdminUserMapper adminUserMapper;
  @Test
  public void contextLoads() {

  }

  @Test
  public void text(){
    AdminUser adminUser =adminUserMapper.text(1);
    System.out.println(adminUser);
  }

}
