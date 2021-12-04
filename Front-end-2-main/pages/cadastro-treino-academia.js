import axios from 'axios'
import React, { useState, useEffect } from 'react'
import AddTreinosAcademiaForm from '../components/Forms/AddTreinosAcademia'
import EditTreinosAcademiaForm from '../components/Forms/EditTreinosAcademiaForms'
import TreinosAcademiaTables from '../components/Tables/TreinosAcademiaTables'
import { addTreinosAcademia } from '../services/addTreinosAcademia'

const API_ENDPOINT = 'http://localhost:8090'

const CadastroTreinosAcademia = () => {
	const [treinosAcademiaList, setTreinosAcademiaList] = useState([])
	// useEffect(() => {
	// 	axios.get(`${API_ENDPOINT}/treinosAcademia`)
	// 		.then((response) => console.log(response))
	// 	console.log(treinosAcademiaList)
	// }, [])

	// Data
	const treinosAcademiasData = [

	]

	const initialFormState = { personal: '', usuario: '', data: '', academia: '', tipo: '' }

	// Setting state
	const [treinosAcademias, setTreinosAcademias] = useState(treinosAcademiasData)
	const [currentTreinosAcademia, setCurrentTreinosAcademia] = useState(initialFormState)
	const [editing, setEditing] = useState(false)

	// CRUD operations
	const addTreinosAcademia1 = treinosAcademia => {
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
		console.log(treinosAcademia)
		addUser(treinosAcademia)
	}

	const deleteTreinosAcademia = id => {
		setEditing(false)

		setTreinosAcademias(treinosAcademias.filter(treinosAcademia => treinosAcademia.id !== id))
	}

	const updateTreinosAcademia = (id, updatedTreinosAcademia) => {
		setEditing(false)

		setTreinosAcademias(treinosAcademias.map(treinosAcademia => (treinosAcademia.id === id ? updatedTreinosAcademia : treinosAcademia)))
	}

	const editRow = treinosAcademia => {
		setEditing(true)

		setCurrentTreinosAcademia({ personal: treinosAcademia.personal, usuario: treinosAcademia.usuario, data: treinosAcademia.data, academia: treinosAcademia.academia, tipo: treinosAcademia.tipo })
	}
	return (
		<div>
			<h3><font size="12"><font color="black">Perfect Trainer </font></font></h3>
			<h1><font size="6"><font color="black">Encontre o seu personal aqui! </font></font></h1>
			<div>
				<div>
					{editing ? (
						<>
							<h2>Edit Treino Academia</h2>
							<EditTreinosAcademiaForm
								editing={editing}
								setEditing={setEditing}
								currentTreinosAcademia={currentTreinosAcademia}
								updateTreinosAcademia={updateTreinosAcademia}
							/>
						</>
					) : (
						<>
							<h2>Cadastrar Treino Academia</h2>
							<AddTreinosAcademiaForm addTreinosAcademia={addTreinosAcademia1} />
						</>
					)}
				</div>
				<div>
					<h2>Treinos Academia Cadastrados</h2>
					<TreinosAcademiaTables treinosAcademias={treinosAcademias} editRow={editRow} deleteTreinosAcademia={deleteTreinosAcademia} />
				</div>
			</div>
		</div>
	)
}


export default CadastroTreinosAcademia
