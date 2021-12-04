import React from 'react'

const TreinosAcademiaTable = props => (
<table>
    <thead>
    <tr>
        <th>Personal</th>
        <th>Cliente</th>
        <th>Data</th>
        <th>Academia</th>
        <th>Tipo</th>
        <th>Ações</th>

    </tr>
    </thead>
    <tbody>
    {props.treinosAcademias?.length > 0 ? (
        props.treinosAcademias.map(treinosAcademia => (
        <tr key={treinosAcademia.id}>
            <td>{treinosAcademia.personal}</td>
            <td>{treinosAcademia.cliente}</td>
            <td>{treinosAcademia.data}</td>
            <td>{treinosAcademia.academia}</td>
            <td>{treinosAcademia.tipo}</td>
            <td>
            <button
                onClick={() => {
                props.editRow(treinosAcademia)
                }}
                className="button muted-button"
            >
                Edit
            </button>
            <button
                onClick={() => props.deletetreinosAcademia(treinosAcademia.id)}
                className="button muted-button"
            >
                Delete
            </button>
            </td>
        </tr>
        ))
    ) : (
        <tr>
        <td colSpan={3}>No treinosAcademia</td>
        </tr>
    )}
    </tbody>
</table>
)

export default TreinosAcademiaTable
