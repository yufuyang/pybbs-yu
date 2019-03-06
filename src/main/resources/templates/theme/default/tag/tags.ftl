<#include "../layout/layout.ftl"/>
<@html page_title="板块" page_tab="tags">
<div class="row">
    <div class="col-md-9">
        <div class="panel panel-info">
            <div class="panel-body">
        <@tag_tags pageNo=pageNo pageSize=40>
            <div class="row" style="overflow: hidden;">

            <#list page.records as tag>
            <#--<div class="col-md-3 tag-item">-->
            <#--<#if tag.icon??>-->
            <#--<img src="${tag.icon}" width="24" class="sponsor-tag-img" alt="${tag.name}">-->
            <#--</#if>-->
            <#--<a href="/topic/tag/${tag.name}">-->
            <#--<span class="label label-info">${tag.name}</span>-->
            <#--</a>-->
            <#--<span class="text-muted">x ${tag.topicCount}</span>-->
            <#--<small class="excerpt text-muted" style="">${tag.description!}</small>-->
            <#--</div>-->
                <div class="row">
                    <div class="col-md-9">
                        <div class="panel panel-info">
                            <div class="panel-body">
                                <div class="row" style="overflow: hidden;">
                                    <div class="col-md-6" style="height: 7rem;">
                                        <div class="col-md-1">
                                            <img src="http://bbs.jeecms.com/r/cms/www/blue/bbs_forum/img/top/tie002.gif" style="height:4rem;margin-top:.5rem" class="sponsor-tag-img" alt="pretty good">
                                        </div>
                                        <div class="col-md-10" style="margin-left:1rem">
                                            <a href="/topic/tag/${tag.name}">
                                                <span class="label label-info">${tag.name}</span>
                                            </a>
                                            <span class="text-muted">x ${tag.topicCount}</span>
                                            <small class="excerpt text-muted" style="">${tag.description!}</small>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 hidden-xs">

                    </div>
                </div>
            </#list>

            </div>
          <#include "../components/paginate.ftl"/>
          <@paginate currentPage=page.current totalPage=page.pages actionUrl="/tags"/>
        </@tag_tags>
            </div>
        </div>
    </div>
    <div class="col-md-3 hidden-xs">
    <#if _user??>
      <#include "../components/user_info.ftl"/>
    <#else>
        <#include "../components/welcome.ftl"/>
    </#if>
    </div>
</div>
</@html>
