<#import "../se_template/security_layout.ftl" as layout>
<@layout.security_layout "Test" >
    <#assign ctx = rc.getContextPath()/>

<div class="row">
    <div class="col-lg-1"></div>
    <div class="col-lg-4 se-in-msg">${msg!}</div>
</div>
<div class="row">
    <div class="col-lg-1"></div>
    <div class="col-lg-10">
        <div class="block se-block <#--block-fill-white-->">
            <div class="header se-header se-header-bl">
                <h2>Login Log Today</h2>
            </div>
            <div class="content controls">
                <table class="table table-striped">
                    <thead class="se-thead">
                    <tr>
                        <th>ID</th>
                        <th>IN/OUT</th>
                        <th>DATE</th>
                        <th>TIME</th>
                        <th>USER NAME</th>
                    </tr>
                    </thead>
                    <tbody>
                        <#list logList as log>
                        <tr>
                            <td>${log.ID!}</td>
                            <#assign inOut = log.IN?string("Sign In", "Sign Out")>
                            <td>${inOut}</td>
                            <td>${log.DATE!}</td>
                            <td>${log.TIME!}</td>
                            <td>${log.USER_NAME!}</td>
                        </tr>
                        </#list>
                    </tbody>
                </table>
            </div>
            <div class="header se-header se-header-bl">
                <h2>Login Log :: Yesterday</h2>
            </div>
            <div class="content controls">
                <table class="table table-striped">
                    <thead class="se-thead">
                    <tr>
                        <th>ID</th>
                        <th>IN/OUT</th>
                        <th>DATE</th>
                        <th>TIME</th>
                        <th>USER NAME</th>
                    </tr>
                    </thead>
                    <tbody>
                        <#list logList2 as log>
                        <tr>
                            <td>${log.ID!}</td>
                            <#assign inOut = log.IN?string("Sign In", "Sign Out")>
                            <td>${inOut}</td>
                            <td>${log.DATE!}</td>
                            <td>${log.TIME!}</td>
                            <td>${log.USER_NAME!}</td>
                        </tr>
                        </#list>
                    </tbody>
                </table>
            </div>
            <div class="header se-header se-header-bl">
                <h2>Login Log : The day before Yesterday</h2>
            </div>
            <div class="content controls">
                <table class="table table-striped">
                    <thead class="se-thead">
                    <tr>
                        <th>ID</th>
                        <th>IN/OUT</th>
                        <th>DATE</th>
                        <th>TIME</th>
                        <th>USER NAME</th>
                    </tr>
                    </thead>
                    <tbody>
                        <#list logList3 as log>
                        <tr>
                            <td>${log.ID!}</td>
                            <#assign inOut = log.IN?string("Sign In", "Sign Out")>
                            <td>${inOut}</td>
                            <td>${log.DATE!}</td>
                            <td>${log.TIME!}</td>
                            <td>${log.USER_NAME!}</td>
                        </tr>
                        </#list>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
</div>

</@layout.security_layout>