/**
 * Created by 123 on 10.10.2016.
 */
//

$(document).ready(function () {
        $("#test").click(
            function() {
                $.ajax({
                    url: "/test",
                    data: {
                        id: $("#number").val()
                    },
                    // dataType: "json",
                    success : function (responseJson) {
                        // alert(result);
                        // .val(result);
                        // var x = $('#input');
                        // x.val(123);
                        // $("#number").val("123");
                        $("#input").val(responseJson);
                    }
                });
            }
        )
    }
)






// $(document).ready(function(){
//     $("#test").click(function(){
//         var x = $("#number").val();
//         $("#input").val(x);
// })});

// function disableBtn() {
//     if (document.getElementById("ready").disabled == true) {
//         document.getElementById("ready").disabled = false;
//         return;
//     }
//
//     if (document.getElementById("ready").disabled == false) {
//         document.getElementById("ready").disabled = true;
//         return;
//     }

///////////////////////////////////////////////////////////////////
// Toogle button with jQuery

    // $("#test").click(function(){
    //     $('#ready').prop('disabled', function(i, v) { return !v; });
    // });


///////////////////////////////////////////////////////////////////
// aJax
// $(document).ready(function(){
//     $("test").click(function(){
//         // $.ajax({
//         $.get("/test", function(responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
//             $("#out").text(responseText);           // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
//         });
//


// $(document).on("click", "#test", function() { // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
//     var x = $('#input')
//     $.get("/test?id=x", function(responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
//         var hd = $('#out');
//         hd.val() = result;
//         // $('#out').val() = responseText;           // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
//         alert(responseText);           // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
// })});


// $(document).on("click", "#test", function() { // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
//     $.get("/test", function(responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
//         // $("#input").val(responseText);           // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
//         // $("#input").val(123123);           // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
//         alert(responseText);
//     });
// });
