// import axios from 'axios'
// import React, { useState, useEffect } from 'react'
// import AddUserForm from './forms/AddUserForm'
// import EditUserForm from './forms/EditUserForm'
// import UserTable from './tables/UserTable'
// import {addUser} from './services/addUser'
import axios from 'axios'
import React, { useState, useEffect } from 'react'
import { useRouter } from 'next/router'
import AddUserForm from '../components/Forms/AddUsersForms'
import EditUserForm from '../components/Forms/EditUsersForms'
import UserTable from '../components/Tables/ClientesTables'
import { addUser } from '../services/AddUsers'

const API_ENDPOINT = 'http://localhost:8090'

const CadastroUsers = () => {
	const router = useRouter()
	const [usersList, setUsersList] = useState([])
	// useEffect(() => {
	// 	axios.get(`${API_ENDPOINT}/personais`)
	// 		.then((response) => console.log(response))
	// 	console.log(usersList)
	// }, [])

	// Data
	const usersData = [

	]

	const initialFormState = { nome: '', email: '', senha: '' }

	// Setting state
	const [users, setUsers] = useState(usersData)
	const [currentUser, setCurrentUser] = useState(initialFormState)
	const [editing, setEditing] = useState(false)

	// CRUD operations
	const addUser1 = user => {
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

		console.log(user)
		// addUser(user)
		router.push('/personal')
	}

	const deleteUser = id => {
		setEditing(false)

		setUsers(users.filter(user => user.id !== id))
	}

	const updateUser = (id, updatedUser) => {
		setEditing(false)

		setUsers(users.map(user => (user.id === id ? updatedUser : user)))
	}

	const editRow = user => {
		setEditing(true)

		setCurrentUser({ nome: user.nome, email: user.email, senha: user.senha })
	}
	return (
		<div>
			<h3><font size="12"><font color="black">Perfect Trainer(PERSONAL) </font></font></h3>
			<h1><font size="6"><font color="black">Encontre o seu personal aqui! </font></font></h1>
			<div>
				<div>
					{editing ? (
						<>
							<h2>Edit user</h2>
							<EditUserForm
								editing={editing}
								setEditing={setEditing}
								currentUser={currentUser}
								updateUser={updateUser}
							/>
						</>
					) : (
						<>
							<h2>Cadastrar Personal</h2>
							<AddUserForm addUser={addUser1} />
						</>
					)}
				</div>
				<div>
					<h2>Usuários Cadastrados</h2>
					<UserTable users={users} editRow={editRow} deleteUser={deleteUser} />
				</div>
			</div>
		</div>
	)
}


export default CadastroUsers
