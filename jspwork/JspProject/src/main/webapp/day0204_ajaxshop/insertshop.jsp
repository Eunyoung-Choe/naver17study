<jsp:useBean id="dao" class="shop.data.ShopDao"/>
<jsp:useBean id="dto" class="shop.data.ShopDto"/>
<jsp:setProperty property="*" name="dto"/>

<%
   dao.insertShop(dto);
%>