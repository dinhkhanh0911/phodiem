/**
 * 
 */


$(document).ready(function() {
	/*$('#table_id').DataTable();*/
	loadSemester();
	/*loadKhoa();*/
	loadClass();
	loadGv();
	loadSubject();
})

var data={
	semester:{},
	gv:{},
	student:{},
	markConfig : {},
	markType :{},
	subject :{},
}

function loadSemester() {
	$.ajax({
		type: 'GET',
		contentType: "application/json",
		url: 'http://localhost:5000/api/v1/semesters',
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
		data.semester = response;
		response.forEach(val => {
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
function loadSubject() {
	$.ajax({
		type: 'GET',
		contentType: "application/json",
		url: 'http://localhost.169:5000/api/v1/subjects',
		//data: JSON.stringify(values),
		datatype: 'json',
		error: function(xhr, ajaxOptions, thrownError) {
			console.log(xhr);
			console.log(ajaxOptions);
			console.log(thrownError);
		}
	}).done(function(response) {
		console.log("mon hoc",response);
		semester=response;
		$('#mon1').empty();
		$('#mon2').empty();
		$('#mon3').empty();
		data.subject = response;
		response.forEach(val => {
			$('#mon1').append(`
				<option value="${val['SubjectId']}">${val['SubjectName']}</option>
				`);
			$('#mon2').append(`
				<option value="${val['SubjectId']}">${val['SubjectName']}</option>
				`);
			$('#mon3').append(`
				<option value="${val['SubjectId']}">${val['SubjectName']}</option>
				`);
		})

	});
}

function loadClass() {
	$.ajax({
		type: 'GET',
		contentType: "application/json",
		url: 'http://localhost:5000/api/v1/classes',
		//data: JSON.stringify(values),
		datatype: 'json',
		error: function(xhr, ajaxOptions, thrownError) {
			console.log(xhr);
			console.log(ajaxOptions);
			console.log(thrownError);
		}
	}).done(function(response) {
		console.log("lop",response);
		$('#lop').empty();
		data.class = response;

		response.forEach(val => {
			$('#lop').append(`
			<option value="${val['MClassId']}">${val['MClassName']}</option>
			`);
		})

	});
}
function loadGv() {
	$.ajax({
		type: 'GET',
		contentType: "application/json",
		url: 'http://localhost:5000/api/v1/teachers',
		//data: JSON.stringify(values),
		datatype: 'json',
		error: function(xhr, ajaxOptions, thrownError) {
			console.log(xhr);
			console.log(ajaxOptions);
			console.log(thrownError);
		}
	}).done(function(response) {
		console.log("giao vien")
		console.log(response);
		data.gv = response;
		$('#giaovien').empty();

		response.forEach(val => {
			$('#giaovien').append(`
			<option value="${val['TeacherId']}">${val['TeacherCode']}</option>
			`);
		})

	});
}
function selectClass(mclass) {

}



function selectMon1(element) {
	let gv = $('#giaovien').find(":selected").val();
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
		//data: value,
		datatype: 'json',
		error: function(xhr, ajaxOptions, thrownError) {
			console.log(xhr);
			console.log(ajaxOptions);
			console.log(thrownError);
		}
	}).done(function(response) {
		console.log("rs1:", response);
		let count = 0;
		$('#table_id').empty();
		$('#titleTable').text('Bảng điểm theo Giáo viên')
		for (const res of response) {
			count++;
			$('#table_id').append(`
			<td>${count}</td>
			<td>${res.studentName}</td>
			<td>${res.markQt}</td>
			<td>${res.markTh}</td>
			<td>${res.markKt}</td>
			<td>${res.markThi}</td>
			<td>${res.markFinal	}</td>						
		
		`);
		}

	});
}

function selectMon2(element) {
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
		console.log("rs2:", response);
		$('#titleTable').text('Bảng điểm theo khoa')
		let count = 0;
		$('#table_id').empty();
		for (const res of response) {
			count++;
			$('#table_id').append(`
			<td>${count}</td>
			<td>${res.studentName}</td>
			<td>${res.markQt}</td>
			<td>${res.markTh}</td>
			<td>${res.markKt}</td>
			<td>${res.markThi}</td>
			<td>${res.markFinal	}</td>						
		
		`);
		}
	});
}
function selectMon3(element) {
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
		console.log("rs3:", response);
		$('#titleTable').text('Bảng điểm theo lớp')
		let count = 0;
		$('#table_id').empty();
		for (const res of response) {
			count++;
			$('#table_id').append(`
			<td>${count}</td>
			<td>${res.studentName}</td>
			<td>${res.markQt}</td>
			<td>${res.markTh}</td>
			<td>${res.markKt}</td>
			<td>${res.markThi}</td>
			<td>${res.markFinal	}</td>						
		
		`);
		}

	});
}















/**
 * 
 */