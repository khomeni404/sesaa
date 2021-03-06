<#assign ctx = rc.getContextPath()/>

<#--<form action="${ctx}/auth/authenticateUser.se" method="POST">
    <input type="text" name="username" value="account"/><br/>
    <input type="password" name="password" value="asadmin"/>
    <br/>
    <input type="submit"/>
</form>-->


<!DOCTYPE html>
<html lang="en">
<head>
    <title>Taurus</title>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <link rel="icon" type="image/ico" href="favicon.ico"/>

    <link href="../resources/taurus/HTML/css/stylesheets.css" rel="stylesheet" type="text/css"/>


    <script type='text/javascript' src='../resources/taurus/HTML/js/plugins/jquery/jquery.min.js'></script>
    <script type='text/javascript' src='../resources/taurus/HTML/js/plugins/jquery/jquery-ui.min.js'></script>
    <script type='text/javascript' src='../resources/taurus/HTML/js/plugins/jquery/jquery-migrate.min.js'></script>
    <script type='text/javascript' src='../resources/taurus/HTML/js/plugins/jquery/globalize.js'></script>
    <script type='text/javascript' src='../resources/taurus/HTML/js/plugins/bootstrap/bootstrap.min.js'></script>

    <script type='text/javascript' src='../resources/taurus/HTML/js/plugins/uniform/jquery.uniform.min.js'></script>

    <script type='text/javascript' src='../resources/taurus/HTML/js/plugins.js'></script>
    <script type='text/javascript' src='js/actions.js'></script>
    <script type='text/javascript' src='js/settings.js'></script>
</head>
<body class="bg-img-num3">

<div class="container">
    <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-lg-10 pull-right" style="padding-bottom: 20px; text-align: right">
            <img src="../resources/images/logo/soft_engine_security.png" height="44" width="477" class=""/><br/>
            <img src="../resources/images/logo/for_aa_3.png" height="81" width="578" class=""/>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-5">
            <form name="loginForm" action="${ctx}/auth/authenticateUser.se" method="POST">
                <div class="login-block">
                    <div class="block block-transparent text-left">
                        <div class="content controls npt pull-right">
                            <div class="form-row">
                                <div class="col-md-12">
                                    <div class="input-group">
                                        <div class="input-group-addon">
                                            <span class="icon-user"></span>
                                        </div>
                                        <input type="text" name="username" class="form-control" placeholder="Username"
                                               value="mak"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col-md-12">
                                    <div class="input-group">
                                        <div class="input-group-addon">
                                            <span class="icon-key"></span>
                                        </div>
                                        <input type="password" name="password" class="form-control"
                                               placeholder="Password" value="man"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col-md-6">
                                    <a href="#" class="btn btn-info btn-block">Clear</a>
                                </div>
                                <div class="col-md-6">
                                    <a href="#" id="submit-btn" class="btn btn-success btn-block">Log In</a>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col-md-12">
                                    <a href="#" class="btn btn-link btn-block">Forgot your password?</a>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-5 text-center">
            <img src="../resources/images/logo/sesaa_logo.png" height="119" width="445" class=""/>
        </div>
    </div>
</div>


</body>
</html>

<script>
    $('#submit-btn').click(function () {
        document.loginForm.submit();
    });
</script>