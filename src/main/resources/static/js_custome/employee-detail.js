
//<editor-fold defaultstate="collapsed" desc="INIT VARIABLE">
var param = function (name, value) {
    this.name = name;
    this.value = value;
};
//</editor-fold>

var EmployeeDetail = function () {

    //<editor-fold defaultstate="collapsed" desc="INIT">
    return {
        init: function () {
            getEmployeeDetail();
        }
    };
    //</editor-fold>

}();

//<editor-fold defaultstate="collapsed" desc="ADD EMPLOYEE">
var getEmployeeDetail = function () {
    var filterParam = [];
    filterParam[filterParam.length] = new param("id",getParameter("id"));
    $.ajax({
        url: "getEmployeeDetail",
        type: "POST",
        data: filterParam,
        success: function (response) {
            if (response) {
                $("#txt_name").text(response.name);
                $("#txt_age").text(response.age);
                $("#txt_dept").text(response.dept);
                $("#txt_salary").text(response.salary);
            }
        },
        error: function () {
        }
    });
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
