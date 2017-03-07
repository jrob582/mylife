<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<%@ include file="theme/header.jsp" %>

<header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-dashboard"></i> Manage Interactions > Add Interactions</b></h5>
</header>

<div class="w3-row-padding w3-half w3-margin-bottom">

    <div class="w3-card-4">
        <div class="w3-container w3-red">
            <h2>Interactions Information</h2>
        </div>

        <form:form method="post" action="/My Life/interactions/save" cssClass="w3-container" commandName="interactions"> 
            <div class="w3-padding-8">
                <label><b>Interactions</b></label>
                <form:input path="Interaction_Id" cssClass="w3-input w3-border" placeholder="Interaction_Id"  />
                <form:errors path="Interaction_Id" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="Clients_id" cssClass="w3-input w3-border" placeholder="Clients_id"  />
                <form:errors path="Clients_id" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="Date_of_contact" cssClass="w3-input w3-border" placeholder="Date_of_contact"  />
                <form:errors path="Date_of_contact" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="Contact_name" cssClass="w3-input w3-border" placeholder="Contact_name"  />
                <form:errors path="Contact_name" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="Contact_type" cssClass="w3-input w3-border" placeholder="Contact_type"  />
                <form:errors path="Contact_type" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="Conversation" cssClass="w3-input w3-border" placeholder="Conversation"  />
                <form:errors path="Conversation" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
            </div>

            <c:choose>
                <c:when test="${not empty client1.client1}">
                    <form:hidden path="clients_id" />
                    <div class="w3-padding-8">
                        <label><b>Client1</b></label>
                        <div class="w3-panel w3-border">
                            <p><b>${client1.client1.Firstname}</b></p>
                        </div>
                    </div>
                </c:when>

                <c:otherwise>
                    <div class="w3-padding-8">
                        <label><b>Client / Prospect</b></label>
                        <form:select path="clients_id" cssClass="w3-select w3-border">
                            <form:option value="-1">Select Client</form:option>
                            <form:option value="-2">Select Prospect</form:option>
                            <form:options items="${client1.client1}"  />
                        
                        </form:select>
                    </div>
                </c:otherwise>
            </c:choose>

            <div class="w3-padding-8">
                <button type="submit" class="w3-btn w3-padding w3-red" style="width:120px">Save</button>
            </div>
        </form:form>
    </div>

</div>

<%@ include file="theme/footer.jsp" %>