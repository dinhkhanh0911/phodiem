
$(document).ready(function(){
	loadSubjects(bindingDataSubjectToForm,function(error){
		console.log(error)
	},"#subjectId")
})
function loadSubjects(callback,handleError,selector){
	fetch(`/api/v1/subjects`)
            .then(function(response){
                return response.json() 
            })
            .then(function(response){
                callback(response.data,selector)
            })
            .catch(function(error){
                handleError(error)
            })
}
function bindingDataSubjectToForm(subjects,selector){
	console.log(subjects)
	var options = subjects.map(function(subject){
		return `
			<option value = ${subject.subjectId}> ${subject.subjectName}</option>
		`
	})
	$(selector).append(options.join(''))
	handleChangeSelect(selector)
}
function handleChangeSelect(selector){
	$(selector).change(function(event){
		console.log(event.target.value)
	})
}