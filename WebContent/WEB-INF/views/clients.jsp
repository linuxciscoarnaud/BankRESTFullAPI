<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table>
    <tr>
        <th>Code</th>
		<th>Adresse</th>
		<th>Nom</th>
    </tr>
    <c:forEach items="${clients}" var="client">
        <tr>
            <td align="center">${client.codeClient}</td>
            <td align="center">${client.adresseClient}</td>
            <td align="center">${client.nomClient}</td>
        </tr>
    </c:forEach>
</table>