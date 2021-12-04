import React, { useState } from 'react'

const AddUserForm = props => {
	const initialFormState = { nome: '', email: '', senha: '' }
	const [user, setUser] = useState(initialFormState)

	const handleInputChange = event => {
		const { name, value } = event.target

		setUser({ ...user, [name]: value })
	}

	return (
		<form
			onSubmit={event => {
				event.preventDefault()
				if (!user.nome || !user.email || !user.senha) return alert('Favor insira os dados')

				props.addUser(user)
				setUser(initialFormState)
			}}
		>
			<label>Nome</label>
			<input type="text" name="nome" value={user.nome} onChange={handleInputChange} />
			<label>E-mail</label>
			<input type="text" name="email" value={user.email} onChange={handleInputChange} />
			<label>Senha</label>
			<input type="text" name="senha" value={user.senha} onChange={handleInputChange} />
			<button type="submit">Adicionar Personal</button>
		</form>
	)
}

export default AddUserForm
