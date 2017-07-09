<div class="block block-drop-shadow">
    <div class="user bg-default bg-light-rtl">
        <img src="../resources/images/logo/sesaa_logo.png" class="img-responsive img-thumbnail"/>
    </div>
    <div class="content list-group list-group-icons">
        <a href="${ctx}/security/home.se" class="list-group-item"><span class="icon-home"></span>Security Home</a>
        <#--<a href="${ctx}/home/home.se" class="list-group-item"><span class="icon-home"></span>Home</a>-->
        <a href="${ctx}/security/editPassword.se" class="list-group-item"><span class="icon-key"></span>Change Password</a>
        <a href="${ctx}/auth/logout.se" class="list-group-item"><span class="icon-off text-danger"></span>Logout</a>
    </div>
</div>

<div class="block block-drop-shadow">
    <div class="user bg-default bg-light-rtl">

            <img src="../resources/images/common/sec_sign_1.png" class="img-responsive img-thumbnail"/>

    </div>
</div>
<#--

<div class="block block-drop-shadow">
    <div class="head bg-dot20">
        <h2>CPU</h2>

        <div class="side pull-right">
            <ul class="buttons">
                <li><a href="#"><span class="icon-cogs"></span></a></li>
            </ul>
        </div>
        <div class="head-subtitle">Intel Core2 Duo T6670 2.20GHz</div>
        <div class="head-panel nm">
            <div class="hp-info hp-simple pull-left hp-inline">
                <span class="hp-main">Core 0 <span class="icon-angle-right"></span> 89%</span>

                <div class="hp-sm">
                    <div class="progress progress-small">
                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="89"
                             aria-valuemin="0" aria-valuemax="100" style="width: 89%"></div>
                    </div>
                </div>
            </div>
            <div class="hp-info hp-simple pull-left hp-inline">
                <span class="hp-main">Core 1 <span class="icon-angle-right"></span> 56%</span>

                <div class="hp-sm">
                    <div class="progress progress-small">
                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="56"
                             aria-valuemin="0" aria-valuemax="100" style="width: 56%"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="block block-drop-shadow">
    <div class="head bg-dot20">
        <h2>Memory</h2>

        <div class="side pull-right">
            <ul class="buttons">
                <li><a href="#"><span class="icon-cogs"></span></a></li>
            </ul>
        </div>
        <div class="head-subtitle">Kingston 2x8Gb DDR3 1866MHz</div>
        <div class="head-panel nm tac">
            <div class="sparkline">
                <span sparkType="pie" sparkWidth="100" sparkHeight="100">5079,3768,7537</span>
            </div>
        </div>
        <div class="head-panel nm">
            <div class="hp-info hp-simple pull-left hp-inline">
                <span class="hp-main"><span class="icon-circle"></span> Allocated 5079 Mb [ 31% ]</span>
            </div>
            <div class="hp-info hp-simple pull-left hp-inline">
                <span class="hp-main"><span class="icon-circle text-info"></span> In Cache 3768 Mb [ 23% ]</span>
            </div>
            <div class="hp-info hp-simple pull-left hp-inline">
                <span class="hp-main"><span class="icon-circle text-primary"></span> Aviable 7537 Mb [ 46% ]</span>
            </div>
        </div>
    </div>
</div>
<div class="block block-drop-shadow">
    <div class="head bg-dot20">
        <h2>Volumes status</h2>

        <div class="side pull-right">
            <ul class="buttons">
                <li><a href="#"><span class="icon-cogs"></span></a></li>
            </ul>
        </div>
        <div class="head-subtitle">WD Caviar Blue 1TB</div>
        <div class="head-panel nm tac" style="line-height: 0px;">
            <div class="knob">
                <input type="text" data-fgColor="#3F97FE" data-min="0" data-max="1024" data-width="100"
                       data-height="100" value="654" data-readOnly="true"/>
            </div>
        </div>
        <div class="head-panel nm">
            <div class="hp-info hp-simple pull-left hp-inline">
                <span class="hp-main">Volume 1 [ 0.5 TB ]</span>
                <span class="hp-sm">Used: 450.0 GB [ 90% ] </span>
                <span class="hp-sm">Free: 50.0 GB [ 10% ] </span>
            </div>
            <div class="hp-info hp-simple pull-left hp-inline">
                <span class="hp-main">Volume 2 [ 0.5 TB ]</span>
                <span class="hp-sm">Used: 154.0 GB [ 30% ] </span>
                <span class="hp-sm">Free: 346.0 GB [ 70% ] </span>
            </div>
        </div>
    </div>

</div>
-->

<input type="hidden" value="${focusOn!}" id="focusOn"/>
<script>
    $(function () {
        var focusOn = '#' + $('#focusOn').val();
        //alert(focusOn);
        $(focusOn).focus();
    })
</script>