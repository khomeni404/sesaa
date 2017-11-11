<#import "../se_template/security_layout.ftl" as layout>
<@layout.security_layout "Test" >
    <#assign ctx = rc.getContextPath()/>
<#--<link href="../resources/plugins/jQueryTree-Multiselect/jquery.tree-multiselect.min.css"
      rel="stylesheet" type="text/css">-->

<form action="${ctx}/security/updateAuthorityOperations.se" method="post">
    <div class="row">
        <div class="col-md-12" style="color: red; font-size: 20px;">${message!}</div>
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <div class="block se-block <#--block-fill-white-->">
                <div class="header se-header">
                    <h2>Operation Assigning</h2>
                </div>
                <div class="content controls">
                    <div class="form-row">
                        <div class="col-md-3 text-right">Authority</div>
                        <div class="col-md-8">
                            <select name="authId[]" multiple="multiple" placeholder="Select Employee"
                                    style="width:400px "
                                    onchange="console.log($(this).children(':selected').length)" class="testSelAll">
                                <#list authorityList as auth>
                                    <option value="${auth.id}">${auth.name}</option>
                                </#list>
                            </select>
                        <#--
                          <select name="authId" id="authId" class="form-control se-select">
                              <#list authorityList as auth>
                                  <option value="${auth.id}">${auth.name}</option>
                              </#list>
                          </select>-->
                        </div>


                    </div>
                    <div class="form-row">

                        <div class="col-md-3"></div>
                        <div class="col-md-4">
                            <input type="submit" class="form-control btn btn-success"
                                   value="Assign Operations to Authority"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-lg-4 se-in-msg"></div>
    </div>
    <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-lg-10">
            <div class="block se-block <#--block-fill-white-->">
                <div class="header se-header se-header-bl">
                    <h2>Operation List</h2>
                </div>
                <div class="content">
                    <select name="authId2[]" multiple="multiple" placeholder="Select Employee" style="width:400px "
                            onchange="console.log($(this).children(':selected').length)" class="testSelAll">
                    <#--<#list authorityList as auth>
                        <option value="${auth.id}">${auth.name}</option>
                    </#list>-->
                        <#list moduleList as module>
                            <optgroup label="${module.name}">
                                <#list module.operationList as op>
                                    <option id="${op.id}" value="${op.id}"
                                            data-section="${module.name}">${op.description}</option>
                                </#list>
                            </optgroup>
                        </#list>
                    </select>
                    <select name="authId3[]" multiple="multiple" placeholder="Select Employee" style="width:400px "
                            onchange="console.log($(this).children(':selected').length)" class="testSelAll">
                        <option value="standard-option1">Standard Option 1</option>
                        <option value="standard-option2">Standard Option 2</option>
                        <optgroup label="An Optgroup!">
                            <option value="optgroup-option1">Optgroup Option 1</option>
                            <option value="optgroup-option2">Optgroup Option 2</option>
                        </optgroup>
                        <option value="standard-option4">Standard Option 4</option>
                    </select>
                <#--<select id="operationIds" name="operationIds" multiple="multiple">
                    <#list moduleList as module>
                        &lt;#&ndash;<option value="Hello" data-section="Admin" selected="selected">Hello</option>&ndash;&gt;
                        <#list module.operationList as op>
                            <option id="${op.id}" value="${op.id}" data-section="${module.name}">${op.description}</option>
                        </#list>
                    </#list>
                </select>-->
                </div>

            </div>

        </div>
    </div>
</form>
</@layout.security_layout>

<script src="../resources/js/jquery-1.11.1.js"></script>
<#--<script src="../resources/js/jQueryPlugin/jquery-ui.js"></script>-->
<#--<script src="../resources/plugins/jQueryTree-Multiselect/jquery.tree-multiselect.min.js"></script>-->
<script src="../resources/plugins/sumoselect-3.0.2/jquery.sumoselect.js"></script>
<link href="../resources/plugins/sumoselect-3.0.2/sumoselect.min.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript">
    $(document).ready(function () {
        window.testSelAll = $('.testSelAll').SumoSelect({okCancelInMulti: true, selectAll: true});
        //$('#s-a2').prop('selected', 'selected');
        $('.testSelAll')[0].sumo.selectItem(2);
        /*$('.btnOk').on('click', function () {
            var obj = [];
            $('option:selected').each(function () {
                obj.push($(this).index());
                alert("Selected Values==" + $(this).val());
            });

            for (var i = 0; i < obj.length; i++) {
                $('.testSelAll')[0].sumo.unSelectItem(obj[i]);
            }
        });*/
    });

</script>

<script type="text/javascript">
    var options = {
        sortable: true,
        startCollapsed: true
    };
    $("select#operationIds").treeMultiselect(options);

    function showData() {
        var data = $('#operationIds').val();
        alert(data);
    }

    var id = 'op-id-155';
    $("#operationIds option[id='155']").attr("selected", "selected");
    $(function () {
        //$('#op-id-155').prop('selected', 'selected');
    });

    /*$('#operationIds option').filter(function(){
        return this.id === id
    }).prop('selected', true);*/

</script>