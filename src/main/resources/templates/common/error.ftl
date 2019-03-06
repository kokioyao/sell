<!doctype html>
<html lang="en">
<head>
    <#include "header.ftl">
</head>
<body>
<div id="wrapper" class="toggled">

    <#--边栏-->
    <#include "../common/nav.ftl">
    <#--主要内容-->
    <div id="page-content-wrapper">

        <div class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <div class="alert alert-dismissable alert-danger">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                        <h4>
                            注意!
                        </h4>
                        <strong>${msg}</strong>
                        <a href="#" class="alert-link">5s自动跳转</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
<script>
    setTimeout('location.href="${url}"', 5000)
</script>
</html>