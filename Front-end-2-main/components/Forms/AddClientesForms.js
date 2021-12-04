import React, { useState } from 'react'

const AddClienteForm = props => {
	const initialFormState = { nome: '', email: '', senha: '', nota: '' }
	const [cliente, setCliente] = useState(initialFormState)

	const handleInputChange = event => {
		const { name, value } = event.target

		setCliente({ ...cliente, [name]: value })
	}

	return (
		<form
			onSubmit={event => {
				event.preventDefault()
				if (!cliente.nome || !cliente.email || !cliente.senha || cliente.nota) {
					return alert('Favor, insira os dados')
				}

				props.addCliente(cliente)
				setCliente(initialFormState)
			}}
		>
			<label>Nome</label>
			<input type="text" name="nome" value={cliente.nome} onChange={handleInputChange} />
			<label>E-mail</label>
			<input type="text" name="email" value={cliente.email} onChange={handleInputChange} />
			<label>Senha</label>
			<input type="text" name="senha" value={cliente.senha} onChange={handleInputChange} />
			{/* <label>Nota</label>
			<input type="text" name="nota" value={cliente.nota} onChange={handleInputChange} /> */}
			<button type='submit'>Adicionar Cliente</button>
		</form>
	)
}

export default AddClienteForm
