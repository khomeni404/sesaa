<#import "../se_template/security_layout.ftl" as layout>
<@layout.security_layout "Test" >
    <#assign ctx = rc.getContextPath()/>
    <#include "../se_template/array.ftl">
<style>
    .menu-label {
        color: black;
        font-weight: bolder
    }
</style>
<#--<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10 navbar brb" role="navigation">
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle menu-label" data-toggle="dropdown"><span
                            class="icon-user"></span> Admin</a>
                    <ul class="dropdown-menu">
                        <li><a href="${ctx}/admin/createStaff.se"><span class="icon-plus-sign-alt"></span>&nbsp;&nbsp;
                            Create Staff</a></li>
                        <li><a href="${ctx}/admin/createCustomer.se"><span class="icon-plus-sign-alt"></span>&nbsp;&nbsp;
                            Create Customer</a></li>
                        <li><a href="${ctx}/admin/createManufacturer.se"><span class="icon-plus-sign-alt"></span>&nbsp;&nbsp;
                            Create Manufacturer</a></li>
                        <li><a href="${ctx}/admin/staffList.se"><span class="icon-th-list"></span>&nbsp;&nbsp; Staff
                            List</a></li>
                        <li><a href="${ctx}/admin/customerList.se"><span class="icon-th-list"></span>&nbsp;&nbsp;
                            Customer
                            List</a></li>

                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>-->
<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10" style="">
        <div class="block se-block row <#--header se-header--> text-center" style="padding: 50px 50px 80px 50px">
            <div class="col-lg-4"><a href="#"><i class="icon-plus-sign-alt text-info icon-5x"></i> <br/><span
                    class="menu-label">Create Staff</span></a></div>
            <div class="col-lg-4"><a href="#"><i class="icon-puzzle-piece text-info icon-5x"></i> <br/><span
                    class="menu-label">Create Staff</span></a></div>
            <div class="col-lg-4"><a href="#"><i class="icon-list text-info icon-5x"></i> <br/><span class="menu-label">Create Staff</span></a>
            </div>
        </div>

        <div class="block se-block row <#--header se-header--> text-center" style="padding: 50px 50px 80px 50px">
            <div class="col-lg-4"><a href="#"><i class="icon-ticket text-info icon-5x"></i> <br/><span
                    class="menu-label">Create Staff</span></a></div>
            <div class="col-lg-4"><a href="#"><i class="icon-xing text-info icon-5x"></i> <br/><span class="menu-label">Create Staff</span></a>
            </div>
            <div class="col-lg-4"><a href="#"><i class="icon-list text-info icon-5x"></i> <br/><span class="menu-label">Create Staff</span></a>
            </div>
        </div>

        <div class="block se-block row <#--header se-header--> text-center" style="padding: 50px 50px 80px 50px">
            <div class="col-lg-4"><a href="#"><i class="icon-cny text-info icon-5x"></i> <br/><span class="menu-label">Create Staff</span></a>
            </div>
            <div class="col-lg-4"><a href="#"><i class="icon-user text-info icon-5x"></i> <br/><span class="menu-label">Create Staff</span></a>
            </div>
            <div class="col-lg-4"><a href="#"><i class="icon-rocket text-info icon-5x"></i> <br/><span
                    class="menu-label">Create Staff</span></a></div>
        </div>

    </div>
</div>
</@layout.security_layout>
