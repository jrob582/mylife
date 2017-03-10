<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<%@ include file="theme/header.jsp" %>

<header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-dashboard"></i> Client > Client</b></h5>
</header>

<div class="w3-row-padding w3-half w3-margin-bottom">

    <div class="w3-card-4">
        <div class="w3-container w3-blue">
            <h2>Client Information</h2>
        </div>

        <form:form method="POST" action="/mylife/client1/editsave" cssClass="w3-container" commandName="client1">
            <form:hidden path="idclient1"  />

            <div class="w3-padding-8">
                <label><b>Name</b></label>
                <form:input path="Firstname" cssClass="w3-input w3-border" placeholder="Firstname"  />
                <form:errors path="Firstname" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="Lastname" cssClass="w3-input w3-border" placeholder="Lastname"  />
                <form:errors path="Lastname" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="Addressline1" cssClass="w3-input w3-border" placeholder="Addressline1"  />
                <form:errors path="Addressline1" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="Addressline2" cssClass="w3-input w3-border" placeholder="Addressline2" />
                <form:errors path="Addressline2" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="City" cssClass="w3-input w3-border" placeholder="City" />
                <form:errors path="City" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="State" cssClass="w3-input w3-border" placerholder="State" />
                <form:errors path="State" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="Zip" cssClass="w3-input w3-border" placeholder="Zip" />
                <form:errors path="Zip" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="Email" cssClass="w3-input w3-border" placeholder="Email" />
                <form:errors path="Email" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="Current_status" cssClass="w3-input w3-border" placeholder="Current_status" />
                <form:errors path="Current_status" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="Phone_number" cssClass="w3-input w3-border" placeholder="Phone_number" />
                <form:errors path="Phone_number" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
            </div>

            <div class="w3-padding-8">
                <button type="submit" class="w3-btn w3-padding w3-blue" style="width:120px">Update</button>
            </div>
        </form:form>

    </div>
</div>

<%@ include file="theme/footer.jsp" %>
