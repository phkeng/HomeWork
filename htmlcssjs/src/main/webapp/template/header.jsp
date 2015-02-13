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
        <title>Learn Html Css Javascript / Servet</title>
        <link href="<%= request.getServletContext().getContextPath()%>/static/third-party/highlight/styles/monokai.css" rel="stylesheet"/>
        <script src="<%= request.getServletContext().getContextPath()%>/static/third-party/highlight/highlight.pack.js"></script>
        <script src="<%= request.getServletContext().getContextPath()%>/static/third-party/jquery.js"></script>
        <script>hljs.initHighlightingOnLoad();</script>
        <style>
            h1{
                border-bottom: 1px solid #ddd;
                margin : 0 0 20px 0;
                padding: 0 0 20px 0;
            }

            body{
                margin: 0;
                padding: 10px 20px 20px 20px;
            }
            
            .toolbar{
                padding: 10px;
                margin-bottom: 10px;
            }

            .content-left{
                float: left;
                width: 50%;
            }

            .content-left-content{
                padding-right: 20px;
            }

            .content-right{
                float: right;
                width: 50%;
            }

            .content-right > strong{
                margin-bottom: 20px;
                display: block;
            }

            .clear{
                clear : both;
            }

            iframe{
                width: 100%;
                height: 300px;
                border : solid 1px #bbb;
            }

            .prev-next-button{
                position: absolute;
                top: 20px;
                right: 30px;
            }

            .iframe-reload-button{
                margin-top: 10px;
            }
            
            hr{
                border-style : solid;
                border-color: #ccc;
                border-width: 1px 0 0 0;
                height: 0;
                margin-bottom: 60px;
            }
            
            .iframe-reload-button{
                display: none;
            }
            
            .prev-next-button{
                display: none;
            }
            
            .message-block{
                background-color: rgb(207, 255, 202);
                padding: 10px;
            }
        </style>
        <script>
            (function($) {
                function reloadIframe($iframe) {
                    var src = $iframe.attr('src');
                    if (src) {
                        var index = src.indexOf('?');
                        if (index !== -1) {
                            src = src.substr(0, index);
                        }

                        $iframe.attr('src', src + "?timestamp=" + new Date().getTime());
                    }
                }

                $(function() {
                    $(document).on('click', '.iframe-reload-button', function(){
                        var $iframe = $(this).parents('.example-iframe').find('iframe');
                        reloadIframe($iframe);
                    });
                });
            })(jQuery);
        </script>
    </head>
    <body>
        <div class="toolbar">
            <a href="<%= request.getServletContext().getContextPath()%>">หน้าแรก</a>
        </div>