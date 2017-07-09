<#import "../se_template/security_layout.ftl" as layout>
<@layout.security_layout "Test" >
    <#assign ctx = rc.getContextPath()/>
    <#include "../se_template/array.ftl">
<div class="row">
    <div class="col-md-12">
        <div class="block se-block">
            <div class="header se-header">
                <h2>Module And Operation List</h2>
            </div>
            <div class="content controls">
                <table class="table table-striped">
                    <thead class="se-thead">
                    <tr>
                        <th width="5%">ID</th>
                        <th width="15%">Module Name</th>
                        <th width="25%">Module Description</th>
                        <th width="5%">Op.ID</th>
                        <th width="25%">Operation Description</th>
                        <th width="20%">Action</th>

                    </tr>
                    </thead>
                    <tbody>
                        <#assign modId = 1>

                        <#list moduleList as module>
                        <tr>
                            <td>${modId}</td>
                            <td>${module.name!}</td>
                            <td>${module.description!}</td>
                            <td colspan="3">
                                <table width="100%">
                                    <#assign opeId = 1>
                                    <#list module.operationList as operation>
                                        <tr>
                                            <td width="5%">${modId}.${opeId}</td>
                                            <td width="25%">${operation.description!}</td>
                                            <td width="20%">${ctx}/${module.alias!}/${operation.name!}.se</td>
                                        </tr>
                                        <#assign opeId = 1+opeId>
                                    </#list>
                                </table>
                            </td>
                        </tr>
                            <#assign modId = 1+modId>
                        </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</@layout.security_layout>
