import React, { useState } from 'react'

const AddTreinosAcademiaForm = props => {
	const initialFormState = { personal: '', usuario: '', data: '', academia: '', tipo: '' }
	const [treinosAcademia, setTreinosAcademia] = useState(initialFormState)

	const handleInputChange = event => {
		const { name, value } = event.target

		setCliente({ ...treinosAcademia, [name]: value })
	}

	return (
		<form
			onSubmit={event => {
				event.preventDefault()
				if (!treinosAcademia.personal || !treinosAcademia.usuario || !treinosAcademia.data || treinosAcademia.academia || treinosAcademia.tipo) {
					return
				}

				// props.addCliente(cliente)
				setCliente(initialFormState)
			}}
		>
			<label>Personal</label>
			<input type="text" name="personal" value={treinosAcademia.personal} onChange={handleInputChange} />
			<label>Usuário</label>
			<input type="text" name="usuario" value={treinosAcademia.usuario} onChange={handleInputChange} />
			<label>Data</label>
			<input type="text" name="data" value={treinosAcademia.data} onChange={handleInputChange} />
			<label>Endereço</label>
			<input type="text" name="academia" value={treinosAcademia.academia} onChange={handleInputChange} />
			<label>Tipo</label>
			<input type="text" name="tipo" value={treinosAcademia.tipo} onChange={handleInputChange} />
			<button>Adicionar Treino Academia</button>
		</form>
	)
}

export default AddTreinosAcademiaForm
