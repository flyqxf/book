/*
 * @(#)Constant.java
 */
package com.yuanneng.book.common.utils;

/**
 * Constant.java
 * 
 * 功 能： 所有的常量
 * 
 * <pre>
 * ver     修订日             作者            修订内容
 * 1.0     2016.03.29         meiqiong        新规做成
 * </pre>
 */
public class Constant {

    /**
     * 固定角色ID ：超级管理员
     */
    public static final String ROLE_NO_SUPER = "1";

    /**
     * 固定角色ID ：审计管理员
     */
    public static final String ROLE_NO_AUDIT = "2";

    /**
     * 固定角色ID ：普通用户
     */
    public static final String ROLE_NO_NORMAL = "3";

    /**
     * ACTION返回值 ：success1
     */
    public static final String SUCCESS1 = "success1";

    /**
     * ACTION返回值 ：error1
     */
    public static final String ERROR1 = "error1";

    /**
     * 用户状态 ：0(正常)
     */
    public static final String USER_STATUS_NORMAL = "0";

    /**
     * 超级管理员ID ：1
     */
    public static final String SUPPER_USER_ROLEID = "1";

    /**
     * 超级管理员用户的ID
     */
    public static final String SUPPER_USERID = "admin";

    /**
     * 超级管理员角色的ID
     */
    public static final String SUPPER_ROLE_ID = "1";

    /**
     * 审计管理员角色的ID
     */
    public static final String AUDIT_ROLE_ID = "2";

    /**
     * 普通管理员角色的ID
     */
    public static final String GENERAL_ROLE_ID = "3";

    /**
     * 成功提示信息session中的KEY
     */
    public static final String MSG_SUCCESS_MESSAGE = "successMsg";
    public static final String DIRECT_LOGIN_URL = "directLoginUrl";
    /**
     * 日志关键字：event
     */
    public static final String LOG_EVENT = "event";

    /**
     * 日志关键字：alert
     */
    public static final String LOG_ALERT = "alert";

    /**
     * 日志关键字：start
     */
    public static final String LOG_START = " start.";

    /**
     * 日志关键字：end
     */
    public static final String LOG_END = " end.";

    /**
     * 字符串：0
     */
    public static final String STRING_ZERO = "0";

    /**
     * 字符串：1
     */
    public static final String STRING_ONE = "1";

    /**
     * 字符串：2
     */
    public static final String STRING_TWO = "2";

    /**
     * 算法关键字：MD5
     */
    public static final String MD5 = "MD5";

    /**
     * 菜单Id：主页面
     */
    public static final String MENU_Z00 = "Z00";

    /**
     * 菜单Id：资产管理-->概况
     */
    public static final String MENU_A00 = "A00";

    /**
     * 菜单Id：资产管理-->新增
     */
    public static final String MENU_A01 = "A01";

    /**
     * 菜单Id：资产管理-->列表
     */
    public static final String MENU_A02 = "A02";

    /**
     * 菜单Id：任务管理-->概况
     */
    public static final String MENU_B00 = "B00";

    /**
     * 菜单Id：任务管理-->新增
     */
    public static final String MENU_B01 = "B01";

    /**
     * 菜单Id：任务管理-->查询
     */
    public static final String MENU_B02 = "B02";

    /**
     * 菜单Id：漏洞管理-->概况
     */
    public static final String MENU_C00 = "C00";

    /**
     * 菜单Id：漏洞管理-->查询
     */
    public static final String MENU_C01 = "C01";

    /**
     * 菜单Id：系统管理-->用户管理
     */
    public static final String MENU_D01 = "D01";

    /**
     * 菜单Id：系统管理-->版本信息
     */
    public static final String MENU_D10 = "D10";

    /**
     * 菜单Id：系统管理-->网络配置
     */
    public static final String MENU_D02 = "D02";

    /**
     * 菜单Id：系统管理-->存储管理
     */
    public static final String MENU_D03 = "D03";

    /**
     * 菜单Id：系统管理-->集群管理
     */
    public static final String MENU_D04 = "D04";

    /**
     * 菜单Id：系统管理-->系统更新
     */
    public static final String MENU_D05 = "D05";

    /**
     * 菜单Id：系统管理-->版本信息
     */
    public static final String MENU_D06 = "D06";

    /**
     * 菜单Id：任务管理-->任务概要
     */
    public static final String MENU_E01 = "E01";

    /**
     * 菜单Id：任务管理-->任务新增
     */
    public static final String MENU_E02 = "E02";

    /**
     * 菜单Id：任务管理-->任务查询
     */
    public static final String MENU_E03 = "E03";

    /**
     * 菜单Id：任务管理-->插件一览
     */
    public static final String MENU_E04 = "E04";

    /**
     * 普通关键字：unknown
     */
    public static final String UNKNOWN = "unknown";

    /**************************************/
    /**
     * SESSION保存信息KEY:编辑用户的信息
     */
    public static final String USER_INFO = "USER_INFO";

    /**
     * SESSION保存信息KEY:编辑用户的区分信息
     */
    public static final String USER_LAYOUT_DIVISION = "USER_LAYOUT_DIVISION";

    /**
     * SESSION保存信息KEY:编辑中的用户信息
     */
    public static final String EDITING_USER = "EDITING_USER";

    /**
     * SESSION保存信息KEY:是否显示用户的检索条件
     */
    public static final String USER_SHOW_CONDITION = "USER_SHOW_CONDITION";

    /**
     * SESSION保存信息KEY:组织机构(用户一览)
     */
    public static final String DIS_ORGID_KEY = "disOrgIdKey";

    /**
     * SESSION保存信息KEY：角色信息（用户一览）
     */
    public static final String US_ROLEID_KEY = "usRoleIdKey";

    /**
     * SESSION保存信息KEY：用户信息（用户一览）
     */
    public static final String US_USER_INFO_KEY = "usUserInfoKey";

    /**
     * SESSION保存信息KEY：密码找回的user
     */
    public static final String SESSION_FORGET_USER = "user";

    /**
     * SESSION保存信息KEY：密码找回的id
     */
    public static final String SESSION_FORGET_ID = "id";

    /**
     * SESSION保存信息KEY：角色统计信息
     */
    public static final String SESSION_ROLE_COUNT = "SESSION_ROLE_COUNT";

    /**
     * properties文件Key值：任务标志位保存路径
     */
    public static final String TASK_ID_PATH = "taskIdPath";

    /**
     * properties文件Key值：DES加密解密密匙
     */
    public static final String DESKey = "email.DESKey";

    /**
     * properties文件Key值：发送邮件邮箱的登录名
     */
    public static final String EMAIL_USERNAME = "email.userName";

    /**
     * properties文件Key值：发送邮件邮箱的密码
     */
    public static final String EMAIL_PASSWORD = "email.password";

    /**
     * properties文件Key值：邮箱SMTP服务器
     */
    public static final String EMAIL_SMTP = "email.smtp";

    /**
     * properties文件Key值：邮箱主题
     */
    public static final String EMAIL_TITLE = "email.title";

    /**
     * properties文件Key值：邮箱内容-->值为HTML格式的超链接
     */
    public static final String EMAIL_CONTENT = "email.content";

    /**
     * properties文件Key值：邮箱内容-->发送者的显示内容
     */
    public static final String EMAIL_FROM_PERSONAL = "email.from.personal";

    /**
     * properties文件Key值：邮箱内容-->重置密码的action
     */
    public static final String EMAIL_ACTION = "email.action";

    /**
     * SESSION保存信息KEY：角色信息
     */
    public static final String RL_ROLE_INFO_KEY = "rlRoleInfoKey";

    /**
     * SESSION保存信息KEY:UVO(登录用户信息)
     */
    public static final String UVO = "LOGIN_UVO";

    /**
     * SESSION保存信息KEY:SUBSCRIBE_LIST(漏洞订阅的检索结果)
     */
    public static final String SUBSCRIBE_LIST = "SUBSCRIBE_LIST";

    /**
     * SESSION保存信息KEY:POOLHOLE_LIST(漏洞管理机能的检索结果)
     */
    public static final String POOLHOLE_LIST = "POOLHOLE_LIST";

    /**
     * SESSION保存信息KEY:POOLHOLE_CONDITION(漏洞管理机能的检索条件)
     */
    public static final String POOLHOLE_CONDITION = "POOLHOLE_CONDITION";

    /**
     * SESSION保存信息KEY:POOLHOLE_IS_FROM_TASK(是否是任务机能迁移)
     */
    public static final String POOLHOLE_IS_FROM_TASK = "POOLHOLE_IS_FROM_TASK";

    /**
     * SESSION保存信息KEY:POOLHOLE_ONE_INFO(漏洞管理机能的一条资产的所有漏洞信息)
     */
    public static final String POOLHOLE_ONE_INFO = "POOLHOLE_ONE_INFO";

    /**
     * SESSION保存信息KEY:POOLHOLE_ONE_INFO(返回任务列表时的保留值)
     */
    public static final String POOLHOLE_INDEX_BAK = "POOLHOLE_INDEX_BAK";

    /**************************************/

    /*************************** 资产审核页面 **********************************/
    public static final String SCAN_REPLACE_ENTITY = "SCAN_REPLACE_ENTITY";

    public static final String SCAN_REPLACE_LIST = "SCAN_REPLACE_LIST";

    /*************************************************************/

    // add qin

    /** 数值 0 */
    public static final int NUM_0 = 0;

    /** 数值 -1 */
    public static final int NUM_MINUS_1 = -1;

    /** 数值 1 */
    public static final int NUM_1 = 1;

    /** 数值 5 */
    public static final int NUM_5 = 5;

    /** 数值 7 */
    public static final int NUM_7 = 7;

    /** 数值 8 */
    public static final int NUM_8 = 8;

    /** 数值 10 */
    public static final int NUM_10 = 10;

    /** 数值 15 */
    public static final int NUM_15 = 15;

    /** 数值 17 */
    public static final int NUM_17 = 17;

    /** 数值 20 */
    public static final int NUM_20 = 20;

    /** 数值 32 */
    public static final int NUM_32 = 32;

    /** 数值 1000 */
    public static final int NUM_1000 = 1000;

    /**
     * 列表显示件数：20
     */
    public static final String LIST_ROW_LIMIT_20 = "20";

    /**
     * 资产发现列表检索结果SESSION保存主键：A101ListResult
     */
    public static final String SESSION_A101LIST_RESULT = "A101ListResult";

    /**
     * 资产发现页面查询条件SESSION
     */
    public static final String SESSION_A101SEARCH_CONDITION = "A101SearchCondition";

    /**
     * 字符串：00
     */
    public static final String STRING_DOUBLE_ZERO = "00";

    /** 字符串 100 */
    public static final String STRING_100 = "100";

    /** 任务检索条件取得ID（session用） */
    public static final String SESSION_CONDITION = "SESSION_CONDITION";

    /** 扫描类型取得ID（session用） */
    public static final String SESSION_POLICY_LIST = "SESSION_POLICY_LIST";

    /** 工具取得ID（session用） */
    public static final String SESSION_TOOL_LIST = "SESSION_TOOL_LIST";

    /** 任务检索结果取得ID（session用） */
    public static final String SESSION_LOOPHOLE_SELECT_LIST = "SESSION_LOOPHOLE_SELECT_LIST";

    /** 资产检索结果取得ID（session用） */
    public static final String SESSION_ASSET_SELECT_LIST = "SESSION_ASSET_SELECT_LIST";

    /**
     * message的补足文字列:任务名称
     */
    public static final String MSG_ADD_TASK_NAME = "任务名称";

    /**
     * message的补足文字列:暂停
     */
    public static final String MSG_ADD_PAUSE = "暂停";

    /**
     * message的补足文字列:停止
     */
    public static final String MSG_ADD_STOP = "停止";

    /**
     * 文件后缀(.txt)
     */
    public static final String FILE_EXTENSION_TXT = "txt";

    /**
     * 文件后缀(.csv)
     */
    public static final String FILE_EXTENSION_CSV = "csv";

    /**
     * 文件后缀(.xlsx)
     */
    public static final String FILE_EXTENSION_XLSX = "xlsx";

    /**
     * 文件后缀(.xls)
     */
    public static final String FILE_EXTENSION_XLS = "xls";

    /**
     * 工具ID取得key
     */
    public static final String REQUEST_TOOL_ID = "toolId";

    /**
     * Nessus的URL
     */
    public static final String NESSUS_URL = "nessusUrl";

    /**
     * Nessus的USER
     */
    public static final String NESSUS_USER = "userName";

    /**
     * Nessus的PWD
     */
    public static final String NESSUS_PWD = "passWord";

    /**
     * Nessus的ENCODING
     */
    public static final String NESSUS_ENCODING = "ecoding";

    /**
     * Nessus的结果保存路径
     */
    public static final String NESSUS_FILEPATH_OUTPUT = "path";

    /**
     * Nessus的结果区分（任务扫描结果）
     */
    public static final String NESSUS_RESULT_SCAN = "scan";

    /**
     * Nessus的结果区分（状态信息）
     */
    public static final String NESSUS_RESULT_INFO = "info";

    /**
     * Nessus的结果区分（状态）
     */
    public static final String NESSUS_RESULT_STATUS = "status";

    /**
     * Nessus的结果区分（id）
     */
    public static final String NESSUS_RESULT_ID = "id";

    /**
     * Nessus任务执行结果（empty:创建）
     */
    public static final String NESSUS_TASK_EMPTY = "empty";

    /**
     * Nessus任务执行结果（completed:执行终了）
     */
    public static final String NESSUS_TASK_COMPLETED = "completed";

    /**
     * Nessus任务执行结果（running:正在执行）
     */
    public static final String NESSUS_TASK_RUNNING = "running";

    /**
     * Nessus任务执行结果（paused:暂停）
     */
    public static final String NESSUS_TASK_PAUSED = "paused";

    /**
     * Nessus任务执行结果（canceled:停止）
     */
    public static final String NESSUS_TASK_CANCELED = "canceled";

    /**
     * Nessus任务执行结果（aborted:异常）
     */
    public static final String NESSUS_TASK_ABORTED = "aborted";

    /**
     * Nessus任务执行结果（error:错误）
     */
    public static final String NESSUS_TASK_ERROR = "error";

    public static final String NESSUS_TASK_FILEUPLOAD = "fileuploaded";

    /**
     * Timer监听参数取得key的前缀
     */
    public static final String TIMER = "timer";

    /**
     * Timer监听参数取得key（漏洞扫描）
     */
    public static final String TIMER0 = "timer0";

    /**
     * Timer监听参数取得key（资产扫描）
     */
    public static final String TIMER1 = "timer1";

    /**
     * Timer监听参数取得key（资产定时计划）
     */
    public static final String TIMER2 = "timer2";

    /**
     * Nessus最大同时执行任务数
     */
    public static final String NESSUS_TASK_MAX_CNT = "runningTaskMaxCount";

    /**
     * 资产发现表登录共通Service
     */
    public static final String SERVICE_ASSETCOMMON = "assetCommonService";

    /**
     * 资产发现表登录共通Service
     */
    public static final String SERVICE_ASSETSERVICE = "assetScanService";

    /**
     * 资产共通Service
     */
    public static final String SERVICE_COMMONSERVICE = "commonService";

    /**
     * 扫描状态监视Service类的方法名
     */
    public static final String METHOD_EXCUTE = "excute";

    /**
     * 任务检索DAO
     */
    public static final String DAO_SECCHECK = "secCheckDao";

    /**
     * 漏洞登录DAO
     */
    public static final String DAO_LOOPHOLE = "loopHoleDao";

    /**
     * 资产扫描DAO
     */
    public static final String DAO_SCAN = "assetScanDao";

    /**
     * 任务DAO
     */
    public static final String DAO_TASK = "taskDao";

    /**
     * 执行中任务ID列表获取key
     */
    public static final String TASK_ID_LIST = "taskIdArr";

    /**
     * 执行中任务ID列表获取key
     */
    public static final String TASK_ID = "taskId";

    /**
     * 执行中任务ID列表获取key
     */
    public static final String FILEPATH = "filePath";

    /**
     * message的编号:BOOKD0002I 密码重置成功信息
     */
    public static final String BOOKD0002I = "BOOKD0002I";

    /**
     * message的编号:BOOKD0003I 密码重置失败信息
     */
    public static final String BOOKD0003I = "BOOKD0003I";

    /**
     * message的编号:BOOKD0001E 许可IP不匹配或不存在
     */
    public static final String BOOKD0003E = "BOOKD0003E";

    /**
     * message的编号:BOOKD0004E 该{0}已存在，请更换{0}。
     */
    public static final String BOOKD0004E = "BOOKD0004E";

    /**
     * message的编号:用户没有设置角色
     */
    public static final String BOOKD0006E = "BOOKD0006E";

    /**
     * message的编号:两次输入密码不一致，请重新输入！
     */
    public static final String BOOKD0008E = "BOOKD0008E";

    /**
     * message的编号:新旧密码不能相同
     */
    public static final String BOOKD0009E = "BOOKD0009E";

    /**
     * message的编号:BOOKD0010E {0}和{1}错误
     */
    public static final String BOOKD0010E = "BOOKD0010E";

    /**
     * message的编号:BOOKD0011E 验证码错误
     */
    public static final String BOOKD0011E = "BOOKD0011E";

    /**
     * message的编号:BOOKD0012E 用户状态被锁定
     */
    public static final String BOOKD0012E = "BOOKD0012E";

    /**
     * message的编号:BOOKD0013E 用户账号过期
     */
    public static final String BOOKD0013E = "BOOKD0013E";

    /**
     * message的编号:BOOKD0014I 给邮箱发送了密码
     */
    public static final String BOOKD0014I = "BOOKD0014I";

    /**
     * message的编号:BOOKD0016E 会话超时。
     */
    public static final String BOOKD0016E = "BOOKD0016E";

    /**
     * message的编号:BOOKD0017E 密码复杂度验证。
     */
    public static final String BOOKD0017E = "BOOKD0017E";

    /**
     * message的编号:BOOKD0018E 密码输入错误
     */
    public static final String BOOKD0018E = "BOOKD0018E";

    /**
     * message的编号:BOOKD0019I 密码修改成功
     */
    public static final String BOOKD0019I = "BOOKD0019I";

    /**
     * message的编号:BOOKD0020I 用户更新成功
     */
    public static final String BOOKD0020I = "BOOKD0020I";

    /**
     * message的编号:BOOKD0021E 用户更新失败
     */
    public static final String BOOKD0021E = "BOOKD0021E";

    /**
     * message的编号:BOOKD0022E 同样的用户存在
     */
    public static final String BOOKD0022E = "BOOKD0022E";

    /**
     * message的编号:BOOKB0003E 该任务不存在，请确认后重新操作。
     */
    public static final String BOOKB0003E = "BOOKB0003E";

    /**
     * message的编号:BOOKB0006E 该当任务没有被执行，不能执行{0}操作。
     */
    public static final String BOOKB0006E = "BOOKB0006E";

    /**
     * message的编号:BOOKB0007E 该当任务正在被执行，不能被再次执行。
     */
    public static final String BOOKB0007E = "BOOKB0007E";

    /**
     * 
     * message的编号:BOOKB0008I 执行对象中包含其他任务正在执行的IP，是否继续执行？
     */
    public static final String BOOKB0008I = "BOOKB0008I";

    /**
     * 
     * message的编号:BOOKB0010E 执行任务数不能大于{0}个。
     */
    public static final String BOOKB0010E = "BOOKB0010E";

    /**
     * 
     * message的编号:BOOKB0012E 任务扫描执行失败。
     */
    public static final String BOOKB0012E = "BOOKB0012E";

    /**
     * 
     * message的编号:BOOKB0013E Nussus任务创建失败。
     */
    public static final String BOOKB0013E = "BOOKB0013E";

    /**
     * 
     * message的编号:BOOKB0014E Nussus任务状态取得失败。
     */
    public static final String BOOKB0014E = "BOOKB0014E";

    /**
     * 
     * message的编号:BOOKB0015E 执行对象的IP范围格式不正确。
     */
    public static final String BOOKB0015E = "BOOKB0015E";

    /**
     * 
     * message的编号:BOOKB0016E 任务暂停失败。
     */
    public static final String BOOKB0016E = "BOOKB0016E";

    /**
     * 
     * message的编号:BOOKB0017E 任务停止失败。
     */
    public static final String BOOKB0017E = "BOOKB0017E";

    /**
     * 
     * message的编号:BOOKB0018E 任务删除失败。
     */
    public static final String BOOKB0018E = "BOOKB0018E";

    /**
     * message的编号:BOOKB0019E 输入的IP范围包含IP数量大于254个，是否强制执行？
     */
    public static final String BOOKB0019E = "BOOKB0019E";

    /**
     * message的编号:BOOKB0019E 输入的IP包含权限范围外的IP并且IP数量大于254个，是否强制执行？
     */
    public static final String BOOKB0020E = "BOOKB0020E";

    /**
     * 横线：-
     */
    public static final String HORIZONTAL_LINE = "-";

    /**
     * 点(半角)："."
     */
    public static final String DOT = ".";

    /**
     * 逗号(半角)：","
     */
    public static final String COMMA = ",";

    /**
     * Nessus CSV文件分隔符
     */
    public static final String NESSUS_REX = "\",\"";

    /**
     * 空字符串：""
     */
    public static final String STRING_BLANK = "";

    /**
     * 冒号：":"
     */
    public static final String COLON = ":";

    /**
     * 字符串中的双引号："\""
     */
    public static final String DOUBLE_QUOTE = "\"";

    /**
     * 字符串：左右小括号
     */
    public static final String BRACKETS = "()";

    /**
     * 字符串：左小括号
     */
    public static final String LEFT_BRACKET = "(";

    /**
     * 字符串：右小括号
     */
    public static final String RIGHT_BRACKET = ")";

    /**
     * 空格
     */
    public static final String STRING_SPACE = "&nbsp;";

    /**
     * 换行
     */
    public static final String STRING_ENTER = "<br>";

    /**
     * 斜线:/
     */
    public static final String VIRGULE = "/";

    /**
     * 下划线:_
     */
    public static final String UNDERLINE = "_";

    /**
     * Nessus风险等级（Critical）
     */
    public static final String NESSUS_RISK_CRITICAL = "Critical";

    /**
     * Nessus风险等级（Serious）
     */
    public static final String NESSUS_RISK_SERIOUS = "Serious";

    /**
     * Nessus风险等级（High）
     */
    public static final String NESSUS_RISK_HIGHT = "High";

    /**
     * Nessus风险等级（Medium）
     */
    public static final String NESSUS_RISK_MEDIUM = "Medium";

    /**
     * Nessus风险等级（Low）
     */
    public static final String NESSUS_RISK_LOW = "Low";

    /**
     * Nessus风险等级（None）
     */
    public static final String NESSUS_RISK_NONE = "None";

    /**
     * 风险等级（Serious）
     */
    public static final String RISK_SERIOUS = "0";

    /**
     * 风险等级（High）
     */
    public static final String RISK_HIGHT = "1";

    /**
     * 风险等级（Medium）
     */
    public static final String RISK_MEDIUM = "2";

    /**
     * 风险等级（Low）
     */
    public static final String RISK_LOW = "3";

    /**
     * 查询列表显示标识：0（不显示）
     */
    public static final String LIST_NOT_DISPLAY_FLAG = "0";

    /**
     * 查询列表显示标识：1（显示）
     */
    public static final String LIST_DISPLAY_FLAG = "1";

    /**
     * 文件上出处理种类：1（资产批量导入）
     */
    public static final String UPLOAD_TYPE_FLAG_ONE = "1";

    /**
     * 文件上出处理种类：2（安全监测扫描IP地址选择）
     */
    public static final String UPLOAD_TYPE_FLAG_TWO = "2";

    /**
     * 文件上出处理种类：3（资产扫描IP地址选择）
     */
    public static final String UPLOAD_TYPE_FLAG_THREE = "3";

    /**
     * 文件上出处理种类：4（任务新增扫描IP地址选择）
     */
    public static final String UPLOAD_TYPE_FLAG_FOUR = "4";

    /**
     * 文件上出处理种类：5（任务新增扫描URL地址选择）
     */
    public static final String UPLOAD_TYPE_FLAG_FIVE = "5";

    /**
     * 页面项目管理ID：A0001（资产状态）
     */
    public static final String CODE_LIST_A0001 = "A0001";

    /**
     * 页面项目管理ID：A0002（是否重要资产）
     */
    public static final String CODE_LIST_A0002 = "A0002";

    /**
     * 页面项目管理ID：A0003（上下线状态）
     */
    public static final String CODE_LIST_A0003 = "A0003";

    /**
     * 页面项目管理ID：A0004（文件导出类型）
     */
    public static final String CODE_LIST_A0004 = "A0004";

    /**
     * 页面项目管理ID：A0005（文件分隔符）
     */
    public static final String CODE_LIST_A0005 = "A0005";

    /**
     * 页面项目管理ID：A0006（获取方式）
     */
    public static final String CODE_LIST_A0006 = "A0006";

    /**
     * 页面项目管理ID：A0007（指纹认证）
     */
    public static final String CODE_LIST_A0007 = "A0007";

    /**
     * 页面项目管理ID：B0002（任务执行状态）
     */
    public static final String CODE_LIST_B0002 = "B0002";

    /**
     * 页面项目管理ID：D0001（各大权限）
     */
    public static final String CODE_LIST_D0001 = "D0001";

    /**
     * 页面项目管理ID：Z0001（操作系统）
     */
    public static final String CODE_LIST_Z0001 = "Z0001";

    /**
     * 页面项目管理ID：Z0002（服务类型）
     */
    public static final String CODE_LIST_Z0002 = "Z0002";

    /**
     * 页面项目管理ID：E0001（任务类型）
     */
    public static final String CODE_LIST_E0001 = "E0001";

    /**
     * 页面项目管理ID：E0002（任务执行状态）
     */
    public static final String CODE_LIST_E0003 = "E0003";

    /**
     * 指纹认证判断值：IPV4
     */
    public static final String FINGER_IDENTIFY_IPV4 = "IPV4";

    /**
     * 指纹认证判断值：HOSTNAME
     */
    public static final String FINGER_IDENTIFY_HOSTNAME = "HOSTNAME";

    /**
     * 指纹认证判断值：MAC
     */
    public static final String FINGER_IDENTIFY_MAC = "MAC";

    /**
     * 指纹认证判断值：VENDOR
     */
    public static final String FINGER_IDENTIFY_VENDOR = "VENDOR";

    /**
     * 指纹认证判断值：OS
     */
    public static final String FINGER_IDENTIFY_OS = "OS";

    /**
     * 指纹认证判断值：OSVERSION
     */
    public static final String FINGER_IDENTIFY_OSVERSION = "OSVERSION";

    // add mei
    /**
     * properties值：DB:schema
     */
    public static final String SCHEMA = "schema";

    /**
     * properties值：页面显示:行数
     */
    public static final String ROW = "row";

    /**
     * properties值：检索的最大的数据量
     */
    public static final String MAX_RECORD = "maxRecord";

    /**
     * properties值：页面找不到的绝对路径
     */
    public static final String NOT_FOUND_PATH = "notFoundPath";

    /**
     * properties值：发生系统错误的绝对路径
     */
    public static final String ERROR_PATH = "errorPath";

    /**
     * properties值：不能访问的文件夹
     */
    public static final String UNACCESS_FOLDERS = "unaccessFolders";

    /**
     * properties值：重设密码首页地址
     */
    public static final String RESET_PASSWORD_URL = "resetPasswordUrl";

    /**
     * properties值：重设密码提交地址
     */
    public static final String RESET_PASSWORD_SUBMIT_URL = "resetPasswordSubmitUrl";

    /**
     * properties值：Login首页地址
     */
    public static final String LOGIN_URL = "loginUrl";

    /**
     * properties值：用户登录地址
     */
    public static final String USER_LOGIN_URL = "userLoginUrl";

    /**
     * properties值：验证码图片URL
     */
    public static final String AUTH_CODE_URL = "authCodeUrl";

    /**
     * properties值：忘记密码URL
     */
    public static final String FORGET_PASSWORD_URL = "forgetPasswordUrl";

    /**
     * properties值：找回密码URL
     */
    public static final String FIND_PASSWORD_URL = "findPasswordUrl";

    /**
     * properties值：session超时的时候login地址
     */
    public static final String SESSION_TIMEOUT_LOGIN_URL = "sessionTimeOutLoginUrl";

    /**
     * properties值：密码错误输入几次时锁定该用户
     */
    public static final String LOCK_USER_COUNT = "lockUserCount";

    /**
     * properties值：密码检测的最短值
     */
    public static final String MIN_PASSWORD = "minPassword";

    /**
     * properties值：密码检测的最长值
     */
    public static final String MAX_PASSWORD = "maxPassword";

    /**
     * properties值：邮箱最长值的检测
     */
    public static final String MAX_EMAIL_LENGTH = "maxEmailLength";

    /**
     * fielderror输出时的默认field
     */
    public static final String DEFAULT_FIELD_NAME = "defaultFieldName";

    /**
     * message的编号:BOOKZ0001E 必须输入的 请输入{0}的内容。
     */
    public static final String BOOKZ0001E = "BOOKZ0001E";

    /**
     * message的编号:BOOKZ0002E 输入格式检测 {0}输入格式不正确。{1}
     */
    public static final String BOOKZ0002E = "BOOKZ0002E";

    /**
     * message的编号:BOOKZ0003E 输入英数字检测 {0}必须输入英数字。
     */
    public static final String BOOKZ0003E = "BOOKZ0003E";

    /**
     * message的编号:BOOKZ0004E 输入范围检测 {0}的输入值必须大于{1}的输入值。
     */
    public static final String BOOKZ0004E = "BOOKZ0004E";

    /**
     * message的编号:BOOKZ0005E 文字长度范围检测 输入{0}的文字长度必须满足{1}到{2}的范围之间。
     */
    public static final String BOOKZ0005E = "BOOKZ0005E";

    /**
     * message的编号:BOOKZ0006E 文字长度最大位数检测 输入{0}的文字长度必须满足{1}以内。
     */
    public static final String BOOKZ0006E = "BOOKZ0006E";

    /**
     * message的编号:BOOKZ0008E 数据异常 指定{0}数据不存在。
     */
    public static final String BOOKZ0008E = "BOOKZ0008E";

    /**
     * message的编号:BOOKZ0009E 必须选择 请选择{0}。
     */
    public static final String BOOKZ0009E = "BOOKZ0009E";

    /**
     * message的编号:BOOKZ0011E 模板缺失错误 指定的{0}模板不存在。
     */
    public static final String BOOKZ0011E = "BOOKZ0011E";

    /**
     * message的编号:BOOKZ0012E 指定文件后缀名与{0}不符，请确认。
     */
    public static final String BOOKZ0012E = "BOOKZ0012E";

    /**
     * message的编号:BOOKZ0013E 指定的{0}大小超过{1}M。
     */
    public static final String BOOKZ0013E = "BOOKZ0013E";

    /**
     * message的编号:BOOKZ0014E 导入数据项目错误 导入的数据项目{0}不存在于{1}中，请确认。
     */
    public static final String BOOKZ0014E = "BOOKZ0014E";

    /**
     * message的编号:BOOKZ0017E 排他更新错误 该{0}信息已经被更新，无法保存。
     */
    public static final String BOOKZ0017E = "BOOKZ0017E";

    /**
     * message的编号:BOOKZ0018E 组织机构IP范围未指定 组织机构尚未设定管辖IP地址范围，请确认。
     */
    public static final String BOOKZ0018E = "BOOKZ0018E";

    /**
     * message的编号:BOOKZ0019E 组织机构IP范围错误 存在组织机构管辖范围以外的IP地址信息，请确认。{0}
     */
    public static final String BOOKZ0019E = "BOOKZ0019E";

    /**
     * message的编号:BOOKZ0020E 输入{0}的文字长度必须为{1}位。
     */
    public static final String BOOKZ0020E = "BOOKZ0020E";

    /**
     * message的编号:BOOKZ0021E 检索画面件数为0 检索结果件数为0件，请修改检索条件。
     */
    public static final String BOOKZ0021E = "BOOKZ0021E";

    /**
     * message的编号:BOOKZ0022E 检索画面件数检测 检索结果件数超过{0}件，请修改检索条件。
     */
    public static final String BOOKZ0022E = "BOOKZ0022E";

    /**
     * message的编号:BOOKZ0023E {0}必须输入数字
     */
    public static final String BOOKZ0023E = "BOOKZ0023E";

    /**
     * message的编号:BOOKZ0026E 存在忙时时段扫描的IP地址信息，是否强制执行？
     */
    public static final String BOOKZ0026E = "BOOKZ0026E";

    /**
     * message的编号:BOOKZ0027I 存在忙时时段扫描的IP地址信息，是否强制执行？
     */
    public static final String BOOKZ0027I = "BOOKZ0027I";

    /**
     * message的编号:BOOKZ0028E 访问了不存在的页面：{0}
     */
    public static final String BOOKZ0028E = "BOOKZ0028E";

    /**
     * message的编号:BOOKZ0029E 删除失败,请重试。
     */
    public static final String BOOKZ0029E = "BOOKZ0029E";

    /**
     * message的编号:BOOKC0030E 此{0}未检索到，或已经被删除，请再重新检索。
     */
    public static final String BOOKZ0030E = "BOOKZ0030E";

    /**
     * message的编号:BOOKC0031E IP段范围输入有误，请确认。
     */
    public static final String BOOKZ0031E = "BOOKZ0031E";

    /**
     * message的编号:BOOKZ0032E IP段范围输入有误，请确认。
     */
    public static final String BOOKZ0032E = "BOOKZ0032E";

    /**
     * message的编号:BOOKZ0033E 至少要设置一个{权限}。
     */
    public static final String BOOKZ0033E = "BOOKZ0033E";

    /**
     * message的编号:BOOKZ0034E 防跨站特殊字符不能输入
     */
    public static final String BOOKZ0034E = "BOOKZ0034E";

    /**
     * message的编号:BOOKZ0035I 删除成功
     */
    public static final String BOOKZ0035I = "BOOKZ0035I";

    /**
     * message的编号:BOOKA0004E 策略名称已存在，请重新输入
     */
    public static final String BOOKA0004E = "BOOKA0004E";

    /**
     * message的编号:BOOKA0002E 资产IP地址检测 指定的IP地址已经存在于资产信息库中，无法进行保存处理，请确认。
     */
    public static final String BOOKA0002E = "BOOKA0002E";

    /**
     * message的编号:BOOKA0003I 删除资产确认 指定的IP地址在资产信息库中处于删除状态，是否继续保存？
     */
    public static final String BOOKA0003I = "BOOKA0003I";

    /**
     * message的编号:BOOKB0011E 输入的IP包含权限范围外的IP，是否强制执行？
     */
    public static final String BOOKB0011E = "BOOKB0011E";

    /**
     * message的编号:BOOKB0011E 请选择正常的扫描策略
     */
    public static final String BOOKA0005I = "BOOKA0005I";

    /**
     * message的编号:BOOKB0011E 请输入1-180的数字
     */
    public static final String BOOKA0005F = "BOOKA0005F";

    /**
     * message的编号:BOOKB0011E 请输入1-12的数字
     */
    public static final String BOOKA0005Q = "BOOKA0005Q";

    /**
     * message的编号:BOOKD0023E {0}不能包含空格，请重新输入。
     */
    public static final String BOOKD0023E = "BOOKD0023E";

    /**
     * message的编号:BOOKE0001E IP地址输入包含重复项，请重新输入。
     */
    public static final String BOOKE0001E = "BOOKE0001E";

    /**
     * message的编号:BOOKE0002E URL地址格式不正确，请重新输入。
     */
    public static final String BOOKE0002E = "BOOKE0002E";

    /**
     * message的编号:BOOKE0003E 输入的{}数量大于{}个，请重新输入。
     */
    public static final String BOOKE0003E = "BOOKE0003E";

    /**
     * message的编号:BOOKE0003E 输入的IP范围包含IP数量大于254个，是否强制执行？
     */
    public static final String BOOKE0004E = "BOOKE0004E";

    /**
     * message的编号:BOOKE0003E 端口地址格式不正确，请重新输入。
     */
    public static final String BOOKE0005E = "BOOKE0005E";

    /**
     * message的补足文字列:用户名
     */
    public static final String MSG_ADD_AUTHORITY = "权限";

    /**
     * message的补足文字列:用户名
     */
    public static final String MSG_ADD_USER_NAME = "用户名";

    /**
     * message的补足文字列:密码
     */
    public static final String MSG_ADD_PASSWORD = "密码";

    /**
     * message的补足文字列:验证码
     */
    public static final String MSG_ADD_CHECKCODE = "验证码";

    /**
     * message的补足文字列:当前密码
     */
    public static final String MSG_ADD_NOW_PASSWORD = "当前密码";

    /**
     * message的补足文字列:新密码
     */
    public static final String MSG_ADD_NEW_PASSWORD = "新密码";

    /**
     * message的补足文字列:确认新密码
     */
    public static final String MSG_ADD_RE_PASSWORD = "确认密码";

    /**
     * message的补足文字列:IP地址
     */
    public static final String MSG_ADD_IPADDR = "IP地址";

    /**
     * message的补足文字列:密码有效时间
     */
    public static final String MSG_ADD_PW_DATE = "密码有效期";

    /**
     * message的补足文字列:密码有效时间(FROM)
     */
    public static final String MSG_ADD_PW_DATE_FROM = "密码有效期(FROM)";

    /**
     * message的补足文字列:密码有效时间(TO)
     */
    public static final String MSG_ADD_PW_DATE_TO = "密码有效期(TO)";

    /**
     * message的补足文字列:IP地址开始
     */
    public static final String MSG_ADD_IPADDR_START = "IP地址开始";

    /**
     * message的补足文字列:IP地址结束
     */
    public static final String MSG_ADD_IPADDR_END = "IP地址结束";

    /**
     * message的补足文字列:IP地址格式输入提示文字
     */
    public static final String MSG_ADD_IPADDR_CMT = "IP地址分为四个部分，每个部分数值0-255之间，例如：192.168.1.1";

    /**
     * message的补足文字列:IP地址格式输入提示文字
     */
    public static final String MSG_ADD_IPADDR_INPUT = "错误IP范围输出";

    /**
     * message的补足文字列:操作系统版本号
     */
    public static final String MSG_ADD_SYSTEM_VERSION = "操作系统版本号";

    /**
     * message的补足文字列:设备类型
     */
    public static final String MSG_ADD_DEVICE_TYPE = "设备类型";

    /**
     * message的补足文字列:主机名
     */
    public static final String MSG_ADD_HOST_NAME = "主机名";

    /**
     * message的补足文字列:网卡地址
     */
    public static final String MSG_ADD_MAC_ADDR = "网卡地址";

    /**
     * message的补足文字列:操作系统
     */
    public static final String MSG_ADD_MAC_SYSTER = "操作系统";

    /**
     * message的补足文字列:网卡地址格式输入提示文字
     */
    public static final String MSG_ADD_MAC_CMT = "网卡地址分为六个部分，每个部分由0-9和A-F的两位组成，例如：AA:11:B2:35:2C:8F";

    /**
     * message的补足文字列:网卡厂商
     */
    public static final String MSG_ADD_VENDOR = "网卡厂商";

    /**
     * message的补足文字列:所属业务系统名称
     */
    public static final String MSG_ADD_BUSINESS = "所属业务系统名称";

    /**
     * message的补足文字列:资产编号
     */
    public static final String MSG_ADD_ASSETNUMS = "资产编号";

    /**
     * message的补足文字列:设备名称
     */
    public static final String MSG_ADD_DEVICE_NAME = "设备名称";

    /**
     * message的补足文字列:硬件型号
     */
    public static final String MSG_ADD_HARDWARE = "硬件型号";

    /**
     * message的补足文字列:所属机房
     */
    public static final String MSG_ADD_MROOM = "所属机房";

    /**
     * message的补足文字列:所属机柜
     */
    public static final String MSG_ADD_MCABINET = "所属机柜";

    /**
     * message的补足文字列:组织机构
     */
    public static final String MSG_ADD_ORGID = "组织机构";

    /**
     * message的补足文字列:添加
     */
    public static final String MSG_ADD_ADD = "添加";

    /**
     * message的补足文字列:组织机构名称
     */
    public static final String MSG_ADD_ORG_NAME = "组织机构名称";

    /**
     * message的补足文字列:IP地址范围
     */
    public static final String MSG_ADD_TARGET_IP = "IP地址范围";

    /**
     * message的补足文字列:URL地址范围
     */
    public static final String MSG_ADD_TARGET_URL = "URL地址范围";

    /**
     * message的补足文字列:子域名
     */
    public static final String MSG_ADD_TARGET_DOMIAN = "子域名";

    /**
     * message的补足文字列:员工工号
     */
    public static final String MSG_ADD_USERCODE = "员工工号";

    /**
     * message的补足文字列:区域划分(省)
     */
    public static final String MSG_ADD_PROVINCE = "区域划分(省)";

    /**
     * message的补足文字列:区域划分(市)
     */
    public static final String MSG_ADD_CITY = "区域划分(市)";

    /**
     * message的补足文字列:区域划分(区)
     */
    public static final String MSG_ADD_AREA = "区域划分(区)";

    /**
     * message的补足文字列:忙时时段开始
     */
    public static final String MSG_ADD_BUSY_START = "忙时时段开始";

    /**
     * message的补足文字列:忙时时段结束
     */
    public static final String MSG_ADD_BUSY_END = "忙时时段结束";

    /**
     * message的补足文字列:时间格式输入提示信息
     */
    public static final String MSG_ADD_TIME_CMT = "时间格式为24小时制以半角:分割，例如：10:30";

    /**
     * message的补足文字列:是否重要资产
     */
    public static final String MSG_ADD_IMPASSET = "是否重要资产";

    /**
     * message的补足文字列:管理员工号
     */
    public static final String MSG_ADD_MANAGER = "管理员工号";

    /**
     * message的补足文字列:维护厂家名称
     */
    public static final String MSG_ADD_MANUFACTURER = "维护厂家名称";

    /**
     * message的补足文字列:厂家维护人员姓名
     */
    public static final String MSG_ADD_ACCENDANT = "厂家维护人员姓名";

    /**
     * message的补足文字列:厂家维护人员电话
     */
    public static final String MSG_ADD_ACCENDANTTEL = "厂家维护人员电话";

    /**
     * message的补足文字列:电话格式输入提示信息
     */
    public static final String MSG_ADD_TEL_CMT = "例如：13566668888";

    /**
     * message的补足文字列:厂家维护人员邮箱
     */
    public static final String MSG_ADD_ACCENDANTMAIL = "厂家维护人员邮箱";

    /**
     * message的补足文字列:邮箱格式输入提示信息
     */
    public static final String MSG_ADD_ACCENDANTMAIL_CMT = "例如：abc@com.cn";

    /**
     * message的补足文字列:备注
     */
    public static final String MSG_ADD_COMMENT = "备注";

    /**
     * message的补足文字列:扫描任务ID
     */
    public static final String MSG_ADD_DISSCANID = "扫描任务ID";

    /**
     * message的补足文字列:组织机构下该管理员工号
     */
    public static final String MSG_ADD_ADMIN_ERROR = "组织机构下该管理员工号";

    /**
     * message的补足文字列:资产信息
     */
    public static final String MSG_ADD_ASSET_INFO = "资产信息";

    /**
     * message的补足文字列:资产发现信息
     */
    public static final String MSG_ADD_ASSET_FOUND_INFO = "资产发现信息";

    /**
     * message的补足文字列:端口1
     */
    public static final String MSG_ADD_OPENPORT_ERROR = "端口";

    /**
     * message的补足文字列:端口1
     */
    public static final String MSG_ADD_OPENPORT1_ERROR = "端口1";

    /**
     * message的补足文字列:端口2
     */
    public static final String MSG_ADD_OPENPORT2_ERROR = "端口2";

    /**
     * message的补足文字列:端口3
     */
    public static final String MSG_ADD_OPENPORT3_ERROR = "端口3";

    /**
     * message的补足文字列:端口4
     */
    public static final String MSG_ADD_OPENPORT4_ERROR = "端口4";

    /**
     * message的补足文字列:端口5
     */
    public static final String MSG_ADD_OPENPORT5_ERROR = "端口5";

    /**
     * message的补足文字列:IP指定
     */
    public static final String MSG_ADD_IP_ASSIGN = "IP指定";

    /** 最新扫描时间（from） */
    public static final String MSG_ADD_SCAN_STARTTIME = "最新扫描开始时间";

    /** 最新扫描时间（to） */
    public static final String MSG_ADD_SCAN_ENDTIME = "最新扫描结束时间";

    /**
     * message的补足文字列:删除
     */
    public static final String MSG_ADD_DELETE = "删除";

    /**
     * message的补足文字列:修改
     */
    public static final String MSG_ADD_UPDATE = "修改";

    /**
     * message的补足文字列:端口
     */
    public static final String MSG_ADD_OPENPORT = "端口";

    /**
     * message的补足文字列:管理员
     */
    public static final String MSG_ADD_ADMIN_NAME = "管理员";

    /**
     * 文件大小
     */
    public static final long FILE_SIZE = 5;

    /**
     * 文件大小（5兆）
     */
    public static final long FILE_SIZE_LIMIT = FILE_SIZE * 1024 * 1024;

    /**
     * message的补足文字列:文件导入
     */
    public static final String MSG_ADD_FILE_INPUT = "文件导入名称";

    /**
     * message的补足文字列:文件导入
     */
    public static final String MSG_ADD_FILE_IP = "导入文件中的IP";

    /**
     * message的补足文字列:文件导入
     */
    public static final String MSG_ADD_FILE = "导入文件中";

    /**
     * 任务增加用(session用)
     */
    public static final String SESSION_TASK_ADD = "SESSION_TASK_ADD";

    /** 数值 2 */
    public static final int NUM_2 = 2;

    /** 任务描述 */
    public static final String MSG_ADD_TASKDES = "任务描述";

    /** 用户名 */
    public static final String MSG_ADD_USERNAME = "用户名";

    /** 用户名 */
    public static final String MSG_ADD_ACCOUNTE = "登录名";
    
    /** 优惠码 */
    public static final String MSG_ADD_REGISTER_CODE = "优惠码";

    /** 真实姓名 */
    public static final String MSG_ADD_REALNAME = "姓名";

    /** 员工工号 */
    public static final String MSG_ADD_CODE = "员工工号";

    /** 所属部门 */
    public static final String MSG_ADD_DEPARTMENT = "所属部门";

    /** 直属领导 */
    public static final String MSG_ADD_DIRECTOR = "直属领导";

    /** 手机号码 */
    public static final String MSG_ADD_PHONE = "手机号码";

    /** 邮箱地址 */
    public static final String MSG_ADD_EMAIL = "邮件地址";

    /** 任务ID */
    public static final String MSG_ADD_TASK_ID = "任务ID";

    /** 角色名称 */
    public static final String MSG_ADD_ROLENAME = "角色名称";

    /** 角色 */
    public static final String MSG_ADD_ROLE = "角色";

    /** 角色备注 */
    public static final String MSG_ADD_ROLEDES = "角色备注";

    /** 扫描时间 */
    public static final String MSG_ADD_SCAN_TIME = "扫描开始时间";

    /** 更新时间 */
    public static final String MSG_ADD_UPDATE_DATE = "更新时间";

    /** 资产 */
    public static final String MSG_ADD_ASSETE = "资产";

    /** 资产 */
    public static final String MSG_ADD_USER = "用户";

    /** 漏洞编号 */
    public static final String MSG_ADD_LOOPHOL_NO = "漏洞编号";

    /** 工具选择 */
    public static final String MSG_TOOL_SELECT = "扫描工具";

    /** 计划任务 */
    public static final String MSG_PLAN_TASK = "计划任务";

    /** 任务 */
    public static final String MSG_TASK = "任务";

    /**
     * message的补足文字列:扫描时间格式输入提示文字
     */
    public static final String MSG_ADD_SCAN_TIME_CMT = "请按照\"YYYY-MM-dd\"的格式输入扫描时间";

    /**
     * message的补足文字列:更新时间格式输入提示文字
     */
    public static final String MSG_ADD_UPDATE_DATE_CMT = "请按照\"YYYY-MM-dd\"的格式输入更新时间";

    /**
     * 漏洞风险等级:严重 0
     */
    public static final String LOOP_HOLE_LEVEL_0 = "0";

    /**
     * 漏洞风险等级:高危 1
     */
    public static final String LOOP_HOLE_LEVEL_1 = "1";

    /**
     * 漏洞风险等级:中危 2
     */
    public static final String LOOP_HOLE_LEVEL_2 = "2";

    /**
     * 漏洞风险等级:低危 3
     */
    public static final String LOOP_HOLE_LEVEL_3 = "3";

    /**************************** 资产Session ************************************/
    /**
     * 资产列表检索结果存入所需session
     */
    public static final String SESSION_A201LIST_RESULT = "A201ListResult";

    /**
     * 资产列表页面查询条件所需session
     */
    public static final String SESSION_A202SEARCH_CONDITION = "A202SearchCondition";

    /**
     * 资产扫描翻页所需Session
     */
    public static final String SESSION_A301LIST_RESULT = "A301ListResult";

    /**
     * 资产扫描列表查询条件session
     */
    public static final String SESSION_A301SEARCH_CONDITION = "A301Search_Condition";

    public static final String SESSION_AUDITFOUND = "auditFound";

    public static final String SESSION_AUDITFOUNDINFO = "assetFoundInfo";

    public static final String SESSION_ASSETXTEND = "assetExtend";

    /**
     * message的编号:BOOKA0005E 扫描结束进程异常。
     */
    public static final String BOOKA0005E = "BOOKA0005E";

    /**
     * 
     */
    public static final String SESSION_ASSETLIST = "assetList";

    /**
     * 资产列表检测Session
     */
    public static final String SESSION_POLICY = "sessionPolicy";

    public static final String SESSION_POLICYLIST = "PolicyList";

    /**
     * 角色权限:查看
     */
    public static final String PERMISION_WATCH = "0";

    /**
     * 角色权限:操作
     */
    public static final String PERMISION_CONTROL = "1";

    /**
     * 日期范围的分隔符
     */
    public static final String DATE_RANGE_SPLITTER = " to ";

    /**
     * 固定文字(empty)
     */
    public static final String STRING_EMPTY = "empty";

    /**
     * 更新db返回值
     */
    public static final String RETURN_VALUE = "returnValue";

    /*************** 资产扫描校验所需常量 *********************/
    /**
     * 任务名称
     */
    public static final String MSG_SCAN_TASKNAME = "任务名称";

    /**
     * 执行时间开始
     */
    public static final String MSG_SCAN_STARTTIME = "执行时间开始";

    /**
     * 执行时间结束
     */
    public static final String MSG_SCAN_ENDTIME = "执行时间结束";

    /**
     * 任务描述
     */
    public static final String MSG_SCAN_DESCRIPTION = "任务描述";

    /**
     * IP指定
     */
    public static final String MSG_SCAN_TARGET = "IP指定";

    /**
     * 任务计划_天
     */
    public static final String MSG_POLICY_DAY = "任务计划_天";

    /**
     * 任务计划_月
     */
    public static final String MSG_POLICY_MONTH = "任务计划_月";

    /**
     * 策略名称
     */
    public static final String MSG_POLICY_NAME = "策略名称";

    /**
     * 策略描述
     */
    public static final String MSG_DESCRIPTION = "策略描述";

    /** 扫描方式 */
    public static final String MSG_SCAN_MODE = "扫描方式";

    /** 扫描方式 */
    public static final String MSG_ADD_CREATE_USER = "创建人";

    /** nmap执行报告 */
    public static final String NMAP_REPORT = "nmap.report";

    /** nmap文件路径 */
    public static final String NMAP_ADDR = "nmap.addr";

    /**
     * 任务类型 0 ：内网资产发现
     */
    public static final int TASK_TYPE_0 = 0;

    /**
     * 任务类型 1 ：外网资产发现
     */
    public static final int TASK_TYPE_1 = 1;

    /**
     * 任务类型 2 ：漏洞检测
     */
    public static final int TASK_TYPE_2 = 2;

    /**
     * 任务类型 3 ：弱口令检测
     */
    public static final int TASK_TYPE_3 = 3;

    /**
     * 任务状态 0 ：立即
     */
    public static final int TASK_STATUS_0 = 0;

    /**
     * 任务状态 1 ：定时
     */
    public static final int TASK_STATUS_1 = 1;

    /***
     * 输入IP地址:0
     */
    public static final int TARGET_MODE_IPV4 = 0;

    /***
     * 导入IP列表:1
     */
    public static final int TARGET_MODE_IPUPLOAD = 1;

    /***
     * 输入URL地址:2
     */
    public static final int TARGET_MODE_URL = 2;

    /***
     * 导入URL列表:3
     */
    public static final int TARGET_MODE_URLUPLOAD = 3;

    /***
     * 目标查询:4
     */
    public static final int TARGET_MODE_SELECT = 4;

    /***
     * 平台内置引擎
     */
    public static final int TASK_ENGINE_DEFAULT = 0;

    /***
     * ip集合
     */
    public static final String IP_LIST = "ip_list";

    /***
     * URL集合
     */
    public static final String URL_LIST = "url_list";

    /***
     * ip端口集合
     */
    public static final String IP_PORT_LIST = "ip_port_list";

    /***
     * ip数量
     */
    public static final String IP_COUNT = "ip_count";

    /***
     * NMAP扫描
     */
    public static final String TASK_NMAP = "task_namp";

    /***
     * NESSUS扫描
     */
    public static final String TASK_NESSUS = "task_nessus";

    /***
     * poc扫描
     */
    public static final String TASK_POC = "task_poc";

    /***
     * wvs扫描
     */
    public static final String TASK_WVS = "task_wvs";

    /***
     * 最大执行任务数量
     */
    public static final String MAX_TASK_INFO = "maxTaskInfo";

    /**
     * 漏洞级别：严重
     */
    public static final String B0003_0 = "0";

    /**
     * 漏洞级别：高危
     */
    public static final String B0003_1 = "1";

    /**
     * 漏洞级别：中危
     */
    public static final String B0003_2 = "2";

    /**
     * 网络区分：内网
     */
    public static final String NETWORK_TYPE_0 = "0";

    /**
     * 网络区分：外网
     */
    public static final String NETWORK_TYPE_1 = "1";
    
    
    public static final String BOOK_DETAIL = "BOOK_DETAIL";
    public static final String BOOK_DIRECTORY = "BOOK_DIRECTORY";
    public static final String BOOK_PART = "BOOK_PART";
    public static final String ADVICE_LIST = "ADVICE_LIST";
    public static final String SUCCESS_CASE_LIST = "SUCCESS_CASE_LIST";
    public static final String HELP_LIST = "HELP_LIST";
    public static final String ACHIEVEMENT_LIST = "ACHIEVEMENT_LIST";
    public static final String ACHIEVEMENT_CONDITION = "ACHIEVEMENT_CONDITION";
    public static final String DIARY_TODAY_YEAR = "DIARY_TODAY_YEAR";
    public static final String DIARY_TODAY_MONTH = "DIARY_TODAY_MONTH";
    public static final String DIARY_TODAY_DAY = "DIARY_TODAY_DAY";
    
    public static final String DIARY_YEAR = "DIARY_YEAR";
    public static final String DIARY_MONTH = "DIARY_MONTH";
    
    public static final String DIARY_LIST = "DIARY_LIST";
    
    /**
     * SESSION保存信息KEY:AdminUserBean(登录用户信息)
     */
    public static final String ADMIN_USER_NAME = "AdminUserBean";
    
    public static final String ALIPAY_NAME = "支付宝";
    public static final String WECHAT_NAME = "微信号";
    public static final String BANK_NAME = "银行名称";
    public static final String BANK_CARD_NAME = "开户名称";
    public static final String BANK_CARD_NUMBER = "银行账号";

}
