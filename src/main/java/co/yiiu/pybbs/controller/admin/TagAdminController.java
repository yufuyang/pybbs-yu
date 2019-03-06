package co.yiiu.pybbs.controller.admin;

import co.yiiu.pybbs.model.AdminUser;
import co.yiiu.pybbs.model.Tag;
import co.yiiu.pybbs.model.Topic;
import co.yiiu.pybbs.service.TagService;
import co.yiiu.pybbs.util.FileUtil;
import co.yiiu.pybbs.util.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by tomoya.
 * Copyright (c) 2018, All Rights Reserved.
 * https://yiiu.co
 */
@Controller
@RequestMapping("/admin/tag")
public class TagAdminController extends BaseAdminController {

  @Autowired
  private TagService tagService;
  @Autowired
  private FileUtil fileUtil;
  @Autowired
  private Tag tag;


  @RequiresPermissions("tag:list")
  @GetMapping("/list")
  public String list(@RequestParam(defaultValue = "1") Integer pageNo, String name, Model model) {
    if (StringUtils.isEmpty(name)) name = null;
    Integer usrid=getAdminUser().getId();
    Integer roleId=getAdminUser().getRoleId();
    IPage<Tag> page = tagService.selectAll(pageNo, null, name);
    model.addAttribute("roleId",roleId);
    model.addAttribute("page", page);
    model.addAttribute("name", name);
    return "admin/tag/list";
  }

  @RequiresPermissions("tag:add")
  @GetMapping("/add")
  public String add() {
    return "admin/tag/add";
  }

  //添加标签
  @RequiresPermissions("tag:add")
  @PostMapping("/add")
  public String add(String name, String description, Integer topicCount) {

//    System.out.println(adminUser.getUsername());
    tag.setName(name);
    tag.setDescription(description);
    //tag.setTopicCount(topicCount);
    tag.setCreateId(getAdminUser().getId());
    tagService.insertTag(tag);
    return redirect("/admin/tag/list");
  }

  @RequiresPermissions("tag:edit")
  @GetMapping("/edit")
  public String edit(Integer id, Model model) {
    model.addAttribute("tag", tagService.selectById(id));
    return "admin/tag/edit";
  }
  //审核标签

  @RequiresPermissions("tag:check")
  @GetMapping ("/check")
  @ResponseBody
  public Result check(Integer id) {
      Tag tag=tagService.selectById(id);
      tag.setPass(!tag.getPass());
      tagService.update(tag);
      return success();
  }


  //编辑标签
  @RequiresPermissions("tag:edit")
  @PostMapping("/edit")
  public String update(Integer id, String name, String description, Integer topicCount) {
    Tag tag = tagService.selectById(id);
    tag.setName(name);
    tag.setDescription(description);
    tag.setTopicCount(topicCount);
    tagService.update(tag);
    return redirect("/admin/tag/list");
  }

  @RequiresPermissions("tag:delete")
  @GetMapping("/delete")
  @ResponseBody
  public Result delete(Integer id) {
    //Tag tag = tagService.selectById(id);
    //if (tag.getTopicCount() > 0) return error("标签还关联着话题，要先把相关联的话题都删了，这个标签才能删除");
    tagService.delete(id);
    return success();
  }

  // 同步标签的话题数
  @RequiresPermissions("tag:async")
  @GetMapping("/async")
  @ResponseBody
  public Result async() {
    tagService.async();
    return success();
  }
}
