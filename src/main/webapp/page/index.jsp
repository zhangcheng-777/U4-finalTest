<%@ page pageEncoding="utf-8" language="java" contentType="text/html;utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>出库管理</title>
    <script src="../js/jquery-1.8.3.js"></script>
    <script>
        $(function () {
            $("#quantity").blur(function () {
                $.post("selectQuantity",{"id":$("#proId").val()},function (data) {
                    if($("#quantity").val()>data.quantity && $("#quantity").val()!=null){
                        $("#notice").text("所选商品库存不足,库存量为"+data.quantity).css("color","red")
                    }else {
                        $("#notice").text("库存充足").css("color","green")
                    }
                },"json")
            })
        })
    </script>
</head>
<body>
<c:if test="${list==null}">
    <jsp:forward page="/page/getAllProduct"></jsp:forward>
</c:if>
<c:if test="${flag>=1}">
    <script>
        alert("操作成功!")
    </script>
</c:if>
    <h1>商品出库</h1>
    <form action="/page/outProduct" method="post" onsubmit="return check()">
        <table border="0" cellpadding="5" cellspacing="0">
            出库商品:&nbsp;&nbsp;
            <select name="productid" id="proId">
                <option value="0">--请选择出库商品</option>
                <c:forEach items="${list}" var="pro">
                    <option value="${pro.id}">${pro.productname}</option>
                </c:forEach>
            </select><br><br>
            数量:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="text" name="quantity" id="quantity">
            <span id="notice"></span>
            <br><br>
            经手人: <input type="text" name="handler" id="handler"><br><br>
            <input type="submit" value="提交">&nbsp;
            <input type="reset" value="重置">
        </table>
    </form>
</body>
<script>
    function check() {
        if($("#proId").val()==0){
            alert("请选择出库商品!");
            return false;
        }
        if($("#quantity").val()==""){
            alert("请填写出库数量!");
            return false;
        }
        if($("#handler").val()==""){
            alert("请填写经手人!");
            return false;
        }
        return true;
    }
</script>
</html>
