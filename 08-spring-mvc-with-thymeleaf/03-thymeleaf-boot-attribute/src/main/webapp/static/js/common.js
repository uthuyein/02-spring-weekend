document.addEventListener('DOMContentLoaded',() =>{
	const btn = document.getElementById('upBtn');
	const file = document.getElementById('upFile');
	const form = document.getElementById('upForm');
	
	btn.addEventListener('click',() => file.click())
	file.addEventListener('change',() => form.submit())
})