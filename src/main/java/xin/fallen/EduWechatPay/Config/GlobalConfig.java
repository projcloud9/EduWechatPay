package xin.fallen.EduWechatPay.Config;import xin.fallen.EduWechatPay.annotation.Alias;/** * Author: Fallen * Date: 2017/8/7 * Time: 9:43 * Usage: */public class GlobalConfig {    //公众号支付    public static final String TRADE_TYPE_GZHZF = "JSAPI";    //扫码支付    public static final String TRADE_TYPE_SMZF = "NATIVE";    @Alias("access_token_api")    public static String ACCESS_TOKEN_API;    @Alias("wechat_user_info_api")    public static String WECHAT_USER_INFO_API;    @Alias("app_secret")    public static String APP_SECRET;    @Alias("wechat_pay_success_feed_back")    public static String WECHAT_PAY_SUCCESS_FEED_BACK;    @Alias("wechat_pay_fail_feed_back")    public static String WECHAT_PAY_FAIL_FEED_BACK;    @Alias("get_order_fee_api")    public static String ORDER_FEE_API;    @Alias("wechat_pay_notify_api")    public static String WECHAT_PAY_NOTIFY_API;    @Alias("mch_id")    public static String MCHID;    @Alias("appid")    public static String APPID;    @Alias("key")    public static String KEY;    @Alias("get_prepayid_addr_api")    public static String ORDER_CREATE_API;    @Alias("pay_notify_addr")    public static String PAY_NOTIFY_ADDR;    @Alias("get_order_pay_result_api")    public static String GET_ORDER_PAY_RESULT_API;    @Alias("get_order_pay_result_postbody")    public static String GET_ORDER_PAY_RESULT_POSTBODY;}