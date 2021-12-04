import React, { useState, useEffect } from 'react'

const EditTreinosAcademiaForm = props => {
const [treinosAcademia, setTreinosAcademia] = useState(props.currentTreinosAcademia)

useEffect(
    () => {
    setTreinosAcademia(props.currentTreinoAcademia)
    },
    [props]
)
  // You can tell React to skip applying an effect if certain values haven’t changed between re-renders. [ props ]

const handleInputChange = event => {
    const { name, value } = event.target

    setTreinosAcademia({ ...treinosAcademia, [name]: value })
}

return (
    <form
    onSubmit={event => {
        event.preventDefault()

        props.updateTreinosAcademia(treinosAcademia.id, treinosAcademia)
    }}
    >
    <label>Personal</label>
    <input type="text" name="personal" value={treinosAcademia.personal} onChange={handleInputChange} />
    <label>Usuário</label>
    <input type="text" name="usuario" value={treinosAcademia.usuario} onChange={handleInputChange} />
    <label>Data</label>
    <input type="text" name="data" value={treinosAcademia.data} onChange={handleInputChange} />
    <label>Endereço</label>
    <input type="text" name="academia" value={treinosAcademia.endereco} onChange={handleInputChange} />
    <label>Tipo</label>
    <input type="text" name="tipo" value={treinosAcademia.tipo} onChange={handleInputChange} />
    <button>Atualizar Treino Academia</button>
    <button onClick={() => props.setEditing(false)} className="button muted-button">
        Cancel
    </button>
    </form>
)
}

export default EditTreinosAcademiaForm
