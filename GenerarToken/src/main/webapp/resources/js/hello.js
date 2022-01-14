/**
 * 
 */
$(document).ready(function() {
    $.ajax({
        url: "http://10.6.0.155:8080/greeting"
    }).then(function(data, status, jqxhr) {
       $('.greeting-id').append(data.id);
       $('.greeting-content').append(data.content);
       console.log(jqxhr);
    });
});