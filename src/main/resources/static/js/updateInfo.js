

$(document).ready(function(){
	loadData("#changeInfoForm")
	autoFocus()
	loadDataPosition(bindingPositionToForm,function(error){
		console.log(error)
	},"#changeInfoForm [name=positionId]")
	handlesubmitForm()
	handleSubmitInfoBtn()
	
})
var userModel = {}
function loadData(selectorForm){
	
	key = $(`${selectorForm} .disabled input`).val()
	loadDataUser(key,bindingDataToForm,function(error){
		console.log("Tải dữ liệu không thành công")
	},selectorForm)
}
function autoFocus(){
	var inputs = document.querySelectorAll("#changeInfoForm [name]")
	inputs[1].focus()
}
function loadDataUser(userId,callback,errorHandle,formSelector){
	fetch(`/api/v1/users/${userId}`)
            .then(function(response){
                return response.json() 
            })
            .then(function(user,formSelector){
                callback(user)
            })
            .catch(function(error){
                errorHandle(error)
            })
}
function pushDataUser(data,callback,errorHandle){
	fetch('/api/v1/users/info', {
        method: 'POST', // or 'PUT'
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    })
    .then(response => response.json())
    .then(data => {
        callback(data)
    })
    .catch((error) => {
        console.error('Error:', error);
    });
}
function loadDataPosition(callback,errorHandle,selector){
	fetch(`/api/v1/positions`)
            .then(function(response){
                return response.json() 
            })
            .then(function(positions){
                callback(positions.data,selector)
            })
            .catch(function(error){
                errorHandle(error)
            })
}
function loadDataUserBySearch(q,callback,errorHandle,selector){
	fetch(`/api/v1/users/search/${q}`)
            .then(function(response){
                return response.json() 
            })
            .then(function(response,selector){
                callback(response)
            })
            .catch(function(error){
                errorHandle(error)
            })
	
}
function bindingDataToForm(user,formSelector){
	userModel = user.data
}
function handlesubmitForm(){
	var formChangeInfo = new Validator("#changeInfoForm",errorHandle)
		console.log(formChangeInfo)
	formChangeInfo.onSubmit= function(dataForm){
		for(var key in dataForm){
			userModel[key]= dataForm[key]
		}
		pushDataUser(userModel,
		function(data){
			alert("Thay đổi thông tin cá nhân thành công")
		},
		function(error){
			alert("Thay đổi giữ liệu không thành công")
		})
	}
	function errorHandle(){
		
	}
}
 function handleSubmitInfoBtn(){
	$('#submitInfoBtn').click(function(event){
		event.preventDefault()
		if(confirm("Bạn có muốn lưu lại thông tin cũ?")){
			window.location.href = "/nguoi-dung/ca-nhan"
		}
	})
	$('#submitChangeBtn').click(function(event){
		event.preventDefault()
		if(confirm("Bạn có muốn lưu lại thông tin cũ?")){
			window.location.href = "/nguoi-dung/menu-quan-ly"
		}
	})
}
 function bindingPositionToForm(positions,selector){
	
	var options = positions.map(function(position){
		return `
			<option value="${position.positionId}">${position.positionName}</option>
		`
	})
	$(`${selector}`).append(options.join(''))
}
