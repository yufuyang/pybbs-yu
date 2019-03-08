package co.yiiu.pybbs.mapper;

import co.yiiu.pybbs.model.AdminUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by tomoya.
 * Copyright (c) 2018, All Rights Reserved.
 * https://yiiu.co
 */
public interface AdminUserMapper extends BaseMapper<AdminUser> {

  List<Map<String, Object>> selectAll();
  void updateTag(@Param("tagId") Integer tagId);
  void updateAdminName(@Param("tagId") Integer tagId);
  AdminUser text(@Param("id") Integer id);
}
