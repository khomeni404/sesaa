<#import "../se_template/security_layout.ftl" as layout>
<@layout.security_layout  title="${PageTitle!}">
    <#assign ctx = rc.getContextPath()/>
    <#include "../se_template/array.ftl">
<style>
    .menu-label {
        color: black;
        font-weight: bolder
    }
    .menu-row{padding: 10px}
</style>

<div class="row">
    <div class="col-md-12" style="padding: 50px 50px 80px 50px">
        <div class="block se-block row menu-row <#--header se-header--> text-center">

            <div class="col-lg-3"><a href="${ctx}/security/createOperation.se"><i class="icon-pencil text-info icon-3x"></i> <br/><span
                    class="menu-label">Create Operation</span></a></div>
            <div class="col-lg-3"><a href="${ctx}/security/operationList.se"><i class="icon-list text-info icon-3x"></i> <br/><span
                    class="menu-label">Operation List</span></a></div>

            <div class="col-lg-3"><a href="${ctx}/security/createAuthority.se"><i class="icon-bookmark-empty text-info icon-3x"></i> <br/><span
                    class="menu-label">Create Authority</span></a></div>

            <div class="col-lg-3"><a href="${ctx}/security/createGroup.se"><i class="icon-plus-sign-alt text-info icon-3x"></i> <br/><span
                    class="menu-label">Create Group</span></a></div>

        </div>

        <div class="block se-block row menu-row <#--header se-header--> text-center">
            <div class="col-lg-3"><a href="${ctx}/time/loginLogList.se"><i class="icon-list text-info icon-3x"></i> <br/><span
                    class="menu-label">Login Log List</span></a></div>

            <#--<a href="${ctx}/security/editPassword.se" class="list-group-item"><span class="icon-key"></span>Change Password</a>-->

            <div class="col-lg-3"><a href="${ctx}/security/editPassword.se"><i class="icon-key text-info icon-3x"></i> <br/><span
                    class="menu-label">Change Password</span></a></div>
        </div>
        <div class="block se-block row menu-row <#--header se-header--> text-center">
            <div class="col-lg-3"><a href="${ctx}/security/assigningOperations.se"><i class="icon-random text-info icon-3x"></i> <br/><span
                    class="menu-label">Operation >> Authority</span></a></div>
            <div class="col-lg-3"><a href="${ctx}/security/assigningAuthorities.se">
                <i class="icon-random text-info icon-3x"></i> <br/><span class="menu-label">
                Authority >> Group</span></a>
            </div>
            <div class="col-lg-3"><a href="${ctx}/security/assigningGroups.se"><i class="icon-random text-info icon-3x"></i> <br/><span
                    class="menu-label">Group >> User</span></a></div>
        </div>
        <div class="block se-block row menu-row <#--header se-header--> text-center">

            <div class="col-lg-3"><a href="${ctx}/pub/resetStock.se"><i class="icon-random text-info icon-3x"></i> <br/><span
                    class="menu-label">Reset Stock</span></a></div>
        </div>


    </div>
</div>

<#--<div class="row">
    <div class="col-md-6">
        <div class="block se-block">
            <div class="header">
                <h2>Stock Ledger List</h2>
            </div>
            <div class="content controls">
                <table class="table table-striped">
                    <thead class="se-thead">
                    <tr>
                        <th>Stock Date</th>
                        <th>Ref No.</th>
                        <th>Source</th>
                        <th>Status</th>
                        <th>Total Cost</th>
                        <th>Operator</th>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                        <#list stockLedgerList as ledger>
                        <tr>
                            <td>${ledger.stockDate!}</td>
                            <td>${ledger.refNo!}</td>
                            <td>${(ledger.source.name)!}</td>
                            <td>${QU.getLedgerStatus(ledger.status!0)!}</td>
                            <td class="se-amt">${ledger.totalAmount!}/-</td>
                            <td>${(ledger.dataOperator.nickName)!}</td>

                        </tr>
                        </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>-->
</@layout.security_layout>
