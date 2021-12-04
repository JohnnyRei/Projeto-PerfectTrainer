import React from 'react'

const TreinosCasaTable = props => (
    <table>
        <thead>
            <tr>
                <th>Personal</th>
                <th>Cliente</th>
                <th>Data</th>
                <th>Endereco</th>
                <th>Tipo</th>
                <th>Ações</th>

            </tr>
        </thead>
        <tbody>
            {props.treinosCasas?.length > 0 ? (
                props.treinosCasas.map(treinosCasa => (
                    <tr key={treinosCasa.id}>
                        <td>{treinosCasa.personal}</td>
                        <td>{treinosCasa.cliente}</td>
                        <td>{treinosCasa.data}</td>
                        <td>{treinosCasa.endereco}</td>
                        <td>{treinosCasa.tipo}</td>
                        <td>
                            <button
                                onClick={() => {
                                    props.editRow(treinosCasa)
                                }}
                                className="button muted-button"
                            >
                                Edit
                            </button>
                            <button
                                onClick={() => props.deletetreinosCasa(treinosCasa.id)}
                                className="button muted-button"
                            >
                                Delete
                            </button>
                        </td>
                    </tr>
                ))
            ) : (
                <tr>
                    <td colSpan={3}>No treinosCasas</td>
                </tr>
            )}
        </tbody>
    </table>
)

export default TreinosCasaTable
