<%--
  Created by IntelliJ IDEA.
  User: Masters
  Date: 2020/6/2
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--因为tomcat版本问题，自动默认EL表达式不启用要手动启用，加入--%>
<%@ page isELIgnored="false" %>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>个人信息</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/myorder.css"/>
</head>
<body>
<!------------------------------head------------------------------>
<div class="head ding">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top">
            <h1 class="fl"><a href="index.html"><img src="img/logo.png"/></a></h1>
            <div class="fr clearfix" id="top1">
                <p class="fl">
                    <a href="#" id="login">登录</a>
                    <a href="#" id="reg">注册</a>
                </p>
                <form action="#" method="get" class="fl">
                    <input type="text" placeholder="搜索"/>
                    <input type="button"/>
                </form>
                <div class="btn fl clearfix">
                    <a href="mygxin.html"><img src="img/grzx.png"/></a>
                    <a href="#" class="er1"><img src="img/ewm.png"/></a>
                    <a href="cart.html"><img src="img/gwc.png"/></a>
                    <p><a href="#"><img src="img/smewm.png"/></a></p>
                </div>
            </div>
        </div>
        <ul class="clearfix" id="bott">
            <li><a href="index.html">首页</a></li>
            <li>
                <a href="#">所有商品</a>
                <div class="sList">
                    <div class="wrapper  clearfix">
                        <a href="paint.html">
                            <dl>
                                <dt><img src="img/nav1.jpg"/></dt>
                                <dd>浓情欧式</dd>
                            </dl>
                        </a>
                        <a href="paint.html">
                            <dl>
                                <dt><img src="img/nav2.jpg"/></dt>
                                <dd>浪漫美式</dd>
                            </dl>
                        </a>
                        <a href="paint.html">
                            <dl>
                                <dt><img src="img/nav3.jpg"/></dt>
                                <dd>雅致中式</dd>
                            </dl>
                        </a>
                        <a href="paint.html">
                            <dl>
                                <dt><img src="img/nav6.jpg"/></dt>
                                <dd>简约现代</dd>
                            </dl>
                        </a>
                        <a href="paint.html">
                            <dl>
                                <dt><img src="img/nav7.jpg"/></dt>
                                <dd>创意装饰</dd>
                            </dl>
                        </a>
                    </div>
                </div>
            </li>
            <li>
                <a href="flowerDer.html">装饰摆件</a>
                <div class="sList2">
                    <div class="clearfix">
                        <a href="proList.html">干花花艺</a>
                        <a href="vase_proList.html">花瓶花器</a>
                    </div>
                </div>
            </li>
            <li>
                <a href="decoration.html">布艺软饰</a>
                <div class="sList2">
                    <div class="clearfix">
                        <a href="zbproList.html">桌布罩件</a>
                        <a href="bzproList.html">抱枕靠垫</a>
                    </div>
                </div>
            </li>
            <li><a href="paint.html">墙式壁挂</a></li>
            <li><a href="perfume.html">蜡艺香薰</a></li>
            <li><a href="idea.html">创意家居</a></li>
        </ul>
    </div>
</div>
<!------------------------------idea------------------------------>
<div class="address mt">
    <div class="wrapper clearfix">
        <a href="index.html" class="fl">首页</a>
        <span>/</span>
        <a href="myorderq.html" class="on">我的订单</a>
        <span>/</span>
        <a href="#" class="on">订单详情</a>
    </div>
</div>

<!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <div class="zuo fl">
            <h3>
                <a href="mygxin.html"><img style="width:92px; height:92px; border-radius:50%;" src="${user.headPic}"/></a>
                <p class="clearfix"><span class="fl">[${user.nickName}]</span><a href="logout"><span class="fr">[退出登录]</span></a></p>
            </h3>
            <div>
                <h4>我的交易</h4>
                <ul>
                    <li><a href="cart.html">我的购物车</a></li>
                    <li class="on"><a href="myorderq.html?pageNumber=1">我的订单</a></li>
                    <li><a href="myprod.html">评价晒单</a></li>
                </ul>
                <h4>个人中心</h4>
                <ul>
                    <li><a href="mygxin.html">我的中心</a></li>
                    <li><a href="address.html">地址管理</a></li>
                </ul>
                <h4>账户管理</h4>
                <ul>
                    <li><a href="mygrxx.html">个人信息</a></li>
                    <li><a href="remima.html">修改密码</a></li>
                </ul>
            </div>
        </div>
        <div class="you fl">
            <div class="my clearfix">
                <h2>订单详情<a href="#">请谨防钓鱼链接或诈骗电话，了解更多&gt;</a></h2>
                <h3>订单号：<span>${userOrder.key.orderId}</span></h3>
            </div>
            <div class="orderList">
                <div class="orderList1">
                    <h3>
                        <c:if test="${userOrder.key.status == '1'}">
                            待支付
                        </c:if>
                        <c:if test="${userOrder.key.status == '2'}">
                            待收货
                        </c:if>
                        <c:if test="${userOrder.key.status == '3'}">
                            已收货
                        </c:if>
                        <c:if test="${userOrder.key.status == '4'}">
                            已关闭
                        </c:if>
                    </h3>
                    <c:forEach items="${userOrder.value}" var="orderItem">
                        <div class="clearfix">
                            <a href="#" class="fl"><img style="width: 65px;height:65px" src="${orderItem.picPath}"/></a>
                            <p class="fl"><a href="#">${orderItem.title}</a><a href="#">¥${orderItem.price}×${orderItem.num}</a></p>
                        </div>
                    </c:forEach>
                </div>
                <div class="orderList1">
                    <h3>收货信息</h3>
                    <p>姓 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<span>${userOrder.key.contact}</span></p>
                    <p>联系电话：<span>${userOrder.key.mobile}</span></p>
                    <p>收货地址：<span>${userOrder.key.province} ${userOrder.key.city} ${userOrder.key.area} ${userOrder.key.address}</span></p>
                </div>
                <div class="orderList1">
                    <h3>支付方式及送货时间</h3>
                    <p>支付方式：<span>
                        <c:if test="${userOrder.key.status != '1' && userOrder.key.status != '4'}">
                            <c:if test="${userOrder.key.paymentType == '1'}">
                                支付宝支付
                            </c:if>
                            <c:if test="${userOrder.key.paymentType == '2'}">
                                微信支付
                            </c:if>
                            <c:if test="${userOrder.key.paymentType == '3'}">
                                银联支付
                            </c:if>
                            <c:if test="${userOrder.key.paymentType == '4'}">
                                货到付款
                            </c:if>
                        </c:if>
                    </span></p>
                    <p>送货时间：<span>不限送货时间</span></p>
                </div>
                <div class="orderList1 hei">
                    <h3><strong>商品总价：</strong><span>¥${userOrder.key.payment}</span></h3>
                    <p><strong>运费：</strong><span>¥${userOrder.key.postFee}</span></p>
                    <p><strong>订单金额：</strong><span>¥${userOrder.key.payment}</span></p>
                    <p><strong>实付金额：</strong><span>
                        ¥<c:if test="${userOrder.key.status != '1' && userOrder.key.status != '4'}">
                            ${userOrder.key.payment}
                        </c:if>
                    </span></p>
                </div>
            </div>
        </div>
    </div>
</div>
<

<!--返回顶部-->
<div class="gotop">
    <a href="cart.html">
        <dl>
            <dt><img src="img/gt1.png"/></dt>
            <dd>去购<br/>物车</dd>
        </dl>
    </a>
    <a href="#" class="dh">
        <dl>
            <dt><img src="img/gt2.png"/></dt>
            <dd>联系<br/>客服</dd>
        </dl>
    </a>
    <a href="mygxin.html">
        <dl>
            <dt><img src="img/gt3.png"/></dt>
            <dd>个人<br/>中心</dd>
        </dl>
    </a>
    <a href="#" class="toptop" style="display: none">
        <dl>
            <dt><img src="img/gt4.png"/></dt>
            <dd>返回<br/>顶部</dd>
        </dl>
    </a>
    <p>400-800-8200</p>
</div>
<!--footer-->
<div class="footer">
    <div class="top">
        <div class="wrapper">
            <div class="clearfix">
                <a href="#2" class="fl"><img src="img/foot1.png"/></a>
                <span class="fl">7天无理由退货</span>
            </div>
            <div class="clearfix">
                <a href="#2" class="fl"><img src="img/foot2.png"/></a>
                <span class="fl">15天免费换货</span>
            </div>
            <div class="clearfix">
                <a href="#2" class="fl"><img src="img/foot3.png"/></a>
                <span class="fl">满599包邮</span>
            </div>
            <div class="clearfix">
                <a href="#2" class="fl"><img src="img/foot4.png"/></a>
                <span class="fl">手机特色服务</span>
            </div>
        </div>
    </div>
    <p class="dibu">最家家居&copy;2013-2017公司版权所有 京ICP备080100-44备0000111000号<br/>
        违法和不良信息举报电话：400-800-8200，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</p>
</div>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>

