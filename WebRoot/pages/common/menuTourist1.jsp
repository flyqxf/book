<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
       <!-- Left-menu -->
       <s:hidden id="canReadChapter" name="canReadChapter"  value="%{#session.canReadChapter}" />
            <div id = "menu" class="m-left-menu" style="background:#fff3e1;">
                <div class="lefttop"><span></span>目录</div>
                    <dl class="leftmenu">
                     <s:iterator value="%{#session.BOOK_DIRECTORY}" status="result" id="bookChapter">
                        <dd>
                            <div class="title"> <span><img src="${pageContext.request.contextPath}/images/leftico01.png" /></span><s:property value='bookChapter' /></div>
                            <ul class="menuson">
                            <s:iterator value="%{#session.BOOK_DETAIL.get(#bookChapter)}" status="res" id="bookDetailBean">
                                <li>
                                    <div class="header"> <cite></cite> <a href="javascript:void(0);" onclick="dumpPart('${id}','<s:property value='bookChapter' />')" ><s:property value='part' /></a> <i></i> </div>
                                </li>
                                </s:iterator>
                            </ul>
                         
                        </dd>
                    </s:iterator>
                    </dl>
            </div><!-- Left-menu -->
            <script type="text/javascript">

$(function(){   
    //导航切换
    $(".menuson .header").click(function(){
        var $parent = $(this).parent();
        $(".menuson>li.active").not($parent).removeClass("active open").find('.sub-menus').hide();
        
        $parent.addClass("active");
        if(!!$(this).next('.sub-menus').size()){
            if($parent.hasClass("open")){
                $parent.removeClass("open").find('.sub-menus').hide();
            }else{
                $parent.addClass("open").find('.sub-menus').show(); 
            }
            
            
        }
    });
    
    // 三级菜单点击
    $('.sub-menus li').click(function(e) {
        $(".sub-menus li.active").removeClass("active");
        $(this).addClass("active");
    });
    
    $('.title').click(function(){
        var $ul = $(this).next('ul');
        $('dd').find('.menuson').slideUp();
        if($ul.is(':visible')){
            $(this).next('.menuson').slideUp();
        }else{
            $(this).next('.menuson').slideDown();
        }
    });
});

var dumpPart = function(id,bookChapter) {
    var url = "../tourist/touristAction.action";
   /*var canReadChapter = $("#canReadChapter").val();
   
  if(bookChapter != canReadChapter) {
    showInfoMessage("请登录后阅读！","系统提示");
    return;
  }*/
    // 迁移参数设定
    var params = new Array();
    params[0] = ["id", id];
    
    
    deptAction(url,params);
};
</script>