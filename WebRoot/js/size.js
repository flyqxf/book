var windowSize =function() {
  var width=$("#m-header").width();
    var height =$(window).height();
    var menuWidth = $("#menu").outerWidth(true);
    var headerHeight = $("#m-header").outerHeight(true);
    
    $("#m-content").height(height-headerHeight);
    //$("#menu").height(height-headerHeight);
    $("#menu").height($("#m-content").height());
    //$("#m-content").width(width);
    //$(".m-right-content").width(width-menuWidth);
    $(".m-right-content").height(height-headerHeight);
    
  var ddd =$(window).width();
  
  var w = width-ddd;
  var m;
//  if(w>0){
      $("#m-content").width(width);
      m=width-menuWidth;
//  } else {
//      $("#m-content").width(ddd);
//      m=ddd-menuWidth;
//  }

    $(".m-right-content").width(m);
    

    
};
$(window).resize(function() {
    windowSize();
  });
function key()//屏蔽Shift,Alt,Ctrl鍵函數
{
   if(event.shiftKey)
   {
       // window.close();//彈出關閉頁面對話框
         return false;//屏蔽Shift鍵
   } 
   else if(event.altKey)
   {
       // window.close();
         return false;//屏蔽Alt鍵
   } 
   else if(event.ctrlKey)
   {
        //window.close();
         return false;//屏蔽Ctrl鍵
   }
   else
   {
        return true;//其他鍵不屏蔽        
   }
}
document.onkeydown=key;//執行鍵盤按下激發事件key()
//if (window.Event)
//{
//   document.captureEvents(Event.MOUSEUP);
//}
function nocontextmenu() //屏蔽鼠標右鍵顯示菜單事件
{
       event.cancelBubble =true;
       event.returnValue = false;
       return false;
}
document.oncontextmenu = nocontextmenu;  // 按下鼠標右鍵nocontextmenu()事件激發 
                                         // IE5.0以上版本支持此事件調用方式
function norightclick(e)//屏蔽鼠標右鍵顯示菜單事件
{
    if (window.Event)
    {
         if (e.which == 2 || e.which == 3)
         return false;
    }
    else
    {
        if (event.button == 2 || event.button == 3)
        {
           event.cancelBubble = true
           event.returnValue = false;
           return false;
        }
    }
}
document.onmousedown = norightclick;   // 按下鼠標右鍵nocontextmenu()事件激發 
                                         // 非IE5.0以上版本支持此事件調用方式
window.history.forward(1);//屏蔽按下backspace鍵返回歷史頁功能