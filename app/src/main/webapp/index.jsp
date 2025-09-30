<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<html>
<head>
    <style>
        .d-flex {
            display: flex;
        }

        .row {
            flex-direction: row;
        }

        .col {
            flex-direction: column;
        }

        .gap-2 {
            gap: 1.5rem;
        }
    </style>
</head>
<body>
<h2>Calculator</h2>
<form method="GET" action="calculate" class="d-flex col gap-2">
    <input name="a" placeholder="A" type="number" value="${a}"/>

    <select name="op">
        <option value="add" <%= java.util.Objects.equals(request.getAttribute("op"), "add") ? "selected" : "" %> >Add</option>
        <option value="subtract" <%= java.util.Objects.equals(request.getAttribute("op"), "subtract") ? "selected" : "" %> >Subtract</option>
        <option value="multiply" <%= java.util.Objects.equals(request.getAttribute("op"), "multiply") ? "selected" : "" %> >Multiply</option>
        <option value="divide" <%= java.util.Objects.equals(request.getAttribute("op"), "divide") ? "selected" : "" %> >Divide</option>
    </select>

    <input name="b" placeholder="B" type="number" value="${b}"/>

    <button type="submit">Calculate this bih</button>
</form>

<%
    Object result = request.getAttribute("result");
    if (result != null) {
%>
<h3>Result: ${result}</h3>
<% } %>

</body>
</html>
