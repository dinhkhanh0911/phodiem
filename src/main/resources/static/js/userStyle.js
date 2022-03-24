

$(document).ready(function(){
	loadData("#changeInfoForm")
	loadDataPosition(bindingPositionToForm,function(error){
		console.log(error)
	},"#changeUserForm [name=positionId]")
	handlesubmitForm()
	handleSubmitInfoBtn()
	handleAddUserForm()
	handleSearchClick()
	
})
var userModel = {}
function loadData(selectorForm){
	
	key = $(`${selectorForm} .disabled input`).val()
	loadDataUser(key,bindingDataToForm,function(error){
		console.log("Tải dữ liệu không thành công")
	},selectorForm)
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
	var form = new Validator("#changeInfoForm",errorHandle)
		
	form.onSubmit= function(dataForm){
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
	var form = new Validator("#changeUserForm",errorHandle)
		
	form.onSubmit= function(dataForm){
		
		pushDataUser(dataForm,
		function(response){
			console.log(response)
			if(confirm("Thêm thành công\n Chuyển sang chỉnh sửa thông tin")){
				window.location.href = `/nguoi-dung/thay-doi-thong-tin-nguoi-dung/${response.data.userId}`
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
		if(confirm("Bạn có muốn lưu lại thông tin cũ?")){
			window.location.href = "/nguoi-dung/ca-nhan"
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
function handleSearchClick(){
	$('#searchBtn').click(function(){
		var value = $('#searchInput').val()
		loadDataUserBySearch(value,bindingDataToTableSearch,function(error){
			console.log(error)
			
		},"")
	})
}
function bindingDataToTableSearch(response,selector){
	console.log(response)
	dienDanhSachBenhNhan(response)
    saveData.setData(response.data)
    handerSeeClick()
    handerDeleteClick()
    handerEditClick()
}
const saveData = (function () {
        var data = [];
        return {
            getData(id) {
                return data[id - 1]
            },
            setData(patientList) {
                data = [...patientList]
            }
        }
})()
function dienDanhSachBenhNhan(data) {
        var tbodyPatient = document.querySelector('#tbodyPatient')
        tbodyPatient.innerHTML = ''
        var i = 1;
        for (var item of data.data) {
            var dateString = item.dateOfBrith
            var date;
            if (dateString) {
                date = new Date(Number(dateString.slice(6, dateString.length - 2)))
            }

            let row = `
            <tr id="${item.userId}">
                <td>${item.fullName}</td>
                <td>${item.dateOfBrith != null ? item.dateOfBrith : "Không có"}</td>
                <td>${item.identityNumber}</td>
                <td>${item.gender == 1? "Nam":"Nữ"}</td>
                
                <td id="${i}">
                    <a id="see-${i}" class="see" title="Xem" data-toggle="modal" data-target="#patient-modal">
                        <i class="fa fa-eye" aria-hidden="true"></i>
                    </a>
                    <a id="edit-${i}" class="edit" title="Sửa">
                        <i class="fa fa-wrench" aria-hidden="true"></i>
                    </a>
                    <a id="delete-${i}" class="delete" title="Xóa">
                        <i class="fa fa-trash-o" aria-hidden="true"></i>
                    </a>
                
                </td>
            </tr>`
            i++
            $('#tbodyPatient').append(row)
        }
    }
    function handerSeeClick() {
        var seeElement = document.querySelectorAll('.see')
        for (var item of seeElement) {
            item.addEventListener('click', hienThiBenhNhan)
        }
    }
    function hienThiBenhNhan() {
        var element = document.querySelector(`#${this.id}`)
        var parent = element.parentElement
        var id = parent.id
        var data = saveData.getData(id)
        hienThiModal(data)
    }
    function hienThiModal(data) {
        var modal = document.querySelector('#patien-modal-body')
        console.log(data)
        
        modal.innerHTML = `
        <div class="modal-group">
            <label class="modal-lable ">Họ và tên:</label>
            <label class="modal-value">${data.fullName || "Không có"}</label>
        </div>
        <div class="modal-group">
            <label class="modal-lable">Ngày sinh:</label>
            <label class="modal-value">${data.dateOfBrith != null ? data.dateOfBrith : "Không có"}</label>
        </div>
        <div class="modal-group">
            <label class="modal-lable">Giới tính:</label>
            <label class="modal-value">${data.gender == 1 ? "Nam" : "Nữ" }</label>
        </div>
        <div class="modal-group">
            <label class="modal-lable">Số CCCD:</label>
            <label class="modal-value">${data.identityNumber || "Không có"}</label>
        </div>
    `

    }

    function handerDeleteClick() {
        var deleteElement = document.querySelectorAll('.delete')
        console.log(deleteElement)
        for (var item of deleteElement) {
            item.addEventListener('click', confirmDelete)
        }
    }
    function confirmDelete() {
        if (confirm("Bạn có thực sự muốn xóa không?")) {
            var element = document.querySelector(`#${this.id}`)
            var parent = element.parentElement.parentElement
            console.log(parent.id)
            xoaBenhNhan(parent)
        }
    }
    function xoaBenhNhan(element) {
        var ID = element.id
        $.ajax({
            url: '/benh-nhan/xoa-benh-nhan',
            type: 'post',
            dataType: 'json',
            data: {
                ID: ID
            },
            success: function (data) {
                if (data.code == 200) {
                    element.remove()
                }
                alert(data.msg)
            }
        })
    }
    function handerEditClick() {
        var editElement = document.querySelectorAll('.edit')
        console.log(editElement)
        for (var item of editElement) {
            item.addEventListener('click', editPatient)
        }
    }
    function editPatient() {
        var element = document.querySelector(`#${this.id}`)
        var parent = element.parentElement.parentElement
        console.log(parent.id)
        window.location.href = `/nguoi-dung/thay-doi-thong-tin-nguoi-dung/${parent.id}`
    }