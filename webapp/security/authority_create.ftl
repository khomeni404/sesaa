<#import "../se_template/security_layout.ftl" as layout>
<@layout.security_layout "Test" >
    <#assign ctx = rc.getContextPath()/>

<div class="row">
    <form action="${ctx}/security/saveAuthority.se" method="post">
        <div class="col-md-12" style="color: red; font-size: 20px;">${message!}</div>
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <div class="block se-block <#--block-fill-white-->">
                <div class="header se-header">
                    <h2>New AUTHORITY</h2>
                </div>
                <div class="content controls">
                    <div class="form-row">
                        <div class="col-md-3 text-right">AUTHORITY NAME.</div>
                        <div class="col-md-4">
                            <input type="text" name="name" class="form-control"
                                   value=""/>
                        </div>


                    </div>

                    <div class="form-row">
                        <div class="col-md-3 text-right">AUTHORITY DESCRIPTION</div>
                        <div class="col-md-4">
                            <textarea name="desc" id="desc" cols="5" class="form-control se-textarea"></textarea>
                        </div>
                        <div class="col-md-3"><input type="submit" class="form-control btn btn-success"
                                                     value="Save Authority"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
<div class="row">
    <div class="col-lg-1"></div>
    <div class="col-lg-4 se-in-msg">${msg!}</div>
</div>
<div class="row">
    <div class="col-lg-1"></div>
    <div class="col-lg-10">
        <div class="block se-block <#--block-fill-white-->">
            <div class="header se-header se-header-bl">
                &Lopf;&iopf;&sopf;&topf;
            </div>
            <div class="content controls">
                <table class="table table-striped">
                    <thead class="se-thead">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Description</th>
                    </tr>
                    </thead>
                    <tbody>
                        <#list authorityList as authority>
                        <tr>
                            <td>${authority.id!}</td>
                            <td>${authority.name!}</td>
                            <td>${authority.description!}</td>
                        </tr>
                        </#list>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
</div>

</@layout.security_layout>