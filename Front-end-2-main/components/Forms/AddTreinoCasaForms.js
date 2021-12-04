import React, { useState } from 'react'

const AddTreinosCasaForm = props => {
	const initialFormState = { personal: '', usuario: '', data: '', endereco: '', tipo: '' }
	const [treinosCasa, setTreinosCasa] = useState(initialFormState)

	const handleInputChange = event => {
		const { name, value } = event.target

		setCliente({ ...treinosCasa, [name]: value })
	}

	return (
		<form
			onSubmit={event => {
				event.preventDefault()
				if (!treinosCasa.personal || !treinosCasa.usuario || !treinosCasa.data || treinosCasa.endereco || treinosCasa.tipo) { } return

				props.addCliente(cliente)
				setCliente(initialFormState)
			}}
		>
			<label>Personal</label>
			<input type="text" name="personal" value={treinosCasa.personal} onChange={handleInputChange} />
			<label>Usuário</label>
			<input type="text" name="usuario" value={treinosCasa.usuario} onChange={handleInputChange} />
			<label>Data</label>
			<input type="text" name="data" value={treinosCasa.data} onChange={handleInputChange} />
			<label>Endereço</label>
			<input type="text" name="endereco" value={treinosCasa.endereco} onChange={handleInputChange} />
			<label>Tipo</label>
			<input type="text" name="tipo" value={treinosCasa.tipo} onChange={handleInputChange} />
			<button>Adicionar Treino Casa</button>
		</form>
	)
}

export default AddTreinosCasaForm
