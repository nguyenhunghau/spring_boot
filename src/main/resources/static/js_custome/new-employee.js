
//<editor-fold defaultstate="collapsed" desc="INIT VARIABLE">
var param = function (name, value) {
    this.name = name;
    this.value = value;
};
//</editor-fold>

var NewEmployee = function () {
    
    //<editor-fold defaultstate="collapsed" desc="HANDLE SAVE ADD">
    var handleSaveAdd = function () {
        $("#btn_save").click(function () {
            $("#frm_faq").validate({
                errorElement: 'span', //default input error message container
                errorClass: 'help-block', // default input error message class
                focusInvalid: false, // do not focus the last invalid input
                rules: {
                    txt_name: {
                        required: true
                    },
                    txt_age: {
                        number: true
                    },
                    txt_salary: {
                        number: true
                    }
                },
                highlight: function (element) { // hightlight error inputs
                    $(element).closest('.form-group').addClass('has-error'); // set error class to the control group
                },
                unhighlight: function (element) { // revert the change done by hightlight
                    $(element).closest('.form-group').removeClass('has-error'); // set error class to the control group
                },
                success: function (label) {
                    label.closest('.form-group').removeClass('has-error'); // set success class to the control group
                },
                submitHandler: function () {
                    addEmployee("save");
                }
            });
        });
    };
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="HANDLE SAVE CONTINUES ADD">
    var handleSaveContinuesAdd = function () {
        $("#btn_save_continues").click(function () {
            $("#frm_faq").validate({
                errorElement: 'span', //default input error message container
                errorClass: 'help-block', // default input error message class
                focusInvalid: false, // do not focus the last invalid input
                rules: {
                    txt_name: {
                        required: true
                    },
                    txt_age: {
                        number: true
                    },
                    txt_salary: {
                        number: true
                    }
                },
                highlight: function (element) { // hightlight error inputs
                    $(element).closest('.form-group').addClass('has-error'); // set error class to the control group
                },
                unhighlight: function (element) { // revert the change done by hightlight
                    $(element).closest('.form-group').removeClass('has-error'); // set error class to the control group
                },
                success: function (label) {
                    label.closest('.form-group').removeClass('has-error'); // set success class to the control group
                },
                submitHandler: function () {
                    addEmployee("continues");
                }
            });
        });
    };
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="INIT">
    return {
        init: function () {
            handleSaveAdd();
            handleSaveContinuesAdd();
        }
    };
    //</editor-fold>

}();

//<editor-fold defaultstate="collapsed" desc="ADD EMPLOYEE">
var addEmployee = function (typeSave) {
    var filterParam = [];
    filterParam[filterParam.length] = new param("name", $("#txt_name").val());
    filterParam[filterParam.length] = new param("age", $("#txt_age").val());
    filterParam[filterParam.length] = new param("dept", $("#txt_dept").val());
    filterParam[filterParam.length] = new param("salary", $("#txt_salary").val());
    $.ajax({
        url: "addEmployee",
        type: "POST",
        data: filterParam,
        success: function (response) {
            if (response.length > 0) {
                if (response.startsWith("error")) {
                    console.log("add wrong");
                } else {
                    if (typeSave === "continues") {
                        location.reload();
                    } else {
                        window.location.href = "employee-manager";
                    }
                }
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
