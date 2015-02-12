<%-- 
    Document   : template
    Created on : Feb 12, 2015, 9:42:30 PM
    Author     : anonymous
--%>

<%@page import="com.blogspot.na5cent.htmlcssjs.util.JspUtils"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.Reader"%>
<%@page import="java.io.InputStream"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="<%= request.getServletContext().getContextPath()%>/static/third-party/highlight/styles/default.css" rel="stylesheet"/>
        <script src="<%= request.getServletContext().getContextPath()%>/static/third-party/highlight/highlight.pack.js"></script>
        <script>hljs.initHighlightingOnLoad();</script>
        <style>
            h1{
                border-bottom: 1px solid #ddd;
                margin : 0 0 20px 0;
                padding: 0 0 20px 0;
            }

            body{
                margin: 0;
                padding: 20px;
            }

            .page-left{
                float: left;
                width: 50%;
            }

            .page-left-content{
                padding-right: 20px;
            }

            .page-right{
                float: right;
                width: 50%;
            }

            .page-right > div{
                margin-bottom: 20px;
            }

            .clear{
                clear : both;
            }

            iframe{
                width: 100%;
                height: 300px;
                border : solid 1px #ccc;
            }
        </style>
    </head>
    <body>