import axios from 'axios'
import React, { useState, useEffect } from 'react'
import AddTreinosCasaForm from '../components/Forms/AddTreinoCasaForms'
import EditTreinosCasaForm from '../components/Forms/EditTreinosCasaForms'
import TreinosCasaTables from '../components/Tables/TreinosCasaTables'
import { addTreinosCasa } from '../services/addTreinosCasa'

const API_ENDPOINT = 'http://localhost:8090'

const CadastroTreinosCasa = () => {
	const [treinosCasaList, setTreinosCasaList] = useState([])
	// useEffect(() => {
	// 	axios.get(`${API_ENDPOINT}/treinosCasa`)
	// 		.then((response) => console.log(response))
	// 	console.log(treinosCasaList)
	// }, [])

	// Data
	const treinosCasasData = [

	]

	const initialFormState = { personal: '', usuario: '', data: '', endereco: '', tipo: '' }

	// Setting state
	const [treinosCasas, setTreinosCasas] = useState(treinosCasaList)
	const [currentTreinosCasa, setCurrentTreinosCasa] = useState(initialFormState)
	const [editing, setEditing] = useState(false)

	// CRUD operations
	const addTreinosCasa1 = treinosCasa => {
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
		console.log(treinosCasa)
		addUser(treinosCasa)
	}

	const deleteTreinosCasa = id => {
		setEditing(false)

		setTreinosCasas(treinosCasas.filter(treinosCasa => treinosCasa.id !== id))
	}

	const updateTreinosCasa = (id, updatedTreinosCasa) => {
		setEditing(false)

		setTreinosCasas(treinosCasas.map(treinosCasa => (treinosCasa.id === id ? updatedTreinosCasa : treinosCasa)))
	}

	const editRow = treinosCasa => {
		setEditing(true)

		setCurrentTreinosCasa({ personal: treinosCasa.personal, usuario: treinosCasa.usuario, data: treinosCasa.data, endereco: treinosCasa.endereco, tipo: treinosCasa.tipo })
	}
	return (
		<div>
			<h3><font size="12"><font color="black">Perfect Trainer </font></font></h3>
			<h1><font size="6"><font color="black">Encontre o seu personal aqui! </font></font></h1>
			<div>
				<div>
					{editing ? (
						<>
							<h2>Edit Treino Casa</h2>
							<EditTreinosCasaForm
								editing={editing}
								setEditing={setEditing}
								currentTreinosCasa={currentTreinosCasa}
								updateTreinosCasa={updateTreinosCasa}
							/>
						</>
					) : (
						<>
							<h2>Cadastrar Treino Casa</h2>
							<AddTreinosCasaForm addTreinosCasa={addTreinosCasa1} />
						</>
					)}
				</div>
				<div>
					<h2>Treinos Casa Cadastrados</h2>
					<TreinosCasaTables treinosCasas={treinosCasas} editRow={editRow} deleteTreinosCasa={deleteTreinosCasa} />
				</div>
			</div>
		</div>
	)
}

export default CadastroTreinosCasa
