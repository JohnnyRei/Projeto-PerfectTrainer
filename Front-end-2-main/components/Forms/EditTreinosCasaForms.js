import React, { useState, useEffect } from 'react'

const EditTreinosCasaForm = props => {
const [treinosCasa, setTreinosCasa] = useState(props.currentTreinosCasa)

useEffect(
    () => {
    setTreinosCasa(props.currentTreinosCasa)
    },
    [props]
)
  // You can tell React to skip applying an effect if certain values haven’t changed between re-renders. [ props ]

const handleInputChange = event => {
    const { name, value } = event.target

    setTreinosCasa({ ...treinosCasa, [name]: value })
}

return (
    <form
    onSubmit={event => {
        event.preventDefault()

        props.updateTreinosCasa(treinosCasa.id, treinosCasa)
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
    <button>Atualizar Treino Casa</button>
    <button onClick={() => props.setEditing(false)} className="button muted-button">
        Cancel
    </button>
    </form>
)
}

export default EditTreinosCasaForm
