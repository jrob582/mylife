<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<%@ include file="theme/header.jsp" %>

  <header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-dashboard"></i> Manage Client</b></h5>
  </header>

  <div class="w3-row-padding w3-margin-bottom">
    
  <c:if test="${not empty message}">
    <c:choose>
      <c:when test="${message.type eq 'INFO'}">
        <div class="w3-panel w3-border w3-pale-yellow w3-border-yellow"><p>${message.message}</p></div>
      </c:when>
      <c:when test="${message.type eq 'ERROR'}">
        <div class="w3-panel w3-border w3-pale-red w3-border-red"><p>${message.message}</p></div>
      </c:when>
    </c:choose>
    
  </c:if>

  <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">  
    <tr>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Action</th>
    </tr>  

    <c:forEach var="client1" items="${list}">   
      <tr>  
        <td>${client1.firstname}</td>  
        <td>${client1.lastname}</td>
        <td>
          <a href="<c:url value="/client1/editclient1/${client1.idclient1}" />"><button class="w3-btn w3-round w3-blue">Edit</button></a>
          <a href="<c:url value="/client1/deleteclient1/${client1.idclient1}" />"><button class="w3-btn w3-round w3-red">Delete</button></a>
          <a href="<c:url value="/interactions/interactionsform/${client1.idclient1}" />"><button class="w3-btn w3-round w3-green">Add Interactions</button></a>
        </td>  
      </tr>  
    </c:forEach>  
  </table> 

  <div class="w3-padding-8">
    <ul class="w3-pagination">
      <c:forEach begin="1" end="${pages}" varStatus="p">  
        <li><a class="<c:if test="${p.index eq page}">w3-green</c:if>" href="<c:url value="/client1/viewclient1/${p.index}" />">${p.index}</a></li>
      </c:forEach>
    </ul>
  </div>
    
  </div>

<%@ include file="theme/footer.jsp" %>