
//<editor-fold defaultstate="collapsed" desc="INIT VARIABLE">
var param = function (name, value) {
    this.name = name;
    this.value = value;
};
//</editor-fold>

var EmployeeManager = function () {

    //<editor-fold defaultstate="collapsed" desc="INIT">
    return {
        init: function () {
            loadEmployee();
            $("#btn_add_employee").click(function (){
                window.location.href = "add-employee";
            });
        }
    };
    //</editor-fold>

}();

//<editor-fold defaultstate="collapsed" desc="ADD EMPLOYEE">
var loadEmployee = function () {
    $.ajax({
        url: "getListEmployees",
        type: "GET",
        data: {},
        success: function (response) {
//            response = $.parseJSON(response);
            var html = '<table class="table table-bordered tb-header-color" id="tbl_list_employee">';
            html += '<thead><tr>';
            html += '<th class="left">Name</th>';
            html += '<th class="center">Age</th>';
            html += '<th class="left">Dept</th>';
            html += '<th class="right">Salary</th>';
            html += '<th class="center">Action</th>';
            html += '</tr></thead><tbody>';

            if (response.length > 0) {
                $.each(response, function (key) {

                    html += '<tr class="odd gradeX"><td>' + response[key].name + '</td>';
                    html += '<td class="center">' + response[key].age + '</td>';
                    html += '<td class="center">' + response[key].dept + '</td>';
                    html += '<td class="center">' + response[key].salary + '</td>';

                    html += '<td>';
                    html += '<a class="btn btn-xs btn-outline red" href="javascript:deleteAction(' + response[key].id + ');" style="margin-left: 10px;">';
                    html += '<i class="fa fa-trash-o"></i><span class="lb_delete">Delete</span>';
                    html += '</a>';
                    
                    html += '<a class="btn btn-xs btn-outline red" href="javascript:showDetail(' + response[key].id + ');" style="margin-left: 10px;">';
                    html += '<i class="fa fa-trash-o"></i><span class="lb_delete">Detail</span>';
                    html += '</a>';
                    html += '</td>';

                    html += '</tr>';
                });

            }
            html += '</tbody></table>';
            $("#div_list_employee").html(html);
        },
        error: function () {
        }
    });
};
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="ADD EMPLOYEE">
var deleteAction = function (id) {
    var filterParam = [];
    filterParam[filterParam.length] = new param("id", id);
    $.ajax({
        url: "deleteEmployee",
        type: "POST",
        data: filterParam,
        success: function (response) {
            if (response.length > 0) {
                if ("false" === response) {
                    console.log("delete wrong");
                } else {
                    console.log("delete succces");
                }
            }
        },
        error: function () {
        }
    });
};
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="ADD EMPLOYEE">
var showDetail = function (id) {
    window.location.href = "employee-detail?id="+id;
};
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="GET PARAMETER">
var getParameter = function (name) {
    var results = new RegExp('[\?&]' + name + '=([^#]*)').exec(window.location.href);
    if (results === null) {
        return null;
    } else {
        return results[1] || 0;
    }
};
//</editor-fold>
