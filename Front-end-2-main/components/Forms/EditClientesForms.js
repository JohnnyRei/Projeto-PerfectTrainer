import React, { useState, useEffect } from 'react'

const EditClienteForm = props => {
    const [cliente, setCliente] = useState(props.currentCliente)

    // useEffect(
    //     () => {
    //         setCliente(props.currentCliente)
    //     },
    //     [props]
    // )
    // You can tell React to skip applying an effect if certain values haven’t changed between re-renders. [ props ]

    const handleInputChange = event => {
        const { name, value } = event.target

        setUser({ ...cliente, [name]: value })
    }

    return (
        <form
            onSubmit={event => {
                event.preventDefault()

                props.updateCliente(cliente.id, cliente)
            }}
        >
            <label>Nome</label>
            <input type="text" name="name" value={cliente.name} onChange={handleInputChange} />
            <label>E-mail</label>
            <input type="text" name="username" value={cliente.username} onChange={handleInputChange} />
            <label>Senha</label>
            <input type="text" name="senha" value={cliente.senha} onChange={handleInputChange} />
            <button>Atualizar Usuário</button>
            {/* <label>Nota</label>
    <input type="text" name="note" value={cliente.nota} onChange={handleInputChange} /> */}
            <button onClick={() => props.setEditing(false)} className="button muted-button">
                Cancel
            </button>
        </form>
    )
}

export default EditClienteForm
