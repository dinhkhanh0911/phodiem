

$(document).ready(function(){
	autoFocus()
	loadDataPosition(bindingPositionToForm,function(error){
		console.log(error)
	},"#changeUserForm [name=positionId]")
	
	
	handleSubmitInfoBtn()
	handleAddUserForm()
	
})
var userModel = {}
function loadData(selectorForm){
	
	key = $(`${selectorForm} .disabled input`).val()
	loadDataUser(key,bindingDataToForm,function(error){
		console.log("Tải dữ liệu không thành công")
	},selectorForm)
}
function autoFocus(){
	var inputs = document.querySelectorAll("#changeUserForm [name]")
	inputs[0].focus()
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
		alert("Dữ liệu thêm chưa hợp lệ")
	}
}
function handleAddUserForm(){
	var formAddUser = new Validator("#changeUserForm",errorHandle)
		
	formAddUser.onSubmit= function(dataForm){
		
		pushDataUser(dataForm,
		function(response){
			console.log(response)
			if(response.code === 200){
				if(confirm("Thêm thành công\n Chuyển sang chỉnh sửa thông tin")){
					window.location.href = `/nguoi-dung/thay-doi-thong-tin-nguoi-dung/${response.data.userId}`
				}
			}
			else{
				alert(response.message)
			}
			
		},
		function(error){
			alert("Thêm không thành công")
		})
	}
	function errorHandle(){
		
	}
}
 function handleSubmitInfoBtn(){
	$('#submitInfoBtn').click(function(event){
		event.preventDefault()
		if(confirm("Mọi thông tin sẽ không được lưu")){
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
