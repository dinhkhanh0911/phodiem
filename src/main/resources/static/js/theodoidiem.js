/**
 * 
 */


$(document).ready( function () {
    $('#table_id').DataTable();
	loadSemester();
	loadKhoa();
	loadClass();
	loadTeacher();


	$('#report').submit(function(even) {
		even.preventDefault();
		var values = {};
		$.each($("#report").serializeArray(), function(i, field) {
			values[field.name] = field.value;

		});
		console.log(JSON.stringify(values))
		$.ajax({
			type: 'POST',
			contentType: "application/json",
			url: 'api/v1/report',
			data: JSON.stringify(values),
			datatype: 'json',
			error: function(xhr, ajaxOptions, thrownError) {
				console.log(xhr);
				console.log(ajaxOptions);
				console.log(thrownError);
			}
		}).done(function(response) {
			alert(response);

		});

	})
})

function loadSemester() {
	$.ajax({
		type: 'GET',
		contentType: "application/json",
		url: 'api/v1/semester',
		//data: JSON.stringify(values),
		datatype: 'json',
		error: function(xhr, ajaxOptions, thrownError) {
			console.log(xhr);
			console.log(ajaxOptions);
			console.log(thrownError);
		}
	}).done(function(response) {
		console.log(response);
		$('#hocKy1').empty();
		$('#hocKy2').empty();
		$('#hocKy3').empty();
		[...response["data"]].forEach(val => {
			$('#hocKy1').append(`
				<option value="${val['semesterId']}">${val['semesterName']}</option>
				`);
				$('#hocKy2').append(`
				<option value="${val['semesterId']}">${val['semesterName']}</option>
				`);
				$('#hocKy3').append(`
				<option value="${val['semesterId']}">${val['semesterName']}</option>
				`);
		})

	});
}
function loadKhoa() {
	$.ajax({
		type: 'GET',
		contentType: "application/json",
		url: 'api/v1/khoa',
		//data: JSON.stringify(values),
		datatype: 'json',
		error: function(xhr, ajaxOptions, thrownError) {
			console.log(xhr);
			console.log(ajaxOptions);
			console.log(thrownError);
		}
	}).done(function(response) {
		console.log(response);
		$('#khoa').empty();

		[...response["data"]].forEach(val => {
			$('#khoa').append(`
			<option value="${val['semesterId']}">${val['semesterName']}</option>
			`);
		})

	});
}

function loadClass(){
	$.ajax({
		type: 'GET',
		contentType: "application/json",
		url: 'api/v1/class',
		//data: JSON.stringify(values),
		datatype: 'json',
		error: function(xhr, ajaxOptions, thrownError) {
			console.log(xhr);
			console.log(ajaxOptions);
			console.log(thrownError);
		}
	}).done(function(response) {
		console.log(response);
		$('#lop').empty();
		
		[...response["data"]].forEach(val => {
			$('#lop').append(`
			<option value="${val['classesId']}">${val['classesName']}</option>
			`);
		})

	});
}
function loadGv(){
	$.ajax({
		type: 'GET',
		contentType: "application/json",
		url: 'api/v1/teacher',
		//data: JSON.stringify(values),
		datatype: 'json',
		error: function(xhr, ajaxOptions, thrownError) {
			console.log(xhr);
			console.log(ajaxOptions);
			console.log(thrownError);
		}
	}).done(function(response) {
		console.log(response);
		$('#giaoVien').empty();
		
		[...response["data"]].forEach(val => {
			$('#giaoVIen').append(`
			<option value="${val['teacherId']}">${val['teacherName']}</option>
			`);
		})

	});
}
function selectClass(mclass){
	
}



function selectMon1(element){
	let gv = $('#giaoVien').find(":selected").val();
	let hk = $('#hocKy1').find(":selected").val();
	
	let value = `{
		"mon":${element.value}
		"giaoVien":${gv}
		"hocKy":${hk}
		}`
	
	console.log(value);
	$.ajax({
		type: 'POST',
		contentType: "application/json",
		url: 'api/v1/theodoi/giaovien',
		data: value,
		datatype: 'json',
		error: function(xhr, ajaxOptions, thrownError) {
			console.log(xhr);
			console.log(ajaxOptions);
			console.log(thrownError);
		}
	}).done(function(response) {
		console.log(response);

	});
}

function selectMon2(element){
	let gv = $('#khoa').find(":selected").val();
	let hk = $('#hocKy2').find(":selected").val();
	
	let value = `{
		"mon":${element.value}
		"khoa":${gv}
		"hocKy":${hk}
		}`
	
	console.log(value);
	$.ajax({
		type: 'POST',
		contentType: "application/json",
		url: 'api/v1/theodoi/khoa',
		data: value,
		datatype: 'json',
		error: function(xhr, ajaxOptions, thrownError) {
			console.log(xhr);
			console.log(ajaxOptions);
			console.log(thrownError);
		}
	}).done(function(response) {
		console.log(response);
	});
}
function selectMon3(element){
	let gv = $('#lop').find(":selected").val();
	let hk = $('#hocKy3').find(":selected").val();
	
	let value = `{
		"mon":${element.value}
		"lop":${gv}
		"hocKy":${hk}
		}`
	
	console.log(value);
	$.ajax({
		type: 'POST',
		contentType: "application/json",
		url: 'api/v1/theodoi/lop',
		data: value,
		datatype: 'json',
		error: function(xhr, ajaxOptions, thrownError) {
			console.log(xhr);
			console.log(ajaxOptions);
			console.log(thrownError);
		}
	}).done(function(response) {
		console.log(response);

	});
}















/**
 * 
 */