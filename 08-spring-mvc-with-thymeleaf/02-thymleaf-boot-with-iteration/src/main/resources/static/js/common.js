document.addEventListener('DOMContentLoaded', () => {

	const btn = document.getElementById('uplBtn');
	const form = document.getElementById('uplForm');
	const file = document.getElementById('uplFile');
	
	if(btn && form && file){
		btn.addEventListener('click',() => file.click())
		file.addEventListener('change',() => form.submit())
	}
})