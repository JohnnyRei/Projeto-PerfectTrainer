const deleteTreinosCasa = treinosCasa => {
    cliente.id = clientes.length + 1
    // setUsers([...users, user])
    const response = await fetch(`${API_ENDPOINT}/treinosCasa/${cliente.id}`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(treinosCasa)
    })
    return await response.json();
}