<%--@elvariable id="user" type="cn.edu.ncu.pojo.User"--%>
<%--
  Created by IntelliJ IDEA.
  User: Masters
  Date: 2020/6/2
  Time: 17:48
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
    <title>最家</title>
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
        <a href="#" class="fl">首页</a>
        <span>/</span>
        <a href="mygxin.html">个人中心</a>
        <span>/</span>
        <a href="myorderq.html" class="on">我的订单</a>
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
                    <li><a href="myorderq.html?pageNumber=1">我的订单</a></li>
                    <li><a href="myprod.html">评价晒单</a></li>
                </ul>
                <h4>个人中心</h4>
                <ul>
                    <li><a href="mygxin.html">我的中心</a></li>
                    <li><a href="address.html">地址管理</a></li>
                </ul>
                <h4>账户管理</h4>
                <ul>
                    <li class="on"><a href="mygrxx.html">个人信息</a></li>
                    <li><a href="remima.html">修改密码</a></li>
                </ul>
            </div>
        </div>
        <div class="you fl">
            <div class="my clearfix">
                <h2 class="fl">我的订单</h2>
                <a href="#" class="fl">请谨防钓鱼链接或诈骗电话，了解更多&gt;</a>
            </div>
            <div class="dlist clearfix">
                <ul class="fl clearfix" id="wa">
                    <li class="on"><a href="#2">全部有效订单</a></li>
                    <li><a href="#2">待支付</a></li>
                    <li><a href="#2l">待收货</a></li>
                    <li><a href="#2">已关闭</a></li>
                </ul>
                <form action="serchOrderByOrderId" method="get" class="fr clearfix">
                    <input type="text" name="orderId" id="" value="" placeholder="请输入商品名称、订单号"/>
                    <input type="submit" name="" id="" value=""/>
                </form>
            </div>

            <c:forEach items="${userOrder}" var="order">
                <c:if test="${order.key.key.status=='3'}">
                    <div class="dkuang">
                        <p class="one">已收货</p>
                        <div class="word clearfix">
                            <ul class="fl clearfix">
                                <li>
                                    <fmt:formatDate value="${order.key.key.createTime}" pattern="yyyy年MM月dd日 hh:mm"/>
                                </li>
                                <li>${order.key.key.contact}</li>
                                <li>订单号:${order.key.key.orderId}</li>
                                <li>
                                    <c:if test="${order.key.key.paymentType == '1'}">
                                        支付宝支付
                                    </c:if>
                                    <c:if test="${order.key.key.paymentType == '2'}">
                                        微信支付
                                    </c:if>
                                    <c:if test="${order.key.key.paymentType == '3'}">
                                        银联支付
                                    </c:if>
                                    <c:if test="${order.key.key.paymentType == '4'}">
                                        货到付款
                                    </c:if>
                                </li>
                            </ul>
                            <p class="fr">订单金额：<span>${order.key.key.payment}</span>元</p>
                        </div>
                        <c:forEach items="${order.value.key}" var="orderItem" varStatus="status">
                            <div class="shohou clearfix">
                                <a href="#" class="fl"><img style="width: 69px;height:69px" src="${orderItem.picPath}"/></a>
                                <p class="fl"><a href="#">${orderItem.title}</a><a href="#">¥${orderItem.price}×${orderItem.num}</a></p>
                                <c:if test="${status.last}">
                                    <p class="fr">
                                        <a href="myprod.html">待评价</a>
                                        <a href="orderDetail?orderId=${order.key.key.orderId}">订单详情</a>
                                    </p>
                                </c:if>
                            </div>
                        </c:forEach>
                    </div>
                </c:if>
                <c:if test="${order.key.key.status=='2'}">
                    <div class="dkuang clearfix deng">
                        <p class="one fl">待收货</p>
                        <div class="clearfix">
                            <div class="fl vewwl">
                                <a href="wuliu.html" class="ckwl">查看物流</a>
                                <div class="wuliu">
                                    <h4>${order.value.value.expressDelivery}：${order.value.value.freightId}</h4>
                                    <ul>
                                        <c:forEach items="${order.key.value}" var="freightDetail" varStatus="n">
                                            <c:if test="${n.index < 3}">
                                                <li>
                                                    <p>${freightDetail.detail}</p>
                                                    <p>
                                                        <fmt:formatDate value="${freightDetail.updateTime}" pattern="yyyy-MM-dd hh:mm:ss"/>
                                                    </p>
                                                </li>
                                            </c:if>
                                        </c:forEach>
                                        <li>以上为最新跟踪信息<a href="freightDetail?freightId=${order.value.value.freightId}">查看全部</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="word clearfix">
                            <ul class="fl clearfix">
                                <li>
                                    <fmt:formatDate value="${order.key.key.createTime}" pattern="yyyy年MM月dd日 hh:mm"/>
                                </li>
                                <li>${order.key.key.contact}</li>
                                <li>订单号:${order.key.key.orderId}</li>
                                <li>
                                    <c:if test="${order.key.key.paymentType == '1'}">
                                        支付宝支付
                                    </c:if>
                                    <c:if test="${order.key.key.paymentType == '2'}">
                                        微信支付
                                    </c:if>
                                    <c:if test="${order.key.key.paymentType == '3'}">
                                        银联支付
                                    </c:if>
                                    <c:if test="${order.key.key.paymentType == '4'}">
                                        货到付款
                                    </c:if>
                                </li>
                            </ul>
                            <p class="fr">订单金额：<span>${order.key.key.payment}</span>元</p>
                        </div>
                        <c:forEach items="${order.value.key}" var="orderItem" varStatus="status">
                            <div class="shohou clearfix">
                                <a href="#" class="fl"><img style="width: 69px;height:69px" src="${orderItem.picPath}"/></a>
                                <p class="fl"><a href="#">${orderItem.title}</a><a href="#">¥${orderItem.price}×${orderItem.num}</a></p>
                                <c:if test="${status.last}">
                                    <p class="fr">
                                        <a href="confirmReceipt?orderId=${order.key.key.orderId}">确认收货</a>
                                        <a href="orderDetail?orderId=${order.key.key.orderId}">订单详情</a>
                                    </p>
                                </c:if>
                            </div>
                        </c:forEach>
                    </div>
                </c:if>
                <c:if test="${order.key.key.status=='1'}">
                    <div class="dkuang deng">
                        <p class="one">待支付</p>
                        <div class="word clearfix">
                            <ul class="fl clearfix">
                                <li>
                                    <fmt:formatDate value="${order.key.key.createTime}" pattern="yyyy年MM月dd日 hh:mm"/>
                                </li>
                                <li>${order.key.key.contact}</li>
                                <li>订单号:${order.key.key.orderId}</li>
                                <li>
                                    <c:if test="${order.key.key.paymentType == '1'}">
                                    支付宝支付
                                </c:if>
                                    <c:if test="${order.key.key.paymentType == '2'}">
                                        微信支付
                                    </c:if>
                                    <c:if test="${order.key.key.paymentType == '3'}">
                                        银联支付
                                    </c:if>
                                    <c:if test="${order.key.key.paymentType == '4'}">
                                        货到付款
                                    </c:if>
                                </li>
                            </ul>
                            <p class="fr">订单金额：<span>${order.key.key.payment}</span>元</p>
                        </div>
                        <c:forEach items="${order.value.key}" var="orderItem" varStatus="status">
                            <div class="shohou clearfix">
                                <a href="#" class="fl"><img src="${orderItem.picPath}"/></a>
                                <p class="fl"><a href="#">${orderItem.title}</a><a href="#">¥${orderItem.price}×${orderItem.num}</a></p>
                                <c:if test="${status.last}">
                                    <p class="fr">
                                        <a href="#">立即支付</a>
                                        <a href="orderDetail?orderId=${order.key.key.orderId}">订单详情</a>
                                    </p>
                                </c:if>
                            </div>
                        </c:forEach>
                    </div>
                </c:if>
                <c:if test="${order.key.key.status=='4'}">
                    <div class="dkuang">
                        <p class="one">已关闭</p>
                        <div class="word clearfix">
                            <ul class="fl clearfix">
                                <li>
                                    <fmt:formatDate value="${order.key.key.createTime}" pattern="yyyy年MM月dd日 hh:mm"/>
                                </li>
                                <li>${order.key.key.contact}</li>
                                <li>订单号:${order.key.key.orderId}</li>
                                <li>
                                    <c:if test="${order.key.key.paymentType == '1'}">
                                        支付宝支付
                                    </c:if>
                                    <c:if test="${order.key.key.paymentType == '2'}">
                                        微信支付
                                    </c:if>
                                    <c:if test="${order.key.key.paymentType == '3'}">
                                        银联支付
                                    </c:if>
                                    <c:if test="${order.key.key.paymentType == '4'}">
                                        货到付款
                                    </c:if>
                                </li>
                            </ul>
                            <p class="fr">订单金额：<span>${order.key.key.payment}</span>元</p>
                        </div>
                        <c:forEach items="${order.value.key}" var="orderItem" varStatus="status">
                            <div class="shohou clearfix">
                                <a href="#" class="fl"><img src="${orderItem.picPath}"/></a>
                                <p class="fl"><a href="#">${orderItem.title}</a><a href="#">¥${orderItem.price}×${orderItem.num}</a></p>
                                <c:if test="${status.last}">
                                    <p class="fr">
                                        <a href="#">交易失败</a>
                                        <a href="orderDetail?orderId=${order.key.key.orderId}">订单详情</a>
                                    </p>
                                </c:if>
                            </div>
                        </c:forEach>
                    </div>
                </c:if>
            </c:forEach>

            <div class="fenye clearfix">
                <a href="#" id="left"><img src="img/zuo.jpg"/></a>
                <a href="#"><span id="span">${pageNumber}</span></a>
                <a href="#" id="right"><img src="img/you.jpg"/></a>
            </div>
        </div>
    </div>
</div>
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
        违法和不良信息举报电话：188-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</p>
</div>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
<script>
    $("#left").click(function () {
        var number = parseInt($("#span").html());
        if (number > 1){
            number --;
        }
        $(this).attr("href", 'myorderq?pageNumber='+number);
    });
    $("#right").click(function () {
        var number = parseInt($("#span").html());
        number ++;
        $(this).attr("href", 'myorderq?pageNumber='+number);
    });
</script>
</body>
</html>

