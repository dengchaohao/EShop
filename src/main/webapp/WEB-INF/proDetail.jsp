<%--
  Created by IntelliJ IDEA.
  User: Masters
  Date: 2020/6/2
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--因为tomcat版本问题，自动默认EL表达式不启用要手动启用，加入--%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>详情页</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
</head>
<body>
<!------------------------------head------------------------------>
<div class="head">
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
<!-----------------address------------------------------->
<div class="address">
    <div class="wrapper clearfix">
        <a href="index.html">首页</a>
        <span>/</span>
        <a href="flowerDer.html">${goods.categoryOne}</a>
        <span>/</span>
        <a href="proList.html">${goods.categoryTwo}</a>
        <span>/</span>
        <a href="#" class="on">${goods.name}</a>
    </div>
</div>
<!-----------------------Detail------------------------------>
<div class="detCon">
    <div class="proDet wrapper">
        <div class="proCon clearfix">
            <div class="proImg fl">
                <img class="det" src="${goods.prodetPic}"/>
                <div class="smallImg clearfix">
                    <c:forEach items="${smallImgs}" var="img">
                        <img src="${img.prodet}" data-src="${img.prodetBig}">
                    </c:forEach>
                   <%-- <img src="img/temp/proDet01.jpg" data-src="img/temp/proDet01_big.jpg">
                    <img src="img/temp/proDet02.jpg" data-src="img/temp/proDet02_big.jpg">
                    <img src="img/temp/proDet03.jpg" data-src="img/temp/proDet03_big.jpg">
                    <img src="img/temp/proDet04.jpg" data-src="img/temp/proDet04_big.jpg">--%>
                </div>
            </div>
            <div class="fr intro">
                <div class="title">
                    <h4>${goods.name}</h4>
                    <p>${goods.introduction}</p>
                    <%--<p>【破损补寄】【适合放室内、卧室、书房、餐桌、办公室、客厅、电视柜等地方】【无理由退换货】【包邮】【白色现代简约花瓶】</p>--%>
                    <span>￥${goods.price}</span>
                </div>
                <div class="proIntro">
                    <p>颜色分类</p>
                    <div class="smallImg clearfix categ">
                        <c:forEach items="${specificationOptions}" var="spec">
                            <p class="fl"><img src="${spec.prosmallPictureUrl}" alt="${spec.sepcName}"
                                               data-src="${spec.probigPictureUrl}"></p>
                        </c:forEach>
                        <%--<p class="fl"><img src="img/temp/prosmall01.jpg" alt="白瓷花瓶+20支快乐花"
                                           data-src="img/temp/proBig01.jpg"></p>
                        <p class="fl"><img src="img/temp/prosmall02.jpg" alt="白瓷花瓶+20支兔尾巴草"
                                           data-src="img/temp/proBig02.jpg"></p>
                        <p class="fl"><img src="img/temp/prosmall03.jpg" alt="20支快乐花" data-src="img/temp/proBig03.jpg">
                        </p>
                        <p class="fl"><img src="img/temp/prosmall04.jpg" alt="20支兔尾巴草" data-src="img/temp/proBig04.jpg">
                        </p>--%>
                    </div>
                    <p>数量&nbsp;&nbsp;库存<span>${goods.stock}</span>件</p>
                    <div class="num clearfix">
                        <img class="fl sub" src="img/temp/sub.jpg">
                        <span class="fl" contentEditable="true">1</span>
                        <img class="fl add" src="img/temp/add.jpg">
                        <p class="please fl">请选择商品属性!</p>
                    </div>
                </div>
                <input type="hidden" id="id" value="${goods.goodsId}"  />&nbsp;&nbsp;&nbsp;
                <div class="btns clearfix">
                    <a href="#2"><p class="buy fl">立即购买</p></a>
                    <p class="cart fr">加入购物车</p>
                    <%--<a href="#"><p class="cart fr">加入购物车</p></a>--%>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="introMsg wrapper clearfix">
    <div class="msgL fl">
        <div class="msgTit clearfix">
            <a class="on">商品详情</a>
            <a>所有评价</a>
        </div>
        <div class="msgAll">
            <div class="msgImgs">
                <c:forEach items="${msgImgs}" var="picture">
                       <img src="${picture.msgImg}" />
                </c:forEach>
                <p>${goods.name}</p>
                <%--<img src="img/temp/det01.jpg">
                <img src="img/temp/det02.jpg">
                <img src="img/temp/det03.jpg">
                <img src="img/temp/det04.jpg">
                <img src="img/temp/det05.jpg">
                <img src="img/temp/det06.jpg">
                <img src="img/temp/det07.jpg">--%>
            </div>
            <div class="eva">
                <c:forEach items="${map}" var="entry">
                    <div class="per clearfix">
                        <img class="fl" style="width: 41px;height: 40px" src="${entry.value.headPic}">
                        <div class="perR fl">
                            <p>${entry.value.username}</p>
                            <p>${entry.key.remark}</p>
                            <p><span>
                                    <fmt:formatDate value="${entry.key.commentTime}" pattern="yyyy年MM月dd日 hh:mm"/>
                                    </span><span>颜色分类：${entry.key.specOption}</span></p>
                        </div>
                    </div>
                </c:forEach>
                <div class="per clearfix">
                    <img class="fl" src="img/temp/per01.jpg">
                    <div class="perR fl">
                        <p>馨***呀</p>
                        <p>不好意思评价晚了，产品很好，价格比玻璃品便宜，没有我担心的杂色，发货快，包装好，全5分</p>
                        <div class="clearfix">
                            <p><img src="img/temp/eva01.jpg"></p>
                            <p><img src="img/temp/eva02.jpg"></p>
                            <p><img src="img/temp/eva03.jpg"></p>
                            <p><img src="img/temp/eva04.jpg"></p>
                            <p><img src="img/temp/eva05.jpg"></p>
                        </div>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p>
                    </div>
                </div>
                <div class="per clearfix">
                    <img class="fl" src="img/temp/per02.jpg">
                    <div class="perR fl">
                        <p>么***周</p>
                        <p>花瓶超级棒，我看图以为是光面的，收货发现是磨砂，但感觉也超有质感，很喜欢。磨砂上面还有点纹路，不过觉得挺自然的，不影响美观。包装也很好，绝对不会磕碎碰坏，好评！</p>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p>
                    </div>
                </div>
                <div class="per clearfix">
                    <img class="fl" src="img/temp/per01.jpg">
                    <div class="perR fl">
                        <p>馨***呀</p>
                        <p>不好意思评价晚了，产品很好，价格比玻璃品便宜，没有我担心的杂色，发货快，包装好，全5分</p>
                        <div class="clearfix">
                            <p><img src="img/temp/eva01.jpg"></p>
                            <p><img src="img/temp/eva02.jpg"></p>
                            <p><img src="img/temp/eva03.jpg"></p>
                            <p><img src="img/temp/eva04.jpg"></p>
                            <p><img src="img/temp/eva05.jpg"></p>
                        </div>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p>
                    </div>
                </div>
                <div class="per clearfix">
                    <img class="fl" src="img/temp/per02.jpg">
                    <div class="perR fl">
                        <p>么***周</p>
                        <p>花瓶超级棒，我看图以为是光面的，收货发现是磨砂，但感觉也超有质感，很喜欢。磨砂上面还有点纹路，不过觉得挺自然的，不影响美观。包装也很好，绝对不会磕碎碰坏，好评！</p>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p>
                    </div>
                </div>
                <div class="per clearfix">
                    <img class="fl" src="img/temp/per01.jpg">
                    <div class="perR fl">
                        <p>馨***呀</p>
                        <p>不好意思评价晚了，产品很好，价格比玻璃品便宜，没有我担心的杂色，发货快，包装好，全5分</p>
                        <div class="clearfix">
                            <p><img src="img/temp/eva01.jpg"></p>
                            <p><img src="img/temp/eva02.jpg"></p>
                            <p><img src="img/temp/eva03.jpg"></p>
                            <p><img src="img/temp/eva04.jpg"></p>
                            <p><img src="img/temp/eva05.jpg"></p>
                        </div>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p>
                    </div>
                </div>
                <div class="per clearfix">
                    <img class="fl" src="img/temp/per02.jpg">
                    <div class="perR fl">
                        <p>么***周</p>
                        <p>花瓶超级棒，我看图以为是光面的，收货发现是磨砂，但感觉也超有质感，很喜欢。磨砂上面还有点纹路，不过觉得挺自然的，不影响美观。包装也很好，绝对不会磕碎碰坏，好评！</p>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p>
                    </div>
                </div>
                <div class="per clearfix">
                    <img class="fl" src="img/temp/per01.jpg">
                    <div class="perR fl">
                        <p>馨***呀</p>
                        <p>不好意思评价晚了，产品很好，价格比玻璃品便宜，没有我担心的杂色，发货快，包装好，全5分</p>
                        <div class="clearfix">
                            <p><img src="img/temp/eva01.jpg"></p>
                            <p><img src="img/temp/eva02.jpg"></p>
                            <p><img src="img/temp/eva03.jpg"></p>
                            <p><img src="img/temp/eva04.jpg"></p>
                            <p><img src="img/temp/eva05.jpg"></p>
                        </div>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p>
                    </div>
                </div>
                <div class="per clearfix">
                    <img class="fl" src="img/temp/per02.jpg">
                    <div class="perR fl">
                        <p>么***周</p>
                        <p>花瓶超级棒，我看图以为是光面的，收货发现是磨砂，但感觉也超有质感，很喜欢。磨砂上面还有点纹路，不过觉得挺自然的，不影响美观。包装也很好，绝对不会磕碎碰坏，好评！</p>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p>
                    </div>
                </div>
                <div class="per clearfix">
                    <img class="fl" src="img/temp/per01.jpg">
                    <div class="perR fl">
                        <p>馨***呀</p>
                        <p>不好意思评价晚了，产品很好，价格比玻璃品便宜，没有我担心的杂色，发货快，包装好，全5分</p>
                        <div class="clearfix">
                            <p><img src="img/temp/eva01.jpg"></p>
                            <p><img src="img/temp/eva02.jpg"></p>
                            <p><img src="img/temp/eva03.jpg"></p>
                            <p><img src="img/temp/eva04.jpg"></p>
                            <p><img src="img/temp/eva05.jpg"></p>
                        </div>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p>
                    </div>
                </div>
                <div class="per clearfix">
                    <img class="fl" src="img/temp/per02.jpg">
                    <div class="perR fl">
                        <p>么***周</p>
                        <p>花瓶超级棒，我看图以为是光面的，收货发现是磨砂，但感觉也超有质感，很喜欢。磨砂上面还有点纹路，不过觉得挺自然的，不影响美观。包装也很好，绝对不会磕碎碰坏，好评！</p>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="msgR fr">
        <h4>为你推荐</h4>
        <div class="seeList">
            <c:forEach items="${recommendedForYou}" var="content">
                <a href="#">
                    <dl>
                        <dt><img src="${content.prodetPic}"></dt>
                        <dd>${content.name}</dd>
                        <dd>￥${content.price}</dd>
                    </dl>
                </a>
            </c:forEach>
            <%--<a href="#">
                <dl>
                    <dt><img src="img/temp/see01.jpg"></dt>
                    <dd>【最家】复古文艺风玻璃花瓶</dd>
                    <dd>￥193.20</dd>
                </dl>
            </a>
            <a href="#">
                <dl>
                    <dt><img src="img/temp/see02.jpg"></dt>
                    <dd>【最家】复古文艺风玻璃花瓶</dd>
                    <dd>￥193.20</dd>
                </dl>
            </a>
            <a href="#">
                <dl>
                    <dt><img src="img/temp/see03.jpg"></dt>
                    <dd>【最家】复古文艺风玻璃花瓶</dd>
                    <dd>￥193.20</dd>
                </dl>
            </a>
            <a href="#">
                <dl>
                    <dt><img src="img/temp/see04.jpg"></dt>
                    <dd>【最家】复古文艺风玻璃花瓶</dd>
                    <dd>￥193.20</dd>
                </dl>
            </a>--%>
        </div>

    </div>
</div>
<div class="like">
    <h4>猜你喜欢</h4>
    <div class="bottom">
        <div class="hd">
            <span class="prev"><img src="img/temp/prev.png"></span>
            <span class="next"><img src="img/temp/next.png"></span>
        </div>
        <div class="imgCon bd">
            <div class="likeList clearfix">
                <div>
                    <c:forEach items="${guessYouLike}" var="content" varStatus="status">
                        <c:if test="${!status.last}">
                            <a href="proDetail.html?goodsId=149187842867912">
                                <dl>
                                    <dt><img src="${content.prodetPic}"></dt>
                                    <dd>${content.name}</dd>
                                    <dd>￥${content.price}</dd>
                                </dl>
                            </a>
                        </c:if>
                        <c:if test="${status.last}">
                            <a href="proDetail.html?goodsId=149187842867912" class="last">
                                <dl>
                                    <dt><img src="${content.prodetPic}"></dt>
                                    <dd>${content.name}</dd>
                                    <dd>￥${content.price}</dd>
                                </dl>
                            </a>
                        </c:if>
                    </c:forEach>
                   <%-- <a href="proDetail.html">
                        <dl>
                            <dt><img src="img/temp/like01.jpg"></dt>
                            <dd>【最家】复古文艺风玻璃花瓶</dd>
                            <dd>￥193.20</dd>
                        </dl>
                    </a>
                    <a href="proDetail.html">
                        <dl>
                            <dt><img src="img/temp/like02.jpg"></dt>
                            <dd>【最家】复古文艺风玻璃花瓶</dd>
                            <dd>￥193.20</dd>
                        </dl>
                    </a>
                    <a href="proDetail.html">
                        <dl>
                            <dt><img src="img/temp/like03.jpg"></dt>
                            <dd>【最家】复古文艺风玻璃花瓶</dd>
                            <dd>￥193.20</dd>
                        </dl>
                    </a>
                    <a href="proDetail.html">
                        <dl>
                            <dt><img src="img/temp/like04.jpg"></dt>
                            <dd>【最家】复古文艺风玻璃花瓶</dd>
                            <dd>￥193.20</dd>
                        </dl>
                    </a>
                    <a href="proDetail.html" class="last">
                        <dl>
                            <dt><img src="img/temp/like05.jpg"></dt>
                            <dd>【最家】复古文艺风玻璃花瓶</dd>
                            <dd>￥193.20</dd>
                        </dl>
                    </a>--%>
                </div>
                <div>
                    <c:forEach items="${guessYouLike}" var="content" varStatus="status">
                        <c:if test="${!status.last}">
                            <a href="proDetail.html?goodsId=149187842867912">
                                <dl>
                                    <dt><img src="${content.prodetPic}"></dt>
                                    <dd>${content.name}</dd>
                                    <dd>￥${content.price}</dd>
                                </dl>
                            </a>
                        </c:if>
                        <c:if test="${status.last}">
                            <a href="proDetail.html?goodsId=149187842867912" class="last">
                                <dl>
                                    <dt><img src="${content.prodetPic}"></dt>
                                    <dd>${content.name}</dd>
                                    <dd>￥${content.price}</dd>
                                </dl>
                            </a>
                        </c:if>
                    </c:forEach>
                   <%-- <a href="proDetail.html">
                        <dl>
                            <dt><img src="img/temp/like01.jpg"></dt>
                            <dd>【最家】复古文艺风玻璃花瓶</dd>
                            <dd>￥193.20</dd>
                        </dl>
                    </a>
                    <a href="proDetail.html">
                        <dl>
                            <dt><img src="img/temp/like02.jpg"></dt>
                            <dd>【最家】复古文艺风玻璃花瓶</dd>
                            <dd>￥193.20</dd>
                        </dl>
                    </a>
                    <a href="proDetail.html">
                        <dl>
                            <dt><img src="img/temp/like03.jpg"></dt>
                            <dd>【最家】复古文艺风玻璃花瓶</dd>
                            <dd>￥193.20</dd>
                        </dl>
                    </a>
                    <a href="proDetail.html">
                        <dl>
                            <dt><img src="img/temp/like04.jpg"></dt>
                            <dd>【最家】复古文艺风玻璃花瓶</dd>
                            <dd>￥193.20</dd>
                        </dl>
                    </a>
                    <a href="proDetail.html" class="last">
                        <dl>
                            <dt><img src="img/temp/like05.jpg"></dt>
                            <dd>【最家】复古文艺风玻璃花瓶</dd>
                            <dd>￥193.20</dd>
                        </dl>
                    </a>--%>
                </div>
            </div>
        </div>
    </div>
</div>
<!--返回顶部-->
<div class="gotop">
    <a href="cart.html">
        <dl class="goCart">
            <dt><img src="img/gt1.png"/></dt>
            <dd>去购<br/>物车</dd>
            <span>1</span>
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
    <a href="#" class="toptop" style="display: none;">
        <dl>
            <dt><img src="img/gt4.png"/></dt>
            <dd>返回<br/>顶部</dd>
        </dl>
    </a>
    <p>400-800-8200</p>
</div>
<div class="msk"></div>
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
<script src="js/jquery.SuperSlide.2.1.1.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
    jQuery(".bottom").slide({
        titCell: ".hd ul",
        mainCell: ".bd .likeList",
        autoPage: true,
        autoPlay: false,
        effect: "leftLoop",
        autoPlay: true,
        vis: 1
    });

    $(".btns a").click(function () {
        if ($(".categ p").hasClass("on")) {
            if ($(this).children().hasClass("buy")) {
                var num = parseInt($(".num span").text());
                var spec = $(".on img").attr("alt");
                $.ajax({
                    type: "get",
                    url: "buyGoods",
                    data: {
                        number:num,
                        spec:spec,
                        id:$("#id").val()
                        /* passWord: $("#passWord").val()*/
                    },
                    dataType: "text",
                    success: function (result) {
                        if (result == 'success') {
                            window.location.href = "order.html";
                        }else {
                            window.location.href = "login.html";
                        }
                    },
                    error: function () {
                    }
                });
            }
            $(".proIntro").css("border", "none");
            $(".num .please").hide();
        } else {
            $(".proIntro").css("border", "1px solid #c10000");
            $(".num .please").show();
        }
    })

</script>
</body>
</html>

