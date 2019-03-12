/*!
 * Html5方式上传文件
 */
    // 导入进度条定义
    var loader;
    // 导入文件大小定义
    var totalFileSize = 0;

    // 文件选择处理
    var fileSelected = function(maxSize, allowFileTypes, fileInfo) {
        // 初始化进度条状态
        reSetProgressValue();
        // 清除页面上显示保存路径
        $("#savePathTitle").text("");
        $("#saveFileNameId").text("");
        // 清除原有选择文件路径信息
        $("#fileSelectTxtId").text("");
        $("#uploadFilePathId").val("");
        // 文件大小检测预处理
        var sizeMsg = "";
        if (maxSize != undefined && !isNaN(maxSize)) {
            if (maxSize > 1024 * 1024) {
                sizeMsg = (Math.round(maxSize * 100 / (1024 * 1024)) / 100).toString() + 'MB';
            } else {
                sizeMsg = (Math.round(maxSize * 100 / 1024) / 100).toString() + 'KB';
            }
        } else {
            var msg = "未设置文件上传大小限制,请确认！";
            clearUploadFilePath();
            showInfoMessage(msg, "提示信息");
            return false;
        }
        // 文件类型检测预处理
        var allowTypes = new Array();
        if (allowFileTypes != undefined) {
            allowTypes = allowFileTypes.split(",");
        }
        if (allowTypes.length >= 1 && allowTypes[0] == ""){
            var msg = "未设置文件上传类型限制,请确认！";
            clearUploadFilePath();
            showInfoMessage(msg, "提示信息");
            return false;
        }
        // HTML5文件API操作
        var file = document.getElementById('uploadFileId').files[0];
        if (file) {
            // 实际选择文件大小
            var realFileSize = file.size;
            // 判断文件大小是否合法
            // 文件内容不存在情况
            if (realFileSize == 0) {
                var msg = "附件大小为0,请确认！";
                clearUploadFilePath();
                showInfoMessage(msg, "提示信息");
                return false;
            }
            // 文件大小超过规定限制情况
            if (realFileSize > maxSize){  
                var msg = "附件大小超过" + sizeMsg + ",请确认！";
                clearUploadFilePath();
                showInfoMessage(msg, "提示信息");
                return false;
            }
            // 判断文件类型是否合法
            var fileName = file.name;
            var fileType = fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();
            var checkFlag = false;
            for (key in allowTypes) {
                var type = allowTypes[key].toLowerCase();
                if (fileType != type) {
                    continue;
                } else {
                    checkFlag = true;
                }
            }
            if (!checkFlag){  
                var msg = "附件类型不匹配（" + allowFileTypes + "）,请确认！";
                clearUploadFilePath();
                showInfoMessage(msg, "提示信息");
                return false;
            }
        }
        $("#fileSelectTxtId").val(fileInfo);
    };

    // 文件上传处理
    var uploadFile = function(type, maxSize, acceptTypes) {
        
        var uploadFilePath = $("#uploadFilePathId").val();
        if (uploadFilePath != undefined && uploadFilePath =="") {
            // 初始化进度条状态
            reSetProgressValue();
            // 清除文件上传提示信息
            $("#uploadErrInfoId").text("");
            var file = document.getElementById('uploadFileId').files[0];
            if (file == null) {
                var msg = "文件未选择,请确认！";
                showInfoMessage(msg, "提示信息");
                return false;
            }
            var xhr = new XMLHttpRequest();
            var formData = new FormData();
            // 关联表单数据
            formData.append("upload", document.getElementById('uploadFileId').files[0]);
            formData.append("uploadType", type);
            formData.append("uploadMaxSize", maxSize);
            formData.append("uploadAcceptType", acceptTypes);
            // 追加监听事件
            xhr.upload.addEventListener("progress", uploadProgress, false);
            xhr.addEventListener("load", uploadComplete, false);
            xhr.addEventListener("error", uploadFailed, false);
            // 发送文件和表单自定义参数
            xhr.open("POST", "../uploadCmn/fileUploadAction.action");
            xhr.send(formData);
        } else {
            var msg = "文件已上传完毕！";
            showInfoMessage(msg, "提示信息");
            return false;
        }
    };

    // 上传进度联动处理
    var uploadProgress = function(evt) {
        // 设定上传文件大小
        totalFileSize = evt.total;
        if (evt.lengthComputable) {
            // 设定文件上传进度
            setProgressValue(evt.loaded);
        }
        else {
            reSetProgressValue();
            $("#uploadErrInfoId").text("无法计算上传进度百分比值！");
        }
    };

    // 上传成功响应处理
    var uploadComplete = function(evt) {
        // 服务断接收完文件返回的结果
        var jsonObj = jQuery.parseJSON(evt.target.responseText); 
        var uploadErrorInfo = jsonObj["uploadErrorInfo"];
        var uploadSaveName = jsonObj["uploadSaveName"];
        var uploadPath = jsonObj["uploadPath"];
        // 检测是否有异常错误
        if (uploadErrorInfo != undefined && uploadErrorInfo != "") {
            $("#uploadErrInfoId").text(uploadErrorInfo);
            // 初始化进度条状态
            reSetProgressValue();
        } else {
            if (uploadPath != undefined && uploadPath != "") {
                // 在页面上显示保存路径
                $("#uploadFilePathId").val(uploadPath);
            }
        }
    };

    // 上传失败
    var uploadFailed = function(evt) {
        var msg = "上传文件失败,请确认！";
        showInfoMessage(msg, "提示信息");
    };

    // 设定进度条状态
    var setProgressValue = function(val) {
        var upSize = val;
        if (upSize > totalFileSize) {
            upSize = totalFileSize;  
        }
        // 设定进度条显示信息
        loader.setProgress(upSize / totalFileSize);
        // 设定文件上传大小信息
        var size = "";
        if (upSize > 1024 * 1024) {
            size = (Math.round(upSize * 100 / (1024 * 1024)) / 100).toString() + 'MB';
        } else {
            size = (Math.round(upSize * 100 / 1024) / 100).toString() + 'KB';
        }
        loader.setValue(size);
    };

    // 重置进度条状态
    var reSetProgressValue = function(val) {
        // 清除文件大小信息
        loader.setValue("");
        // 重置进度条显示信息
        loader.setProgress(0);
    };

    // 清除文件选择框内文件路径内容
    var clearUploadFilePath = function() {
        var file = $("#uploadFileId");
        file.after(file.clone().val(""));
        file.remove();
    };

    // 文件选择按钮按下时激活文件上传按钮事件
    var fileSelect = function() {
        $("#uploadFileId").click();
    };