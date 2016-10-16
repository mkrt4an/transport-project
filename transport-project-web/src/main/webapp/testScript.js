/**
 * Created by 123 on 10.10.2016.
 */

function f() {
    $.ajax({
        url: "/TestServlet",
        data: {
            id: '1'
        },
        success : function (result) {
            // alert(result);
            // var hd = $("#h");
            // hd.value = result;
        }
    })
}