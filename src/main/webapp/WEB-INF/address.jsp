<%--@elvariable id="user" type="cn.edu.ncu.pojo.User"--%>
<%--
  Created by IntelliJ IDEA.
  User: Masters
  Date: 2020/6/2
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--因为tomcat版本问题，自动默认EL表达式不启用要手动启用，加入--%>
<%@ page isELIgnored="false" %>
<html>
<head lang="en">
    <meta charset="utf-8" />
    <title>最家</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/mygxin.css" />
</head>
<body>
<!------------------------------head------------------------------>
<div class="head ding">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top">
            <h1 class="fl"><a href="index.html"><img src="img/logo.png"/></a></h1>
            <div class="fr clearfix" id="top1">
                <p class="fl">
                    <a href="login.html" id="login">登录</a>
                    <a href="reg.html" id="reg">注册</a>
                </p>
                <form action="#" method="get" class="fl">
                    <input type="text" placeholder="搜索" />
                    <input type="button" />
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
        <a href="mygxin.html">个人中心</a>
        <span>/</span>
        <a href="address.html" class="on">地址管理</a>
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
                    <li class="on"><a href="address.html">地址管理</a></li>
                </ul>
                <h4>账户管理</h4>
                <ul>
                    <li><a href="mygrxx.html">个人信息</a></li>
                    <li><a href="remima.html">修改密码</a></li>
                </ul>
            </div>
        </div>
        <div class="you fl">
            <h2>收货地址</h2>
            <div class="add" style="margin-bottom:20px">
                <div>
                    <a href="#2" id="addxad"><img src="img/jia.png"/></a>
                    <span>添加新地址</span>
                </div>

                <c:if test="${defaultAddress!=null}">
                    <div class="dizhi">
                        <p>${defaultAddress.contact}</p>
                        <p>${defaultAddress.mobile}</p>
                        <p>
                           <c:forEach items="${areas}" var="area">
                               <c:if test="${area.areaId == defaultAddress.areaId}">
                                   <c:forEach items="${cities}" var="city">
                                       <c:if test="${city.cityId == area.cityId}">
                                           <c:forEach items="${provinces}" var="province">
                                               <c:if test="${city.provinceId == province.provinceId}">
                                                   ${province.province}
                                               </c:if>
                                           </c:forEach>
                                           ${city.name}
                                       </c:if>
                                   </c:forEach>
                                   ${area.area}
                               </c:if>
                           </c:forEach>
                        </p>
                        <p>${defaultAddress.address}（${defaultAddress.zipCode}）</p>
                        <input class="id" type="hidden" name="id" value="${defaultAddress.addressId}"/>
                    </div>
                </c:if>
            </div>

            <c:if test="${allAddresses!=null}">
                <div style="margin-bottom:20px;display: flex;justify-content: space-around;">
                    <c:forEach items="${allAddresses}" var="address" >
                        <div class="dizhi" style="width: 244px;height: 158px;border: 1px solid #E0E0E0;padding: 20px 0 0 24px;color: #757575;line-height: 20px;">
                            <p style="font-size: 18px;margin-bottom: 25px;color: #262626;">${address.contact}</p>
                            <p>${address.mobile}</p>
                            <p>
                                <c:forEach items="${areas}" var="area">
                                    <c:if test="${area.areaId == address.areaId}">
                                        <c:forEach items="${cities}" var="city">
                                            <c:if test="${city.cityId == area.cityId}">
                                                <c:forEach items="${provinces}" var="province">
                                                    <c:if test="${city.provinceId == province.provinceId}">
                                                        ${province.province}
                                                    </c:if>
                                                </c:forEach>
                                                ${city.name}
                                            </c:if>
                                        </c:forEach>
                                        ${area.area}
                                    </c:if>
                                </c:forEach>
                            </p>
                            <p>${address.address}（${address.zipCode}）</p>
                            <input class="id" type="hidden" name="id" value="${address.addressId}"/>
                        </div>
                    </c:forEach>
                </div>
            </c:if>
        </div>
    </div>
</div>
<!--编辑弹框-->
<!--遮罩-->
<div class="mask"></div>
<div class="adddz">
    <form action="addAddress" method="post">
        <input type="text" name="contact" placeholder="姓名" class="on"/>
        <input type="text" name="mobile" placeholder="手机号"/>
        <div class="city">
            <select name="province">
                <option value="省份/自治区">省份/自治区</option>
                <c:forEach items="${provinces}" var="province">
                    <option value="${province.provinceId}">${province.province}</option>
                </c:forEach>
            </select>
            <select name="city">
                <option value="城市/地区">城市/地区</option>
                <c:forEach items="${cities}" var="city">
                    <option value="${city.cityId}">${city.name}</option>
                </c:forEach>
            </select>
            <select name="town">
                <option value="区/县">区/县</option>
                <c:forEach items="${areas}" var="area">
                    <option value="${area.areaId}">${area.area}</option>
                </c:forEach>
            </select>
            <select>
                <option value="配送区域">配送区域</option>
            </select>
        </div>
        <textarea name="address" rows="" cols="" placeholder="详细地址"></textarea>
        <input type="text" name="alias" placeholder="邮政编码"/>
        <div class="bc">
            <input type="submit" value="保存"/>
            <input type="button" value="取消"/>
        </div>
    </form>
</div>
<div class="readd">
    <form action="" method="post" class="form">
        <input type="text" name="contact" class="on" value="${defaultAddress.contact}"/>
        <input type="text" name="mobile" value="${defaultAddress.mobile}"/>
        <div class="city">
            <select name="province">

                    <c:forEach items="${areas}" var="area">
                        <c:if test="${area.areaId == defaultAddress.areaId}">
                            <c:forEach items="${cities}" var="city">
                                <c:if test="${area.cityId == city.cityId}">
                                    <c:forEach items="${provinces}" var="province">
                                        <c:if test="${city.provinceId == province.provinceId}">
                                            <option value="省份/自治区">
                                                ${province.province}
                                            </option>
                                        </c:if>
                                     </c:forEach>
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>

                <c:forEach items="${provinces}" var="province">
                    <option value="${province.provinceId}">${province.province}</option>
                </c:forEach>
            </select>
            <select name="city">

                    <c:forEach items="${areas}" var="area">
                        <c:if test="${area.areaId == defaultAddress.areaId}">
                            <c:forEach items="${cities}" var="city">
                                <c:if test="${area.cityId == city.cityId}">
                                    <option value="城市/地区">
                                        ${city.name}
                                    </option>
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>

                <c:forEach items="${cities}" var="city">
                    <option value="${city.cityId}">${city.name}</option>
                </c:forEach>
            </select>
            <select name="town">

                    <c:forEach items="${areas}" var="area">
                        <c:if test="${area.areaId == defaultAddress.areaId}">
                            <option value="区/县">
                               ${area.area}
                            </option>
                        </c:if>
                    </c:forEach>

                <c:forEach items="${areas}" var="area">
                    <option value="${area.areaId}">${area.area}</option>
                </c:forEach>
            </select>
            <select>
                <option value="配送区域">配送区域</option>
            </select>
        </div>
        <textarea name="address" rows="" cols="" placeholder="详细地址">${defaultAddress.address}</textarea>
        <input type="text" name="alias" placeholder="邮政编码" value="${defaultAddress.zipCode}"/>
        <div class="bc">
            <input type="submit" value="保存"/>
            <input type="button" value="取消"/>
        </div>
    </form>
</div>
<!--返回顶部-->
<div class="gotop">
    <a href="cart.html">
        <dl>
            <dt><img src="img/gt1.png"/></dt>
            <dd>去购<br />物车</dd>
        </dl>
    </a>
    <a href="#" class="dh">
        <dl>
            <dt><img src="img/gt2.png"/></dt>
            <dd>联系<br />客服</dd>
        </dl>
    </a>
    <a href="mygxin.html">
        <dl>
            <dt><img src="img/gt3.png"/></dt>
            <dd>个人<br />中心</dd>
        </dl>
    </a>
    <a href="#" class="toptop" style="display: none">
        <dl>
            <dt><img src="img/gt4.png"/></dt>
            <dd>返回<br />顶部</dd>
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
    <p class="dibu">最家家居&copy;2013-2017公司版权所有 京ICP备080100-44备0000111000号<br />
        违法和不良信息举报电话：400-800-8200，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</p>
</div>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>


