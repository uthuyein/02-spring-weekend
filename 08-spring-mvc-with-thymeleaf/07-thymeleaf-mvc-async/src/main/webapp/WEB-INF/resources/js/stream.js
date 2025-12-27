window.addEventListener('load', () => {

    document.getElementById('responseTrigger').addEventListener('click', async () => {
        console.log("JS strarting ....")

        const output = document.getElementById('output')
        const response = await fetch('http://localhost:8080/response/stream')
        const reader = response.body.pipeThrough(new TextDecoderStream).getReader()

        output.innerText = ''
        console.log(reader)

        while (true) {
            const { value, done } = await reader.read()

            if (done) {
                break
            }

            var li = document.createElement('li')
            li.innerText = value

            output.appendChild(li)
        }
    })


    document.getElementById('sseTrigger').addEventListener('click', () => {
        console.log("JS strarting ....")

        const output = document.getElementById('output')
        const response = new EventSource('http://localhost:8080/response/sse')

        output.innerText = ''
        response.onmessage = message => {

            var li = document.createElement('li')
            li.innerText = message.data

            output.appendChild(li)
        }
		
		response.onerror = error =>{
			console.log(error)
			response.close()
		}
    })
	
	
})