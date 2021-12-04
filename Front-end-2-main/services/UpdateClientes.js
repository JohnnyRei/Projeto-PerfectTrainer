const updateCLiente = cliente => {
    cliente.id = clientes.length + 1
    // setUsers([...users, user])
    const response = await fetch(`${API_ENDPOINT}/usuarios/${cliente.id}`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(cliente)
    })
    return await response.json();
}