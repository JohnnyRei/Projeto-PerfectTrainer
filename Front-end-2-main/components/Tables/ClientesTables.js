import React from 'react'

const ClienteTable = props => (
<table>
    <thead>
    <tr>
        <th>Nome</th>
        <th>E-mail</th>
        <th>Senha</th>
        <th>Nota</th>
        <th>Ações</th>

    </tr>
    </thead>
    <tbody>
    {props.users?.length > 0 ? (
        props.users.map(user => (
        <tr key={user.id}>
            <td>{user.name}</td>
            <td>{user.username}</td>
            <td>{user.senha}</td>
            <td>
            <button
                onClick={() => {
                props.editRow(user)
                }}
                className="button muted-button"
            >
                Edit
            </button>
            <button
                onClick={() => props.deleteUser(user.id)}
                className="button muted-button"
            >
                Delete
            </button>
            </td>
        </tr>
        ))
    ) : (
        <tr>
        <td colSpan={3}>No users</td>
        </tr>
    )}
    </tbody>
</table>
)

export default ClienteTable
