$(document).ready(function(){
	handerLoginSubmit()
})

function handerLoginSubmit(){
	$('#login').submit(function (even) {
        
		even.preventDefault();
		var values = {};
		$.each($("#login").serializeArray(), function (i, field) {
		    values[field.name] = field.value;
		    
		});
		console.log(JSON.stringify(values))
        $.ajax({
            type:'POST',
            contentType:"application/json",
            url: 'api/v1/login',
            data: JSON.stringify(values),
            datatype: 'json',
            error: function (xhr, ajaxOptions, thrownError) {
                console.log();
                alert(xhr.responseJSON.message)
                console.log(ajaxOptions);
                console.log(thrownError);
            }
        }).done(function (response) {
            
            if (response != null ) {
				console.log(response)
                if(response.code===200){
					window.location.href="/nguoi-dung/them-nguoi-dung"
				}
				else if(response.code===400){
					
				}
                
            }
        });
        
    })
}