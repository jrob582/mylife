<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<%@ include file="theme/header.jsp" %>

<header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-dashboard"></i> Manage Interactions > Add Interactions</b></h5>
</header>

<div class="w3-row-padding w3-half w3-margin-bottom">

    <div class="w3-card-4">
        <div class="w3-container w3-blue">
            <h2>Header</h2>
        </div>

        <form:form method="POST" action="/mylife/interactions/editsave" cssClass="w3-container" commandName="interactions">
            <form:hidden path="interactionid"  />

            <div class="w3-padding-8">
                <label><b>Name</b></label>
                <form:input path="title" cssClass="w3-input w3-border"  />
            </div>

            <div class="w3-padding-8">
                <label><b>Interactions</b></label>
                <form:input path="Interaction Id" cssClass="w3-input w3-border" placeholder="Interaction Id"  />
                <form:errors path="Interaction Id" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="Clients Id" cssClass="w3-input w3-border" placeholder="Clients Id"  />
                <form:errors path="Clients Id" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="Date of Contact" cssClass="w3-input w3-border" placeholder="Date of Contact"  />
                <form:errors path="Date of Contact" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="Contact Name" cssClass="w3-input w3-border" placeholder="Contact Name" />
                <form:errors path="Contact Name" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="Contact Type" cssClass="w3-input w3-border" placeholder="Contact Type" />
                <form:errors path="Contact Type" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="Conversation" cssClass="w3-input w3-border" placerholder="Conversation" />
                <form:errors path="Conversation" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
            </div>

            <div class="w3-padding-8">
                <button type="submit" class="w3-btn w3-padding w3-blue" style="width:120px">Save</button>
            </div>
        </form:form>

    </div>
</div>

<%@ include file="theme/footer.jsp" %>