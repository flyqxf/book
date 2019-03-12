//禁止右键
document.oncontextmenu=function(){ 
  return false
}
//禁止选中
document.onselectstart=function(){ 
  return false
}
//禁止拖拽
document.ondragstart=function(){ 
  return false
}
//禁止复制
document.oncopy=function(){ 
  return false
}
//******************** 屏蔽右键 *********************** 
function click(e) { 
if (document.all) { 
if (event.button==1||event.button==2||event.button==3) { 
oncontextmenu='return false'; 
} 
} 
if (document.layers) { 
if (e.which == 3) { 
oncontextmenu='return false'; 
} 
} 
} 
if (document.layers) { 
document.captureEvents(Event.MOUSEDOWN); 
} 
document.onmousedown=click; 
document.oncontextmenu = new Function("return false;") 
//******************************************* 
document.onkeydown=function(evt){ 
e = window.event;
        // 「F5」
        if(e.keyCode == 116) {
            e.returnValue = false;
            return false;
        }
     // 「F12」
        if(e.keyCode == 123) {
            e.returnValue = false;
            return false;
        }
        // 「Alt + →」「Alt + ←」
        if ((e.altKey) && ((e.keyCode == 37) || (e.keyCode == 39))) {
            e.returnValue = false;
            return false;
        }
        // 「Backspace」
        if(e.keyCode == 8) {
            var src = e.srcElement;
            if(((src.tagName == "INPUT" && (src.type == "text" || src.type == "password")) || src.tagName == "TEXTAREA") && src.readOnly == false){
                return true;
            } else {
                e.returnValue = false;
                return false;
            }
        }
        // 「Ctrl + R」
        if((e.ctrlKey) && (e.keyCode == 82)) {
            e.returnValue = false;
            return false;
        }
        // 「 Ctrl + F5」
        if ((e.ctrlKey) && (e.keyCode == 116)) {
            e.returnValue = false;
            return false;
        }
        // 「Ctrl + K」
        if ((e.ctrlKey) && (e.keyCode == 75)) {
            e.returnValue = false;
            return false;
        }
        // 「Ctrl + Shift + T」
        if ((e.ctrlKey) && (e.shiftKey) && (e.keyCode == 84)) {
            e.returnValue = false;
            return false;
        }
        // 「Ctrl + N」
        if ((e.ctrlKey) && (e.keyCode == 78)) {
            e.returnValue = false;
            return false;
        }
} 