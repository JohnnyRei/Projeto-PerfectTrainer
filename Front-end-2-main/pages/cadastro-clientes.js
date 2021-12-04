import axios from 'axios'
import { useRouter } from 'next/router'
import React, { useState, useEffect } from 'react'
import AddClienteForm from '../components/Forms/AddClientesForms'
import EditClienteForm from '../components/Forms/EditClientesForms'
import ClienteTable from '../components/Tables/ClientesTables'
import { addCliente } from '../services/AddClientes'

const API_ENDPOINT = 'http://localhost:8090'

const CadastroClientes = () => {
	const router = useRouter()
	const [clientesList, setClientesList] = useState([])
	// useEffect(() => {
	// 	axios.get(`${API_ENDPOINT}/usuarios`)
	// 		.then((response) => console.log(response))
	// 	console.log(clientesList)
	// }, [])

	// Data
	const usersData = [

	]

	const initialFormState = { nome: '', email: '', senha: '', nota: '' }

	// Setting state
	const [clientes, setClientes] = useState(clientesList)
	const [currentCliente, setCurrentCliente] = useState(initialFormState)
	const [editing, setEditing] = useState(false)

	// CRUD operations
	const addCliente1 = cliente => {
		//user.id = users.length + 1
		//setUsers([...users, user])
		//user.id = users.length + 1
		// setUsers([...users, user])
		//const response = await fetch(`${API_ENDPOINT}/personais`, {
		//method: 'POST',
		//headers: { 'Content-Type': 'application/json' },
		//body: JSON.stringify(user)
		//})
		//return await response.json();
		console.log(cliente)
		router.push('/usuario')

		// addCliente1(cliente)
	}

	const deleteCliente = id => {
		setEditing(false)

		setClientes(clientes.filter(cliente => clientes.id !== id))
	}

	const updateCliente = (id, updatedCliente) => {
		setEditing(false)

		setUsers(clientes.map(cliente => (cliente.id === id ? updatedCliente : user)))
	}

	const editRow = cliente => {
		setEditing(true)

		setCurrentCliente({ nome: cliente.nome, email: cliente.email, senha: cliente.senha })
	}
	return (
		<div>
			<h3><font size="12"><font color="black">Perfect Trainer(USER) </font></font></h3>
			<h1><font size="6"><font color="black">Encontre o seu personal aqui! </font></font></h1>
			<div>
				<div>
					{editing ? (
						<>
							<h2>Edit cliente</h2>
							<EditClienteForm
								editing={editing}
								setEditing={setEditing}
								currentCliente={currentCliente}
								updateCliente={updateCliente}
							/>
						</>
					) : (
						<>
							<h2>Cadastrar Usuário</h2>
							<AddClienteForm addCliente={addCliente1} />
						</>
					)}
				</div>
				<div>
					<h2>Usuários Cadastrados</h2>
					<ClienteTable clientes={clientes} editRow={editRow} deleteCliente={deleteCliente} />
				</div>
			</div>
		</div>
	)
}

export default CadastroClientes
