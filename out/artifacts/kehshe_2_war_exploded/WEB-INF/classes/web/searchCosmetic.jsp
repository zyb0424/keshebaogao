<%@ page contentType="text/html;charset=GB2312" %>
<HTML><HEAD><%@ include file="head.txt" %></HEAD>
<BODY background=image/back2.jpg><font size=2>
<div align="center">
<br>��ѯʱ�������뻯ױƷ�İ汾�Ż�ױƷ���Ƽ��۸�<br>
��ױƷ����֧��ģ����ѯ��
<br>����۸�����2��ֵ֮��ļ۸񣬸�ʽ�ǣ��۸�1-�۸�2<br>
���� 0-1000
<FORM action="searchByConditionServlet" Method="post" >
   <br>�����ѯ��Ϣ:<Input type=text name="searchMess"><br>
   <Input type =radio name="radio" value="cosmetic_number">��Ʒ�汾��
   <Input type =radio name="radio" value="cosmetic_name" checked="ok">��Ʒ����
   <Input type =radio name="radio" value="cosmetic_price">��Ʒ�۸�
   <br><Input type=submit name="g" value="�ύ">
</Form>
</div>
</Font></BODY></HTML>
