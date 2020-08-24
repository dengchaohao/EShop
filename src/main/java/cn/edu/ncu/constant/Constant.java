package cn.edu.ncu.constant;

/**
 * @Author ZhaiyiJun
 * @Create by Masters on 2020-08-15
 * @Description: mybatis-study-01
 * @Modified by：[描述修改人]
 * @Version: 1.0
 * @History: [描述修改信息]
 */
public class Constant {
    public static final Integer INTERCOUNT = 10000;

    public static final String[] PAY_WAY= {"支付宝支付","微信支付","银联支付","货到付款"};
    public static final int MB_PAGE_SIZE = 7;
    public static final int MU_PAGE_SIZE = 15;
    public static final int PW_PAGE_SIZE = 12;
    public static final int C_PAGE_SIZE = 3;
    public static final int UO_PAGE_SIZE = 3;
    //	public static final int PAGE_SIZE = 3;
    public static final String UN_DO ="未发货";
    public static final String UN_COMMENT ="待评价";
    public static final String EN_COMMENT ="已评价";

    public static final String[] NoFilter_Pages=new String[]{
            "/index.html","/bzproList.html","/decoration.html"
            ,"/flowerDer.html","/forget.html",
            "/idea.html","/reg.html"
            ,"/login.html","/zbproList.html","/paint.html","/perfume.html"
            ,"/proDetail.html","/proList.html","/search.html"
            ,"/vase_proList.html","/loginCheck.html"};
}
